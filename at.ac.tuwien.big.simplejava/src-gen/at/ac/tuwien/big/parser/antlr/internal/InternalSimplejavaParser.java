package at.ac.tuwien.big.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.ac.tuwien.big.services.SimplejavaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimplejavaParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "';'", "'import'", "'public'", "'class'", "'{'", "'}'", "'int'", "'double'", "'String'", "'boolean'", "'static'", "'void'", "'('", "','", "')'", "'pointcutblock'", "'='", "'if'", "'else'", "'for'", "':'", "'while'", "'return'", "'this'", "'.'", "'equals'", "'hashCode'", "'System.out.println'", "'null'", "'true'", "'false'", "'!'", "'||'", "'&&'", "'&'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'.*'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
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
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
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


        public InternalSimplejavaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimplejavaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimplejavaParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSimplejava.g"; }



     	private SimplejavaGrammarAccess grammarAccess;

        public InternalSimplejavaParser(TokenStream input, SimplejavaGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "SimpleJava";
       	}

       	@Override
       	protected SimplejavaGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSimpleJava"
    // InternalSimplejava.g:64:1: entryRuleSimpleJava returns [EObject current=null] : iv_ruleSimpleJava= ruleSimpleJava EOF ;
    public final EObject entryRuleSimpleJava() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleJava = null;


        try {
            // InternalSimplejava.g:64:51: (iv_ruleSimpleJava= ruleSimpleJava EOF )
            // InternalSimplejava.g:65:2: iv_ruleSimpleJava= ruleSimpleJava EOF
            {
             newCompositeNode(grammarAccess.getSimpleJavaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleJava=ruleSimpleJava();

            state._fsp--;

             current =iv_ruleSimpleJava; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleJava"


    // $ANTLR start "ruleSimpleJava"
    // InternalSimplejava.g:71:1: ruleSimpleJava returns [EObject current=null] : ( ( (lv_package_0_0= rulePackageDeclaration ) ) ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) ) ) ;
    public final EObject ruleSimpleJava() throws RecognitionException {
        EObject current = null;

        EObject lv_package_0_0 = null;

        EObject lv_imports_1_0 = null;

        EObject lv_clazz_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:77:2: ( ( ( (lv_package_0_0= rulePackageDeclaration ) ) ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) ) ) )
            // InternalSimplejava.g:78:2: ( ( (lv_package_0_0= rulePackageDeclaration ) ) ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) ) )
            {
            // InternalSimplejava.g:78:2: ( ( (lv_package_0_0= rulePackageDeclaration ) ) ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) ) )
            // InternalSimplejava.g:79:3: ( (lv_package_0_0= rulePackageDeclaration ) ) ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) )
            {
            // InternalSimplejava.g:79:3: ( (lv_package_0_0= rulePackageDeclaration ) )
            // InternalSimplejava.g:80:4: (lv_package_0_0= rulePackageDeclaration )
            {
            // InternalSimplejava.g:80:4: (lv_package_0_0= rulePackageDeclaration )
            // InternalSimplejava.g:81:5: lv_package_0_0= rulePackageDeclaration
            {

            					newCompositeNode(grammarAccess.getSimpleJavaAccess().getPackagePackageDeclarationParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_package_0_0=rulePackageDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleJavaRule());
            					}
            					set(
            						current,
            						"package",
            						lv_package_0_0,
            						"at.ac.tuwien.big.Simplejava.PackageDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:98:3: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSimplejava.g:99:4: (lv_imports_1_0= ruleImport )
            	    {
            	    // InternalSimplejava.g:99:4: (lv_imports_1_0= ruleImport )
            	    // InternalSimplejava.g:100:5: lv_imports_1_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getSimpleJavaAccess().getImportsImportParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_1_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSimpleJavaRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_1_0,
            	    						"at.ac.tuwien.big.Simplejava.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalSimplejava.g:117:3: ( (lv_clazz_2_0= ruleClassDeclaration ) )
            // InternalSimplejava.g:118:4: (lv_clazz_2_0= ruleClassDeclaration )
            {
            // InternalSimplejava.g:118:4: (lv_clazz_2_0= ruleClassDeclaration )
            // InternalSimplejava.g:119:5: lv_clazz_2_0= ruleClassDeclaration
            {

            					newCompositeNode(grammarAccess.getSimpleJavaAccess().getClazzClassDeclarationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_clazz_2_0=ruleClassDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleJavaRule());
            					}
            					set(
            						current,
            						"clazz",
            						lv_clazz_2_0,
            						"at.ac.tuwien.big.Simplejava.ClassDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleJava"


    // $ANTLR start "entryRulePackageDeclaration"
    // InternalSimplejava.g:140:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // InternalSimplejava.g:140:59: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // InternalSimplejava.g:141:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;

             current =iv_rulePackageDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalSimplejava.g:147:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSimplejava.g:153:2: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalSimplejava.g:154:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalSimplejava.g:154:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalSimplejava.g:155:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
            		
            // InternalSimplejava.g:159:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimplejava.g:160:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimplejava.g:160:4: (lv_name_1_0= RULE_ID )
            // InternalSimplejava.g:161:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPackageDeclarationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPackageDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getPackageDeclarationAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleImport"
    // InternalSimplejava.g:185:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSimplejava.g:185:47: (iv_ruleImport= ruleImport EOF )
            // InternalSimplejava.g:186:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSimplejava.g:192:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_imported_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_imported_1_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:198:2: ( (otherlv_0= 'import' ( (lv_imported_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';' ) )
            // InternalSimplejava.g:199:2: (otherlv_0= 'import' ( (lv_imported_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';' )
            {
            // InternalSimplejava.g:199:2: (otherlv_0= 'import' ( (lv_imported_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';' )
            // InternalSimplejava.g:200:3: otherlv_0= 'import' ( (lv_imported_1_0= ruleQualifiedNameWithWildcard ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalSimplejava.g:204:3: ( (lv_imported_1_0= ruleQualifiedNameWithWildcard ) )
            // InternalSimplejava.g:205:4: (lv_imported_1_0= ruleQualifiedNameWithWildcard )
            {
            // InternalSimplejava.g:205:4: (lv_imported_1_0= ruleQualifiedNameWithWildcard )
            // InternalSimplejava.g:206:5: lv_imported_1_0= ruleQualifiedNameWithWildcard
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportedQualifiedNameWithWildcardParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_imported_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"imported",
            						lv_imported_1_0,
            						"at.ac.tuwien.big.Simplejava.QualifiedNameWithWildcard");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleClassDeclaration"
    // InternalSimplejava.g:231:1: entryRuleClassDeclaration returns [EObject current=null] : iv_ruleClassDeclaration= ruleClassDeclaration EOF ;
    public final EObject entryRuleClassDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassDeclaration = null;


        try {
            // InternalSimplejava.g:231:57: (iv_ruleClassDeclaration= ruleClassDeclaration EOF )
            // InternalSimplejava.g:232:2: iv_ruleClassDeclaration= ruleClassDeclaration EOF
            {
             newCompositeNode(grammarAccess.getClassDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassDeclaration=ruleClassDeclaration();

            state._fsp--;

             current =iv_ruleClassDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleClassDeclaration"


    // $ANTLR start "ruleClassDeclaration"
    // InternalSimplejava.g:238:1: ruleClassDeclaration returns [EObject current=null] : (otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' ) | ( (lv_method_6_0= ruleMethod ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleClassDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_attribute_4_0 = null;

        EObject lv_method_6_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:244:2: ( (otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' ) | ( (lv_method_6_0= ruleMethod ) ) )* otherlv_7= '}' ) )
            // InternalSimplejava.g:245:2: (otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' ) | ( (lv_method_6_0= ruleMethod ) ) )* otherlv_7= '}' )
            {
            // InternalSimplejava.g:245:2: (otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' ) | ( (lv_method_6_0= ruleMethod ) ) )* otherlv_7= '}' )
            // InternalSimplejava.g:246:3: otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' ) | ( (lv_method_6_0= ruleMethod ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getClassDeclarationAccess().getPublicKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getClassDeclarationAccess().getClassKeyword_1());
            		
            // InternalSimplejava.g:254:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalSimplejava.g:255:4: (lv_name_2_0= RULE_ID )
            {
            // InternalSimplejava.g:255:4: (lv_name_2_0= RULE_ID )
            // InternalSimplejava.g:256:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_2_0, grammarAccess.getClassDeclarationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClassDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getClassDeclarationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSimplejava.g:276:3: ( ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' ) | ( (lv_method_6_0= ruleMethod ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||(LA2_0>=18 && LA2_0<=21)) ) {
                    alt2=1;
                }
                else if ( (LA2_0==14) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSimplejava.g:277:4: ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' )
            	    {
            	    // InternalSimplejava.g:277:4: ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' )
            	    // InternalSimplejava.g:278:5: ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';'
            	    {
            	    // InternalSimplejava.g:278:5: ( (lv_attribute_4_0= ruleParameter ) )
            	    // InternalSimplejava.g:279:6: (lv_attribute_4_0= ruleParameter )
            	    {
            	    // InternalSimplejava.g:279:6: (lv_attribute_4_0= ruleParameter )
            	    // InternalSimplejava.g:280:7: lv_attribute_4_0= ruleParameter
            	    {

            	    							newCompositeNode(grammarAccess.getClassDeclarationAccess().getAttributeParameterParserRuleCall_4_0_0_0());
            	    						
            	    pushFollow(FOLLOW_5);
            	    lv_attribute_4_0=ruleParameter();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getClassDeclarationRule());
            	    							}
            	    							add(
            	    								current,
            	    								"attribute",
            	    								lv_attribute_4_0,
            	    								"at.ac.tuwien.big.Simplejava.Parameter");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    otherlv_5=(Token)match(input,12,FOLLOW_8); 

            	    					newLeafNode(otherlv_5, grammarAccess.getClassDeclarationAccess().getSemicolonKeyword_4_0_1());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimplejava.g:303:4: ( (lv_method_6_0= ruleMethod ) )
            	    {
            	    // InternalSimplejava.g:303:4: ( (lv_method_6_0= ruleMethod ) )
            	    // InternalSimplejava.g:304:5: (lv_method_6_0= ruleMethod )
            	    {
            	    // InternalSimplejava.g:304:5: (lv_method_6_0= ruleMethod )
            	    // InternalSimplejava.g:305:6: lv_method_6_0= ruleMethod
            	    {

            	    						newCompositeNode(grammarAccess.getClassDeclarationAccess().getMethodMethodParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_method_6_0=ruleMethod();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getClassDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"method",
            	    							lv_method_6_0,
            	    							"at.ac.tuwien.big.Simplejava.Method");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getClassDeclarationAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassDeclaration"


    // $ANTLR start "entryRuleParameter"
    // InternalSimplejava.g:331:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSimplejava.g:331:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSimplejava.g:332:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSimplejava.g:338:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:344:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSimplejava.g:345:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSimplejava.g:345:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSimplejava.g:346:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSimplejava.g:346:3: ( (lv_type_0_0= ruleType ) )
            // InternalSimplejava.g:347:4: (lv_type_0_0= ruleType )
            {
            // InternalSimplejava.g:347:4: (lv_type_0_0= ruleType )
            // InternalSimplejava.g:348:5: lv_type_0_0= ruleType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"at.ac.tuwien.big.Simplejava.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:365:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimplejava.g:366:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimplejava.g:366:4: (lv_name_1_0= RULE_ID )
            // InternalSimplejava.g:367:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleType"
    // InternalSimplejava.g:387:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalSimplejava.g:387:45: (iv_ruleType= ruleType EOF )
            // InternalSimplejava.g:388:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalSimplejava.g:394:1: ruleType returns [EObject current=null] : ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) ) | ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;


        	enterRule();

        try {
            // InternalSimplejava.g:400:2: ( ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) ) | ( ( ruleQualifiedName ) ) ) )
            // InternalSimplejava.g:401:2: ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) ) | ( ( ruleQualifiedName ) ) )
            {
            // InternalSimplejava.g:401:2: ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) ) | ( ( ruleQualifiedName ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=18 && LA4_0<=21)) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalSimplejava.g:402:3: ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) )
                    {
                    // InternalSimplejava.g:402:3: ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) )
                    // InternalSimplejava.g:403:4: ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) )
                    {
                    // InternalSimplejava.g:403:4: ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) )
                    // InternalSimplejava.g:404:5: (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' )
                    {
                    // InternalSimplejava.g:404:5: (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' )
                    int alt3=4;
                    switch ( input.LA(1) ) {
                    case 18:
                        {
                        alt3=1;
                        }
                        break;
                    case 19:
                        {
                        alt3=2;
                        }
                        break;
                    case 20:
                        {
                        alt3=3;
                        }
                        break;
                    case 21:
                        {
                        alt3=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // InternalSimplejava.g:405:6: lv_typeName_0_1= 'int'
                            {
                            lv_typeName_0_1=(Token)match(input,18,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_1, grammarAccess.getTypeAccess().getTypeNameIntKeyword_0_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:416:6: lv_typeName_0_2= 'double'
                            {
                            lv_typeName_0_2=(Token)match(input,19,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_2, grammarAccess.getTypeAccess().getTypeNameDoubleKeyword_0_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalSimplejava.g:427:6: lv_typeName_0_3= 'String'
                            {
                            lv_typeName_0_3=(Token)match(input,20,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_3, grammarAccess.getTypeAccess().getTypeNameStringKeyword_0_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                            					

                            }
                            break;
                        case 4 :
                            // InternalSimplejava.g:438:6: lv_typeName_0_4= 'boolean'
                            {
                            lv_typeName_0_4=(Token)match(input,21,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_4, grammarAccess.getTypeAccess().getTypeNameBooleanKeyword_0_0_3());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:452:3: ( ( ruleQualifiedName ) )
                    {
                    // InternalSimplejava.g:452:3: ( ( ruleQualifiedName ) )
                    // InternalSimplejava.g:453:4: ( ruleQualifiedName )
                    {
                    // InternalSimplejava.g:453:4: ( ruleQualifiedName )
                    // InternalSimplejava.g:454:5: ruleQualifiedName
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTypeRule());
                    					}
                    				

                    					newCompositeNode(grammarAccess.getTypeAccess().getTypeRefClassDeclarationCrossReference_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    ruleQualifiedName();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleMethod"
    // InternalSimplejava.g:472:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalSimplejava.g:472:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalSimplejava.g:473:2: iv_ruleMethod= ruleMethod EOF
            {
             newCompositeNode(grammarAccess.getMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethod=ruleMethod();

            state._fsp--;

             current =iv_ruleMethod; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMethod"


    // $ANTLR start "ruleMethod"
    // InternalSimplejava.g:479:1: ruleMethod returns [EObject current=null] : (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) ) ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_returnType_3_0 = null;

        EObject lv_parameter_6_0 = null;

        EObject lv_parameter_8_0 = null;

        EObject lv_content_10_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:485:2: ( (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) ) ) )
            // InternalSimplejava.g:486:2: (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) ) )
            {
            // InternalSimplejava.g:486:2: (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) ) )
            // InternalSimplejava.g:487:3: otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getMethodAccess().getPublicKeyword_0());
            		
            // InternalSimplejava.g:491:3: ( (lv_static_1_0= 'static' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSimplejava.g:492:4: (lv_static_1_0= 'static' )
                    {
                    // InternalSimplejava.g:492:4: (lv_static_1_0= 'static' )
                    // InternalSimplejava.g:493:5: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,22,FOLLOW_10); 

                    					newLeafNode(lv_static_1_0, grammarAccess.getMethodAccess().getStaticStaticKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodRule());
                    					}
                    					setWithLastConsumed(current, "static", true, "static");
                    				

                    }


                    }
                    break;

            }

            // InternalSimplejava.g:505:3: (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID||(LA6_0>=18 && LA6_0<=21)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSimplejava.g:506:4: otherlv_2= 'void'
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getVoidKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:511:4: ( (lv_returnType_3_0= ruleType ) )
                    {
                    // InternalSimplejava.g:511:4: ( (lv_returnType_3_0= ruleType ) )
                    // InternalSimplejava.g:512:5: (lv_returnType_3_0= ruleType )
                    {
                    // InternalSimplejava.g:512:5: (lv_returnType_3_0= ruleType )
                    // InternalSimplejava.g:513:6: lv_returnType_3_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getReturnTypeTypeParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_returnType_3_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodRule());
                    						}
                    						set(
                    							current,
                    							"returnType",
                    							lv_returnType_3_0,
                    							"at.ac.tuwien.big.Simplejava.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSimplejava.g:531:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalSimplejava.g:532:4: (lv_name_4_0= RULE_ID )
            {
            // InternalSimplejava.g:532:4: (lv_name_4_0= RULE_ID )
            // InternalSimplejava.g:533:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_4_0, grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMethodRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,24,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSimplejava.g:553:3: ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||(LA8_0>=18 && LA8_0<=21)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSimplejava.g:554:4: ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )*
                    {
                    // InternalSimplejava.g:554:4: ( (lv_parameter_6_0= ruleParameter ) )
                    // InternalSimplejava.g:555:5: (lv_parameter_6_0= ruleParameter )
                    {
                    // InternalSimplejava.g:555:5: (lv_parameter_6_0= ruleParameter )
                    // InternalSimplejava.g:556:6: lv_parameter_6_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getParameterParameterParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_parameter_6_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_6_0,
                    							"at.ac.tuwien.big.Simplejava.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimplejava.g:573:4: (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==25) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalSimplejava.g:574:5: otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) )
                    	    {
                    	    otherlv_7=(Token)match(input,25,FOLLOW_14); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getMethodAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalSimplejava.g:578:5: ( (lv_parameter_8_0= ruleParameter ) )
                    	    // InternalSimplejava.g:579:6: (lv_parameter_8_0= ruleParameter )
                    	    {
                    	    // InternalSimplejava.g:579:6: (lv_parameter_8_0= ruleParameter )
                    	    // InternalSimplejava.g:580:7: lv_parameter_8_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodAccess().getParameterParameterParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_parameter_8_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMethodRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_8_0,
                    	    								"at.ac.tuwien.big.Simplejava.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,26,FOLLOW_15); 

            			newLeafNode(otherlv_9, grammarAccess.getMethodAccess().getRightParenthesisKeyword_6());
            		
            // InternalSimplejava.g:603:3: ( (lv_content_10_0= ruleMethodBlock ) )
            // InternalSimplejava.g:604:4: (lv_content_10_0= ruleMethodBlock )
            {
            // InternalSimplejava.g:604:4: (lv_content_10_0= ruleMethodBlock )
            // InternalSimplejava.g:605:5: lv_content_10_0= ruleMethodBlock
            {

            					newCompositeNode(grammarAccess.getMethodAccess().getContentMethodBlockParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_content_10_0=ruleMethodBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMethodRule());
            					}
            					set(
            						current,
            						"content",
            						lv_content_10_0,
            						"at.ac.tuwien.big.Simplejava.MethodBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "entryRuleMethodBlock"
    // InternalSimplejava.g:626:1: entryRuleMethodBlock returns [EObject current=null] : iv_ruleMethodBlock= ruleMethodBlock EOF ;
    public final EObject entryRuleMethodBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodBlock = null;


        try {
            // InternalSimplejava.g:626:52: (iv_ruleMethodBlock= ruleMethodBlock EOF )
            // InternalSimplejava.g:627:2: iv_ruleMethodBlock= ruleMethodBlock EOF
            {
             newCompositeNode(grammarAccess.getMethodBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodBlock=ruleMethodBlock();

            state._fsp--;

             current =iv_ruleMethodBlock; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMethodBlock"


    // $ANTLR start "ruleMethodBlock"
    // InternalSimplejava.g:633:1: ruleMethodBlock returns [EObject current=null] : ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleMethodBlock() throws RecognitionException {
        EObject current = null;

        Token lv_generated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statements_3_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:639:2: ( ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) ) )
            // InternalSimplejava.g:640:2: ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) )
            {
            // InternalSimplejava.g:640:2: ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) )
            // InternalSimplejava.g:641:3: () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' )
            {
            // InternalSimplejava.g:641:3: ()
            // InternalSimplejava.g:642:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodBlockAccess().getMethodBlockAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:648:3: ( (lv_generated_1_0= 'pointcutblock' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSimplejava.g:649:4: (lv_generated_1_0= 'pointcutblock' )
                    {
                    // InternalSimplejava.g:649:4: (lv_generated_1_0= 'pointcutblock' )
                    // InternalSimplejava.g:650:5: lv_generated_1_0= 'pointcutblock'
                    {
                    lv_generated_1_0=(Token)match(input,27,FOLLOW_7); 

                    					newLeafNode(lv_generated_1_0, grammarAccess.getMethodBlockAccess().getGeneratedPointcutblockKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodBlockRule());
                    					}
                    					setWithLastConsumed(current, "generated", true, "pointcutblock");
                    				

                    }


                    }
                    break;

            }

            // InternalSimplejava.g:662:3: (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' )
            // InternalSimplejava.g:663:4: otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}'
            {
            otherlv_2=(Token)match(input,16,FOLLOW_16); 

            				newLeafNode(otherlv_2, grammarAccess.getMethodBlockAccess().getLeftCurlyBracketKeyword_2_0());
            			
            // InternalSimplejava.g:667:4: ( (lv_statements_3_0= ruleStatement ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||LA10_0==16||(LA10_0>=18 && LA10_0<=21)||LA10_0==27||LA10_0==29||LA10_0==31||(LA10_0>=33 && LA10_0<=35)||(LA10_0>=37 && LA10_0<=39)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSimplejava.g:668:5: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalSimplejava.g:668:5: (lv_statements_3_0= ruleStatement )
            	    // InternalSimplejava.g:669:6: lv_statements_3_0= ruleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getMethodBlockAccess().getStatementsStatementParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMethodBlockRule());
            	    						}
            	    						add(
            	    							current,
            	    							"statements",
            	    							lv_statements_3_0,
            	    							"at.ac.tuwien.big.Simplejava.Statement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

            				newLeafNode(otherlv_4, grammarAccess.getMethodBlockAccess().getRightCurlyBracketKeyword_2_2());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodBlock"


    // $ANTLR start "entryRuleSimpleStatement"
    // InternalSimplejava.g:695:1: entryRuleSimpleStatement returns [EObject current=null] : iv_ruleSimpleStatement= ruleSimpleStatement EOF ;
    public final EObject entryRuleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleStatement = null;


        try {
            // InternalSimplejava.g:695:56: (iv_ruleSimpleStatement= ruleSimpleStatement EOF )
            // InternalSimplejava.g:696:2: iv_ruleSimpleStatement= ruleSimpleStatement EOF
            {
             newCompositeNode(grammarAccess.getSimpleStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleStatement=ruleSimpleStatement();

            state._fsp--;

             current =iv_ruleSimpleStatement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleStatement"


    // $ANTLR start "ruleSimpleStatement"
    // InternalSimplejava.g:702:1: ruleSimpleStatement returns [EObject current=null] : (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment ) ;
    public final EObject ruleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleVariableDeclaration_0 = null;

        EObject this_Assignment_1 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:708:2: ( (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment ) )
            // InternalSimplejava.g:709:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )
            {
            // InternalSimplejava.g:709:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalSimplejava.g:710:3: this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration
                    {

                    			newCompositeNode(grammarAccess.getSimpleStatementAccess().getSimpleVariableDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleVariableDeclaration_0=ruleSimpleVariableDeclaration();

                    state._fsp--;


                    			current = this_SimpleVariableDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:719:3: this_Assignment_1= ruleAssignment
                    {

                    			newCompositeNode(grammarAccess.getSimpleStatementAccess().getAssignmentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Assignment_1=ruleAssignment();

                    state._fsp--;


                    			current = this_Assignment_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleStatement"


    // $ANTLR start "entryRuleStatement"
    // InternalSimplejava.g:731:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalSimplejava.g:731:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalSimplejava.g:732:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalSimplejava.g:738:1: ruleStatement returns [EObject current=null] : (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_MethodBlock_0 = null;

        EObject this_VariableDeclaration_1 = null;

        EObject this_Assignment_2 = null;

        EObject this_IfStatement_3 = null;

        EObject this_ForStatement_4 = null;

        EObject this_ForInStatement_5 = null;

        EObject this_WhileStatement_6 = null;

        EObject this_ReturnStatement_7 = null;

        EObject this_MethodCall_8 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:744:2: ( (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall ) )
            // InternalSimplejava.g:745:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall )
            {
            // InternalSimplejava.g:745:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall )
            int alt12=9;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalSimplejava.g:746:3: this_MethodBlock_0= ruleMethodBlock
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getMethodBlockParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MethodBlock_0=ruleMethodBlock();

                    state._fsp--;


                    			current = this_MethodBlock_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:755:3: this_VariableDeclaration_1= ruleVariableDeclaration
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getVariableDeclarationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableDeclaration_1=ruleVariableDeclaration();

                    state._fsp--;


                    			current = this_VariableDeclaration_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSimplejava.g:764:3: this_Assignment_2= ruleAssignment
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Assignment_2=ruleAssignment();

                    state._fsp--;


                    			current = this_Assignment_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSimplejava.g:773:3: this_IfStatement_3= ruleIfStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_IfStatement_3=ruleIfStatement();

                    state._fsp--;


                    			current = this_IfStatement_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSimplejava.g:782:3: this_ForStatement_4= ruleForStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getForStatementParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForStatement_4=ruleForStatement();

                    state._fsp--;


                    			current = this_ForStatement_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSimplejava.g:791:3: this_ForInStatement_5= ruleForInStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getForInStatementParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForInStatement_5=ruleForInStatement();

                    state._fsp--;


                    			current = this_ForInStatement_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalSimplejava.g:800:3: this_WhileStatement_6= ruleWhileStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_WhileStatement_6=ruleWhileStatement();

                    state._fsp--;


                    			current = this_WhileStatement_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalSimplejava.g:809:3: this_ReturnStatement_7= ruleReturnStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReturnStatement_7=ruleReturnStatement();

                    state._fsp--;


                    			current = this_ReturnStatement_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalSimplejava.g:818:3: this_MethodCall_8= ruleMethodCall
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getMethodCallParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_MethodCall_8=ruleMethodCall();

                    state._fsp--;


                    			current = this_MethodCall_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleSimpleVariableDeclaration"
    // InternalSimplejava.g:830:1: entryRuleSimpleVariableDeclaration returns [EObject current=null] : iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF ;
    public final EObject entryRuleSimpleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleVariableDeclaration = null;


        try {
            // InternalSimplejava.g:830:66: (iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF )
            // InternalSimplejava.g:831:2: iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getSimpleVariableDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleVariableDeclaration=ruleSimpleVariableDeclaration();

            state._fsp--;

             current =iv_ruleSimpleVariableDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleVariableDeclaration"


    // $ANTLR start "ruleSimpleVariableDeclaration"
    // InternalSimplejava.g:837:1: ruleSimpleVariableDeclaration returns [EObject current=null] : ( () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleSimpleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_parameter_1_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:843:2: ( ( () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) )
            // InternalSimplejava.g:844:2: ( () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            {
            // InternalSimplejava.g:844:2: ( () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            // InternalSimplejava.g:845:3: () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) )
            {
            // InternalSimplejava.g:845:3: ()
            // InternalSimplejava.g:846:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleVariableDeclarationAccess().getVariableDeclarationAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:852:3: ( (lv_parameter_1_0= ruleParameter ) )
            // InternalSimplejava.g:853:4: (lv_parameter_1_0= ruleParameter )
            {
            // InternalSimplejava.g:853:4: (lv_parameter_1_0= ruleParameter )
            // InternalSimplejava.g:854:5: lv_parameter_1_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getSimpleVariableDeclarationAccess().getParameterParameterParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_17);
            lv_parameter_1_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleVariableDeclarationRule());
            					}
            					set(
            						current,
            						"parameter",
            						lv_parameter_1_0,
            						"at.ac.tuwien.big.Simplejava.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleVariableDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalSimplejava.g:875:3: ( (lv_expression_3_0= ruleGenericExpression ) )
            // InternalSimplejava.g:876:4: (lv_expression_3_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:876:4: (lv_expression_3_0= ruleGenericExpression )
            // InternalSimplejava.g:877:5: lv_expression_3_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getSimpleVariableDeclarationAccess().getExpressionGenericExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_3_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleVariableDeclarationRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"at.ac.tuwien.big.Simplejava.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleVariableDeclaration"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalSimplejava.g:898:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalSimplejava.g:898:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalSimplejava.g:899:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalSimplejava.g:905:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parameter_0_0 = null;

        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:911:2: ( ( ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) )
            // InternalSimplejava.g:912:2: ( ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            {
            // InternalSimplejava.g:912:2: ( ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            // InternalSimplejava.g:913:3: ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';'
            {
            // InternalSimplejava.g:913:3: ( (lv_parameter_0_0= ruleParameter ) )
            // InternalSimplejava.g:914:4: (lv_parameter_0_0= ruleParameter )
            {
            // InternalSimplejava.g:914:4: (lv_parameter_0_0= ruleParameter )
            // InternalSimplejava.g:915:5: lv_parameter_0_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getParameterParameterParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_parameter_0_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            					}
            					set(
            						current,
            						"parameter",
            						lv_parameter_0_0,
            						"at.ac.tuwien.big.Simplejava.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_1());
            		
            // InternalSimplejava.g:936:3: ( (lv_expression_2_0= ruleGenericExpression ) )
            // InternalSimplejava.g:937:4: (lv_expression_2_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:937:4: (lv_expression_2_0= ruleGenericExpression )
            // InternalSimplejava.g:938:5: lv_expression_2_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionGenericExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_expression_2_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_2_0,
            						"at.ac.tuwien.big.Simplejava.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleAssignment"
    // InternalSimplejava.g:963:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalSimplejava.g:963:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalSimplejava.g:964:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalSimplejava.g:970:1: ruleAssignment returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:976:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) )
            // InternalSimplejava.g:977:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            {
            // InternalSimplejava.g:977:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            // InternalSimplejava.g:978:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';'
            {
            // InternalSimplejava.g:978:3: ( ( ruleQualifiedName ) )
            // InternalSimplejava.g:979:4: ( ruleQualifiedName )
            {
            // InternalSimplejava.g:979:4: ( ruleQualifiedName )
            // InternalSimplejava.g:980:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssignmentAccess().getParameterParameterCrossReference_0_0());
            				
            pushFollow(FOLLOW_17);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
            		
            // InternalSimplejava.g:998:3: ( (lv_expression_2_0= ruleGenericExpression ) )
            // InternalSimplejava.g:999:4: (lv_expression_2_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:999:4: (lv_expression_2_0= ruleGenericExpression )
            // InternalSimplejava.g:1000:5: lv_expression_2_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionGenericExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_expression_2_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_2_0,
            						"at.ac.tuwien.big.Simplejava.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getAssignmentAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleIfStatement"
    // InternalSimplejava.g:1025:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalSimplejava.g:1025:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalSimplejava.g:1026:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSimplejava.g:1032:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_condition_1_0 = null;

        EObject lv_then_2_0 = null;

        EObject lv_else_4_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1038:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? ) )
            // InternalSimplejava.g:1039:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? )
            {
            // InternalSimplejava.g:1039:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? )
            // InternalSimplejava.g:1040:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
            		
            // InternalSimplejava.g:1044:3: ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) )
            // InternalSimplejava.g:1045:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            {
            // InternalSimplejava.g:1045:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            // InternalSimplejava.g:1046:5: lv_condition_1_0= ruleParanthesisOrBinaryExpression
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getConditionParanthesisOrBinaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_15);
            lv_condition_1_0=ruleParanthesisOrBinaryExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"at.ac.tuwien.big.Simplejava.ParanthesisOrBinaryExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:1063:3: ( (lv_then_2_0= ruleMethodBlock ) )
            // InternalSimplejava.g:1064:4: (lv_then_2_0= ruleMethodBlock )
            {
            // InternalSimplejava.g:1064:4: (lv_then_2_0= ruleMethodBlock )
            // InternalSimplejava.g:1065:5: lv_then_2_0= ruleMethodBlock
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getThenMethodBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_then_2_0=ruleMethodBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					set(
            						current,
            						"then",
            						lv_then_2_0,
            						"at.ac.tuwien.big.Simplejava.MethodBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:1082:3: (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==30) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalSimplejava.g:1083:4: otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) )
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_15); 

                    				newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getElseKeyword_3_0());
                    			
                    // InternalSimplejava.g:1087:4: ( (lv_else_4_0= ruleMethodBlock ) )
                    // InternalSimplejava.g:1088:5: (lv_else_4_0= ruleMethodBlock )
                    {
                    // InternalSimplejava.g:1088:5: (lv_else_4_0= ruleMethodBlock )
                    // InternalSimplejava.g:1089:6: lv_else_4_0= ruleMethodBlock
                    {

                    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseMethodBlockParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_else_4_0=ruleMethodBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIfStatementRule());
                    						}
                    						set(
                    							current,
                    							"else",
                    							lv_else_4_0,
                    							"at.ac.tuwien.big.Simplejava.MethodBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalSimplejava.g:1111:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalSimplejava.g:1111:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalSimplejava.g:1112:2: iv_ruleForStatement= ruleForStatement EOF
            {
             newCompositeNode(grammarAccess.getForStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForStatement=ruleForStatement();

            state._fsp--;

             current =iv_ruleForStatement; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSimplejava.g:1118:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) ) ;
    public final EObject ruleForStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_init_2_0 = null;

        EObject lv_condition_4_0 = null;

        EObject lv_continuation_6_0 = null;

        EObject lv_body_8_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1124:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1125:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1125:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) )
            // InternalSimplejava.g:1126:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1134:3: ( (lv_init_2_0= ruleSimpleStatement ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID||(LA14_0>=18 && LA14_0<=21)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalSimplejava.g:1135:4: (lv_init_2_0= ruleSimpleStatement )
                    {
                    // InternalSimplejava.g:1135:4: (lv_init_2_0= ruleSimpleStatement )
                    // InternalSimplejava.g:1136:5: lv_init_2_0= ruleSimpleStatement
                    {

                    					newCompositeNode(grammarAccess.getForStatementAccess().getInitSimpleStatementParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_5);
                    lv_init_2_0=ruleSimpleStatement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getForStatementRule());
                    					}
                    					set(
                    						current,
                    						"init",
                    						lv_init_2_0,
                    						"at.ac.tuwien.big.Simplejava.SimpleStatement");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getForStatementAccess().getSemicolonKeyword_3());
            		
            // InternalSimplejava.g:1157:3: ( (lv_condition_4_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1158:4: (lv_condition_4_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1158:4: (lv_condition_4_0= ruleGenericExpression )
            // InternalSimplejava.g:1159:5: lv_condition_4_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getConditionGenericExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_5);
            lv_condition_4_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_4_0,
            						"at.ac.tuwien.big.Simplejava.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_5, grammarAccess.getForStatementAccess().getSemicolonKeyword_5());
            		
            // InternalSimplejava.g:1180:3: ( (lv_continuation_6_0= ruleSimpleStatement ) )
            // InternalSimplejava.g:1181:4: (lv_continuation_6_0= ruleSimpleStatement )
            {
            // InternalSimplejava.g:1181:4: (lv_continuation_6_0= ruleSimpleStatement )
            // InternalSimplejava.g:1182:5: lv_continuation_6_0= ruleSimpleStatement
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getContinuationSimpleStatementParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_21);
            lv_continuation_6_0=ruleSimpleStatement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"continuation",
            						lv_continuation_6_0,
            						"at.ac.tuwien.big.Simplejava.SimpleStatement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,26,FOLLOW_22); 

            			newLeafNode(otherlv_7, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());
            		
            // InternalSimplejava.g:1203:3: ( (lv_body_8_0= ruleStatement ) )
            // InternalSimplejava.g:1204:4: (lv_body_8_0= ruleStatement )
            {
            // InternalSimplejava.g:1204:4: (lv_body_8_0= ruleStatement )
            // InternalSimplejava.g:1205:5: lv_body_8_0= ruleStatement
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getBodyStatementParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_8_0=ruleStatement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_8_0,
            						"at.ac.tuwien.big.Simplejava.Statement");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleForInStatement"
    // InternalSimplejava.g:1226:1: entryRuleForInStatement returns [EObject current=null] : iv_ruleForInStatement= ruleForInStatement EOF ;
    public final EObject entryRuleForInStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForInStatement = null;


        try {
            // InternalSimplejava.g:1226:55: (iv_ruleForInStatement= ruleForInStatement EOF )
            // InternalSimplejava.g:1227:2: iv_ruleForInStatement= ruleForInStatement EOF
            {
             newCompositeNode(grammarAccess.getForInStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForInStatement=ruleForInStatement();

            state._fsp--;

             current =iv_ruleForInStatement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleForInStatement"


    // $ANTLR start "ruleForInStatement"
    // InternalSimplejava.g:1233:1: ruleForInStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) ) ;
    public final EObject ruleForInStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_subparameter_2_0 = null;

        EObject lv_expression_4_0 = null;

        EObject lv_body_6_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1239:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1240:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1240:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) )
            // InternalSimplejava.g:1241:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getForInStatementAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getForInStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1249:3: ( (lv_subparameter_2_0= ruleParameter ) )
            // InternalSimplejava.g:1250:4: (lv_subparameter_2_0= ruleParameter )
            {
            // InternalSimplejava.g:1250:4: (lv_subparameter_2_0= ruleParameter )
            // InternalSimplejava.g:1251:5: lv_subparameter_2_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getSubparameterParameterParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_subparameter_2_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForInStatementRule());
            					}
            					set(
            						current,
            						"subparameter",
            						lv_subparameter_2_0,
            						"at.ac.tuwien.big.Simplejava.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,32,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getForInStatementAccess().getColonKeyword_3());
            		
            // InternalSimplejava.g:1272:3: ( (lv_expression_4_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1273:4: (lv_expression_4_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1273:4: (lv_expression_4_0= ruleGenericExpression )
            // InternalSimplejava.g:1274:5: lv_expression_4_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getExpressionGenericExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_expression_4_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForInStatementRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_4_0,
            						"at.ac.tuwien.big.Simplejava.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,26,FOLLOW_22); 

            			newLeafNode(otherlv_5, grammarAccess.getForInStatementAccess().getRightParenthesisKeyword_5());
            		
            // InternalSimplejava.g:1295:3: ( (lv_body_6_0= ruleStatement ) )
            // InternalSimplejava.g:1296:4: (lv_body_6_0= ruleStatement )
            {
            // InternalSimplejava.g:1296:4: (lv_body_6_0= ruleStatement )
            // InternalSimplejava.g:1297:5: lv_body_6_0= ruleStatement
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getBodyStatementParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_6_0=ruleStatement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForInStatementRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_6_0,
            						"at.ac.tuwien.big.Simplejava.Statement");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForInStatement"


    // $ANTLR start "entryRuleWhileStatement"
    // InternalSimplejava.g:1318:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalSimplejava.g:1318:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalSimplejava.g:1319:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             newCompositeNode(grammarAccess.getWhileStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // InternalSimplejava.g:1325:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;

        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1331:2: ( (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1332:2: (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1332:2: (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) )
            // InternalSimplejava.g:1333:3: otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
            		
            // InternalSimplejava.g:1337:3: ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) )
            // InternalSimplejava.g:1338:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            {
            // InternalSimplejava.g:1338:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            // InternalSimplejava.g:1339:5: lv_condition_1_0= ruleParanthesisOrBinaryExpression
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionParanthesisOrBinaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_22);
            lv_condition_1_0=ruleParanthesisOrBinaryExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"at.ac.tuwien.big.Simplejava.ParanthesisOrBinaryExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:1356:3: ( (lv_body_2_0= ruleStatement ) )
            // InternalSimplejava.g:1357:4: (lv_body_2_0= ruleStatement )
            {
            // InternalSimplejava.g:1357:4: (lv_body_2_0= ruleStatement )
            // InternalSimplejava.g:1358:5: lv_body_2_0= ruleStatement
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getBodyStatementParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_2_0=ruleStatement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_2_0,
            						"at.ac.tuwien.big.Simplejava.Statement");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // InternalSimplejava.g:1379:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // InternalSimplejava.g:1379:56: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // InternalSimplejava.g:1380:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             newCompositeNode(grammarAccess.getReturnStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalSimplejava.g:1386:1: ruleReturnStatement returns [EObject current=null] : (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1392:2: ( (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' ) )
            // InternalSimplejava.g:1393:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' )
            {
            // InternalSimplejava.g:1393:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' )
            // InternalSimplejava.g:1394:3: otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getReturnStatementAccess().getReturnKeyword_0());
            		
            // InternalSimplejava.g:1398:3: ( (lv_expression_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1399:4: (lv_expression_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1399:4: (lv_expression_1_0= ruleGenericExpression )
            // InternalSimplejava.g:1400:5: lv_expression_1_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionGenericExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_expression_1_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReturnStatementRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_1_0,
            						"at.ac.tuwien.big.Simplejava.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getReturnStatementAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleMethodCall"
    // InternalSimplejava.g:1425:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSimplejava.g:1425:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSimplejava.g:1426:2: iv_ruleMethodCall= ruleMethodCall EOF
            {
             newCompositeNode(grammarAccess.getMethodCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodCall=ruleMethodCall();

            state._fsp--;

             current =iv_ruleMethodCall; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMethodCall"


    // $ANTLR start "ruleMethodCall"
    // InternalSimplejava.g:1432:1: ruleMethodCall returns [EObject current=null] : ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';' ) ;
    public final EObject ruleMethodCall() throws RecognitionException {
        EObject current = null;

        Token lv_thisObject_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_methodName_4_1=null;
        Token lv_methodName_4_2=null;
        Token lv_methodName_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_parameter_7_0 = null;

        EObject lv_parameter_9_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1438:2: ( ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';' ) )
            // InternalSimplejava.g:1439:2: ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';' )
            {
            // InternalSimplejava.g:1439:2: ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';' )
            // InternalSimplejava.g:1440:3: ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';'
            {
            // InternalSimplejava.g:1440:3: ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID||LA19_0==35||(LA19_0>=37 && LA19_0<=38)) ) {
                alt19=1;
            }
            else if ( (LA19_0==39) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalSimplejava.g:1441:4: ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) )
                    {
                    // InternalSimplejava.g:1441:4: ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) )
                    // InternalSimplejava.g:1442:5: ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) )
                    {
                    // InternalSimplejava.g:1442:5: ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_ID) ) {
                        int LA16_1 = input.LA(2);

                        if ( (LA16_1==36) ) {
                            alt16=1;
                        }
                    }
                    else if ( (LA16_0==35) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalSimplejava.g:1443:6: ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.'
                            {
                            // InternalSimplejava.g:1443:6: ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) )
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==RULE_ID) ) {
                                alt15=1;
                            }
                            else if ( (LA15_0==35) ) {
                                alt15=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 15, 0, input);

                                throw nvae;
                            }
                            switch (alt15) {
                                case 1 :
                                    // InternalSimplejava.g:1444:7: ( ( ruleQualifiedName ) )
                                    {
                                    // InternalSimplejava.g:1444:7: ( ( ruleQualifiedName ) )
                                    // InternalSimplejava.g:1445:8: ( ruleQualifiedName )
                                    {
                                    // InternalSimplejava.g:1445:8: ( ruleQualifiedName )
                                    // InternalSimplejava.g:1446:9: ruleQualifiedName
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getMethodCallRule());
                                    									}
                                    								

                                    									newCompositeNode(grammarAccess.getMethodCallAccess().getObjectParameterCrossReference_0_0_0_0_0_0());
                                    								
                                    pushFollow(FOLLOW_24);
                                    ruleQualifiedName();

                                    state._fsp--;


                                    									afterParserOrEnumRuleCall();
                                    								

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalSimplejava.g:1461:7: ( (lv_thisObject_1_0= 'this' ) )
                                    {
                                    // InternalSimplejava.g:1461:7: ( (lv_thisObject_1_0= 'this' ) )
                                    // InternalSimplejava.g:1462:8: (lv_thisObject_1_0= 'this' )
                                    {
                                    // InternalSimplejava.g:1462:8: (lv_thisObject_1_0= 'this' )
                                    // InternalSimplejava.g:1463:9: lv_thisObject_1_0= 'this'
                                    {
                                    lv_thisObject_1_0=(Token)match(input,35,FOLLOW_24); 

                                    									newLeafNode(lv_thisObject_1_0, grammarAccess.getMethodCallAccess().getThisObjectThisKeyword_0_0_0_0_1_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getMethodCallRule());
                                    									}
                                    									setWithLastConsumed(current, "thisObject", true, "this");
                                    								

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_2=(Token)match(input,36,FOLLOW_25); 

                            						newLeafNode(otherlv_2, grammarAccess.getMethodCallAccess().getFullStopKeyword_0_0_0_1());
                            					

                            }
                            break;

                    }

                    // InternalSimplejava.g:1481:5: ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ID) ) {
                        alt18=1;
                    }
                    else if ( ((LA18_0>=37 && LA18_0<=38)) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalSimplejava.g:1482:6: ( (otherlv_3= RULE_ID ) )
                            {
                            // InternalSimplejava.g:1482:6: ( (otherlv_3= RULE_ID ) )
                            // InternalSimplejava.g:1483:7: (otherlv_3= RULE_ID )
                            {
                            // InternalSimplejava.g:1483:7: (otherlv_3= RULE_ID )
                            // InternalSimplejava.g:1484:8: otherlv_3= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            							
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_11); 

                            								newLeafNode(otherlv_3, grammarAccess.getMethodCallAccess().getMethodMethodCrossReference_0_0_1_0_0());
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:1496:6: ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) )
                            {
                            // InternalSimplejava.g:1496:6: ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) )
                            // InternalSimplejava.g:1497:7: ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) )
                            {
                            // InternalSimplejava.g:1497:7: ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) )
                            // InternalSimplejava.g:1498:8: (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' )
                            {
                            // InternalSimplejava.g:1498:8: (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' )
                            int alt17=2;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==37) ) {
                                alt17=1;
                            }
                            else if ( (LA17_0==38) ) {
                                alt17=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 0, input);

                                throw nvae;
                            }
                            switch (alt17) {
                                case 1 :
                                    // InternalSimplejava.g:1499:9: lv_methodName_4_1= 'equals'
                                    {
                                    lv_methodName_4_1=(Token)match(input,37,FOLLOW_11); 

                                    									newLeafNode(lv_methodName_4_1, grammarAccess.getMethodCallAccess().getMethodNameEqualsKeyword_0_0_1_1_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getMethodCallRule());
                                    									}
                                    									setWithLastConsumed(current, "methodName", lv_methodName_4_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSimplejava.g:1510:9: lv_methodName_4_2= 'hashCode'
                                    {
                                    lv_methodName_4_2=(Token)match(input,38,FOLLOW_11); 

                                    									newLeafNode(lv_methodName_4_2, grammarAccess.getMethodCallAccess().getMethodNameHashCodeKeyword_0_0_1_1_0_1());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getMethodCallRule());
                                    									}
                                    									setWithLastConsumed(current, "methodName", lv_methodName_4_2, null);
                                    								

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:1526:4: ( (lv_methodName_5_0= 'System.out.println' ) )
                    {
                    // InternalSimplejava.g:1526:4: ( (lv_methodName_5_0= 'System.out.println' ) )
                    // InternalSimplejava.g:1527:5: (lv_methodName_5_0= 'System.out.println' )
                    {
                    // InternalSimplejava.g:1527:5: (lv_methodName_5_0= 'System.out.println' )
                    // InternalSimplejava.g:1528:6: lv_methodName_5_0= 'System.out.println'
                    {
                    lv_methodName_5_0=(Token)match(input,39,FOLLOW_11); 

                    						newLeafNode(lv_methodName_5_0, grammarAccess.getMethodCallAccess().getMethodNameSystemOutPrintlnKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMethodCallRule());
                    						}
                    						setWithLastConsumed(current, "methodName", lv_methodName_5_0, "System.out.println");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_26); 

            			newLeafNode(otherlv_6, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1545:3: ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==24||LA21_0==35||(LA21_0>=37 && LA21_0<=43)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSimplejava.g:1546:4: ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )*
                    {
                    // InternalSimplejava.g:1546:4: ( (lv_parameter_7_0= ruleGenericExpression ) )
                    // InternalSimplejava.g:1547:5: (lv_parameter_7_0= ruleGenericExpression )
                    {
                    // InternalSimplejava.g:1547:5: (lv_parameter_7_0= ruleGenericExpression )
                    // InternalSimplejava.g:1548:6: lv_parameter_7_0= ruleGenericExpression
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getParameterGenericExpressionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_parameter_7_0=ruleGenericExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_7_0,
                    							"at.ac.tuwien.big.Simplejava.GenericExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimplejava.g:1565:4: (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==25) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalSimplejava.g:1566:5: otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) )
                    	    {
                    	    otherlv_8=(Token)match(input,25,FOLLOW_18); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getMethodCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalSimplejava.g:1570:5: ( (lv_parameter_9_0= ruleGenericExpression ) )
                    	    // InternalSimplejava.g:1571:6: (lv_parameter_9_0= ruleGenericExpression )
                    	    {
                    	    // InternalSimplejava.g:1571:6: (lv_parameter_9_0= ruleGenericExpression )
                    	    // InternalSimplejava.g:1572:7: lv_parameter_9_0= ruleGenericExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodCallAccess().getParameterGenericExpressionParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_parameter_9_0=ruleGenericExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_9_0,
                    	    								"at.ac.tuwien.big.Simplejava.GenericExpression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,26,FOLLOW_5); 

            			newLeafNode(otherlv_10, grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_3());
            		
            otherlv_11=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getMethodCallAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodCall"


    // $ANTLR start "entryRuleGenericExpression"
    // InternalSimplejava.g:1603:1: entryRuleGenericExpression returns [EObject current=null] : iv_ruleGenericExpression= ruleGenericExpression EOF ;
    public final EObject entryRuleGenericExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericExpression = null;


        try {
            // InternalSimplejava.g:1603:58: (iv_ruleGenericExpression= ruleGenericExpression EOF )
            // InternalSimplejava.g:1604:2: iv_ruleGenericExpression= ruleGenericExpression EOF
            {
             newCompositeNode(grammarAccess.getGenericExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenericExpression=ruleGenericExpression();

            state._fsp--;

             current =iv_ruleGenericExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleGenericExpression"


    // $ANTLR start "ruleGenericExpression"
    // InternalSimplejava.g:1610:1: ruleGenericExpression returns [EObject current=null] : (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression ) ;
    public final EObject ruleGenericExpression() throws RecognitionException {
        EObject current = null;

        EObject this_VariableExpression_0 = null;

        EObject this_MethodCall_1 = null;

        EObject this_ParanthesisOrBinaryExpression_2 = null;

        EObject this_UnaryExpression_3 = null;

        EObject this_ConstantExpression_4 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1616:2: ( (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression ) )
            // InternalSimplejava.g:1617:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression )
            {
            // InternalSimplejava.g:1617:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression )
            int alt22=5;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalSimplejava.g:1618:3: this_VariableExpression_0= ruleVariableExpression
                    {

                    			newCompositeNode(grammarAccess.getGenericExpressionAccess().getVariableExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableExpression_0=ruleVariableExpression();

                    state._fsp--;


                    			current = this_VariableExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:1627:3: this_MethodCall_1= ruleMethodCall
                    {

                    			newCompositeNode(grammarAccess.getGenericExpressionAccess().getMethodCallParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MethodCall_1=ruleMethodCall();

                    state._fsp--;


                    			current = this_MethodCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSimplejava.g:1636:3: this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression
                    {

                    			newCompositeNode(grammarAccess.getGenericExpressionAccess().getParanthesisOrBinaryExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParanthesisOrBinaryExpression_2=ruleParanthesisOrBinaryExpression();

                    state._fsp--;


                    			current = this_ParanthesisOrBinaryExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSimplejava.g:1645:3: this_UnaryExpression_3= ruleUnaryExpression
                    {

                    			newCompositeNode(grammarAccess.getGenericExpressionAccess().getUnaryExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_3=ruleUnaryExpression();

                    state._fsp--;


                    			current = this_UnaryExpression_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSimplejava.g:1654:3: this_ConstantExpression_4= ruleConstantExpression
                    {

                    			newCompositeNode(grammarAccess.getGenericExpressionAccess().getConstantExpressionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConstantExpression_4=ruleConstantExpression();

                    state._fsp--;


                    			current = this_ConstantExpression_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenericExpression"


    // $ANTLR start "entryRuleConstantExpression"
    // InternalSimplejava.g:1666:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalSimplejava.g:1666:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalSimplejava.g:1667:2: iv_ruleConstantExpression= ruleConstantExpression EOF
            {
             newCompositeNode(grammarAccess.getConstantExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantExpression=ruleConstantExpression();

            state._fsp--;

             current =iv_ruleConstantExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleConstantExpression"


    // $ANTLR start "ruleConstantExpression"
    // InternalSimplejava.g:1673:1: ruleConstantExpression returns [EObject current=null] : (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerExpression_0 = null;

        EObject this_StringExpression_1 = null;

        EObject this_BooleanExpression_2 = null;

        EObject this_NullExpression_3 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1679:2: ( (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression ) )
            // InternalSimplejava.g:1680:2: (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression )
            {
            // InternalSimplejava.g:1680:2: (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression )
            int alt23=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt23=1;
                }
                break;
            case RULE_STRING:
                {
                alt23=2;
                }
                break;
            case 41:
            case 42:
                {
                alt23=3;
                }
                break;
            case 40:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalSimplejava.g:1681:3: this_IntegerExpression_0= ruleIntegerExpression
                    {

                    			newCompositeNode(grammarAccess.getConstantExpressionAccess().getIntegerExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerExpression_0=ruleIntegerExpression();

                    state._fsp--;


                    			current = this_IntegerExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:1690:3: this_StringExpression_1= ruleStringExpression
                    {

                    			newCompositeNode(grammarAccess.getConstantExpressionAccess().getStringExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringExpression_1=ruleStringExpression();

                    state._fsp--;


                    			current = this_StringExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSimplejava.g:1699:3: this_BooleanExpression_2= ruleBooleanExpression
                    {

                    			newCompositeNode(grammarAccess.getConstantExpressionAccess().getBooleanExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanExpression_2=ruleBooleanExpression();

                    state._fsp--;


                    			current = this_BooleanExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSimplejava.g:1708:3: this_NullExpression_3= ruleNullExpression
                    {

                    			newCompositeNode(grammarAccess.getConstantExpressionAccess().getNullExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_NullExpression_3=ruleNullExpression();

                    state._fsp--;


                    			current = this_NullExpression_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantExpression"


    // $ANTLR start "entryRuleNullExpression"
    // InternalSimplejava.g:1720:1: entryRuleNullExpression returns [EObject current=null] : iv_ruleNullExpression= ruleNullExpression EOF ;
    public final EObject entryRuleNullExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExpression = null;


        try {
            // InternalSimplejava.g:1720:55: (iv_ruleNullExpression= ruleNullExpression EOF )
            // InternalSimplejava.g:1721:2: iv_ruleNullExpression= ruleNullExpression EOF
            {
             newCompositeNode(grammarAccess.getNullExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNullExpression=ruleNullExpression();

            state._fsp--;

             current =iv_ruleNullExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNullExpression"


    // $ANTLR start "ruleNullExpression"
    // InternalSimplejava.g:1727:1: ruleNullExpression returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSimplejava.g:1733:2: ( ( () otherlv_1= 'null' ) )
            // InternalSimplejava.g:1734:2: ( () otherlv_1= 'null' )
            {
            // InternalSimplejava.g:1734:2: ( () otherlv_1= 'null' )
            // InternalSimplejava.g:1735:3: () otherlv_1= 'null'
            {
            // InternalSimplejava.g:1735:3: ()
            // InternalSimplejava.g:1736:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNullExpressionAccess().getNullExpressionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getNullExpressionAccess().getNullKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullExpression"


    // $ANTLR start "entryRuleIntegerExpression"
    // InternalSimplejava.g:1750:1: entryRuleIntegerExpression returns [EObject current=null] : iv_ruleIntegerExpression= ruleIntegerExpression EOF ;
    public final EObject entryRuleIntegerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerExpression = null;


        try {
            // InternalSimplejava.g:1750:58: (iv_ruleIntegerExpression= ruleIntegerExpression EOF )
            // InternalSimplejava.g:1751:2: iv_ruleIntegerExpression= ruleIntegerExpression EOF
            {
             newCompositeNode(grammarAccess.getIntegerExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerExpression=ruleIntegerExpression();

            state._fsp--;

             current =iv_ruleIntegerExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIntegerExpression"


    // $ANTLR start "ruleIntegerExpression"
    // InternalSimplejava.g:1757:1: ruleIntegerExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSimplejava.g:1763:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalSimplejava.g:1764:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalSimplejava.g:1764:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalSimplejava.g:1765:3: (lv_value_0_0= RULE_INT )
            {
            // InternalSimplejava.g:1765:3: (lv_value_0_0= RULE_INT )
            // InternalSimplejava.g:1766:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIntegerExpressionAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntegerExpressionRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerExpression"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalSimplejava.g:1785:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalSimplejava.g:1785:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalSimplejava.g:1786:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;

             current =iv_ruleBooleanExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalSimplejava.g:1792:1: ruleBooleanExpression returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSimplejava.g:1798:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalSimplejava.g:1799:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalSimplejava.g:1799:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalSimplejava.g:1800:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalSimplejava.g:1800:3: ()
            // InternalSimplejava.g:1801:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanExpressionAccess().getBooleanExpressionAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:1807:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==41) ) {
                alt24=1;
            }
            else if ( (LA24_0==42) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalSimplejava.g:1808:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalSimplejava.g:1808:4: ( (lv_value_1_0= 'true' ) )
                    // InternalSimplejava.g:1809:5: (lv_value_1_0= 'true' )
                    {
                    // InternalSimplejava.g:1809:5: (lv_value_1_0= 'true' )
                    // InternalSimplejava.g:1810:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,41,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getBooleanExpressionAccess().getValueTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", true, "true");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:1823:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanExpressionAccess().getFalseKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleStringExpression"
    // InternalSimplejava.g:1832:1: entryRuleStringExpression returns [EObject current=null] : iv_ruleStringExpression= ruleStringExpression EOF ;
    public final EObject entryRuleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExpression = null;


        try {
            // InternalSimplejava.g:1832:57: (iv_ruleStringExpression= ruleStringExpression EOF )
            // InternalSimplejava.g:1833:2: iv_ruleStringExpression= ruleStringExpression EOF
            {
             newCompositeNode(grammarAccess.getStringExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringExpression=ruleStringExpression();

            state._fsp--;

             current =iv_ruleStringExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleStringExpression"


    // $ANTLR start "ruleStringExpression"
    // InternalSimplejava.g:1839:1: ruleStringExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSimplejava.g:1845:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalSimplejava.g:1846:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalSimplejava.g:1846:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalSimplejava.g:1847:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalSimplejava.g:1847:3: (lv_value_0_0= RULE_STRING )
            // InternalSimplejava.g:1848:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getStringExpressionAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringExpressionRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalSimplejava.g:1867:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalSimplejava.g:1867:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalSimplejava.g:1868:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalSimplejava.g:1874:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        EObject lv_source_1_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1880:2: ( ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) ) )
            // InternalSimplejava.g:1881:2: ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) )
            {
            // InternalSimplejava.g:1881:2: ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) )
            // InternalSimplejava.g:1882:3: ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) )
            {
            // InternalSimplejava.g:1882:3: ( (lv_type_0_0= '!' ) )
            // InternalSimplejava.g:1883:4: (lv_type_0_0= '!' )
            {
            // InternalSimplejava.g:1883:4: (lv_type_0_0= '!' )
            // InternalSimplejava.g:1884:5: lv_type_0_0= '!'
            {
            lv_type_0_0=(Token)match(input,43,FOLLOW_18); 

            					newLeafNode(lv_type_0_0, grammarAccess.getUnaryExpressionAccess().getTypeExclamationMarkKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnaryExpressionRule());
            					}
            					setWithLastConsumed(current, "type", lv_type_0_0, "!");
            				

            }


            }

            // InternalSimplejava.g:1896:3: ( (lv_source_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1897:4: (lv_source_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1897:4: (lv_source_1_0= ruleGenericExpression )
            // InternalSimplejava.g:1898:5: lv_source_1_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getSourceGenericExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_source_1_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_1_0,
            						"at.ac.tuwien.big.Simplejava.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleVariableExpression"
    // InternalSimplejava.g:1919:1: entryRuleVariableExpression returns [EObject current=null] : iv_ruleVariableExpression= ruleVariableExpression EOF ;
    public final EObject entryRuleVariableExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableExpression = null;


        try {
            // InternalSimplejava.g:1919:59: (iv_ruleVariableExpression= ruleVariableExpression EOF )
            // InternalSimplejava.g:1920:2: iv_ruleVariableExpression= ruleVariableExpression EOF
            {
             newCompositeNode(grammarAccess.getVariableExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableExpression=ruleVariableExpression();

            state._fsp--;

             current =iv_ruleVariableExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVariableExpression"


    // $ANTLR start "ruleVariableExpression"
    // InternalSimplejava.g:1926:1: ruleVariableExpression returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariableExpression() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalSimplejava.g:1932:2: ( ( ( ruleQualifiedName ) ) )
            // InternalSimplejava.g:1933:2: ( ( ruleQualifiedName ) )
            {
            // InternalSimplejava.g:1933:2: ( ( ruleQualifiedName ) )
            // InternalSimplejava.g:1934:3: ( ruleQualifiedName )
            {
            // InternalSimplejava.g:1934:3: ( ruleQualifiedName )
            // InternalSimplejava.g:1935:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVariableExpressionRule());
            				}
            			

            				newCompositeNode(grammarAccess.getVariableExpressionAccess().getVariableParameterCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableExpression"


    // $ANTLR start "entryRuleParanthesisOrBinaryExpression"
    // InternalSimplejava.g:1952:1: entryRuleParanthesisOrBinaryExpression returns [EObject current=null] : iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF ;
    public final EObject entryRuleParanthesisOrBinaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesisOrBinaryExpression = null;


        try {
            // InternalSimplejava.g:1952:70: (iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF )
            // InternalSimplejava.g:1953:2: iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF
            {
             newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParanthesisOrBinaryExpression=ruleParanthesisOrBinaryExpression();

            state._fsp--;

             current =iv_ruleParanthesisOrBinaryExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleParanthesisOrBinaryExpression"


    // $ANTLR start "ruleParanthesisOrBinaryExpression"
    // InternalSimplejava.g:1959:1: ruleParanthesisOrBinaryExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' ) ;
    public final EObject ruleParanthesisOrBinaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_2_1=null;
        Token lv_type_2_2=null;
        Token lv_type_2_3=null;
        Token lv_type_2_4=null;
        Token lv_type_2_5=null;
        Token lv_type_2_6=null;
        Token lv_type_2_7=null;
        Token lv_type_2_8=null;
        Token lv_type_2_9=null;
        Token lv_type_2_10=null;
        Token lv_type_2_11=null;
        Token lv_type_2_12=null;
        Token lv_type_2_13=null;
        Token otherlv_4=null;
        EObject lv_source_1_0 = null;

        EObject lv_argument_3_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1965:2: ( (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' ) )
            // InternalSimplejava.g:1966:2: (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' )
            {
            // InternalSimplejava.g:1966:2: (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' )
            // InternalSimplejava.g:1967:3: otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesisOrBinaryExpressionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalSimplejava.g:1971:3: ( (lv_source_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1972:4: (lv_source_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1972:4: (lv_source_1_0= ruleGenericExpression )
            // InternalSimplejava.g:1973:5: lv_source_1_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionAccess().getSourceGenericExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_source_1_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParanthesisOrBinaryExpressionRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_1_0,
            						"at.ac.tuwien.big.Simplejava.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:1990:3: ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=44 && LA26_0<=56)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSimplejava.g:1991:4: ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) )
                    {
                    // InternalSimplejava.g:1991:4: ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) )
                    // InternalSimplejava.g:1992:5: ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) )
                    {
                    // InternalSimplejava.g:1992:5: ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) )
                    // InternalSimplejava.g:1993:6: (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' )
                    {
                    // InternalSimplejava.g:1993:6: (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' )
                    int alt25=13;
                    switch ( input.LA(1) ) {
                    case 44:
                        {
                        alt25=1;
                        }
                        break;
                    case 45:
                        {
                        alt25=2;
                        }
                        break;
                    case 46:
                        {
                        alt25=3;
                        }
                        break;
                    case 47:
                        {
                        alt25=4;
                        }
                        break;
                    case 48:
                        {
                        alt25=5;
                        }
                        break;
                    case 49:
                        {
                        alt25=6;
                        }
                        break;
                    case 50:
                        {
                        alt25=7;
                        }
                        break;
                    case 51:
                        {
                        alt25=8;
                        }
                        break;
                    case 52:
                        {
                        alt25=9;
                        }
                        break;
                    case 53:
                        {
                        alt25=10;
                        }
                        break;
                    case 54:
                        {
                        alt25=11;
                        }
                        break;
                    case 55:
                        {
                        alt25=12;
                        }
                        break;
                    case 56:
                        {
                        alt25=13;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }

                    switch (alt25) {
                        case 1 :
                            // InternalSimplejava.g:1994:7: lv_type_2_1= '||'
                            {
                            lv_type_2_1=(Token)match(input,44,FOLLOW_18); 

                            							newLeafNode(lv_type_2_1, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeVerticalLineVerticalLineKeyword_2_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:2005:7: lv_type_2_2= '&&'
                            {
                            lv_type_2_2=(Token)match(input,45,FOLLOW_18); 

                            							newLeafNode(lv_type_2_2, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAmpersandAmpersandKeyword_2_0_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSimplejava.g:2016:7: lv_type_2_3= '&'
                            {
                            lv_type_2_3=(Token)match(input,46,FOLLOW_18); 

                            							newLeafNode(lv_type_2_3, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAmpersandKeyword_2_0_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSimplejava.g:2027:7: lv_type_2_4= '+'
                            {
                            lv_type_2_4=(Token)match(input,47,FOLLOW_18); 

                            							newLeafNode(lv_type_2_4, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypePlusSignKeyword_2_0_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSimplejava.g:2038:7: lv_type_2_5= '-'
                            {
                            lv_type_2_5=(Token)match(input,48,FOLLOW_18); 

                            							newLeafNode(lv_type_2_5, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeHyphenMinusKeyword_2_0_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalSimplejava.g:2049:7: lv_type_2_6= '*'
                            {
                            lv_type_2_6=(Token)match(input,49,FOLLOW_18); 

                            							newLeafNode(lv_type_2_6, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAsteriskKeyword_2_0_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_6, null);
                            						

                            }
                            break;
                        case 7 :
                            // InternalSimplejava.g:2060:7: lv_type_2_7= '/'
                            {
                            lv_type_2_7=(Token)match(input,50,FOLLOW_18); 

                            							newLeafNode(lv_type_2_7, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeSolidusKeyword_2_0_0_6());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_7, null);
                            						

                            }
                            break;
                        case 8 :
                            // InternalSimplejava.g:2071:7: lv_type_2_8= '=='
                            {
                            lv_type_2_8=(Token)match(input,51,FOLLOW_18); 

                            							newLeafNode(lv_type_2_8, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeEqualsSignEqualsSignKeyword_2_0_0_7());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_8, null);
                            						

                            }
                            break;
                        case 9 :
                            // InternalSimplejava.g:2082:7: lv_type_2_9= '!='
                            {
                            lv_type_2_9=(Token)match(input,52,FOLLOW_18); 

                            							newLeafNode(lv_type_2_9, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeExclamationMarkEqualsSignKeyword_2_0_0_8());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_9, null);
                            						

                            }
                            break;
                        case 10 :
                            // InternalSimplejava.g:2093:7: lv_type_2_10= '<'
                            {
                            lv_type_2_10=(Token)match(input,53,FOLLOW_18); 

                            							newLeafNode(lv_type_2_10, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeLessThanSignKeyword_2_0_0_9());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_10, null);
                            						

                            }
                            break;
                        case 11 :
                            // InternalSimplejava.g:2104:7: lv_type_2_11= '<='
                            {
                            lv_type_2_11=(Token)match(input,54,FOLLOW_18); 

                            							newLeafNode(lv_type_2_11, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeLessThanSignEqualsSignKeyword_2_0_0_10());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_11, null);
                            						

                            }
                            break;
                        case 12 :
                            // InternalSimplejava.g:2115:7: lv_type_2_12= '>'
                            {
                            lv_type_2_12=(Token)match(input,55,FOLLOW_18); 

                            							newLeafNode(lv_type_2_12, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeGreaterThanSignKeyword_2_0_0_11());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_12, null);
                            						

                            }
                            break;
                        case 13 :
                            // InternalSimplejava.g:2126:7: lv_type_2_13= '>='
                            {
                            lv_type_2_13=(Token)match(input,56,FOLLOW_18); 

                            							newLeafNode(lv_type_2_13, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeGreaterThanSignEqualsSignKeyword_2_0_0_12());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_13, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    // InternalSimplejava.g:2139:4: ( (lv_argument_3_0= ruleGenericExpression ) )
                    // InternalSimplejava.g:2140:5: (lv_argument_3_0= ruleGenericExpression )
                    {
                    // InternalSimplejava.g:2140:5: (lv_argument_3_0= ruleGenericExpression )
                    // InternalSimplejava.g:2141:6: lv_argument_3_0= ruleGenericExpression
                    {

                    						newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionAccess().getArgumentGenericExpressionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_argument_3_0=ruleGenericExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParanthesisOrBinaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"argument",
                    							lv_argument_3_0,
                    							"at.ac.tuwien.big.Simplejava.GenericExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getParanthesisOrBinaryExpressionAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParanthesisOrBinaryExpression"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalSimplejava.g:2167:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalSimplejava.g:2167:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalSimplejava.g:2168:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalSimplejava.g:2174:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:2180:2: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalSimplejava.g:2181:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalSimplejava.g:2181:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalSimplejava.g:2182:3: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {

            			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
            		
            pushFollow(FOLLOW_28);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            			current.merge(this_QualifiedName_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSimplejava.g:2192:3: (kw= '.*' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==57) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSimplejava.g:2193:4: kw= '.*'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalSimplejava.g:2203:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSimplejava.g:2203:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSimplejava.g:2204:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalSimplejava.g:2210:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2216:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSimplejava.g:2217:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSimplejava.g:2217:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSimplejava.g:2218:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalSimplejava.g:2225:3: (kw= '.' this_ID_2= RULE_ID )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==36) ) {
                    int LA28_2 = input.LA(2);

                    if ( (LA28_2==RULE_ID) ) {
                        int LA28_3 = input.LA(3);

                        if ( (LA28_3==EOF||LA28_3==RULE_ID||LA28_3==12||(LA28_3>=25 && LA28_3<=26)||LA28_3==28||LA28_3==36||(LA28_3>=44 && LA28_3<=57)) ) {
                            alt28=1;
                        }


                    }


                }


                switch (alt28) {
            	case 1 :
            	    // InternalSimplejava.g:2226:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,36,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_29); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\1\4\1\uffff\2\4\1\uffff\1\4";
    static final String dfa_3s = "\1\25\1\uffff\1\44\1\4\1\uffff\1\44";
    static final String dfa_4s = "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_5s = "\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\15\uffff\4\1",
            "",
            "\1\1\27\uffff\1\4\7\uffff\1\3",
            "\1\5",
            "",
            "\1\1\27\uffff\1\4\7\uffff\1\3"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "709:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )";
        }
    }
    static final String dfa_7s = "\27\uffff";
    static final String dfa_8s = "\1\4\2\uffff\1\4\1\uffff\1\30\3\uffff\1\4\1\uffff\7\4\1\uffff\1\34\1\4\1\uffff\1\4";
    static final String dfa_9s = "\1\47\2\uffff\1\44\1\uffff\1\30\3\uffff\1\46\1\uffff\1\25\1\44\4\4\1\44\1\uffff\1\40\1\4\1\uffff\1\44";
    static final String dfa_10s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\uffff\1\7\1\10\1\11\1\uffff\1\3\7\uffff\1\5\2\uffff\1\6\1\uffff";
    static final String dfa_11s = "\27\uffff}>";
    static final String[] dfa_12s = {
            "\1\3\13\uffff\1\1\1\uffff\4\2\5\uffff\1\1\1\uffff\1\4\1\uffff\1\5\1\uffff\1\6\1\7\1\10\1\uffff\3\10",
            "",
            "",
            "\1\2\23\uffff\1\10\3\uffff\1\12\7\uffff\1\11",
            "",
            "\1\13",
            "",
            "",
            "",
            "\1\14\40\uffff\2\10",
            "",
            "\1\21\7\uffff\1\22\5\uffff\1\15\1\16\1\17\1\20",
            "\1\2\23\uffff\1\10\3\uffff\1\12\7\uffff\1\11",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23\27\uffff\1\22\7\uffff\1\24",
            "",
            "\1\22\3\uffff\1\25",
            "\1\26",
            "",
            "\1\23\27\uffff\1\22\7\uffff\1\24"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "745:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall )";
        }
    }
    static final String dfa_13s = "\11\uffff";
    static final String dfa_14s = "\1\uffff\1\7\6\uffff\1\7";
    static final String dfa_15s = "\1\4\1\14\4\uffff\1\4\1\uffff\1\14";
    static final String dfa_16s = "\1\53\1\70\4\uffff\1\46\1\uffff\1\70";
    static final String dfa_17s = "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\1\1\uffff";
    static final String dfa_18s = "\11\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\2\5\21\uffff\1\3\12\uffff\1\2\1\uffff\3\2\3\5\1\4",
            "\1\7\13\uffff\1\2\2\7\11\uffff\1\6\7\uffff\15\7",
            "",
            "",
            "",
            "",
            "\1\10\40\uffff\2\2",
            "",
            "\1\7\13\uffff\1\2\2\7\11\uffff\1\6\7\uffff\15\7"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1617:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000003E4010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000FC0010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000BC0010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000043C0010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000003C0010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000EEA83F0010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000FEEA93D0070L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000003C1010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000EEA83D0010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000006000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000FEEAD3D0070L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x01FFF00004000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001000000002L});

}