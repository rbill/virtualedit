package interparse.interparse;

import uk.ac.york.cs.ecss.learn.learnable.manager.MultiSlotValueMap;
import uk.ac.york.cs.ecss.learn.learnable.manager.SlotValueMap;
import uk.ac.york.cs.ecss.learn.learnable.manager.ValueDescManager;
import uk.ac.york.cs.ecss.learn.learnformat.MyInputDesc;

public class SvmState {
	private SlotValueMap svm;
	private String prefix;

	public void augmentVDM(ValueDescManager vdm) {
		MultiSlotValueMap msvm = new MultiSlotValueMap("");
		msvm.addSlotValueMap(svm); 
		msvm.augmentValuesDescTemp(vdm);
	}

	public MyInputDesc getInput(ValueDescManager man) {
		return man.getArrayPair(svm);
	}

	public SvmState(SlotValueMap svm, String prefix) {
		this.svm = svm;
		this.prefix = prefix;
	}

	public SvmState(SlotValueMap svm) {
		this(svm, "");
	}

	public SvmState() {
		this(new SlotValueMap(), "");
	}

	public void set(String slot, double value) {
		svm.set("", prefix + "/" + slot, "", 1.0);
	}

	public void set(String slot, boolean value) {
		svm.set("", prefix + "/" + slot, "", value ? 1.0 : 0.0);
	}

	public void add(String slot, double value) {
		svm.add("", prefix + "/" + slot, "", 1.0);
	}

	public SvmState push(String subthing) {
		return new SvmState(svm, prefix + subthing + "/");
	}

	public void add(String slot, String cardType) {
		svm.add("", slot, cardType, 1.0);
	}

}