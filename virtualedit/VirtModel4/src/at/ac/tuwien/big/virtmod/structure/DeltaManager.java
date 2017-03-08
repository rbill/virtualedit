package at.ac.tuwien.big.virtmod.structure;

public interface DeltaManager {


	/*private*/ static VObject getObject(VContainer cont) {
		return cont==null?null:cont.object();
	}
	
	public VObject createObject(VContainer delta, VContainer edit, VContainer base, VObject editObject, VObject baseObject);
	
	public default VObject createObject(VContainer delta, VContainer edit, VContainer base) {
		return createObject(delta, edit, base, getObject(edit), getObject(base));
	}

}
