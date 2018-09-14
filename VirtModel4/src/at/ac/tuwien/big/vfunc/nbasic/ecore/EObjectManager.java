package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import VObjectModel.AnyValue;
import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.IdentifierCmp;
import VObjectModel.IdentifierRef;
import VObjectModel.IdentifierRefOrCmp;
import VObjectModel.JavaValue;
import at.ac.tuwien.big.vfunc.nbasic.ecore.BasicCache.CacheType;

public class EObjectManager {
	
	//Creator --> Identifier --> EObject
	
	//Namespace --> name --> thing
	private Map<String, Map<String, EObjectCreator>> eobjectCreators = new HashMap<>();
	//private Map<EObjectCreator, Map<Object[], VMEObject>> createdObjects = new HashMap<>();
	
	/*
	public VMEObject getOrCreate(EObjectCreator creator, Object... params) {
		return createdObjects.computeIfAbsent(creator, x->new HashMap<>()).computeIfAbsent(params, cr->creator.createEObject(params));
	}
	
	public VMEObject getOrCreate(String creatorName, Object... params) {
		EObjectCreator creator = eobjectCreators.get(creatorName);
		if (creator == null) {
			throw new UnsupportedOperationException("Could not find creator " + creator);
		}
		return getOrCreate(creator, params);
	}*/
	
	public void addCreator(String namespace, String name, EObjectCreator creator) {
		eobjectCreators.computeIfAbsent(namespace, x->new HashMap<>()).put(name, creator);
	}
	
	private BasicCache<Identifier, VMEObject> createdObjects = new BasicCache<>(Identifier.class,
			CacheType.FIX,
			new Function<Identifier, VMEObject>() {

				@Override
				public VMEObject apply(Identifier t) {
					CreatorId creatorid = t.getCreatorid();
					//Get creator
					EObjectCreator creator = eobjectCreators.computeIfAbsent(creatorid.getNamespace(), x->new HashMap<>()).get(creatorid.getName());
					if (creator == null) {
						System.err.println("Creator "+creatorid.getNamespace()+"::"+creatorid.getName()+" not found!");
						return null;
					}
					//First create all sub-things
					Object[] subVals = new Object[t.getIdentifierreforcmp().size()];
					{
						int idx = 0;
						for (AnyValue val: t.getIdentifierreforcmp()) {
							subVals[idx] = convert(val);
							++idx;
						}
					}
					VMEObject ret = creator.createEObject(subVals);
					return ret;
				}
			}
			);
	
	public Object convert(AnyValue val) {
		if (val == null) {
			return null;
		}
		if (val instanceof IdentifierRefOrCmp) {
			Identifier id = null;
			if (val instanceof IdentifierRef) {
				id = ((IdentifierRef)val).getS_identifier();
			} else if (val instanceof IdentifierCmp) {
				id = ((IdentifierCmp)val).getS_identifier();
			}
			if (id != null) {
				return getObject(id);
			}
		} else if (val instanceof JavaValue) {
			return ((JavaValue)val).getValue();
		}
		throw new UnsupportedOperationException("Cannot convert "+val+"!");
	}
	
	public VMEObject getObject(Identifier id) {
		return createdObjects.get(id);
	}

}
