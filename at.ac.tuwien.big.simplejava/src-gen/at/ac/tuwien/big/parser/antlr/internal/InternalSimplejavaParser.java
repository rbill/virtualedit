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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "';'", "'import'", "'public'", "'class'", "'{'", "'}'", "'='", "'int'", "'double'", "'String'", "'boolean'", "'Object'", "'List'", "'ArrayList'", "'Logger'", "'void'", "'[]'", "'static'", "'('", "','", "')'", "'pointcutblock'", "'if'", "'else'", "'for'", "':'", "'while'", "'return'", "'this'", "'.'", "'equals'", "'hashCode'", "'add'", "'remove'", "'clear'", "'logp'", "'System.out.println'", "'new'", "'null'", "'true'", "'false'", "'!'", "'||'", "'&&'", "'&'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'.*'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
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
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
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
    // InternalSimplejava.g:71:1: ruleSimpleJava returns [EObject current=null] : ( ( (lv_package_0_0= rulePackageDeclaration ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) ) ) ;
    public final EObject ruleSimpleJava() throws RecognitionException {
        EObject current = null;

        EObject lv_package_0_0 = null;

        EObject lv_imports_1_0 = null;

        EObject lv_clazz_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:77:2: ( ( ( (lv_package_0_0= rulePackageDeclaration ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) ) ) )
            // InternalSimplejava.g:78:2: ( ( (lv_package_0_0= rulePackageDeclaration ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) ) )
            {
            // InternalSimplejava.g:78:2: ( ( (lv_package_0_0= rulePackageDeclaration ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) ) )
            // InternalSimplejava.g:79:3: ( (lv_package_0_0= rulePackageDeclaration ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_clazz_2_0= ruleClassDeclaration ) )
            {
            // InternalSimplejava.g:79:3: ( (lv_package_0_0= rulePackageDeclaration ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
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
                    break;

            }

            // InternalSimplejava.g:98:3: ( (lv_imports_1_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
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
            	    break loop2;
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
    // InternalSimplejava.g:238:1: ruleClassDeclaration returns [EObject current=null] : (otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' )* ( (lv_method_6_0= ruleMethod ) )* otherlv_7= '}' ) ;
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
            // InternalSimplejava.g:244:2: ( (otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' )* ( (lv_method_6_0= ruleMethod ) )* otherlv_7= '}' ) )
            // InternalSimplejava.g:245:2: (otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' )* ( (lv_method_6_0= ruleMethod ) )* otherlv_7= '}' )
            {
            // InternalSimplejava.g:245:2: (otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' )* ( (lv_method_6_0= ruleMethod ) )* otherlv_7= '}' )
            // InternalSimplejava.g:246:3: otherlv_0= 'public' otherlv_1= 'class' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' )* ( (lv_method_6_0= ruleMethod ) )* otherlv_7= '}'
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
            		
            // InternalSimplejava.g:276:3: ( ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID||(LA3_0>=19 && LA3_0<=27)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSimplejava.g:277:4: ( (lv_attribute_4_0= ruleParameter ) ) otherlv_5= ';'
            	    {
            	    // InternalSimplejava.g:277:4: ( (lv_attribute_4_0= ruleParameter ) )
            	    // InternalSimplejava.g:278:5: (lv_attribute_4_0= ruleParameter )
            	    {
            	    // InternalSimplejava.g:278:5: (lv_attribute_4_0= ruleParameter )
            	    // InternalSimplejava.g:279:6: lv_attribute_4_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getClassDeclarationAccess().getAttributeParameterParserRuleCall_4_0_0());
            	    					
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

            	    				newLeafNode(otherlv_5, grammarAccess.getClassDeclarationAccess().getSemicolonKeyword_4_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalSimplejava.g:301:3: ( (lv_method_6_0= ruleMethod ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSimplejava.g:302:4: (lv_method_6_0= ruleMethod )
            	    {
            	    // InternalSimplejava.g:302:4: (lv_method_6_0= ruleMethod )
            	    // InternalSimplejava.g:303:5: lv_method_6_0= ruleMethod
            	    {

            	    					newCompositeNode(grammarAccess.getClassDeclarationAccess().getMethodMethodParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
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
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getClassDeclarationAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalSimplejava.g:328:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSimplejava.g:328:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSimplejava.g:329:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalSimplejava.g:335:1: ruleParameter returns [EObject current=null] : (this_SimpleParameter_0= ruleSimpleParameter | this_Attribute_1= ruleAttribute ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleParameter_0 = null;

        EObject this_Attribute_1 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:341:2: ( (this_SimpleParameter_0= ruleSimpleParameter | this_Attribute_1= ruleAttribute ) )
            // InternalSimplejava.g:342:2: (this_SimpleParameter_0= ruleSimpleParameter | this_Attribute_1= ruleAttribute )
            {
            // InternalSimplejava.g:342:2: (this_SimpleParameter_0= ruleSimpleParameter | this_Attribute_1= ruleAttribute )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalSimplejava.g:343:3: this_SimpleParameter_0= ruleSimpleParameter
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getSimpleParameterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleParameter_0=ruleSimpleParameter();

                    state._fsp--;


                    			current = this_SimpleParameter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:352:3: this_Attribute_1= ruleAttribute
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getAttributeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Attribute_1=ruleAttribute();

                    state._fsp--;


                    			current = this_Attribute_1;
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleSimpleParameter"
    // InternalSimplejava.g:364:1: entryRuleSimpleParameter returns [EObject current=null] : iv_ruleSimpleParameter= ruleSimpleParameter EOF ;
    public final EObject entryRuleSimpleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleParameter = null;


        try {
            // InternalSimplejava.g:364:56: (iv_ruleSimpleParameter= ruleSimpleParameter EOF )
            // InternalSimplejava.g:365:2: iv_ruleSimpleParameter= ruleSimpleParameter EOF
            {
             newCompositeNode(grammarAccess.getSimpleParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleParameter=ruleSimpleParameter();

            state._fsp--;

             current =iv_ruleSimpleParameter; 
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
    // $ANTLR end "entryRuleSimpleParameter"


    // $ANTLR start "ruleSimpleParameter"
    // InternalSimplejava.g:371:1: ruleSimpleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:377:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSimplejava.g:378:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSimplejava.g:378:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSimplejava.g:379:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSimplejava.g:379:3: ( (lv_type_0_0= ruleType ) )
            // InternalSimplejava.g:380:4: (lv_type_0_0= ruleType )
            {
            // InternalSimplejava.g:380:4: (lv_type_0_0= ruleType )
            // InternalSimplejava.g:381:5: lv_type_0_0= ruleType
            {

            					newCompositeNode(grammarAccess.getSimpleParameterAccess().getTypeTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"at.ac.tuwien.big.Simplejava.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:398:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimplejava.g:399:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimplejava.g:399:4: (lv_name_1_0= RULE_ID )
            // InternalSimplejava.g:400:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSimpleParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleParameterRule());
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
    // $ANTLR end "ruleSimpleParameter"


    // $ANTLR start "entryRuleAttribute"
    // InternalSimplejava.g:420:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalSimplejava.g:420:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalSimplejava.g:421:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalSimplejava.g:427:1: ruleAttribute returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:433:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) )
            // InternalSimplejava.g:434:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            {
            // InternalSimplejava.g:434:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            // InternalSimplejava.g:435:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) )
            {
            // InternalSimplejava.g:435:3: ( (lv_type_0_0= ruleType ) )
            // InternalSimplejava.g:436:4: (lv_type_0_0= ruleType )
            {
            // InternalSimplejava.g:436:4: (lv_type_0_0= ruleType )
            // InternalSimplejava.g:437:5: lv_type_0_0= ruleType
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"at.ac.tuwien.big.Simplejava.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:454:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimplejava.g:455:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimplejava.g:455:4: (lv_name_1_0= RULE_ID )
            // InternalSimplejava.g:456:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getEqualsSignKeyword_2());
            		
            // InternalSimplejava.g:476:3: ( (lv_expression_3_0= ruleGenericExpression ) )
            // InternalSimplejava.g:477:4: (lv_expression_3_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:477:4: (lv_expression_3_0= ruleGenericExpression )
            // InternalSimplejava.g:478:5: lv_expression_3_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getExpressionGenericExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_3_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleType"
    // InternalSimplejava.g:499:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalSimplejava.g:499:45: (iv_ruleType= ruleType EOF )
            // InternalSimplejava.g:500:2: iv_ruleType= ruleType EOF
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
    // InternalSimplejava.g:506:1: ruleType returns [EObject current=null] : ( ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_isArray_3_0= '[]' ) )? ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        Token lv_typeName_0_5=null;
        Token lv_typeName_0_6=null;
        Token lv_typeName_0_7=null;
        Token lv_typeName_0_8=null;
        Token lv_isVoid_1_0=null;
        Token lv_isArray_3_0=null;


        	enterRule();

        try {
            // InternalSimplejava.g:512:2: ( ( ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_isArray_3_0= '[]' ) )? ) )
            // InternalSimplejava.g:513:2: ( ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_isArray_3_0= '[]' ) )? )
            {
            // InternalSimplejava.g:513:2: ( ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_isArray_3_0= '[]' ) )? )
            // InternalSimplejava.g:514:3: ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_isArray_3_0= '[]' ) )?
            {
            // InternalSimplejava.g:514:3: ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                {
                alt7=1;
                }
                break;
            case 27:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalSimplejava.g:515:4: ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) )
                    {
                    // InternalSimplejava.g:515:4: ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) )
                    // InternalSimplejava.g:516:5: ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) )
                    {
                    // InternalSimplejava.g:516:5: ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) )
                    // InternalSimplejava.g:517:6: (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' )
                    {
                    // InternalSimplejava.g:517:6: (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' )
                    int alt6=8;
                    switch ( input.LA(1) ) {
                    case 19:
                        {
                        alt6=1;
                        }
                        break;
                    case 20:
                        {
                        alt6=2;
                        }
                        break;
                    case 21:
                        {
                        alt6=3;
                        }
                        break;
                    case 22:
                        {
                        alt6=4;
                        }
                        break;
                    case 23:
                        {
                        alt6=5;
                        }
                        break;
                    case 24:
                        {
                        alt6=6;
                        }
                        break;
                    case 25:
                        {
                        alt6=7;
                        }
                        break;
                    case 26:
                        {
                        alt6=8;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }

                    switch (alt6) {
                        case 1 :
                            // InternalSimplejava.g:518:7: lv_typeName_0_1= 'int'
                            {
                            lv_typeName_0_1=(Token)match(input,19,FOLLOW_12); 

                            							newLeafNode(lv_typeName_0_1, grammarAccess.getTypeAccess().getTypeNameIntKeyword_0_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTypeRule());
                            							}
                            							setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:529:7: lv_typeName_0_2= 'double'
                            {
                            lv_typeName_0_2=(Token)match(input,20,FOLLOW_12); 

                            							newLeafNode(lv_typeName_0_2, grammarAccess.getTypeAccess().getTypeNameDoubleKeyword_0_0_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTypeRule());
                            							}
                            							setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSimplejava.g:540:7: lv_typeName_0_3= 'String'
                            {
                            lv_typeName_0_3=(Token)match(input,21,FOLLOW_12); 

                            							newLeafNode(lv_typeName_0_3, grammarAccess.getTypeAccess().getTypeNameStringKeyword_0_0_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTypeRule());
                            							}
                            							setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSimplejava.g:551:7: lv_typeName_0_4= 'boolean'
                            {
                            lv_typeName_0_4=(Token)match(input,22,FOLLOW_12); 

                            							newLeafNode(lv_typeName_0_4, grammarAccess.getTypeAccess().getTypeNameBooleanKeyword_0_0_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTypeRule());
                            							}
                            							setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSimplejava.g:562:7: lv_typeName_0_5= 'Object'
                            {
                            lv_typeName_0_5=(Token)match(input,23,FOLLOW_12); 

                            							newLeafNode(lv_typeName_0_5, grammarAccess.getTypeAccess().getTypeNameObjectKeyword_0_0_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTypeRule());
                            							}
                            							setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalSimplejava.g:573:7: lv_typeName_0_6= 'List'
                            {
                            lv_typeName_0_6=(Token)match(input,24,FOLLOW_12); 

                            							newLeafNode(lv_typeName_0_6, grammarAccess.getTypeAccess().getTypeNameListKeyword_0_0_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTypeRule());
                            							}
                            							setWithLastConsumed(current, "typeName", lv_typeName_0_6, null);
                            						

                            }
                            break;
                        case 7 :
                            // InternalSimplejava.g:584:7: lv_typeName_0_7= 'ArrayList'
                            {
                            lv_typeName_0_7=(Token)match(input,25,FOLLOW_12); 

                            							newLeafNode(lv_typeName_0_7, grammarAccess.getTypeAccess().getTypeNameArrayListKeyword_0_0_0_6());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTypeRule());
                            							}
                            							setWithLastConsumed(current, "typeName", lv_typeName_0_7, null);
                            						

                            }
                            break;
                        case 8 :
                            // InternalSimplejava.g:595:7: lv_typeName_0_8= 'Logger'
                            {
                            lv_typeName_0_8=(Token)match(input,26,FOLLOW_12); 

                            							newLeafNode(lv_typeName_0_8, grammarAccess.getTypeAccess().getTypeNameLoggerKeyword_0_0_0_7());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTypeRule());
                            							}
                            							setWithLastConsumed(current, "typeName", lv_typeName_0_8, null);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:609:4: ( (lv_isVoid_1_0= 'void' ) )
                    {
                    // InternalSimplejava.g:609:4: ( (lv_isVoid_1_0= 'void' ) )
                    // InternalSimplejava.g:610:5: (lv_isVoid_1_0= 'void' )
                    {
                    // InternalSimplejava.g:610:5: (lv_isVoid_1_0= 'void' )
                    // InternalSimplejava.g:611:6: lv_isVoid_1_0= 'void'
                    {
                    lv_isVoid_1_0=(Token)match(input,27,FOLLOW_12); 

                    						newLeafNode(lv_isVoid_1_0, grammarAccess.getTypeAccess().getIsVoidVoidKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeRule());
                    						}
                    						setWithLastConsumed(current, "isVoid", true, "void");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSimplejava.g:624:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalSimplejava.g:624:4: ( ( ruleQualifiedName ) )
                    // InternalSimplejava.g:625:5: ( ruleQualifiedName )
                    {
                    // InternalSimplejava.g:625:5: ( ruleQualifiedName )
                    // InternalSimplejava.g:626:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getTypeAccess().getTypeRefClassDeclarationCrossReference_0_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSimplejava.g:641:3: ( (lv_isArray_3_0= '[]' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==28) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSimplejava.g:642:4: (lv_isArray_3_0= '[]' )
                    {
                    // InternalSimplejava.g:642:4: (lv_isArray_3_0= '[]' )
                    // InternalSimplejava.g:643:5: lv_isArray_3_0= '[]'
                    {
                    lv_isArray_3_0=(Token)match(input,28,FOLLOW_2); 

                    					newLeafNode(lv_isArray_3_0, grammarAccess.getTypeAccess().getIsArrayLeftSquareBracketRightSquareBracketKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTypeRule());
                    					}
                    					setWithLastConsumed(current, "isArray", true, "[]");
                    				

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleMethod"
    // InternalSimplejava.g:659:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalSimplejava.g:659:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalSimplejava.g:660:2: iv_ruleMethod= ruleMethod EOF
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
    // InternalSimplejava.g:666:1: ruleMethod returns [EObject current=null] : (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) ) ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_returnType_2_0 = null;

        EObject lv_parameter_5_0 = null;

        EObject lv_parameter_7_0 = null;

        EObject lv_content_9_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:672:2: ( (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) ) ) )
            // InternalSimplejava.g:673:2: (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) ) )
            {
            // InternalSimplejava.g:673:2: (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) ) )
            // InternalSimplejava.g:674:3: otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getMethodAccess().getPublicKeyword_0());
            		
            // InternalSimplejava.g:678:3: ( (lv_static_1_0= 'static' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==29) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSimplejava.g:679:4: (lv_static_1_0= 'static' )
                    {
                    // InternalSimplejava.g:679:4: (lv_static_1_0= 'static' )
                    // InternalSimplejava.g:680:5: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,29,FOLLOW_14); 

                    					newLeafNode(lv_static_1_0, grammarAccess.getMethodAccess().getStaticStaticKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodRule());
                    					}
                    					setWithLastConsumed(current, "static", true, "static");
                    				

                    }


                    }
                    break;

            }

            // InternalSimplejava.g:692:3: ( (lv_returnType_2_0= ruleType ) )
            // InternalSimplejava.g:693:4: (lv_returnType_2_0= ruleType )
            {
            // InternalSimplejava.g:693:4: (lv_returnType_2_0= ruleType )
            // InternalSimplejava.g:694:5: lv_returnType_2_0= ruleType
            {

            					newCompositeNode(grammarAccess.getMethodAccess().getReturnTypeTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
            lv_returnType_2_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMethodRule());
            					}
            					set(
            						current,
            						"returnType",
            						lv_returnType_2_0,
            						"at.ac.tuwien.big.Simplejava.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimplejava.g:711:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSimplejava.g:712:4: (lv_name_3_0= RULE_ID )
                    {
                    // InternalSimplejava.g:712:4: (lv_name_3_0= RULE_ID )
                    // InternalSimplejava.g:713:5: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_16); 

                    					newLeafNode(lv_name_3_0, grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_3_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSimplejava.g:733:3: ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||(LA12_0>=19 && LA12_0<=27)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSimplejava.g:734:4: ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )*
                    {
                    // InternalSimplejava.g:734:4: ( (lv_parameter_5_0= ruleSimpleParameter ) )
                    // InternalSimplejava.g:735:5: (lv_parameter_5_0= ruleSimpleParameter )
                    {
                    // InternalSimplejava.g:735:5: (lv_parameter_5_0= ruleSimpleParameter )
                    // InternalSimplejava.g:736:6: lv_parameter_5_0= ruleSimpleParameter
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getParameterSimpleParameterParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_parameter_5_0=ruleSimpleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_5_0,
                    							"at.ac.tuwien.big.Simplejava.SimpleParameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimplejava.g:753:4: (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==31) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalSimplejava.g:754:5: otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FOLLOW_14); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getMethodAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalSimplejava.g:758:5: ( (lv_parameter_7_0= ruleSimpleParameter ) )
                    	    // InternalSimplejava.g:759:6: (lv_parameter_7_0= ruleSimpleParameter )
                    	    {
                    	    // InternalSimplejava.g:759:6: (lv_parameter_7_0= ruleSimpleParameter )
                    	    // InternalSimplejava.g:760:7: lv_parameter_7_0= ruleSimpleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodAccess().getParameterSimpleParameterParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
                    	    lv_parameter_7_0=ruleSimpleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMethodRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_7_0,
                    	    								"at.ac.tuwien.big.Simplejava.SimpleParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,32,FOLLOW_19); 

            			newLeafNode(otherlv_8, grammarAccess.getMethodAccess().getRightParenthesisKeyword_6());
            		
            // InternalSimplejava.g:783:3: ( (lv_content_9_0= ruleMethodBlock ) )
            // InternalSimplejava.g:784:4: (lv_content_9_0= ruleMethodBlock )
            {
            // InternalSimplejava.g:784:4: (lv_content_9_0= ruleMethodBlock )
            // InternalSimplejava.g:785:5: lv_content_9_0= ruleMethodBlock
            {

            					newCompositeNode(grammarAccess.getMethodAccess().getContentMethodBlockParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_content_9_0=ruleMethodBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMethodRule());
            					}
            					set(
            						current,
            						"content",
            						lv_content_9_0,
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
    // InternalSimplejava.g:806:1: entryRuleMethodBlock returns [EObject current=null] : iv_ruleMethodBlock= ruleMethodBlock EOF ;
    public final EObject entryRuleMethodBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodBlock = null;


        try {
            // InternalSimplejava.g:806:52: (iv_ruleMethodBlock= ruleMethodBlock EOF )
            // InternalSimplejava.g:807:2: iv_ruleMethodBlock= ruleMethodBlock EOF
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
    // InternalSimplejava.g:813:1: ruleMethodBlock returns [EObject current=null] : ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleMethodBlock() throws RecognitionException {
        EObject current = null;

        Token lv_generated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statements_3_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:819:2: ( ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) ) )
            // InternalSimplejava.g:820:2: ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) )
            {
            // InternalSimplejava.g:820:2: ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) )
            // InternalSimplejava.g:821:3: () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' )
            {
            // InternalSimplejava.g:821:3: ()
            // InternalSimplejava.g:822:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodBlockAccess().getMethodBlockAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:828:3: ( (lv_generated_1_0= 'pointcutblock' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==33) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalSimplejava.g:829:4: (lv_generated_1_0= 'pointcutblock' )
                    {
                    // InternalSimplejava.g:829:4: (lv_generated_1_0= 'pointcutblock' )
                    // InternalSimplejava.g:830:5: lv_generated_1_0= 'pointcutblock'
                    {
                    lv_generated_1_0=(Token)match(input,33,FOLLOW_7); 

                    					newLeafNode(lv_generated_1_0, grammarAccess.getMethodBlockAccess().getGeneratedPointcutblockKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodBlockRule());
                    					}
                    					setWithLastConsumed(current, "generated", true, "pointcutblock");
                    				

                    }


                    }
                    break;

            }

            // InternalSimplejava.g:842:3: (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' )
            // InternalSimplejava.g:843:4: otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}'
            {
            otherlv_2=(Token)match(input,16,FOLLOW_20); 

            				newLeafNode(otherlv_2, grammarAccess.getMethodBlockAccess().getLeftCurlyBracketKeyword_2_0());
            			
            // InternalSimplejava.g:847:4: ( (lv_statements_3_0= ruleStatement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID||LA14_0==16||(LA14_0>=19 && LA14_0<=27)||(LA14_0>=33 && LA14_0<=34)||LA14_0==36||(LA14_0>=38 && LA14_0<=40)||(LA14_0>=42 && LA14_0<=48)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSimplejava.g:848:5: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalSimplejava.g:848:5: (lv_statements_3_0= ruleStatement )
            	    // InternalSimplejava.g:849:6: lv_statements_3_0= ruleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getMethodBlockAccess().getStatementsStatementParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
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
            	    break loop14;
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
    // InternalSimplejava.g:875:1: entryRuleSimpleStatement returns [EObject current=null] : iv_ruleSimpleStatement= ruleSimpleStatement EOF ;
    public final EObject entryRuleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleStatement = null;


        try {
            // InternalSimplejava.g:875:56: (iv_ruleSimpleStatement= ruleSimpleStatement EOF )
            // InternalSimplejava.g:876:2: iv_ruleSimpleStatement= ruleSimpleStatement EOF
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
    // InternalSimplejava.g:882:1: ruleSimpleStatement returns [EObject current=null] : (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment ) ;
    public final EObject ruleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleVariableDeclaration_0 = null;

        EObject this_Assignment_1 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:888:2: ( (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment ) )
            // InternalSimplejava.g:889:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )
            {
            // InternalSimplejava.g:889:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalSimplejava.g:890:3: this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration
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
                    // InternalSimplejava.g:899:3: this_Assignment_1= ruleAssignment
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
    // InternalSimplejava.g:911:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalSimplejava.g:911:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalSimplejava.g:912:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalSimplejava.g:918:1: ruleStatement returns [EObject current=null] : (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_9=null;
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
            // InternalSimplejava.g:924:2: ( (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) ) )
            // InternalSimplejava.g:925:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) )
            {
            // InternalSimplejava.g:925:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) )
            int alt16=9;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalSimplejava.g:926:3: this_MethodBlock_0= ruleMethodBlock
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
                    // InternalSimplejava.g:935:3: this_VariableDeclaration_1= ruleVariableDeclaration
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
                    // InternalSimplejava.g:944:3: this_Assignment_2= ruleAssignment
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
                    // InternalSimplejava.g:953:3: this_IfStatement_3= ruleIfStatement
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
                    // InternalSimplejava.g:962:3: this_ForStatement_4= ruleForStatement
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
                    // InternalSimplejava.g:971:3: this_ForInStatement_5= ruleForInStatement
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
                    // InternalSimplejava.g:980:3: this_WhileStatement_6= ruleWhileStatement
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
                    // InternalSimplejava.g:989:3: this_ReturnStatement_7= ruleReturnStatement
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
                    // InternalSimplejava.g:998:3: (this_MethodCall_8= ruleMethodCall otherlv_9= ';' )
                    {
                    // InternalSimplejava.g:998:3: (this_MethodCall_8= ruleMethodCall otherlv_9= ';' )
                    // InternalSimplejava.g:999:4: this_MethodCall_8= ruleMethodCall otherlv_9= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getMethodCallParserRuleCall_8_0());
                    			
                    pushFollow(FOLLOW_5);
                    this_MethodCall_8=ruleMethodCall();

                    state._fsp--;


                    				current = this_MethodCall_8;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_9=(Token)match(input,12,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getStatementAccess().getSemicolonKeyword_8_1());
                    			

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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleSimpleVariableDeclaration"
    // InternalSimplejava.g:1016:1: entryRuleSimpleVariableDeclaration returns [EObject current=null] : iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF ;
    public final EObject entryRuleSimpleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleVariableDeclaration = null;


        try {
            // InternalSimplejava.g:1016:66: (iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF )
            // InternalSimplejava.g:1017:2: iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF
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
    // InternalSimplejava.g:1023:1: ruleSimpleVariableDeclaration returns [EObject current=null] : ( () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleSimpleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_parameter_1_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1029:2: ( ( () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) )
            // InternalSimplejava.g:1030:2: ( () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            {
            // InternalSimplejava.g:1030:2: ( () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            // InternalSimplejava.g:1031:3: () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) )
            {
            // InternalSimplejava.g:1031:3: ()
            // InternalSimplejava.g:1032:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleVariableDeclarationAccess().getVariableDeclarationAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:1038:3: ( (lv_parameter_1_0= ruleSimpleParameter ) )
            // InternalSimplejava.g:1039:4: (lv_parameter_1_0= ruleSimpleParameter )
            {
            // InternalSimplejava.g:1039:4: (lv_parameter_1_0= ruleSimpleParameter )
            // InternalSimplejava.g:1040:5: lv_parameter_1_0= ruleSimpleParameter
            {

            					newCompositeNode(grammarAccess.getSimpleVariableDeclarationAccess().getParameterSimpleParameterParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_parameter_1_0=ruleSimpleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleVariableDeclarationRule());
            					}
            					set(
            						current,
            						"parameter",
            						lv_parameter_1_0,
            						"at.ac.tuwien.big.Simplejava.SimpleParameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleVariableDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalSimplejava.g:1061:3: ( (lv_expression_3_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1062:4: (lv_expression_3_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1062:4: (lv_expression_3_0= ruleGenericExpression )
            // InternalSimplejava.g:1063:5: lv_expression_3_0= ruleGenericExpression
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
    // InternalSimplejava.g:1084:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalSimplejava.g:1084:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalSimplejava.g:1085:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalSimplejava.g:1091:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parameter_0_0 = null;

        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1097:2: ( ( ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) )
            // InternalSimplejava.g:1098:2: ( ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            {
            // InternalSimplejava.g:1098:2: ( ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            // InternalSimplejava.g:1099:3: ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';'
            {
            // InternalSimplejava.g:1099:3: ( (lv_parameter_0_0= ruleSimpleParameter ) )
            // InternalSimplejava.g:1100:4: (lv_parameter_0_0= ruleSimpleParameter )
            {
            // InternalSimplejava.g:1100:4: (lv_parameter_0_0= ruleSimpleParameter )
            // InternalSimplejava.g:1101:5: lv_parameter_0_0= ruleSimpleParameter
            {

            					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getParameterSimpleParameterParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_parameter_0_0=ruleSimpleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            					}
            					set(
            						current,
            						"parameter",
            						lv_parameter_0_0,
            						"at.ac.tuwien.big.Simplejava.SimpleParameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_1());
            		
            // InternalSimplejava.g:1122:3: ( (lv_expression_2_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1123:4: (lv_expression_2_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1123:4: (lv_expression_2_0= ruleGenericExpression )
            // InternalSimplejava.g:1124:5: lv_expression_2_0= ruleGenericExpression
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
    // InternalSimplejava.g:1149:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalSimplejava.g:1149:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalSimplejava.g:1150:2: iv_ruleAssignment= ruleAssignment EOF
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
    // InternalSimplejava.g:1156:1: ruleAssignment returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1162:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) )
            // InternalSimplejava.g:1163:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            {
            // InternalSimplejava.g:1163:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            // InternalSimplejava.g:1164:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';'
            {
            // InternalSimplejava.g:1164:3: ( ( ruleQualifiedName ) )
            // InternalSimplejava.g:1165:4: ( ruleQualifiedName )
            {
            // InternalSimplejava.g:1165:4: ( ruleQualifiedName )
            // InternalSimplejava.g:1166:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssignmentAccess().getParameterParameterCrossReference_0_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
            		
            // InternalSimplejava.g:1184:3: ( (lv_expression_2_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1185:4: (lv_expression_2_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1185:4: (lv_expression_2_0= ruleGenericExpression )
            // InternalSimplejava.g:1186:5: lv_expression_2_0= ruleGenericExpression
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
    // InternalSimplejava.g:1211:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalSimplejava.g:1211:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalSimplejava.g:1212:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalSimplejava.g:1218:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_condition_1_0 = null;

        EObject lv_then_2_0 = null;

        EObject lv_else_4_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1224:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? ) )
            // InternalSimplejava.g:1225:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? )
            {
            // InternalSimplejava.g:1225:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? )
            // InternalSimplejava.g:1226:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
            		
            // InternalSimplejava.g:1230:3: ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) )
            // InternalSimplejava.g:1231:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            {
            // InternalSimplejava.g:1231:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            // InternalSimplejava.g:1232:5: lv_condition_1_0= ruleParanthesisOrBinaryExpression
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getConditionParanthesisOrBinaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_19);
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

            // InternalSimplejava.g:1249:3: ( (lv_then_2_0= ruleMethodBlock ) )
            // InternalSimplejava.g:1250:4: (lv_then_2_0= ruleMethodBlock )
            {
            // InternalSimplejava.g:1250:4: (lv_then_2_0= ruleMethodBlock )
            // InternalSimplejava.g:1251:5: lv_then_2_0= ruleMethodBlock
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getThenMethodBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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

            // InternalSimplejava.g:1268:3: (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSimplejava.g:1269:4: otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) )
                    {
                    otherlv_3=(Token)match(input,35,FOLLOW_19); 

                    				newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getElseKeyword_3_0());
                    			
                    // InternalSimplejava.g:1273:4: ( (lv_else_4_0= ruleMethodBlock ) )
                    // InternalSimplejava.g:1274:5: (lv_else_4_0= ruleMethodBlock )
                    {
                    // InternalSimplejava.g:1274:5: (lv_else_4_0= ruleMethodBlock )
                    // InternalSimplejava.g:1275:6: lv_else_4_0= ruleMethodBlock
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
    // InternalSimplejava.g:1297:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalSimplejava.g:1297:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalSimplejava.g:1298:2: iv_ruleForStatement= ruleForStatement EOF
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
    // InternalSimplejava.g:1304:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) ) ;
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
            // InternalSimplejava.g:1310:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1311:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1311:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) )
            // InternalSimplejava.g:1312:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1320:3: ( (lv_init_2_0= ruleSimpleStatement ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||(LA18_0>=19 && LA18_0<=27)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalSimplejava.g:1321:4: (lv_init_2_0= ruleSimpleStatement )
                    {
                    // InternalSimplejava.g:1321:4: (lv_init_2_0= ruleSimpleStatement )
                    // InternalSimplejava.g:1322:5: lv_init_2_0= ruleSimpleStatement
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

            otherlv_3=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getForStatementAccess().getSemicolonKeyword_3());
            		
            // InternalSimplejava.g:1343:3: ( (lv_condition_4_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1344:4: (lv_condition_4_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1344:4: (lv_condition_4_0= ruleGenericExpression )
            // InternalSimplejava.g:1345:5: lv_condition_4_0= ruleGenericExpression
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
            		
            // InternalSimplejava.g:1366:3: ( (lv_continuation_6_0= ruleSimpleStatement ) )
            // InternalSimplejava.g:1367:4: (lv_continuation_6_0= ruleSimpleStatement )
            {
            // InternalSimplejava.g:1367:4: (lv_continuation_6_0= ruleSimpleStatement )
            // InternalSimplejava.g:1368:5: lv_continuation_6_0= ruleSimpleStatement
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getContinuationSimpleStatementParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_23);
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

            otherlv_7=(Token)match(input,32,FOLLOW_24); 

            			newLeafNode(otherlv_7, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());
            		
            // InternalSimplejava.g:1389:3: ( (lv_body_8_0= ruleStatement ) )
            // InternalSimplejava.g:1390:4: (lv_body_8_0= ruleStatement )
            {
            // InternalSimplejava.g:1390:4: (lv_body_8_0= ruleStatement )
            // InternalSimplejava.g:1391:5: lv_body_8_0= ruleStatement
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
    // InternalSimplejava.g:1412:1: entryRuleForInStatement returns [EObject current=null] : iv_ruleForInStatement= ruleForInStatement EOF ;
    public final EObject entryRuleForInStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForInStatement = null;


        try {
            // InternalSimplejava.g:1412:55: (iv_ruleForInStatement= ruleForInStatement EOF )
            // InternalSimplejava.g:1413:2: iv_ruleForInStatement= ruleForInStatement EOF
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
    // InternalSimplejava.g:1419:1: ruleForInStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) ) ;
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
            // InternalSimplejava.g:1425:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1426:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1426:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) )
            // InternalSimplejava.g:1427:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getForInStatementAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getForInStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1435:3: ( (lv_subparameter_2_0= ruleSimpleParameter ) )
            // InternalSimplejava.g:1436:4: (lv_subparameter_2_0= ruleSimpleParameter )
            {
            // InternalSimplejava.g:1436:4: (lv_subparameter_2_0= ruleSimpleParameter )
            // InternalSimplejava.g:1437:5: lv_subparameter_2_0= ruleSimpleParameter
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getSubparameterSimpleParameterParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_25);
            lv_subparameter_2_0=ruleSimpleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForInStatementRule());
            					}
            					set(
            						current,
            						"subparameter",
            						lv_subparameter_2_0,
            						"at.ac.tuwien.big.Simplejava.SimpleParameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,37,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getForInStatementAccess().getColonKeyword_3());
            		
            // InternalSimplejava.g:1458:3: ( (lv_expression_4_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1459:4: (lv_expression_4_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1459:4: (lv_expression_4_0= ruleGenericExpression )
            // InternalSimplejava.g:1460:5: lv_expression_4_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getExpressionGenericExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_23);
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

            otherlv_5=(Token)match(input,32,FOLLOW_24); 

            			newLeafNode(otherlv_5, grammarAccess.getForInStatementAccess().getRightParenthesisKeyword_5());
            		
            // InternalSimplejava.g:1481:3: ( (lv_body_6_0= ruleStatement ) )
            // InternalSimplejava.g:1482:4: (lv_body_6_0= ruleStatement )
            {
            // InternalSimplejava.g:1482:4: (lv_body_6_0= ruleStatement )
            // InternalSimplejava.g:1483:5: lv_body_6_0= ruleStatement
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
    // InternalSimplejava.g:1504:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalSimplejava.g:1504:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalSimplejava.g:1505:2: iv_ruleWhileStatement= ruleWhileStatement EOF
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
    // InternalSimplejava.g:1511:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;

        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1517:2: ( (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1518:2: (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1518:2: (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) )
            // InternalSimplejava.g:1519:3: otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
            		
            // InternalSimplejava.g:1523:3: ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) )
            // InternalSimplejava.g:1524:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            {
            // InternalSimplejava.g:1524:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            // InternalSimplejava.g:1525:5: lv_condition_1_0= ruleParanthesisOrBinaryExpression
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionParanthesisOrBinaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
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

            // InternalSimplejava.g:1542:3: ( (lv_body_2_0= ruleStatement ) )
            // InternalSimplejava.g:1543:4: (lv_body_2_0= ruleStatement )
            {
            // InternalSimplejava.g:1543:4: (lv_body_2_0= ruleStatement )
            // InternalSimplejava.g:1544:5: lv_body_2_0= ruleStatement
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
    // InternalSimplejava.g:1565:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // InternalSimplejava.g:1565:56: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // InternalSimplejava.g:1566:2: iv_ruleReturnStatement= ruleReturnStatement EOF
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
    // InternalSimplejava.g:1572:1: ruleReturnStatement returns [EObject current=null] : (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1578:2: ( (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' ) )
            // InternalSimplejava.g:1579:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' )
            {
            // InternalSimplejava.g:1579:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' )
            // InternalSimplejava.g:1580:3: otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getReturnStatementAccess().getReturnKeyword_0());
            		
            // InternalSimplejava.g:1584:3: ( (lv_expression_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1585:4: (lv_expression_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1585:4: (lv_expression_1_0= ruleGenericExpression )
            // InternalSimplejava.g:1586:5: lv_expression_1_0= ruleGenericExpression
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
    // InternalSimplejava.g:1611:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSimplejava.g:1611:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSimplejava.g:1612:2: iv_ruleMethodCall= ruleMethodCall EOF
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
    // InternalSimplejava.g:1618:1: ruleMethodCall returns [EObject current=null] : ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' ) ;
    public final EObject ruleMethodCall() throws RecognitionException {
        EObject current = null;

        Token lv_thisObject_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_methodName_4_1=null;
        Token lv_methodName_4_2=null;
        Token lv_methodName_4_3=null;
        Token lv_methodName_4_4=null;
        Token lv_methodName_4_5=null;
        Token lv_methodName_4_6=null;
        Token lv_methodName_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_parameter_7_0 = null;

        EObject lv_parameter_9_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1624:2: ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' ) )
            // InternalSimplejava.g:1625:2: ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' )
            {
            // InternalSimplejava.g:1625:2: ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' )
            // InternalSimplejava.g:1626:3: ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')'
            {
            // InternalSimplejava.g:1626:3: ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) )
            // InternalSimplejava.g:1627:4: ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) )
            {
            // InternalSimplejava.g:1627:4: ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==41) ) {
                    alt20=1;
                }
            }
            else if ( (LA20_0==40) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalSimplejava.g:1628:5: ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.'
                    {
                    // InternalSimplejava.g:1628:5: ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_ID) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==40) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalSimplejava.g:1629:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalSimplejava.g:1629:6: ( ( ruleQualifiedName ) )
                            // InternalSimplejava.g:1630:7: ( ruleQualifiedName )
                            {
                            // InternalSimplejava.g:1630:7: ( ruleQualifiedName )
                            // InternalSimplejava.g:1631:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getMethodCallAccess().getObjectParameterCrossReference_0_0_0_0_0());
                            							
                            pushFollow(FOLLOW_26);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:1646:6: ( (lv_thisObject_1_0= 'this' ) )
                            {
                            // InternalSimplejava.g:1646:6: ( (lv_thisObject_1_0= 'this' ) )
                            // InternalSimplejava.g:1647:7: (lv_thisObject_1_0= 'this' )
                            {
                            // InternalSimplejava.g:1647:7: (lv_thisObject_1_0= 'this' )
                            // InternalSimplejava.g:1648:8: lv_thisObject_1_0= 'this'
                            {
                            lv_thisObject_1_0=(Token)match(input,40,FOLLOW_26); 

                            								newLeafNode(lv_thisObject_1_0, grammarAccess.getMethodCallAccess().getThisObjectThisKeyword_0_0_0_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "thisObject", true, "this");
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,41,FOLLOW_27); 

                    					newLeafNode(otherlv_2, grammarAccess.getMethodCallAccess().getFullStopKeyword_0_0_1());
                    				

                    }
                    break;

            }

            // InternalSimplejava.g:1666:4: ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt22=1;
                }
                break;
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
                {
                alt22=2;
                }
                break;
            case 48:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalSimplejava.g:1667:5: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalSimplejava.g:1667:5: ( (otherlv_3= RULE_ID ) )
                    // InternalSimplejava.g:1668:6: (otherlv_3= RULE_ID )
                    {
                    // InternalSimplejava.g:1668:6: (otherlv_3= RULE_ID )
                    // InternalSimplejava.g:1669:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMethodCallRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_16); 

                    							newLeafNode(otherlv_3, grammarAccess.getMethodCallAccess().getMethodMethodCrossReference_0_1_0_0());
                    						

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:1681:5: ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) )
                    {
                    // InternalSimplejava.g:1681:5: ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) )
                    // InternalSimplejava.g:1682:6: ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) )
                    {
                    // InternalSimplejava.g:1682:6: ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) )
                    // InternalSimplejava.g:1683:7: (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' )
                    {
                    // InternalSimplejava.g:1683:7: (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' )
                    int alt21=6;
                    switch ( input.LA(1) ) {
                    case 42:
                        {
                        alt21=1;
                        }
                        break;
                    case 43:
                        {
                        alt21=2;
                        }
                        break;
                    case 44:
                        {
                        alt21=3;
                        }
                        break;
                    case 45:
                        {
                        alt21=4;
                        }
                        break;
                    case 46:
                        {
                        alt21=5;
                        }
                        break;
                    case 47:
                        {
                        alt21=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }

                    switch (alt21) {
                        case 1 :
                            // InternalSimplejava.g:1684:8: lv_methodName_4_1= 'equals'
                            {
                            lv_methodName_4_1=(Token)match(input,42,FOLLOW_16); 

                            								newLeafNode(lv_methodName_4_1, grammarAccess.getMethodCallAccess().getMethodNameEqualsKeyword_0_1_1_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_1, null);
                            							

                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:1695:8: lv_methodName_4_2= 'hashCode'
                            {
                            lv_methodName_4_2=(Token)match(input,43,FOLLOW_16); 

                            								newLeafNode(lv_methodName_4_2, grammarAccess.getMethodCallAccess().getMethodNameHashCodeKeyword_0_1_1_0_1());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_2, null);
                            							

                            }
                            break;
                        case 3 :
                            // InternalSimplejava.g:1706:8: lv_methodName_4_3= 'add'
                            {
                            lv_methodName_4_3=(Token)match(input,44,FOLLOW_16); 

                            								newLeafNode(lv_methodName_4_3, grammarAccess.getMethodCallAccess().getMethodNameAddKeyword_0_1_1_0_2());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_3, null);
                            							

                            }
                            break;
                        case 4 :
                            // InternalSimplejava.g:1717:8: lv_methodName_4_4= 'remove'
                            {
                            lv_methodName_4_4=(Token)match(input,45,FOLLOW_16); 

                            								newLeafNode(lv_methodName_4_4, grammarAccess.getMethodCallAccess().getMethodNameRemoveKeyword_0_1_1_0_3());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_4, null);
                            							

                            }
                            break;
                        case 5 :
                            // InternalSimplejava.g:1728:8: lv_methodName_4_5= 'clear'
                            {
                            lv_methodName_4_5=(Token)match(input,46,FOLLOW_16); 

                            								newLeafNode(lv_methodName_4_5, grammarAccess.getMethodCallAccess().getMethodNameClearKeyword_0_1_1_0_4());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_5, null);
                            							

                            }
                            break;
                        case 6 :
                            // InternalSimplejava.g:1739:8: lv_methodName_4_6= 'logp'
                            {
                            lv_methodName_4_6=(Token)match(input,47,FOLLOW_16); 

                            								newLeafNode(lv_methodName_4_6, grammarAccess.getMethodCallAccess().getMethodNameLogpKeyword_0_1_1_0_5());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_6, null);
                            							

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSimplejava.g:1753:5: ( (lv_methodName_5_0= 'System.out.println' ) )
                    {
                    // InternalSimplejava.g:1753:5: ( (lv_methodName_5_0= 'System.out.println' ) )
                    // InternalSimplejava.g:1754:6: (lv_methodName_5_0= 'System.out.println' )
                    {
                    // InternalSimplejava.g:1754:6: (lv_methodName_5_0= 'System.out.println' )
                    // InternalSimplejava.g:1755:7: lv_methodName_5_0= 'System.out.println'
                    {
                    lv_methodName_5_0=(Token)match(input,48,FOLLOW_16); 

                    							newLeafNode(lv_methodName_5_0, grammarAccess.getMethodCallAccess().getMethodNameSystemOutPrintlnKeyword_0_1_2_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMethodCallRule());
                    							}
                    							setWithLastConsumed(current, "methodName", lv_methodName_5_0, "System.out.println");
                    						

                    }


                    }


                    }
                    break;

            }


            }

            otherlv_6=(Token)match(input,30,FOLLOW_28); 

            			newLeafNode(otherlv_6, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1773:3: ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==30||LA24_0==40||(LA24_0>=42 && LA24_0<=53)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalSimplejava.g:1774:4: ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )*
                    {
                    // InternalSimplejava.g:1774:4: ( (lv_parameter_7_0= ruleGenericExpression ) )
                    // InternalSimplejava.g:1775:5: (lv_parameter_7_0= ruleGenericExpression )
                    {
                    // InternalSimplejava.g:1775:5: (lv_parameter_7_0= ruleGenericExpression )
                    // InternalSimplejava.g:1776:6: lv_parameter_7_0= ruleGenericExpression
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getParameterGenericExpressionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalSimplejava.g:1793:4: (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==31) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalSimplejava.g:1794:5: otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) )
                    	    {
                    	    otherlv_8=(Token)match(input,31,FOLLOW_11); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getMethodCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalSimplejava.g:1798:5: ( (lv_parameter_9_0= ruleGenericExpression ) )
                    	    // InternalSimplejava.g:1799:6: (lv_parameter_9_0= ruleGenericExpression )
                    	    {
                    	    // InternalSimplejava.g:1799:6: (lv_parameter_9_0= ruleGenericExpression )
                    	    // InternalSimplejava.g:1800:7: lv_parameter_9_0= ruleGenericExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodCallAccess().getParameterGenericExpressionParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,32,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_3());
            		

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


    // $ANTLR start "entryRuleConstructorCall"
    // InternalSimplejava.g:1827:1: entryRuleConstructorCall returns [EObject current=null] : iv_ruleConstructorCall= ruleConstructorCall EOF ;
    public final EObject entryRuleConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorCall = null;


        try {
            // InternalSimplejava.g:1827:56: (iv_ruleConstructorCall= ruleConstructorCall EOF )
            // InternalSimplejava.g:1828:2: iv_ruleConstructorCall= ruleConstructorCall EOF
            {
             newCompositeNode(grammarAccess.getConstructorCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstructorCall=ruleConstructorCall();

            state._fsp--;

             current =iv_ruleConstructorCall; 
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
    // $ANTLR end "entryRuleConstructorCall"


    // $ANTLR start "ruleConstructorCall"
    // InternalSimplejava.g:1834:1: ruleConstructorCall returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_1_0 = null;

        EObject lv_parameter_3_0 = null;

        EObject lv_parameter_5_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1840:2: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalSimplejava.g:1841:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalSimplejava.g:1841:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')' )
            // InternalSimplejava.g:1842:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getConstructorCallAccess().getNewKeyword_0());
            		
            // InternalSimplejava.g:1846:3: ( (lv_type_1_0= ruleType ) )
            // InternalSimplejava.g:1847:4: (lv_type_1_0= ruleType )
            {
            // InternalSimplejava.g:1847:4: (lv_type_1_0= ruleType )
            // InternalSimplejava.g:1848:5: lv_type_1_0= ruleType
            {

            					newCompositeNode(grammarAccess.getConstructorCallAccess().getTypeTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_type_1_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstructorCallRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"at.ac.tuwien.big.Simplejava.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getConstructorCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSimplejava.g:1869:3: ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_INT && LA26_0<=RULE_STRING)||(LA26_0>=50 && LA26_0<=52)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSimplejava.g:1870:4: ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )*
                    {
                    // InternalSimplejava.g:1870:4: ( (lv_parameter_3_0= ruleConstantExpression ) )
                    // InternalSimplejava.g:1871:5: (lv_parameter_3_0= ruleConstantExpression )
                    {
                    // InternalSimplejava.g:1871:5: (lv_parameter_3_0= ruleConstantExpression )
                    // InternalSimplejava.g:1872:6: lv_parameter_3_0= ruleConstantExpression
                    {

                    						newCompositeNode(grammarAccess.getConstructorCallAccess().getParameterConstantExpressionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_parameter_3_0=ruleConstantExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConstructorCallRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_3_0,
                    							"at.ac.tuwien.big.Simplejava.ConstantExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimplejava.g:1889:4: (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==31) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalSimplejava.g:1890:5: otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,31,FOLLOW_30); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getConstructorCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSimplejava.g:1894:5: ( (lv_parameter_5_0= ruleConstantExpression ) )
                    	    // InternalSimplejava.g:1895:6: (lv_parameter_5_0= ruleConstantExpression )
                    	    {
                    	    // InternalSimplejava.g:1895:6: (lv_parameter_5_0= ruleConstantExpression )
                    	    // InternalSimplejava.g:1896:7: lv_parameter_5_0= ruleConstantExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getConstructorCallAccess().getParameterConstantExpressionParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
                    	    lv_parameter_5_0=ruleConstantExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getConstructorCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_5_0,
                    	    								"at.ac.tuwien.big.Simplejava.ConstantExpression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,32,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getConstructorCallAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleConstructorCall"


    // $ANTLR start "entryRuleGenericExpression"
    // InternalSimplejava.g:1923:1: entryRuleGenericExpression returns [EObject current=null] : iv_ruleGenericExpression= ruleGenericExpression EOF ;
    public final EObject entryRuleGenericExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericExpression = null;


        try {
            // InternalSimplejava.g:1923:58: (iv_ruleGenericExpression= ruleGenericExpression EOF )
            // InternalSimplejava.g:1924:2: iv_ruleGenericExpression= ruleGenericExpression EOF
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
    // InternalSimplejava.g:1930:1: ruleGenericExpression returns [EObject current=null] : (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall ) ;
    public final EObject ruleGenericExpression() throws RecognitionException {
        EObject current = null;

        EObject this_VariableExpression_0 = null;

        EObject this_MethodCall_1 = null;

        EObject this_ParanthesisOrBinaryExpression_2 = null;

        EObject this_UnaryExpression_3 = null;

        EObject this_ConstantExpression_4 = null;

        EObject this_ConstructorCall_5 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1936:2: ( (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall ) )
            // InternalSimplejava.g:1937:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall )
            {
            // InternalSimplejava.g:1937:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall )
            int alt27=6;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalSimplejava.g:1938:3: this_VariableExpression_0= ruleVariableExpression
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
                    // InternalSimplejava.g:1947:3: this_MethodCall_1= ruleMethodCall
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
                    // InternalSimplejava.g:1956:3: this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression
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
                    // InternalSimplejava.g:1965:3: this_UnaryExpression_3= ruleUnaryExpression
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
                    // InternalSimplejava.g:1974:3: this_ConstantExpression_4= ruleConstantExpression
                    {

                    			newCompositeNode(grammarAccess.getGenericExpressionAccess().getConstantExpressionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConstantExpression_4=ruleConstantExpression();

                    state._fsp--;


                    			current = this_ConstantExpression_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSimplejava.g:1983:3: this_ConstructorCall_5= ruleConstructorCall
                    {

                    			newCompositeNode(grammarAccess.getGenericExpressionAccess().getConstructorCallParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConstructorCall_5=ruleConstructorCall();

                    state._fsp--;


                    			current = this_ConstructorCall_5;
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
    // InternalSimplejava.g:1995:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalSimplejava.g:1995:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalSimplejava.g:1996:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalSimplejava.g:2002:1: ruleConstantExpression returns [EObject current=null] : (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerExpression_0 = null;

        EObject this_StringExpression_1 = null;

        EObject this_BooleanExpression_2 = null;

        EObject this_NullExpression_3 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:2008:2: ( (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression ) )
            // InternalSimplejava.g:2009:2: (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression )
            {
            // InternalSimplejava.g:2009:2: (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression )
            int alt28=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt28=1;
                }
                break;
            case RULE_STRING:
                {
                alt28=2;
                }
                break;
            case 51:
            case 52:
                {
                alt28=3;
                }
                break;
            case 50:
                {
                alt28=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalSimplejava.g:2010:3: this_IntegerExpression_0= ruleIntegerExpression
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
                    // InternalSimplejava.g:2019:3: this_StringExpression_1= ruleStringExpression
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
                    // InternalSimplejava.g:2028:3: this_BooleanExpression_2= ruleBooleanExpression
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
                    // InternalSimplejava.g:2037:3: this_NullExpression_3= ruleNullExpression
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
    // InternalSimplejava.g:2049:1: entryRuleNullExpression returns [EObject current=null] : iv_ruleNullExpression= ruleNullExpression EOF ;
    public final EObject entryRuleNullExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExpression = null;


        try {
            // InternalSimplejava.g:2049:55: (iv_ruleNullExpression= ruleNullExpression EOF )
            // InternalSimplejava.g:2050:2: iv_ruleNullExpression= ruleNullExpression EOF
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
    // InternalSimplejava.g:2056:1: ruleNullExpression returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2062:2: ( ( () otherlv_1= 'null' ) )
            // InternalSimplejava.g:2063:2: ( () otherlv_1= 'null' )
            {
            // InternalSimplejava.g:2063:2: ( () otherlv_1= 'null' )
            // InternalSimplejava.g:2064:3: () otherlv_1= 'null'
            {
            // InternalSimplejava.g:2064:3: ()
            // InternalSimplejava.g:2065:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNullExpressionAccess().getNullExpressionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,50,FOLLOW_2); 

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
    // InternalSimplejava.g:2079:1: entryRuleIntegerExpression returns [EObject current=null] : iv_ruleIntegerExpression= ruleIntegerExpression EOF ;
    public final EObject entryRuleIntegerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerExpression = null;


        try {
            // InternalSimplejava.g:2079:58: (iv_ruleIntegerExpression= ruleIntegerExpression EOF )
            // InternalSimplejava.g:2080:2: iv_ruleIntegerExpression= ruleIntegerExpression EOF
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
    // InternalSimplejava.g:2086:1: ruleIntegerExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2092:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalSimplejava.g:2093:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalSimplejava.g:2093:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalSimplejava.g:2094:3: (lv_value_0_0= RULE_INT )
            {
            // InternalSimplejava.g:2094:3: (lv_value_0_0= RULE_INT )
            // InternalSimplejava.g:2095:4: lv_value_0_0= RULE_INT
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
    // InternalSimplejava.g:2114:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalSimplejava.g:2114:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalSimplejava.g:2115:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
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
    // InternalSimplejava.g:2121:1: ruleBooleanExpression returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2127:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalSimplejava.g:2128:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalSimplejava.g:2128:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalSimplejava.g:2129:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalSimplejava.g:2129:3: ()
            // InternalSimplejava.g:2130:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanExpressionAccess().getBooleanExpressionAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:2136:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==51) ) {
                alt29=1;
            }
            else if ( (LA29_0==52) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalSimplejava.g:2137:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalSimplejava.g:2137:4: ( (lv_value_1_0= 'true' ) )
                    // InternalSimplejava.g:2138:5: (lv_value_1_0= 'true' )
                    {
                    // InternalSimplejava.g:2138:5: (lv_value_1_0= 'true' )
                    // InternalSimplejava.g:2139:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,51,FOLLOW_2); 

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
                    // InternalSimplejava.g:2152:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_2); 

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
    // InternalSimplejava.g:2161:1: entryRuleStringExpression returns [EObject current=null] : iv_ruleStringExpression= ruleStringExpression EOF ;
    public final EObject entryRuleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExpression = null;


        try {
            // InternalSimplejava.g:2161:57: (iv_ruleStringExpression= ruleStringExpression EOF )
            // InternalSimplejava.g:2162:2: iv_ruleStringExpression= ruleStringExpression EOF
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
    // InternalSimplejava.g:2168:1: ruleStringExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2174:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalSimplejava.g:2175:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalSimplejava.g:2175:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalSimplejava.g:2176:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalSimplejava.g:2176:3: (lv_value_0_0= RULE_STRING )
            // InternalSimplejava.g:2177:4: lv_value_0_0= RULE_STRING
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
    // InternalSimplejava.g:2196:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalSimplejava.g:2196:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalSimplejava.g:2197:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalSimplejava.g:2203:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        EObject lv_source_1_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:2209:2: ( ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) ) )
            // InternalSimplejava.g:2210:2: ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) )
            {
            // InternalSimplejava.g:2210:2: ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) )
            // InternalSimplejava.g:2211:3: ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) )
            {
            // InternalSimplejava.g:2211:3: ( (lv_type_0_0= '!' ) )
            // InternalSimplejava.g:2212:4: (lv_type_0_0= '!' )
            {
            // InternalSimplejava.g:2212:4: (lv_type_0_0= '!' )
            // InternalSimplejava.g:2213:5: lv_type_0_0= '!'
            {
            lv_type_0_0=(Token)match(input,53,FOLLOW_11); 

            					newLeafNode(lv_type_0_0, grammarAccess.getUnaryExpressionAccess().getTypeExclamationMarkKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnaryExpressionRule());
            					}
            					setWithLastConsumed(current, "type", lv_type_0_0, "!");
            				

            }


            }

            // InternalSimplejava.g:2225:3: ( (lv_source_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:2226:4: (lv_source_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:2226:4: (lv_source_1_0= ruleGenericExpression )
            // InternalSimplejava.g:2227:5: lv_source_1_0= ruleGenericExpression
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
    // InternalSimplejava.g:2248:1: entryRuleVariableExpression returns [EObject current=null] : iv_ruleVariableExpression= ruleVariableExpression EOF ;
    public final EObject entryRuleVariableExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableExpression = null;


        try {
            // InternalSimplejava.g:2248:59: (iv_ruleVariableExpression= ruleVariableExpression EOF )
            // InternalSimplejava.g:2249:2: iv_ruleVariableExpression= ruleVariableExpression EOF
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
    // InternalSimplejava.g:2255:1: ruleVariableExpression returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariableExpression() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalSimplejava.g:2261:2: ( ( ( ruleQualifiedName ) ) )
            // InternalSimplejava.g:2262:2: ( ( ruleQualifiedName ) )
            {
            // InternalSimplejava.g:2262:2: ( ( ruleQualifiedName ) )
            // InternalSimplejava.g:2263:3: ( ruleQualifiedName )
            {
            // InternalSimplejava.g:2263:3: ( ruleQualifiedName )
            // InternalSimplejava.g:2264:4: ruleQualifiedName
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
    // InternalSimplejava.g:2281:1: entryRuleParanthesisOrBinaryExpression returns [EObject current=null] : iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF ;
    public final EObject entryRuleParanthesisOrBinaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesisOrBinaryExpression = null;


        try {
            // InternalSimplejava.g:2281:70: (iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF )
            // InternalSimplejava.g:2282:2: iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF
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
    // InternalSimplejava.g:2288:1: ruleParanthesisOrBinaryExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' ) ;
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
            // InternalSimplejava.g:2294:2: ( (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' ) )
            // InternalSimplejava.g:2295:2: (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' )
            {
            // InternalSimplejava.g:2295:2: (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' )
            // InternalSimplejava.g:2296:3: otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesisOrBinaryExpressionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalSimplejava.g:2300:3: ( (lv_source_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:2301:4: (lv_source_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:2301:4: (lv_source_1_0= ruleGenericExpression )
            // InternalSimplejava.g:2302:5: lv_source_1_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionAccess().getSourceGenericExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_31);
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

            // InternalSimplejava.g:2319:3: ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=54 && LA31_0<=66)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalSimplejava.g:2320:4: ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) )
                    {
                    // InternalSimplejava.g:2320:4: ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) )
                    // InternalSimplejava.g:2321:5: ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) )
                    {
                    // InternalSimplejava.g:2321:5: ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) )
                    // InternalSimplejava.g:2322:6: (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' )
                    {
                    // InternalSimplejava.g:2322:6: (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' )
                    int alt30=13;
                    switch ( input.LA(1) ) {
                    case 54:
                        {
                        alt30=1;
                        }
                        break;
                    case 55:
                        {
                        alt30=2;
                        }
                        break;
                    case 56:
                        {
                        alt30=3;
                        }
                        break;
                    case 57:
                        {
                        alt30=4;
                        }
                        break;
                    case 58:
                        {
                        alt30=5;
                        }
                        break;
                    case 59:
                        {
                        alt30=6;
                        }
                        break;
                    case 60:
                        {
                        alt30=7;
                        }
                        break;
                    case 61:
                        {
                        alt30=8;
                        }
                        break;
                    case 62:
                        {
                        alt30=9;
                        }
                        break;
                    case 63:
                        {
                        alt30=10;
                        }
                        break;
                    case 64:
                        {
                        alt30=11;
                        }
                        break;
                    case 65:
                        {
                        alt30=12;
                        }
                        break;
                    case 66:
                        {
                        alt30=13;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }

                    switch (alt30) {
                        case 1 :
                            // InternalSimplejava.g:2323:7: lv_type_2_1= '||'
                            {
                            lv_type_2_1=(Token)match(input,54,FOLLOW_11); 

                            							newLeafNode(lv_type_2_1, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeVerticalLineVerticalLineKeyword_2_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:2334:7: lv_type_2_2= '&&'
                            {
                            lv_type_2_2=(Token)match(input,55,FOLLOW_11); 

                            							newLeafNode(lv_type_2_2, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAmpersandAmpersandKeyword_2_0_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSimplejava.g:2345:7: lv_type_2_3= '&'
                            {
                            lv_type_2_3=(Token)match(input,56,FOLLOW_11); 

                            							newLeafNode(lv_type_2_3, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAmpersandKeyword_2_0_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSimplejava.g:2356:7: lv_type_2_4= '+'
                            {
                            lv_type_2_4=(Token)match(input,57,FOLLOW_11); 

                            							newLeafNode(lv_type_2_4, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypePlusSignKeyword_2_0_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSimplejava.g:2367:7: lv_type_2_5= '-'
                            {
                            lv_type_2_5=(Token)match(input,58,FOLLOW_11); 

                            							newLeafNode(lv_type_2_5, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeHyphenMinusKeyword_2_0_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalSimplejava.g:2378:7: lv_type_2_6= '*'
                            {
                            lv_type_2_6=(Token)match(input,59,FOLLOW_11); 

                            							newLeafNode(lv_type_2_6, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAsteriskKeyword_2_0_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_6, null);
                            						

                            }
                            break;
                        case 7 :
                            // InternalSimplejava.g:2389:7: lv_type_2_7= '/'
                            {
                            lv_type_2_7=(Token)match(input,60,FOLLOW_11); 

                            							newLeafNode(lv_type_2_7, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeSolidusKeyword_2_0_0_6());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_7, null);
                            						

                            }
                            break;
                        case 8 :
                            // InternalSimplejava.g:2400:7: lv_type_2_8= '=='
                            {
                            lv_type_2_8=(Token)match(input,61,FOLLOW_11); 

                            							newLeafNode(lv_type_2_8, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeEqualsSignEqualsSignKeyword_2_0_0_7());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_8, null);
                            						

                            }
                            break;
                        case 9 :
                            // InternalSimplejava.g:2411:7: lv_type_2_9= '!='
                            {
                            lv_type_2_9=(Token)match(input,62,FOLLOW_11); 

                            							newLeafNode(lv_type_2_9, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeExclamationMarkEqualsSignKeyword_2_0_0_8());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_9, null);
                            						

                            }
                            break;
                        case 10 :
                            // InternalSimplejava.g:2422:7: lv_type_2_10= '<'
                            {
                            lv_type_2_10=(Token)match(input,63,FOLLOW_11); 

                            							newLeafNode(lv_type_2_10, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeLessThanSignKeyword_2_0_0_9());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_10, null);
                            						

                            }
                            break;
                        case 11 :
                            // InternalSimplejava.g:2433:7: lv_type_2_11= '<='
                            {
                            lv_type_2_11=(Token)match(input,64,FOLLOW_11); 

                            							newLeafNode(lv_type_2_11, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeLessThanSignEqualsSignKeyword_2_0_0_10());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_11, null);
                            						

                            }
                            break;
                        case 12 :
                            // InternalSimplejava.g:2444:7: lv_type_2_12= '>'
                            {
                            lv_type_2_12=(Token)match(input,65,FOLLOW_11); 

                            							newLeafNode(lv_type_2_12, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeGreaterThanSignKeyword_2_0_0_11());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_12, null);
                            						

                            }
                            break;
                        case 13 :
                            // InternalSimplejava.g:2455:7: lv_type_2_13= '>='
                            {
                            lv_type_2_13=(Token)match(input,66,FOLLOW_11); 

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

                    // InternalSimplejava.g:2468:4: ( (lv_argument_3_0= ruleGenericExpression ) )
                    // InternalSimplejava.g:2469:5: (lv_argument_3_0= ruleGenericExpression )
                    {
                    // InternalSimplejava.g:2469:5: (lv_argument_3_0= ruleGenericExpression )
                    // InternalSimplejava.g:2470:6: lv_argument_3_0= ruleGenericExpression
                    {

                    						newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionAccess().getArgumentGenericExpressionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_23);
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

            otherlv_4=(Token)match(input,32,FOLLOW_2); 

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
    // InternalSimplejava.g:2496:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalSimplejava.g:2496:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalSimplejava.g:2497:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
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
    // InternalSimplejava.g:2503:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:2509:2: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalSimplejava.g:2510:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalSimplejava.g:2510:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalSimplejava.g:2511:3: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {

            			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
            		
            pushFollow(FOLLOW_32);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            			current.merge(this_QualifiedName_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSimplejava.g:2521:3: (kw= '.*' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==67) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalSimplejava.g:2522:4: kw= '.*'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

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
    // InternalSimplejava.g:2532:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSimplejava.g:2532:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSimplejava.g:2533:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalSimplejava.g:2539:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2545:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSimplejava.g:2546:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSimplejava.g:2546:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSimplejava.g:2547:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_33); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalSimplejava.g:2554:3: (kw= '.' this_ID_2= RULE_ID )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // InternalSimplejava.g:2555:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,41,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_33); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop33;
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


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String dfa_1s = "\21\uffff";
    static final String dfa_2s = "\14\uffff\1\17\4\uffff";
    static final String dfa_3s = "\14\4\1\14\1\4\2\uffff\1\4";
    static final String dfa_4s = "\1\33\11\34\1\51\1\4\1\22\1\4\2\uffff\1\51";
    static final String dfa_5s = "\16\uffff\1\2\1\1\1\uffff";
    static final String dfa_6s = "\21\uffff}>";
    static final String[] dfa_7s = {
            "\1\12\16\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13",
            "\1\14\27\uffff\1\13\14\uffff\1\15",
            "\1\14",
            "\1\17\5\uffff\1\16",
            "\1\20",
            "",
            "",
            "\1\14\27\uffff\1\13\14\uffff\1\15"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "342:2: (this_SimpleParameter_0= ruleSimpleParameter | this_Attribute_1= ruleAttribute )";
        }
    }
    static final String dfa_8s = "\6\uffff";
    static final String dfa_9s = "\1\4\1\uffff\2\4\1\uffff\1\4";
    static final String dfa_10s = "\1\33\1\uffff\1\51\1\4\1\uffff\1\51";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_12s = "\6\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\16\uffff\11\1",
            "",
            "\1\1\15\uffff\1\4\11\uffff\1\1\14\uffff\1\3",
            "\1\5",
            "",
            "\1\1\15\uffff\1\4\11\uffff\1\1\14\uffff\1\3"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "889:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )";
        }
    }
    static final String dfa_14s = "\35\uffff";
    static final String dfa_15s = "\1\4\2\uffff\1\4\1\uffff\1\36\3\uffff\1\4\1\uffff\14\4\1\uffff\1\4\1\22\1\4\1\uffff\1\4";
    static final String dfa_16s = "\1\60\2\uffff\1\51\1\uffff\1\36\3\uffff\1\60\1\uffff\1\33\1\51\11\34\1\51\1\uffff\1\4\1\45\1\4\1\uffff\1\51";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\uffff\1\7\1\10\1\11\1\uffff\1\3\14\uffff\1\5\3\uffff\1\6\1\uffff";
    static final String dfa_18s = "\35\uffff}>";
    static final String[] dfa_19s = {
            "\1\3\13\uffff\1\1\2\uffff\11\2\5\uffff\1\1\1\4\1\uffff\1\5\1\uffff\1\6\1\7\1\10\1\uffff\7\10",
            "",
            "",
            "\1\2\15\uffff\1\12\11\uffff\1\2\1\uffff\1\10\12\uffff\1\11",
            "",
            "\1\13",
            "",
            "",
            "",
            "\1\14\45\uffff\7\10",
            "",
            "\1\26\7\uffff\1\27\6\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25",
            "\1\2\15\uffff\1\12\11\uffff\1\2\1\uffff\1\10\12\uffff\1\11",
            "\1\31\27\uffff\1\30",
            "\1\31\27\uffff\1\30",
            "\1\31\27\uffff\1\30",
            "\1\31\27\uffff\1\30",
            "\1\31\27\uffff\1\30",
            "\1\31\27\uffff\1\30",
            "\1\31\27\uffff\1\30",
            "\1\31\27\uffff\1\30",
            "\1\31\27\uffff\1\30",
            "\1\31\15\uffff\1\27\11\uffff\1\30\14\uffff\1\32",
            "",
            "\1\31",
            "\1\27\22\uffff\1\33",
            "\1\34",
            "",
            "\1\31\15\uffff\1\27\11\uffff\1\30\14\uffff\1\32"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "925:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) )";
        }
    }
    static final String dfa_20s = "\12\uffff";
    static final String dfa_21s = "\1\uffff\1\10\7\uffff\1\10";
    static final String dfa_22s = "\1\4\1\14\5\uffff\1\4\1\uffff\1\14";
    static final String dfa_23s = "\1\65\1\102\5\uffff\1\60\1\uffff\1\102";
    static final String dfa_24s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\uffff\1\1\1\uffff";
    static final String dfa_25s = "\12\uffff}>";
    static final String[] dfa_26s = {
            "\1\1\2\5\27\uffff\1\3\11\uffff\1\2\1\uffff\7\2\1\6\3\5\1\4",
            "\1\10\21\uffff\1\2\2\10\10\uffff\1\7\14\uffff\15\10",
            "",
            "",
            "",
            "",
            "",
            "\1\11\45\uffff\7\2",
            "",
            "\1\10\21\uffff\1\2\2\10\10\uffff\1\7\14\uffff\15\10"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "1937:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall )";
        }
    }
    static final String dfa_27s = "\26\uffff";
    static final String dfa_28s = "\1\1\2\uffff\1\5\22\uffff";
    static final String dfa_29s = "\1\4\1\uffff\3\4\1\uffff\5\37\1\uffff\2\4\1\uffff\1\4\5\37\1\4";
    static final String dfa_30s = "\1\103\1\uffff\1\60\1\103\1\65\1\uffff\5\40\1\uffff\1\51\1\65\1\uffff\1\60\5\40\1\51";
    static final String dfa_31s = "\1\uffff\1\2\3\uffff\1\1\5\uffff\1\1\2\uffff\1\1\7\uffff";
    static final String dfa_32s = "\26\uffff}>";
    static final String[] dfa_33s = {
            "\1\1\7\uffff\1\1\5\uffff\1\1\11\uffff\1\1\1\uffff\3\1\10\uffff\1\2\14\uffff\16\1",
            "",
            "\1\3\45\uffff\7\1",
            "\1\5\7\uffff\1\5\5\uffff\1\5\11\uffff\1\5\1\uffff\1\4\2\5\10\uffff\1\5\14\uffff\16\5",
            "\1\14\1\6\1\7\14\uffff\11\13\2\uffff\1\1\1\uffff\1\13\7\uffff\1\1\1\uffff\10\1\1\12\1\10\1\11\1\1",
            "",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "",
            "\1\16\27\uffff\1\16\1\uffff\3\1\10\uffff\1\17",
            "\1\1\1\20\1\21\27\uffff\1\1\11\uffff\1\1\1\uffff\10\1\1\24\1\22\1\23\1\1",
            "",
            "\1\25\45\uffff\7\1",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\16\27\uffff\1\16\1\uffff\3\1\10\uffff\1\17"
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "()* loopback of 2554:3: (kw= '.' this_ID_2= RULE_ID )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000FFA4010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x003FFD0040000070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000002FF80010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000FF80010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000010FF80010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000200010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0001FDD60FFB0010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000000FF81010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0001FDD60FF90010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0001FC0000000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x003FFD0140000070L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x001C000100000060L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x001C000000000060L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0xFFC0000100000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000020000000002L});

}