/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.serializer;

import at.ac.tuwien.big.virtmodel.services.VLangGrammarAccess;
import at.ac.tuwien.big.virtmodel.vLang.BasicAction;
import at.ac.tuwien.big.virtmodel.vLang.Block;
import at.ac.tuwien.big.virtmodel.vLang.DeleteAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FixedValue;
import at.ac.tuwien.big.virtmodel.vLang.ForLoopStatement;
import at.ac.tuwien.big.virtmodel.vLang.ForStatement;
import at.ac.tuwien.big.virtmodel.vLang.FullFunctionAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FunctionCall;
import at.ac.tuwien.big.virtmodel.vLang.FunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.FunctionDomainScope;
import at.ac.tuwien.big.virtmodel.vLang.FunctionParDef;
import at.ac.tuwien.big.virtmodel.vLang.IfStatement;
import at.ac.tuwien.big.virtmodel.vLang.IfThenElse;
import at.ac.tuwien.big.virtmodel.vLang.Import;
import at.ac.tuwien.big.virtmodel.vLang.InfiniteScope;
import at.ac.tuwien.big.virtmodel.vLang.JavaFunctionCall;
import at.ac.tuwien.big.virtmodel.vLang.JavaFunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.LetStatement;
import at.ac.tuwien.big.virtmodel.vLang.ObjId;
import at.ac.tuwien.big.virtmodel.vLang.ObjParam;
import at.ac.tuwien.big.virtmodel.vLang.OclFunction;
import at.ac.tuwien.big.virtmodel.vLang.ParDef;
import at.ac.tuwien.big.virtmodel.vLang.ReturnStatement;
import at.ac.tuwien.big.virtmodel.vLang.RuleAssignment;
import at.ac.tuwien.big.virtmodel.vLang.SetDef;
import at.ac.tuwien.big.virtmodel.vLang.SetLiteral;
import at.ac.tuwien.big.virtmodel.vLang.SetScope;
import at.ac.tuwien.big.virtmodel.vLang.SingleScope;
import at.ac.tuwien.big.virtmodel.vLang.VLang;
import at.ac.tuwien.big.virtmodel.vLang.VLangPackage;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class VLangSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private VLangGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == VLangPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case VLangPackage.BASIC_ACTION:
				sequence_BasicAction_FunctionPars(context, (BasicAction) semanticObject); 
				return; 
			case VLangPackage.BLOCK:
				sequence_Block(context, (Block) semanticObject); 
				return; 
			case VLangPackage.DELETE_ASSIGNMENT:
				sequence_DeleteAssignment(context, (DeleteAssignment) semanticObject); 
				return; 
			case VLangPackage.FIXED_VALUE:
				sequence_FixedValue(context, (FixedValue) semanticObject); 
				return; 
			case VLangPackage.FOR_LOOP_STATEMENT:
				sequence_ForLoopStatement(context, (ForLoopStatement) semanticObject); 
				return; 
			case VLangPackage.FOR_STATEMENT:
				sequence_ForStatement(context, (ForStatement) semanticObject); 
				return; 
			case VLangPackage.FULL_FUNCTION_ASSIGNMENT:
				sequence_FullFunctionAssignment(context, (FullFunctionAssignment) semanticObject); 
				return; 
			case VLangPackage.FUNCTION_CALL:
				sequence_FunctionCall_FunctionPars(context, (FunctionCall) semanticObject); 
				return; 
			case VLangPackage.FUNCTION_DEF:
				sequence_FunctionDef(context, (FunctionDef) semanticObject); 
				return; 
			case VLangPackage.FUNCTION_DOMAIN_SCOPE:
				if (rule == grammarAccess.getFunctionDomainScopeRule()) {
					sequence_FunctionDomainScope(context, (FunctionDomainScope) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFunctionScopeRule()) {
					sequence_FunctionDomainScope_FunctionScope(context, (FunctionDomainScope) semanticObject); 
					return; 
				}
				else break;
			case VLangPackage.FUNCTION_PAR_DEF:
				sequence_FunctionParDef(context, (FunctionParDef) semanticObject); 
				return; 
			case VLangPackage.IF_STATEMENT:
				sequence_IfStatement(context, (IfStatement) semanticObject); 
				return; 
			case VLangPackage.IF_THEN_ELSE:
				sequence_IfThenElse(context, (IfThenElse) semanticObject); 
				return; 
			case VLangPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case VLangPackage.INFINITE_SCOPE:
				if (rule == grammarAccess.getFunctionScopeRule()) {
					sequence_FunctionScope_InfiniteScope(context, (InfiniteScope) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getInfiniteScopeRule()) {
					sequence_InfiniteScope(context, (InfiniteScope) semanticObject); 
					return; 
				}
				else break;
			case VLangPackage.JAVA_FUNCTION_CALL:
				sequence_FunctionPars_JavaFunctionCall(context, (JavaFunctionCall) semanticObject); 
				return; 
			case VLangPackage.JAVA_FUNCTION_DEF:
				sequence_JavaFunctionDef(context, (JavaFunctionDef) semanticObject); 
				return; 
			case VLangPackage.LET_STATEMENT:
				sequence_LetStatement_MaybeValue(context, (LetStatement) semanticObject); 
				return; 
			case VLangPackage.OBJ_ID:
				sequence_ObjId(context, (ObjId) semanticObject); 
				return; 
			case VLangPackage.OBJ_PARAM:
				sequence_ObjParam(context, (ObjParam) semanticObject); 
				return; 
			case VLangPackage.OCL_FUNCTION:
				sequence_OclFunction(context, (OclFunction) semanticObject); 
				return; 
			case VLangPackage.PAR_DEF:
				sequence_ParDef(context, (ParDef) semanticObject); 
				return; 
			case VLangPackage.RETURN_STATEMENT:
				sequence_MaybeValue(context, (ReturnStatement) semanticObject); 
				return; 
			case VLangPackage.RULE_ASSIGNMENT:
				sequence_RuleAssignment(context, (RuleAssignment) semanticObject); 
				return; 
			case VLangPackage.SET_DEF:
				sequence_SetDef(context, (SetDef) semanticObject); 
				return; 
			case VLangPackage.SET_LITERAL:
				sequence_SetLiteral(context, (SetLiteral) semanticObject); 
				return; 
			case VLangPackage.SET_SCOPE:
				if (rule == grammarAccess.getFunctionScopeRule()) {
					sequence_FunctionScope_SetScope(context, (SetScope) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSetScopeRule()) {
					sequence_SetScope(context, (SetScope) semanticObject); 
					return; 
				}
				else break;
			case VLangPackage.SINGLE_SCOPE:
				if (rule == grammarAccess.getFunctionScopeRule()) {
					sequence_FunctionScope_SingleScope(context, (SingleScope) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSingleScopeRule()) {
					sequence_SingleScope(context, (SingleScope) semanticObject); 
					return; 
				}
				else break;
			case VLangPackage.VLANG:
				sequence_VLang(context, (VLang) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AssignStatement returns BasicAction
	 *     BasicAction returns BasicAction
	 *
	 * Constraint:
	 *     (thing=[SetOrFunctionDef|ID] calledFunc=ID (params+=FunctionPar params+=FunctionPar*)?)
	 */
	protected void sequence_BasicAction_FunctionPars(ISerializationContext context, BasicAction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Block
	 *     FullFunction returns Block
	 *     Block returns Block
	 *     SingleStatement returns Block
	 *
	 * Constraint:
	 *     (statements+=SingleStatement | statements+=Block)*
	 */
	protected void sequence_Block(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AssignStatement returns DeleteAssignment
	 *     DeleteAssignment returns DeleteAssignment
	 *
	 * Constraint:
	 *     (function=[FunctionDef|ID] scope=FunctionScope)
	 */
	protected void sequence_DeleteAssignment(ISerializationContext context, DeleteAssignment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.DELETE_ASSIGNMENT__FUNCTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.DELETE_ASSIGNMENT__FUNCTION));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.DELETE_ASSIGNMENT__SCOPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.DELETE_ASSIGNMENT__SCOPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDeleteAssignmentAccess().getFunctionFunctionDefIDTerminalRuleCall_1_0_1(), semanticObject.eGet(VLangPackage.Literals.DELETE_ASSIGNMENT__FUNCTION, false));
		feeder.accept(grammarAccess.getDeleteAssignmentAccess().getScopeFunctionScopeParserRuleCall_3_0(), semanticObject.getScope());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Filter returns FixedValue
	 *     SingleValue returns FixedValue
	 *     FixedValue returns FixedValue
	 *     FunctionAssignment returns FixedValue
	 *     BasicExpression returns FixedValue
	 *     Expression returns FixedValue
	 *     FunctionPar returns FixedValue
	 *
	 * Constraint:
	 *     (number=INT | string=STRING | objid=ObjId)
	 */
	protected void sequence_FixedValue(ISerializationContext context, FixedValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SingleStatement returns ForLoopStatement
	 *     ForLoopStatement returns ForLoopStatement
	 *
	 * Constraint:
	 *     (name=ID value=FunctionAssignment loopExpr=SingleStatement)
	 */
	protected void sequence_ForLoopStatement(ISerializationContext context, ForLoopStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FOR_LOOP_STATEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FOR_LOOP_STATEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FOR_LOOP_STATEMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FOR_LOOP_STATEMENT__VALUE));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FOR_LOOP_STATEMENT__LOOP_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FOR_LOOP_STATEMENT__LOOP_EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getForLoopStatementAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getForLoopStatementAccess().getValueFunctionAssignmentParserRuleCall_4_0(), semanticObject.getValue());
		feeder.accept(grammarAccess.getForLoopStatementAccess().getLoopExprSingleStatementParserRuleCall_6_0(), semanticObject.getLoopExpr());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SingleStatement returns ForStatement
	 *     ForStatement returns ForStatement
	 *
	 * Constraint:
	 *     (initVar=SingleStatement condition=FunctionAssignment endProcessing=SingleStatement loopExpr=SingleStatement)
	 */
	protected void sequence_ForStatement(ISerializationContext context, ForStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FOR_STATEMENT__INIT_VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FOR_STATEMENT__INIT_VAR));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FOR_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FOR_STATEMENT__CONDITION));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FOR_STATEMENT__END_PROCESSING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FOR_STATEMENT__END_PROCESSING));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FOR_STATEMENT__LOOP_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FOR_STATEMENT__LOOP_EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getForStatementAccess().getInitVarSingleStatementParserRuleCall_2_0(), semanticObject.getInitVar());
		feeder.accept(grammarAccess.getForStatementAccess().getConditionFunctionAssignmentParserRuleCall_4_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getForStatementAccess().getEndProcessingSingleStatementParserRuleCall_6_0(), semanticObject.getEndProcessing());
		feeder.accept(grammarAccess.getForStatementAccess().getLoopExprSingleStatementParserRuleCall_8_0(), semanticObject.getLoopExpr());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Filter returns FullFunctionAssignment
	 *     FunctionAssignment returns FullFunctionAssignment
	 *     FullFunctionAssignment returns FullFunctionAssignment
	 *
	 * Constraint:
	 *     (parameters=ParDef expr=BasicExpression)
	 */
	protected void sequence_FullFunctionAssignment(ISerializationContext context, FullFunctionAssignment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FULL_FUNCTION_ASSIGNMENT__PARAMETERS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FULL_FUNCTION_ASSIGNMENT__PARAMETERS));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FULL_FUNCTION_ASSIGNMENT__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FULL_FUNCTION_ASSIGNMENT__EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFullFunctionAssignmentAccess().getParametersParDefParserRuleCall_0_0(), semanticObject.getParameters());
		feeder.accept(grammarAccess.getFullFunctionAssignmentAccess().getExprBasicExpressionParserRuleCall_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Filter returns FunctionCall
	 *     SingleValue returns FunctionCall
	 *     FunctionAssignment returns FunctionCall
	 *     BasicExpression returns FunctionCall
	 *     Expression returns FunctionCall
	 *     CalculatedValue returns FunctionCall
	 *     FunctionCall returns FunctionCall
	 *     FunctionPar returns FunctionCall
	 *
	 * Constraint:
	 *     (function=[FunctionDef|ID] (params+=FunctionPar params+=FunctionPar*)?)
	 */
	protected void sequence_FunctionCall_FunctionPars(ISerializationContext context, FunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AssignStatement returns FunctionDef
	 *     SetOrFunctionDef returns FunctionDef
	 *     FunctionDef returns FunctionDef
	 *
	 * Constraint:
	 *     (type=FunctionType? name=ID init=JavaFunctionCall fullAssignment=FunctionAssignment?)
	 */
	protected void sequence_FunctionDef(ISerializationContext context, FunctionDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionDomainScope returns FunctionDomainScope
	 *
	 * Constraint:
	 *     function=[FunctionDef|ID]
	 */
	protected void sequence_FunctionDomainScope(ISerializationContext context, FunctionDomainScope semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.FUNCTION_DOMAIN_SCOPE__FUNCTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.FUNCTION_DOMAIN_SCOPE__FUNCTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFunctionDomainScopeAccess().getFunctionFunctionDefIDTerminalRuleCall_1_0_1(), semanticObject.eGet(VLangPackage.Literals.FUNCTION_DOMAIN_SCOPE__FUNCTION, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     FunctionScope returns FunctionDomainScope
	 *
	 * Constraint:
	 *     (function=[FunctionDef|ID] filter=Filter?)
	 */
	protected void sequence_FunctionDomainScope_FunctionScope(ISerializationContext context, FunctionDomainScope semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionParDef returns FunctionParDef
	 *
	 * Constraint:
	 *     (name=ID type=ID?)
	 */
	protected void sequence_FunctionParDef(ISerializationContext context, FunctionParDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Filter returns JavaFunctionCall
	 *     SingleValue returns JavaFunctionCall
	 *     FunctionAssignment returns JavaFunctionCall
	 *     BasicExpression returns JavaFunctionCall
	 *     Expression returns JavaFunctionCall
	 *     CalculatedValue returns JavaFunctionCall
	 *     JavaFunctionCall returns JavaFunctionCall
	 *     FunctionPar returns JavaFunctionCall
	 *
	 * Constraint:
	 *     (function=[JavaFunctionDef|ID] (params+=FunctionPar params+=FunctionPar*)?)
	 */
	protected void sequence_FunctionPars_JavaFunctionCall(ISerializationContext context, JavaFunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionScope returns InfiniteScope
	 *
	 * Constraint:
	 *     filter=Filter?
	 */
	protected void sequence_FunctionScope_InfiniteScope(ISerializationContext context, InfiniteScope semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionScope returns SetScope
	 *
	 * Constraint:
	 *     ((setRef=[SetDef|ID] | set=SetLiteral) filter=Filter?)
	 */
	protected void sequence_FunctionScope_SetScope(ISerializationContext context, SetScope semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionScope returns SingleScope
	 *
	 * Constraint:
	 *     (value=SingleValue filter=Filter?)
	 */
	protected void sequence_FunctionScope_SingleScope(ISerializationContext context, SingleScope semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SingleStatement returns IfStatement
	 *     IfStatement returns IfStatement
	 *
	 * Constraint:
	 *     (condition=FunctionAssignment thenStatement=SingleStatement elseStatement=SingleStatement?)
	 */
	protected void sequence_IfStatement(ISerializationContext context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Filter returns IfThenElse
	 *     SingleValue returns IfThenElse
	 *     FunctionAssignment returns IfThenElse
	 *     BasicExpression returns IfThenElse
	 *     Expression returns IfThenElse
	 *     CalculatedValue returns IfThenElse
	 *     IfThenElse returns IfThenElse
	 *     FunctionPar returns IfThenElse
	 *
	 * Constraint:
	 *     (condition=FunctionAssignment thenExpr=FunctionAssignment elseExpr=FunctionAssignment)
	 */
	protected void sequence_IfThenElse(ISerializationContext context, IfThenElse semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.IF_THEN_ELSE__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.IF_THEN_ELSE__CONDITION));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.IF_THEN_ELSE__THEN_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.IF_THEN_ELSE__THEN_EXPR));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.IF_THEN_ELSE__ELSE_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.IF_THEN_ELSE__ELSE_EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIfThenElseAccess().getConditionFunctionAssignmentParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getIfThenElseAccess().getThenExprFunctionAssignmentParserRuleCall_3_0(), semanticObject.getThenExpr());
		feeder.accept(grammarAccess.getIfThenElseAccess().getElseExprFunctionAssignmentParserRuleCall_5_0(), semanticObject.getElseExpr());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     target=ESTRING
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.IMPORT__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.IMPORT__TARGET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getTargetESTRINGTerminalRuleCall_1_0(), semanticObject.getTarget());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     InfiniteScope returns InfiniteScope
	 *
	 * Constraint:
	 *     {InfiniteScope}
	 */
	protected void sequence_InfiniteScope(ISerializationContext context, InfiniteScope semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AssignStatement returns JavaFunctionDef
	 *     JavaFunctionDef returns JavaFunctionDef
	 *
	 * Constraint:
	 *     (type=JavaFunctionType name=ID javaFunc=ESTRING)
	 */
	protected void sequence_JavaFunctionDef(ISerializationContext context, JavaFunctionDef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.JAVA_FUNCTION_DEF__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.JAVA_FUNCTION_DEF__TYPE));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.JAVA_FUNCTION_DEF__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.JAVA_FUNCTION_DEF__NAME));
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.JAVA_FUNCTION_DEF__JAVA_FUNC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.JAVA_FUNCTION_DEF__JAVA_FUNC));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJavaFunctionDefAccess().getTypeJavaFunctionTypeEnumRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getJavaFunctionDefAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getJavaFunctionDefAccess().getJavaFuncESTRINGTerminalRuleCall_3_0(), semanticObject.getJavaFunc());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SingleStatement returns LetStatement
	 *     LetStatement returns LetStatement
	 *
	 * Constraint:
	 *     (name=ID value=FunctionAssignment?)
	 */
	protected void sequence_LetStatement_MaybeValue(ISerializationContext context, LetStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SingleStatement returns ReturnStatement
	 *     ReturnStatement returns ReturnStatement
	 *
	 * Constraint:
	 *     value=FunctionAssignment
	 */
	protected void sequence_MaybeValue(ISerializationContext context, ReturnStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.MAYBE_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.MAYBE_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMaybeValueAccess().getValueFunctionAssignmentParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ObjId returns ObjId
	 *
	 * Constraint:
	 *     (name=ID (params+=ObjParam params+=ObjParam*)?)
	 */
	protected void sequence_ObjId(ISerializationContext context, ObjId semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ObjParam returns ObjParam
	 *
	 * Constraint:
	 *     (number=INT | string=STRING | (name=ID (params+=ObjParam params+=ObjParam*)?))
	 */
	protected void sequence_ObjParam(ISerializationContext context, ObjParam semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Filter returns OclFunction
	 *     FunctionAssignment returns OclFunction
	 *     BasicExpression returns OclFunction
	 *     Expression returns OclFunction
	 *     OclFunction returns OclFunction
	 *
	 * Constraint:
	 *     oclFunc=STRING
	 */
	protected void sequence_OclFunction(ISerializationContext context, OclFunction semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.OCL_FUNCTION__OCL_FUNC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.OCL_FUNCTION__OCL_FUNC));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOclFunctionAccess().getOclFuncSTRINGTerminalRuleCall_1_0(), semanticObject.getOclFunc());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ParDef returns ParDef
	 *
	 * Constraint:
	 *     (params+=FunctionParDef params+=FunctionParDef*)?
	 */
	protected void sequence_ParDef(ISerializationContext context, ParDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AssignStatement returns RuleAssignment
	 *     RuleAssignment returns RuleAssignment
	 *
	 * Constraint:
	 *     (function=[FunctionDef|ID] scope=FunctionScope (isFinite?=':=' | isDerive?='=' | isConstraint?='==') assignment=FunctionAssignment)
	 */
	protected void sequence_RuleAssignment(ISerializationContext context, RuleAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AssignStatement returns SetDef
	 *     SetOrFunctionDef returns SetDef
	 *     SetDef returns SetDef
	 *
	 * Constraint:
	 *     (name=ID literal=SetLiteral?)
	 */
	protected void sequence_SetDef(ISerializationContext context, SetDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SetLiteral returns SetLiteral
	 *
	 * Constraint:
	 *     (values+=FixedValue values+=FixedValue*)?
	 */
	protected void sequence_SetLiteral(ISerializationContext context, SetLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SetScope returns SetScope
	 *
	 * Constraint:
	 *     (setRef=[SetDef|ID] | set=SetLiteral)
	 */
	protected void sequence_SetScope(ISerializationContext context, SetScope semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SingleScope returns SingleScope
	 *
	 * Constraint:
	 *     value=SingleValue
	 */
	protected void sequence_SingleScope(ISerializationContext context, SingleScope semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, VLangPackage.Literals.SINGLE_SCOPE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VLangPackage.Literals.SINGLE_SCOPE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSingleScopeAccess().getValueSingleValueParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     VLang returns VLang
	 *
	 * Constraint:
	 *     ((imports+=Import+ statement+=AssignStatement+) | statement+=AssignStatement+)?
	 */
	protected void sequence_VLang(ISerializationContext context, VLang semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
