package at.ac.tuwien.big.simpleaspect.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.ac.tuwien.big.simpleaspect.services.SimpleAspectGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleAspectParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'aspect'", "'{'", "'}'", "'private'", "'/'", "';'", "'pointcut'", "'('", "','", "')'", "':'", "'!'", "'||'", "'&&'", "'call'", "'execution'", "'within'", "'handler'", "'public'", "'static'", "'*'", "'..'", "'before'", "'after'", "'around'", "'int'", "'double'", "'String'", "'boolean'", "'void'", "'pointcutblock'", "'='", "'if'", "'else'", "'for'", "'while'", "'return'", "'this'", "'.'", "'equals'", "'hashCode'", "'System.out.println'", "'null'", "'true'", "'false'", "'&'", "'+'", "'-'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='"
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
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
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


        public InternalSimpleAspectParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleAspectParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleAspectParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSimpleAspect.g"; }



     	private SimpleAspectGrammarAccess grammarAccess;

        public InternalSimpleAspectParser(TokenStream input, SimpleAspectGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Aspect";
       	}

       	@Override
       	protected SimpleAspectGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleAspect"
    // InternalSimpleAspect.g:64:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalSimpleAspect.g:64:47: (iv_ruleAspect= ruleAspect EOF )
            // InternalSimpleAspect.g:65:2: iv_ruleAspect= ruleAspect EOF
            {
             newCompositeNode(grammarAccess.getAspectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAspect=ruleAspect();

            state._fsp--;

             current =iv_ruleAspect; 
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
    // $ANTLR end "entryRuleAspect"


    // $ANTLR start "ruleAspect"
    // InternalSimpleAspect.g:71:1: ruleAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_attributes_3_0= ruleForeignAttribute ) ) | ( (lv_methods_4_0= ruleMethod ) ) | ( (lv_pointcuts_5_0= rulePointcut ) ) | ( (lv_advices_6_0= ruleAdvice ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_methods_4_0 = null;

        EObject lv_pointcuts_5_0 = null;

        EObject lv_advices_6_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:77:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_attributes_3_0= ruleForeignAttribute ) ) | ( (lv_methods_4_0= ruleMethod ) ) | ( (lv_pointcuts_5_0= rulePointcut ) ) | ( (lv_advices_6_0= ruleAdvice ) ) )* otherlv_7= '}' ) )
            // InternalSimpleAspect.g:78:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_attributes_3_0= ruleForeignAttribute ) ) | ( (lv_methods_4_0= ruleMethod ) ) | ( (lv_pointcuts_5_0= rulePointcut ) ) | ( (lv_advices_6_0= ruleAdvice ) ) )* otherlv_7= '}' )
            {
            // InternalSimpleAspect.g:78:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_attributes_3_0= ruleForeignAttribute ) ) | ( (lv_methods_4_0= ruleMethod ) ) | ( (lv_pointcuts_5_0= rulePointcut ) ) | ( (lv_advices_6_0= ruleAdvice ) ) )* otherlv_7= '}' )
            // InternalSimpleAspect.g:79:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_attributes_3_0= ruleForeignAttribute ) ) | ( (lv_methods_4_0= ruleMethod ) ) | ( (lv_pointcuts_5_0= rulePointcut ) ) | ( (lv_advices_6_0= ruleAdvice ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAspectAccess().getAspectKeyword_0());
            		
            // InternalSimpleAspect.g:83:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleAspect.g:84:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleAspect.g:84:4: (lv_name_1_0= RULE_ID )
            // InternalSimpleAspect.g:85:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSimpleAspect.g:105:3: ( ( (lv_attributes_3_0= ruleForeignAttribute ) ) | ( (lv_methods_4_0= ruleMethod ) ) | ( (lv_pointcuts_5_0= rulePointcut ) ) | ( (lv_advices_6_0= ruleAdvice ) ) )*
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    alt1=1;
                    }
                    break;
                case 29:
                    {
                    alt1=2;
                    }
                    break;
                case 17:
                    {
                    alt1=3;
                    }
                    break;
                case 33:
                case 34:
                case 35:
                    {
                    alt1=4;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // InternalSimpleAspect.g:106:4: ( (lv_attributes_3_0= ruleForeignAttribute ) )
            	    {
            	    // InternalSimpleAspect.g:106:4: ( (lv_attributes_3_0= ruleForeignAttribute ) )
            	    // InternalSimpleAspect.g:107:5: (lv_attributes_3_0= ruleForeignAttribute )
            	    {
            	    // InternalSimpleAspect.g:107:5: (lv_attributes_3_0= ruleForeignAttribute )
            	    // InternalSimpleAspect.g:108:6: lv_attributes_3_0= ruleForeignAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getAspectAccess().getAttributesForeignAttributeParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_attributes_3_0=ruleForeignAttribute();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"attributes",
            	    							lv_attributes_3_0,
            	    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.ForeignAttribute");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleAspect.g:126:4: ( (lv_methods_4_0= ruleMethod ) )
            	    {
            	    // InternalSimpleAspect.g:126:4: ( (lv_methods_4_0= ruleMethod ) )
            	    // InternalSimpleAspect.g:127:5: (lv_methods_4_0= ruleMethod )
            	    {
            	    // InternalSimpleAspect.g:127:5: (lv_methods_4_0= ruleMethod )
            	    // InternalSimpleAspect.g:128:6: lv_methods_4_0= ruleMethod
            	    {

            	    						newCompositeNode(grammarAccess.getAspectAccess().getMethodsMethodParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_methods_4_0=ruleMethod();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"methods",
            	    							lv_methods_4_0,
            	    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Method");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSimpleAspect.g:146:4: ( (lv_pointcuts_5_0= rulePointcut ) )
            	    {
            	    // InternalSimpleAspect.g:146:4: ( (lv_pointcuts_5_0= rulePointcut ) )
            	    // InternalSimpleAspect.g:147:5: (lv_pointcuts_5_0= rulePointcut )
            	    {
            	    // InternalSimpleAspect.g:147:5: (lv_pointcuts_5_0= rulePointcut )
            	    // InternalSimpleAspect.g:148:6: lv_pointcuts_5_0= rulePointcut
            	    {

            	    						newCompositeNode(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_3_2_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_pointcuts_5_0=rulePointcut();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pointcuts",
            	    							lv_pointcuts_5_0,
            	    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Pointcut");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSimpleAspect.g:166:4: ( (lv_advices_6_0= ruleAdvice ) )
            	    {
            	    // InternalSimpleAspect.g:166:4: ( (lv_advices_6_0= ruleAdvice ) )
            	    // InternalSimpleAspect.g:167:5: (lv_advices_6_0= ruleAdvice )
            	    {
            	    // InternalSimpleAspect.g:167:5: (lv_advices_6_0= ruleAdvice )
            	    // InternalSimpleAspect.g:168:6: lv_advices_6_0= ruleAdvice
            	    {

            	    						newCompositeNode(grammarAccess.getAspectAccess().getAdvicesAdviceParserRuleCall_3_3_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_advices_6_0=ruleAdvice();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAspectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"advices",
            	    							lv_advices_6_0,
            	    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Advice");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleAspect"


    // $ANTLR start "entryRuleForeignAttribute"
    // InternalSimpleAspect.g:194:1: entryRuleForeignAttribute returns [EObject current=null] : iv_ruleForeignAttribute= ruleForeignAttribute EOF ;
    public final EObject entryRuleForeignAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForeignAttribute = null;


        try {
            // InternalSimpleAspect.g:194:57: (iv_ruleForeignAttribute= ruleForeignAttribute EOF )
            // InternalSimpleAspect.g:195:2: iv_ruleForeignAttribute= ruleForeignAttribute EOF
            {
             newCompositeNode(grammarAccess.getForeignAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForeignAttribute=ruleForeignAttribute();

            state._fsp--;

             current =iv_ruleForeignAttribute; 
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
    // $ANTLR end "entryRuleForeignAttribute"


    // $ANTLR start "ruleForeignAttribute"
    // InternalSimpleAspect.g:201:1: ruleForeignAttribute returns [EObject current=null] : (otherlv_0= 'private' ( (lv_type_1_0= ruleType ) ) ( (lv_inType_2_0= ruleQualifiedName ) ) otherlv_3= '/' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleForeignAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_inType_2_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:207:2: ( (otherlv_0= 'private' ( (lv_type_1_0= ruleType ) ) ( (lv_inType_2_0= ruleQualifiedName ) ) otherlv_3= '/' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalSimpleAspect.g:208:2: (otherlv_0= 'private' ( (lv_type_1_0= ruleType ) ) ( (lv_inType_2_0= ruleQualifiedName ) ) otherlv_3= '/' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalSimpleAspect.g:208:2: (otherlv_0= 'private' ( (lv_type_1_0= ruleType ) ) ( (lv_inType_2_0= ruleQualifiedName ) ) otherlv_3= '/' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ';' )
            // InternalSimpleAspect.g:209:3: otherlv_0= 'private' ( (lv_type_1_0= ruleType ) ) ( (lv_inType_2_0= ruleQualifiedName ) ) otherlv_3= '/' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getForeignAttributeAccess().getPrivateKeyword_0());
            		
            // InternalSimpleAspect.g:213:3: ( (lv_type_1_0= ruleType ) )
            // InternalSimpleAspect.g:214:4: (lv_type_1_0= ruleType )
            {
            // InternalSimpleAspect.g:214:4: (lv_type_1_0= ruleType )
            // InternalSimpleAspect.g:215:5: lv_type_1_0= ruleType
            {

            					newCompositeNode(grammarAccess.getForeignAttributeAccess().getTypeTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_type_1_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForeignAttributeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimpleAspect.g:232:3: ( (lv_inType_2_0= ruleQualifiedName ) )
            // InternalSimpleAspect.g:233:4: (lv_inType_2_0= ruleQualifiedName )
            {
            // InternalSimpleAspect.g:233:4: (lv_inType_2_0= ruleQualifiedName )
            // InternalSimpleAspect.g:234:5: lv_inType_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getForeignAttributeAccess().getInTypeQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_inType_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForeignAttributeRule());
            					}
            					set(
            						current,
            						"inType",
            						lv_inType_2_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getForeignAttributeAccess().getSolidusKeyword_3());
            		
            // InternalSimpleAspect.g:255:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalSimpleAspect.g:256:4: (lv_name_4_0= RULE_ID )
            {
            // InternalSimpleAspect.g:256:4: (lv_name_4_0= RULE_ID )
            // InternalSimpleAspect.g:257:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_4_0, grammarAccess.getForeignAttributeAccess().getNameIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getForeignAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getForeignAttributeAccess().getSemicolonKeyword_5());
            		

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
    // $ANTLR end "ruleForeignAttribute"


    // $ANTLR start "entryRulePointcut"
    // InternalSimpleAspect.g:281:1: entryRulePointcut returns [EObject current=null] : iv_rulePointcut= rulePointcut EOF ;
    public final EObject entryRulePointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointcut = null;


        try {
            // InternalSimpleAspect.g:281:49: (iv_rulePointcut= rulePointcut EOF )
            // InternalSimpleAspect.g:282:2: iv_rulePointcut= rulePointcut EOF
            {
             newCompositeNode(grammarAccess.getPointcutRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointcut=rulePointcut();

            state._fsp--;

             current =iv_rulePointcut; 
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
    // $ANTLR end "entryRulePointcut"


    // $ANTLR start "rulePointcut"
    // InternalSimpleAspect.g:288:1: rulePointcut returns [EObject current=null] : (otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_condition_8_0= rulePointcutCondition ) ) otherlv_9= ';' ) ;
    public final EObject rulePointcut() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_parameter_3_0 = null;

        EObject lv_parameter_5_0 = null;

        EObject lv_condition_8_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:294:2: ( (otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_condition_8_0= rulePointcutCondition ) ) otherlv_9= ';' ) )
            // InternalSimpleAspect.g:295:2: (otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_condition_8_0= rulePointcutCondition ) ) otherlv_9= ';' )
            {
            // InternalSimpleAspect.g:295:2: (otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_condition_8_0= rulePointcutCondition ) ) otherlv_9= ';' )
            // InternalSimpleAspect.g:296:3: otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameter_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_condition_8_0= rulePointcutCondition ) ) otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPointcutAccess().getPointcutKeyword_0());
            		
            // InternalSimpleAspect.g:300:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleAspect.g:301:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleAspect.g:301:4: (lv_name_1_0= RULE_ID )
            // InternalSimpleAspect.g:302:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPointcutAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPointcutRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getPointcutAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSimpleAspect.g:322:3: ( ( (lv_parameter_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID||(LA3_0>=36 && LA3_0<=39)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSimpleAspect.g:323:4: ( (lv_parameter_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) ) )*
                    {
                    // InternalSimpleAspect.g:323:4: ( (lv_parameter_3_0= ruleParameter ) )
                    // InternalSimpleAspect.g:324:5: (lv_parameter_3_0= ruleParameter )
                    {
                    // InternalSimpleAspect.g:324:5: (lv_parameter_3_0= ruleParameter )
                    // InternalSimpleAspect.g:325:6: lv_parameter_3_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getPointcutAccess().getParameterParameterParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parameter_3_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointcutRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_3_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimpleAspect.g:342:4: (otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==19) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalSimpleAspect.g:343:5: otherlv_4= ',' ( (lv_parameter_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_6); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPointcutAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSimpleAspect.g:347:5: ( (lv_parameter_5_0= ruleParameter ) )
                    	    // InternalSimpleAspect.g:348:6: (lv_parameter_5_0= ruleParameter )
                    	    {
                    	    // InternalSimpleAspect.g:348:6: (lv_parameter_5_0= ruleParameter )
                    	    // InternalSimpleAspect.g:349:7: lv_parameter_5_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getPointcutAccess().getParameterParameterParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_parameter_5_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPointcutRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_5_0,
                    	    								"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
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
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getPointcutAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,21,FOLLOW_13); 

            			newLeafNode(otherlv_7, grammarAccess.getPointcutAccess().getColonKeyword_5());
            		
            // InternalSimpleAspect.g:376:3: ( (lv_condition_8_0= rulePointcutCondition ) )
            // InternalSimpleAspect.g:377:4: (lv_condition_8_0= rulePointcutCondition )
            {
            // InternalSimpleAspect.g:377:4: (lv_condition_8_0= rulePointcutCondition )
            // InternalSimpleAspect.g:378:5: lv_condition_8_0= rulePointcutCondition
            {

            					newCompositeNode(grammarAccess.getPointcutAccess().getConditionPointcutConditionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_8);
            lv_condition_8_0=rulePointcutCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointcutRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_8_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.PointcutCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getPointcutAccess().getSemicolonKeyword_7());
            		

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
    // $ANTLR end "rulePointcut"


    // $ANTLR start "entryRulePointcutCondition"
    // InternalSimpleAspect.g:403:1: entryRulePointcutCondition returns [EObject current=null] : iv_rulePointcutCondition= rulePointcutCondition EOF ;
    public final EObject entryRulePointcutCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointcutCondition = null;


        try {
            // InternalSimpleAspect.g:403:58: (iv_rulePointcutCondition= rulePointcutCondition EOF )
            // InternalSimpleAspect.g:404:2: iv_rulePointcutCondition= rulePointcutCondition EOF
            {
             newCompositeNode(grammarAccess.getPointcutConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointcutCondition=rulePointcutCondition();

            state._fsp--;

             current =iv_rulePointcutCondition; 
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
    // $ANTLR end "entryRulePointcutCondition"


    // $ANTLR start "rulePointcutCondition"
    // InternalSimpleAspect.g:410:1: rulePointcutCondition returns [EObject current=null] : (this_SimplePointcutCondition_0= ruleSimplePointcutCondition | this_BinaryPointcutCondition_1= ruleBinaryPointcutCondition | this_UnaryPointcutCondition_2= ruleUnaryPointcutCondition ) ;
    public final EObject rulePointcutCondition() throws RecognitionException {
        EObject current = null;

        EObject this_SimplePointcutCondition_0 = null;

        EObject this_BinaryPointcutCondition_1 = null;

        EObject this_UnaryPointcutCondition_2 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:416:2: ( (this_SimplePointcutCondition_0= ruleSimplePointcutCondition | this_BinaryPointcutCondition_1= ruleBinaryPointcutCondition | this_UnaryPointcutCondition_2= ruleUnaryPointcutCondition ) )
            // InternalSimpleAspect.g:417:2: (this_SimplePointcutCondition_0= ruleSimplePointcutCondition | this_BinaryPointcutCondition_1= ruleBinaryPointcutCondition | this_UnaryPointcutCondition_2= ruleUnaryPointcutCondition )
            {
            // InternalSimpleAspect.g:417:2: (this_SimplePointcutCondition_0= ruleSimplePointcutCondition | this_BinaryPointcutCondition_1= ruleBinaryPointcutCondition | this_UnaryPointcutCondition_2= ruleUnaryPointcutCondition )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 25:
            case 26:
            case 27:
            case 28:
                {
                alt4=1;
                }
                break;
            case 18:
                {
                alt4=2;
                }
                break;
            case 22:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalSimpleAspect.g:418:3: this_SimplePointcutCondition_0= ruleSimplePointcutCondition
                    {

                    			newCompositeNode(grammarAccess.getPointcutConditionAccess().getSimplePointcutConditionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimplePointcutCondition_0=ruleSimplePointcutCondition();

                    state._fsp--;


                    			current = this_SimplePointcutCondition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:427:3: this_BinaryPointcutCondition_1= ruleBinaryPointcutCondition
                    {

                    			newCompositeNode(grammarAccess.getPointcutConditionAccess().getBinaryPointcutConditionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BinaryPointcutCondition_1=ruleBinaryPointcutCondition();

                    state._fsp--;


                    			current = this_BinaryPointcutCondition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSimpleAspect.g:436:3: this_UnaryPointcutCondition_2= ruleUnaryPointcutCondition
                    {

                    			newCompositeNode(grammarAccess.getPointcutConditionAccess().getUnaryPointcutConditionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnaryPointcutCondition_2=ruleUnaryPointcutCondition();

                    state._fsp--;


                    			current = this_UnaryPointcutCondition_2;
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
    // $ANTLR end "rulePointcutCondition"


    // $ANTLR start "entryRuleUnaryPointcutCondition"
    // InternalSimpleAspect.g:448:1: entryRuleUnaryPointcutCondition returns [EObject current=null] : iv_ruleUnaryPointcutCondition= ruleUnaryPointcutCondition EOF ;
    public final EObject entryRuleUnaryPointcutCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryPointcutCondition = null;


        try {
            // InternalSimpleAspect.g:448:63: (iv_ruleUnaryPointcutCondition= ruleUnaryPointcutCondition EOF )
            // InternalSimpleAspect.g:449:2: iv_ruleUnaryPointcutCondition= ruleUnaryPointcutCondition EOF
            {
             newCompositeNode(grammarAccess.getUnaryPointcutConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryPointcutCondition=ruleUnaryPointcutCondition();

            state._fsp--;

             current =iv_ruleUnaryPointcutCondition; 
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
    // $ANTLR end "entryRuleUnaryPointcutCondition"


    // $ANTLR start "ruleUnaryPointcutCondition"
    // InternalSimpleAspect.g:455:1: ruleUnaryPointcutCondition returns [EObject current=null] : (otherlv_0= '!' ( (lv_condition_1_0= rulePointcutCondition ) ) ) ;
    public final EObject ruleUnaryPointcutCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:461:2: ( (otherlv_0= '!' ( (lv_condition_1_0= rulePointcutCondition ) ) ) )
            // InternalSimpleAspect.g:462:2: (otherlv_0= '!' ( (lv_condition_1_0= rulePointcutCondition ) ) )
            {
            // InternalSimpleAspect.g:462:2: (otherlv_0= '!' ( (lv_condition_1_0= rulePointcutCondition ) ) )
            // InternalSimpleAspect.g:463:3: otherlv_0= '!' ( (lv_condition_1_0= rulePointcutCondition ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getUnaryPointcutConditionAccess().getExclamationMarkKeyword_0());
            		
            // InternalSimpleAspect.g:467:3: ( (lv_condition_1_0= rulePointcutCondition ) )
            // InternalSimpleAspect.g:468:4: (lv_condition_1_0= rulePointcutCondition )
            {
            // InternalSimpleAspect.g:468:4: (lv_condition_1_0= rulePointcutCondition )
            // InternalSimpleAspect.g:469:5: lv_condition_1_0= rulePointcutCondition
            {

            					newCompositeNode(grammarAccess.getUnaryPointcutConditionAccess().getConditionPointcutConditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_condition_1_0=rulePointcutCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryPointcutConditionRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.PointcutCondition");
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
    // $ANTLR end "ruleUnaryPointcutCondition"


    // $ANTLR start "entryRuleBinaryPointcutCondition"
    // InternalSimpleAspect.g:490:1: entryRuleBinaryPointcutCondition returns [EObject current=null] : iv_ruleBinaryPointcutCondition= ruleBinaryPointcutCondition EOF ;
    public final EObject entryRuleBinaryPointcutCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryPointcutCondition = null;


        try {
            // InternalSimpleAspect.g:490:64: (iv_ruleBinaryPointcutCondition= ruleBinaryPointcutCondition EOF )
            // InternalSimpleAspect.g:491:2: iv_ruleBinaryPointcutCondition= ruleBinaryPointcutCondition EOF
            {
             newCompositeNode(grammarAccess.getBinaryPointcutConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryPointcutCondition=ruleBinaryPointcutCondition();

            state._fsp--;

             current =iv_ruleBinaryPointcutCondition; 
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
    // $ANTLR end "entryRuleBinaryPointcutCondition"


    // $ANTLR start "ruleBinaryPointcutCondition"
    // InternalSimpleAspect.g:497:1: ruleBinaryPointcutCondition returns [EObject current=null] : (otherlv_0= '(' ( (lv_first_1_0= rulePointcutCondition ) ) otherlv_2= ')' ( ( (lv_type_3_0= '||' ) ) | ( (lv_type_4_0= '&&' ) ) ) otherlv_5= '(' ( (lv_second_6_0= rulePointcutCondition ) ) otherlv_7= ')' ) ;
    public final EObject ruleBinaryPointcutCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_first_1_0 = null;

        EObject lv_second_6_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:503:2: ( (otherlv_0= '(' ( (lv_first_1_0= rulePointcutCondition ) ) otherlv_2= ')' ( ( (lv_type_3_0= '||' ) ) | ( (lv_type_4_0= '&&' ) ) ) otherlv_5= '(' ( (lv_second_6_0= rulePointcutCondition ) ) otherlv_7= ')' ) )
            // InternalSimpleAspect.g:504:2: (otherlv_0= '(' ( (lv_first_1_0= rulePointcutCondition ) ) otherlv_2= ')' ( ( (lv_type_3_0= '||' ) ) | ( (lv_type_4_0= '&&' ) ) ) otherlv_5= '(' ( (lv_second_6_0= rulePointcutCondition ) ) otherlv_7= ')' )
            {
            // InternalSimpleAspect.g:504:2: (otherlv_0= '(' ( (lv_first_1_0= rulePointcutCondition ) ) otherlv_2= ')' ( ( (lv_type_3_0= '||' ) ) | ( (lv_type_4_0= '&&' ) ) ) otherlv_5= '(' ( (lv_second_6_0= rulePointcutCondition ) ) otherlv_7= ')' )
            // InternalSimpleAspect.g:505:3: otherlv_0= '(' ( (lv_first_1_0= rulePointcutCondition ) ) otherlv_2= ')' ( ( (lv_type_3_0= '||' ) ) | ( (lv_type_4_0= '&&' ) ) ) otherlv_5= '(' ( (lv_second_6_0= rulePointcutCondition ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getBinaryPointcutConditionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalSimpleAspect.g:509:3: ( (lv_first_1_0= rulePointcutCondition ) )
            // InternalSimpleAspect.g:510:4: (lv_first_1_0= rulePointcutCondition )
            {
            // InternalSimpleAspect.g:510:4: (lv_first_1_0= rulePointcutCondition )
            // InternalSimpleAspect.g:511:5: lv_first_1_0= rulePointcutCondition
            {

            					newCompositeNode(grammarAccess.getBinaryPointcutConditionAccess().getFirstPointcutConditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_14);
            lv_first_1_0=rulePointcutCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryPointcutConditionRule());
            					}
            					set(
            						current,
            						"first",
            						lv_first_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.PointcutCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getBinaryPointcutConditionAccess().getRightParenthesisKeyword_2());
            		
            // InternalSimpleAspect.g:532:3: ( ( (lv_type_3_0= '||' ) ) | ( (lv_type_4_0= '&&' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalSimpleAspect.g:533:4: ( (lv_type_3_0= '||' ) )
                    {
                    // InternalSimpleAspect.g:533:4: ( (lv_type_3_0= '||' ) )
                    // InternalSimpleAspect.g:534:5: (lv_type_3_0= '||' )
                    {
                    // InternalSimpleAspect.g:534:5: (lv_type_3_0= '||' )
                    // InternalSimpleAspect.g:535:6: lv_type_3_0= '||'
                    {
                    lv_type_3_0=(Token)match(input,23,FOLLOW_9); 

                    						newLeafNode(lv_type_3_0, grammarAccess.getBinaryPointcutConditionAccess().getTypeVerticalLineVerticalLineKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryPointcutConditionRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_3_0, "||");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:548:4: ( (lv_type_4_0= '&&' ) )
                    {
                    // InternalSimpleAspect.g:548:4: ( (lv_type_4_0= '&&' ) )
                    // InternalSimpleAspect.g:549:5: (lv_type_4_0= '&&' )
                    {
                    // InternalSimpleAspect.g:549:5: (lv_type_4_0= '&&' )
                    // InternalSimpleAspect.g:550:6: lv_type_4_0= '&&'
                    {
                    lv_type_4_0=(Token)match(input,24,FOLLOW_9); 

                    						newLeafNode(lv_type_4_0, grammarAccess.getBinaryPointcutConditionAccess().getTypeAmpersandAmpersandKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBinaryPointcutConditionRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_4_0, "&&");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getBinaryPointcutConditionAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSimpleAspect.g:567:3: ( (lv_second_6_0= rulePointcutCondition ) )
            // InternalSimpleAspect.g:568:4: (lv_second_6_0= rulePointcutCondition )
            {
            // InternalSimpleAspect.g:568:4: (lv_second_6_0= rulePointcutCondition )
            // InternalSimpleAspect.g:569:5: lv_second_6_0= rulePointcutCondition
            {

            					newCompositeNode(grammarAccess.getBinaryPointcutConditionAccess().getSecondPointcutConditionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_14);
            lv_second_6_0=rulePointcutCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryPointcutConditionRule());
            					}
            					set(
            						current,
            						"second",
            						lv_second_6_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.PointcutCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getBinaryPointcutConditionAccess().getRightParenthesisKeyword_6());
            		

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
    // $ANTLR end "ruleBinaryPointcutCondition"


    // $ANTLR start "entryRuleSimplePointcutCondition"
    // InternalSimpleAspect.g:594:1: entryRuleSimplePointcutCondition returns [EObject current=null] : iv_ruleSimplePointcutCondition= ruleSimplePointcutCondition EOF ;
    public final EObject entryRuleSimplePointcutCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimplePointcutCondition = null;


        try {
            // InternalSimpleAspect.g:594:64: (iv_ruleSimplePointcutCondition= ruleSimplePointcutCondition EOF )
            // InternalSimpleAspect.g:595:2: iv_ruleSimplePointcutCondition= ruleSimplePointcutCondition EOF
            {
             newCompositeNode(grammarAccess.getSimplePointcutConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimplePointcutCondition=ruleSimplePointcutCondition();

            state._fsp--;

             current =iv_ruleSimplePointcutCondition; 
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
    // $ANTLR end "entryRuleSimplePointcutCondition"


    // $ANTLR start "ruleSimplePointcutCondition"
    // InternalSimpleAspect.g:601:1: ruleSimplePointcutCondition returns [EObject current=null] : ( ( ( ( (lv_type_0_0= 'call' ) ) | ( (lv_type_1_0= 'execution' ) ) ) otherlv_2= '(' ( (lv_condition_3_0= rulePointcutMethodFilter ) ) otherlv_4= ')' ) | ( ( ( (lv_type_5_0= 'within' ) ) | ( (lv_type_6_0= 'handler' ) ) ) otherlv_7= '(' ( (lv_condition_8_0= rulePointcutTypeFilter ) ) otherlv_9= ')' ) ) ;
    public final EObject ruleSimplePointcutCondition() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_type_5_0=null;
        Token lv_type_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_condition_3_0 = null;

        EObject lv_condition_8_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:607:2: ( ( ( ( ( (lv_type_0_0= 'call' ) ) | ( (lv_type_1_0= 'execution' ) ) ) otherlv_2= '(' ( (lv_condition_3_0= rulePointcutMethodFilter ) ) otherlv_4= ')' ) | ( ( ( (lv_type_5_0= 'within' ) ) | ( (lv_type_6_0= 'handler' ) ) ) otherlv_7= '(' ( (lv_condition_8_0= rulePointcutTypeFilter ) ) otherlv_9= ')' ) ) )
            // InternalSimpleAspect.g:608:2: ( ( ( ( (lv_type_0_0= 'call' ) ) | ( (lv_type_1_0= 'execution' ) ) ) otherlv_2= '(' ( (lv_condition_3_0= rulePointcutMethodFilter ) ) otherlv_4= ')' ) | ( ( ( (lv_type_5_0= 'within' ) ) | ( (lv_type_6_0= 'handler' ) ) ) otherlv_7= '(' ( (lv_condition_8_0= rulePointcutTypeFilter ) ) otherlv_9= ')' ) )
            {
            // InternalSimpleAspect.g:608:2: ( ( ( ( (lv_type_0_0= 'call' ) ) | ( (lv_type_1_0= 'execution' ) ) ) otherlv_2= '(' ( (lv_condition_3_0= rulePointcutMethodFilter ) ) otherlv_4= ')' ) | ( ( ( (lv_type_5_0= 'within' ) ) | ( (lv_type_6_0= 'handler' ) ) ) otherlv_7= '(' ( (lv_condition_8_0= rulePointcutTypeFilter ) ) otherlv_9= ')' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=25 && LA8_0<=26)) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=27 && LA8_0<=28)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalSimpleAspect.g:609:3: ( ( ( (lv_type_0_0= 'call' ) ) | ( (lv_type_1_0= 'execution' ) ) ) otherlv_2= '(' ( (lv_condition_3_0= rulePointcutMethodFilter ) ) otherlv_4= ')' )
                    {
                    // InternalSimpleAspect.g:609:3: ( ( ( (lv_type_0_0= 'call' ) ) | ( (lv_type_1_0= 'execution' ) ) ) otherlv_2= '(' ( (lv_condition_3_0= rulePointcutMethodFilter ) ) otherlv_4= ')' )
                    // InternalSimpleAspect.g:610:4: ( ( (lv_type_0_0= 'call' ) ) | ( (lv_type_1_0= 'execution' ) ) ) otherlv_2= '(' ( (lv_condition_3_0= rulePointcutMethodFilter ) ) otherlv_4= ')'
                    {
                    // InternalSimpleAspect.g:610:4: ( ( (lv_type_0_0= 'call' ) ) | ( (lv_type_1_0= 'execution' ) ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==25) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==26) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalSimpleAspect.g:611:5: ( (lv_type_0_0= 'call' ) )
                            {
                            // InternalSimpleAspect.g:611:5: ( (lv_type_0_0= 'call' ) )
                            // InternalSimpleAspect.g:612:6: (lv_type_0_0= 'call' )
                            {
                            // InternalSimpleAspect.g:612:6: (lv_type_0_0= 'call' )
                            // InternalSimpleAspect.g:613:7: lv_type_0_0= 'call'
                            {
                            lv_type_0_0=(Token)match(input,25,FOLLOW_9); 

                            							newLeafNode(lv_type_0_0, grammarAccess.getSimplePointcutConditionAccess().getTypeCallKeyword_0_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSimplePointcutConditionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_0_0, "call");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSimpleAspect.g:626:5: ( (lv_type_1_0= 'execution' ) )
                            {
                            // InternalSimpleAspect.g:626:5: ( (lv_type_1_0= 'execution' ) )
                            // InternalSimpleAspect.g:627:6: (lv_type_1_0= 'execution' )
                            {
                            // InternalSimpleAspect.g:627:6: (lv_type_1_0= 'execution' )
                            // InternalSimpleAspect.g:628:7: lv_type_1_0= 'execution'
                            {
                            lv_type_1_0=(Token)match(input,26,FOLLOW_9); 

                            							newLeafNode(lv_type_1_0, grammarAccess.getSimplePointcutConditionAccess().getTypeExecutionKeyword_0_0_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSimplePointcutConditionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_1_0, "execution");
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,18,FOLLOW_16); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimplePointcutConditionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalSimpleAspect.g:645:4: ( (lv_condition_3_0= rulePointcutMethodFilter ) )
                    // InternalSimpleAspect.g:646:5: (lv_condition_3_0= rulePointcutMethodFilter )
                    {
                    // InternalSimpleAspect.g:646:5: (lv_condition_3_0= rulePointcutMethodFilter )
                    // InternalSimpleAspect.g:647:6: lv_condition_3_0= rulePointcutMethodFilter
                    {

                    						newCompositeNode(grammarAccess.getSimplePointcutConditionAccess().getConditionPointcutMethodFilterParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_condition_3_0=rulePointcutMethodFilter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimplePointcutConditionRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_3_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.PointcutMethodFilter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getSimplePointcutConditionAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:670:3: ( ( ( (lv_type_5_0= 'within' ) ) | ( (lv_type_6_0= 'handler' ) ) ) otherlv_7= '(' ( (lv_condition_8_0= rulePointcutTypeFilter ) ) otherlv_9= ')' )
                    {
                    // InternalSimpleAspect.g:670:3: ( ( ( (lv_type_5_0= 'within' ) ) | ( (lv_type_6_0= 'handler' ) ) ) otherlv_7= '(' ( (lv_condition_8_0= rulePointcutTypeFilter ) ) otherlv_9= ')' )
                    // InternalSimpleAspect.g:671:4: ( ( (lv_type_5_0= 'within' ) ) | ( (lv_type_6_0= 'handler' ) ) ) otherlv_7= '(' ( (lv_condition_8_0= rulePointcutTypeFilter ) ) otherlv_9= ')'
                    {
                    // InternalSimpleAspect.g:671:4: ( ( (lv_type_5_0= 'within' ) ) | ( (lv_type_6_0= 'handler' ) ) )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==27) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==28) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalSimpleAspect.g:672:5: ( (lv_type_5_0= 'within' ) )
                            {
                            // InternalSimpleAspect.g:672:5: ( (lv_type_5_0= 'within' ) )
                            // InternalSimpleAspect.g:673:6: (lv_type_5_0= 'within' )
                            {
                            // InternalSimpleAspect.g:673:6: (lv_type_5_0= 'within' )
                            // InternalSimpleAspect.g:674:7: lv_type_5_0= 'within'
                            {
                            lv_type_5_0=(Token)match(input,27,FOLLOW_9); 

                            							newLeafNode(lv_type_5_0, grammarAccess.getSimplePointcutConditionAccess().getTypeWithinKeyword_1_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSimplePointcutConditionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_5_0, "within");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSimpleAspect.g:687:5: ( (lv_type_6_0= 'handler' ) )
                            {
                            // InternalSimpleAspect.g:687:5: ( (lv_type_6_0= 'handler' ) )
                            // InternalSimpleAspect.g:688:6: (lv_type_6_0= 'handler' )
                            {
                            // InternalSimpleAspect.g:688:6: (lv_type_6_0= 'handler' )
                            // InternalSimpleAspect.g:689:7: lv_type_6_0= 'handler'
                            {
                            lv_type_6_0=(Token)match(input,28,FOLLOW_9); 

                            							newLeafNode(lv_type_6_0, grammarAccess.getSimplePointcutConditionAccess().getTypeHandlerKeyword_1_0_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSimplePointcutConditionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_6_0, "handler");
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,18,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getSimplePointcutConditionAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalSimpleAspect.g:706:4: ( (lv_condition_8_0= rulePointcutTypeFilter ) )
                    // InternalSimpleAspect.g:707:5: (lv_condition_8_0= rulePointcutTypeFilter )
                    {
                    // InternalSimpleAspect.g:707:5: (lv_condition_8_0= rulePointcutTypeFilter )
                    // InternalSimpleAspect.g:708:6: lv_condition_8_0= rulePointcutTypeFilter
                    {

                    						newCompositeNode(grammarAccess.getSimplePointcutConditionAccess().getConditionPointcutTypeFilterParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_condition_8_0=rulePointcutTypeFilter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimplePointcutConditionRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_8_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.PointcutTypeFilter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getSimplePointcutConditionAccess().getRightParenthesisKeyword_1_3());
                    			

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
    // $ANTLR end "ruleSimplePointcutCondition"


    // $ANTLR start "entryRulePointcutMethodFilter"
    // InternalSimpleAspect.g:734:1: entryRulePointcutMethodFilter returns [EObject current=null] : iv_rulePointcutMethodFilter= rulePointcutMethodFilter EOF ;
    public final EObject entryRulePointcutMethodFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointcutMethodFilter = null;


        try {
            // InternalSimpleAspect.g:734:61: (iv_rulePointcutMethodFilter= rulePointcutMethodFilter EOF )
            // InternalSimpleAspect.g:735:2: iv_rulePointcutMethodFilter= rulePointcutMethodFilter EOF
            {
             newCompositeNode(grammarAccess.getPointcutMethodFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointcutMethodFilter=rulePointcutMethodFilter();

            state._fsp--;

             current =iv_rulePointcutMethodFilter; 
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
    // $ANTLR end "entryRulePointcutMethodFilter"


    // $ANTLR start "rulePointcutMethodFilter"
    // InternalSimpleAspect.g:741:1: rulePointcutMethodFilter returns [EObject current=null] : ( ( (lv_isPublic_0_0= 'public' ) )? ( (lv_isPrivate_1_0= 'private' ) )? ( (lv_isStatic_2_0= 'static' ) )? ( ( (lv_anyReturn_3_0= '*' ) ) | ( (lv_returnType_4_0= ruleType ) ) ) ( ( (lv_anyClass_5_0= '*' ) ) | ( (lv_classType_6_0= ruleQualifiedName ) ) ) ( ( (lv_anyMethod_7_0= '*' ) ) | ( (lv_methodName_8_0= RULE_ID ) ) ) otherlv_9= '(' ( ( (lv_anyParameter_10_0= '..' ) ) | ( ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )* )? ) otherlv_14= ')' ) ;
    public final EObject rulePointcutMethodFilter() throws RecognitionException {
        EObject current = null;

        Token lv_isPublic_0_0=null;
        Token lv_isPrivate_1_0=null;
        Token lv_isStatic_2_0=null;
        Token lv_anyReturn_3_0=null;
        Token lv_anyClass_5_0=null;
        Token lv_anyMethod_7_0=null;
        Token lv_methodName_8_0=null;
        Token otherlv_9=null;
        Token lv_anyParameter_10_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_returnType_4_0 = null;

        AntlrDatatypeRuleToken lv_classType_6_0 = null;

        EObject lv_parameter_11_0 = null;

        EObject lv_parameter_13_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:747:2: ( ( ( (lv_isPublic_0_0= 'public' ) )? ( (lv_isPrivate_1_0= 'private' ) )? ( (lv_isStatic_2_0= 'static' ) )? ( ( (lv_anyReturn_3_0= '*' ) ) | ( (lv_returnType_4_0= ruleType ) ) ) ( ( (lv_anyClass_5_0= '*' ) ) | ( (lv_classType_6_0= ruleQualifiedName ) ) ) ( ( (lv_anyMethod_7_0= '*' ) ) | ( (lv_methodName_8_0= RULE_ID ) ) ) otherlv_9= '(' ( ( (lv_anyParameter_10_0= '..' ) ) | ( ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )* )? ) otherlv_14= ')' ) )
            // InternalSimpleAspect.g:748:2: ( ( (lv_isPublic_0_0= 'public' ) )? ( (lv_isPrivate_1_0= 'private' ) )? ( (lv_isStatic_2_0= 'static' ) )? ( ( (lv_anyReturn_3_0= '*' ) ) | ( (lv_returnType_4_0= ruleType ) ) ) ( ( (lv_anyClass_5_0= '*' ) ) | ( (lv_classType_6_0= ruleQualifiedName ) ) ) ( ( (lv_anyMethod_7_0= '*' ) ) | ( (lv_methodName_8_0= RULE_ID ) ) ) otherlv_9= '(' ( ( (lv_anyParameter_10_0= '..' ) ) | ( ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )* )? ) otherlv_14= ')' )
            {
            // InternalSimpleAspect.g:748:2: ( ( (lv_isPublic_0_0= 'public' ) )? ( (lv_isPrivate_1_0= 'private' ) )? ( (lv_isStatic_2_0= 'static' ) )? ( ( (lv_anyReturn_3_0= '*' ) ) | ( (lv_returnType_4_0= ruleType ) ) ) ( ( (lv_anyClass_5_0= '*' ) ) | ( (lv_classType_6_0= ruleQualifiedName ) ) ) ( ( (lv_anyMethod_7_0= '*' ) ) | ( (lv_methodName_8_0= RULE_ID ) ) ) otherlv_9= '(' ( ( (lv_anyParameter_10_0= '..' ) ) | ( ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )* )? ) otherlv_14= ')' )
            // InternalSimpleAspect.g:749:3: ( (lv_isPublic_0_0= 'public' ) )? ( (lv_isPrivate_1_0= 'private' ) )? ( (lv_isStatic_2_0= 'static' ) )? ( ( (lv_anyReturn_3_0= '*' ) ) | ( (lv_returnType_4_0= ruleType ) ) ) ( ( (lv_anyClass_5_0= '*' ) ) | ( (lv_classType_6_0= ruleQualifiedName ) ) ) ( ( (lv_anyMethod_7_0= '*' ) ) | ( (lv_methodName_8_0= RULE_ID ) ) ) otherlv_9= '(' ( ( (lv_anyParameter_10_0= '..' ) ) | ( ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )* )? ) otherlv_14= ')'
            {
            // InternalSimpleAspect.g:749:3: ( (lv_isPublic_0_0= 'public' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==29) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSimpleAspect.g:750:4: (lv_isPublic_0_0= 'public' )
                    {
                    // InternalSimpleAspect.g:750:4: (lv_isPublic_0_0= 'public' )
                    // InternalSimpleAspect.g:751:5: lv_isPublic_0_0= 'public'
                    {
                    lv_isPublic_0_0=(Token)match(input,29,FOLLOW_17); 

                    					newLeafNode(lv_isPublic_0_0, grammarAccess.getPointcutMethodFilterAccess().getIsPublicPublicKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPointcutMethodFilterRule());
                    					}
                    					setWithLastConsumed(current, "isPublic", true, "public");
                    				

                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:763:3: ( (lv_isPrivate_1_0= 'private' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSimpleAspect.g:764:4: (lv_isPrivate_1_0= 'private' )
                    {
                    // InternalSimpleAspect.g:764:4: (lv_isPrivate_1_0= 'private' )
                    // InternalSimpleAspect.g:765:5: lv_isPrivate_1_0= 'private'
                    {
                    lv_isPrivate_1_0=(Token)match(input,14,FOLLOW_18); 

                    					newLeafNode(lv_isPrivate_1_0, grammarAccess.getPointcutMethodFilterAccess().getIsPrivatePrivateKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPointcutMethodFilterRule());
                    					}
                    					setWithLastConsumed(current, "isPrivate", true, "private");
                    				

                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:777:3: ( (lv_isStatic_2_0= 'static' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSimpleAspect.g:778:4: (lv_isStatic_2_0= 'static' )
                    {
                    // InternalSimpleAspect.g:778:4: (lv_isStatic_2_0= 'static' )
                    // InternalSimpleAspect.g:779:5: lv_isStatic_2_0= 'static'
                    {
                    lv_isStatic_2_0=(Token)match(input,30,FOLLOW_19); 

                    					newLeafNode(lv_isStatic_2_0, grammarAccess.getPointcutMethodFilterAccess().getIsStaticStaticKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPointcutMethodFilterRule());
                    					}
                    					setWithLastConsumed(current, "isStatic", true, "static");
                    				

                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:791:3: ( ( (lv_anyReturn_3_0= '*' ) ) | ( (lv_returnType_4_0= ruleType ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==31) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID||(LA12_0>=36 && LA12_0<=39)) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalSimpleAspect.g:792:4: ( (lv_anyReturn_3_0= '*' ) )
                    {
                    // InternalSimpleAspect.g:792:4: ( (lv_anyReturn_3_0= '*' ) )
                    // InternalSimpleAspect.g:793:5: (lv_anyReturn_3_0= '*' )
                    {
                    // InternalSimpleAspect.g:793:5: (lv_anyReturn_3_0= '*' )
                    // InternalSimpleAspect.g:794:6: lv_anyReturn_3_0= '*'
                    {
                    lv_anyReturn_3_0=(Token)match(input,31,FOLLOW_19); 

                    						newLeafNode(lv_anyReturn_3_0, grammarAccess.getPointcutMethodFilterAccess().getAnyReturnAsteriskKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPointcutMethodFilterRule());
                    						}
                    						setWithLastConsumed(current, "anyReturn", true, "*");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:807:4: ( (lv_returnType_4_0= ruleType ) )
                    {
                    // InternalSimpleAspect.g:807:4: ( (lv_returnType_4_0= ruleType ) )
                    // InternalSimpleAspect.g:808:5: (lv_returnType_4_0= ruleType )
                    {
                    // InternalSimpleAspect.g:808:5: (lv_returnType_4_0= ruleType )
                    // InternalSimpleAspect.g:809:6: lv_returnType_4_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getPointcutMethodFilterAccess().getReturnTypeTypeParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_returnType_4_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointcutMethodFilterRule());
                    						}
                    						set(
                    							current,
                    							"returnType",
                    							lv_returnType_4_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:827:3: ( ( (lv_anyClass_5_0= '*' ) ) | ( (lv_classType_6_0= ruleQualifiedName ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalSimpleAspect.g:828:4: ( (lv_anyClass_5_0= '*' ) )
                    {
                    // InternalSimpleAspect.g:828:4: ( (lv_anyClass_5_0= '*' ) )
                    // InternalSimpleAspect.g:829:5: (lv_anyClass_5_0= '*' )
                    {
                    // InternalSimpleAspect.g:829:5: (lv_anyClass_5_0= '*' )
                    // InternalSimpleAspect.g:830:6: lv_anyClass_5_0= '*'
                    {
                    lv_anyClass_5_0=(Token)match(input,31,FOLLOW_20); 

                    						newLeafNode(lv_anyClass_5_0, grammarAccess.getPointcutMethodFilterAccess().getAnyClassAsteriskKeyword_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPointcutMethodFilterRule());
                    						}
                    						setWithLastConsumed(current, "anyClass", true, "*");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:843:4: ( (lv_classType_6_0= ruleQualifiedName ) )
                    {
                    // InternalSimpleAspect.g:843:4: ( (lv_classType_6_0= ruleQualifiedName ) )
                    // InternalSimpleAspect.g:844:5: (lv_classType_6_0= ruleQualifiedName )
                    {
                    // InternalSimpleAspect.g:844:5: (lv_classType_6_0= ruleQualifiedName )
                    // InternalSimpleAspect.g:845:6: lv_classType_6_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getPointcutMethodFilterAccess().getClassTypeQualifiedNameParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_classType_6_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointcutMethodFilterRule());
                    						}
                    						set(
                    							current,
                    							"classType",
                    							lv_classType_6_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:863:3: ( ( (lv_anyMethod_7_0= '*' ) ) | ( (lv_methodName_8_0= RULE_ID ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalSimpleAspect.g:864:4: ( (lv_anyMethod_7_0= '*' ) )
                    {
                    // InternalSimpleAspect.g:864:4: ( (lv_anyMethod_7_0= '*' ) )
                    // InternalSimpleAspect.g:865:5: (lv_anyMethod_7_0= '*' )
                    {
                    // InternalSimpleAspect.g:865:5: (lv_anyMethod_7_0= '*' )
                    // InternalSimpleAspect.g:866:6: lv_anyMethod_7_0= '*'
                    {
                    lv_anyMethod_7_0=(Token)match(input,31,FOLLOW_9); 

                    						newLeafNode(lv_anyMethod_7_0, grammarAccess.getPointcutMethodFilterAccess().getAnyMethodAsteriskKeyword_5_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPointcutMethodFilterRule());
                    						}
                    						setWithLastConsumed(current, "anyMethod", true, "*");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:879:4: ( (lv_methodName_8_0= RULE_ID ) )
                    {
                    // InternalSimpleAspect.g:879:4: ( (lv_methodName_8_0= RULE_ID ) )
                    // InternalSimpleAspect.g:880:5: (lv_methodName_8_0= RULE_ID )
                    {
                    // InternalSimpleAspect.g:880:5: (lv_methodName_8_0= RULE_ID )
                    // InternalSimpleAspect.g:881:6: lv_methodName_8_0= RULE_ID
                    {
                    lv_methodName_8_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    						newLeafNode(lv_methodName_8_0, grammarAccess.getPointcutMethodFilterAccess().getMethodNameIDTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPointcutMethodFilterRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"methodName",
                    							lv_methodName_8_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_21); 

            			newLeafNode(otherlv_9, grammarAccess.getPointcutMethodFilterAccess().getLeftParenthesisKeyword_6());
            		
            // InternalSimpleAspect.g:902:3: ( ( (lv_anyParameter_10_0= '..' ) ) | ( ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )* )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID||LA17_0==20||(LA17_0>=36 && LA17_0<=39)) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalSimpleAspect.g:903:4: ( (lv_anyParameter_10_0= '..' ) )
                    {
                    // InternalSimpleAspect.g:903:4: ( (lv_anyParameter_10_0= '..' ) )
                    // InternalSimpleAspect.g:904:5: (lv_anyParameter_10_0= '..' )
                    {
                    // InternalSimpleAspect.g:904:5: (lv_anyParameter_10_0= '..' )
                    // InternalSimpleAspect.g:905:6: lv_anyParameter_10_0= '..'
                    {
                    lv_anyParameter_10_0=(Token)match(input,32,FOLLOW_14); 

                    						newLeafNode(lv_anyParameter_10_0, grammarAccess.getPointcutMethodFilterAccess().getAnyParameterFullStopFullStopKeyword_7_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPointcutMethodFilterRule());
                    						}
                    						setWithLastConsumed(current, "anyParameter", true, "..");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:918:4: ( ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )* )?
                    {
                    // InternalSimpleAspect.g:918:4: ( ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_ID||(LA16_0>=36 && LA16_0<=39)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalSimpleAspect.g:919:5: ( (lv_parameter_11_0= ruleType ) ) (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )*
                            {
                            // InternalSimpleAspect.g:919:5: ( (lv_parameter_11_0= ruleType ) )
                            // InternalSimpleAspect.g:920:6: (lv_parameter_11_0= ruleType )
                            {
                            // InternalSimpleAspect.g:920:6: (lv_parameter_11_0= ruleType )
                            // InternalSimpleAspect.g:921:7: lv_parameter_11_0= ruleType
                            {

                            							newCompositeNode(grammarAccess.getPointcutMethodFilterAccess().getParameterTypeParserRuleCall_7_1_0_0());
                            						
                            pushFollow(FOLLOW_11);
                            lv_parameter_11_0=ruleType();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPointcutMethodFilterRule());
                            							}
                            							add(
                            								current,
                            								"parameter",
                            								lv_parameter_11_0,
                            								"at.ac.tuwien.big.simpleaspect.SimpleAspect.Type");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalSimpleAspect.g:938:5: (otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) ) )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==19) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // InternalSimpleAspect.g:939:6: otherlv_12= ',' ( (lv_parameter_13_0= ruleType ) )
                            	    {
                            	    otherlv_12=(Token)match(input,19,FOLLOW_6); 

                            	    						newLeafNode(otherlv_12, grammarAccess.getPointcutMethodFilterAccess().getCommaKeyword_7_1_1_0());
                            	    					
                            	    // InternalSimpleAspect.g:943:6: ( (lv_parameter_13_0= ruleType ) )
                            	    // InternalSimpleAspect.g:944:7: (lv_parameter_13_0= ruleType )
                            	    {
                            	    // InternalSimpleAspect.g:944:7: (lv_parameter_13_0= ruleType )
                            	    // InternalSimpleAspect.g:945:8: lv_parameter_13_0= ruleType
                            	    {

                            	    								newCompositeNode(grammarAccess.getPointcutMethodFilterAccess().getParameterTypeParserRuleCall_7_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_11);
                            	    lv_parameter_13_0=ruleType();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getPointcutMethodFilterRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"parameter",
                            	    									lv_parameter_13_0,
                            	    									"at.ac.tuwien.big.simpleaspect.SimpleAspect.Type");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getPointcutMethodFilterAccess().getRightParenthesisKeyword_8());
            		

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
    // $ANTLR end "rulePointcutMethodFilter"


    // $ANTLR start "entryRulePointcutTypeFilter"
    // InternalSimpleAspect.g:973:1: entryRulePointcutTypeFilter returns [EObject current=null] : iv_rulePointcutTypeFilter= rulePointcutTypeFilter EOF ;
    public final EObject entryRulePointcutTypeFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointcutTypeFilter = null;


        try {
            // InternalSimpleAspect.g:973:59: (iv_rulePointcutTypeFilter= rulePointcutTypeFilter EOF )
            // InternalSimpleAspect.g:974:2: iv_rulePointcutTypeFilter= rulePointcutTypeFilter EOF
            {
             newCompositeNode(grammarAccess.getPointcutTypeFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointcutTypeFilter=rulePointcutTypeFilter();

            state._fsp--;

             current =iv_rulePointcutTypeFilter; 
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
    // $ANTLR end "entryRulePointcutTypeFilter"


    // $ANTLR start "rulePointcutTypeFilter"
    // InternalSimpleAspect.g:980:1: rulePointcutTypeFilter returns [EObject current=null] : ( () ( (lv_classType_1_0= ruleQualifiedName ) ) ) ;
    public final EObject rulePointcutTypeFilter() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_classType_1_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:986:2: ( ( () ( (lv_classType_1_0= ruleQualifiedName ) ) ) )
            // InternalSimpleAspect.g:987:2: ( () ( (lv_classType_1_0= ruleQualifiedName ) ) )
            {
            // InternalSimpleAspect.g:987:2: ( () ( (lv_classType_1_0= ruleQualifiedName ) ) )
            // InternalSimpleAspect.g:988:3: () ( (lv_classType_1_0= ruleQualifiedName ) )
            {
            // InternalSimpleAspect.g:988:3: ()
            // InternalSimpleAspect.g:989:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPointcutTypeFilterAccess().getPointcutTypeFilterAction_0(),
            					current);
            			

            }

            // InternalSimpleAspect.g:995:3: ( (lv_classType_1_0= ruleQualifiedName ) )
            // InternalSimpleAspect.g:996:4: (lv_classType_1_0= ruleQualifiedName )
            {
            // InternalSimpleAspect.g:996:4: (lv_classType_1_0= ruleQualifiedName )
            // InternalSimpleAspect.g:997:5: lv_classType_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getPointcutTypeFilterAccess().getClassTypeQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_classType_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointcutTypeFilterRule());
            					}
            					set(
            						current,
            						"classType",
            						lv_classType_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.QualifiedName");
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
    // $ANTLR end "rulePointcutTypeFilter"


    // $ANTLR start "entryRuleAdvice"
    // InternalSimpleAspect.g:1018:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // InternalSimpleAspect.g:1018:47: (iv_ruleAdvice= ruleAdvice EOF )
            // InternalSimpleAspect.g:1019:2: iv_ruleAdvice= ruleAdvice EOF
            {
             newCompositeNode(grammarAccess.getAdviceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;

             current =iv_ruleAdvice; 
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
    // $ANTLR end "entryRuleAdvice"


    // $ANTLR start "ruleAdvice"
    // InternalSimpleAspect.g:1025:1: ruleAdvice returns [EObject current=null] : ( () ( ( (lv_type_1_0= 'before' ) ) | ( (lv_type_2_0= 'after' ) ) | ( (lv_type_3_0= 'around' ) ) ) otherlv_4= '(' ( ( (lv_parameter_5_0= ruleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) ) )* )? otherlv_8= ')' ( ( (lv_pointcut_9_0= rulePointcutRef ) ) | ( (lv_pointcut_10_0= rulePointcut ) ) ) ( (lv_code_11_0= ruleMethodBlock ) ) ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_parameter_5_0 = null;

        EObject lv_parameter_7_0 = null;

        EObject lv_pointcut_9_0 = null;

        EObject lv_pointcut_10_0 = null;

        EObject lv_code_11_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1031:2: ( ( () ( ( (lv_type_1_0= 'before' ) ) | ( (lv_type_2_0= 'after' ) ) | ( (lv_type_3_0= 'around' ) ) ) otherlv_4= '(' ( ( (lv_parameter_5_0= ruleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) ) )* )? otherlv_8= ')' ( ( (lv_pointcut_9_0= rulePointcutRef ) ) | ( (lv_pointcut_10_0= rulePointcut ) ) ) ( (lv_code_11_0= ruleMethodBlock ) ) ) )
            // InternalSimpleAspect.g:1032:2: ( () ( ( (lv_type_1_0= 'before' ) ) | ( (lv_type_2_0= 'after' ) ) | ( (lv_type_3_0= 'around' ) ) ) otherlv_4= '(' ( ( (lv_parameter_5_0= ruleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) ) )* )? otherlv_8= ')' ( ( (lv_pointcut_9_0= rulePointcutRef ) ) | ( (lv_pointcut_10_0= rulePointcut ) ) ) ( (lv_code_11_0= ruleMethodBlock ) ) )
            {
            // InternalSimpleAspect.g:1032:2: ( () ( ( (lv_type_1_0= 'before' ) ) | ( (lv_type_2_0= 'after' ) ) | ( (lv_type_3_0= 'around' ) ) ) otherlv_4= '(' ( ( (lv_parameter_5_0= ruleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) ) )* )? otherlv_8= ')' ( ( (lv_pointcut_9_0= rulePointcutRef ) ) | ( (lv_pointcut_10_0= rulePointcut ) ) ) ( (lv_code_11_0= ruleMethodBlock ) ) )
            // InternalSimpleAspect.g:1033:3: () ( ( (lv_type_1_0= 'before' ) ) | ( (lv_type_2_0= 'after' ) ) | ( (lv_type_3_0= 'around' ) ) ) otherlv_4= '(' ( ( (lv_parameter_5_0= ruleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) ) )* )? otherlv_8= ')' ( ( (lv_pointcut_9_0= rulePointcutRef ) ) | ( (lv_pointcut_10_0= rulePointcut ) ) ) ( (lv_code_11_0= ruleMethodBlock ) )
            {
            // InternalSimpleAspect.g:1033:3: ()
            // InternalSimpleAspect.g:1034:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAdviceAccess().getAdviceAction_0(),
            					current);
            			

            }

            // InternalSimpleAspect.g:1040:3: ( ( (lv_type_1_0= 'before' ) ) | ( (lv_type_2_0= 'after' ) ) | ( (lv_type_3_0= 'around' ) ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt18=1;
                }
                break;
            case 34:
                {
                alt18=2;
                }
                break;
            case 35:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalSimpleAspect.g:1041:4: ( (lv_type_1_0= 'before' ) )
                    {
                    // InternalSimpleAspect.g:1041:4: ( (lv_type_1_0= 'before' ) )
                    // InternalSimpleAspect.g:1042:5: (lv_type_1_0= 'before' )
                    {
                    // InternalSimpleAspect.g:1042:5: (lv_type_1_0= 'before' )
                    // InternalSimpleAspect.g:1043:6: lv_type_1_0= 'before'
                    {
                    lv_type_1_0=(Token)match(input,33,FOLLOW_9); 

                    						newLeafNode(lv_type_1_0, grammarAccess.getAdviceAccess().getTypeBeforeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdviceRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_1_0, "before");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:1056:4: ( (lv_type_2_0= 'after' ) )
                    {
                    // InternalSimpleAspect.g:1056:4: ( (lv_type_2_0= 'after' ) )
                    // InternalSimpleAspect.g:1057:5: (lv_type_2_0= 'after' )
                    {
                    // InternalSimpleAspect.g:1057:5: (lv_type_2_0= 'after' )
                    // InternalSimpleAspect.g:1058:6: lv_type_2_0= 'after'
                    {
                    lv_type_2_0=(Token)match(input,34,FOLLOW_9); 

                    						newLeafNode(lv_type_2_0, grammarAccess.getAdviceAccess().getTypeAfterKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdviceRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_2_0, "after");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSimpleAspect.g:1071:4: ( (lv_type_3_0= 'around' ) )
                    {
                    // InternalSimpleAspect.g:1071:4: ( (lv_type_3_0= 'around' ) )
                    // InternalSimpleAspect.g:1072:5: (lv_type_3_0= 'around' )
                    {
                    // InternalSimpleAspect.g:1072:5: (lv_type_3_0= 'around' )
                    // InternalSimpleAspect.g:1073:6: lv_type_3_0= 'around'
                    {
                    lv_type_3_0=(Token)match(input,35,FOLLOW_9); 

                    						newLeafNode(lv_type_3_0, grammarAccess.getAdviceAccess().getTypeAroundKeyword_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdviceRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_3_0, "around");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSimpleAspect.g:1090:3: ( ( (lv_parameter_5_0= ruleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID||(LA20_0>=36 && LA20_0<=39)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalSimpleAspect.g:1091:4: ( (lv_parameter_5_0= ruleParameter ) ) (otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) ) )*
                    {
                    // InternalSimpleAspect.g:1091:4: ( (lv_parameter_5_0= ruleParameter ) )
                    // InternalSimpleAspect.g:1092:5: (lv_parameter_5_0= ruleParameter )
                    {
                    // InternalSimpleAspect.g:1092:5: (lv_parameter_5_0= ruleParameter )
                    // InternalSimpleAspect.g:1093:6: lv_parameter_5_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getAdviceAccess().getParameterParameterParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parameter_5_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAdviceRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_5_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimpleAspect.g:1110:4: (otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==19) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalSimpleAspect.g:1111:5: otherlv_6= ',' ( (lv_parameter_7_0= ruleParameter ) )
                    	    {
                    	    otherlv_6=(Token)match(input,19,FOLLOW_6); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getAdviceAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSimpleAspect.g:1115:5: ( (lv_parameter_7_0= ruleParameter ) )
                    	    // InternalSimpleAspect.g:1116:6: (lv_parameter_7_0= ruleParameter )
                    	    {
                    	    // InternalSimpleAspect.g:1116:6: (lv_parameter_7_0= ruleParameter )
                    	    // InternalSimpleAspect.g:1117:7: lv_parameter_7_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getAdviceAccess().getParameterParameterParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_parameter_7_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAdviceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_7_0,
                    	    								"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,20,FOLLOW_22); 

            			newLeafNode(otherlv_8, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_4());
            		
            // InternalSimpleAspect.g:1140:3: ( ( (lv_pointcut_9_0= rulePointcutRef ) ) | ( (lv_pointcut_10_0= rulePointcut ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            else if ( (LA21_0==17) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalSimpleAspect.g:1141:4: ( (lv_pointcut_9_0= rulePointcutRef ) )
                    {
                    // InternalSimpleAspect.g:1141:4: ( (lv_pointcut_9_0= rulePointcutRef ) )
                    // InternalSimpleAspect.g:1142:5: (lv_pointcut_9_0= rulePointcutRef )
                    {
                    // InternalSimpleAspect.g:1142:5: (lv_pointcut_9_0= rulePointcutRef )
                    // InternalSimpleAspect.g:1143:6: lv_pointcut_9_0= rulePointcutRef
                    {

                    						newCompositeNode(grammarAccess.getAdviceAccess().getPointcutPointcutRefParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_pointcut_9_0=rulePointcutRef();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAdviceRule());
                    						}
                    						set(
                    							current,
                    							"pointcut",
                    							lv_pointcut_9_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.PointcutRef");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:1161:4: ( (lv_pointcut_10_0= rulePointcut ) )
                    {
                    // InternalSimpleAspect.g:1161:4: ( (lv_pointcut_10_0= rulePointcut ) )
                    // InternalSimpleAspect.g:1162:5: (lv_pointcut_10_0= rulePointcut )
                    {
                    // InternalSimpleAspect.g:1162:5: (lv_pointcut_10_0= rulePointcut )
                    // InternalSimpleAspect.g:1163:6: lv_pointcut_10_0= rulePointcut
                    {

                    						newCompositeNode(grammarAccess.getAdviceAccess().getPointcutPointcutParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_pointcut_10_0=rulePointcut();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAdviceRule());
                    						}
                    						set(
                    							current,
                    							"pointcut",
                    							lv_pointcut_10_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Pointcut");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:1181:3: ( (lv_code_11_0= ruleMethodBlock ) )
            // InternalSimpleAspect.g:1182:4: (lv_code_11_0= ruleMethodBlock )
            {
            // InternalSimpleAspect.g:1182:4: (lv_code_11_0= ruleMethodBlock )
            // InternalSimpleAspect.g:1183:5: lv_code_11_0= ruleMethodBlock
            {

            					newCompositeNode(grammarAccess.getAdviceAccess().getCodeMethodBlockParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_code_11_0=ruleMethodBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdviceRule());
            					}
            					set(
            						current,
            						"code",
            						lv_code_11_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.MethodBlock");
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
    // $ANTLR end "ruleAdvice"


    // $ANTLR start "entryRulePointcutRef"
    // InternalSimpleAspect.g:1204:1: entryRulePointcutRef returns [EObject current=null] : iv_rulePointcutRef= rulePointcutRef EOF ;
    public final EObject entryRulePointcutRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointcutRef = null;


        try {
            // InternalSimpleAspect.g:1204:52: (iv_rulePointcutRef= rulePointcutRef EOF )
            // InternalSimpleAspect.g:1205:2: iv_rulePointcutRef= rulePointcutRef EOF
            {
             newCompositeNode(grammarAccess.getPointcutRefRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointcutRef=rulePointcutRef();

            state._fsp--;

             current =iv_rulePointcutRef; 
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
    // $ANTLR end "entryRulePointcutRef"


    // $ANTLR start "rulePointcutRef"
    // InternalSimpleAspect.g:1211:1: rulePointcutRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameterValue_2_0= ruleVariableExpression ) ) (otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject rulePointcutRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameterValue_2_0 = null;

        EObject lv_parameterValue_4_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1217:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameterValue_2_0= ruleVariableExpression ) ) (otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalSimpleAspect.g:1218:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameterValue_2_0= ruleVariableExpression ) ) (otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalSimpleAspect.g:1218:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameterValue_2_0= ruleVariableExpression ) ) (otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) ) )* )? otherlv_5= ')' )
            // InternalSimpleAspect.g:1219:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameterValue_2_0= ruleVariableExpression ) ) (otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalSimpleAspect.g:1219:3: ( (otherlv_0= RULE_ID ) )
            // InternalSimpleAspect.g:1220:4: (otherlv_0= RULE_ID )
            {
            // InternalSimpleAspect.g:1220:4: (otherlv_0= RULE_ID )
            // InternalSimpleAspect.g:1221:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPointcutRefRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(otherlv_0, grammarAccess.getPointcutRefAccess().getPointcutPointcutCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getPointcutRefAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimpleAspect.g:1236:3: ( ( (lv_parameterValue_2_0= ruleVariableExpression ) ) (otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSimpleAspect.g:1237:4: ( (lv_parameterValue_2_0= ruleVariableExpression ) ) (otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) ) )*
                    {
                    // InternalSimpleAspect.g:1237:4: ( (lv_parameterValue_2_0= ruleVariableExpression ) )
                    // InternalSimpleAspect.g:1238:5: (lv_parameterValue_2_0= ruleVariableExpression )
                    {
                    // InternalSimpleAspect.g:1238:5: (lv_parameterValue_2_0= ruleVariableExpression )
                    // InternalSimpleAspect.g:1239:6: lv_parameterValue_2_0= ruleVariableExpression
                    {

                    						newCompositeNode(grammarAccess.getPointcutRefAccess().getParameterValueVariableExpressionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parameterValue_2_0=ruleVariableExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointcutRefRule());
                    						}
                    						add(
                    							current,
                    							"parameterValue",
                    							lv_parameterValue_2_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.VariableExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimpleAspect.g:1256:4: (otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==19) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalSimpleAspect.g:1257:5: otherlv_3= ',' ( (lv_parameterValue_4_0= ruleVariableExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_6); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getPointcutRefAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalSimpleAspect.g:1261:5: ( (lv_parameterValue_4_0= ruleVariableExpression ) )
                    	    // InternalSimpleAspect.g:1262:6: (lv_parameterValue_4_0= ruleVariableExpression )
                    	    {
                    	    // InternalSimpleAspect.g:1262:6: (lv_parameterValue_4_0= ruleVariableExpression )
                    	    // InternalSimpleAspect.g:1263:7: lv_parameterValue_4_0= ruleVariableExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getPointcutRefAccess().getParameterValueVariableExpressionParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_parameterValue_4_0=ruleVariableExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPointcutRefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameterValue",
                    	    								lv_parameterValue_4_0,
                    	    								"at.ac.tuwien.big.simpleaspect.SimpleAspect.VariableExpression");
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

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getPointcutRefAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "rulePointcutRef"


    // $ANTLR start "entryRuleParameter"
    // InternalSimpleAspect.g:1290:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSimpleAspect.g:1290:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSimpleAspect.g:1291:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalSimpleAspect.g:1297:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1303:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSimpleAspect.g:1304:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSimpleAspect.g:1304:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSimpleAspect.g:1305:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSimpleAspect.g:1305:3: ( (lv_type_0_0= ruleType ) )
            // InternalSimpleAspect.g:1306:4: (lv_type_0_0= ruleType )
            {
            // InternalSimpleAspect.g:1306:4: (lv_type_0_0= ruleType )
            // InternalSimpleAspect.g:1307:5: lv_type_0_0= ruleType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimpleAspect.g:1324:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleAspect.g:1325:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleAspect.g:1325:4: (lv_name_1_0= RULE_ID )
            // InternalSimpleAspect.g:1326:5: lv_name_1_0= RULE_ID
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
    // InternalSimpleAspect.g:1346:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalSimpleAspect.g:1346:45: (iv_ruleType= ruleType EOF )
            // InternalSimpleAspect.g:1347:2: iv_ruleType= ruleType EOF
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
    // InternalSimpleAspect.g:1353:1: ruleType returns [EObject current=null] : ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) ) | ( (lv_typeRef_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;
        AntlrDatatypeRuleToken lv_typeRef_1_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1359:2: ( ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) ) | ( (lv_typeRef_1_0= ruleQualifiedName ) ) ) )
            // InternalSimpleAspect.g:1360:2: ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) ) | ( (lv_typeRef_1_0= ruleQualifiedName ) ) )
            {
            // InternalSimpleAspect.g:1360:2: ( ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) ) | ( (lv_typeRef_1_0= ruleQualifiedName ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=36 && LA25_0<=39)) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalSimpleAspect.g:1361:3: ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) )
                    {
                    // InternalSimpleAspect.g:1361:3: ( ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) ) )
                    // InternalSimpleAspect.g:1362:4: ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) )
                    {
                    // InternalSimpleAspect.g:1362:4: ( (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' ) )
                    // InternalSimpleAspect.g:1363:5: (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' )
                    {
                    // InternalSimpleAspect.g:1363:5: (lv_typeName_0_1= 'int' | lv_typeName_0_2= 'double' | lv_typeName_0_3= 'String' | lv_typeName_0_4= 'boolean' )
                    int alt24=4;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt24=1;
                        }
                        break;
                    case 37:
                        {
                        alt24=2;
                        }
                        break;
                    case 38:
                        {
                        alt24=3;
                        }
                        break;
                    case 39:
                        {
                        alt24=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // InternalSimpleAspect.g:1364:6: lv_typeName_0_1= 'int'
                            {
                            lv_typeName_0_1=(Token)match(input,36,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_1, grammarAccess.getTypeAccess().getTypeNameIntKeyword_0_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalSimpleAspect.g:1375:6: lv_typeName_0_2= 'double'
                            {
                            lv_typeName_0_2=(Token)match(input,37,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_2, grammarAccess.getTypeAccess().getTypeNameDoubleKeyword_0_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalSimpleAspect.g:1386:6: lv_typeName_0_3= 'String'
                            {
                            lv_typeName_0_3=(Token)match(input,38,FOLLOW_2); 

                            						newLeafNode(lv_typeName_0_3, grammarAccess.getTypeAccess().getTypeNameStringKeyword_0_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTypeRule());
                            						}
                            						setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                            					

                            }
                            break;
                        case 4 :
                            // InternalSimpleAspect.g:1397:6: lv_typeName_0_4= 'boolean'
                            {
                            lv_typeName_0_4=(Token)match(input,39,FOLLOW_2); 

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
                    // InternalSimpleAspect.g:1411:3: ( (lv_typeRef_1_0= ruleQualifiedName ) )
                    {
                    // InternalSimpleAspect.g:1411:3: ( (lv_typeRef_1_0= ruleQualifiedName ) )
                    // InternalSimpleAspect.g:1412:4: (lv_typeRef_1_0= ruleQualifiedName )
                    {
                    // InternalSimpleAspect.g:1412:4: (lv_typeRef_1_0= ruleQualifiedName )
                    // InternalSimpleAspect.g:1413:5: lv_typeRef_1_0= ruleQualifiedName
                    {

                    					newCompositeNode(grammarAccess.getTypeAccess().getTypeRefQualifiedNameParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_typeRef_1_0=ruleQualifiedName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTypeRule());
                    					}
                    					set(
                    						current,
                    						"typeRef",
                    						lv_typeRef_1_0,
                    						"at.ac.tuwien.big.simpleaspect.SimpleAspect.QualifiedName");
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
    // InternalSimpleAspect.g:1434:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalSimpleAspect.g:1434:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalSimpleAspect.g:1435:2: iv_ruleMethod= ruleMethod EOF
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
    // InternalSimpleAspect.g:1441:1: ruleMethod returns [EObject current=null] : (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) ) ) ;
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
            // InternalSimpleAspect.g:1447:2: ( (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) ) ) )
            // InternalSimpleAspect.g:1448:2: (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) ) )
            {
            // InternalSimpleAspect.g:1448:2: (otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) ) )
            // InternalSimpleAspect.g:1449:3: otherlv_0= 'public' ( (lv_static_1_0= 'static' ) )? (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) ) ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )? otherlv_9= ')' ( (lv_content_10_0= ruleMethodBlock ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_24); 

            			newLeafNode(otherlv_0, grammarAccess.getMethodAccess().getPublicKeyword_0());
            		
            // InternalSimpleAspect.g:1453:3: ( (lv_static_1_0= 'static' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==30) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSimpleAspect.g:1454:4: (lv_static_1_0= 'static' )
                    {
                    // InternalSimpleAspect.g:1454:4: (lv_static_1_0= 'static' )
                    // InternalSimpleAspect.g:1455:5: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,30,FOLLOW_25); 

                    					newLeafNode(lv_static_1_0, grammarAccess.getMethodAccess().getStaticStaticKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodRule());
                    					}
                    					setWithLastConsumed(current, "static", true, "static");
                    				

                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:1467:3: (otherlv_2= 'void' | ( (lv_returnType_3_0= ruleType ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_ID||(LA27_0>=36 && LA27_0<=39)) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalSimpleAspect.g:1468:4: otherlv_2= 'void'
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getVoidKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSimpleAspect.g:1473:4: ( (lv_returnType_3_0= ruleType ) )
                    {
                    // InternalSimpleAspect.g:1473:4: ( (lv_returnType_3_0= ruleType ) )
                    // InternalSimpleAspect.g:1474:5: (lv_returnType_3_0= ruleType )
                    {
                    // InternalSimpleAspect.g:1474:5: (lv_returnType_3_0= ruleType )
                    // InternalSimpleAspect.g:1475:6: lv_returnType_3_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getReturnTypeTypeParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_returnType_3_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodRule());
                    						}
                    						set(
                    							current,
                    							"returnType",
                    							lv_returnType_3_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:1493:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalSimpleAspect.g:1494:4: (lv_name_4_0= RULE_ID )
            {
            // InternalSimpleAspect.g:1494:4: (lv_name_4_0= RULE_ID )
            // InternalSimpleAspect.g:1495:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_5=(Token)match(input,18,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSimpleAspect.g:1515:3: ( ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID||(LA29_0>=36 && LA29_0<=39)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalSimpleAspect.g:1516:4: ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )*
                    {
                    // InternalSimpleAspect.g:1516:4: ( (lv_parameter_6_0= ruleParameter ) )
                    // InternalSimpleAspect.g:1517:5: (lv_parameter_6_0= ruleParameter )
                    {
                    // InternalSimpleAspect.g:1517:5: (lv_parameter_6_0= ruleParameter )
                    // InternalSimpleAspect.g:1518:6: lv_parameter_6_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getParameterParameterParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parameter_6_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_6_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimpleAspect.g:1535:4: (otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==19) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalSimpleAspect.g:1536:5: otherlv_7= ',' ( (lv_parameter_8_0= ruleParameter ) )
                    	    {
                    	    otherlv_7=(Token)match(input,19,FOLLOW_6); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getMethodAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalSimpleAspect.g:1540:5: ( (lv_parameter_8_0= ruleParameter ) )
                    	    // InternalSimpleAspect.g:1541:6: (lv_parameter_8_0= ruleParameter )
                    	    {
                    	    // InternalSimpleAspect.g:1541:6: (lv_parameter_8_0= ruleParameter )
                    	    // InternalSimpleAspect.g:1542:7: lv_parameter_8_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodAccess().getParameterParameterParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_parameter_8_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMethodRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_8_0,
                    	    								"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_23); 

            			newLeafNode(otherlv_9, grammarAccess.getMethodAccess().getRightParenthesisKeyword_6());
            		
            // InternalSimpleAspect.g:1565:3: ( (lv_content_10_0= ruleMethodBlock ) )
            // InternalSimpleAspect.g:1566:4: (lv_content_10_0= ruleMethodBlock )
            {
            // InternalSimpleAspect.g:1566:4: (lv_content_10_0= ruleMethodBlock )
            // InternalSimpleAspect.g:1567:5: lv_content_10_0= ruleMethodBlock
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
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.MethodBlock");
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
    // InternalSimpleAspect.g:1588:1: entryRuleMethodBlock returns [EObject current=null] : iv_ruleMethodBlock= ruleMethodBlock EOF ;
    public final EObject entryRuleMethodBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodBlock = null;


        try {
            // InternalSimpleAspect.g:1588:52: (iv_ruleMethodBlock= ruleMethodBlock EOF )
            // InternalSimpleAspect.g:1589:2: iv_ruleMethodBlock= ruleMethodBlock EOF
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
    // InternalSimpleAspect.g:1595:1: ruleMethodBlock returns [EObject current=null] : ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) ) ;
    public final EObject ruleMethodBlock() throws RecognitionException {
        EObject current = null;

        Token lv_generated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statements_3_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1601:2: ( ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) ) )
            // InternalSimpleAspect.g:1602:2: ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) )
            {
            // InternalSimpleAspect.g:1602:2: ( () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' ) )
            // InternalSimpleAspect.g:1603:3: () ( (lv_generated_1_0= 'pointcutblock' ) )? (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' )
            {
            // InternalSimpleAspect.g:1603:3: ()
            // InternalSimpleAspect.g:1604:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodBlockAccess().getMethodBlockAction_0(),
            					current);
            			

            }

            // InternalSimpleAspect.g:1610:3: ( (lv_generated_1_0= 'pointcutblock' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==41) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalSimpleAspect.g:1611:4: (lv_generated_1_0= 'pointcutblock' )
                    {
                    // InternalSimpleAspect.g:1611:4: (lv_generated_1_0= 'pointcutblock' )
                    // InternalSimpleAspect.g:1612:5: lv_generated_1_0= 'pointcutblock'
                    {
                    lv_generated_1_0=(Token)match(input,41,FOLLOW_4); 

                    					newLeafNode(lv_generated_1_0, grammarAccess.getMethodBlockAccess().getGeneratedPointcutblockKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMethodBlockRule());
                    					}
                    					setWithLastConsumed(current, "generated", true, "pointcutblock");
                    				

                    }


                    }
                    break;

            }

            // InternalSimpleAspect.g:1624:3: (otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}' )
            // InternalSimpleAspect.g:1625:4: otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* otherlv_4= '}'
            {
            otherlv_2=(Token)match(input,12,FOLLOW_26); 

            				newLeafNode(otherlv_2, grammarAccess.getMethodBlockAccess().getLeftCurlyBracketKeyword_2_0());
            			
            // InternalSimpleAspect.g:1629:4: ( (lv_statements_3_0= ruleStatement ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID||LA31_0==12||(LA31_0>=36 && LA31_0<=39)||LA31_0==41||LA31_0==43||(LA31_0>=45 && LA31_0<=48)||(LA31_0>=50 && LA31_0<=52)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalSimpleAspect.g:1630:5: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalSimpleAspect.g:1630:5: (lv_statements_3_0= ruleStatement )
            	    // InternalSimpleAspect.g:1631:6: lv_statements_3_0= ruleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getMethodBlockAccess().getStatementsStatementParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMethodBlockRule());
            	    						}
            	    						add(
            	    							current,
            	    							"statements",
            	    							lv_statements_3_0,
            	    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.Statement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

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
    // InternalSimpleAspect.g:1657:1: entryRuleSimpleStatement returns [EObject current=null] : iv_ruleSimpleStatement= ruleSimpleStatement EOF ;
    public final EObject entryRuleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleStatement = null;


        try {
            // InternalSimpleAspect.g:1657:56: (iv_ruleSimpleStatement= ruleSimpleStatement EOF )
            // InternalSimpleAspect.g:1658:2: iv_ruleSimpleStatement= ruleSimpleStatement EOF
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
    // InternalSimpleAspect.g:1664:1: ruleSimpleStatement returns [EObject current=null] : (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment ) ;
    public final EObject ruleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleVariableDeclaration_0 = null;

        EObject this_Assignment_1 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1670:2: ( (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment ) )
            // InternalSimpleAspect.g:1671:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )
            {
            // InternalSimpleAspect.g:1671:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalSimpleAspect.g:1672:3: this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration
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
                    // InternalSimpleAspect.g:1681:3: this_Assignment_1= ruleAssignment
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
    // InternalSimpleAspect.g:1693:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalSimpleAspect.g:1693:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalSimpleAspect.g:1694:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalSimpleAspect.g:1700:1: ruleStatement returns [EObject current=null] : (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall ) ;
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
            // InternalSimpleAspect.g:1706:2: ( (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall ) )
            // InternalSimpleAspect.g:1707:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall )
            {
            // InternalSimpleAspect.g:1707:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall )
            int alt33=9;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // InternalSimpleAspect.g:1708:3: this_MethodBlock_0= ruleMethodBlock
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
                    // InternalSimpleAspect.g:1717:3: this_VariableDeclaration_1= ruleVariableDeclaration
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
                    // InternalSimpleAspect.g:1726:3: this_Assignment_2= ruleAssignment
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
                    // InternalSimpleAspect.g:1735:3: this_IfStatement_3= ruleIfStatement
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
                    // InternalSimpleAspect.g:1744:3: this_ForStatement_4= ruleForStatement
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
                    // InternalSimpleAspect.g:1753:3: this_ForInStatement_5= ruleForInStatement
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
                    // InternalSimpleAspect.g:1762:3: this_WhileStatement_6= ruleWhileStatement
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
                    // InternalSimpleAspect.g:1771:3: this_ReturnStatement_7= ruleReturnStatement
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
                    // InternalSimpleAspect.g:1780:3: this_MethodCall_8= ruleMethodCall
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
    // InternalSimpleAspect.g:1792:1: entryRuleSimpleVariableDeclaration returns [EObject current=null] : iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF ;
    public final EObject entryRuleSimpleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleVariableDeclaration = null;


        try {
            // InternalSimpleAspect.g:1792:66: (iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF )
            // InternalSimpleAspect.g:1793:2: iv_ruleSimpleVariableDeclaration= ruleSimpleVariableDeclaration EOF
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
    // InternalSimpleAspect.g:1799:1: ruleSimpleVariableDeclaration returns [EObject current=null] : ( () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleSimpleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_parameter_1_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1805:2: ( ( () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) ) )
            // InternalSimpleAspect.g:1806:2: ( () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            {
            // InternalSimpleAspect.g:1806:2: ( () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) ) )
            // InternalSimpleAspect.g:1807:3: () ( (lv_parameter_1_0= ruleParameter ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleGenericExpression ) )
            {
            // InternalSimpleAspect.g:1807:3: ()
            // InternalSimpleAspect.g:1808:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleVariableDeclarationAccess().getVariableDeclarationAction_0(),
            					current);
            			

            }

            // InternalSimpleAspect.g:1814:3: ( (lv_parameter_1_0= ruleParameter ) )
            // InternalSimpleAspect.g:1815:4: (lv_parameter_1_0= ruleParameter )
            {
            // InternalSimpleAspect.g:1815:4: (lv_parameter_1_0= ruleParameter )
            // InternalSimpleAspect.g:1816:5: lv_parameter_1_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getSimpleVariableDeclarationAccess().getParameterParameterParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_parameter_1_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleVariableDeclarationRule());
            					}
            					set(
            						current,
            						"parameter",
            						lv_parameter_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleVariableDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalSimpleAspect.g:1837:3: ( (lv_expression_3_0= ruleGenericExpression ) )
            // InternalSimpleAspect.g:1838:4: (lv_expression_3_0= ruleGenericExpression )
            {
            // InternalSimpleAspect.g:1838:4: (lv_expression_3_0= ruleGenericExpression )
            // InternalSimpleAspect.g:1839:5: lv_expression_3_0= ruleGenericExpression
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
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
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
    // InternalSimpleAspect.g:1860:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalSimpleAspect.g:1860:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalSimpleAspect.g:1861:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalSimpleAspect.g:1867:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parameter_0_0 = null;

        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1873:2: ( ( ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) )
            // InternalSimpleAspect.g:1874:2: ( ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            {
            // InternalSimpleAspect.g:1874:2: ( ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            // InternalSimpleAspect.g:1875:3: ( (lv_parameter_0_0= ruleParameter ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';'
            {
            // InternalSimpleAspect.g:1875:3: ( (lv_parameter_0_0= ruleParameter ) )
            // InternalSimpleAspect.g:1876:4: (lv_parameter_0_0= ruleParameter )
            {
            // InternalSimpleAspect.g:1876:4: (lv_parameter_0_0= ruleParameter )
            // InternalSimpleAspect.g:1877:5: lv_parameter_0_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getParameterParameterParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_27);
            lv_parameter_0_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            					}
            					set(
            						current,
            						"parameter",
            						lv_parameter_0_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,42,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_1());
            		
            // InternalSimpleAspect.g:1898:3: ( (lv_expression_2_0= ruleGenericExpression ) )
            // InternalSimpleAspect.g:1899:4: (lv_expression_2_0= ruleGenericExpression )
            {
            // InternalSimpleAspect.g:1899:4: (lv_expression_2_0= ruleGenericExpression )
            // InternalSimpleAspect.g:1900:5: lv_expression_2_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionGenericExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_2_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_2_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSimpleAspect.g:1925:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalSimpleAspect.g:1925:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalSimpleAspect.g:1926:2: iv_ruleAssignment= ruleAssignment EOF
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
    // InternalSimpleAspect.g:1932:1: ruleAssignment returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:1938:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' ) )
            // InternalSimpleAspect.g:1939:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            {
            // InternalSimpleAspect.g:1939:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';' )
            // InternalSimpleAspect.g:1940:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleGenericExpression ) ) otherlv_3= ';'
            {
            // InternalSimpleAspect.g:1940:3: ( ( ruleQualifiedName ) )
            // InternalSimpleAspect.g:1941:4: ( ruleQualifiedName )
            {
            // InternalSimpleAspect.g:1941:4: ( ruleQualifiedName )
            // InternalSimpleAspect.g:1942:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssignmentAccess().getParameterParameterCrossReference_0_0());
            				
            pushFollow(FOLLOW_27);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,42,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
            		
            // InternalSimpleAspect.g:1960:3: ( (lv_expression_2_0= ruleGenericExpression ) )
            // InternalSimpleAspect.g:1961:4: (lv_expression_2_0= ruleGenericExpression )
            {
            // InternalSimpleAspect.g:1961:4: (lv_expression_2_0= ruleGenericExpression )
            // InternalSimpleAspect.g:1962:5: lv_expression_2_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionGenericExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_2_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_2_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSimpleAspect.g:1987:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalSimpleAspect.g:1987:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalSimpleAspect.g:1988:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalSimpleAspect.g:1994:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_condition_1_0 = null;

        EObject lv_then_2_0 = null;

        EObject lv_else_4_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:2000:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? ) )
            // InternalSimpleAspect.g:2001:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? )
            {
            // InternalSimpleAspect.g:2001:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )? )
            // InternalSimpleAspect.g:2002:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_then_2_0= ruleMethodBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )?
            {
            otherlv_0=(Token)match(input,43,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
            		
            // InternalSimpleAspect.g:2006:3: ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) )
            // InternalSimpleAspect.g:2007:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            {
            // InternalSimpleAspect.g:2007:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            // InternalSimpleAspect.g:2008:5: lv_condition_1_0= ruleParanthesisOrBinaryExpression
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getConditionParanthesisOrBinaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_23);
            lv_condition_1_0=ruleParanthesisOrBinaryExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.ParanthesisOrBinaryExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimpleAspect.g:2025:3: ( (lv_then_2_0= ruleMethodBlock ) )
            // InternalSimpleAspect.g:2026:4: (lv_then_2_0= ruleMethodBlock )
            {
            // InternalSimpleAspect.g:2026:4: (lv_then_2_0= ruleMethodBlock )
            // InternalSimpleAspect.g:2027:5: lv_then_2_0= ruleMethodBlock
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getThenMethodBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_29);
            lv_then_2_0=ruleMethodBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					set(
            						current,
            						"then",
            						lv_then_2_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.MethodBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimpleAspect.g:2044:3: (otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==44) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalSimpleAspect.g:2045:4: otherlv_3= 'else' ( (lv_else_4_0= ruleMethodBlock ) )
                    {
                    otherlv_3=(Token)match(input,44,FOLLOW_23); 

                    				newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getElseKeyword_3_0());
                    			
                    // InternalSimpleAspect.g:2049:4: ( (lv_else_4_0= ruleMethodBlock ) )
                    // InternalSimpleAspect.g:2050:5: (lv_else_4_0= ruleMethodBlock )
                    {
                    // InternalSimpleAspect.g:2050:5: (lv_else_4_0= ruleMethodBlock )
                    // InternalSimpleAspect.g:2051:6: lv_else_4_0= ruleMethodBlock
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
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.MethodBlock");
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
    // InternalSimpleAspect.g:2073:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalSimpleAspect.g:2073:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalSimpleAspect.g:2074:2: iv_ruleForStatement= ruleForStatement EOF
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
    // InternalSimpleAspect.g:2080:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) ) ;
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
            // InternalSimpleAspect.g:2086:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) ) )
            // InternalSimpleAspect.g:2087:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) )
            {
            // InternalSimpleAspect.g:2087:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) ) )
            // InternalSimpleAspect.g:2088:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_init_2_0= ruleSimpleStatement ) )? otherlv_3= ';' ( (lv_condition_4_0= ruleGenericExpression ) ) otherlv_5= ';' ( (lv_continuation_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimpleAspect.g:2096:3: ( (lv_init_2_0= ruleSimpleStatement ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID||(LA35_0>=36 && LA35_0<=39)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalSimpleAspect.g:2097:4: (lv_init_2_0= ruleSimpleStatement )
                    {
                    // InternalSimpleAspect.g:2097:4: (lv_init_2_0= ruleSimpleStatement )
                    // InternalSimpleAspect.g:2098:5: lv_init_2_0= ruleSimpleStatement
                    {

                    					newCompositeNode(grammarAccess.getForStatementAccess().getInitSimpleStatementParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_8);
                    lv_init_2_0=ruleSimpleStatement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getForStatementRule());
                    					}
                    					set(
                    						current,
                    						"init",
                    						lv_init_2_0,
                    						"at.ac.tuwien.big.simpleaspect.SimpleAspect.SimpleStatement");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,16,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getForStatementAccess().getSemicolonKeyword_3());
            		
            // InternalSimpleAspect.g:2119:3: ( (lv_condition_4_0= ruleGenericExpression ) )
            // InternalSimpleAspect.g:2120:4: (lv_condition_4_0= ruleGenericExpression )
            {
            // InternalSimpleAspect.g:2120:4: (lv_condition_4_0= ruleGenericExpression )
            // InternalSimpleAspect.g:2121:5: lv_condition_4_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getConditionGenericExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_8);
            lv_condition_4_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_4_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getForStatementAccess().getSemicolonKeyword_5());
            		
            // InternalSimpleAspect.g:2142:3: ( (lv_continuation_6_0= ruleSimpleStatement ) )
            // InternalSimpleAspect.g:2143:4: (lv_continuation_6_0= ruleSimpleStatement )
            {
            // InternalSimpleAspect.g:2143:4: (lv_continuation_6_0= ruleSimpleStatement )
            // InternalSimpleAspect.g:2144:5: lv_continuation_6_0= ruleSimpleStatement
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getContinuationSimpleStatementParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_14);
            lv_continuation_6_0=ruleSimpleStatement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"continuation",
            						lv_continuation_6_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.SimpleStatement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_31); 

            			newLeafNode(otherlv_7, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());
            		
            // InternalSimpleAspect.g:2165:3: ( (lv_body_8_0= ruleStatement ) )
            // InternalSimpleAspect.g:2166:4: (lv_body_8_0= ruleStatement )
            {
            // InternalSimpleAspect.g:2166:4: (lv_body_8_0= ruleStatement )
            // InternalSimpleAspect.g:2167:5: lv_body_8_0= ruleStatement
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
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.Statement");
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
    // InternalSimpleAspect.g:2188:1: entryRuleForInStatement returns [EObject current=null] : iv_ruleForInStatement= ruleForInStatement EOF ;
    public final EObject entryRuleForInStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForInStatement = null;


        try {
            // InternalSimpleAspect.g:2188:55: (iv_ruleForInStatement= ruleForInStatement EOF )
            // InternalSimpleAspect.g:2189:2: iv_ruleForInStatement= ruleForInStatement EOF
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
    // InternalSimpleAspect.g:2195:1: ruleForInStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) ) ;
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
            // InternalSimpleAspect.g:2201:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) ) )
            // InternalSimpleAspect.g:2202:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) )
            {
            // InternalSimpleAspect.g:2202:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) ) )
            // InternalSimpleAspect.g:2203:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_subparameter_2_0= ruleParameter ) ) otherlv_3= ':' ( (lv_expression_4_0= ruleGenericExpression ) ) otherlv_5= ')' ( (lv_body_6_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getForInStatementAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getForInStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimpleAspect.g:2211:3: ( (lv_subparameter_2_0= ruleParameter ) )
            // InternalSimpleAspect.g:2212:4: (lv_subparameter_2_0= ruleParameter )
            {
            // InternalSimpleAspect.g:2212:4: (lv_subparameter_2_0= ruleParameter )
            // InternalSimpleAspect.g:2213:5: lv_subparameter_2_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getSubparameterParameterParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_subparameter_2_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForInStatementRule());
            					}
            					set(
            						current,
            						"subparameter",
            						lv_subparameter_2_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getForInStatementAccess().getColonKeyword_3());
            		
            // InternalSimpleAspect.g:2234:3: ( (lv_expression_4_0= ruleGenericExpression ) )
            // InternalSimpleAspect.g:2235:4: (lv_expression_4_0= ruleGenericExpression )
            {
            // InternalSimpleAspect.g:2235:4: (lv_expression_4_0= ruleGenericExpression )
            // InternalSimpleAspect.g:2236:5: lv_expression_4_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getForInStatementAccess().getExpressionGenericExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_14);
            lv_expression_4_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForInStatementRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_4_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_31); 

            			newLeafNode(otherlv_5, grammarAccess.getForInStatementAccess().getRightParenthesisKeyword_5());
            		
            // InternalSimpleAspect.g:2257:3: ( (lv_body_6_0= ruleStatement ) )
            // InternalSimpleAspect.g:2258:4: (lv_body_6_0= ruleStatement )
            {
            // InternalSimpleAspect.g:2258:4: (lv_body_6_0= ruleStatement )
            // InternalSimpleAspect.g:2259:5: lv_body_6_0= ruleStatement
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
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.Statement");
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
    // InternalSimpleAspect.g:2280:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalSimpleAspect.g:2280:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalSimpleAspect.g:2281:2: iv_ruleWhileStatement= ruleWhileStatement EOF
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
    // InternalSimpleAspect.g:2287:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;

        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:2293:2: ( (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) ) )
            // InternalSimpleAspect.g:2294:2: (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) )
            {
            // InternalSimpleAspect.g:2294:2: (otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) ) )
            // InternalSimpleAspect.g:2295:3: otherlv_0= 'while' ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) ) ( (lv_body_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
            		
            // InternalSimpleAspect.g:2299:3: ( (lv_condition_1_0= ruleParanthesisOrBinaryExpression ) )
            // InternalSimpleAspect.g:2300:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            {
            // InternalSimpleAspect.g:2300:4: (lv_condition_1_0= ruleParanthesisOrBinaryExpression )
            // InternalSimpleAspect.g:2301:5: lv_condition_1_0= ruleParanthesisOrBinaryExpression
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionParanthesisOrBinaryExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_31);
            lv_condition_1_0=ruleParanthesisOrBinaryExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.ParanthesisOrBinaryExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimpleAspect.g:2318:3: ( (lv_body_2_0= ruleStatement ) )
            // InternalSimpleAspect.g:2319:4: (lv_body_2_0= ruleStatement )
            {
            // InternalSimpleAspect.g:2319:4: (lv_body_2_0= ruleStatement )
            // InternalSimpleAspect.g:2320:5: lv_body_2_0= ruleStatement
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
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.Statement");
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
    // InternalSimpleAspect.g:2341:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // InternalSimpleAspect.g:2341:56: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // InternalSimpleAspect.g:2342:2: iv_ruleReturnStatement= ruleReturnStatement EOF
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
    // InternalSimpleAspect.g:2348:1: ruleReturnStatement returns [EObject current=null] : (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:2354:2: ( (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' ) )
            // InternalSimpleAspect.g:2355:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' )
            {
            // InternalSimpleAspect.g:2355:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';' )
            // InternalSimpleAspect.g:2356:3: otherlv_0= 'return' ( (lv_expression_1_0= ruleGenericExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getReturnStatementAccess().getReturnKeyword_0());
            		
            // InternalSimpleAspect.g:2360:3: ( (lv_expression_1_0= ruleGenericExpression ) )
            // InternalSimpleAspect.g:2361:4: (lv_expression_1_0= ruleGenericExpression )
            {
            // InternalSimpleAspect.g:2361:4: (lv_expression_1_0= ruleGenericExpression )
            // InternalSimpleAspect.g:2362:5: lv_expression_1_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionGenericExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_1_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReturnStatementRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSimpleAspect.g:2387:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSimpleAspect.g:2387:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSimpleAspect.g:2388:2: iv_ruleMethodCall= ruleMethodCall EOF
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
    // InternalSimpleAspect.g:2394:1: ruleMethodCall returns [EObject current=null] : ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';' ) ;
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
            // InternalSimpleAspect.g:2400:2: ( ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';' ) )
            // InternalSimpleAspect.g:2401:2: ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';' )
            {
            // InternalSimpleAspect.g:2401:2: ( ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';' )
            // InternalSimpleAspect.g:2402:3: ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) ) otherlv_6= '(' ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )? otherlv_10= ')' otherlv_11= ';'
            {
            // InternalSimpleAspect.g:2402:3: ( ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) ) | ( (lv_methodName_5_0= 'System.out.println' ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID||LA40_0==48||(LA40_0>=50 && LA40_0<=51)) ) {
                alt40=1;
            }
            else if ( (LA40_0==52) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalSimpleAspect.g:2403:4: ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) )
                    {
                    // InternalSimpleAspect.g:2403:4: ( ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) ) )
                    // InternalSimpleAspect.g:2404:5: ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )? ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) )
                    {
                    // InternalSimpleAspect.g:2404:5: ( ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.' )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==RULE_ID) ) {
                        int LA37_1 = input.LA(2);

                        if ( (LA37_1==49) ) {
                            alt37=1;
                        }
                    }
                    else if ( (LA37_0==48) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalSimpleAspect.g:2405:6: ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) ) otherlv_2= '.'
                            {
                            // InternalSimpleAspect.g:2405:6: ( ( ( ruleQualifiedName ) ) | ( (lv_thisObject_1_0= 'this' ) ) )
                            int alt36=2;
                            int LA36_0 = input.LA(1);

                            if ( (LA36_0==RULE_ID) ) {
                                alt36=1;
                            }
                            else if ( (LA36_0==48) ) {
                                alt36=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 36, 0, input);

                                throw nvae;
                            }
                            switch (alt36) {
                                case 1 :
                                    // InternalSimpleAspect.g:2406:7: ( ( ruleQualifiedName ) )
                                    {
                                    // InternalSimpleAspect.g:2406:7: ( ( ruleQualifiedName ) )
                                    // InternalSimpleAspect.g:2407:8: ( ruleQualifiedName )
                                    {
                                    // InternalSimpleAspect.g:2407:8: ( ruleQualifiedName )
                                    // InternalSimpleAspect.g:2408:9: ruleQualifiedName
                                    {

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getMethodCallRule());
                                    									}
                                    								

                                    									newCompositeNode(grammarAccess.getMethodCallAccess().getObjectParameterCrossReference_0_0_0_0_0_0());
                                    								
                                    pushFollow(FOLLOW_32);
                                    ruleQualifiedName();

                                    state._fsp--;


                                    									afterParserOrEnumRuleCall();
                                    								

                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalSimpleAspect.g:2423:7: ( (lv_thisObject_1_0= 'this' ) )
                                    {
                                    // InternalSimpleAspect.g:2423:7: ( (lv_thisObject_1_0= 'this' ) )
                                    // InternalSimpleAspect.g:2424:8: (lv_thisObject_1_0= 'this' )
                                    {
                                    // InternalSimpleAspect.g:2424:8: (lv_thisObject_1_0= 'this' )
                                    // InternalSimpleAspect.g:2425:9: lv_thisObject_1_0= 'this'
                                    {
                                    lv_thisObject_1_0=(Token)match(input,48,FOLLOW_32); 

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

                            otherlv_2=(Token)match(input,49,FOLLOW_33); 

                            						newLeafNode(otherlv_2, grammarAccess.getMethodCallAccess().getFullStopKeyword_0_0_0_1());
                            					

                            }
                            break;

                    }

                    // InternalSimpleAspect.g:2443:5: ( ( (otherlv_3= RULE_ID ) ) | ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) ) )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==RULE_ID) ) {
                        alt39=1;
                    }
                    else if ( ((LA39_0>=50 && LA39_0<=51)) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalSimpleAspect.g:2444:6: ( (otherlv_3= RULE_ID ) )
                            {
                            // InternalSimpleAspect.g:2444:6: ( (otherlv_3= RULE_ID ) )
                            // InternalSimpleAspect.g:2445:7: (otherlv_3= RULE_ID )
                            {
                            // InternalSimpleAspect.g:2445:7: (otherlv_3= RULE_ID )
                            // InternalSimpleAspect.g:2446:8: otherlv_3= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getMethodCallRule());
                            								}
                            							
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_9); 

                            								newLeafNode(otherlv_3, grammarAccess.getMethodCallAccess().getMethodMethodCrossReference_0_0_1_0_0());
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSimpleAspect.g:2458:6: ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) )
                            {
                            // InternalSimpleAspect.g:2458:6: ( ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) ) )
                            // InternalSimpleAspect.g:2459:7: ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) )
                            {
                            // InternalSimpleAspect.g:2459:7: ( (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' ) )
                            // InternalSimpleAspect.g:2460:8: (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' )
                            {
                            // InternalSimpleAspect.g:2460:8: (lv_methodName_4_1= 'equals' | lv_methodName_4_2= 'hashCode' )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==50) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==51) ) {
                                alt38=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 38, 0, input);

                                throw nvae;
                            }
                            switch (alt38) {
                                case 1 :
                                    // InternalSimpleAspect.g:2461:9: lv_methodName_4_1= 'equals'
                                    {
                                    lv_methodName_4_1=(Token)match(input,50,FOLLOW_9); 

                                    									newLeafNode(lv_methodName_4_1, grammarAccess.getMethodCallAccess().getMethodNameEqualsKeyword_0_0_1_1_0_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getMethodCallRule());
                                    									}
                                    									setWithLastConsumed(current, "methodName", lv_methodName_4_1, null);
                                    								

                                    }
                                    break;
                                case 2 :
                                    // InternalSimpleAspect.g:2472:9: lv_methodName_4_2= 'hashCode'
                                    {
                                    lv_methodName_4_2=(Token)match(input,51,FOLLOW_9); 

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
                    // InternalSimpleAspect.g:2488:4: ( (lv_methodName_5_0= 'System.out.println' ) )
                    {
                    // InternalSimpleAspect.g:2488:4: ( (lv_methodName_5_0= 'System.out.println' ) )
                    // InternalSimpleAspect.g:2489:5: (lv_methodName_5_0= 'System.out.println' )
                    {
                    // InternalSimpleAspect.g:2489:5: (lv_methodName_5_0= 'System.out.println' )
                    // InternalSimpleAspect.g:2490:6: lv_methodName_5_0= 'System.out.println'
                    {
                    lv_methodName_5_0=(Token)match(input,52,FOLLOW_9); 

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

            otherlv_6=(Token)match(input,18,FOLLOW_34); 

            			newLeafNode(otherlv_6, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSimpleAspect.g:2507:3: ( ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )* )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)||LA42_0==18||LA42_0==22||LA42_0==48||(LA42_0>=50 && LA42_0<=55)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalSimpleAspect.g:2508:4: ( (lv_parameter_7_0= ruleGenericExpression ) ) (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )*
                    {
                    // InternalSimpleAspect.g:2508:4: ( (lv_parameter_7_0= ruleGenericExpression ) )
                    // InternalSimpleAspect.g:2509:5: (lv_parameter_7_0= ruleGenericExpression )
                    {
                    // InternalSimpleAspect.g:2509:5: (lv_parameter_7_0= ruleGenericExpression )
                    // InternalSimpleAspect.g:2510:6: lv_parameter_7_0= ruleGenericExpression
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getParameterGenericExpressionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parameter_7_0=ruleGenericExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    						}
                    						add(
                    							current,
                    							"parameter",
                    							lv_parameter_7_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSimpleAspect.g:2527:4: (otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==19) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalSimpleAspect.g:2528:5: otherlv_8= ',' ( (lv_parameter_9_0= ruleGenericExpression ) )
                    	    {
                    	    otherlv_8=(Token)match(input,19,FOLLOW_28); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getMethodCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalSimpleAspect.g:2532:5: ( (lv_parameter_9_0= ruleGenericExpression ) )
                    	    // InternalSimpleAspect.g:2533:6: (lv_parameter_9_0= ruleGenericExpression )
                    	    {
                    	    // InternalSimpleAspect.g:2533:6: (lv_parameter_9_0= ruleGenericExpression )
                    	    // InternalSimpleAspect.g:2534:7: lv_parameter_9_0= ruleGenericExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodCallAccess().getParameterGenericExpressionParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_parameter_9_0=ruleGenericExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameter",
                    	    								lv_parameter_9_0,
                    	    								"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FOLLOW_8); 

            			newLeafNode(otherlv_10, grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_3());
            		
            otherlv_11=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSimpleAspect.g:2565:1: entryRuleGenericExpression returns [EObject current=null] : iv_ruleGenericExpression= ruleGenericExpression EOF ;
    public final EObject entryRuleGenericExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericExpression = null;


        try {
            // InternalSimpleAspect.g:2565:58: (iv_ruleGenericExpression= ruleGenericExpression EOF )
            // InternalSimpleAspect.g:2566:2: iv_ruleGenericExpression= ruleGenericExpression EOF
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
    // InternalSimpleAspect.g:2572:1: ruleGenericExpression returns [EObject current=null] : (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression ) ;
    public final EObject ruleGenericExpression() throws RecognitionException {
        EObject current = null;

        EObject this_VariableExpression_0 = null;

        EObject this_MethodCall_1 = null;

        EObject this_ParanthesisOrBinaryExpression_2 = null;

        EObject this_UnaryExpression_3 = null;

        EObject this_ConstantExpression_4 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:2578:2: ( (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression ) )
            // InternalSimpleAspect.g:2579:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression )
            {
            // InternalSimpleAspect.g:2579:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression )
            int alt43=5;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // InternalSimpleAspect.g:2580:3: this_VariableExpression_0= ruleVariableExpression
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
                    // InternalSimpleAspect.g:2589:3: this_MethodCall_1= ruleMethodCall
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
                    // InternalSimpleAspect.g:2598:3: this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression
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
                    // InternalSimpleAspect.g:2607:3: this_UnaryExpression_3= ruleUnaryExpression
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
                    // InternalSimpleAspect.g:2616:3: this_ConstantExpression_4= ruleConstantExpression
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
    // InternalSimpleAspect.g:2628:1: entryRuleConstantExpression returns [EObject current=null] : iv_ruleConstantExpression= ruleConstantExpression EOF ;
    public final EObject entryRuleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantExpression = null;


        try {
            // InternalSimpleAspect.g:2628:59: (iv_ruleConstantExpression= ruleConstantExpression EOF )
            // InternalSimpleAspect.g:2629:2: iv_ruleConstantExpression= ruleConstantExpression EOF
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
    // InternalSimpleAspect.g:2635:1: ruleConstantExpression returns [EObject current=null] : (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression ) ;
    public final EObject ruleConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerExpression_0 = null;

        EObject this_StringExpression_1 = null;

        EObject this_BooleanExpression_2 = null;

        EObject this_NullExpression_3 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:2641:2: ( (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression ) )
            // InternalSimpleAspect.g:2642:2: (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression )
            {
            // InternalSimpleAspect.g:2642:2: (this_IntegerExpression_0= ruleIntegerExpression | this_StringExpression_1= ruleStringExpression | this_BooleanExpression_2= ruleBooleanExpression | this_NullExpression_3= ruleNullExpression )
            int alt44=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt44=1;
                }
                break;
            case RULE_STRING:
                {
                alt44=2;
                }
                break;
            case 54:
            case 55:
                {
                alt44=3;
                }
                break;
            case 53:
                {
                alt44=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalSimpleAspect.g:2643:3: this_IntegerExpression_0= ruleIntegerExpression
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
                    // InternalSimpleAspect.g:2652:3: this_StringExpression_1= ruleStringExpression
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
                    // InternalSimpleAspect.g:2661:3: this_BooleanExpression_2= ruleBooleanExpression
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
                    // InternalSimpleAspect.g:2670:3: this_NullExpression_3= ruleNullExpression
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
    // InternalSimpleAspect.g:2682:1: entryRuleNullExpression returns [EObject current=null] : iv_ruleNullExpression= ruleNullExpression EOF ;
    public final EObject entryRuleNullExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExpression = null;


        try {
            // InternalSimpleAspect.g:2682:55: (iv_ruleNullExpression= ruleNullExpression EOF )
            // InternalSimpleAspect.g:2683:2: iv_ruleNullExpression= ruleNullExpression EOF
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
    // InternalSimpleAspect.g:2689:1: ruleNullExpression returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSimpleAspect.g:2695:2: ( ( () otherlv_1= 'null' ) )
            // InternalSimpleAspect.g:2696:2: ( () otherlv_1= 'null' )
            {
            // InternalSimpleAspect.g:2696:2: ( () otherlv_1= 'null' )
            // InternalSimpleAspect.g:2697:3: () otherlv_1= 'null'
            {
            // InternalSimpleAspect.g:2697:3: ()
            // InternalSimpleAspect.g:2698:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNullExpressionAccess().getNullExpressionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,53,FOLLOW_2); 

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
    // InternalSimpleAspect.g:2712:1: entryRuleIntegerExpression returns [EObject current=null] : iv_ruleIntegerExpression= ruleIntegerExpression EOF ;
    public final EObject entryRuleIntegerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerExpression = null;


        try {
            // InternalSimpleAspect.g:2712:58: (iv_ruleIntegerExpression= ruleIntegerExpression EOF )
            // InternalSimpleAspect.g:2713:2: iv_ruleIntegerExpression= ruleIntegerExpression EOF
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
    // InternalSimpleAspect.g:2719:1: ruleIntegerExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSimpleAspect.g:2725:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalSimpleAspect.g:2726:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalSimpleAspect.g:2726:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalSimpleAspect.g:2727:3: (lv_value_0_0= RULE_INT )
            {
            // InternalSimpleAspect.g:2727:3: (lv_value_0_0= RULE_INT )
            // InternalSimpleAspect.g:2728:4: lv_value_0_0= RULE_INT
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
    // InternalSimpleAspect.g:2747:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalSimpleAspect.g:2747:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalSimpleAspect.g:2748:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
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
    // InternalSimpleAspect.g:2754:1: ruleBooleanExpression returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSimpleAspect.g:2760:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalSimpleAspect.g:2761:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalSimpleAspect.g:2761:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalSimpleAspect.g:2762:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalSimpleAspect.g:2762:3: ()
            // InternalSimpleAspect.g:2763:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanExpressionAccess().getBooleanExpressionAction_0(),
            					current);
            			

            }

            // InternalSimpleAspect.g:2769:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==54) ) {
                alt45=1;
            }
            else if ( (LA45_0==55) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalSimpleAspect.g:2770:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalSimpleAspect.g:2770:4: ( (lv_value_1_0= 'true' ) )
                    // InternalSimpleAspect.g:2771:5: (lv_value_1_0= 'true' )
                    {
                    // InternalSimpleAspect.g:2771:5: (lv_value_1_0= 'true' )
                    // InternalSimpleAspect.g:2772:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,54,FOLLOW_2); 

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
                    // InternalSimpleAspect.g:2785:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,55,FOLLOW_2); 

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
    // InternalSimpleAspect.g:2794:1: entryRuleStringExpression returns [EObject current=null] : iv_ruleStringExpression= ruleStringExpression EOF ;
    public final EObject entryRuleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExpression = null;


        try {
            // InternalSimpleAspect.g:2794:57: (iv_ruleStringExpression= ruleStringExpression EOF )
            // InternalSimpleAspect.g:2795:2: iv_ruleStringExpression= ruleStringExpression EOF
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
    // InternalSimpleAspect.g:2801:1: ruleStringExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSimpleAspect.g:2807:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalSimpleAspect.g:2808:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalSimpleAspect.g:2808:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalSimpleAspect.g:2809:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalSimpleAspect.g:2809:3: (lv_value_0_0= RULE_STRING )
            // InternalSimpleAspect.g:2810:4: lv_value_0_0= RULE_STRING
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
    // InternalSimpleAspect.g:2829:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalSimpleAspect.g:2829:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalSimpleAspect.g:2830:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalSimpleAspect.g:2836:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        EObject lv_source_1_0 = null;



        	enterRule();

        try {
            // InternalSimpleAspect.g:2842:2: ( ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) ) )
            // InternalSimpleAspect.g:2843:2: ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) )
            {
            // InternalSimpleAspect.g:2843:2: ( ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) ) )
            // InternalSimpleAspect.g:2844:3: ( (lv_type_0_0= '!' ) ) ( (lv_source_1_0= ruleGenericExpression ) )
            {
            // InternalSimpleAspect.g:2844:3: ( (lv_type_0_0= '!' ) )
            // InternalSimpleAspect.g:2845:4: (lv_type_0_0= '!' )
            {
            // InternalSimpleAspect.g:2845:4: (lv_type_0_0= '!' )
            // InternalSimpleAspect.g:2846:5: lv_type_0_0= '!'
            {
            lv_type_0_0=(Token)match(input,22,FOLLOW_28); 

            					newLeafNode(lv_type_0_0, grammarAccess.getUnaryExpressionAccess().getTypeExclamationMarkKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnaryExpressionRule());
            					}
            					setWithLastConsumed(current, "type", lv_type_0_0, "!");
            				

            }


            }

            // InternalSimpleAspect.g:2858:3: ( (lv_source_1_0= ruleGenericExpression ) )
            // InternalSimpleAspect.g:2859:4: (lv_source_1_0= ruleGenericExpression )
            {
            // InternalSimpleAspect.g:2859:4: (lv_source_1_0= ruleGenericExpression )
            // InternalSimpleAspect.g:2860:5: lv_source_1_0= ruleGenericExpression
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
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
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
    // InternalSimpleAspect.g:2881:1: entryRuleVariableExpression returns [EObject current=null] : iv_ruleVariableExpression= ruleVariableExpression EOF ;
    public final EObject entryRuleVariableExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableExpression = null;


        try {
            // InternalSimpleAspect.g:2881:59: (iv_ruleVariableExpression= ruleVariableExpression EOF )
            // InternalSimpleAspect.g:2882:2: iv_ruleVariableExpression= ruleVariableExpression EOF
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
    // InternalSimpleAspect.g:2888:1: ruleVariableExpression returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariableExpression() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalSimpleAspect.g:2894:2: ( ( ( ruleQualifiedName ) ) )
            // InternalSimpleAspect.g:2895:2: ( ( ruleQualifiedName ) )
            {
            // InternalSimpleAspect.g:2895:2: ( ( ruleQualifiedName ) )
            // InternalSimpleAspect.g:2896:3: ( ruleQualifiedName )
            {
            // InternalSimpleAspect.g:2896:3: ( ruleQualifiedName )
            // InternalSimpleAspect.g:2897:4: ruleQualifiedName
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
    // InternalSimpleAspect.g:2914:1: entryRuleParanthesisOrBinaryExpression returns [EObject current=null] : iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF ;
    public final EObject entryRuleParanthesisOrBinaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParanthesisOrBinaryExpression = null;


        try {
            // InternalSimpleAspect.g:2914:70: (iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF )
            // InternalSimpleAspect.g:2915:2: iv_ruleParanthesisOrBinaryExpression= ruleParanthesisOrBinaryExpression EOF
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
    // InternalSimpleAspect.g:2921:1: ruleParanthesisOrBinaryExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' ) ;
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
            // InternalSimpleAspect.g:2927:2: ( (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' ) )
            // InternalSimpleAspect.g:2928:2: (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' )
            {
            // InternalSimpleAspect.g:2928:2: (otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')' )
            // InternalSimpleAspect.g:2929:3: otherlv_0= '(' ( (lv_source_1_0= ruleGenericExpression ) ) ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getParanthesisOrBinaryExpressionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalSimpleAspect.g:2933:3: ( (lv_source_1_0= ruleGenericExpression ) )
            // InternalSimpleAspect.g:2934:4: (lv_source_1_0= ruleGenericExpression )
            {
            // InternalSimpleAspect.g:2934:4: (lv_source_1_0= ruleGenericExpression )
            // InternalSimpleAspect.g:2935:5: lv_source_1_0= ruleGenericExpression
            {

            					newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionAccess().getSourceGenericExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_35);
            lv_source_1_0=ruleGenericExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParanthesisOrBinaryExpressionRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_1_0,
            						"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSimpleAspect.g:2952:3: ( ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==15||(LA47_0>=23 && LA47_0<=24)||LA47_0==31||(LA47_0>=56 && LA47_0<=64)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalSimpleAspect.g:2953:4: ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) ) ( (lv_argument_3_0= ruleGenericExpression ) )
                    {
                    // InternalSimpleAspect.g:2953:4: ( ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) ) )
                    // InternalSimpleAspect.g:2954:5: ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) )
                    {
                    // InternalSimpleAspect.g:2954:5: ( (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' ) )
                    // InternalSimpleAspect.g:2955:6: (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' )
                    {
                    // InternalSimpleAspect.g:2955:6: (lv_type_2_1= '||' | lv_type_2_2= '&&' | lv_type_2_3= '&' | lv_type_2_4= '+' | lv_type_2_5= '-' | lv_type_2_6= '*' | lv_type_2_7= '/' | lv_type_2_8= '==' | lv_type_2_9= '!=' | lv_type_2_10= '<' | lv_type_2_11= '<=' | lv_type_2_12= '>' | lv_type_2_13= '>=' )
                    int alt46=13;
                    switch ( input.LA(1) ) {
                    case 23:
                        {
                        alt46=1;
                        }
                        break;
                    case 24:
                        {
                        alt46=2;
                        }
                        break;
                    case 56:
                        {
                        alt46=3;
                        }
                        break;
                    case 57:
                        {
                        alt46=4;
                        }
                        break;
                    case 58:
                        {
                        alt46=5;
                        }
                        break;
                    case 31:
                        {
                        alt46=6;
                        }
                        break;
                    case 15:
                        {
                        alt46=7;
                        }
                        break;
                    case 59:
                        {
                        alt46=8;
                        }
                        break;
                    case 60:
                        {
                        alt46=9;
                        }
                        break;
                    case 61:
                        {
                        alt46=10;
                        }
                        break;
                    case 62:
                        {
                        alt46=11;
                        }
                        break;
                    case 63:
                        {
                        alt46=12;
                        }
                        break;
                    case 64:
                        {
                        alt46=13;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }

                    switch (alt46) {
                        case 1 :
                            // InternalSimpleAspect.g:2956:7: lv_type_2_1= '||'
                            {
                            lv_type_2_1=(Token)match(input,23,FOLLOW_28); 

                            							newLeafNode(lv_type_2_1, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeVerticalLineVerticalLineKeyword_2_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSimpleAspect.g:2967:7: lv_type_2_2= '&&'
                            {
                            lv_type_2_2=(Token)match(input,24,FOLLOW_28); 

                            							newLeafNode(lv_type_2_2, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAmpersandAmpersandKeyword_2_0_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSimpleAspect.g:2978:7: lv_type_2_3= '&'
                            {
                            lv_type_2_3=(Token)match(input,56,FOLLOW_28); 

                            							newLeafNode(lv_type_2_3, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAmpersandKeyword_2_0_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSimpleAspect.g:2989:7: lv_type_2_4= '+'
                            {
                            lv_type_2_4=(Token)match(input,57,FOLLOW_28); 

                            							newLeafNode(lv_type_2_4, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypePlusSignKeyword_2_0_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSimpleAspect.g:3000:7: lv_type_2_5= '-'
                            {
                            lv_type_2_5=(Token)match(input,58,FOLLOW_28); 

                            							newLeafNode(lv_type_2_5, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeHyphenMinusKeyword_2_0_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalSimpleAspect.g:3011:7: lv_type_2_6= '*'
                            {
                            lv_type_2_6=(Token)match(input,31,FOLLOW_28); 

                            							newLeafNode(lv_type_2_6, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeAsteriskKeyword_2_0_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_6, null);
                            						

                            }
                            break;
                        case 7 :
                            // InternalSimpleAspect.g:3022:7: lv_type_2_7= '/'
                            {
                            lv_type_2_7=(Token)match(input,15,FOLLOW_28); 

                            							newLeafNode(lv_type_2_7, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeSolidusKeyword_2_0_0_6());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_7, null);
                            						

                            }
                            break;
                        case 8 :
                            // InternalSimpleAspect.g:3033:7: lv_type_2_8= '=='
                            {
                            lv_type_2_8=(Token)match(input,59,FOLLOW_28); 

                            							newLeafNode(lv_type_2_8, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeEqualsSignEqualsSignKeyword_2_0_0_7());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_8, null);
                            						

                            }
                            break;
                        case 9 :
                            // InternalSimpleAspect.g:3044:7: lv_type_2_9= '!='
                            {
                            lv_type_2_9=(Token)match(input,60,FOLLOW_28); 

                            							newLeafNode(lv_type_2_9, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeExclamationMarkEqualsSignKeyword_2_0_0_8());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_9, null);
                            						

                            }
                            break;
                        case 10 :
                            // InternalSimpleAspect.g:3055:7: lv_type_2_10= '<'
                            {
                            lv_type_2_10=(Token)match(input,61,FOLLOW_28); 

                            							newLeafNode(lv_type_2_10, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeLessThanSignKeyword_2_0_0_9());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_10, null);
                            						

                            }
                            break;
                        case 11 :
                            // InternalSimpleAspect.g:3066:7: lv_type_2_11= '<='
                            {
                            lv_type_2_11=(Token)match(input,62,FOLLOW_28); 

                            							newLeafNode(lv_type_2_11, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeLessThanSignEqualsSignKeyword_2_0_0_10());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_11, null);
                            						

                            }
                            break;
                        case 12 :
                            // InternalSimpleAspect.g:3077:7: lv_type_2_12= '>'
                            {
                            lv_type_2_12=(Token)match(input,63,FOLLOW_28); 

                            							newLeafNode(lv_type_2_12, grammarAccess.getParanthesisOrBinaryExpressionAccess().getTypeGreaterThanSignKeyword_2_0_0_11());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParanthesisOrBinaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "type", lv_type_2_12, null);
                            						

                            }
                            break;
                        case 13 :
                            // InternalSimpleAspect.g:3088:7: lv_type_2_13= '>='
                            {
                            lv_type_2_13=(Token)match(input,64,FOLLOW_28); 

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

                    // InternalSimpleAspect.g:3101:4: ( (lv_argument_3_0= ruleGenericExpression ) )
                    // InternalSimpleAspect.g:3102:5: (lv_argument_3_0= ruleGenericExpression )
                    {
                    // InternalSimpleAspect.g:3102:5: (lv_argument_3_0= ruleGenericExpression )
                    // InternalSimpleAspect.g:3103:6: lv_argument_3_0= ruleGenericExpression
                    {

                    						newCompositeNode(grammarAccess.getParanthesisOrBinaryExpressionAccess().getArgumentGenericExpressionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_argument_3_0=ruleGenericExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParanthesisOrBinaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"argument",
                    							lv_argument_3_0,
                    							"at.ac.tuwien.big.simpleaspect.SimpleAspect.GenericExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FOLLOW_2); 

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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalSimpleAspect.g:3129:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSimpleAspect.g:3129:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSimpleAspect.g:3130:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalSimpleAspect.g:3136:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalSimpleAspect.g:3142:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSimpleAspect.g:3143:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSimpleAspect.g:3143:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSimpleAspect.g:3144:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalSimpleAspect.g:3151:3: (kw= '.' this_ID_2= RULE_ID )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==49) ) {
                    int LA48_2 = input.LA(2);

                    if ( (LA48_2==RULE_ID) ) {
                        int LA48_3 = input.LA(3);

                        if ( (LA48_3==EOF||LA48_3==RULE_ID||(LA48_3>=15 && LA48_3<=16)||(LA48_3>=19 && LA48_3<=20)||(LA48_3>=23 && LA48_3<=24)||LA48_3==31||LA48_3==42||LA48_3==49||(LA48_3>=56 && LA48_3<=64)) ) {
                            alt48=1;
                        }


                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalSimpleAspect.g:3152:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,49,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_36); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop48;
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


    protected DFA32 dfa32 = new DFA32(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA43 dfa43 = new DFA43(this);
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\1\4\1\uffff\2\4\1\uffff\1\4";
    static final String dfa_3s = "\1\47\1\uffff\1\61\1\4\1\uffff\1\61";
    static final String dfa_4s = "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_5s = "\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\37\uffff\4\1",
            "",
            "\1\1\45\uffff\1\4\6\uffff\1\3",
            "\1\5",
            "",
            "\1\1\45\uffff\1\4\6\uffff\1\3"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1671:2: (this_SimpleVariableDeclaration_0= ruleSimpleVariableDeclaration | this_Assignment_1= ruleAssignment )";
        }
    }
    static final String dfa_7s = "\27\uffff";
    static final String dfa_8s = "\1\4\2\uffff\1\4\1\uffff\1\22\3\uffff\1\4\1\uffff\7\4\1\uffff\1\25\1\4\1\uffff\1\4";
    static final String dfa_9s = "\1\64\2\uffff\1\61\1\uffff\1\22\3\uffff\1\63\1\uffff\1\47\1\61\4\4\1\61\1\uffff\1\52\1\4\1\uffff\1\61";
    static final String dfa_10s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\uffff\1\7\1\10\1\11\1\uffff\1\3\7\uffff\1\5\2\uffff\1\6\1\uffff";
    static final String dfa_11s = "\27\uffff}>";
    static final String[] dfa_12s = {
            "\1\3\7\uffff\1\1\27\uffff\4\2\1\uffff\1\1\1\uffff\1\4\1\uffff\1\5\1\6\1\7\1\10\1\uffff\3\10",
            "",
            "",
            "\1\2\15\uffff\1\10\27\uffff\1\12\6\uffff\1\11",
            "",
            "\1\13",
            "",
            "",
            "",
            "\1\14\55\uffff\2\10",
            "",
            "\1\21\13\uffff\1\22\23\uffff\1\15\1\16\1\17\1\20",
            "\1\2\15\uffff\1\10\27\uffff\1\12\6\uffff\1\11",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23\45\uffff\1\22\6\uffff\1\24",
            "",
            "\1\25\24\uffff\1\22",
            "\1\26",
            "",
            "\1\23\45\uffff\1\22\6\uffff\1\24"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1707:2: (this_MethodBlock_0= ruleMethodBlock | this_VariableDeclaration_1= ruleVariableDeclaration | this_Assignment_2= ruleAssignment | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_ForInStatement_5= ruleForInStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement | this_MethodCall_8= ruleMethodCall )";
        }
    }
    static final String dfa_13s = "\11\uffff";
    static final String dfa_14s = "\1\uffff\1\7\6\uffff\1\7";
    static final String dfa_15s = "\1\4\1\17\4\uffff\1\4\1\uffff\1\17";
    static final String dfa_16s = "\1\67\1\100\4\uffff\1\63\1\uffff\1\100";
    static final String dfa_17s = "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\1\1\uffff";
    static final String dfa_18s = "\11\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\2\5\13\uffff\1\3\3\uffff\1\4\31\uffff\1\2\1\uffff\3\2\3\5",
            "\2\7\1\uffff\1\2\2\7\2\uffff\2\7\6\uffff\1\7\21\uffff\1\6\6\uffff\11\7",
            "",
            "",
            "",
            "",
            "\1\10\55\uffff\2\2",
            "",
            "\2\7\1\uffff\1\2\2\7\2\uffff\2\7\6\uffff\1\7\21\uffff\1\6\6\uffff\11\7"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "2579:2: (this_VariableExpression_0= ruleVariableExpression | this_MethodCall_1= ruleMethodCall | this_ParanthesisOrBinaryExpression_2= ruleParanthesisOrBinaryExpression | this_UnaryExpression_3= ruleUnaryExpression | this_ConstantExpression_4= ruleConstantExpression )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000E20026000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000F000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000F000100010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000001E440000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000F0E0004010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000F0C0004010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000F0C0000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000F080000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000F100100010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000020000001000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000001F040000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000001F000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x001DEAF000003010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00FDEAF000441070L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000000F000010010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x001DEAF000001010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000C000000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00FDEAF000541070L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0xFF00000081908000L,0x0000000000000001L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0002000000000002L});

}