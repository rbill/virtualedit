package at.ac.tuwien.big.helper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface VProp {
	
	boolean includeBefore() default false;
	
	boolean includeChange() default true;
	
	boolean includeOpId() default false;
}
