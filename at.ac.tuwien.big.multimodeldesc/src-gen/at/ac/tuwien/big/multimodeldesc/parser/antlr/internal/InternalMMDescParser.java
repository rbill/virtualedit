package at.ac.tuwien.big.multimodeldesc.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.ac.tuwien.big.multimodeldesc.services.MMDescGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMMDescParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PointDesc'", "'['", "'Integer'", "'String'", "','", "']'", "'model'", "'{'", "'}'", "'+'", "'view'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMMDescParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMMDescParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMMDescParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMMDesc.g"; }



     	private MMDescGrammarAccess grammarAccess;

        public InternalMMDescParser(TokenStream input, MMDescGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MMDesc";
       	}

       	@Override
       	protected MMDescGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMMDesc"
    // InternalMMDesc.g:64:1: entryRuleMMDesc returns [EObject current=null] : iv_ruleMMDesc= ruleMMDesc EOF ;
    public final EObject entryRuleMMDesc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMMDesc = null;


        try {
            // InternalMMDesc.g:64:47: (iv_ruleMMDesc= ruleMMDesc EOF )
            // InternalMMDesc.g:65:2: iv_ruleMMDesc= ruleMMDesc EOF
            {
             newCompositeNode(grammarAccess.getMMDescRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMMDesc=ruleMMDesc();

            state._fsp--;

             current =iv_ruleMMDesc; 
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
    // $ANTLR end "entryRuleMMDesc"


    // $ANTLR start "ruleMMDesc"
    // InternalMMDesc.g:71:1: ruleMMDesc returns [EObject current=null] : ( ( (lv_pointDesc_0_0= rulePointDesc ) ) ( (lv_models_1_0= ruleModelRef ) )* ( (lv_view_2_0= ruleModelView ) )? ) ;
    public final EObject ruleMMDesc() throws RecognitionException {
        EObject current = null;

        EObject lv_pointDesc_0_0 = null;

        EObject lv_models_1_0 = null;

        EObject lv_view_2_0 = null;



        	enterRule();

        try {
            // InternalMMDesc.g:77:2: ( ( ( (lv_pointDesc_0_0= rulePointDesc ) ) ( (lv_models_1_0= ruleModelRef ) )* ( (lv_view_2_0= ruleModelView ) )? ) )
            // InternalMMDesc.g:78:2: ( ( (lv_pointDesc_0_0= rulePointDesc ) ) ( (lv_models_1_0= ruleModelRef ) )* ( (lv_view_2_0= ruleModelView ) )? )
            {
            // InternalMMDesc.g:78:2: ( ( (lv_pointDesc_0_0= rulePointDesc ) ) ( (lv_models_1_0= ruleModelRef ) )* ( (lv_view_2_0= ruleModelView ) )? )
            // InternalMMDesc.g:79:3: ( (lv_pointDesc_0_0= rulePointDesc ) ) ( (lv_models_1_0= ruleModelRef ) )* ( (lv_view_2_0= ruleModelView ) )?
            {
            // InternalMMDesc.g:79:3: ( (lv_pointDesc_0_0= rulePointDesc ) )
            // InternalMMDesc.g:80:4: (lv_pointDesc_0_0= rulePointDesc )
            {
            // InternalMMDesc.g:80:4: (lv_pointDesc_0_0= rulePointDesc )
            // InternalMMDesc.g:81:5: lv_pointDesc_0_0= rulePointDesc
            {

            					newCompositeNode(grammarAccess.getMMDescAccess().getPointDescPointDescParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_pointDesc_0_0=rulePointDesc();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMMDescRule());
            					}
            					set(
            						current,
            						"pointDesc",
            						lv_pointDesc_0_0,
            						"at.ac.tuwien.big.multimodeldesc.MMDesc.PointDesc");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMMDesc.g:98:3: ( (lv_models_1_0= ruleModelRef ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMMDesc.g:99:4: (lv_models_1_0= ruleModelRef )
            	    {
            	    // InternalMMDesc.g:99:4: (lv_models_1_0= ruleModelRef )
            	    // InternalMMDesc.g:100:5: lv_models_1_0= ruleModelRef
            	    {

            	    					newCompositeNode(grammarAccess.getMMDescAccess().getModelsModelRefParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_models_1_0=ruleModelRef();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMMDescRule());
            	    					}
            	    					add(
            	    						current,
            	    						"models",
            	    						lv_models_1_0,
            	    						"at.ac.tuwien.big.multimodeldesc.MMDesc.ModelRef");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalMMDesc.g:117:3: ( (lv_view_2_0= ruleModelView ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==21) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMMDesc.g:118:4: (lv_view_2_0= ruleModelView )
                    {
                    // InternalMMDesc.g:118:4: (lv_view_2_0= ruleModelView )
                    // InternalMMDesc.g:119:5: lv_view_2_0= ruleModelView
                    {

                    					newCompositeNode(grammarAccess.getMMDescAccess().getViewModelViewParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_view_2_0=ruleModelView();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getMMDescRule());
                    					}
                    					set(
                    						current,
                    						"view",
                    						lv_view_2_0,
                    						"at.ac.tuwien.big.multimodeldesc.MMDesc.ModelView");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleMMDesc"


    // $ANTLR start "entryRulePointDesc"
    // InternalMMDesc.g:140:1: entryRulePointDesc returns [EObject current=null] : iv_rulePointDesc= rulePointDesc EOF ;
    public final EObject entryRulePointDesc() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointDesc = null;


        try {
            // InternalMMDesc.g:140:50: (iv_rulePointDesc= rulePointDesc EOF )
            // InternalMMDesc.g:141:2: iv_rulePointDesc= rulePointDesc EOF
            {
             newCompositeNode(grammarAccess.getPointDescRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointDesc=rulePointDesc();

            state._fsp--;

             current =iv_rulePointDesc; 
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
    // $ANTLR end "entryRulePointDesc"


    // $ANTLR start "rulePointDesc"
    // InternalMMDesc.g:147:1: rulePointDesc returns [EObject current=null] : ( () otherlv_1= 'PointDesc' otherlv_2= '[' ( ( (lv_type_3_0= 'Integer' ) ) | ( ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )* ) )? otherlv_8= ']' ) ;
    public final EObject rulePointDesc() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;
        Token otherlv_5=null;
        Token lv_type_6_0=null;
        Token lv_type_7_0=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalMMDesc.g:153:2: ( ( () otherlv_1= 'PointDesc' otherlv_2= '[' ( ( (lv_type_3_0= 'Integer' ) ) | ( ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )* ) )? otherlv_8= ']' ) )
            // InternalMMDesc.g:154:2: ( () otherlv_1= 'PointDesc' otherlv_2= '[' ( ( (lv_type_3_0= 'Integer' ) ) | ( ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )* ) )? otherlv_8= ']' )
            {
            // InternalMMDesc.g:154:2: ( () otherlv_1= 'PointDesc' otherlv_2= '[' ( ( (lv_type_3_0= 'Integer' ) ) | ( ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )* ) )? otherlv_8= ']' )
            // InternalMMDesc.g:155:3: () otherlv_1= 'PointDesc' otherlv_2= '[' ( ( (lv_type_3_0= 'Integer' ) ) | ( ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )* ) )? otherlv_8= ']'
            {
            // InternalMMDesc.g:155:3: ()
            // InternalMMDesc.g:156:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPointDescAccess().getPointDescAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getPointDescAccess().getPointDescKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getPointDescAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalMMDesc.g:170:3: ( ( (lv_type_3_0= 'Integer' ) ) | ( ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )* ) )?
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                alt5=2;
            }
            switch (alt5) {
                case 1 :
                    // InternalMMDesc.g:171:4: ( (lv_type_3_0= 'Integer' ) )
                    {
                    // InternalMMDesc.g:171:4: ( (lv_type_3_0= 'Integer' ) )
                    // InternalMMDesc.g:172:5: (lv_type_3_0= 'Integer' )
                    {
                    // InternalMMDesc.g:172:5: (lv_type_3_0= 'Integer' )
                    // InternalMMDesc.g:173:6: lv_type_3_0= 'Integer'
                    {
                    lv_type_3_0=(Token)match(input,13,FOLLOW_6); 

                    						newLeafNode(lv_type_3_0, grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPointDescRule());
                    						}
                    						addWithLastConsumed(current, "type", lv_type_3_0, "Integer");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMMDesc.g:186:4: ( ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )* )
                    {
                    // InternalMMDesc.g:186:4: ( ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )* )
                    // InternalMMDesc.g:187:5: ( (lv_type_4_0= 'String' ) ) (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )*
                    {
                    // InternalMMDesc.g:187:5: ( (lv_type_4_0= 'String' ) )
                    // InternalMMDesc.g:188:6: (lv_type_4_0= 'String' )
                    {
                    // InternalMMDesc.g:188:6: (lv_type_4_0= 'String' )
                    // InternalMMDesc.g:189:7: lv_type_4_0= 'String'
                    {
                    lv_type_4_0=(Token)match(input,14,FOLLOW_7); 

                    							newLeafNode(lv_type_4_0, grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getPointDescRule());
                    							}
                    							addWithLastConsumed(current, "type", lv_type_4_0, "String");
                    						

                    }


                    }

                    // InternalMMDesc.g:201:5: (otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalMMDesc.g:202:6: otherlv_5= ',' ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) )
                    	    {
                    	    otherlv_5=(Token)match(input,15,FOLLOW_8); 

                    	    						newLeafNode(otherlv_5, grammarAccess.getPointDescAccess().getCommaKeyword_3_1_1_0());
                    	    					
                    	    // InternalMMDesc.g:206:6: ( ( (lv_type_6_0= 'Integer' ) ) | ( (lv_type_7_0= 'String' ) ) )
                    	    int alt3=2;
                    	    int LA3_0 = input.LA(1);

                    	    if ( (LA3_0==13) ) {
                    	        alt3=1;
                    	    }
                    	    else if ( (LA3_0==14) ) {
                    	        alt3=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 3, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // InternalMMDesc.g:207:7: ( (lv_type_6_0= 'Integer' ) )
                    	            {
                    	            // InternalMMDesc.g:207:7: ( (lv_type_6_0= 'Integer' ) )
                    	            // InternalMMDesc.g:208:8: (lv_type_6_0= 'Integer' )
                    	            {
                    	            // InternalMMDesc.g:208:8: (lv_type_6_0= 'Integer' )
                    	            // InternalMMDesc.g:209:9: lv_type_6_0= 'Integer'
                    	            {
                    	            lv_type_6_0=(Token)match(input,13,FOLLOW_7); 

                    	            									newLeafNode(lv_type_6_0, grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_1_1_1_0_0());
                    	            								

                    	            									if (current==null) {
                    	            										current = createModelElement(grammarAccess.getPointDescRule());
                    	            									}
                    	            									addWithLastConsumed(current, "type", lv_type_6_0, "Integer");
                    	            								

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalMMDesc.g:222:7: ( (lv_type_7_0= 'String' ) )
                    	            {
                    	            // InternalMMDesc.g:222:7: ( (lv_type_7_0= 'String' ) )
                    	            // InternalMMDesc.g:223:8: (lv_type_7_0= 'String' )
                    	            {
                    	            // InternalMMDesc.g:223:8: (lv_type_7_0= 'String' )
                    	            // InternalMMDesc.g:224:9: lv_type_7_0= 'String'
                    	            {
                    	            lv_type_7_0=(Token)match(input,14,FOLLOW_7); 

                    	            									newLeafNode(lv_type_7_0, grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_1_1_1_0());
                    	            								

                    	            									if (current==null) {
                    	            										current = createModelElement(grammarAccess.getPointDescRule());
                    	            									}
                    	            									addWithLastConsumed(current, "type", lv_type_7_0, "String");
                    	            								

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getPointDescAccess().getRightSquareBracketKeyword_4());
            		

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
    // $ANTLR end "rulePointDesc"


    // $ANTLR start "entryRuleModelRef"
    // InternalMMDesc.g:248:1: entryRuleModelRef returns [EObject current=null] : iv_ruleModelRef= ruleModelRef EOF ;
    public final EObject entryRuleModelRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelRef = null;


        try {
            // InternalMMDesc.g:248:49: (iv_ruleModelRef= ruleModelRef EOF )
            // InternalMMDesc.g:249:2: iv_ruleModelRef= ruleModelRef EOF
            {
             newCompositeNode(grammarAccess.getModelRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelRef=ruleModelRef();

            state._fsp--;

             current =iv_ruleModelRef; 
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
    // $ANTLR end "entryRuleModelRef"


    // $ANTLR start "ruleModelRef"
    // InternalMMDesc.g:255:1: ruleModelRef returns [EObject current=null] : (otherlv_0= 'model' ( (lv_id_1_0= RULE_INT ) ) ( (lv_uri_2_0= RULE_STRING ) ) (otherlv_3= '[' ( ( (lv_data_4_0= RULE_STRING ) ) | this_ID_5= RULE_ID | this_INT_6= RULE_INT ) otherlv_7= ']' )? (otherlv_8= '{' ( (lv_next_9_0= ruleModelRef ) )* otherlv_10= '}' )? ( (lv_continue_11_0= '+' ) )? ) ;
    public final EObject ruleModelRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token lv_uri_2_0=null;
        Token otherlv_3=null;
        Token lv_data_4_0=null;
        Token this_ID_5=null;
        Token this_INT_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_continue_11_0=null;
        EObject lv_next_9_0 = null;



        	enterRule();

        try {
            // InternalMMDesc.g:261:2: ( (otherlv_0= 'model' ( (lv_id_1_0= RULE_INT ) ) ( (lv_uri_2_0= RULE_STRING ) ) (otherlv_3= '[' ( ( (lv_data_4_0= RULE_STRING ) ) | this_ID_5= RULE_ID | this_INT_6= RULE_INT ) otherlv_7= ']' )? (otherlv_8= '{' ( (lv_next_9_0= ruleModelRef ) )* otherlv_10= '}' )? ( (lv_continue_11_0= '+' ) )? ) )
            // InternalMMDesc.g:262:2: (otherlv_0= 'model' ( (lv_id_1_0= RULE_INT ) ) ( (lv_uri_2_0= RULE_STRING ) ) (otherlv_3= '[' ( ( (lv_data_4_0= RULE_STRING ) ) | this_ID_5= RULE_ID | this_INT_6= RULE_INT ) otherlv_7= ']' )? (otherlv_8= '{' ( (lv_next_9_0= ruleModelRef ) )* otherlv_10= '}' )? ( (lv_continue_11_0= '+' ) )? )
            {
            // InternalMMDesc.g:262:2: (otherlv_0= 'model' ( (lv_id_1_0= RULE_INT ) ) ( (lv_uri_2_0= RULE_STRING ) ) (otherlv_3= '[' ( ( (lv_data_4_0= RULE_STRING ) ) | this_ID_5= RULE_ID | this_INT_6= RULE_INT ) otherlv_7= ']' )? (otherlv_8= '{' ( (lv_next_9_0= ruleModelRef ) )* otherlv_10= '}' )? ( (lv_continue_11_0= '+' ) )? )
            // InternalMMDesc.g:263:3: otherlv_0= 'model' ( (lv_id_1_0= RULE_INT ) ) ( (lv_uri_2_0= RULE_STRING ) ) (otherlv_3= '[' ( ( (lv_data_4_0= RULE_STRING ) ) | this_ID_5= RULE_ID | this_INT_6= RULE_INT ) otherlv_7= ']' )? (otherlv_8= '{' ( (lv_next_9_0= ruleModelRef ) )* otherlv_10= '}' )? ( (lv_continue_11_0= '+' ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getModelRefAccess().getModelKeyword_0());
            		
            // InternalMMDesc.g:267:3: ( (lv_id_1_0= RULE_INT ) )
            // InternalMMDesc.g:268:4: (lv_id_1_0= RULE_INT )
            {
            // InternalMMDesc.g:268:4: (lv_id_1_0= RULE_INT )
            // InternalMMDesc.g:269:5: lv_id_1_0= RULE_INT
            {
            lv_id_1_0=(Token)match(input,RULE_INT,FOLLOW_10); 

            					newLeafNode(lv_id_1_0, grammarAccess.getModelRefAccess().getIdINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalMMDesc.g:285:3: ( (lv_uri_2_0= RULE_STRING ) )
            // InternalMMDesc.g:286:4: (lv_uri_2_0= RULE_STRING )
            {
            // InternalMMDesc.g:286:4: (lv_uri_2_0= RULE_STRING )
            // InternalMMDesc.g:287:5: lv_uri_2_0= RULE_STRING
            {
            lv_uri_2_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_uri_2_0, grammarAccess.getModelRefAccess().getUriSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"uri",
            						lv_uri_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalMMDesc.g:303:3: (otherlv_3= '[' ( ( (lv_data_4_0= RULE_STRING ) ) | this_ID_5= RULE_ID | this_INT_6= RULE_INT ) otherlv_7= ']' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==12) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMMDesc.g:304:4: otherlv_3= '[' ( ( (lv_data_4_0= RULE_STRING ) ) | this_ID_5= RULE_ID | this_INT_6= RULE_INT ) otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getModelRefAccess().getLeftSquareBracketKeyword_3_0());
                    			
                    // InternalMMDesc.g:308:4: ( ( (lv_data_4_0= RULE_STRING ) ) | this_ID_5= RULE_ID | this_INT_6= RULE_INT )
                    int alt6=3;
                    switch ( input.LA(1) ) {
                    case RULE_STRING:
                        {
                        alt6=1;
                        }
                        break;
                    case RULE_ID:
                        {
                        alt6=2;
                        }
                        break;
                    case RULE_INT:
                        {
                        alt6=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }

                    switch (alt6) {
                        case 1 :
                            // InternalMMDesc.g:309:5: ( (lv_data_4_0= RULE_STRING ) )
                            {
                            // InternalMMDesc.g:309:5: ( (lv_data_4_0= RULE_STRING ) )
                            // InternalMMDesc.g:310:6: (lv_data_4_0= RULE_STRING )
                            {
                            // InternalMMDesc.g:310:6: (lv_data_4_0= RULE_STRING )
                            // InternalMMDesc.g:311:7: lv_data_4_0= RULE_STRING
                            {
                            lv_data_4_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

                            							newLeafNode(lv_data_4_0, grammarAccess.getModelRefAccess().getDataSTRINGTerminalRuleCall_3_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getModelRefRule());
                            							}
                            							addWithLastConsumed(
                            								current,
                            								"data",
                            								lv_data_4_0,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalMMDesc.g:328:5: this_ID_5= RULE_ID
                            {
                            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_6); 

                            					newLeafNode(this_ID_5, grammarAccess.getModelRefAccess().getIDTerminalRuleCall_3_1_1());
                            				

                            }
                            break;
                        case 3 :
                            // InternalMMDesc.g:333:5: this_INT_6= RULE_INT
                            {
                            this_INT_6=(Token)match(input,RULE_INT,FOLLOW_6); 

                            					newLeafNode(this_INT_6, grammarAccess.getModelRefAccess().getINTTerminalRuleCall_3_1_2());
                            				

                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,16,FOLLOW_13); 

                    				newLeafNode(otherlv_7, grammarAccess.getModelRefAccess().getRightSquareBracketKeyword_3_2());
                    			

                    }
                    break;

            }

            // InternalMMDesc.g:343:3: (otherlv_8= '{' ( (lv_next_9_0= ruleModelRef ) )* otherlv_10= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMMDesc.g:344:4: otherlv_8= '{' ( (lv_next_9_0= ruleModelRef ) )* otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,18,FOLLOW_14); 

                    				newLeafNode(otherlv_8, grammarAccess.getModelRefAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalMMDesc.g:348:4: ( (lv_next_9_0= ruleModelRef ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==17) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalMMDesc.g:349:5: (lv_next_9_0= ruleModelRef )
                    	    {
                    	    // InternalMMDesc.g:349:5: (lv_next_9_0= ruleModelRef )
                    	    // InternalMMDesc.g:350:6: lv_next_9_0= ruleModelRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelRefAccess().getNextModelRefParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    lv_next_9_0=ruleModelRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getModelRefRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"next",
                    	    							lv_next_9_0,
                    	    							"at.ac.tuwien.big.multimodeldesc.MMDesc.ModelRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_15); 

                    				newLeafNode(otherlv_10, grammarAccess.getModelRefAccess().getRightCurlyBracketKeyword_4_2());
                    			

                    }
                    break;

            }

            // InternalMMDesc.g:372:3: ( (lv_continue_11_0= '+' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMMDesc.g:373:4: (lv_continue_11_0= '+' )
                    {
                    // InternalMMDesc.g:373:4: (lv_continue_11_0= '+' )
                    // InternalMMDesc.g:374:5: lv_continue_11_0= '+'
                    {
                    lv_continue_11_0=(Token)match(input,20,FOLLOW_2); 

                    					newLeafNode(lv_continue_11_0, grammarAccess.getModelRefAccess().getContinuePlusSignKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRefRule());
                    					}
                    					setWithLastConsumed(current, "continue", true, "+");
                    				

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
    // $ANTLR end "ruleModelRef"


    // $ANTLR start "entryRuleModelView"
    // InternalMMDesc.g:390:1: entryRuleModelView returns [EObject current=null] : iv_ruleModelView= ruleModelView EOF ;
    public final EObject entryRuleModelView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelView = null;


        try {
            // InternalMMDesc.g:390:50: (iv_ruleModelView= ruleModelView EOF )
            // InternalMMDesc.g:391:2: iv_ruleModelView= ruleModelView EOF
            {
             newCompositeNode(grammarAccess.getModelViewRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelView=ruleModelView();

            state._fsp--;

             current =iv_ruleModelView; 
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
    // $ANTLR end "entryRuleModelView"


    // $ANTLR start "ruleModelView"
    // InternalMMDesc.g:397:1: ruleModelView returns [EObject current=null] : ( () otherlv_1= 'view' otherlv_2= '[' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= ']' ) ;
    public final EObject ruleModelView() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalMMDesc.g:403:2: ( ( () otherlv_1= 'view' otherlv_2= '[' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= ']' ) )
            // InternalMMDesc.g:404:2: ( () otherlv_1= 'view' otherlv_2= '[' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= ']' )
            {
            // InternalMMDesc.g:404:2: ( () otherlv_1= 'view' otherlv_2= '[' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= ']' )
            // InternalMMDesc.g:405:3: () otherlv_1= 'view' otherlv_2= '[' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= ']'
            {
            // InternalMMDesc.g:405:3: ()
            // InternalMMDesc.g:406:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getModelViewAccess().getModelViewAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getModelViewAccess().getViewKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getModelViewAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalMMDesc.g:420:3: ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMMDesc.g:421:4: ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    // InternalMMDesc.g:421:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMMDesc.g:422:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMMDesc.g:422:5: (otherlv_3= RULE_ID )
                    // InternalMMDesc.g:423:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelViewRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_7); 

                    						newLeafNode(otherlv_3, grammarAccess.getModelViewAccess().getViewedModelRefCrossReference_3_0_0());
                    					

                    }


                    }

                    // InternalMMDesc.g:434:4: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==15) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalMMDesc.g:435:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,15,FOLLOW_17); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getModelViewAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalMMDesc.g:439:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalMMDesc.g:440:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalMMDesc.g:440:6: (otherlv_5= RULE_ID )
                    	    // InternalMMDesc.g:441:7: otherlv_5= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModelViewRule());
                    	    							}
                    	    						
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_7); 

                    	    							newLeafNode(otherlv_5, grammarAccess.getModelViewAccess().getViewedModelRefCrossReference_3_1_1_0());
                    	    						

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

            otherlv_6=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getModelViewAccess().getRightSquareBracketKeyword_4());
            		

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
    // $ANTLR end "ruleModelView"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000220002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000016000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000141002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});

}