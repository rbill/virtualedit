package at.ac.tuwien.big.vmod.registry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.Assignment;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.AssignmentImpl;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl.MultiTransformationExecutor;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl.TransformationExecutor;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;


public class HenshinGenerator implements TransformatorGeneratorGenerator {
	
	private static class HenshinTransformationExecutor implements TransformationExecutor {
		
		private Module module;
		
		private HenshinTransformationExecutor(Module module) {
			this.module = module;
		}

		@Override
		public void executeOn(VModelView view) {
			Engine engine = new EngineImpl();
			HenshinResourceSet test = new HenshinResourceSet();
			Resource res = test.createResource("testResource.xmi");
			SimpleModelCorrespondance corr = view.saveResource(res);
			
			EGraph graph = new EGraphImpl(res.getContents());
			SimpleModelCorrespondance subcorr = new SimpleModelCorrespondance();
			Map<Symbol,InstanceCreator> existingCreators = new HashMap<Symbol, InstanceCreator>();
			//Don't know how to create a factory, just synchronize ...
			for (Match match: InterpreterUtil.findAllMatches(engine, module, graph)) {
				Assignment assignment = new AssignmentImpl(match.getUnit());
				SymbolImpl prefix = (SymbolImpl)Symbol.from("prefix");
				prefix.addObject(match.getUnit().getName());
				for (Parameter par: match.getUnit().getParameters()) {
					Object pv = match.getParameterValue(par);
					assignment.setParameterValue(par, pv);
					if (pv instanceof EObject) {
						EObject other = corr.getRightObject((EObject)pv);
						if (other instanceof VMEObject) {
							VMEObject vme = (VMEObject)other;
							prefix.addObject(vme.getUUID());
						} 
					} else if (pv instanceof Integer || pv instanceof String) {
						prefix.addObject(pv);
					} else {
						prefix.addObject(String.valueOf(pv));
					}
				}
				UnitApplication application = new UnitApplicationImpl(engine, graph, match.getUnit(),
						assignment);
				try {
					
					application.execute(null);
					
					InstanceCreator gtc = existingCreators.get(prefix);
					if (gtc == null) {
						existingCreators.put(prefix, gtc = view.getTransformationCreater(prefix,corr,subcorr));
					}
					List<EObject> roots = graph.getRoots();
					SimpleModelEqualizer eq = new SimpleModelEqualizer(roots,							
							view.exposeContents(), corr.inverse(), subcorr, gtc);
					eq.equalize();
				} catch (Exception e) {
					System.err.println("Could not execute rule: " + e.getMessage());
				}
			}
			
			//Synchronize back ...
			
		}
		
	}
	
	@Override
	public TransformationExecutor getExecutor(Resource res) {
		Module module = null;
		for (EObject eobj: res.getContents()) {
			if (eobj instanceof Module) {
				module = (Module)eobj;
			}
		}
		MultiTransformationExecutor ret = new MultiTransformationExecutor();
		ret.addExecutor(new HenshinTransformationExecutor(module));
		return ret;
	}

}
