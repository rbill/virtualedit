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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "';'", "'import'", "'public'", "'class'", "'{'", "'}'", "'='", "'int'", "'double'", "'String'", "'boolean'", "'Object'", "'List'", "'ArrayList'", "'Logger'", "'void'", "'static'", "'('", "','", "')'", "'pointcutblock'", "'if'", "'else'", "'for'", "':'", "'while'", "'return'", "'this'", "'.'", "'equals'", "'hashCode'", "'add'", "'remove'", "'clear'", "'logp'", "'System.out.println'", "'new'", "'null'", "'true'", "'false'", "'!'", "'||'", "'&&'", "'&'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'.*'"
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
    // InternalSimplejava.g:506:1: ruleType returns [EObject current=null] : ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) ) ;
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


        	enterRule();

        try {
            // InternalSimplejava.g:512:2: ( ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) ) )
            // InternalSimplejava.g:513:2: ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) )
            {
            // InternalSimplejava.g:513:2: ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) ) | ( (lv_isVoid_1_0= 'void' ) ) | ( ( ruleQualifiedName ) ) )
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
                    // InternalSimplejava.g:514:3: ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) )
                    {
                    // InternalSimplejava.g:514:3: ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) ) )
                    // InternalSimplejava.g:515:4: ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) )
                    {
                    // InternalSimplejava.g:515:4: ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' ) )
                    // InternalSimplejava.g:516:5: (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' )
                    {
                    // InternalSimplejava.g:516:5: (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' | lv_typeName_0_5= 'Object' | lv_typeName_0_6= 'List' | lv_typeName_0_7= 'ArrayList' | lv_typeName_0_8= 'Logger' )
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
                            // InternalSimplejava.g:517:6: lv_typeName_0_1= 'int'
                            {
                            lv_typeName_0_1=(Token)match(input,19,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_1, grammarAccess.getTypeAccess().getTypeNameIntKeyword_0_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:528:6: lv_typeName_0_2= 'double'
                            {
                            lv_typeName_0_2=(Token)match(input,20,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_2, grammarAccess.getTypeAccess().getTypeNameDoubleKeyword_0_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalSimplejava.g:539:6: lv_typeName_0_3= 'String'
                            {
                            lv_typeName_0_3=(Token)match(input,21,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_3, grammarAccess.getTypeAccess().getTypeNameStringKeyword_0_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                            					

                            }
                            break;
                        case 4 :
                            // InternalSimplejava.g:550:6: lv_typeName_0_4= 'boolean'
                            {
                            lv_typeName_0_4=(Token)match(input,22,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_4, grammarAccess.getTypeAccess().getTypeNameBooleanKeyword_0_0_3());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                            					

                            }
                            break;
                        case 5 :
                            // InternalSimplejava.g:561:6: lv_typeName_0_5= 'Object'
                            {
                            lv_typeName_0_5=(Token)match(input,23,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_5, grammarAccess.getTypeAccess().getTypeNameObjectKeyword_0_0_4());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_5, null);
                            					

                            }
                            break;
                        case 6 :
                            // InternalSimplejava.g:572:6: lv_typeName_0_6= 'List'
                            {
                            lv_typeName_0_6=(Token)match(input,24,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_6, grammarAccess.getTypeAccess().getTypeNameListKeyword_0_0_5());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_6, null);
                            					

                            }
                            break;
                        case 7 :
                            // InternalSimplejava.g:583:6: lv_typeName_0_7= 'ArrayList'
                            {
                            lv_typeName_0_7=(Token)match(input,25,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_7, grammarAccess.getTypeAccess().getTypeNameArrayListKeyword_0_0_6());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_7, null);
                            					

                            }
                            break;
                        case 8 :
                            // InternalSimplejava.g:594:6: lv_typeName_0_8= 'Logger'
                            {
                            lv_typeName_0_8=(Token)match(input,26,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_8, grammarAccess.getTypeAccess().getTypeNameLoggerKeyword_0_0_7());
                            					

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
                    // InternalSimplejava.g:608:3: ( (lv_isVoid_1_0= 'void' ) )
                    {
                    // InternalSimplejava.g:608:3: ( (lv_isVoid_1_0= 'void' ) )
                    // InternalSimplejava.g:609:4: (lv_isVoid_1_0= 'void' )
                    {
                    // InternalSimplejava.g:609:4: (lv_isVoid_1_0= 'void' )
                    // InternalSimplejava.g:610:5: lv_isVoid_1_0= 'void'
                    {
                    lv_isVoid_1_0=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_isVoid_1_0, grammarAccess.getTypeAccess().getIsVoidVoidKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTypeRule());
                    					}
                    					setWithLastConsumed(current, "isVoid", true, "void");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSimplejava.g:623:3: ( ( ruleQualifiedName ) )
                    {
                    // InternalSimplejava.g:623:3: ( ( ruleQualifiedName ) )
                    // InternalSimplejava.g:624:4: ( ruleQualifiedName )
                    {
                    // InternalSimplejava.g:624:4: ( ruleQualifiedName )
                    // InternalSimplejava.g:625:5: ruleQualifiedName
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTypeRule());
                    					}
                    				

                    					newCompositeNode(grammarAccess.getTypeAccess().getTypeRefClassDeclarationCrossReference_2_0());
                    				
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
    // InternalSimplejava.g:643:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalSimplejava.g:643:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalSimplejava.g:644:2: iv_ruleMethod= ruleMethod EOF
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
    // InternalSimplejava.g:650:1: ruleMethod returns [EObject current=null] : (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) ) ) ;
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
            // InternalSimplejava.g:656:2: ( (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) ) ) )
            // InternalSimplejava.g:657:2: (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) ) )
            {
            // InternalSimplejava.g:657:2: (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) ) )
            // InternalSimplejava.g:658:3: otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? ( (lv_returnType_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) )? otherlv_4= '(' ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )? otherlv_8= ')' ( (lv_content_9_0= ruleMethodBlock ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getMethodAccess().getPublicKeyword_0());
            		
            // InternalSimplejava.g:662:3: ( (lv_static_1_0= 'static' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==28) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSimplejava.g:663:4: (lv_static_1_0= 'static' )
                    {
                    // InternalSimplejava.g:663:4: (lv_static_1_0= 'static' )
                    // InternalSimplejava.g:664:5: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,28,FOLLOW_13); 

                    					newLeafNode(lv_static_1_0, grammarAccess.getMethodAccess().getStaticStaticKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodRule());
                    					}
                    					setWithLastConsumed(current, "static", true, "static");
                    				

                    }


                    }
                    break;

            }

            // InternalSimplejava.g:676:3: ( (lv_returnType_2_0= ruleType ) )
            // InternalSimplejava.g:677:4: (lv_returnType_2_0= ruleType )
            {
            // InternalSimplejava.g:677:4: (lv_returnType_2_0= ruleType )
            // InternalSimplejava.g:678:5: lv_returnType_2_0= ruleType
            {

            					newCompositeNode(grammarAccess.getMethodAccess().getReturnTypeTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
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

            // InternalSimplejava.g:695:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSimplejava.g:696:4: (lv_name_3_0= RULE_ID )
                    {
                    // InternalSimplejava.g:696:4: (lv_name_3_0= RULE_ID )
                    // InternalSimplejava.g:697:5: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_15); 

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

            otherlv_4=(Token)match(input,29,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSimplejava.g:717:3: ( ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||(LA11_0>=19 && LA11_0<=27)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSimplejava.g:718:4: ( (lv_parameter_5_0= ruleSimpleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )*
                    {
                    // InternalSimplejava.g:718:4: ( (lv_parameter_5_0= ruleSimpleParameter ) )
                    // InternalSimplejava.g:719:5: (lv_parameter_5_0= ruleSimpleParameter )
                    {
                    // InternalSimplejava.g:719:5: (lv_parameter_5_0= ruleSimpleParameter )
                    // InternalSimplejava.g:720:6: lv_parameter_5_0= ruleSimpleParameter
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getParameterSimpleParameterParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_17);
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

                    // InternalSimplejava.g:737:4: (otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==30) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalSimplejava.g:738:5: otherlv_6= ',' ( (lv_parameter_7_0= ruleSimpleParameter ) )
                    	    {
                    	    otherlv_6=(Token)match(input,30,FOLLOW_13); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getMethodAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalSimplejava.g:742:5: ( (lv_parameter_7_0= ruleSimpleParameter ) )
                    	    // InternalSimplejava.g:743:6: (lv_parameter_7_0= ruleSimpleParameter )
                    	    {
                    	    // InternalSimplejava.g:743:6: (lv_parameter_7_0= ruleSimpleParameter )
                    	    // InternalSimplejava.g:744:7: lv_parameter_7_0= ruleSimpleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodAccess().getParameterSimpleParameterParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_17);
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
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,31,FOLLOW_18); 

            			newLeafNode(otherlv_8, grammarAccess.getMethodAccess().getRightParenthesisKeyword_6());
            		
            // InternalSimplejava.g:767:3: ( (lv_content_9_0= ruleMethodBlock ) )
            // InternalSimplejava.g:768:4: (lv_content_9_0= ruleMethodBlock )
            {
            // InternalSimplejava.g:768:4: (lv_content_9_0= ruleMethodBlock )
            // InternalSimplejava.g:769:5: lv_content_9_0= ruleMethodBlock
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
    // InternalSimplejava.g:790:1: entryRuleMethodBlock returns [EObject current=null] : iv_ruleMethodBlock= ruleMethodBlock EOF ;
    public final EObject entryRuleMethodBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodBlock = null;


        try {
            // InternalSimplejava.g:790:52: (iv_ruleMethodBlock= ruleMethodBlock EOF )
            // InternalSimplejava.g:791:2: iv_ruleMethodBlock= ruleMethodBlock EOF
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
    // InternalSimplejava.g:797:1: ruleMethodBlock returns [EObject current=null] : ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleMethodBlock() throws RecognitionException {
        EObject current = null;

        Token lv_generated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statements_3_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:803:2: ( ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) ) )
            // InternalSimplejava.g:804:2: ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) )
            {
            // InternalSimplejava.g:804:2: ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) )
            // InternalSimplejava.g:805:3: () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' )
            {
            // InternalSimplejava.g:805:3: ()
            // InternalSimplejava.g:806:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodBlockAccess().getMethodBlockAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:812:3: ( (lv_generated_1_0= 'pointcutblock' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSimplejava.g:813:4: (lv_generated_1_0= 'pointcutblock' )
                    {
                    // InternalSimplejava.g:813:4: (lv_generated_1_0= 'pointcutblock' )
                    // InternalSimplejava.g:814:5: lv_generated_1_0= 'pointcutblock'
                    {
                    lv_generated_1_0=(Token)match(input,32,FOLLOW_7); 

                    					newLeafNode(lv_generated_1_0, grammarAccess.getMethodBlockAccess().getGeneratedPointcutblockKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodBlockRule());
                    					}
                    					setWithLastConsumed(current, "generated", true, "pointcutblock");
                    				

                    }


                    }
                    break;

            }

            // InternalSimplejava.g:826:3: (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' )
            // InternalSimplejava.g:827:4: otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}'
            {
            otherlv_2=(Token)match(input,16,FOLLOW_19); 

            				newLeafNode(otherlv_2, grammarAccess.getMethodBlockAccess().getLeftCurlyBracketKeyword_2_0());
            			
            // InternalSimplejava.g:831:4: ( (lv_statements_3_0= ruleStatement ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||LA13_0==16||(LA13_0>=19 && LA13_0<=27)||(LA13_0>=32 && LA13_0<=33)||LA13_0==35||(LA13_0>=37 && LA13_0<=39)||(LA13_0>=41 && LA13_0<=47)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSimplejava.g:832:5: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalSimplejava.g:832:5: (lv_statements_3_0= ruleStatement )
            	    // InternalSimplejava.g:833:6: lv_statements_3_0= ruleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getMethodBlockAccess().getStatementsStatementParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
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
            	    break loop13;
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
    // InternalSimplejava.g:859:1: entryRuleSimpleStatement returns [EObject current=null] : iv_ruleSimpleStatement= ruleSimpleStatement EOF ;
    public final EObject entryRuleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleStatement = null;


        try {
            // InternalSimplejava.g:859:56: (iv_ruleSimpleStatement= ruleSimpleStatement EOF )
            // InternalSimplejava.g:860:2: iv_ruleSimpleStatement= ruleSimpleStatement EOF
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
    // InternalSimplejava.g:866:1: ruleSimpleStatement returns [EObject current=null] : (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment ) ;
    public final EObject ruleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleVariableDeclaration_0 = null;

        EObject this_Assignment_1 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:872:2: ( (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment ) )
            // InternalSimplejava.g:873:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )
            {
            // InternalSimplejava.g:873:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalSimplejava.g:874:3: this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration
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
                    // InternalSimplejava.g:883:3: this_Assignment_1= ruleAssignment
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
    // InternalSimplejava.g:895:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalSimplejava.g:895:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalSimplejava.g:896:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalSimplejava.g:902:1: ruleStatement returns [EObject current=null] : (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) ) ;
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
            // InternalSimplejava.g:908:2: ( (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) ) )
            // InternalSimplejava.g:909:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) )
            {
            // InternalSimplejava.g:909:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) )
            int alt15=9;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalSimplejava.g:910:3: this_MethodBlock_0= ruleMethodBlock
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
                    // InternalSimplejava.g:919:3: this_VariableDeclaration_1= ruleVariableDeclaration
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
                    // InternalSimplejava.g:928:3: this_Assignment_2= ruleAssignment
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
                    // InternalSimplejava.g:937:3: this_IfStatement_3= ruleIfStatement
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
                    // InternalSimplejava.g:946:3: this_ForStatement_4= ruleForStatement
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
                    // InternalSimplejava.g:955:3: this_ForInStatement_5= ruleForInStatement
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
                    // InternalSimplejava.g:964:3: this_WhileStatement_6= ruleWhileStatement
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
                    // InternalSimplejava.g:973:3: this_ReturnStatement_7= ruleReturnStatement
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
                    // InternalSimplejava.g:982:3: (this_MethodCall_8= ruleMethodCall otherlv_9= ';' )
                    {
                    // InternalSimplejava.g:982:3: (this_MethodCall_8= ruleMethodCall otherlv_9= ';' )
                    // InternalSimplejava.g:983:4: this_MethodCall_8= ruleMethodCall otherlv_9= ';'
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
    // InternalSimplejava.g:1000:1: entryRuleSimpleVariableDeclaration returns [EObject current=null] : iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF ;
    public final EObject entryRuleSimpleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleVariableDeclaration = null;


        try {
            // InternalSimplejava.g:1000:66: (iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF )
            // InternalSimplejava.g:1001:2: iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF
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
    // InternalSimplejava.g:1007:1: ruleSimpleVariableDeclaration returns [EObject current=null] : ( () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleSimpleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_parameter_1_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1013:2: ( ( () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) )
            // InternalSimplejava.g:1014:2: ( () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            {
            // InternalSimplejava.g:1014:2: ( () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            // InternalSimplejava.g:1015:3: () ( (lv_parameter_1_0= ruleSimpleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) )
            {
            // InternalSimplejava.g:1015:3: ()
            // InternalSimplejava.g:1016:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleVariableDeclarationAccess().getVariableDeclarationAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:1022:3: ( (lv_parameter_1_0= ruleSimpleParameter ) )
            // InternalSimplejava.g:1023:4: (lv_parameter_1_0= ruleSimpleParameter )
            {
            // InternalSimplejava.g:1023:4: (lv_parameter_1_0= ruleSimpleParameter )
            // InternalSimplejava.g:1024:5: lv_parameter_1_0= ruleSimpleParameter
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
            		
            // InternalSimplejava.g:1045:3: ( (lv_expression_3_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1046:4: (lv_expression_3_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1046:4: (lv_expression_3_0= ruleGenericExpression )
            // InternalSimplejava.g:1047:5: lv_expression_3_0= ruleGenericExpression
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
    // InternalSimplejava.g:1068:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalSimplejava.g:1068:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalSimplejava.g:1069:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalSimplejava.g:1075:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parameter_0_0 = null;

        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1081:2: ( ( ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) )
            // InternalSimplejava.g:1082:2: ( ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            {
            // InternalSimplejava.g:1082:2: ( ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            // InternalSimplejava.g:1083:3: ( (lv_parameter_0_0= ruleSimpleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';'
            {
            // InternalSimplejava.g:1083:3: ( (lv_parameter_0_0= ruleSimpleParameter ) )
            // InternalSimplejava.g:1084:4: (lv_parameter_0_0= ruleSimpleParameter )
            {
            // InternalSimplejava.g:1084:4: (lv_parameter_0_0= ruleSimpleParameter )
            // InternalSimplejava.g:1085:5: lv_parameter_0_0= ruleSimpleParameter
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
            		
            // InternalSimplejava.g:1106:3: ( (lv_expression_2_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1107:4: (lv_expression_2_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1107:4: (lv_expression_2_0= ruleGenericExpression )
            // InternalSimplejava.g:1108:5: lv_expression_2_0= ruleGenericExpression
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
    // InternalSimplejava.g:1133:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalSimplejava.g:1133:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalSimplejava.g:1134:2: iv_ruleAssignment= ruleAssignment EOF
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
    // InternalSimplejava.g:1140:1: ruleAssignment returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1146:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) )
            // InternalSimplejava.g:1147:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            {
            // InternalSimplejava.g:1147:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            // InternalSimplejava.g:1148:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';'
            {
            // InternalSimplejava.g:1148:3: ( ( ruleQualifiedName ) )
            // InternalSimplejava.g:1149:4: ( ruleQualifiedName )
            {
            // InternalSimplejava.g:1149:4: ( ruleQualifiedName )
            // InternalSimplejava.g:1150:5: ruleQualifiedName
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
            		
            // InternalSimplejava.g:1168:3: ( (lv_expression_2_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1169:4: (lv_expression_2_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1169:4: (lv_expression_2_0= ruleGenericExpression )
            // InternalSimplejava.g:1170:5: lv_expression_2_0= ruleGenericExpression
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
    // InternalSimplejava.g:1195:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalSimplejava.g:1195:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalSimplejava.g:1196:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalSimplejava.g:1202:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_condition_1_0 = null;

        EObject lv_then_2_0 = null;

        EObject lv_else_4_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1208:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? ) )
            // InternalSimplejava.g:1209:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? )
            {
            // InternalSimplejava.g:1209:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? )
            // InternalSimplejava.g:1210:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
            		
            // InternalSimplejava.g:1214:3: ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) )
            // InternalSimplejava.g:1215:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            {
            // InternalSimplejava.g:1215:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            // InternalSimplejava.g:1216:5: lv_condition_1_0= ruleParanthesisOrBinaryExpression
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getConditionParanthesisOrBinaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
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

            // InternalSimplejava.g:1233:3: ( (lv_then_2_0= ruleMethodBlock ) )
            // InternalSimplejava.g:1234:4: (lv_then_2_0= ruleMethodBlock )
            {
            // InternalSimplejava.g:1234:4: (lv_then_2_0= ruleMethodBlock )
            // InternalSimplejava.g:1235:5: lv_then_2_0= ruleMethodBlock
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getThenMethodBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_20);
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

            // InternalSimplejava.g:1252:3: (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSimplejava.g:1253:4: otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) )
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_18); 

                    				newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getElseKeyword_3_0());
                    			
                    // InternalSimplejava.g:1257:4: ( (lv_else_4_0= ruleMethodBlock ) )
                    // InternalSimplejava.g:1258:5: (lv_else_4_0= ruleMethodBlock )
                    {
                    // InternalSimplejava.g:1258:5: (lv_else_4_0= ruleMethodBlock )
                    // InternalSimplejava.g:1259:6: lv_else_4_0= ruleMethodBlock
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
    // InternalSimplejava.g:1281:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalSimplejava.g:1281:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalSimplejava.g:1282:2: iv_ruleForStatement= ruleForStatement EOF
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
    // InternalSimplejava.g:1288:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) ) ;
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
            // InternalSimplejava.g:1294:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1295:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1295:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) )
            // InternalSimplejava.g:1296:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1304:3: ( (lv_init_2_0= ruleSimpleStatement ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||(LA17_0>=19 && LA17_0<=27)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSimplejava.g:1305:4: (lv_init_2_0= ruleSimpleStatement )
                    {
                    // InternalSimplejava.g:1305:4: (lv_init_2_0= ruleSimpleStatement )
                    // InternalSimplejava.g:1306:5: lv_init_2_0= ruleSimpleStatement
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
            		
            // InternalSimplejava.g:1327:3: ( (lv_condition_4_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1328:4: (lv_condition_4_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1328:4: (lv_condition_4_0= ruleGenericExpression )
            // InternalSimplejava.g:1329:5: lv_condition_4_0= ruleGenericExpression
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

            otherlv_5=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getForStatementAccess().getSemicolonKeyword_5());
            		
            // InternalSimplejava.g:1350:3: ( (lv_continuation_6_0= ruleSimpleStatement ) )
            // InternalSimplejava.g:1351:4: (lv_continuation_6_0= ruleSimpleStatement )
            {
            // InternalSimplejava.g:1351:4: (lv_continuation_6_0= ruleSimpleStatement )
            // InternalSimplejava.g:1352:5: lv_continuation_6_0= ruleSimpleStatement
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getContinuationSimpleStatementParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_22);
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

            otherlv_7=(Token)match(input,31,FOLLOW_23); 

            			newLeafNode(otherlv_7, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());
            		
            // InternalSimplejava.g:1373:3: ( (lv_body_8_0= ruleStatement ) )
            // InternalSimplejava.g:1374:4: (lv_body_8_0= ruleStatement )
            {
            // InternalSimplejava.g:1374:4: (lv_body_8_0= ruleStatement )
            // InternalSimplejava.g:1375:5: lv_body_8_0= ruleStatement
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
    // InternalSimplejava.g:1396:1: entryRuleForInStatement returns [EObject current=null] : iv_ruleForInStatement= ruleForInStatement EOF ;
    public final EObject entryRuleForInStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForInStatement = null;


        try {
            // InternalSimplejava.g:1396:55: (iv_ruleForInStatement= ruleForInStatement EOF )
            // InternalSimplejava.g:1397:2: iv_ruleForInStatement= ruleForInStatement EOF
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
    // InternalSimplejava.g:1403:1: ruleForInStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) ) ;
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
            // InternalSimplejava.g:1409:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1410:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1410:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) )
            // InternalSimplejava.g:1411:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleSimpleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getForInStatementAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getForInStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1419:3: ( (lv_subparameter_2_0= ruleSimpleParameter ) )
            // InternalSimplejava.g:1420:4: (lv_subparameter_2_0= ruleSimpleParameter )
            {
            // InternalSimplejava.g:1420:4: (lv_subparameter_2_0= ruleSimpleParameter )
            // InternalSimplejava.g:1421:5: lv_subparameter_2_0= ruleSimpleParameter
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getSubparameterSimpleParameterParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_24);
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

            otherlv_3=(Token)match(input,36,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getForInStatementAccess().getColonKeyword_3());
            		
            // InternalSimplejava.g:1442:3: ( (lv_expression_4_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1443:4: (lv_expression_4_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1443:4: (lv_expression_4_0= ruleGenericExpression )
            // InternalSimplejava.g:1444:5: lv_expression_4_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getExpressionGenericExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_22);
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

            otherlv_5=(Token)match(input,31,FOLLOW_23); 

            			newLeafNode(otherlv_5, grammarAccess.getForInStatementAccess().getRightParenthesisKeyword_5());
            		
            // InternalSimplejava.g:1465:3: ( (lv_body_6_0= ruleStatement ) )
            // InternalSimplejava.g:1466:4: (lv_body_6_0= ruleStatement )
            {
            // InternalSimplejava.g:1466:4: (lv_body_6_0= ruleStatement )
            // InternalSimplejava.g:1467:5: lv_body_6_0= ruleStatement
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
    // InternalSimplejava.g:1488:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalSimplejava.g:1488:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalSimplejava.g:1489:2: iv_ruleWhileStatement= ruleWhileStatement EOF
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
    // InternalSimplejava.g:1495:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;

        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1501:2: ( (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) ) )
            // InternalSimplejava.g:1502:2: (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) )
            {
            // InternalSimplejava.g:1502:2: (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) )
            // InternalSimplejava.g:1503:3: otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
            		
            // InternalSimplejava.g:1507:3: ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) )
            // InternalSimplejava.g:1508:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            {
            // InternalSimplejava.g:1508:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            // InternalSimplejava.g:1509:5: lv_condition_1_0= ruleParanthesisOrBinaryExpression
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionParanthesisOrBinaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_23);
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

            // InternalSimplejava.g:1526:3: ( (lv_body_2_0= ruleStatement ) )
            // InternalSimplejava.g:1527:4: (lv_body_2_0= ruleStatement )
            {
            // InternalSimplejava.g:1527:4: (lv_body_2_0= ruleStatement )
            // InternalSimplejava.g:1528:5: lv_body_2_0= ruleStatement
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
    // InternalSimplejava.g:1549:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // InternalSimplejava.g:1549:56: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // InternalSimplejava.g:1550:2: iv_ruleReturnStatement= ruleReturnStatement EOF
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
    // InternalSimplejava.g:1556:1: ruleReturnStatement returns [EObject current=null] : (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1562:2: ( (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' ) )
            // InternalSimplejava.g:1563:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' )
            {
            // InternalSimplejava.g:1563:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' )
            // InternalSimplejava.g:1564:3: otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getReturnStatementAccess().getReturnKeyword_0());
            		
            // InternalSimplejava.g:1568:3: ( (lv_expression_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:1569:4: (lv_expression_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:1569:4: (lv_expression_1_0= ruleGenericExpression )
            // InternalSimplejava.g:1570:5: lv_expression_1_0= ruleGenericExpression
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
    // InternalSimplejava.g:1595:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSimplejava.g:1595:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSimplejava.g:1596:2: iv_ruleMethodCall= ruleMethodCall EOF
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
    // InternalSimplejava.g:1602:1: ruleMethodCall returns [EObject current=null] : ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' ) ;
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
            // InternalSimplejava.g:1608:2: ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' ) )
            // InternalSimplejava.g:1609:2: ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' )
            {
            // InternalSimplejava.g:1609:2: ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' )
            // InternalSimplejava.g:1610:3: ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')'
            {
            // InternalSimplejava.g:1610:3: ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) )
            // InternalSimplejava.g:1611:4: ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) )
            {
            // InternalSimplejava.g:1611:4: ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==40) ) {
                    alt19=1;
                }
            }
            else if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSimplejava.g:1612:5: ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.'
                    {
                    // InternalSimplejava.g:1612:5: ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ID) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==39) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalSimplejava.g:1613:6: ( ( ruleQualifiedName ) )
                            {
                            // InternalSimplejava.g:1613:6: ( ( ruleQualifiedName ) )
                            // InternalSimplejava.g:1614:7: ( ruleQualifiedName )
                            {
                            // InternalSimplejava.g:1614:7: ( ruleQualifiedName )
                            // InternalSimplejava.g:1615:8: ruleQualifiedName
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getMethodCallAccess().getObjectParameterCrossReference_0_0_0_0_0());
                            							
                            pushFollow(FOLLOW_25);
                            ruleQualifiedName();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:1630:6: ( (lv_thisObject_1_0= 'this' ) )
                            {
                            // InternalSimplejava.g:1630:6: ( (lv_thisObject_1_0= 'this' ) )
                            // InternalSimplejava.g:1631:7: (lv_thisObject_1_0= 'this' )
                            {
                            // InternalSimplejava.g:1631:7: (lv_thisObject_1_0= 'this' )
                            // InternalSimplejava.g:1632:8: lv_thisObject_1_0= 'this'
                            {
                            lv_thisObject_1_0=(Token)match(input,39,FOLLOW_25); 

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

                    otherlv_2=(Token)match(input,40,FOLLOW_26); 

                    					newLeafNode(otherlv_2, grammarAccess.getMethodCallAccess().getFullStopKeyword_0_0_1());
                    				

                    }
                    break;

            }

            // InternalSimplejava.g:1650:4: ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt21=1;
                }
                break;
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt21=2;
                }
                break;
            case 47:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalSimplejava.g:1651:5: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalSimplejava.g:1651:5: ( (otherlv_3= RULE_ID ) )
                    // InternalSimplejava.g:1652:6: (otherlv_3= RULE_ID )
                    {
                    // InternalSimplejava.g:1652:6: (otherlv_3= RULE_ID )
                    // InternalSimplejava.g:1653:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMethodCallRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_15); 

                    							newLeafNode(otherlv_3, grammarAccess.getMethodCallAccess().getMethodMethodCrossReference_0_1_0_0());
                    						

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimplejava.g:1665:5: ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) )
                    {
                    // InternalSimplejava.g:1665:5: ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) ) )
                    // InternalSimplejava.g:1666:6: ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) )
                    {
                    // InternalSimplejava.g:1666:6: ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' ) )
                    // InternalSimplejava.g:1667:7: (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' )
                    {
                    // InternalSimplejava.g:1667:7: (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' | lv_methodName_4_3= 'add' | lv_methodName_4_4= 'remove' | lv_methodName_4_5= 'clear' | lv_methodName_4_6= 'logp' )
                    int alt20=6;
                    switch ( input.LA(1) ) {
                    case 41:
                        {
                        alt20=1;
                        }
                        break;
                    case 42:
                        {
                        alt20=2;
                        }
                        break;
                    case 43:
                        {
                        alt20=3;
                        }
                        break;
                    case 44:
                        {
                        alt20=4;
                        }
                        break;
                    case 45:
                        {
                        alt20=5;
                        }
                        break;
                    case 46:
                        {
                        alt20=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }

                    switch (alt20) {
                        case 1 :
                            // InternalSimplejava.g:1668:8: lv_methodName_4_1= 'equals'
                            {
                            lv_methodName_4_1=(Token)match(input,41,FOLLOW_15); 

                            								newLeafNode(lv_methodName_4_1, grammarAccess.getMethodCallAccess().getMethodNameEqualsKeyword_0_1_1_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_1, null);
                            							

                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:1679:8: lv_methodName_4_2= 'hashCode'
                            {
                            lv_methodName_4_2=(Token)match(input,42,FOLLOW_15); 

                            								newLeafNode(lv_methodName_4_2, grammarAccess.getMethodCallAccess().getMethodNameHashCodeKeyword_0_1_1_0_1());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_2, null);
                            							

                            }
                            break;
                        case 3 :
                            // InternalSimplejava.g:1690:8: lv_methodName_4_3= 'add'
                            {
                            lv_methodName_4_3=(Token)match(input,43,FOLLOW_15); 

                            								newLeafNode(lv_methodName_4_3, grammarAccess.getMethodCallAccess().getMethodNameAddKeyword_0_1_1_0_2());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_3, null);
                            							

                            }
                            break;
                        case 4 :
                            // InternalSimplejava.g:1701:8: lv_methodName_4_4= 'remove'
                            {
                            lv_methodName_4_4=(Token)match(input,44,FOLLOW_15); 

                            								newLeafNode(lv_methodName_4_4, grammarAccess.getMethodCallAccess().getMethodNameRemoveKeyword_0_1_1_0_3());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_4, null);
                            							

                            }
                            break;
                        case 5 :
                            // InternalSimplejava.g:1712:8: lv_methodName_4_5= 'clear'
                            {
                            lv_methodName_4_5=(Token)match(input,45,FOLLOW_15); 

                            								newLeafNode(lv_methodName_4_5, grammarAccess.getMethodCallAccess().getMethodNameClearKeyword_0_1_1_0_4());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            								setWithLastConsumed(current, "methodName", lv_methodName_4_5, null);
                            							

                            }
                            break;
                        case 6 :
                            // InternalSimplejava.g:1723:8: lv_methodName_4_6= 'logp'
                            {
                            lv_methodName_4_6=(Token)match(input,46,FOLLOW_15); 

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
                    // InternalSimplejava.g:1737:5: ( (lv_methodName_5_0= 'System.out.println' ) )
                    {
                    // InternalSimplejava.g:1737:5: ( (lv_methodName_5_0= 'System.out.println' ) )
                    // InternalSimplejava.g:1738:6: (lv_methodName_5_0= 'System.out.println' )
                    {
                    // InternalSimplejava.g:1738:6: (lv_methodName_5_0= 'System.out.println' )
                    // InternalSimplejava.g:1739:7: lv_methodName_5_0= 'System.out.println'
                    {
                    lv_methodName_5_0=(Token)match(input,47,FOLLOW_15); 

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

            otherlv_6=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_6, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimplejava.g:1757:3: ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||LA23_0==29||LA23_0==39||(LA23_0>=41 && LA23_0<=52)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSimplejava.g:1758:4: ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )*
                    {
                    // InternalSimplejava.g:1758:4: ( (lv_parameter_7_0= ruleGenericExpression ) )
                    // InternalSimplejava.g:1759:5: (lv_parameter_7_0= ruleGenericExpression )
                    {
                    // InternalSimplejava.g:1759:5: (lv_parameter_7_0= ruleGenericExpression )
                    // InternalSimplejava.g:1760:6: lv_parameter_7_0= ruleGenericExpression
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getParameterGenericExpressionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_17);
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

                    // InternalSimplejava.g:1777:4: (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==30) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalSimplejava.g:1778:5: otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) )
                    	    {
                    	    otherlv_8=(Token)match(input,30,FOLLOW_11); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getMethodCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalSimplejava.g:1782:5: ( (lv_parameter_9_0= ruleGenericExpression ) )
                    	    // InternalSimplejava.g:1783:6: (lv_parameter_9_0= ruleGenericExpression )
                    	    {
                    	    // InternalSimplejava.g:1783:6: (lv_parameter_9_0= ruleGenericExpression )
                    	    // InternalSimplejava.g:1784:7: lv_parameter_9_0= ruleGenericExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodCallAccess().getParameterGenericExpressionParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_17);
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
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,31,FOLLOW_2); 

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
    // InternalSimplejava.g:1811:1: entryRuleConstructorCall returns [EObject current=null] : iv_ruleConstructorCall= ruleConstructorCall EOF ;
    public final EObject entryRuleConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorCall = null;


        try {
            // InternalSimplejava.g:1811:56: (iv_ruleConstructorCall= ruleConstructorCall EOF )
            // InternalSimplejava.g:1812:2: iv_ruleConstructorCall= ruleConstructorCall EOF
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
    // InternalSimplejava.g:1818:1: ruleConstructorCall returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // InternalSimplejava.g:1824:2: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalSimplejava.g:1825:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalSimplejava.g:1825:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')' )
            // InternalSimplejava.g:1826:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )? otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getConstructorCallAccess().getNewKeyword_0());
            		
            // InternalSimplejava.g:1830:3: ( (lv_type_1_0= ruleType ) )
            // InternalSimplejava.g:1831:4: (lv_type_1_0= ruleType )
            {
            // InternalSimplejava.g:1831:4: (lv_type_1_0= ruleType )
            // InternalSimplejava.g:1832:5: lv_type_1_0= ruleType
            {

            					newCompositeNode(grammarAccess.getConstructorCallAccess().getTypeTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_15);
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

            otherlv_2=(Token)match(input,29,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getConstructorCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSimplejava.g:1853:3: ( ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_INT && LA25_0<=RULE_STRING)||(LA25_0>=49 && LA25_0<=51)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalSimplejava.g:1854:4: ( (lv_parameter_3_0= ruleConstantExpression ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )*
                    {
                    // InternalSimplejava.g:1854:4: ( (lv_parameter_3_0= ruleConstantExpression ) )
                    // InternalSimplejava.g:1855:5: (lv_parameter_3_0= ruleConstantExpression )
                    {
                    // InternalSimplejava.g:1855:5: (lv_parameter_3_0= ruleConstantExpression )
                    // InternalSimplejava.g:1856:6: lv_parameter_3_0= ruleConstantExpression
                    {

                    						newCompositeNode(grammarAccess.getConstructorCallAccess().getParameterConstantExpressionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_17);
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

                    // InternalSimplejava.g:1873:4: (otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==30) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalSimplejava.g:1874:5: otherlv_4= ',' ( (lv_parameter_5_0= ruleConstantExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,30,FOLLOW_29); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getConstructorCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSimplejava.g:1878:5: ( (lv_parameter_5_0= ruleConstantExpression ) )
                    	    // InternalSimplejava.g:1879:6: (lv_parameter_5_0= ruleConstantExpression )
                    	    {
                    	    // InternalSimplejava.g:1879:6: (lv_parameter_5_0= ruleConstantExpression )
                    	    // InternalSimplejava.g:1880:7: lv_parameter_5_0= ruleConstantExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getConstructorCallAccess().getParameterConstantExpressionParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_17);
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
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,31,FOLLOW_2); 

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
    // InternalSimplejava.g:1907:1: entryRuleGenericExpression returns [EObject current=null] : iv_ruleGenericExpression= ruleGenericExpression EOF ;
    public final EObject entryRuleGenericExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericExpression = null;


        try {
            // InternalSimplejava.g:1907:58: (iv_ruleGenericExpression= ruleGenericExpression EOF )
            // InternalSimplejava.g:1908:2: iv_ruleGenericExpression= ruleGenericExpression EOF
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
    // InternalSimplejava.g:1914:1: ruleGenericExpression returns [EObject current=null] : (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall ) ;
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
            // InternalSimplejava.g:1920:2: ( (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall ) )
            // InternalSimplejava.g:1921:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall )
            {
            // InternalSimplejava.g:1921:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall )
            int alt26=6;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalSimplejava.g:1922:3: this_VariableExpression_0= ruleVariableExpression
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
                    // InternalSimplejava.g:1931:3: this_MethodCall_1= ruleMethodCall
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
                    // InternalSimplejava.g:1940:3: this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression
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
                    // InternalSimplejava.g:1949:3: this_UnaryExpression_3= ruleUnaryExpression
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
                    // InternalSimplejava.g:1958:3: this_ConstantExpression_4= ruleConstantExpression
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
                    // InternalSimplejava.g:1967:3: this_ConstructorCall_5= ruleConstructorCall
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
    // InternalSimplejava.g:1979:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalSimplejava.g:1979:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalSimplejava.g:1980:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalSimplejava.g:1986:1: ruleConstantExpression returns [EObject current=null] : (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerExpression_0 = null;

        EObject this_StringExpression_1 = null;

        EObject this_BooleanExpression_2 = null;

        EObject this_NullExpression_3 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:1992:2: ( (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression ) )
            // InternalSimplejava.g:1993:2: (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression )
            {
            // InternalSimplejava.g:1993:2: (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression )
            int alt27=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt27=1;
                }
                break;
            case RULE_STRING:
                {
                alt27=2;
                }
                break;
            case 50:
            case 51:
                {
                alt27=3;
                }
                break;
            case 49:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalSimplejava.g:1994:3: this_IntegerExpression_0= ruleIntegerExpression
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
                    // InternalSimplejava.g:2003:3: this_StringExpression_1= ruleStringExpression
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
                    // InternalSimplejava.g:2012:3: this_BooleanExpression_2= ruleBooleanExpression
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
                    // InternalSimplejava.g:2021:3: this_NullExpression_3= ruleNullExpression
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
    // InternalSimplejava.g:2033:1: entryRuleNullExpression returns [EObject current=null] : iv_ruleNullExpression= ruleNullExpression EOF ;
    public final EObject entryRuleNullExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExpression = null;


        try {
            // InternalSimplejava.g:2033:55: (iv_ruleNullExpression= ruleNullExpression EOF )
            // InternalSimplejava.g:2034:2: iv_ruleNullExpression= ruleNullExpression EOF
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
    // InternalSimplejava.g:2040:1: ruleNullExpression returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2046:2: ( ( () otherlv_1= 'null' ) )
            // InternalSimplejava.g:2047:2: ( () otherlv_1= 'null' )
            {
            // InternalSimplejava.g:2047:2: ( () otherlv_1= 'null' )
            // InternalSimplejava.g:2048:3: () otherlv_1= 'null'
            {
            // InternalSimplejava.g:2048:3: ()
            // InternalSimplejava.g:2049:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNullExpressionAccess().getNullExpressionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,49,FOLLOW_2); 

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
    // InternalSimplejava.g:2063:1: entryRuleIntegerExpression returns [EObject current=null] : iv_ruleIntegerExpression= ruleIntegerExpression EOF ;
    public final EObject entryRuleIntegerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerExpression = null;


        try {
            // InternalSimplejava.g:2063:58: (iv_ruleIntegerExpression= ruleIntegerExpression EOF )
            // InternalSimplejava.g:2064:2: iv_ruleIntegerExpression= ruleIntegerExpression EOF
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
    // InternalSimplejava.g:2070:1: ruleIntegerExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2076:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalSimplejava.g:2077:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalSimplejava.g:2077:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalSimplejava.g:2078:3: (lv_value_0_0= RULE_INT )
            {
            // InternalSimplejava.g:2078:3: (lv_value_0_0= RULE_INT )
            // InternalSimplejava.g:2079:4: lv_value_0_0= RULE_INT
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
    // InternalSimplejava.g:2098:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalSimplejava.g:2098:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalSimplejava.g:2099:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
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
    // InternalSimplejava.g:2105:1: ruleBooleanExpression returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2111:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalSimplejava.g:2112:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalSimplejava.g:2112:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalSimplejava.g:2113:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalSimplejava.g:2113:3: ()
            // InternalSimplejava.g:2114:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanExpressionAccess().getBooleanExpressionAction_0(),
            					current);
            			

            }

            // InternalSimplejava.g:2120:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==50) ) {
                alt28=1;
            }
            else if ( (LA28_0==51) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalSimplejava.g:2121:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalSimplejava.g:2121:4: ( (lv_value_1_0= 'true' ) )
                    // InternalSimplejava.g:2122:5: (lv_value_1_0= 'true' )
                    {
                    // InternalSimplejava.g:2122:5: (lv_value_1_0= 'true' )
                    // InternalSimplejava.g:2123:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,50,FOLLOW_2); 

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
                    // InternalSimplejava.g:2136:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_2); 

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
    // InternalSimplejava.g:2145:1: entryRuleStringExpression returns [EObject current=null] : iv_ruleStringExpression= ruleStringExpression EOF ;
    public final EObject entryRuleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExpression = null;


        try {
            // InternalSimplejava.g:2145:57: (iv_ruleStringExpression= ruleStringExpression EOF )
            // InternalSimplejava.g:2146:2: iv_ruleStringExpression= ruleStringExpression EOF
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
    // InternalSimplejava.g:2152:1: ruleStringExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2158:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalSimplejava.g:2159:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalSimplejava.g:2159:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalSimplejava.g:2160:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalSimplejava.g:2160:3: (lv_value_0_0= RULE_STRING )
            // InternalSimplejava.g:2161:4: lv_value_0_0= RULE_STRING
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
    // InternalSimplejava.g:2180:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalSimplejava.g:2180:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalSimplejava.g:2181:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalSimplejava.g:2187:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        EObject lv_source_1_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:2193:2: ( ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) ) )
            // InternalSimplejava.g:2194:2: ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) )
            {
            // InternalSimplejava.g:2194:2: ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) )
            // InternalSimplejava.g:2195:3: ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) )
            {
            // InternalSimplejava.g:2195:3: ( (lv_type_0_0= '!' ) )
            // InternalSimplejava.g:2196:4: (lv_type_0_0= '!' )
            {
            // InternalSimplejava.g:2196:4: (lv_type_0_0= '!' )
            // InternalSimplejava.g:2197:5: lv_type_0_0= '!'
            {
            lv_type_0_0=(Token)match(input,52,FOLLOW_11); 

            					newLeafNode(lv_type_0_0, grammarAccess.getUnaryExpressionAccess().getTypeExclamationMarkKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnaryExpressionRule());
            					}
            					setWithLastConsumed(current, "type", lv_type_0_0, "!");
            				

            }


            }

            // InternalSimplejava.g:2209:3: ( (lv_source_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:2210:4: (lv_source_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:2210:4: (lv_source_1_0= ruleGenericExpression )
            // InternalSimplejava.g:2211:5: lv_source_1_0= ruleGenericExpression
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
    // InternalSimplejava.g:2232:1: entryRuleVariableExpression returns [EObject current=null] : iv_ruleVariableExpression= ruleVariableExpression EOF ;
    public final EObject entryRuleVariableExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableExpression = null;


        try {
            // InternalSimplejava.g:2232:59: (iv_ruleVariableExpression= ruleVariableExpression EOF )
            // InternalSimplejava.g:2233:2: iv_ruleVariableExpression= ruleVariableExpression EOF
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
    // InternalSimplejava.g:2239:1: ruleVariableExpression returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariableExpression() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalSimplejava.g:2245:2: ( ( ( ruleQualifiedName ) ) )
            // InternalSimplejava.g:2246:2: ( ( ruleQualifiedName ) )
            {
            // InternalSimplejava.g:2246:2: ( ( ruleQualifiedName ) )
            // InternalSimplejava.g:2247:3: ( ruleQualifiedName )
            {
            // InternalSimplejava.g:2247:3: ( ruleQualifiedName )
            // InternalSimplejava.g:2248:4: ruleQualifiedName
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
    // InternalSimplejava.g:2265:1: entryRuleParanthesisOrBinaryExpression returns [EObject current=null] : iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF ;
    public final EObject entryRuleParanthesisOrBinaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesisOrBinaryExpression = null;


        try {
            // InternalSimplejava.g:2265:70: (iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF )
            // InternalSimplejava.g:2266:2: iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF
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
    // InternalSimplejava.g:2272:1: ruleParanthesisOrBinaryExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' ) ;
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
            // InternalSimplejava.g:2278:2: ( (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' ) )
            // InternalSimplejava.g:2279:2: (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' )
            {
            // InternalSimplejava.g:2279:2: (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' )
            // InternalSimplejava.g:2280:3: otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesisOrBinaryExpressionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalSimplejava.g:2284:3: ( (lv_source_1_0= ruleGenericExpression ) )
            // InternalSimplejava.g:2285:4: (lv_source_1_0= ruleGenericExpression )
            {
            // InternalSimplejava.g:2285:4: (lv_source_1_0= ruleGenericExpression )
            // InternalSimplejava.g:2286:5: lv_source_1_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionAccess().getSourceGenericExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_30);
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

            // InternalSimplejava.g:2303:3: ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=53 && LA30_0<=65)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalSimplejava.g:2304:4: ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) )
                    {
                    // InternalSimplejava.g:2304:4: ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) )
                    // InternalSimplejava.g:2305:5: ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) )
                    {
                    // InternalSimplejava.g:2305:5: ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) )
                    // InternalSimplejava.g:2306:6: (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' )
                    {
                    // InternalSimplejava.g:2306:6: (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' )
                    int alt29=13;
                    switch ( input.LA(1) ) {
                    case 53:
                        {
                        alt29=1;
                        }
                        break;
                    case 54:
                        {
                        alt29=2;
                        }
                        break;
                    case 55:
                        {
                        alt29=3;
                        }
                        break;
                    case 56:
                        {
                        alt29=4;
                        }
                        break;
                    case 57:
                        {
                        alt29=5;
                        }
                        break;
                    case 58:
                        {
                        alt29=6;
                        }
                        break;
                    case 59:
                        {
                        alt29=7;
                        }
                        break;
                    case 60:
                        {
                        alt29=8;
                        }
                        break;
                    case 61:
                        {
                        alt29=9;
                        }
                        break;
                    case 62:
                        {
                        alt29=10;
                        }
                        break;
                    case 63:
                        {
                        alt29=11;
                        }
                        break;
                    case 64:
                        {
                        alt29=12;
                        }
                        break;
                    case 65:
                        {
                        alt29=13;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }

                    switch (alt29) {
                        case 1 :
                            // InternalSimplejava.g:2307:7: lv_type_2_1= '||'
                            {
                            lv_type_2_1=(Token)match(input,53,FOLLOW_11); 

                            							newLeafNode(lv_type_2_1, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeVerticalLineVerticalLineKeyword_2_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSimplejava.g:2318:7: lv_type_2_2= '&&'
                            {
                            lv_type_2_2=(Token)match(input,54,FOLLOW_11); 

                            							newLeafNode(lv_type_2_2, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAmpersandAmpersandKeyword_2_0_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSimplejava.g:2329:7: lv_type_2_3= '&'
                            {
                            lv_type_2_3=(Token)match(input,55,FOLLOW_11); 

                            							newLeafNode(lv_type_2_3, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAmpersandKeyword_2_0_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSimplejava.g:2340:7: lv_type_2_4= '+'
                            {
                            lv_type_2_4=(Token)match(input,56,FOLLOW_11); 

                            							newLeafNode(lv_type_2_4, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypePlusSignKeyword_2_0_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSimplejava.g:2351:7: lv_type_2_5= '-'
                            {
                            lv_type_2_5=(Token)match(input,57,FOLLOW_11); 

                            							newLeafNode(lv_type_2_5, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeHyphenMinusKeyword_2_0_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalSimplejava.g:2362:7: lv_type_2_6= '*'
                            {
                            lv_type_2_6=(Token)match(input,58,FOLLOW_11); 

                            							newLeafNode(lv_type_2_6, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAsteriskKeyword_2_0_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_6, null);
                            						

                            }
                            break;
                        case 7 :
                            // InternalSimplejava.g:2373:7: lv_type_2_7= '/'
                            {
                            lv_type_2_7=(Token)match(input,59,FOLLOW_11); 

                            							newLeafNode(lv_type_2_7, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeSolidusKeyword_2_0_0_6());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_7, null);
                            						

                            }
                            break;
                        case 8 :
                            // InternalSimplejava.g:2384:7: lv_type_2_8= '=='
                            {
                            lv_type_2_8=(Token)match(input,60,FOLLOW_11); 

                            							newLeafNode(lv_type_2_8, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeEqualsSignEqualsSignKeyword_2_0_0_7());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_8, null);
                            						

                            }
                            break;
                        case 9 :
                            // InternalSimplejava.g:2395:7: lv_type_2_9= '!='
                            {
                            lv_type_2_9=(Token)match(input,61,FOLLOW_11); 

                            							newLeafNode(lv_type_2_9, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeExclamationMarkEqualsSignKeyword_2_0_0_8());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_9, null);
                            						

                            }
                            break;
                        case 10 :
                            // InternalSimplejava.g:2406:7: lv_type_2_10= '<'
                            {
                            lv_type_2_10=(Token)match(input,62,FOLLOW_11); 

                            							newLeafNode(lv_type_2_10, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeLessThanSignKeyword_2_0_0_9());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_10, null);
                            						

                            }
                            break;
                        case 11 :
                            // InternalSimplejava.g:2417:7: lv_type_2_11= '<='
                            {
                            lv_type_2_11=(Token)match(input,63,FOLLOW_11); 

                            							newLeafNode(lv_type_2_11, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeLessThanSignEqualsSignKeyword_2_0_0_10());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_11, null);
                            						

                            }
                            break;
                        case 12 :
                            // InternalSimplejava.g:2428:7: lv_type_2_12= '>'
                            {
                            lv_type_2_12=(Token)match(input,64,FOLLOW_11); 

                            							newLeafNode(lv_type_2_12, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeGreaterThanSignKeyword_2_0_0_11());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_12, null);
                            						

                            }
                            break;
                        case 13 :
                            // InternalSimplejava.g:2439:7: lv_type_2_13= '>='
                            {
                            lv_type_2_13=(Token)match(input,65,FOLLOW_11); 

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

                    // InternalSimplejava.g:2452:4: ( (lv_argument_3_0= ruleGenericExpression ) )
                    // InternalSimplejava.g:2453:5: (lv_argument_3_0= ruleGenericExpression )
                    {
                    // InternalSimplejava.g:2453:5: (lv_argument_3_0= ruleGenericExpression )
                    // InternalSimplejava.g:2454:6: lv_argument_3_0= ruleGenericExpression
                    {

                    						newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionAccess().getArgumentGenericExpressionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_22);
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

            otherlv_4=(Token)match(input,31,FOLLOW_2); 

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
    // InternalSimplejava.g:2480:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalSimplejava.g:2480:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalSimplejava.g:2481:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
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
    // InternalSimplejava.g:2487:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalSimplejava.g:2493:2: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalSimplejava.g:2494:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalSimplejava.g:2494:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalSimplejava.g:2495:3: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {

            			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
            		
            pushFollow(FOLLOW_31);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            			current.merge(this_QualifiedName_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSimplejava.g:2505:3: (kw= '.*' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==66) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalSimplejava.g:2506:4: kw= '.*'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

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
    // InternalSimplejava.g:2516:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSimplejava.g:2516:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSimplejava.g:2517:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalSimplejava.g:2523:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalSimplejava.g:2529:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSimplejava.g:2530:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSimplejava.g:2530:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSimplejava.g:2531:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalSimplejava.g:2538:3: (kw= '.' this_ID_2= RULE_ID )*
            loop32:
            do {
                int alt32=2;
                alt32 = dfa32.predict(input);
                switch (alt32) {
            	case 1 :
            	    // InternalSimplejava.g:2539:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,40,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_32); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop32;
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
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\13\uffff\1\16\4\uffff";
    static final String dfa_3s = "\13\4\1\14\1\4\2\uffff\1\4";
    static final String dfa_4s = "\1\33\11\4\1\50\1\22\1\4\2\uffff\1\50";
    static final String dfa_5s = "\15\uffff\1\2\1\1\1\uffff";
    static final String dfa_6s = "\20\uffff}>";
    static final String[] dfa_7s = {
            "\1\12\16\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13\43\uffff\1\14",
            "\1\16\5\uffff\1\15",
            "\1\17",
            "",
            "",
            "\1\13\43\uffff\1\14"
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
    static final String dfa_10s = "\1\33\1\uffff\1\50\1\4\1\uffff\1\50";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_12s = "\6\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\16\uffff\11\1",
            "",
            "\1\1\15\uffff\1\4\25\uffff\1\3",
            "\1\5",
            "",
            "\1\1\15\uffff\1\4\25\uffff\1\3"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "873:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )";
        }
    }
    static final String dfa_14s = "\34\uffff";
    static final String dfa_15s = "\1\4\2\uffff\1\4\1\uffff\1\35\3\uffff\1\4\1\uffff\14\4\1\uffff\1\22\1\4\1\uffff\1\4";
    static final String dfa_16s = "\1\57\2\uffff\1\50\1\uffff\1\35\3\uffff\1\57\1\uffff\1\33\1\50\11\4\1\50\1\uffff\1\44\1\4\1\uffff\1\50";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\uffff\1\7\1\10\1\11\1\uffff\1\3\14\uffff\1\5\2\uffff\1\6\1\uffff";
    static final String dfa_18s = "\34\uffff}>";
    static final String[] dfa_19s = {
            "\1\3\13\uffff\1\1\2\uffff\11\2\4\uffff\1\1\1\4\1\uffff\1\5\1\uffff\1\6\1\7\1\10\1\uffff\7\10",
            "",
            "",
            "\1\2\15\uffff\1\12\12\uffff\1\10\12\uffff\1\11",
            "",
            "\1\13",
            "",
            "",
            "",
            "\1\14\44\uffff\7\10",
            "",
            "\1\26\7\uffff\1\27\6\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25",
            "\1\2\15\uffff\1\12\12\uffff\1\10\12\uffff\1\11",
            "\1\30",
            "\1\30",
            "\1\30",
            "\1\30",
            "\1\30",
            "\1\30",
            "\1\30",
            "\1\30",
            "\1\30",
            "\1\30\15\uffff\1\27\25\uffff\1\31",
            "",
            "\1\27\21\uffff\1\32",
            "\1\33",
            "",
            "\1\30\15\uffff\1\27\25\uffff\1\31"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "909:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | (this_MethodCall_8= ruleMethodCall otherlv_9= ';' ) )";
        }
    }
    static final String dfa_20s = "\12\uffff";
    static final String dfa_21s = "\1\uffff\1\10\7\uffff\1\10";
    static final String dfa_22s = "\1\4\1\14\5\uffff\1\4\1\uffff\1\14";
    static final String dfa_23s = "\1\64\1\101\5\uffff\1\57\1\uffff\1\101";
    static final String dfa_24s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\uffff\1\1\1\uffff";
    static final String dfa_25s = "\12\uffff}>";
    static final String[] dfa_26s = {
            "\1\1\2\5\26\uffff\1\3\11\uffff\1\2\1\uffff\7\2\1\6\3\5\1\4",
            "\1\10\20\uffff\1\2\2\10\10\uffff\1\7\14\uffff\15\10",
            "",
            "",
            "",
            "",
            "",
            "\1\11\44\uffff\7\2",
            "",
            "\1\10\20\uffff\1\2\2\10\10\uffff\1\7\14\uffff\15\10"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "1921:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression | this_ConstructorCall_5= ruleConstructorCall )";
        }
    }
    static final String dfa_27s = "\26\uffff";
    static final String dfa_28s = "\1\1\2\uffff\1\4\22\uffff";
    static final String dfa_29s = "\1\4\1\uffff\2\4\1\uffff\1\4\5\36\1\uffff\2\4\1\uffff\1\4\5\36\1\4";
    static final String dfa_30s = "\1\102\1\uffff\1\57\1\102\1\uffff\1\64\5\37\1\uffff\1\50\1\64\1\uffff\1\57\5\37\1\50";
    static final String dfa_31s = "\1\uffff\1\2\2\uffff\1\1\6\uffff\1\1\2\uffff\1\1\7\uffff";
    static final String dfa_32s = "\26\uffff}>";
    static final String[] dfa_33s = {
            "\1\1\7\uffff\1\1\5\uffff\1\1\12\uffff\3\1\10\uffff\1\2\14\uffff\16\1",
            "",
            "\1\3\44\uffff\7\1",
            "\1\4\7\uffff\1\4\5\uffff\1\4\12\uffff\1\5\2\4\10\uffff\1\4\14\uffff\16\4",
            "",
            "\1\14\1\6\1\7\14\uffff\11\13\1\uffff\1\1\1\uffff\1\13\7\uffff\1\1\1\uffff\10\1\1\12\1\10\1\11\1\1",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "",
            "\1\16\30\uffff\3\1\10\uffff\1\17",
            "\1\1\1\20\1\21\26\uffff\1\1\11\uffff\1\1\1\uffff\10\1\1\24\1\22\1\23\1\1",
            "",
            "\1\25\44\uffff\7\1",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\15\1\16",
            "\1\16\30\uffff\3\1\10\uffff\1\17"
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "()* loopback of 2538:3: (kw= '.' this_ID_2= RULE_ID )*";
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
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x001FFE8020000070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000001FF80010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000FF80010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000008FF80010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000100010000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000FEEB0FFB0010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000000FF81010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000FEEB0FF90010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000FE0000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x001FFE80A0000070L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000E000080000060L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000E000000000060L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0xFFE0000080000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000010000000002L});

}