/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.school.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.builder.builderState.IssuesProvider;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;

import at.ac.tuwien.big.school.editor.VMXtextEditor;
import at.ac.tuwien.big.school.validation.SchoolTextValidator;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;
/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
//extends at.ac.tuwien.big.xmlintelledit.intelledit.xtext.DynamicQuickfixProvider
//extends DefaultQuickfixProvider 
public class SchoolTextQuickfixProvider extends at.ac.tuwien.big.xmlintelledit.intelledit.xtext.DynamicQuickfixProvider {


	@Fix(SchoolTextValidator.CHANGE_ORIGIN)
	public void changeVirtual(Issue issue, IssueResolutionAcceptor acceptor) {
		issue.getCode();
		String[] data = issue.getData();
		acceptor.accept(issue, issue.getMessage(), "", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				VMEObject eobj = SchoolTextValidator.getEObject(data[0], data[1]);
				VMXtextEditor editor = VMXtextEditor.INSTANCE;
				VMEObject alternative = editor.getEObject(element);
				if (eobj != null && alternative != null) {
					System.out.println("Replace "+alternative+" by "+eobj);
					editor.replace(alternative,eobj);
				}
			}
			
		});
	}
	@Fix(SchoolTextValidator.RESET_PARTIAL)
	public void resetPartialVirtual(Issue issue, IssueResolutionAcceptor acceptor) {
		issue.getCode();
		String[] data = issue.getData();
		acceptor.accept(issue, issue.getMessage(), "", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				VMXtextEditor editor = VMXtextEditor.INSTANCE;
				VMEObject eobj = editor.getEObject(element);
				if (eobj != null) {
					editor.refreshVirtual();
					editor.partialReset(eobj);
					editor.refreshText();
				}
			}
			
		});
	}
	@Fix(SchoolTextValidator.RESET)
	public void resetVirtual(Issue issue, IssueResolutionAcceptor acceptor) {
		issue.getCode();
		String[] data = issue.getData();
		acceptor.accept(issue, issue.getMessage(), "", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				VMXtextEditor editor = VMXtextEditor.INSTANCE;
				VMEObject eobj = editor.getEObject(element);
				if (eobj != null) {
					editor.refreshVirtual();
					eobj.resetCustom();
					editor.refreshText();
				}
			}
			
		});
	}
	
	
}