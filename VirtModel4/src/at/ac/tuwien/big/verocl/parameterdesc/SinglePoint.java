package at.ac.tuwien.big.verocl.parameterdesc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.ocl.pivot.Signal;

import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.virtmod.multiref.ModelRef;

/**Reference to a single point*/
public interface SinglePoint  extends Points {
	
	public Object[] getValues();
	
	public Collection<? extends SinglePoint> getNext();

	public default MultiPoint asMultiPoint() {
		return new MultiPoint() { 

			@Override
			public PointDesc getDesc() {
				return SinglePoint.this.getDesc();
			}

			@Override
			public boolean contains(Object[] pointValues) {
				return Arrays.equals(SinglePoint.this.getValues(),pointValues);
			}

			@Override
			public Collection<? extends SinglePoint> getNext() {
				return SinglePoint.this.getNext();
			}
			
			@Override
			public boolean equals(Object other) {
				return SinglePoint.this.equals(other);
			}
			
			@Override
			public int hashCode() {
				return SinglePoint.this.hashCode();
			}
			
		};
	}


}
