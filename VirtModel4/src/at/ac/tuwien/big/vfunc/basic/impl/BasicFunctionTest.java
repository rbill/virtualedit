package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.Arrays;
import java.util.List;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.ConstraintViolation;
import at.ac.tuwien.big.vfunc.basic.Editor;
import at.ac.tuwien.big.vfunc.basic.Scope;

public class BasicFunctionTest {
	
	public static void main(String[] args) {
		Editor editor = new Editor(){};
		
		BasicFunction<Integer,Integer> plusTwo = new BasicFunction<Integer, Integer>(false, new BasicFunctionType<>(Integer.class,Integer.class));
		Scope<Integer> plusTwoScope = new SetScope<Integer>(Arrays.asList(2,3,4));
		BasicExpression<Integer, Integer> plusTwoExpr = new BasicExpression<Integer, Integer>((x)->x+2);
		Assignment<Integer, Integer> plusTwoAss = new BasicAssignment<Integer, Integer>(plusTwo, plusTwoScope, plusTwoExpr, editor, AssignmentType.HARD);
		plusTwo.addAssignment(plusTwoAss, AssignmentType.HARD);
		
		BasicFunction<Integer, Target>
		
		BasicFunction<Integer, Integer> bf = new BasicFunction<Integer, Integer>(false, new BasicFunctionType<>(Integer.class,Integer.class));
		
		Scope<Integer> scope = new SetScope<Integer>(Arrays.asList(1,2,3));
		BasicExpression<Integer, Integer> basicExpr = new BasicExpression<Integer, Integer>((x)->x*2);
		Assignment<Integer, Integer> ass = new BasicAssignment<Integer, Integer>(bf, scope, basicExpr, editor, AssignmentType.HARD);
		bf.addAssignment(ass, AssignmentType.HARD);
		
		
		
		bf.addBasicConstraint((x)->Math.min(4,2*x), editor);
		List<ConstraintViolation<Integer, Integer>> constraintViolations = bf.getConstraintViolations();
		for (ConstraintViolation<Integer, Integer> cv: constraintViolations) {
			System.out.println("ConstraintViolation: "+cv);
		}
		int[] values = new int[]{1,2,3,4};
		for (int val: values) {
			Integer result = bf.evaluateReduced(val);
			System.out.println("f("+val+") = " +result);
		}
	}

}
