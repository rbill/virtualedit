package at.ac.tuwien.big.school.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.common.ui.contentassist.TerminalsProposalProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import at.ac.tuwien.big.xmlintelledit.intelledit.change.Change;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.ChangeType;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.ParameterType;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.Undoer;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.basic.AbstractFixedFeatureChangeType;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.basic.BasicAddConstantChange;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.basic.BasicSetConstantChange;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.basic.FixedAddConstantChangeType;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.basic.FixedReplaceConstantChangeType;
import at.ac.tuwien.big.xmlintelledit.intelledit.change.basic.FixedSetConstantChangeType;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.Evaluable;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.EvaluationState;
import at.ac.tuwien.big.xmlintelledit.intelledit.oclvisit.EvalResult;
import at.ac.tuwien.big.xmlintelledit.intelledit.search.local.impl.Evaluation;
import at.ac.tuwien.big.xmlintelledit.intelledit.search.local.impl.ViolatedConstraintsEvaluator;
import at.ac.tuwien.big.xmlintelledit.intelledit.transfer.EcoreMapTransferFunction;
import at.ac.tuwien.big.xmlintelledit.intelledit.transfer.EcoreTransferFunction;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class VProposalProvider extends TerminalsProposalProvider {
	
	public static final int MAX_ASSIGNMENTS = 20;
	
	public static final int MAX_VALUE_FULLTRIES = 100;
	public static final int MAX_VALUE_TRIES = 200;
	
	
	@Override
	public void completeAssignment(Assignment assignment, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		createCompletionProposal()
		acceptor.accept(new ICompletionProposal() {
			
			@Override
			public Point getSelection(IDocument document) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Image getImage() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getDisplayString() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public IContextInformation getContextInformation() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAdditionalProposalInfo() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void apply(IDocument document) {
				// TODO Auto-generated method stub
				
			}
		});
		super.completeAssignment(assignment, contentAssistContext, acceptor);
	}
	
	
	//lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor);
	
}