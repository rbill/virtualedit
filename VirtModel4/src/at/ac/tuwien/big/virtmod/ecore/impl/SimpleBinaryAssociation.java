package at.ac.tuwien.big.virtmod.ecore.impl;

import at.ac.tuwien.big.virtmod.basic.VEditableInvertibleFunc;
import at.ac.tuwien.big.virtmod.ecore.Association;
import at.ac.tuwien.big.virtmod.ecore.VListFeature;

public class SimpleBinaryAssociation<A,B> implements Association<A,B> {
	
	private VEditableInvertibleFunc<A, B> baseAssoc;
	private VEditableInvertibleFunc<B, A> baseAssocInv;
	
	public SimpleBinaryAssociation(VEditableInvertibleFunc<A, B> base) {
		this.baseAssoc = base; 
		this.baseAssocInv = baseAssoc.inverse();
		left = new AssociationFeature<A,B>(baseAssoc);
		right = new AssociationFeature<B,A>(baseAssocInv);
	}
	
		
	private AssociationFeature<A,B> left;
	private AssociationFeature<B,A> right;
	
	
	

	@Override
	public VListFeature<A,B> getLeft() {
		return left;
	}

	@Override
	public VListFeature<B,A> getRight() {
		return right;
	}

}
