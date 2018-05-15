package at.ac.tuwien.big.virtmodel.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.ac.tuwien.big.virtmodel.services.VLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalVLangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ESTRING", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "';'", "'function'", "':='", "'new'", "'='", "'.'", "'set'", "'{'", "','", "'}'", "'('", "')'", "'=='", "'delete'", "'with'", "'all'", "'@'", "'&'", "'->'", "'ocl'", "'let'", "'return'", "'if'", "'else'", "'for'", "':'", "'then'", "'endif'", "'$'", "'#'", "'finite'", "'derive'", "'constraint'", "'jfunc'", "'jcons'", "'jop'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_ESTRING=4;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__48=48;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalVLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVLangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVLang.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private VLangGrammarAccess grammarAccess;

        public InternalVLangParser(TokenStream input, VLangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "VLang";
       	}

       	@Override
       	protected VLangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleVLang"
    // InternalVLang.g:71:1: entryRuleVLang returns [EObject current=null] : iv_ruleVLang= ruleVLang EOF ;
    public final EObject entryRuleVLang() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVLang = null;


        try {
            // InternalVLang.g:71:46: (iv_ruleVLang= ruleVLang EOF )
            // InternalVLang.g:72:2: iv_ruleVLang= ruleVLang EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVLangRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVLang=ruleVLang();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVLang; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVLang"


    // $ANTLR start "ruleVLang"
    // InternalVLang.g:78:1: ruleVLang returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_statement_1_0= ruleAssignStatement ) )* ) ;
    public final EObject ruleVLang() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_statement_1_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:84:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_statement_1_0= ruleAssignStatement ) )* ) )
            // InternalVLang.g:85:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_statement_1_0= ruleAssignStatement ) )* )
            {
            // InternalVLang.g:85:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_statement_1_0= ruleAssignStatement ) )* )
            // InternalVLang.g:86:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_statement_1_0= ruleAssignStatement ) )*
            {
            // InternalVLang.g:86:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalVLang.g:87:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalVLang.g:87:4: (lv_imports_0_0= ruleImport )
            	    // InternalVLang.g:88:5: lv_imports_0_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getVLangAccess().getImportsImportParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getVLangRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_0_0,
            	      						"at.ac.tuwien.big.virtmodel.VLang.Import");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalVLang.g:105:3: ( (lv_statement_1_0= ruleAssignStatement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||LA2_0==14||LA2_0==19||LA2_0==26||(LA2_0>=43 && LA2_0<=48)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalVLang.g:106:4: (lv_statement_1_0= ruleAssignStatement )
            	    {
            	    // InternalVLang.g:106:4: (lv_statement_1_0= ruleAssignStatement )
            	    // InternalVLang.g:107:5: lv_statement_1_0= ruleAssignStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getVLangAccess().getStatementAssignStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_statement_1_0=ruleAssignStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getVLangRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statement",
            	      						lv_statement_1_0,
            	      						"at.ac.tuwien.big.virtmodel.VLang.AssignStatement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVLang"


    // $ANTLR start "entryRuleImport"
    // InternalVLang.g:128:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalVLang.g:128:47: (iv_ruleImport= ruleImport EOF )
            // InternalVLang.g:129:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalVLang.g:135:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_target_1_0= RULE_ESTRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_target_1_0=null;


        	enterRule();

        try {
            // InternalVLang.g:141:2: ( (otherlv_0= 'import' ( (lv_target_1_0= RULE_ESTRING ) ) ) )
            // InternalVLang.g:142:2: (otherlv_0= 'import' ( (lv_target_1_0= RULE_ESTRING ) ) )
            {
            // InternalVLang.g:142:2: (otherlv_0= 'import' ( (lv_target_1_0= RULE_ESTRING ) ) )
            // InternalVLang.g:143:3: otherlv_0= 'import' ( (lv_target_1_0= RULE_ESTRING ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
              		
            }
            // InternalVLang.g:147:3: ( (lv_target_1_0= RULE_ESTRING ) )
            // InternalVLang.g:148:4: (lv_target_1_0= RULE_ESTRING )
            {
            // InternalVLang.g:148:4: (lv_target_1_0= RULE_ESTRING )
            // InternalVLang.g:149:5: lv_target_1_0= RULE_ESTRING
            {
            lv_target_1_0=(Token)match(input,RULE_ESTRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_target_1_0, grammarAccess.getImportAccess().getTargetESTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportRule());
              					}
              					setWithLastConsumed(
              						current,
              						"target",
              						lv_target_1_0,
              						"at.ac.tuwien.big.virtmodel.VLang.ESTRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleAssignStatement"
    // InternalVLang.g:169:1: entryRuleAssignStatement returns [EObject current=null] : iv_ruleAssignStatement= ruleAssignStatement EOF ;
    public final EObject entryRuleAssignStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignStatement = null;


        try {
            // InternalVLang.g:169:56: (iv_ruleAssignStatement= ruleAssignStatement EOF )
            // InternalVLang.g:170:2: iv_ruleAssignStatement= ruleAssignStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignStatement=ruleAssignStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignStatement"


    // $ANTLR start "ruleAssignStatement"
    // InternalVLang.g:176:1: ruleAssignStatement returns [EObject current=null] : ( (this_JavaFunctionDef_0= ruleJavaFunctionDef | this_SetOrFunctionDef_1= ruleSetOrFunctionDef | this_RuleAssignment_2= ruleRuleAssignment | this_BasicAction_3= ruleBasicAction | this_DeleteAssignment_4= ruleDeleteAssignment ) otherlv_5= ';' ) ;
    public final EObject ruleAssignStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        EObject this_JavaFunctionDef_0 = null;

        EObject this_SetOrFunctionDef_1 = null;

        EObject this_RuleAssignment_2 = null;

        EObject this_BasicAction_3 = null;

        EObject this_DeleteAssignment_4 = null;



        	enterRule();

        try {
            // InternalVLang.g:182:2: ( ( (this_JavaFunctionDef_0= ruleJavaFunctionDef | this_SetOrFunctionDef_1= ruleSetOrFunctionDef | this_RuleAssignment_2= ruleRuleAssignment | this_BasicAction_3= ruleBasicAction | this_DeleteAssignment_4= ruleDeleteAssignment ) otherlv_5= ';' ) )
            // InternalVLang.g:183:2: ( (this_JavaFunctionDef_0= ruleJavaFunctionDef | this_SetOrFunctionDef_1= ruleSetOrFunctionDef | this_RuleAssignment_2= ruleRuleAssignment | this_BasicAction_3= ruleBasicAction | this_DeleteAssignment_4= ruleDeleteAssignment ) otherlv_5= ';' )
            {
            // InternalVLang.g:183:2: ( (this_JavaFunctionDef_0= ruleJavaFunctionDef | this_SetOrFunctionDef_1= ruleSetOrFunctionDef | this_RuleAssignment_2= ruleRuleAssignment | this_BasicAction_3= ruleBasicAction | this_DeleteAssignment_4= ruleDeleteAssignment ) otherlv_5= ';' )
            // InternalVLang.g:184:3: (this_JavaFunctionDef_0= ruleJavaFunctionDef | this_SetOrFunctionDef_1= ruleSetOrFunctionDef | this_RuleAssignment_2= ruleRuleAssignment | this_BasicAction_3= ruleBasicAction | this_DeleteAssignment_4= ruleDeleteAssignment ) otherlv_5= ';'
            {
            // InternalVLang.g:184:3: (this_JavaFunctionDef_0= ruleJavaFunctionDef | this_SetOrFunctionDef_1= ruleSetOrFunctionDef | this_RuleAssignment_2= ruleRuleAssignment | this_BasicAction_3= ruleBasicAction | this_DeleteAssignment_4= ruleDeleteAssignment )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 46:
            case 47:
            case 48:
                {
                alt3=1;
                }
                break;
            case 14:
            case 19:
            case 43:
            case 44:
            case 45:
                {
                alt3=2;
                }
                break;
            case RULE_ID:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==18) ) {
                    alt3=4;
                }
                else if ( (LA3_3==23) ) {
                    alt3=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt3=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalVLang.g:185:4: this_JavaFunctionDef_0= ruleJavaFunctionDef
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignStatementAccess().getJavaFunctionDefParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_6);
                    this_JavaFunctionDef_0=ruleJavaFunctionDef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_JavaFunctionDef_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalVLang.g:197:4: this_SetOrFunctionDef_1= ruleSetOrFunctionDef
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignStatementAccess().getSetOrFunctionDefParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_6);
                    this_SetOrFunctionDef_1=ruleSetOrFunctionDef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_SetOrFunctionDef_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalVLang.g:209:4: this_RuleAssignment_2= ruleRuleAssignment
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignStatementAccess().getRuleAssignmentParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_6);
                    this_RuleAssignment_2=ruleRuleAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_RuleAssignment_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 4 :
                    // InternalVLang.g:221:4: this_BasicAction_3= ruleBasicAction
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignStatementAccess().getBasicActionParserRuleCall_0_3());
                      			
                    }
                    pushFollow(FOLLOW_6);
                    this_BasicAction_3=ruleBasicAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_BasicAction_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 5 :
                    // InternalVLang.g:233:4: this_DeleteAssignment_4= ruleDeleteAssignment
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignStatementAccess().getDeleteAssignmentParserRuleCall_0_4());
                      			
                    }
                    pushFollow(FOLLOW_6);
                    this_DeleteAssignment_4=ruleDeleteAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_DeleteAssignment_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getAssignStatementAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignStatement"


    // $ANTLR start "entryRuleSetOrFunctionDef"
    // InternalVLang.g:253:1: entryRuleSetOrFunctionDef returns [EObject current=null] : iv_ruleSetOrFunctionDef= ruleSetOrFunctionDef EOF ;
    public final EObject entryRuleSetOrFunctionDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetOrFunctionDef = null;


        try {
            // InternalVLang.g:253:57: (iv_ruleSetOrFunctionDef= ruleSetOrFunctionDef EOF )
            // InternalVLang.g:254:2: iv_ruleSetOrFunctionDef= ruleSetOrFunctionDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetOrFunctionDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetOrFunctionDef=ruleSetOrFunctionDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetOrFunctionDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetOrFunctionDef"


    // $ANTLR start "ruleSetOrFunctionDef"
    // InternalVLang.g:260:1: ruleSetOrFunctionDef returns [EObject current=null] : (this_SetDef_0= ruleSetDef | this_FunctionDef_1= ruleFunctionDef ) ;
    public final EObject ruleSetOrFunctionDef() throws RecognitionException {
        EObject current = null;

        EObject this_SetDef_0 = null;

        EObject this_FunctionDef_1 = null;



        	enterRule();

        try {
            // InternalVLang.g:266:2: ( (this_SetDef_0= ruleSetDef | this_FunctionDef_1= ruleFunctionDef ) )
            // InternalVLang.g:267:2: (this_SetDef_0= ruleSetDef | this_FunctionDef_1= ruleFunctionDef )
            {
            // InternalVLang.g:267:2: (this_SetDef_0= ruleSetDef | this_FunctionDef_1= ruleFunctionDef )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            else if ( (LA4_0==14||(LA4_0>=43 && LA4_0<=45)) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalVLang.g:268:3: this_SetDef_0= ruleSetDef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSetOrFunctionDefAccess().getSetDefParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SetDef_0=ruleSetDef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetDef_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVLang.g:280:3: this_FunctionDef_1= ruleFunctionDef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSetOrFunctionDefAccess().getFunctionDefParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionDef_1=ruleFunctionDef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionDef_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetOrFunctionDef"


    // $ANTLR start "entryRuleFunctionDef"
    // InternalVLang.g:295:1: entryRuleFunctionDef returns [EObject current=null] : iv_ruleFunctionDef= ruleFunctionDef EOF ;
    public final EObject entryRuleFunctionDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDef = null;


        try {
            // InternalVLang.g:295:52: (iv_ruleFunctionDef= ruleFunctionDef EOF )
            // InternalVLang.g:296:2: iv_ruleFunctionDef= ruleFunctionDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDef=ruleFunctionDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDef"


    // $ANTLR start "ruleFunctionDef"
    // InternalVLang.g:302:1: ruleFunctionDef returns [EObject current=null] : ( ( (lv_type_0_0= ruleFunctionType ) )? otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' otherlv_4= 'new' ( (lv_init_5_0= ruleJavaFunctionCall ) ) (otherlv_6= '=' ( (lv_fullAssignment_7_0= ruleFunctionAssignment ) ) )? ) ;
    public final EObject ruleFunctionDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_init_5_0 = null;

        EObject lv_fullAssignment_7_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:308:2: ( ( ( (lv_type_0_0= ruleFunctionType ) )? otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' otherlv_4= 'new' ( (lv_init_5_0= ruleJavaFunctionCall ) ) (otherlv_6= '=' ( (lv_fullAssignment_7_0= ruleFunctionAssignment ) ) )? ) )
            // InternalVLang.g:309:2: ( ( (lv_type_0_0= ruleFunctionType ) )? otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' otherlv_4= 'new' ( (lv_init_5_0= ruleJavaFunctionCall ) ) (otherlv_6= '=' ( (lv_fullAssignment_7_0= ruleFunctionAssignment ) ) )? )
            {
            // InternalVLang.g:309:2: ( ( (lv_type_0_0= ruleFunctionType ) )? otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' otherlv_4= 'new' ( (lv_init_5_0= ruleJavaFunctionCall ) ) (otherlv_6= '=' ( (lv_fullAssignment_7_0= ruleFunctionAssignment ) ) )? )
            // InternalVLang.g:310:3: ( (lv_type_0_0= ruleFunctionType ) )? otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' otherlv_4= 'new' ( (lv_init_5_0= ruleJavaFunctionCall ) ) (otherlv_6= '=' ( (lv_fullAssignment_7_0= ruleFunctionAssignment ) ) )?
            {
            // InternalVLang.g:310:3: ( (lv_type_0_0= ruleFunctionType ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=43 && LA5_0<=45)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVLang.g:311:4: (lv_type_0_0= ruleFunctionType )
                    {
                    // InternalVLang.g:311:4: (lv_type_0_0= ruleFunctionType )
                    // InternalVLang.g:312:5: lv_type_0_0= ruleFunctionType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionDefAccess().getTypeFunctionTypeEnumRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_7);
                    lv_type_0_0=ruleFunctionType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionDefRule());
                      					}
                      					set(
                      						current,
                      						"type",
                      						lv_type_0_0,
                      						"at.ac.tuwien.big.virtmodel.VLang.FunctionType");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,14,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionDefAccess().getFunctionKeyword_1());
              		
            }
            // InternalVLang.g:333:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalVLang.g:334:4: (lv_name_2_0= RULE_ID )
            {
            // InternalVLang.g:334:4: (lv_name_2_0= RULE_ID )
            // InternalVLang.g:335:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getFunctionDefAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionDefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionDefAccess().getColonEqualsSignKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,16,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getFunctionDefAccess().getNewKeyword_4());
              		
            }
            // InternalVLang.g:359:3: ( (lv_init_5_0= ruleJavaFunctionCall ) )
            // InternalVLang.g:360:4: (lv_init_5_0= ruleJavaFunctionCall )
            {
            // InternalVLang.g:360:4: (lv_init_5_0= ruleJavaFunctionCall )
            // InternalVLang.g:361:5: lv_init_5_0= ruleJavaFunctionCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDefAccess().getInitJavaFunctionCallParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_init_5_0=ruleJavaFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDefRule());
              					}
              					set(
              						current,
              						"init",
              						lv_init_5_0,
              						"at.ac.tuwien.big.virtmodel.VLang.JavaFunctionCall");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVLang.g:378:3: (otherlv_6= '=' ( (lv_fullAssignment_7_0= ruleFunctionAssignment ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalVLang.g:379:4: otherlv_6= '=' ( (lv_fullAssignment_7_0= ruleFunctionAssignment ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getFunctionDefAccess().getEqualsSignKeyword_6_0());
                      			
                    }
                    // InternalVLang.g:383:4: ( (lv_fullAssignment_7_0= ruleFunctionAssignment ) )
                    // InternalVLang.g:384:5: (lv_fullAssignment_7_0= ruleFunctionAssignment )
                    {
                    // InternalVLang.g:384:5: (lv_fullAssignment_7_0= ruleFunctionAssignment )
                    // InternalVLang.g:385:6: lv_fullAssignment_7_0= ruleFunctionAssignment
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefAccess().getFullAssignmentFunctionAssignmentParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_fullAssignment_7_0=ruleFunctionAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefRule());
                      						}
                      						set(
                      							current,
                      							"fullAssignment",
                      							lv_fullAssignment_7_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDef"


    // $ANTLR start "entryRuleJavaFunctionDef"
    // InternalVLang.g:407:1: entryRuleJavaFunctionDef returns [EObject current=null] : iv_ruleJavaFunctionDef= ruleJavaFunctionDef EOF ;
    public final EObject entryRuleJavaFunctionDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaFunctionDef = null;


        try {
            // InternalVLang.g:407:56: (iv_ruleJavaFunctionDef= ruleJavaFunctionDef EOF )
            // InternalVLang.g:408:2: iv_ruleJavaFunctionDef= ruleJavaFunctionDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaFunctionDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJavaFunctionDef=ruleJavaFunctionDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaFunctionDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJavaFunctionDef"


    // $ANTLR start "ruleJavaFunctionDef"
    // InternalVLang.g:414:1: ruleJavaFunctionDef returns [EObject current=null] : ( ( (lv_type_0_0= ruleJavaFunctionType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_javaFunc_3_0= RULE_ESTRING ) ) ) ;
    public final EObject ruleJavaFunctionDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_javaFunc_3_0=null;
        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:420:2: ( ( ( (lv_type_0_0= ruleJavaFunctionType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_javaFunc_3_0= RULE_ESTRING ) ) ) )
            // InternalVLang.g:421:2: ( ( (lv_type_0_0= ruleJavaFunctionType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_javaFunc_3_0= RULE_ESTRING ) ) )
            {
            // InternalVLang.g:421:2: ( ( (lv_type_0_0= ruleJavaFunctionType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_javaFunc_3_0= RULE_ESTRING ) ) )
            // InternalVLang.g:422:3: ( (lv_type_0_0= ruleJavaFunctionType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_javaFunc_3_0= RULE_ESTRING ) )
            {
            // InternalVLang.g:422:3: ( (lv_type_0_0= ruleJavaFunctionType ) )
            // InternalVLang.g:423:4: (lv_type_0_0= ruleJavaFunctionType )
            {
            // InternalVLang.g:423:4: (lv_type_0_0= ruleJavaFunctionType )
            // InternalVLang.g:424:5: lv_type_0_0= ruleJavaFunctionType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJavaFunctionDefAccess().getTypeJavaFunctionTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_type_0_0=ruleJavaFunctionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJavaFunctionDefRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"at.ac.tuwien.big.virtmodel.VLang.JavaFunctionType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVLang.g:441:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalVLang.g:442:4: (lv_name_1_0= RULE_ID )
            {
            // InternalVLang.g:442:4: (lv_name_1_0= RULE_ID )
            // InternalVLang.g:443:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getJavaFunctionDefAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getJavaFunctionDefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getJavaFunctionDefAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalVLang.g:463:3: ( (lv_javaFunc_3_0= RULE_ESTRING ) )
            // InternalVLang.g:464:4: (lv_javaFunc_3_0= RULE_ESTRING )
            {
            // InternalVLang.g:464:4: (lv_javaFunc_3_0= RULE_ESTRING )
            // InternalVLang.g:465:5: lv_javaFunc_3_0= RULE_ESTRING
            {
            lv_javaFunc_3_0=(Token)match(input,RULE_ESTRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_javaFunc_3_0, grammarAccess.getJavaFunctionDefAccess().getJavaFuncESTRINGTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getJavaFunctionDefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"javaFunc",
              						lv_javaFunc_3_0,
              						"at.ac.tuwien.big.virtmodel.VLang.ESTRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJavaFunctionDef"


    // $ANTLR start "entryRuleBasicAction"
    // InternalVLang.g:485:1: entryRuleBasicAction returns [EObject current=null] : iv_ruleBasicAction= ruleBasicAction EOF ;
    public final EObject entryRuleBasicAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicAction = null;


        try {
            // InternalVLang.g:485:52: (iv_ruleBasicAction= ruleBasicAction EOF )
            // InternalVLang.g:486:2: iv_ruleBasicAction= ruleBasicAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicActionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBasicAction=ruleBasicAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicAction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicAction"


    // $ANTLR start "ruleBasicAction"
    // InternalVLang.g:492:1: ruleBasicAction returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_calledFunc_2_0= RULE_ID ) ) this_FunctionPars_3= ruleFunctionPars[$current] ) ;
    public final EObject ruleBasicAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_calledFunc_2_0=null;
        EObject this_FunctionPars_3 = null;



        	enterRule();

        try {
            // InternalVLang.g:498:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_calledFunc_2_0= RULE_ID ) ) this_FunctionPars_3= ruleFunctionPars[$current] ) )
            // InternalVLang.g:499:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_calledFunc_2_0= RULE_ID ) ) this_FunctionPars_3= ruleFunctionPars[$current] )
            {
            // InternalVLang.g:499:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_calledFunc_2_0= RULE_ID ) ) this_FunctionPars_3= ruleFunctionPars[$current] )
            // InternalVLang.g:500:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_calledFunc_2_0= RULE_ID ) ) this_FunctionPars_3= ruleFunctionPars[$current]
            {
            // InternalVLang.g:500:3: ( (otherlv_0= RULE_ID ) )
            // InternalVLang.g:501:4: (otherlv_0= RULE_ID )
            {
            // InternalVLang.g:501:4: (otherlv_0= RULE_ID )
            // InternalVLang.g:502:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBasicActionRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getBasicActionAccess().getThingSetOrFunctionDefCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBasicActionAccess().getFullStopKeyword_1());
              		
            }
            // InternalVLang.g:520:3: ( (lv_calledFunc_2_0= RULE_ID ) )
            // InternalVLang.g:521:4: (lv_calledFunc_2_0= RULE_ID )
            {
            // InternalVLang.g:521:4: (lv_calledFunc_2_0= RULE_ID )
            // InternalVLang.g:522:5: lv_calledFunc_2_0= RULE_ID
            {
            lv_calledFunc_2_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_calledFunc_2_0, grammarAccess.getBasicActionAccess().getCalledFuncIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBasicActionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"calledFunc",
              						lv_calledFunc_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getBasicActionRule());
              			}
              			newCompositeNode(grammarAccess.getBasicActionAccess().getFunctionParsParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_2);
            this_FunctionPars_3=ruleFunctionPars(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_FunctionPars_3;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicAction"


    // $ANTLR start "entryRuleSetDef"
    // InternalVLang.g:556:1: entryRuleSetDef returns [EObject current=null] : iv_ruleSetDef= ruleSetDef EOF ;
    public final EObject entryRuleSetDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetDef = null;


        try {
            // InternalVLang.g:556:47: (iv_ruleSetDef= ruleSetDef EOF )
            // InternalVLang.g:557:2: iv_ruleSetDef= ruleSetDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetDef=ruleSetDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetDef"


    // $ANTLR start "ruleSetDef"
    // InternalVLang.g:563:1: ruleSetDef returns [EObject current=null] : (otherlv_0= 'set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_literal_3_0= ruleSetLiteral ) ) )? ) ;
    public final EObject ruleSetDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_literal_3_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:569:2: ( (otherlv_0= 'set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_literal_3_0= ruleSetLiteral ) ) )? ) )
            // InternalVLang.g:570:2: (otherlv_0= 'set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_literal_3_0= ruleSetLiteral ) ) )? )
            {
            // InternalVLang.g:570:2: (otherlv_0= 'set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_literal_3_0= ruleSetLiteral ) ) )? )
            // InternalVLang.g:571:3: otherlv_0= 'set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_literal_3_0= ruleSetLiteral ) ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSetDefAccess().getSetKeyword_0());
              		
            }
            // InternalVLang.g:575:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalVLang.g:576:4: (lv_name_1_0= RULE_ID )
            {
            // InternalVLang.g:576:4: (lv_name_1_0= RULE_ID )
            // InternalVLang.g:577:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getSetDefAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSetDefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalVLang.g:593:3: (otherlv_2= '=' ( (lv_literal_3_0= ruleSetLiteral ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalVLang.g:594:4: otherlv_2= '=' ( (lv_literal_3_0= ruleSetLiteral ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSetDefAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalVLang.g:598:4: ( (lv_literal_3_0= ruleSetLiteral ) )
                    // InternalVLang.g:599:5: (lv_literal_3_0= ruleSetLiteral )
                    {
                    // InternalVLang.g:599:5: (lv_literal_3_0= ruleSetLiteral )
                    // InternalVLang.g:600:6: lv_literal_3_0= ruleSetLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSetDefAccess().getLiteralSetLiteralParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_literal_3_0=ruleSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSetDefRule());
                      						}
                      						set(
                      							current,
                      							"literal",
                      							lv_literal_3_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.SetLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetDef"


    // $ANTLR start "entryRuleSetLiteral"
    // InternalVLang.g:622:1: entryRuleSetLiteral returns [EObject current=null] : iv_ruleSetLiteral= ruleSetLiteral EOF ;
    public final EObject entryRuleSetLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetLiteral = null;


        try {
            // InternalVLang.g:622:51: (iv_ruleSetLiteral= ruleSetLiteral EOF )
            // InternalVLang.g:623:2: iv_ruleSetLiteral= ruleSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetLiteral=ruleSetLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetLiteral"


    // $ANTLR start "ruleSetLiteral"
    // InternalVLang.g:629:1: ruleSetLiteral returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_values_2_0= ruleFixedValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleSetLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:635:2: ( ( () otherlv_1= '{' ( ( (lv_values_2_0= ruleFixedValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) ) )* )? otherlv_5= '}' ) )
            // InternalVLang.g:636:2: ( () otherlv_1= '{' ( ( (lv_values_2_0= ruleFixedValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) ) )* )? otherlv_5= '}' )
            {
            // InternalVLang.g:636:2: ( () otherlv_1= '{' ( ( (lv_values_2_0= ruleFixedValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) ) )* )? otherlv_5= '}' )
            // InternalVLang.g:637:3: () otherlv_1= '{' ( ( (lv_values_2_0= ruleFixedValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) ) )* )? otherlv_5= '}'
            {
            // InternalVLang.g:637:3: ()
            // InternalVLang.g:638:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetLiteralAccess().getSetLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetLiteralAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalVLang.g:651:3: ( ( (lv_values_2_0= ruleFixedValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_INT && LA9_0<=RULE_STRING)||LA9_0==42) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVLang.g:652:4: ( (lv_values_2_0= ruleFixedValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) ) )*
                    {
                    // InternalVLang.g:652:4: ( (lv_values_2_0= ruleFixedValue ) )
                    // InternalVLang.g:653:5: (lv_values_2_0= ruleFixedValue )
                    {
                    // InternalVLang.g:653:5: (lv_values_2_0= ruleFixedValue )
                    // InternalVLang.g:654:6: lv_values_2_0= ruleFixedValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSetLiteralAccess().getValuesFixedValueParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_values_2_0=ruleFixedValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSetLiteralRule());
                      						}
                      						add(
                      							current,
                      							"values",
                      							lv_values_2_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.FixedValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalVLang.g:671:4: (otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==21) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalVLang.g:672:5: otherlv_3= ',' ( (lv_values_4_0= ruleFixedValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getSetLiteralAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalVLang.g:676:5: ( (lv_values_4_0= ruleFixedValue ) )
                    	    // InternalVLang.g:677:6: (lv_values_4_0= ruleFixedValue )
                    	    {
                    	    // InternalVLang.g:677:6: (lv_values_4_0= ruleFixedValue )
                    	    // InternalVLang.g:678:7: lv_values_4_0= ruleFixedValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getSetLiteralAccess().getValuesFixedValueParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_values_4_0=ruleFixedValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getSetLiteralRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"values",
                    	      								lv_values_4_0,
                    	      								"at.ac.tuwien.big.virtmodel.VLang.FixedValue");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getSetLiteralAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetLiteral"


    // $ANTLR start "entryRuleRuleAssignment"
    // InternalVLang.g:705:1: entryRuleRuleAssignment returns [EObject current=null] : iv_ruleRuleAssignment= ruleRuleAssignment EOF ;
    public final EObject entryRuleRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleAssignment = null;


        try {
            // InternalVLang.g:705:55: (iv_ruleRuleAssignment= ruleRuleAssignment EOF )
            // InternalVLang.g:706:2: iv_ruleRuleAssignment= ruleRuleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleAssignment=ruleRuleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleAssignment"


    // $ANTLR start "ruleRuleAssignment"
    // InternalVLang.g:712:1: ruleRuleAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_scope_2_0= ruleFunctionScope ) ) otherlv_3= ')' ( ( (lv_isFinite_4_0= ':=' ) ) | ( (lv_isDerive_5_0= '=' ) ) | ( (lv_isConstraint_6_0= '==' ) ) ) ( (lv_assignment_7_0= ruleFunctionAssignment ) ) ) ;
    public final EObject ruleRuleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_isFinite_4_0=null;
        Token lv_isDerive_5_0=null;
        Token lv_isConstraint_6_0=null;
        EObject lv_scope_2_0 = null;

        EObject lv_assignment_7_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:718:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_scope_2_0= ruleFunctionScope ) ) otherlv_3= ')' ( ( (lv_isFinite_4_0= ':=' ) ) | ( (lv_isDerive_5_0= '=' ) ) | ( (lv_isConstraint_6_0= '==' ) ) ) ( (lv_assignment_7_0= ruleFunctionAssignment ) ) ) )
            // InternalVLang.g:719:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_scope_2_0= ruleFunctionScope ) ) otherlv_3= ')' ( ( (lv_isFinite_4_0= ':=' ) ) | ( (lv_isDerive_5_0= '=' ) ) | ( (lv_isConstraint_6_0= '==' ) ) ) ( (lv_assignment_7_0= ruleFunctionAssignment ) ) )
            {
            // InternalVLang.g:719:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_scope_2_0= ruleFunctionScope ) ) otherlv_3= ')' ( ( (lv_isFinite_4_0= ':=' ) ) | ( (lv_isDerive_5_0= '=' ) ) | ( (lv_isConstraint_6_0= '==' ) ) ) ( (lv_assignment_7_0= ruleFunctionAssignment ) ) )
            // InternalVLang.g:720:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_scope_2_0= ruleFunctionScope ) ) otherlv_3= ')' ( ( (lv_isFinite_4_0= ':=' ) ) | ( (lv_isDerive_5_0= '=' ) ) | ( (lv_isConstraint_6_0= '==' ) ) ) ( (lv_assignment_7_0= ruleFunctionAssignment ) )
            {
            // InternalVLang.g:720:3: ( (otherlv_0= RULE_ID ) )
            // InternalVLang.g:721:4: (otherlv_0= RULE_ID )
            {
            // InternalVLang.g:721:4: (otherlv_0= RULE_ID )
            // InternalVLang.g:722:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRuleAssignmentRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getRuleAssignmentAccess().getFunctionFunctionDefCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRuleAssignmentAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVLang.g:740:3: ( (lv_scope_2_0= ruleFunctionScope ) )
            // InternalVLang.g:741:4: (lv_scope_2_0= ruleFunctionScope )
            {
            // InternalVLang.g:741:4: (lv_scope_2_0= ruleFunctionScope )
            // InternalVLang.g:742:5: lv_scope_2_0= ruleFunctionScope
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRuleAssignmentAccess().getScopeFunctionScopeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_scope_2_0=ruleFunctionScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRuleAssignmentRule());
              					}
              					set(
              						current,
              						"scope",
              						lv_scope_2_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionScope");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRuleAssignmentAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalVLang.g:763:3: ( ( (lv_isFinite_4_0= ':=' ) ) | ( (lv_isDerive_5_0= '=' ) ) | ( (lv_isConstraint_6_0= '==' ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt10=1;
                }
                break;
            case 17:
                {
                alt10=2;
                }
                break;
            case 25:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalVLang.g:764:4: ( (lv_isFinite_4_0= ':=' ) )
                    {
                    // InternalVLang.g:764:4: ( (lv_isFinite_4_0= ':=' ) )
                    // InternalVLang.g:765:5: (lv_isFinite_4_0= ':=' )
                    {
                    // InternalVLang.g:765:5: (lv_isFinite_4_0= ':=' )
                    // InternalVLang.g:766:6: lv_isFinite_4_0= ':='
                    {
                    lv_isFinite_4_0=(Token)match(input,15,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isFinite_4_0, grammarAccess.getRuleAssignmentAccess().getIsFiniteColonEqualsSignKeyword_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRuleAssignmentRule());
                      						}
                      						setWithLastConsumed(current, "isFinite", true, ":=");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVLang.g:779:4: ( (lv_isDerive_5_0= '=' ) )
                    {
                    // InternalVLang.g:779:4: ( (lv_isDerive_5_0= '=' ) )
                    // InternalVLang.g:780:5: (lv_isDerive_5_0= '=' )
                    {
                    // InternalVLang.g:780:5: (lv_isDerive_5_0= '=' )
                    // InternalVLang.g:781:6: lv_isDerive_5_0= '='
                    {
                    lv_isDerive_5_0=(Token)match(input,17,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isDerive_5_0, grammarAccess.getRuleAssignmentAccess().getIsDeriveEqualsSignKeyword_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRuleAssignmentRule());
                      						}
                      						setWithLastConsumed(current, "isDerive", true, "=");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalVLang.g:794:4: ( (lv_isConstraint_6_0= '==' ) )
                    {
                    // InternalVLang.g:794:4: ( (lv_isConstraint_6_0= '==' ) )
                    // InternalVLang.g:795:5: (lv_isConstraint_6_0= '==' )
                    {
                    // InternalVLang.g:795:5: (lv_isConstraint_6_0= '==' )
                    // InternalVLang.g:796:6: lv_isConstraint_6_0= '=='
                    {
                    lv_isConstraint_6_0=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isConstraint_6_0, grammarAccess.getRuleAssignmentAccess().getIsConstraintEqualsSignEqualsSignKeyword_4_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRuleAssignmentRule());
                      						}
                      						setWithLastConsumed(current, "isConstraint", true, "==");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalVLang.g:809:3: ( (lv_assignment_7_0= ruleFunctionAssignment ) )
            // InternalVLang.g:810:4: (lv_assignment_7_0= ruleFunctionAssignment )
            {
            // InternalVLang.g:810:4: (lv_assignment_7_0= ruleFunctionAssignment )
            // InternalVLang.g:811:5: lv_assignment_7_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRuleAssignmentAccess().getAssignmentFunctionAssignmentParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_assignment_7_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRuleAssignmentRule());
              					}
              					set(
              						current,
              						"assignment",
              						lv_assignment_7_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleAssignment"


    // $ANTLR start "entryRuleDeleteAssignment"
    // InternalVLang.g:832:1: entryRuleDeleteAssignment returns [EObject current=null] : iv_ruleDeleteAssignment= ruleDeleteAssignment EOF ;
    public final EObject entryRuleDeleteAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteAssignment = null;


        try {
            // InternalVLang.g:832:57: (iv_ruleDeleteAssignment= ruleDeleteAssignment EOF )
            // InternalVLang.g:833:2: iv_ruleDeleteAssignment= ruleDeleteAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeleteAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeleteAssignment=ruleDeleteAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeleteAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeleteAssignment"


    // $ANTLR start "ruleDeleteAssignment"
    // InternalVLang.g:839:1: ruleDeleteAssignment returns [EObject current=null] : (otherlv_0= 'delete' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_scope_3_0= ruleFunctionScope ) ) otherlv_4= ')' ) ;
    public final EObject ruleDeleteAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_scope_3_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:845:2: ( (otherlv_0= 'delete' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_scope_3_0= ruleFunctionScope ) ) otherlv_4= ')' ) )
            // InternalVLang.g:846:2: (otherlv_0= 'delete' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_scope_3_0= ruleFunctionScope ) ) otherlv_4= ')' )
            {
            // InternalVLang.g:846:2: (otherlv_0= 'delete' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_scope_3_0= ruleFunctionScope ) ) otherlv_4= ')' )
            // InternalVLang.g:847:3: otherlv_0= 'delete' ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( (lv_scope_3_0= ruleFunctionScope ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDeleteAssignmentAccess().getDeleteKeyword_0());
              		
            }
            // InternalVLang.g:851:3: ( (otherlv_1= RULE_ID ) )
            // InternalVLang.g:852:4: (otherlv_1= RULE_ID )
            {
            // InternalVLang.g:852:4: (otherlv_1= RULE_ID )
            // InternalVLang.g:853:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDeleteAssignmentRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getDeleteAssignmentAccess().getFunctionFunctionDefCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDeleteAssignmentAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalVLang.g:871:3: ( (lv_scope_3_0= ruleFunctionScope ) )
            // InternalVLang.g:872:4: (lv_scope_3_0= ruleFunctionScope )
            {
            // InternalVLang.g:872:4: (lv_scope_3_0= ruleFunctionScope )
            // InternalVLang.g:873:5: lv_scope_3_0= ruleFunctionScope
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeleteAssignmentAccess().getScopeFunctionScopeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_scope_3_0=ruleFunctionScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeleteAssignmentRule());
              					}
              					set(
              						current,
              						"scope",
              						lv_scope_3_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionScope");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDeleteAssignmentAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeleteAssignment"


    // $ANTLR start "entryRuleFunctionScope"
    // InternalVLang.g:898:1: entryRuleFunctionScope returns [EObject current=null] : iv_ruleFunctionScope= ruleFunctionScope EOF ;
    public final EObject entryRuleFunctionScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionScope = null;


        try {
            // InternalVLang.g:898:54: (iv_ruleFunctionScope= ruleFunctionScope EOF )
            // InternalVLang.g:899:2: iv_ruleFunctionScope= ruleFunctionScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionScopeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionScope=ruleFunctionScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionScope; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionScope"


    // $ANTLR start "ruleFunctionScope"
    // InternalVLang.g:905:1: ruleFunctionScope returns [EObject current=null] : ( (this_SingleScope_0= ruleSingleScope | this_FunctionDomainScope_1= ruleFunctionDomainScope | this_SetScope_2= ruleSetScope | this_InfiniteScope_3= ruleInfiniteScope ) (otherlv_4= 'with' ( (lv_filter_5_0= ruleFilter ) ) )? ) ;
    public final EObject ruleFunctionScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        EObject this_SingleScope_0 = null;

        EObject this_FunctionDomainScope_1 = null;

        EObject this_SetScope_2 = null;

        EObject this_InfiniteScope_3 = null;

        EObject lv_filter_5_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:911:2: ( ( (this_SingleScope_0= ruleSingleScope | this_FunctionDomainScope_1= ruleFunctionDomainScope | this_SetScope_2= ruleSetScope | this_InfiniteScope_3= ruleInfiniteScope ) (otherlv_4= 'with' ( (lv_filter_5_0= ruleFilter ) ) )? ) )
            // InternalVLang.g:912:2: ( (this_SingleScope_0= ruleSingleScope | this_FunctionDomainScope_1= ruleFunctionDomainScope | this_SetScope_2= ruleSetScope | this_InfiniteScope_3= ruleInfiniteScope ) (otherlv_4= 'with' ( (lv_filter_5_0= ruleFilter ) ) )? )
            {
            // InternalVLang.g:912:2: ( (this_SingleScope_0= ruleSingleScope | this_FunctionDomainScope_1= ruleFunctionDomainScope | this_SetScope_2= ruleSetScope | this_InfiniteScope_3= ruleInfiniteScope ) (otherlv_4= 'with' ( (lv_filter_5_0= ruleFilter ) ) )? )
            // InternalVLang.g:913:3: (this_SingleScope_0= ruleSingleScope | this_FunctionDomainScope_1= ruleFunctionDomainScope | this_SetScope_2= ruleSetScope | this_InfiniteScope_3= ruleInfiniteScope ) (otherlv_4= 'with' ( (lv_filter_5_0= ruleFilter ) ) )?
            {
            // InternalVLang.g:913:3: (this_SingleScope_0= ruleSingleScope | this_FunctionDomainScope_1= ruleFunctionDomainScope | this_SetScope_2= ruleSetScope | this_InfiniteScope_3= ruleInfiniteScope )
            int alt11=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 35:
            case 42:
                {
                alt11=1;
                }
                break;
            case 29:
                {
                alt11=2;
                }
                break;
            case 30:
                {
                alt11=3;
                }
                break;
            case 28:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalVLang.g:914:4: this_SingleScope_0= ruleSingleScope
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getFunctionScopeAccess().getSingleScopeParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_24);
                    this_SingleScope_0=ruleSingleScope();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_SingleScope_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalVLang.g:926:4: this_FunctionDomainScope_1= ruleFunctionDomainScope
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getFunctionScopeAccess().getFunctionDomainScopeParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_24);
                    this_FunctionDomainScope_1=ruleFunctionDomainScope();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_FunctionDomainScope_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalVLang.g:938:4: this_SetScope_2= ruleSetScope
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getFunctionScopeAccess().getSetScopeParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_24);
                    this_SetScope_2=ruleSetScope();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_SetScope_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 4 :
                    // InternalVLang.g:950:4: this_InfiniteScope_3= ruleInfiniteScope
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getFunctionScopeAccess().getInfiniteScopeParserRuleCall_0_3());
                      			
                    }
                    pushFollow(FOLLOW_24);
                    this_InfiniteScope_3=ruleInfiniteScope();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_InfiniteScope_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalVLang.g:962:3: (otherlv_4= 'with' ( (lv_filter_5_0= ruleFilter ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalVLang.g:963:4: otherlv_4= 'with' ( (lv_filter_5_0= ruleFilter ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getFunctionScopeAccess().getWithKeyword_1_0());
                      			
                    }
                    // InternalVLang.g:967:4: ( (lv_filter_5_0= ruleFilter ) )
                    // InternalVLang.g:968:5: (lv_filter_5_0= ruleFilter )
                    {
                    // InternalVLang.g:968:5: (lv_filter_5_0= ruleFilter )
                    // InternalVLang.g:969:6: lv_filter_5_0= ruleFilter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionScopeAccess().getFilterFilterParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_filter_5_0=ruleFilter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionScopeRule());
                      						}
                      						set(
                      							current,
                      							"filter",
                      							lv_filter_5_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.Filter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionScope"


    // $ANTLR start "entryRuleInfiniteScope"
    // InternalVLang.g:991:1: entryRuleInfiniteScope returns [EObject current=null] : iv_ruleInfiniteScope= ruleInfiniteScope EOF ;
    public final EObject entryRuleInfiniteScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfiniteScope = null;


        try {
            // InternalVLang.g:991:54: (iv_ruleInfiniteScope= ruleInfiniteScope EOF )
            // InternalVLang.g:992:2: iv_ruleInfiniteScope= ruleInfiniteScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfiniteScopeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInfiniteScope=ruleInfiniteScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfiniteScope; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfiniteScope"


    // $ANTLR start "ruleInfiniteScope"
    // InternalVLang.g:998:1: ruleInfiniteScope returns [EObject current=null] : ( () otherlv_1= 'all' ) ;
    public final EObject ruleInfiniteScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalVLang.g:1004:2: ( ( () otherlv_1= 'all' ) )
            // InternalVLang.g:1005:2: ( () otherlv_1= 'all' )
            {
            // InternalVLang.g:1005:2: ( () otherlv_1= 'all' )
            // InternalVLang.g:1006:3: () otherlv_1= 'all'
            {
            // InternalVLang.g:1006:3: ()
            // InternalVLang.g:1007:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInfiniteScopeAccess().getInfiniteScopeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInfiniteScopeAccess().getAllKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfiniteScope"


    // $ANTLR start "entryRuleFilter"
    // InternalVLang.g:1024:1: entryRuleFilter returns [EObject current=null] : iv_ruleFilter= ruleFilter EOF ;
    public final EObject entryRuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilter = null;


        try {
            // InternalVLang.g:1024:47: (iv_ruleFilter= ruleFilter EOF )
            // InternalVLang.g:1025:2: iv_ruleFilter= ruleFilter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFilterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFilter=ruleFilter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFilter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFilter"


    // $ANTLR start "ruleFilter"
    // InternalVLang.g:1031:1: ruleFilter returns [EObject current=null] : this_FunctionAssignment_0= ruleFunctionAssignment ;
    public final EObject ruleFilter() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionAssignment_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1037:2: (this_FunctionAssignment_0= ruleFunctionAssignment )
            // InternalVLang.g:1038:2: this_FunctionAssignment_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getFilterAccess().getFunctionAssignmentParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_FunctionAssignment_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_FunctionAssignment_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilter"


    // $ANTLR start "entryRuleFunctionDomainScope"
    // InternalVLang.g:1052:1: entryRuleFunctionDomainScope returns [EObject current=null] : iv_ruleFunctionDomainScope= ruleFunctionDomainScope EOF ;
    public final EObject entryRuleFunctionDomainScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDomainScope = null;


        try {
            // InternalVLang.g:1052:60: (iv_ruleFunctionDomainScope= ruleFunctionDomainScope EOF )
            // InternalVLang.g:1053:2: iv_ruleFunctionDomainScope= ruleFunctionDomainScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDomainScopeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDomainScope=ruleFunctionDomainScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDomainScope; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDomainScope"


    // $ANTLR start "ruleFunctionDomainScope"
    // InternalVLang.g:1059:1: ruleFunctionDomainScope returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleFunctionDomainScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalVLang.g:1065:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalVLang.g:1066:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalVLang.g:1066:2: (otherlv_0= '@' ( (otherlv_1= RULE_ID ) ) )
            // InternalVLang.g:1067:3: otherlv_0= '@' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFunctionDomainScopeAccess().getCommercialAtKeyword_0());
              		
            }
            // InternalVLang.g:1071:3: ( (otherlv_1= RULE_ID ) )
            // InternalVLang.g:1072:4: (otherlv_1= RULE_ID )
            {
            // InternalVLang.g:1072:4: (otherlv_1= RULE_ID )
            // InternalVLang.g:1073:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionDomainScopeRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getFunctionDomainScopeAccess().getFunctionFunctionDefCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDomainScope"


    // $ANTLR start "entryRuleSetScope"
    // InternalVLang.g:1091:1: entryRuleSetScope returns [EObject current=null] : iv_ruleSetScope= ruleSetScope EOF ;
    public final EObject entryRuleSetScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetScope = null;


        try {
            // InternalVLang.g:1091:49: (iv_ruleSetScope= ruleSetScope EOF )
            // InternalVLang.g:1092:2: iv_ruleSetScope= ruleSetScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetScopeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetScope=ruleSetScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetScope; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetScope"


    // $ANTLR start "ruleSetScope"
    // InternalVLang.g:1098:1: ruleSetScope returns [EObject current=null] : (otherlv_0= '&' ( ( (otherlv_1= RULE_ID ) ) | ( (lv_set_2_0= ruleSetLiteral ) ) ) ) ;
    public final EObject ruleSetScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_set_2_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1104:2: ( (otherlv_0= '&' ( ( (otherlv_1= RULE_ID ) ) | ( (lv_set_2_0= ruleSetLiteral ) ) ) ) )
            // InternalVLang.g:1105:2: (otherlv_0= '&' ( ( (otherlv_1= RULE_ID ) ) | ( (lv_set_2_0= ruleSetLiteral ) ) ) )
            {
            // InternalVLang.g:1105:2: (otherlv_0= '&' ( ( (otherlv_1= RULE_ID ) ) | ( (lv_set_2_0= ruleSetLiteral ) ) ) )
            // InternalVLang.g:1106:3: otherlv_0= '&' ( ( (otherlv_1= RULE_ID ) ) | ( (lv_set_2_0= ruleSetLiteral ) ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSetScopeAccess().getAmpersandKeyword_0());
              		
            }
            // InternalVLang.g:1110:3: ( ( (otherlv_1= RULE_ID ) ) | ( (lv_set_2_0= ruleSetLiteral ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            else if ( (LA13_0==20) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalVLang.g:1111:4: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalVLang.g:1111:4: ( (otherlv_1= RULE_ID ) )
                    // InternalVLang.g:1112:5: (otherlv_1= RULE_ID )
                    {
                    // InternalVLang.g:1112:5: (otherlv_1= RULE_ID )
                    // InternalVLang.g:1113:6: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSetScopeRule());
                      						}
                      					
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_1, grammarAccess.getSetScopeAccess().getSetRefSetDefCrossReference_1_0_0());
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVLang.g:1128:4: ( (lv_set_2_0= ruleSetLiteral ) )
                    {
                    // InternalVLang.g:1128:4: ( (lv_set_2_0= ruleSetLiteral ) )
                    // InternalVLang.g:1129:5: (lv_set_2_0= ruleSetLiteral )
                    {
                    // InternalVLang.g:1129:5: (lv_set_2_0= ruleSetLiteral )
                    // InternalVLang.g:1130:6: lv_set_2_0= ruleSetLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSetScopeAccess().getSetSetLiteralParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_set_2_0=ruleSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSetScopeRule());
                      						}
                      						set(
                      							current,
                      							"set",
                      							lv_set_2_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.SetLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetScope"


    // $ANTLR start "entryRuleSingleScope"
    // InternalVLang.g:1152:1: entryRuleSingleScope returns [EObject current=null] : iv_ruleSingleScope= ruleSingleScope EOF ;
    public final EObject entryRuleSingleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleScope = null;


        try {
            // InternalVLang.g:1152:52: (iv_ruleSingleScope= ruleSingleScope EOF )
            // InternalVLang.g:1153:2: iv_ruleSingleScope= ruleSingleScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSingleScopeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSingleScope=ruleSingleScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSingleScope; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleScope"


    // $ANTLR start "ruleSingleScope"
    // InternalVLang.g:1159:1: ruleSingleScope returns [EObject current=null] : ( (lv_value_0_0= ruleSingleValue ) ) ;
    public final EObject ruleSingleScope() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1165:2: ( ( (lv_value_0_0= ruleSingleValue ) ) )
            // InternalVLang.g:1166:2: ( (lv_value_0_0= ruleSingleValue ) )
            {
            // InternalVLang.g:1166:2: ( (lv_value_0_0= ruleSingleValue ) )
            // InternalVLang.g:1167:3: (lv_value_0_0= ruleSingleValue )
            {
            // InternalVLang.g:1167:3: (lv_value_0_0= ruleSingleValue )
            // InternalVLang.g:1168:4: lv_value_0_0= ruleSingleValue
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getSingleScopeAccess().getValueSingleValueParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleSingleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getSingleScopeRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"at.ac.tuwien.big.virtmodel.VLang.SingleValue");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleScope"


    // $ANTLR start "entryRuleSingleValue"
    // InternalVLang.g:1188:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // InternalVLang.g:1188:52: (iv_ruleSingleValue= ruleSingleValue EOF )
            // InternalVLang.g:1189:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSingleValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSingleValue=ruleSingleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSingleValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleValue"


    // $ANTLR start "ruleSingleValue"
    // InternalVLang.g:1195:1: ruleSingleValue returns [EObject current=null] : (this_FixedValue_0= ruleFixedValue | this_CalculatedValue_1= ruleCalculatedValue ) ;
    public final EObject ruleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject this_FixedValue_0 = null;

        EObject this_CalculatedValue_1 = null;



        	enterRule();

        try {
            // InternalVLang.g:1201:2: ( (this_FixedValue_0= ruleFixedValue | this_CalculatedValue_1= ruleCalculatedValue ) )
            // InternalVLang.g:1202:2: (this_FixedValue_0= ruleFixedValue | this_CalculatedValue_1= ruleCalculatedValue )
            {
            // InternalVLang.g:1202:2: (this_FixedValue_0= ruleFixedValue | this_CalculatedValue_1= ruleCalculatedValue )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_INT && LA14_0<=RULE_STRING)||LA14_0==42) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID||LA14_0==35) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalVLang.g:1203:3: this_FixedValue_0= ruleFixedValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSingleValueAccess().getFixedValueParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FixedValue_0=ruleFixedValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FixedValue_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVLang.g:1215:3: this_CalculatedValue_1= ruleCalculatedValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSingleValueAccess().getCalculatedValueParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CalculatedValue_1=ruleCalculatedValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CalculatedValue_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleValue"


    // $ANTLR start "entryRuleFixedValue"
    // InternalVLang.g:1230:1: entryRuleFixedValue returns [EObject current=null] : iv_ruleFixedValue= ruleFixedValue EOF ;
    public final EObject entryRuleFixedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedValue = null;


        try {
            // InternalVLang.g:1230:51: (iv_ruleFixedValue= ruleFixedValue EOF )
            // InternalVLang.g:1231:2: iv_ruleFixedValue= ruleFixedValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFixedValue=ruleFixedValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFixedValue"


    // $ANTLR start "ruleFixedValue"
    // InternalVLang.g:1237:1: ruleFixedValue returns [EObject current=null] : ( ( (lv_number_0_0= RULE_INT ) ) | ( (lv_string_1_0= RULE_STRING ) ) | ( (lv_objid_2_0= ruleObjId ) ) ) ;
    public final EObject ruleFixedValue() throws RecognitionException {
        EObject current = null;

        Token lv_number_0_0=null;
        Token lv_string_1_0=null;
        EObject lv_objid_2_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1243:2: ( ( ( (lv_number_0_0= RULE_INT ) ) | ( (lv_string_1_0= RULE_STRING ) ) | ( (lv_objid_2_0= ruleObjId ) ) ) )
            // InternalVLang.g:1244:2: ( ( (lv_number_0_0= RULE_INT ) ) | ( (lv_string_1_0= RULE_STRING ) ) | ( (lv_objid_2_0= ruleObjId ) ) )
            {
            // InternalVLang.g:1244:2: ( ( (lv_number_0_0= RULE_INT ) ) | ( (lv_string_1_0= RULE_STRING ) ) | ( (lv_objid_2_0= ruleObjId ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt15=1;
                }
                break;
            case RULE_STRING:
                {
                alt15=2;
                }
                break;
            case 42:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalVLang.g:1245:3: ( (lv_number_0_0= RULE_INT ) )
                    {
                    // InternalVLang.g:1245:3: ( (lv_number_0_0= RULE_INT ) )
                    // InternalVLang.g:1246:4: (lv_number_0_0= RULE_INT )
                    {
                    // InternalVLang.g:1246:4: (lv_number_0_0= RULE_INT )
                    // InternalVLang.g:1247:5: lv_number_0_0= RULE_INT
                    {
                    lv_number_0_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_number_0_0, grammarAccess.getFixedValueAccess().getNumberINTTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFixedValueRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"number",
                      						lv_number_0_0,
                      						"org.eclipse.xtext.common.Terminals.INT");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVLang.g:1264:3: ( (lv_string_1_0= RULE_STRING ) )
                    {
                    // InternalVLang.g:1264:3: ( (lv_string_1_0= RULE_STRING ) )
                    // InternalVLang.g:1265:4: (lv_string_1_0= RULE_STRING )
                    {
                    // InternalVLang.g:1265:4: (lv_string_1_0= RULE_STRING )
                    // InternalVLang.g:1266:5: lv_string_1_0= RULE_STRING
                    {
                    lv_string_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_string_1_0, grammarAccess.getFixedValueAccess().getStringSTRINGTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFixedValueRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"string",
                      						lv_string_1_0,
                      						"org.eclipse.xtext.common.Terminals.STRING");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalVLang.g:1283:3: ( (lv_objid_2_0= ruleObjId ) )
                    {
                    // InternalVLang.g:1283:3: ( (lv_objid_2_0= ruleObjId ) )
                    // InternalVLang.g:1284:4: (lv_objid_2_0= ruleObjId )
                    {
                    // InternalVLang.g:1284:4: (lv_objid_2_0= ruleObjId )
                    // InternalVLang.g:1285:5: lv_objid_2_0= ruleObjId
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFixedValueAccess().getObjidObjIdParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_objid_2_0=ruleObjId();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFixedValueRule());
                      					}
                      					set(
                      						current,
                      						"objid",
                      						lv_objid_2_0,
                      						"at.ac.tuwien.big.virtmodel.VLang.ObjId");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFixedValue"


    // $ANTLR start "entryRuleFunctionAssignment"
    // InternalVLang.g:1306:1: entryRuleFunctionAssignment returns [EObject current=null] : iv_ruleFunctionAssignment= ruleFunctionAssignment EOF ;
    public final EObject entryRuleFunctionAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionAssignment = null;


        try {
            // InternalVLang.g:1306:59: (iv_ruleFunctionAssignment= ruleFunctionAssignment EOF )
            // InternalVLang.g:1307:2: iv_ruleFunctionAssignment= ruleFunctionAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionAssignment=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionAssignment"


    // $ANTLR start "ruleFunctionAssignment"
    // InternalVLang.g:1313:1: ruleFunctionAssignment returns [EObject current=null] : (this_FullFunctionAssignment_0= ruleFullFunctionAssignment | this_Expression_1= ruleExpression ) ;
    public final EObject ruleFunctionAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_FullFunctionAssignment_0 = null;

        EObject this_Expression_1 = null;



        	enterRule();

        try {
            // InternalVLang.g:1319:2: ( (this_FullFunctionAssignment_0= ruleFullFunctionAssignment | this_Expression_1= ruleExpression ) )
            // InternalVLang.g:1320:2: (this_FullFunctionAssignment_0= ruleFullFunctionAssignment | this_Expression_1= ruleExpression )
            {
            // InternalVLang.g:1320:2: (this_FullFunctionAssignment_0= ruleFullFunctionAssignment | this_Expression_1= ruleExpression )
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalVLang.g:1321:3: this_FullFunctionAssignment_0= ruleFullFunctionAssignment
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAssignmentAccess().getFullFunctionAssignmentParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FullFunctionAssignment_0=ruleFullFunctionAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FullFunctionAssignment_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVLang.g:1333:3: this_Expression_1= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAssignmentAccess().getExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Expression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionAssignment"


    // $ANTLR start "entryRuleFullFunctionAssignment"
    // InternalVLang.g:1348:1: entryRuleFullFunctionAssignment returns [EObject current=null] : iv_ruleFullFunctionAssignment= ruleFullFunctionAssignment EOF ;
    public final EObject entryRuleFullFunctionAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullFunctionAssignment = null;


        try {
            // InternalVLang.g:1348:63: (iv_ruleFullFunctionAssignment= ruleFullFunctionAssignment EOF )
            // InternalVLang.g:1349:2: iv_ruleFullFunctionAssignment= ruleFullFunctionAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullFunctionAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFullFunctionAssignment=ruleFullFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullFunctionAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFullFunctionAssignment"


    // $ANTLR start "ruleFullFunctionAssignment"
    // InternalVLang.g:1355:1: ruleFullFunctionAssignment returns [EObject current=null] : ( ( ( (lv_parameters_0_0= ruleParDef ) ) otherlv_1= '->' )? ( (lv_expr_2_0= ruleExpression ) ) ) ;
    public final EObject ruleFullFunctionAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_parameters_0_0 = null;

        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1361:2: ( ( ( ( (lv_parameters_0_0= ruleParDef ) ) otherlv_1= '->' )? ( (lv_expr_2_0= ruleExpression ) ) ) )
            // InternalVLang.g:1362:2: ( ( ( (lv_parameters_0_0= ruleParDef ) ) otherlv_1= '->' )? ( (lv_expr_2_0= ruleExpression ) ) )
            {
            // InternalVLang.g:1362:2: ( ( ( (lv_parameters_0_0= ruleParDef ) ) otherlv_1= '->' )? ( (lv_expr_2_0= ruleExpression ) ) )
            // InternalVLang.g:1363:3: ( ( (lv_parameters_0_0= ruleParDef ) ) otherlv_1= '->' )? ( (lv_expr_2_0= ruleExpression ) )
            {
            // InternalVLang.g:1363:3: ( ( (lv_parameters_0_0= ruleParDef ) ) otherlv_1= '->' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalVLang.g:1364:4: ( (lv_parameters_0_0= ruleParDef ) ) otherlv_1= '->'
                    {
                    // InternalVLang.g:1364:4: ( (lv_parameters_0_0= ruleParDef ) )
                    // InternalVLang.g:1365:5: (lv_parameters_0_0= ruleParDef )
                    {
                    // InternalVLang.g:1365:5: (lv_parameters_0_0= ruleParDef )
                    // InternalVLang.g:1366:6: lv_parameters_0_0= ruleParDef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFullFunctionAssignmentAccess().getParametersParDefParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_parameters_0_0=ruleParDef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFullFunctionAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"parameters",
                      							lv_parameters_0_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.ParDef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getFullFunctionAssignmentAccess().getHyphenMinusGreaterThanSignKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalVLang.g:1388:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalVLang.g:1389:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalVLang.g:1389:4: (lv_expr_2_0= ruleExpression )
            // InternalVLang.g:1390:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFullFunctionAssignmentAccess().getExprExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFullFunctionAssignmentRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"at.ac.tuwien.big.virtmodel.VLang.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFullFunctionAssignment"


    // $ANTLR start "entryRuleExpression"
    // InternalVLang.g:1411:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalVLang.g:1411:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalVLang.g:1412:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalVLang.g:1418:1: ruleExpression returns [EObject current=null] : (this_SingleValue_0= ruleSingleValue | this_FullFunction_1= ruleFullFunction | this_OclFunction_2= ruleOclFunction ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SingleValue_0 = null;

        EObject this_FullFunction_1 = null;

        EObject this_OclFunction_2 = null;



        	enterRule();

        try {
            // InternalVLang.g:1424:2: ( (this_SingleValue_0= ruleSingleValue | this_FullFunction_1= ruleFullFunction | this_OclFunction_2= ruleOclFunction ) )
            // InternalVLang.g:1425:2: (this_SingleValue_0= ruleSingleValue | this_FullFunction_1= ruleFullFunction | this_OclFunction_2= ruleOclFunction )
            {
            // InternalVLang.g:1425:2: (this_SingleValue_0= ruleSingleValue | this_FullFunction_1= ruleFullFunction | this_OclFunction_2= ruleOclFunction )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 35:
            case 42:
                {
                alt18=1;
                }
                break;
            case 20:
                {
                alt18=2;
                }
                break;
            case 32:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalVLang.g:1426:3: this_SingleValue_0= ruleSingleValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getSingleValueParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SingleValue_0=ruleSingleValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SingleValue_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVLang.g:1438:3: this_FullFunction_1= ruleFullFunction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getFullFunctionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FullFunction_1=ruleFullFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FullFunction_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalVLang.g:1450:3: this_OclFunction_2= ruleOclFunction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getOclFunctionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_OclFunction_2=ruleOclFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OclFunction_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOclFunction"
    // InternalVLang.g:1465:1: entryRuleOclFunction returns [EObject current=null] : iv_ruleOclFunction= ruleOclFunction EOF ;
    public final EObject entryRuleOclFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclFunction = null;


        try {
            // InternalVLang.g:1465:52: (iv_ruleOclFunction= ruleOclFunction EOF )
            // InternalVLang.g:1466:2: iv_ruleOclFunction= ruleOclFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOclFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOclFunction=ruleOclFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOclFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOclFunction"


    // $ANTLR start "ruleOclFunction"
    // InternalVLang.g:1472:1: ruleOclFunction returns [EObject current=null] : (otherlv_0= 'ocl' ( (lv_oclFunc_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleOclFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_oclFunc_1_0=null;


        	enterRule();

        try {
            // InternalVLang.g:1478:2: ( (otherlv_0= 'ocl' ( (lv_oclFunc_1_0= RULE_STRING ) ) ) )
            // InternalVLang.g:1479:2: (otherlv_0= 'ocl' ( (lv_oclFunc_1_0= RULE_STRING ) ) )
            {
            // InternalVLang.g:1479:2: (otherlv_0= 'ocl' ( (lv_oclFunc_1_0= RULE_STRING ) ) )
            // InternalVLang.g:1480:3: otherlv_0= 'ocl' ( (lv_oclFunc_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getOclFunctionAccess().getOclKeyword_0());
              		
            }
            // InternalVLang.g:1484:3: ( (lv_oclFunc_1_0= RULE_STRING ) )
            // InternalVLang.g:1485:4: (lv_oclFunc_1_0= RULE_STRING )
            {
            // InternalVLang.g:1485:4: (lv_oclFunc_1_0= RULE_STRING )
            // InternalVLang.g:1486:5: lv_oclFunc_1_0= RULE_STRING
            {
            lv_oclFunc_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_oclFunc_1_0, grammarAccess.getOclFunctionAccess().getOclFuncSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOclFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"oclFunc",
              						lv_oclFunc_1_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOclFunction"


    // $ANTLR start "entryRuleFullFunction"
    // InternalVLang.g:1506:1: entryRuleFullFunction returns [EObject current=null] : iv_ruleFullFunction= ruleFullFunction EOF ;
    public final EObject entryRuleFullFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullFunction = null;


        try {
            // InternalVLang.g:1506:53: (iv_ruleFullFunction= ruleFullFunction EOF )
            // InternalVLang.g:1507:2: iv_ruleFullFunction= ruleFullFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFullFunction=ruleFullFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFullFunction"


    // $ANTLR start "ruleFullFunction"
    // InternalVLang.g:1513:1: ruleFullFunction returns [EObject current=null] : this_Block_0= ruleBlock ;
    public final EObject ruleFullFunction() throws RecognitionException {
        EObject current = null;

        EObject this_Block_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1519:2: (this_Block_0= ruleBlock )
            // InternalVLang.g:1520:2: this_Block_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getFullFunctionAccess().getBlockParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_Block_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Block_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFullFunction"


    // $ANTLR start "entryRuleBlock"
    // InternalVLang.g:1534:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalVLang.g:1534:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalVLang.g:1535:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalVLang.g:1541:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' ) | ( (lv_statements_4_0= ruleBlock ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_statements_2_0 = null;

        EObject lv_statements_4_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1547:2: ( ( () otherlv_1= '{' ( ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' ) | ( (lv_statements_4_0= ruleBlock ) ) )* otherlv_5= '}' ) )
            // InternalVLang.g:1548:2: ( () otherlv_1= '{' ( ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' ) | ( (lv_statements_4_0= ruleBlock ) ) )* otherlv_5= '}' )
            {
            // InternalVLang.g:1548:2: ( () otherlv_1= '{' ( ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' ) | ( (lv_statements_4_0= ruleBlock ) ) )* otherlv_5= '}' )
            // InternalVLang.g:1549:3: () otherlv_1= '{' ( ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' ) | ( (lv_statements_4_0= ruleBlock ) ) )* otherlv_5= '}'
            {
            // InternalVLang.g:1549:3: ()
            // InternalVLang.g:1550:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalVLang.g:1563:3: ( ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' ) | ( (lv_statements_4_0= ruleBlock ) ) )*
            loop19:
            do {
                int alt19=3;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=33 && LA19_0<=35)||LA19_0==37) ) {
                    alt19=1;
                }
                else if ( (LA19_0==20) ) {
                    int LA19_3 = input.LA(2);

                    if ( (synpred27_InternalVLang()) ) {
                        alt19=1;
                    }
                    else if ( (synpred28_InternalVLang()) ) {
                        alt19=2;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // InternalVLang.g:1564:4: ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' )
            	    {
            	    // InternalVLang.g:1564:4: ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' )
            	    // InternalVLang.g:1565:5: ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';'
            	    {
            	    // InternalVLang.g:1565:5: ( (lv_statements_2_0= ruleSingleStatement ) )
            	    // InternalVLang.g:1566:6: (lv_statements_2_0= ruleSingleStatement )
            	    {
            	    // InternalVLang.g:1566:6: (lv_statements_2_0= ruleSingleStatement )
            	    // InternalVLang.g:1567:7: lv_statements_2_0= ruleSingleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getBlockAccess().getStatementsSingleStatementParserRuleCall_2_0_0_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_statements_2_0=ruleSingleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getBlockRule());
            	      							}
            	      							add(
            	      								current,
            	      								"statements",
            	      								lv_statements_2_0,
            	      								"at.ac.tuwien.big.virtmodel.VLang.SingleStatement");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,13,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getSemicolonKeyword_2_0_1());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalVLang.g:1590:4: ( (lv_statements_4_0= ruleBlock ) )
            	    {
            	    // InternalVLang.g:1590:4: ( (lv_statements_4_0= ruleBlock ) )
            	    // InternalVLang.g:1591:5: (lv_statements_4_0= ruleBlock )
            	    {
            	    // InternalVLang.g:1591:5: (lv_statements_4_0= ruleBlock )
            	    // InternalVLang.g:1592:6: lv_statements_4_0= ruleBlock
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockAccess().getStatementsBlockParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_statements_4_0=ruleBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBlockRule());
            	      						}
            	      						add(
            	      							current,
            	      							"statements",
            	      							lv_statements_4_0,
            	      							"at.ac.tuwien.big.virtmodel.VLang.Block");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleSingleStatement"
    // InternalVLang.g:1618:1: entryRuleSingleStatement returns [EObject current=null] : iv_ruleSingleStatement= ruleSingleStatement EOF ;
    public final EObject entryRuleSingleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleStatement = null;


        try {
            // InternalVLang.g:1618:56: (iv_ruleSingleStatement= ruleSingleStatement EOF )
            // InternalVLang.g:1619:2: iv_ruleSingleStatement= ruleSingleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSingleStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSingleStatement=ruleSingleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSingleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleStatement"


    // $ANTLR start "ruleSingleStatement"
    // InternalVLang.g:1625:1: ruleSingleStatement returns [EObject current=null] : (this_LetStatement_0= ruleLetStatement | this_Block_1= ruleBlock | this_ReturnStatement_2= ruleReturnStatement | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForLoopStatement_5= ruleForLoopStatement ) ;
    public final EObject ruleSingleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_LetStatement_0 = null;

        EObject this_Block_1 = null;

        EObject this_ReturnStatement_2 = null;

        EObject this_IfStatement_3 = null;

        EObject this_ForStatement_4 = null;

        EObject this_ForLoopStatement_5 = null;



        	enterRule();

        try {
            // InternalVLang.g:1631:2: ( (this_LetStatement_0= ruleLetStatement | this_Block_1= ruleBlock | this_ReturnStatement_2= ruleReturnStatement | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForLoopStatement_5= ruleForLoopStatement ) )
            // InternalVLang.g:1632:2: (this_LetStatement_0= ruleLetStatement | this_Block_1= ruleBlock | this_ReturnStatement_2= ruleReturnStatement | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForLoopStatement_5= ruleForLoopStatement )
            {
            // InternalVLang.g:1632:2: (this_LetStatement_0= ruleLetStatement | this_Block_1= ruleBlock | this_ReturnStatement_2= ruleReturnStatement | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForLoopStatement_5= ruleForLoopStatement )
            int alt20=6;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt20=1;
                }
                break;
            case 20:
                {
                alt20=2;
                }
                break;
            case 34:
                {
                alt20=3;
                }
                break;
            case 35:
                {
                alt20=4;
                }
                break;
            case 37:
                {
                int LA20_5 = input.LA(2);

                if ( (LA20_5==23) ) {
                    int LA20_6 = input.LA(3);

                    if ( (LA20_6==RULE_ID) ) {
                        alt20=6;
                    }
                    else if ( (LA20_6==20||(LA20_6>=33 && LA20_6<=35)||LA20_6==37) ) {
                        alt20=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalVLang.g:1633:3: this_LetStatement_0= ruleLetStatement
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSingleStatementAccess().getLetStatementParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LetStatement_0=ruleLetStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LetStatement_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVLang.g:1645:3: this_Block_1= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSingleStatementAccess().getBlockParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Block_1=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Block_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalVLang.g:1657:3: this_ReturnStatement_2= ruleReturnStatement
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSingleStatementAccess().getReturnStatementParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ReturnStatement_2=ruleReturnStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ReturnStatement_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalVLang.g:1669:3: this_IfStatement_3= ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSingleStatementAccess().getIfStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfStatement_3=ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfStatement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalVLang.g:1681:3: this_ForStatement_4= ruleForStatement
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSingleStatementAccess().getForStatementParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ForStatement_4=ruleForStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ForStatement_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalVLang.g:1693:3: this_ForLoopStatement_5= ruleForLoopStatement
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSingleStatementAccess().getForLoopStatementParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ForLoopStatement_5=ruleForLoopStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ForLoopStatement_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleStatement"


    // $ANTLR start "entryRuleLetStatement"
    // InternalVLang.g:1708:1: entryRuleLetStatement returns [EObject current=null] : iv_ruleLetStatement= ruleLetStatement EOF ;
    public final EObject entryRuleLetStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetStatement = null;


        try {
            // InternalVLang.g:1708:53: (iv_ruleLetStatement= ruleLetStatement EOF )
            // InternalVLang.g:1709:2: iv_ruleLetStatement= ruleLetStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLetStatement=ruleLetStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetStatement"


    // $ANTLR start "ruleLetStatement"
    // InternalVLang.g:1715:1: ruleLetStatement returns [EObject current=null] : (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) (this_MaybeValue_2= ruleMaybeValue[$current] )? ) ;
    public final EObject ruleLetStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject this_MaybeValue_2 = null;



        	enterRule();

        try {
            // InternalVLang.g:1721:2: ( (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) (this_MaybeValue_2= ruleMaybeValue[$current] )? ) )
            // InternalVLang.g:1722:2: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) (this_MaybeValue_2= ruleMaybeValue[$current] )? )
            {
            // InternalVLang.g:1722:2: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) (this_MaybeValue_2= ruleMaybeValue[$current] )? )
            // InternalVLang.g:1723:3: otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) (this_MaybeValue_2= ruleMaybeValue[$current] )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLetStatementAccess().getLetKeyword_0());
              		
            }
            // InternalVLang.g:1727:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalVLang.g:1728:4: (lv_name_1_0= RULE_ID )
            {
            // InternalVLang.g:1728:4: (lv_name_1_0= RULE_ID )
            // InternalVLang.g:1729:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getLetStatementAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLetStatementRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalVLang.g:1745:3: (this_MaybeValue_2= ruleMaybeValue[$current] )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalVLang.g:1746:4: this_MaybeValue_2= ruleMaybeValue[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getLetStatementRule());
                      				}
                      				newCompositeNode(grammarAccess.getLetStatementAccess().getMaybeValueParserRuleCall_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_MaybeValue_2=ruleMaybeValue(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_MaybeValue_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // InternalVLang.g:1765:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // InternalVLang.g:1765:56: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // InternalVLang.g:1766:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReturnStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReturnStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturnStatement"


    // $ANTLR start "ruleReturnStatement"
    // InternalVLang.g:1772:1: ruleReturnStatement returns [EObject current=null] : (otherlv_0= 'return' this_MaybeValue_1= ruleMaybeValue[$current] ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_MaybeValue_1 = null;



        	enterRule();

        try {
            // InternalVLang.g:1778:2: ( (otherlv_0= 'return' this_MaybeValue_1= ruleMaybeValue[$current] ) )
            // InternalVLang.g:1779:2: (otherlv_0= 'return' this_MaybeValue_1= ruleMaybeValue[$current] )
            {
            // InternalVLang.g:1779:2: (otherlv_0= 'return' this_MaybeValue_1= ruleMaybeValue[$current] )
            // InternalVLang.g:1780:3: otherlv_0= 'return' this_MaybeValue_1= ruleMaybeValue[$current]
            {
            otherlv_0=(Token)match(input,34,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getReturnStatementAccess().getReturnKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getReturnStatementRule());
              			}
              			newCompositeNode(grammarAccess.getReturnStatementAccess().getMaybeValueParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            this_MaybeValue_1=ruleMaybeValue(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MaybeValue_1;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturnStatement"


    // $ANTLR start "entryRuleIfStatement"
    // InternalVLang.g:1802:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalVLang.g:1802:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalVLang.g:1803:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalVLang.g:1809:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleFunctionAssignment ) ) otherlv_3= ')' ( (lv_thenStatement_4_0= ruleSingleStatement ) ) (otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_condition_2_0 = null;

        EObject lv_thenStatement_4_0 = null;

        EObject lv_elseStatement_6_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1815:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleFunctionAssignment ) ) otherlv_3= ')' ( (lv_thenStatement_4_0= ruleSingleStatement ) ) (otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) ) )? ) )
            // InternalVLang.g:1816:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleFunctionAssignment ) ) otherlv_3= ')' ( (lv_thenStatement_4_0= ruleSingleStatement ) ) (otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) ) )? )
            {
            // InternalVLang.g:1816:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleFunctionAssignment ) ) otherlv_3= ')' ( (lv_thenStatement_4_0= ruleSingleStatement ) ) (otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) ) )? )
            // InternalVLang.g:1817:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleFunctionAssignment ) ) otherlv_3= ')' ( (lv_thenStatement_4_0= ruleSingleStatement ) ) (otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVLang.g:1825:3: ( (lv_condition_2_0= ruleFunctionAssignment ) )
            // InternalVLang.g:1826:4: (lv_condition_2_0= ruleFunctionAssignment )
            {
            // InternalVLang.g:1826:4: (lv_condition_2_0= ruleFunctionAssignment )
            // InternalVLang.g:1827:5: lv_condition_2_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getConditionFunctionAssignmentParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_condition_2_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_2_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalVLang.g:1848:3: ( (lv_thenStatement_4_0= ruleSingleStatement ) )
            // InternalVLang.g:1849:4: (lv_thenStatement_4_0= ruleSingleStatement )
            {
            // InternalVLang.g:1849:4: (lv_thenStatement_4_0= ruleSingleStatement )
            // InternalVLang.g:1850:5: lv_thenStatement_4_0= ruleSingleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getThenStatementSingleStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_thenStatement_4_0=ruleSingleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"thenStatement",
              						lv_thenStatement_4_0,
              						"at.ac.tuwien.big.virtmodel.VLang.SingleStatement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVLang.g:1867:3: (otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36) ) {
                int LA22_1 = input.LA(2);

                if ( (synpred35_InternalVLang()) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalVLang.g:1868:4: otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) )
                    {
                    otherlv_5=(Token)match(input,36,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getIfStatementAccess().getElseKeyword_5_0());
                      			
                    }
                    // InternalVLang.g:1872:4: ( (lv_elseStatement_6_0= ruleSingleStatement ) )
                    // InternalVLang.g:1873:5: (lv_elseStatement_6_0= ruleSingleStatement )
                    {
                    // InternalVLang.g:1873:5: (lv_elseStatement_6_0= ruleSingleStatement )
                    // InternalVLang.g:1874:6: lv_elseStatement_6_0= ruleSingleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfStatementAccess().getElseStatementSingleStatementParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_elseStatement_6_0=ruleSingleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfStatementRule());
                      						}
                      						set(
                      							current,
                      							"elseStatement",
                      							lv_elseStatement_6_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.SingleStatement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleForStatement"
    // InternalVLang.g:1896:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalVLang.g:1896:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalVLang.g:1897:2: iv_ruleForStatement= ruleForStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForStatement=ruleForStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForStatement"


    // $ANTLR start "ruleForStatement"
    // InternalVLang.g:1903:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_initVar_2_0= ruleSingleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleFunctionAssignment ) ) otherlv_5= ';' ( (lv_endProcessing_6_0= ruleSingleStatement ) ) otherlv_7= ')' ( (lv_loopExpr_8_0= ruleSingleStatement ) ) ) ;
    public final EObject ruleForStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_initVar_2_0 = null;

        EObject lv_condition_4_0 = null;

        EObject lv_endProcessing_6_0 = null;

        EObject lv_loopExpr_8_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:1909:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_initVar_2_0= ruleSingleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleFunctionAssignment ) ) otherlv_5= ';' ( (lv_endProcessing_6_0= ruleSingleStatement ) ) otherlv_7= ')' ( (lv_loopExpr_8_0= ruleSingleStatement ) ) ) )
            // InternalVLang.g:1910:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_initVar_2_0= ruleSingleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleFunctionAssignment ) ) otherlv_5= ';' ( (lv_endProcessing_6_0= ruleSingleStatement ) ) otherlv_7= ')' ( (lv_loopExpr_8_0= ruleSingleStatement ) ) )
            {
            // InternalVLang.g:1910:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_initVar_2_0= ruleSingleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleFunctionAssignment ) ) otherlv_5= ';' ( (lv_endProcessing_6_0= ruleSingleStatement ) ) otherlv_7= ')' ( (lv_loopExpr_8_0= ruleSingleStatement ) ) )
            // InternalVLang.g:1911:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_initVar_2_0= ruleSingleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleFunctionAssignment ) ) otherlv_5= ';' ( (lv_endProcessing_6_0= ruleSingleStatement ) ) otherlv_7= ')' ( (lv_loopExpr_8_0= ruleSingleStatement ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,23,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVLang.g:1919:3: ( (lv_initVar_2_0= ruleSingleStatement ) )
            // InternalVLang.g:1920:4: (lv_initVar_2_0= ruleSingleStatement )
            {
            // InternalVLang.g:1920:4: (lv_initVar_2_0= ruleSingleStatement )
            // InternalVLang.g:1921:5: lv_initVar_2_0= ruleSingleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementAccess().getInitVarSingleStatementParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_initVar_2_0=ruleSingleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRule());
              					}
              					set(
              						current,
              						"initVar",
              						lv_initVar_2_0,
              						"at.ac.tuwien.big.virtmodel.VLang.SingleStatement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getForStatementAccess().getSemicolonKeyword_3());
              		
            }
            // InternalVLang.g:1942:3: ( (lv_condition_4_0= ruleFunctionAssignment ) )
            // InternalVLang.g:1943:4: (lv_condition_4_0= ruleFunctionAssignment )
            {
            // InternalVLang.g:1943:4: (lv_condition_4_0= ruleFunctionAssignment )
            // InternalVLang.g:1944:5: lv_condition_4_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementAccess().getConditionFunctionAssignmentParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_condition_4_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_4_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getForStatementAccess().getSemicolonKeyword_5());
              		
            }
            // InternalVLang.g:1965:3: ( (lv_endProcessing_6_0= ruleSingleStatement ) )
            // InternalVLang.g:1966:4: (lv_endProcessing_6_0= ruleSingleStatement )
            {
            // InternalVLang.g:1966:4: (lv_endProcessing_6_0= ruleSingleStatement )
            // InternalVLang.g:1967:5: lv_endProcessing_6_0= ruleSingleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementAccess().getEndProcessingSingleStatementParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_endProcessing_6_0=ruleSingleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRule());
              					}
              					set(
              						current,
              						"endProcessing",
              						lv_endProcessing_6_0,
              						"at.ac.tuwien.big.virtmodel.VLang.SingleStatement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,24,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());
              		
            }
            // InternalVLang.g:1988:3: ( (lv_loopExpr_8_0= ruleSingleStatement ) )
            // InternalVLang.g:1989:4: (lv_loopExpr_8_0= ruleSingleStatement )
            {
            // InternalVLang.g:1989:4: (lv_loopExpr_8_0= ruleSingleStatement )
            // InternalVLang.g:1990:5: lv_loopExpr_8_0= ruleSingleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementAccess().getLoopExprSingleStatementParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_loopExpr_8_0=ruleSingleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRule());
              					}
              					set(
              						current,
              						"loopExpr",
              						lv_loopExpr_8_0,
              						"at.ac.tuwien.big.virtmodel.VLang.SingleStatement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForStatement"


    // $ANTLR start "entryRuleForLoopStatement"
    // InternalVLang.g:2011:1: entryRuleForLoopStatement returns [EObject current=null] : iv_ruleForLoopStatement= ruleForLoopStatement EOF ;
    public final EObject entryRuleForLoopStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForLoopStatement = null;


        try {
            // InternalVLang.g:2011:57: (iv_ruleForLoopStatement= ruleForLoopStatement EOF )
            // InternalVLang.g:2012:2: iv_ruleForLoopStatement= ruleForLoopStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForLoopStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForLoopStatement=ruleForLoopStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForLoopStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForLoopStatement"


    // $ANTLR start "ruleForLoopStatement"
    // InternalVLang.g:2018:1: ruleForLoopStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_value_4_0= ruleFunctionAssignment ) ) otherlv_5= ')' ( (lv_loopExpr_6_0= ruleSingleStatement ) ) ) ;
    public final EObject ruleForLoopStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_4_0 = null;

        EObject lv_loopExpr_6_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:2024:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_value_4_0= ruleFunctionAssignment ) ) otherlv_5= ')' ( (lv_loopExpr_6_0= ruleSingleStatement ) ) ) )
            // InternalVLang.g:2025:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_value_4_0= ruleFunctionAssignment ) ) otherlv_5= ')' ( (lv_loopExpr_6_0= ruleSingleStatement ) ) )
            {
            // InternalVLang.g:2025:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_value_4_0= ruleFunctionAssignment ) ) otherlv_5= ')' ( (lv_loopExpr_6_0= ruleSingleStatement ) ) )
            // InternalVLang.g:2026:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_value_4_0= ruleFunctionAssignment ) ) otherlv_5= ')' ( (lv_loopExpr_6_0= ruleSingleStatement ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForLoopStatementAccess().getForKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,23,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getForLoopStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVLang.g:2034:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalVLang.g:2035:4: (lv_name_2_0= RULE_ID )
            {
            // InternalVLang.g:2035:4: (lv_name_2_0= RULE_ID )
            // InternalVLang.g:2036:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getForLoopStatementAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getForLoopStatementRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,38,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getForLoopStatementAccess().getColonKeyword_3());
              		
            }
            // InternalVLang.g:2056:3: ( (lv_value_4_0= ruleFunctionAssignment ) )
            // InternalVLang.g:2057:4: (lv_value_4_0= ruleFunctionAssignment )
            {
            // InternalVLang.g:2057:4: (lv_value_4_0= ruleFunctionAssignment )
            // InternalVLang.g:2058:5: lv_value_4_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForLoopStatementAccess().getValueFunctionAssignmentParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_value_4_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForLoopStatementRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_4_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,24,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getForLoopStatementAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalVLang.g:2079:3: ( (lv_loopExpr_6_0= ruleSingleStatement ) )
            // InternalVLang.g:2080:4: (lv_loopExpr_6_0= ruleSingleStatement )
            {
            // InternalVLang.g:2080:4: (lv_loopExpr_6_0= ruleSingleStatement )
            // InternalVLang.g:2081:5: lv_loopExpr_6_0= ruleSingleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForLoopStatementAccess().getLoopExprSingleStatementParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_loopExpr_6_0=ruleSingleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForLoopStatementRule());
              					}
              					set(
              						current,
              						"loopExpr",
              						lv_loopExpr_6_0,
              						"at.ac.tuwien.big.virtmodel.VLang.SingleStatement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForLoopStatement"


    // $ANTLR start "ruleMaybeValue"
    // InternalVLang.g:2103:1: ruleMaybeValue[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '=' ( (lv_value_1_0= ruleFunctionAssignment ) ) ) ;
    public final EObject ruleMaybeValue(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:2109:2: ( (otherlv_0= '=' ( (lv_value_1_0= ruleFunctionAssignment ) ) ) )
            // InternalVLang.g:2110:2: (otherlv_0= '=' ( (lv_value_1_0= ruleFunctionAssignment ) ) )
            {
            // InternalVLang.g:2110:2: (otherlv_0= '=' ( (lv_value_1_0= ruleFunctionAssignment ) ) )
            // InternalVLang.g:2111:3: otherlv_0= '=' ( (lv_value_1_0= ruleFunctionAssignment ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMaybeValueAccess().getEqualsSignKeyword_0());
              		
            }
            // InternalVLang.g:2115:3: ( (lv_value_1_0= ruleFunctionAssignment ) )
            // InternalVLang.g:2116:4: (lv_value_1_0= ruleFunctionAssignment )
            {
            // InternalVLang.g:2116:4: (lv_value_1_0= ruleFunctionAssignment )
            // InternalVLang.g:2117:5: lv_value_1_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMaybeValueAccess().getValueFunctionAssignmentParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMaybeValueRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaybeValue"


    // $ANTLR start "entryRuleParDef"
    // InternalVLang.g:2138:1: entryRuleParDef returns [EObject current=null] : iv_ruleParDef= ruleParDef EOF ;
    public final EObject entryRuleParDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParDef = null;


        try {
            // InternalVLang.g:2138:47: (iv_ruleParDef= ruleParDef EOF )
            // InternalVLang.g:2139:2: iv_ruleParDef= ruleParDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParDef=ruleParDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParDef"


    // $ANTLR start "ruleParDef"
    // InternalVLang.g:2145:1: ruleParDef returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleFunctionParDef ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleParDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:2151:2: ( ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleFunctionParDef ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) ) )* )? otherlv_5= ')' ) )
            // InternalVLang.g:2152:2: ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleFunctionParDef ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) ) )* )? otherlv_5= ')' )
            {
            // InternalVLang.g:2152:2: ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleFunctionParDef ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) ) )* )? otherlv_5= ')' )
            // InternalVLang.g:2153:3: () otherlv_1= '(' ( ( (lv_params_2_0= ruleFunctionParDef ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) ) )* )? otherlv_5= ')'
            {
            // InternalVLang.g:2153:3: ()
            // InternalVLang.g:2154:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParDefAccess().getParDefAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,23,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParDefAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVLang.g:2167:3: ( ( (lv_params_2_0= ruleFunctionParDef ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalVLang.g:2168:4: ( (lv_params_2_0= ruleFunctionParDef ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) ) )*
                    {
                    // InternalVLang.g:2168:4: ( (lv_params_2_0= ruleFunctionParDef ) )
                    // InternalVLang.g:2169:5: (lv_params_2_0= ruleFunctionParDef )
                    {
                    // InternalVLang.g:2169:5: (lv_params_2_0= ruleFunctionParDef )
                    // InternalVLang.g:2170:6: lv_params_2_0= ruleFunctionParDef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParDefAccess().getParamsFunctionParDefParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
                    lv_params_2_0=ruleFunctionParDef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParDefRule());
                      						}
                      						add(
                      							current,
                      							"params",
                      							lv_params_2_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.FunctionParDef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalVLang.g:2187:4: (otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==21) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalVLang.g:2188:5: otherlv_3= ',' ( (lv_params_4_0= ruleFunctionParDef ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getParDefAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalVLang.g:2192:5: ( (lv_params_4_0= ruleFunctionParDef ) )
                    	    // InternalVLang.g:2193:6: (lv_params_4_0= ruleFunctionParDef )
                    	    {
                    	    // InternalVLang.g:2193:6: (lv_params_4_0= ruleFunctionParDef )
                    	    // InternalVLang.g:2194:7: lv_params_4_0= ruleFunctionParDef
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getParDefAccess().getParamsFunctionParDefParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_33);
                    	    lv_params_4_0=ruleFunctionParDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getParDefRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"params",
                    	      								lv_params_4_0,
                    	      								"at.ac.tuwien.big.virtmodel.VLang.FunctionParDef");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getParDefAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParDef"


    // $ANTLR start "entryRuleFunctionParDef"
    // InternalVLang.g:2221:1: entryRuleFunctionParDef returns [EObject current=null] : iv_ruleFunctionParDef= ruleFunctionParDef EOF ;
    public final EObject entryRuleFunctionParDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionParDef = null;


        try {
            // InternalVLang.g:2221:55: (iv_ruleFunctionParDef= ruleFunctionParDef EOF )
            // InternalVLang.g:2222:2: iv_ruleFunctionParDef= ruleFunctionParDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionParDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionParDef=ruleFunctionParDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionParDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionParDef"


    // $ANTLR start "ruleFunctionParDef"
    // InternalVLang.g:2228:1: ruleFunctionParDef returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleFunctionParDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;


        	enterRule();

        try {
            // InternalVLang.g:2234:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )? ) )
            // InternalVLang.g:2235:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )? )
            {
            // InternalVLang.g:2235:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )? )
            // InternalVLang.g:2236:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )?
            {
            // InternalVLang.g:2236:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalVLang.g:2237:4: (lv_name_0_0= RULE_ID )
            {
            // InternalVLang.g:2237:4: (lv_name_0_0= RULE_ID )
            // InternalVLang.g:2238:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getFunctionParDefAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionParDefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalVLang.g:2254:3: (otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==38) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalVLang.g:2255:4: otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getFunctionParDefAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalVLang.g:2259:4: ( (lv_type_2_0= RULE_ID ) )
                    // InternalVLang.g:2260:5: (lv_type_2_0= RULE_ID )
                    {
                    // InternalVLang.g:2260:5: (lv_type_2_0= RULE_ID )
                    // InternalVLang.g:2261:6: lv_type_2_0= RULE_ID
                    {
                    lv_type_2_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_2_0, grammarAccess.getFunctionParDefAccess().getTypeIDTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFunctionParDefRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"type",
                      							lv_type_2_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionParDef"


    // $ANTLR start "entryRuleCalculatedValue"
    // InternalVLang.g:2282:1: entryRuleCalculatedValue returns [EObject current=null] : iv_ruleCalculatedValue= ruleCalculatedValue EOF ;
    public final EObject entryRuleCalculatedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCalculatedValue = null;


        try {
            // InternalVLang.g:2282:56: (iv_ruleCalculatedValue= ruleCalculatedValue EOF )
            // InternalVLang.g:2283:2: iv_ruleCalculatedValue= ruleCalculatedValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCalculatedValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCalculatedValue=ruleCalculatedValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCalculatedValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCalculatedValue"


    // $ANTLR start "ruleCalculatedValue"
    // InternalVLang.g:2289:1: ruleCalculatedValue returns [EObject current=null] : (this_FunctionCall_0= ruleFunctionCall | this_IfThenElse_1= ruleIfThenElse ) ;
    public final EObject ruleCalculatedValue() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionCall_0 = null;

        EObject this_IfThenElse_1 = null;



        	enterRule();

        try {
            // InternalVLang.g:2295:2: ( (this_FunctionCall_0= ruleFunctionCall | this_IfThenElse_1= ruleIfThenElse ) )
            // InternalVLang.g:2296:2: (this_FunctionCall_0= ruleFunctionCall | this_IfThenElse_1= ruleIfThenElse )
            {
            // InternalVLang.g:2296:2: (this_FunctionCall_0= ruleFunctionCall | this_IfThenElse_1= ruleIfThenElse )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            else if ( (LA26_0==35) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalVLang.g:2297:3: this_FunctionCall_0= ruleFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCalculatedValueAccess().getFunctionCallParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_0=ruleFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionCall_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVLang.g:2309:3: this_IfThenElse_1= ruleIfThenElse
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCalculatedValueAccess().getIfThenElseParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfThenElse_1=ruleIfThenElse();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfThenElse_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCalculatedValue"


    // $ANTLR start "entryRuleIfThenElse"
    // InternalVLang.g:2324:1: entryRuleIfThenElse returns [EObject current=null] : iv_ruleIfThenElse= ruleIfThenElse EOF ;
    public final EObject entryRuleIfThenElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfThenElse = null;


        try {
            // InternalVLang.g:2324:51: (iv_ruleIfThenElse= ruleIfThenElse EOF )
            // InternalVLang.g:2325:2: iv_ruleIfThenElse= ruleIfThenElse EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfThenElseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfThenElse=ruleIfThenElse();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfThenElse; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfThenElse"


    // $ANTLR start "ruleIfThenElse"
    // InternalVLang.g:2331:1: ruleIfThenElse returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleFunctionAssignment ) ) otherlv_2= 'then' ( (lv_thenExpr_3_0= ruleFunctionAssignment ) ) otherlv_4= 'else' ( (lv_elseExpr_5_0= ruleFunctionAssignment ) ) otherlv_6= 'endif' ) ;
    public final EObject ruleIfThenElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_1_0 = null;

        EObject lv_thenExpr_3_0 = null;

        EObject lv_elseExpr_5_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:2337:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleFunctionAssignment ) ) otherlv_2= 'then' ( (lv_thenExpr_3_0= ruleFunctionAssignment ) ) otherlv_4= 'else' ( (lv_elseExpr_5_0= ruleFunctionAssignment ) ) otherlv_6= 'endif' ) )
            // InternalVLang.g:2338:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleFunctionAssignment ) ) otherlv_2= 'then' ( (lv_thenExpr_3_0= ruleFunctionAssignment ) ) otherlv_4= 'else' ( (lv_elseExpr_5_0= ruleFunctionAssignment ) ) otherlv_6= 'endif' )
            {
            // InternalVLang.g:2338:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleFunctionAssignment ) ) otherlv_2= 'then' ( (lv_thenExpr_3_0= ruleFunctionAssignment ) ) otherlv_4= 'else' ( (lv_elseExpr_5_0= ruleFunctionAssignment ) ) otherlv_6= 'endif' )
            // InternalVLang.g:2339:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleFunctionAssignment ) ) otherlv_2= 'then' ( (lv_thenExpr_3_0= ruleFunctionAssignment ) ) otherlv_4= 'else' ( (lv_elseExpr_5_0= ruleFunctionAssignment ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfThenElseAccess().getIfKeyword_0());
              		
            }
            // InternalVLang.g:2343:3: ( (lv_condition_1_0= ruleFunctionAssignment ) )
            // InternalVLang.g:2344:4: (lv_condition_1_0= ruleFunctionAssignment )
            {
            // InternalVLang.g:2344:4: (lv_condition_1_0= ruleFunctionAssignment )
            // InternalVLang.g:2345:5: lv_condition_1_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfThenElseAccess().getConditionFunctionAssignmentParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_35);
            lv_condition_1_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfThenElseRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_1_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIfThenElseAccess().getThenKeyword_2());
              		
            }
            // InternalVLang.g:2366:3: ( (lv_thenExpr_3_0= ruleFunctionAssignment ) )
            // InternalVLang.g:2367:4: (lv_thenExpr_3_0= ruleFunctionAssignment )
            {
            // InternalVLang.g:2367:4: (lv_thenExpr_3_0= ruleFunctionAssignment )
            // InternalVLang.g:2368:5: lv_thenExpr_3_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfThenElseAccess().getThenExprFunctionAssignmentParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_36);
            lv_thenExpr_3_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfThenElseRule());
              					}
              					set(
              						current,
              						"thenExpr",
              						lv_thenExpr_3_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,36,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getIfThenElseAccess().getElseKeyword_4());
              		
            }
            // InternalVLang.g:2389:3: ( (lv_elseExpr_5_0= ruleFunctionAssignment ) )
            // InternalVLang.g:2390:4: (lv_elseExpr_5_0= ruleFunctionAssignment )
            {
            // InternalVLang.g:2390:4: (lv_elseExpr_5_0= ruleFunctionAssignment )
            // InternalVLang.g:2391:5: lv_elseExpr_5_0= ruleFunctionAssignment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfThenElseAccess().getElseExprFunctionAssignmentParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_37);
            lv_elseExpr_5_0=ruleFunctionAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfThenElseRule());
              					}
              					set(
              						current,
              						"elseExpr",
              						lv_elseExpr_5_0,
              						"at.ac.tuwien.big.virtmodel.VLang.FunctionAssignment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getIfThenElseAccess().getEndifKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfThenElse"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalVLang.g:2416:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalVLang.g:2416:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalVLang.g:2417:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalVLang.g:2423:1: ruleFunctionCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_FunctionPars_1= ruleFunctionPars[$current] ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_FunctionPars_1 = null;



        	enterRule();

        try {
            // InternalVLang.g:2429:2: ( ( ( (otherlv_0= RULE_ID ) ) this_FunctionPars_1= ruleFunctionPars[$current] ) )
            // InternalVLang.g:2430:2: ( ( (otherlv_0= RULE_ID ) ) this_FunctionPars_1= ruleFunctionPars[$current] )
            {
            // InternalVLang.g:2430:2: ( ( (otherlv_0= RULE_ID ) ) this_FunctionPars_1= ruleFunctionPars[$current] )
            // InternalVLang.g:2431:3: ( (otherlv_0= RULE_ID ) ) this_FunctionPars_1= ruleFunctionPars[$current]
            {
            // InternalVLang.g:2431:3: ( (otherlv_0= RULE_ID ) )
            // InternalVLang.g:2432:4: (otherlv_0= RULE_ID )
            {
            // InternalVLang.g:2432:4: (otherlv_0= RULE_ID )
            // InternalVLang.g:2433:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionCallRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getFunctionCallAccess().getFunctionFunctionDefCrossReference_0_0());
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getFunctionCallRule());
              			}
              			newCompositeNode(grammarAccess.getFunctionCallAccess().getFunctionParsParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            this_FunctionPars_1=ruleFunctionPars(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_FunctionPars_1;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleJavaFunctionCall"
    // InternalVLang.g:2465:1: entryRuleJavaFunctionCall returns [EObject current=null] : iv_ruleJavaFunctionCall= ruleJavaFunctionCall EOF ;
    public final EObject entryRuleJavaFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaFunctionCall = null;


        try {
            // InternalVLang.g:2465:57: (iv_ruleJavaFunctionCall= ruleJavaFunctionCall EOF )
            // InternalVLang.g:2466:2: iv_ruleJavaFunctionCall= ruleJavaFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJavaFunctionCall=ruleJavaFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJavaFunctionCall"


    // $ANTLR start "ruleJavaFunctionCall"
    // InternalVLang.g:2472:1: ruleJavaFunctionCall returns [EObject current=null] : (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) this_FunctionPars_2= ruleFunctionPars[$current] ) ;
    public final EObject ruleJavaFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_FunctionPars_2 = null;



        	enterRule();

        try {
            // InternalVLang.g:2478:2: ( (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) this_FunctionPars_2= ruleFunctionPars[$current] ) )
            // InternalVLang.g:2479:2: (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) this_FunctionPars_2= ruleFunctionPars[$current] )
            {
            // InternalVLang.g:2479:2: (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) this_FunctionPars_2= ruleFunctionPars[$current] )
            // InternalVLang.g:2480:3: otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) this_FunctionPars_2= ruleFunctionPars[$current]
            {
            otherlv_0=(Token)match(input,41,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJavaFunctionCallAccess().getDollarSignKeyword_0());
              		
            }
            // InternalVLang.g:2484:3: ( (otherlv_1= RULE_ID ) )
            // InternalVLang.g:2485:4: (otherlv_1= RULE_ID )
            {
            // InternalVLang.g:2485:4: (otherlv_1= RULE_ID )
            // InternalVLang.g:2486:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getJavaFunctionCallRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getJavaFunctionCallAccess().getFunctionJavaFunctionDefCrossReference_1_0());
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getJavaFunctionCallRule());
              			}
              			newCompositeNode(grammarAccess.getJavaFunctionCallAccess().getFunctionParsParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_FunctionPars_2=ruleFunctionPars(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_FunctionPars_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJavaFunctionCall"


    // $ANTLR start "ruleFunctionPars"
    // InternalVLang.g:2519:1: ruleFunctionPars[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '(' ( ( (lv_params_1_0= ruleFunctionPar ) ) (otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) ) )* )? otherlv_4= ')' ) ;
    public final EObject ruleFunctionPars(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_params_1_0 = null;

        EObject lv_params_3_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:2525:2: ( (otherlv_0= '(' ( ( (lv_params_1_0= ruleFunctionPar ) ) (otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) ) )* )? otherlv_4= ')' ) )
            // InternalVLang.g:2526:2: (otherlv_0= '(' ( ( (lv_params_1_0= ruleFunctionPar ) ) (otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) ) )* )? otherlv_4= ')' )
            {
            // InternalVLang.g:2526:2: (otherlv_0= '(' ( ( (lv_params_1_0= ruleFunctionPar ) ) (otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) ) )* )? otherlv_4= ')' )
            // InternalVLang.g:2527:3: otherlv_0= '(' ( ( (lv_params_1_0= ruleFunctionPar ) ) (otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) ) )* )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFunctionParsAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalVLang.g:2531:3: ( ( (lv_params_1_0= ruleFunctionPar ) ) (otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_STRING)||LA28_0==35||LA28_0==42) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalVLang.g:2532:4: ( (lv_params_1_0= ruleFunctionPar ) ) (otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) ) )*
                    {
                    // InternalVLang.g:2532:4: ( (lv_params_1_0= ruleFunctionPar ) )
                    // InternalVLang.g:2533:5: (lv_params_1_0= ruleFunctionPar )
                    {
                    // InternalVLang.g:2533:5: (lv_params_1_0= ruleFunctionPar )
                    // InternalVLang.g:2534:6: lv_params_1_0= ruleFunctionPar
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionParsAccess().getParamsFunctionParParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
                    lv_params_1_0=ruleFunctionPar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionParsRule());
                      						}
                      						add(
                      							current,
                      							"params",
                      							lv_params_1_0,
                      							"at.ac.tuwien.big.virtmodel.VLang.FunctionPar");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalVLang.g:2551:4: (otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==21) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalVLang.g:2552:5: otherlv_2= ',' ( (lv_params_3_0= ruleFunctionPar ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_39); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_2, grammarAccess.getFunctionParsAccess().getCommaKeyword_1_1_0());
                    	      				
                    	    }
                    	    // InternalVLang.g:2556:5: ( (lv_params_3_0= ruleFunctionPar ) )
                    	    // InternalVLang.g:2557:6: (lv_params_3_0= ruleFunctionPar )
                    	    {
                    	    // InternalVLang.g:2557:6: (lv_params_3_0= ruleFunctionPar )
                    	    // InternalVLang.g:2558:7: lv_params_3_0= ruleFunctionPar
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionParsAccess().getParamsFunctionParParserRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_33);
                    	    lv_params_3_0=ruleFunctionPar();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getFunctionParsRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"params",
                    	      								lv_params_3_0,
                    	      								"at.ac.tuwien.big.virtmodel.VLang.FunctionPar");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getFunctionParsAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionPars"


    // $ANTLR start "entryRuleFunctionPar"
    // InternalVLang.g:2585:1: entryRuleFunctionPar returns [EObject current=null] : iv_ruleFunctionPar= ruleFunctionPar EOF ;
    public final EObject entryRuleFunctionPar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionPar = null;


        try {
            // InternalVLang.g:2585:52: (iv_ruleFunctionPar= ruleFunctionPar EOF )
            // InternalVLang.g:2586:2: iv_ruleFunctionPar= ruleFunctionPar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionParRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionPar=ruleFunctionPar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionPar; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionPar"


    // $ANTLR start "ruleFunctionPar"
    // InternalVLang.g:2592:1: ruleFunctionPar returns [EObject current=null] : this_SingleValue_0= ruleSingleValue ;
    public final EObject ruleFunctionPar() throws RecognitionException {
        EObject current = null;

        EObject this_SingleValue_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:2598:2: (this_SingleValue_0= ruleSingleValue )
            // InternalVLang.g:2599:2: this_SingleValue_0= ruleSingleValue
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getFunctionParAccess().getSingleValueParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_SingleValue_0=ruleSingleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_SingleValue_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionPar"


    // $ANTLR start "entryRuleObjId"
    // InternalVLang.g:2613:1: entryRuleObjId returns [EObject current=null] : iv_ruleObjId= ruleObjId EOF ;
    public final EObject entryRuleObjId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjId = null;


        try {
            // InternalVLang.g:2613:46: (iv_ruleObjId= ruleObjId EOF )
            // InternalVLang.g:2614:2: iv_ruleObjId= ruleObjId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjIdRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleObjId=ruleObjId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjId; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjId"


    // $ANTLR start "ruleObjId"
    // InternalVLang.g:2620:1: ruleObjId returns [EObject current=null] : (otherlv_0= '#' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )* )? otherlv_6= ')' )? ) ;
    public final EObject ruleObjId() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:2626:2: ( (otherlv_0= '#' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )* )? otherlv_6= ')' )? ) )
            // InternalVLang.g:2627:2: (otherlv_0= '#' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )* )? otherlv_6= ')' )? )
            {
            // InternalVLang.g:2627:2: (otherlv_0= '#' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )* )? otherlv_6= ')' )? )
            // InternalVLang.g:2628:3: otherlv_0= '#' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )* )? otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,42,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getObjIdAccess().getNumberSignKeyword_0());
              		
            }
            // InternalVLang.g:2632:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalVLang.g:2633:4: (lv_name_1_0= RULE_ID )
            {
            // InternalVLang.g:2633:4: (lv_name_1_0= RULE_ID )
            // InternalVLang.g:2634:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getObjIdAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getObjIdRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalVLang.g:2650:3: (otherlv_2= '(' ( ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )* )? otherlv_6= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==23) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalVLang.g:2651:4: otherlv_2= '(' ( ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )* )? otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getObjIdAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalVLang.g:2655:4: ( ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalVLang.g:2656:5: ( (lv_params_3_0= ruleObjParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )*
                            {
                            // InternalVLang.g:2656:5: ( (lv_params_3_0= ruleObjParam ) )
                            // InternalVLang.g:2657:6: (lv_params_3_0= ruleObjParam )
                            {
                            // InternalVLang.g:2657:6: (lv_params_3_0= ruleObjParam )
                            // InternalVLang.g:2658:7: lv_params_3_0= ruleObjParam
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getObjIdAccess().getParamsObjParamParserRuleCall_2_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_33);
                            lv_params_3_0=ruleObjParam();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getObjIdRule());
                              							}
                              							add(
                              								current,
                              								"params",
                              								lv_params_3_0,
                              								"at.ac.tuwien.big.virtmodel.VLang.ObjParam");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalVLang.g:2675:5: (otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) ) )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==21) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // InternalVLang.g:2676:6: otherlv_4= ',' ( (lv_params_5_0= ruleObjParam ) )
                            	    {
                            	    otherlv_4=(Token)match(input,21,FOLLOW_42); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_4, grammarAccess.getObjIdAccess().getCommaKeyword_2_1_1_0());
                            	      					
                            	    }
                            	    // InternalVLang.g:2680:6: ( (lv_params_5_0= ruleObjParam ) )
                            	    // InternalVLang.g:2681:7: (lv_params_5_0= ruleObjParam )
                            	    {
                            	    // InternalVLang.g:2681:7: (lv_params_5_0= ruleObjParam )
                            	    // InternalVLang.g:2682:8: lv_params_5_0= ruleObjParam
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getObjIdAccess().getParamsObjParamParserRuleCall_2_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_33);
                            	    lv_params_5_0=ruleObjParam();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getObjIdRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"params",
                            	      									lv_params_5_0,
                            	      									"at.ac.tuwien.big.virtmodel.VLang.ObjParam");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop29;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getObjIdAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjId"


    // $ANTLR start "entryRuleObjParam"
    // InternalVLang.g:2710:1: entryRuleObjParam returns [EObject current=null] : iv_ruleObjParam= ruleObjParam EOF ;
    public final EObject entryRuleObjParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjParam = null;


        try {
            // InternalVLang.g:2710:49: (iv_ruleObjParam= ruleObjParam EOF )
            // InternalVLang.g:2711:2: iv_ruleObjParam= ruleObjParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjParamRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleObjParam=ruleObjParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjParam; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjParam"


    // $ANTLR start "ruleObjParam"
    // InternalVLang.g:2717:1: ruleObjParam returns [EObject current=null] : ( ( (lv_number_0_0= RULE_INT ) ) | ( (lv_string_1_0= RULE_STRING ) ) | ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')' )? ) ) ;
    public final EObject ruleObjParam() throws RecognitionException {
        EObject current = null;

        Token lv_number_0_0=null;
        Token lv_string_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_params_4_0 = null;

        EObject lv_params_6_0 = null;



        	enterRule();

        try {
            // InternalVLang.g:2723:2: ( ( ( (lv_number_0_0= RULE_INT ) ) | ( (lv_string_1_0= RULE_STRING ) ) | ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')' )? ) ) )
            // InternalVLang.g:2724:2: ( ( (lv_number_0_0= RULE_INT ) ) | ( (lv_string_1_0= RULE_STRING ) ) | ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')' )? ) )
            {
            // InternalVLang.g:2724:2: ( ( (lv_number_0_0= RULE_INT ) ) | ( (lv_string_1_0= RULE_STRING ) ) | ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')' )? ) )
            int alt35=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt35=1;
                }
                break;
            case RULE_STRING:
                {
                alt35=2;
                }
                break;
            case RULE_ID:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalVLang.g:2725:3: ( (lv_number_0_0= RULE_INT ) )
                    {
                    // InternalVLang.g:2725:3: ( (lv_number_0_0= RULE_INT ) )
                    // InternalVLang.g:2726:4: (lv_number_0_0= RULE_INT )
                    {
                    // InternalVLang.g:2726:4: (lv_number_0_0= RULE_INT )
                    // InternalVLang.g:2727:5: lv_number_0_0= RULE_INT
                    {
                    lv_number_0_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_number_0_0, grammarAccess.getObjParamAccess().getNumberINTTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getObjParamRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"number",
                      						lv_number_0_0,
                      						"org.eclipse.xtext.common.Terminals.INT");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVLang.g:2744:3: ( (lv_string_1_0= RULE_STRING ) )
                    {
                    // InternalVLang.g:2744:3: ( (lv_string_1_0= RULE_STRING ) )
                    // InternalVLang.g:2745:4: (lv_string_1_0= RULE_STRING )
                    {
                    // InternalVLang.g:2745:4: (lv_string_1_0= RULE_STRING )
                    // InternalVLang.g:2746:5: lv_string_1_0= RULE_STRING
                    {
                    lv_string_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_string_1_0, grammarAccess.getObjParamAccess().getStringSTRINGTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getObjParamRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"string",
                      						lv_string_1_0,
                      						"org.eclipse.xtext.common.Terminals.STRING");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalVLang.g:2763:3: ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')' )? )
                    {
                    // InternalVLang.g:2763:3: ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')' )? )
                    // InternalVLang.g:2764:4: ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')' )?
                    {
                    // InternalVLang.g:2764:4: ( (lv_name_2_0= RULE_ID ) )
                    // InternalVLang.g:2765:5: (lv_name_2_0= RULE_ID )
                    {
                    // InternalVLang.g:2765:5: (lv_name_2_0= RULE_ID )
                    // InternalVLang.g:2766:6: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_2_0, grammarAccess.getObjParamAccess().getNameIDTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getObjParamRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalVLang.g:2782:4: (otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==23) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalVLang.g:2783:5: otherlv_3= '(' ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )? otherlv_7= ')'
                            {
                            otherlv_3=(Token)match(input,23,FOLLOW_41); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getObjParamAccess().getLeftParenthesisKeyword_2_1_0());
                              				
                            }
                            // InternalVLang.g:2787:5: ( ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )* )?
                            int alt33=2;
                            int LA33_0 = input.LA(1);

                            if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_STRING)) ) {
                                alt33=1;
                            }
                            switch (alt33) {
                                case 1 :
                                    // InternalVLang.g:2788:6: ( (lv_params_4_0= ruleObjParam ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )*
                                    {
                                    // InternalVLang.g:2788:6: ( (lv_params_4_0= ruleObjParam ) )
                                    // InternalVLang.g:2789:7: (lv_params_4_0= ruleObjParam )
                                    {
                                    // InternalVLang.g:2789:7: (lv_params_4_0= ruleObjParam )
                                    // InternalVLang.g:2790:8: lv_params_4_0= ruleObjParam
                                    {
                                    if ( state.backtracking==0 ) {

                                      								newCompositeNode(grammarAccess.getObjParamAccess().getParamsObjParamParserRuleCall_2_1_1_0_0());
                                      							
                                    }
                                    pushFollow(FOLLOW_33);
                                    lv_params_4_0=ruleObjParam();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								if (current==null) {
                                      									current = createModelElementForParent(grammarAccess.getObjParamRule());
                                      								}
                                      								add(
                                      									current,
                                      									"params",
                                      									lv_params_4_0,
                                      									"at.ac.tuwien.big.virtmodel.VLang.ObjParam");
                                      								afterParserOrEnumRuleCall();
                                      							
                                    }

                                    }


                                    }

                                    // InternalVLang.g:2807:6: (otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) ) )*
                                    loop32:
                                    do {
                                        int alt32=2;
                                        int LA32_0 = input.LA(1);

                                        if ( (LA32_0==21) ) {
                                            alt32=1;
                                        }


                                        switch (alt32) {
                                    	case 1 :
                                    	    // InternalVLang.g:2808:7: otherlv_5= ',' ( (lv_params_6_0= ruleObjParam ) )
                                    	    {
                                    	    otherlv_5=(Token)match(input,21,FOLLOW_42); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      							newLeafNode(otherlv_5, grammarAccess.getObjParamAccess().getCommaKeyword_2_1_1_1_0());
                                    	      						
                                    	    }
                                    	    // InternalVLang.g:2812:7: ( (lv_params_6_0= ruleObjParam ) )
                                    	    // InternalVLang.g:2813:8: (lv_params_6_0= ruleObjParam )
                                    	    {
                                    	    // InternalVLang.g:2813:8: (lv_params_6_0= ruleObjParam )
                                    	    // InternalVLang.g:2814:9: lv_params_6_0= ruleObjParam
                                    	    {
                                    	    if ( state.backtracking==0 ) {

                                    	      									newCompositeNode(grammarAccess.getObjParamAccess().getParamsObjParamParserRuleCall_2_1_1_1_1_0());
                                    	      								
                                    	    }
                                    	    pushFollow(FOLLOW_33);
                                    	    lv_params_6_0=ruleObjParam();

                                    	    state._fsp--;
                                    	    if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      									if (current==null) {
                                    	      										current = createModelElementForParent(grammarAccess.getObjParamRule());
                                    	      									}
                                    	      									add(
                                    	      										current,
                                    	      										"params",
                                    	      										lv_params_6_0,
                                    	      										"at.ac.tuwien.big.virtmodel.VLang.ObjParam");
                                    	      									afterParserOrEnumRuleCall();
                                    	      								
                                    	    }

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop32;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            otherlv_7=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_7, grammarAccess.getObjParamAccess().getRightParenthesisKeyword_2_1_2());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjParam"


    // $ANTLR start "ruleFunctionType"
    // InternalVLang.g:2843:1: ruleFunctionType returns [Enumerator current=null] : ( (enumLiteral_0= 'finite' ) | (enumLiteral_1= 'derive' ) | (enumLiteral_2= 'constraint' ) ) ;
    public final Enumerator ruleFunctionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalVLang.g:2849:2: ( ( (enumLiteral_0= 'finite' ) | (enumLiteral_1= 'derive' ) | (enumLiteral_2= 'constraint' ) ) )
            // InternalVLang.g:2850:2: ( (enumLiteral_0= 'finite' ) | (enumLiteral_1= 'derive' ) | (enumLiteral_2= 'constraint' ) )
            {
            // InternalVLang.g:2850:2: ( (enumLiteral_0= 'finite' ) | (enumLiteral_1= 'derive' ) | (enumLiteral_2= 'constraint' ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt36=1;
                }
                break;
            case 44:
                {
                alt36=2;
                }
                break;
            case 45:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalVLang.g:2851:3: (enumLiteral_0= 'finite' )
                    {
                    // InternalVLang.g:2851:3: (enumLiteral_0= 'finite' )
                    // InternalVLang.g:2852:4: enumLiteral_0= 'finite'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFunctionTypeAccess().getFINITEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getFunctionTypeAccess().getFINITEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalVLang.g:2859:3: (enumLiteral_1= 'derive' )
                    {
                    // InternalVLang.g:2859:3: (enumLiteral_1= 'derive' )
                    // InternalVLang.g:2860:4: enumLiteral_1= 'derive'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFunctionTypeAccess().getDERIVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getFunctionTypeAccess().getDERIVEEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalVLang.g:2867:3: (enumLiteral_2= 'constraint' )
                    {
                    // InternalVLang.g:2867:3: (enumLiteral_2= 'constraint' )
                    // InternalVLang.g:2868:4: enumLiteral_2= 'constraint'
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getFunctionTypeAccess().getCONSTRAINTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getFunctionTypeAccess().getCONSTRAINTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionType"


    // $ANTLR start "ruleJavaFunctionType"
    // InternalVLang.g:2878:1: ruleJavaFunctionType returns [Enumerator current=null] : ( (enumLiteral_0= 'jfunc' ) | (enumLiteral_1= 'jcons' ) | (enumLiteral_2= 'jop' ) ) ;
    public final Enumerator ruleJavaFunctionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalVLang.g:2884:2: ( ( (enumLiteral_0= 'jfunc' ) | (enumLiteral_1= 'jcons' ) | (enumLiteral_2= 'jop' ) ) )
            // InternalVLang.g:2885:2: ( (enumLiteral_0= 'jfunc' ) | (enumLiteral_1= 'jcons' ) | (enumLiteral_2= 'jop' ) )
            {
            // InternalVLang.g:2885:2: ( (enumLiteral_0= 'jfunc' ) | (enumLiteral_1= 'jcons' ) | (enumLiteral_2= 'jop' ) )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt37=1;
                }
                break;
            case 47:
                {
                alt37=2;
                }
                break;
            case 48:
                {
                alt37=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalVLang.g:2886:3: (enumLiteral_0= 'jfunc' )
                    {
                    // InternalVLang.g:2886:3: (enumLiteral_0= 'jfunc' )
                    // InternalVLang.g:2887:4: enumLiteral_0= 'jfunc'
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getJavaFunctionTypeAccess().getFUNCCALLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getJavaFunctionTypeAccess().getFUNCCALLEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalVLang.g:2894:3: (enumLiteral_1= 'jcons' )
                    {
                    // InternalVLang.g:2894:3: (enumLiteral_1= 'jcons' )
                    // InternalVLang.g:2895:4: enumLiteral_1= 'jcons'
                    {
                    enumLiteral_1=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getJavaFunctionTypeAccess().getCONSTRUCTOREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getJavaFunctionTypeAccess().getCONSTRUCTOREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalVLang.g:2902:3: (enumLiteral_2= 'jop' )
                    {
                    // InternalVLang.g:2902:3: (enumLiteral_2= 'jop' )
                    // InternalVLang.g:2903:4: enumLiteral_2= 'jop'
                    {
                    enumLiteral_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getJavaFunctionTypeAccess().getOPERATIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getJavaFunctionTypeAccess().getOPERATIONEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJavaFunctionType"

    // $ANTLR start synpred23_InternalVLang
    public final void synpred23_InternalVLang_fragment() throws RecognitionException {   
        EObject this_FullFunctionAssignment_0 = null;


        // InternalVLang.g:1321:3: (this_FullFunctionAssignment_0= ruleFullFunctionAssignment )
        // InternalVLang.g:1321:3: this_FullFunctionAssignment_0= ruleFullFunctionAssignment
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_FullFunctionAssignment_0=ruleFullFunctionAssignment();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalVLang

    // $ANTLR start synpred27_InternalVLang
    public final void synpred27_InternalVLang_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;


        // InternalVLang.g:1564:4: ( ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' ) )
        // InternalVLang.g:1564:4: ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' )
        {
        // InternalVLang.g:1564:4: ( ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';' )
        // InternalVLang.g:1565:5: ( (lv_statements_2_0= ruleSingleStatement ) ) otherlv_3= ';'
        {
        // InternalVLang.g:1565:5: ( (lv_statements_2_0= ruleSingleStatement ) )
        // InternalVLang.g:1566:6: (lv_statements_2_0= ruleSingleStatement )
        {
        // InternalVLang.g:1566:6: (lv_statements_2_0= ruleSingleStatement )
        // InternalVLang.g:1567:7: lv_statements_2_0= ruleSingleStatement
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getBlockAccess().getStatementsSingleStatementParserRuleCall_2_0_0_0());
          						
        }
        pushFollow(FOLLOW_6);
        lv_statements_2_0=ruleSingleStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_3=(Token)match(input,13,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred27_InternalVLang

    // $ANTLR start synpred28_InternalVLang
    public final void synpred28_InternalVLang_fragment() throws RecognitionException {   
        EObject lv_statements_4_0 = null;


        // InternalVLang.g:1590:4: ( ( (lv_statements_4_0= ruleBlock ) ) )
        // InternalVLang.g:1590:4: ( (lv_statements_4_0= ruleBlock ) )
        {
        // InternalVLang.g:1590:4: ( (lv_statements_4_0= ruleBlock ) )
        // InternalVLang.g:1591:5: (lv_statements_4_0= ruleBlock )
        {
        // InternalVLang.g:1591:5: (lv_statements_4_0= ruleBlock )
        // InternalVLang.g:1592:6: lv_statements_4_0= ruleBlock
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getBlockAccess().getStatementsBlockParserRuleCall_2_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_statements_4_0=ruleBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred28_InternalVLang

    // $ANTLR start synpred35_InternalVLang
    public final void synpred35_InternalVLang_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_elseStatement_6_0 = null;


        // InternalVLang.g:1868:4: (otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) ) )
        // InternalVLang.g:1868:4: otherlv_5= 'else' ( (lv_elseStatement_6_0= ruleSingleStatement ) )
        {
        otherlv_5=(Token)match(input,36,FOLLOW_29); if (state.failed) return ;
        // InternalVLang.g:1872:4: ( (lv_elseStatement_6_0= ruleSingleStatement ) )
        // InternalVLang.g:1873:5: (lv_elseStatement_6_0= ruleSingleStatement )
        {
        // InternalVLang.g:1873:5: (lv_elseStatement_6_0= ruleSingleStatement )
        // InternalVLang.g:1874:6: lv_elseStatement_6_0= ruleSingleStatement
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getIfStatementAccess().getElseStatementSingleStatementParserRuleCall_5_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elseStatement_6_0=ruleSingleStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred35_InternalVLang

    // Delegated rules

    public final boolean synpred28_InternalVLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalVLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalVLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalVLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalVLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalVLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalVLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalVLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\5\1\uffff\7\0\1\uffff";
    static final String dfa_3s = "\1\52\1\uffff\7\0\1\uffff";
    static final String dfa_4s = "\1\uffff\1\1\7\uffff\1\2";
    static final String dfa_5s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff}>";
    static final String[] dfa_6s = {
            "\1\5\1\2\1\3\14\uffff\1\7\2\uffff\1\1\10\uffff\1\10\2\uffff\1\6\6\uffff\1\4",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1320:2: (this_FullFunctionAssignment_0= ruleFullFunctionAssignment | this_Expression_1= ruleExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalVLang()) ) {s = 1;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_3 = input.LA(1);

                         
                        int index16_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalVLang()) ) {s = 1;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index16_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_4 = input.LA(1);

                         
                        int index16_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalVLang()) ) {s = 1;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index16_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_5 = input.LA(1);

                         
                        int index16_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalVLang()) ) {s = 1;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index16_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_6 = input.LA(1);

                         
                        int index16_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalVLang()) ) {s = 1;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index16_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA16_7 = input.LA(1);

                         
                        int index16_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalVLang()) ) {s = 1;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index16_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA16_8 = input.LA(1);

                         
                        int index16_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalVLang()) ) {s = 1;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index16_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0001F80004085022L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0001F80004084022L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000409009000E0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000400004000C0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000400000000C0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000408700000E0L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002028000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000002E00500000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000002E00100000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000408010000E0L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00000408000000E0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00000000010000E0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00000000000000E0L});

}