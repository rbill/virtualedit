package at.ac.tuwien.big.vfunc.nbasic.constraint;

import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;

//Xtend wäre besser, aber irgendwie geht das nicht ...
public class ObjectCreatorGenerator {
	
	public String generate(ObjectCreator creator) {
		StringBuilder ret = new StringBuilder();
		appendLines(ret,
				"package at.ac.tuwien.big.vfunc.nbasic.constraint;","",
				"import org.eclipse.emf.ecore.EClass;",
				"import org.eclipse.emf.ecore.EReference;",
				"import org.eclipse.emf.ecore.EcoreFactory;",
				"import Citizen.Burger;",
				"import Citizen.CitizenPackage;",
				"import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;","",
				"public class "+creator.getName()
				);
		return ret.toString();
	}
	
	public void appendLines(StringBuilder builder, String... lines) {
		for (String line: lines) {
			builder.append(line);
			builder.append("\n");
		}
	}

}
