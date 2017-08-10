package at.ac.tuwien.big.multimodeldesc.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import at.ac.tuwien.big.multimodeldesc.services.MMDescGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMMDescParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'PointDesc'", "'['", "']'", "','", "'model'", "'{'", "'}'", "'view'", "'Integer'", "'String'", "'+'"
    };
    public static final int RULE_STRING=6;
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
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

    	public void setGrammarAccess(MMDescGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleMMDesc"
    // InternalMMDesc.g:53:1: entryRuleMMDesc : ruleMMDesc EOF ;
    public final void entryRuleMMDesc() throws RecognitionException {
        try {
            // InternalMMDesc.g:54:1: ( ruleMMDesc EOF )
            // InternalMMDesc.g:55:1: ruleMMDesc EOF
            {
             before(grammarAccess.getMMDescRule()); 
            pushFollow(FOLLOW_1);
            ruleMMDesc();

            state._fsp--;

             after(grammarAccess.getMMDescRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMMDesc"


    // $ANTLR start "ruleMMDesc"
    // InternalMMDesc.g:62:1: ruleMMDesc : ( ( rule__MMDesc__Group__0 ) ) ;
    public final void ruleMMDesc() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:66:2: ( ( ( rule__MMDesc__Group__0 ) ) )
            // InternalMMDesc.g:67:2: ( ( rule__MMDesc__Group__0 ) )
            {
            // InternalMMDesc.g:67:2: ( ( rule__MMDesc__Group__0 ) )
            // InternalMMDesc.g:68:3: ( rule__MMDesc__Group__0 )
            {
             before(grammarAccess.getMMDescAccess().getGroup()); 
            // InternalMMDesc.g:69:3: ( rule__MMDesc__Group__0 )
            // InternalMMDesc.g:69:4: rule__MMDesc__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MMDesc__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMMDescAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMMDesc"


    // $ANTLR start "entryRulePointDesc"
    // InternalMMDesc.g:78:1: entryRulePointDesc : rulePointDesc EOF ;
    public final void entryRulePointDesc() throws RecognitionException {
        try {
            // InternalMMDesc.g:79:1: ( rulePointDesc EOF )
            // InternalMMDesc.g:80:1: rulePointDesc EOF
            {
             before(grammarAccess.getPointDescRule()); 
            pushFollow(FOLLOW_1);
            rulePointDesc();

            state._fsp--;

             after(grammarAccess.getPointDescRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePointDesc"


    // $ANTLR start "rulePointDesc"
    // InternalMMDesc.g:87:1: rulePointDesc : ( ( rule__PointDesc__Group__0 ) ) ;
    public final void rulePointDesc() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:91:2: ( ( ( rule__PointDesc__Group__0 ) ) )
            // InternalMMDesc.g:92:2: ( ( rule__PointDesc__Group__0 ) )
            {
            // InternalMMDesc.g:92:2: ( ( rule__PointDesc__Group__0 ) )
            // InternalMMDesc.g:93:3: ( rule__PointDesc__Group__0 )
            {
             before(grammarAccess.getPointDescAccess().getGroup()); 
            // InternalMMDesc.g:94:3: ( rule__PointDesc__Group__0 )
            // InternalMMDesc.g:94:4: rule__PointDesc__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PointDesc__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPointDescAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePointDesc"


    // $ANTLR start "entryRuleModelRef"
    // InternalMMDesc.g:103:1: entryRuleModelRef : ruleModelRef EOF ;
    public final void entryRuleModelRef() throws RecognitionException {
        try {
            // InternalMMDesc.g:104:1: ( ruleModelRef EOF )
            // InternalMMDesc.g:105:1: ruleModelRef EOF
            {
             before(grammarAccess.getModelRefRule()); 
            pushFollow(FOLLOW_1);
            ruleModelRef();

            state._fsp--;

             after(grammarAccess.getModelRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelRef"


    // $ANTLR start "ruleModelRef"
    // InternalMMDesc.g:112:1: ruleModelRef : ( ( rule__ModelRef__Group__0 ) ) ;
    public final void ruleModelRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:116:2: ( ( ( rule__ModelRef__Group__0 ) ) )
            // InternalMMDesc.g:117:2: ( ( rule__ModelRef__Group__0 ) )
            {
            // InternalMMDesc.g:117:2: ( ( rule__ModelRef__Group__0 ) )
            // InternalMMDesc.g:118:3: ( rule__ModelRef__Group__0 )
            {
             before(grammarAccess.getModelRefAccess().getGroup()); 
            // InternalMMDesc.g:119:3: ( rule__ModelRef__Group__0 )
            // InternalMMDesc.g:119:4: rule__ModelRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ModelRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelRef"


    // $ANTLR start "entryRuleModelView"
    // InternalMMDesc.g:128:1: entryRuleModelView : ruleModelView EOF ;
    public final void entryRuleModelView() throws RecognitionException {
        try {
            // InternalMMDesc.g:129:1: ( ruleModelView EOF )
            // InternalMMDesc.g:130:1: ruleModelView EOF
            {
             before(grammarAccess.getModelViewRule()); 
            pushFollow(FOLLOW_1);
            ruleModelView();

            state._fsp--;

             after(grammarAccess.getModelViewRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelView"


    // $ANTLR start "ruleModelView"
    // InternalMMDesc.g:137:1: ruleModelView : ( ( rule__ModelView__Group__0 ) ) ;
    public final void ruleModelView() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:141:2: ( ( ( rule__ModelView__Group__0 ) ) )
            // InternalMMDesc.g:142:2: ( ( rule__ModelView__Group__0 ) )
            {
            // InternalMMDesc.g:142:2: ( ( rule__ModelView__Group__0 ) )
            // InternalMMDesc.g:143:3: ( rule__ModelView__Group__0 )
            {
             before(grammarAccess.getModelViewAccess().getGroup()); 
            // InternalMMDesc.g:144:3: ( rule__ModelView__Group__0 )
            // InternalMMDesc.g:144:4: rule__ModelView__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ModelView__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelViewAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelView"


    // $ANTLR start "rule__PointDesc__Alternatives_3"
    // InternalMMDesc.g:152:1: rule__PointDesc__Alternatives_3 : ( ( ( rule__PointDesc__TypeAssignment_3_0 ) ) | ( ( rule__PointDesc__Group_3_1__0 ) ) );
    public final void rule__PointDesc__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:156:1: ( ( ( rule__PointDesc__TypeAssignment_3_0 ) ) | ( ( rule__PointDesc__Group_3_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) ) {
                alt1=1;
            }
            else if ( (LA1_0==20) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalMMDesc.g:157:2: ( ( rule__PointDesc__TypeAssignment_3_0 ) )
                    {
                    // InternalMMDesc.g:157:2: ( ( rule__PointDesc__TypeAssignment_3_0 ) )
                    // InternalMMDesc.g:158:3: ( rule__PointDesc__TypeAssignment_3_0 )
                    {
                     before(grammarAccess.getPointDescAccess().getTypeAssignment_3_0()); 
                    // InternalMMDesc.g:159:3: ( rule__PointDesc__TypeAssignment_3_0 )
                    // InternalMMDesc.g:159:4: rule__PointDesc__TypeAssignment_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PointDesc__TypeAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointDescAccess().getTypeAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMMDesc.g:163:2: ( ( rule__PointDesc__Group_3_1__0 ) )
                    {
                    // InternalMMDesc.g:163:2: ( ( rule__PointDesc__Group_3_1__0 ) )
                    // InternalMMDesc.g:164:3: ( rule__PointDesc__Group_3_1__0 )
                    {
                     before(grammarAccess.getPointDescAccess().getGroup_3_1()); 
                    // InternalMMDesc.g:165:3: ( rule__PointDesc__Group_3_1__0 )
                    // InternalMMDesc.g:165:4: rule__PointDesc__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PointDesc__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointDescAccess().getGroup_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Alternatives_3"


    // $ANTLR start "rule__PointDesc__Alternatives_3_1_1_1"
    // InternalMMDesc.g:173:1: rule__PointDesc__Alternatives_3_1_1_1 : ( ( ( rule__PointDesc__TypeAssignment_3_1_1_1_0 ) ) | ( ( rule__PointDesc__TypeAssignment_3_1_1_1_1 ) ) );
    public final void rule__PointDesc__Alternatives_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:177:1: ( ( ( rule__PointDesc__TypeAssignment_3_1_1_1_0 ) ) | ( ( rule__PointDesc__TypeAssignment_3_1_1_1_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==19) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMMDesc.g:178:2: ( ( rule__PointDesc__TypeAssignment_3_1_1_1_0 ) )
                    {
                    // InternalMMDesc.g:178:2: ( ( rule__PointDesc__TypeAssignment_3_1_1_1_0 ) )
                    // InternalMMDesc.g:179:3: ( rule__PointDesc__TypeAssignment_3_1_1_1_0 )
                    {
                     before(grammarAccess.getPointDescAccess().getTypeAssignment_3_1_1_1_0()); 
                    // InternalMMDesc.g:180:3: ( rule__PointDesc__TypeAssignment_3_1_1_1_0 )
                    // InternalMMDesc.g:180:4: rule__PointDesc__TypeAssignment_3_1_1_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PointDesc__TypeAssignment_3_1_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointDescAccess().getTypeAssignment_3_1_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMMDesc.g:184:2: ( ( rule__PointDesc__TypeAssignment_3_1_1_1_1 ) )
                    {
                    // InternalMMDesc.g:184:2: ( ( rule__PointDesc__TypeAssignment_3_1_1_1_1 ) )
                    // InternalMMDesc.g:185:3: ( rule__PointDesc__TypeAssignment_3_1_1_1_1 )
                    {
                     before(grammarAccess.getPointDescAccess().getTypeAssignment_3_1_1_1_1()); 
                    // InternalMMDesc.g:186:3: ( rule__PointDesc__TypeAssignment_3_1_1_1_1 )
                    // InternalMMDesc.g:186:4: rule__PointDesc__TypeAssignment_3_1_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__PointDesc__TypeAssignment_3_1_1_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointDescAccess().getTypeAssignment_3_1_1_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Alternatives_3_1_1_1"


    // $ANTLR start "rule__ModelRef__Alternatives_3_1"
    // InternalMMDesc.g:194:1: rule__ModelRef__Alternatives_3_1 : ( ( ( rule__ModelRef__DataAssignment_3_1_0 ) ) | ( RULE_ID ) | ( RULE_INT ) );
    public final void rule__ModelRef__Alternatives_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:198:1: ( ( ( rule__ModelRef__DataAssignment_3_1_0 ) ) | ( RULE_ID ) | ( RULE_INT ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt3=1;
                }
                break;
            case RULE_ID:
                {
                alt3=2;
                }
                break;
            case RULE_INT:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalMMDesc.g:199:2: ( ( rule__ModelRef__DataAssignment_3_1_0 ) )
                    {
                    // InternalMMDesc.g:199:2: ( ( rule__ModelRef__DataAssignment_3_1_0 ) )
                    // InternalMMDesc.g:200:3: ( rule__ModelRef__DataAssignment_3_1_0 )
                    {
                     before(grammarAccess.getModelRefAccess().getDataAssignment_3_1_0()); 
                    // InternalMMDesc.g:201:3: ( rule__ModelRef__DataAssignment_3_1_0 )
                    // InternalMMDesc.g:201:4: rule__ModelRef__DataAssignment_3_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ModelRef__DataAssignment_3_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelRefAccess().getDataAssignment_3_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMMDesc.g:205:2: ( RULE_ID )
                    {
                    // InternalMMDesc.g:205:2: ( RULE_ID )
                    // InternalMMDesc.g:206:3: RULE_ID
                    {
                     before(grammarAccess.getModelRefAccess().getIDTerminalRuleCall_3_1_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getModelRefAccess().getIDTerminalRuleCall_3_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMMDesc.g:211:2: ( RULE_INT )
                    {
                    // InternalMMDesc.g:211:2: ( RULE_INT )
                    // InternalMMDesc.g:212:3: RULE_INT
                    {
                     before(grammarAccess.getModelRefAccess().getINTTerminalRuleCall_3_1_2()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getModelRefAccess().getINTTerminalRuleCall_3_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Alternatives_3_1"


    // $ANTLR start "rule__MMDesc__Group__0"
    // InternalMMDesc.g:221:1: rule__MMDesc__Group__0 : rule__MMDesc__Group__0__Impl rule__MMDesc__Group__1 ;
    public final void rule__MMDesc__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:225:1: ( rule__MMDesc__Group__0__Impl rule__MMDesc__Group__1 )
            // InternalMMDesc.g:226:2: rule__MMDesc__Group__0__Impl rule__MMDesc__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__MMDesc__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MMDesc__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__Group__0"


    // $ANTLR start "rule__MMDesc__Group__0__Impl"
    // InternalMMDesc.g:233:1: rule__MMDesc__Group__0__Impl : ( ( rule__MMDesc__PointDescAssignment_0 ) ) ;
    public final void rule__MMDesc__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:237:1: ( ( ( rule__MMDesc__PointDescAssignment_0 ) ) )
            // InternalMMDesc.g:238:1: ( ( rule__MMDesc__PointDescAssignment_0 ) )
            {
            // InternalMMDesc.g:238:1: ( ( rule__MMDesc__PointDescAssignment_0 ) )
            // InternalMMDesc.g:239:2: ( rule__MMDesc__PointDescAssignment_0 )
            {
             before(grammarAccess.getMMDescAccess().getPointDescAssignment_0()); 
            // InternalMMDesc.g:240:2: ( rule__MMDesc__PointDescAssignment_0 )
            // InternalMMDesc.g:240:3: rule__MMDesc__PointDescAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MMDesc__PointDescAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMMDescAccess().getPointDescAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__Group__0__Impl"


    // $ANTLR start "rule__MMDesc__Group__1"
    // InternalMMDesc.g:248:1: rule__MMDesc__Group__1 : rule__MMDesc__Group__1__Impl rule__MMDesc__Group__2 ;
    public final void rule__MMDesc__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:252:1: ( rule__MMDesc__Group__1__Impl rule__MMDesc__Group__2 )
            // InternalMMDesc.g:253:2: rule__MMDesc__Group__1__Impl rule__MMDesc__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__MMDesc__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MMDesc__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__Group__1"


    // $ANTLR start "rule__MMDesc__Group__1__Impl"
    // InternalMMDesc.g:260:1: rule__MMDesc__Group__1__Impl : ( ( rule__MMDesc__ModelsAssignment_1 )* ) ;
    public final void rule__MMDesc__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:264:1: ( ( ( rule__MMDesc__ModelsAssignment_1 )* ) )
            // InternalMMDesc.g:265:1: ( ( rule__MMDesc__ModelsAssignment_1 )* )
            {
            // InternalMMDesc.g:265:1: ( ( rule__MMDesc__ModelsAssignment_1 )* )
            // InternalMMDesc.g:266:2: ( rule__MMDesc__ModelsAssignment_1 )*
            {
             before(grammarAccess.getMMDescAccess().getModelsAssignment_1()); 
            // InternalMMDesc.g:267:2: ( rule__MMDesc__ModelsAssignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMMDesc.g:267:3: rule__MMDesc__ModelsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__MMDesc__ModelsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getMMDescAccess().getModelsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__Group__1__Impl"


    // $ANTLR start "rule__MMDesc__Group__2"
    // InternalMMDesc.g:275:1: rule__MMDesc__Group__2 : rule__MMDesc__Group__2__Impl ;
    public final void rule__MMDesc__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:279:1: ( rule__MMDesc__Group__2__Impl )
            // InternalMMDesc.g:280:2: rule__MMDesc__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MMDesc__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__Group__2"


    // $ANTLR start "rule__MMDesc__Group__2__Impl"
    // InternalMMDesc.g:286:1: rule__MMDesc__Group__2__Impl : ( ( rule__MMDesc__ViewAssignment_2 )? ) ;
    public final void rule__MMDesc__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:290:1: ( ( ( rule__MMDesc__ViewAssignment_2 )? ) )
            // InternalMMDesc.g:291:1: ( ( rule__MMDesc__ViewAssignment_2 )? )
            {
            // InternalMMDesc.g:291:1: ( ( rule__MMDesc__ViewAssignment_2 )? )
            // InternalMMDesc.g:292:2: ( rule__MMDesc__ViewAssignment_2 )?
            {
             before(grammarAccess.getMMDescAccess().getViewAssignment_2()); 
            // InternalMMDesc.g:293:2: ( rule__MMDesc__ViewAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMMDesc.g:293:3: rule__MMDesc__ViewAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__MMDesc__ViewAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMMDescAccess().getViewAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__Group__2__Impl"


    // $ANTLR start "rule__PointDesc__Group__0"
    // InternalMMDesc.g:302:1: rule__PointDesc__Group__0 : rule__PointDesc__Group__0__Impl rule__PointDesc__Group__1 ;
    public final void rule__PointDesc__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:306:1: ( rule__PointDesc__Group__0__Impl rule__PointDesc__Group__1 )
            // InternalMMDesc.g:307:2: rule__PointDesc__Group__0__Impl rule__PointDesc__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__PointDesc__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointDesc__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__0"


    // $ANTLR start "rule__PointDesc__Group__0__Impl"
    // InternalMMDesc.g:314:1: rule__PointDesc__Group__0__Impl : ( () ) ;
    public final void rule__PointDesc__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:318:1: ( ( () ) )
            // InternalMMDesc.g:319:1: ( () )
            {
            // InternalMMDesc.g:319:1: ( () )
            // InternalMMDesc.g:320:2: ()
            {
             before(grammarAccess.getPointDescAccess().getPointDescAction_0()); 
            // InternalMMDesc.g:321:2: ()
            // InternalMMDesc.g:321:3: 
            {
            }

             after(grammarAccess.getPointDescAccess().getPointDescAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__0__Impl"


    // $ANTLR start "rule__PointDesc__Group__1"
    // InternalMMDesc.g:329:1: rule__PointDesc__Group__1 : rule__PointDesc__Group__1__Impl rule__PointDesc__Group__2 ;
    public final void rule__PointDesc__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:333:1: ( rule__PointDesc__Group__1__Impl rule__PointDesc__Group__2 )
            // InternalMMDesc.g:334:2: rule__PointDesc__Group__1__Impl rule__PointDesc__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__PointDesc__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointDesc__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__1"


    // $ANTLR start "rule__PointDesc__Group__1__Impl"
    // InternalMMDesc.g:341:1: rule__PointDesc__Group__1__Impl : ( 'PointDesc' ) ;
    public final void rule__PointDesc__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:345:1: ( ( 'PointDesc' ) )
            // InternalMMDesc.g:346:1: ( 'PointDesc' )
            {
            // InternalMMDesc.g:346:1: ( 'PointDesc' )
            // InternalMMDesc.g:347:2: 'PointDesc'
            {
             before(grammarAccess.getPointDescAccess().getPointDescKeyword_1()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getPointDescAccess().getPointDescKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__1__Impl"


    // $ANTLR start "rule__PointDesc__Group__2"
    // InternalMMDesc.g:356:1: rule__PointDesc__Group__2 : rule__PointDesc__Group__2__Impl rule__PointDesc__Group__3 ;
    public final void rule__PointDesc__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:360:1: ( rule__PointDesc__Group__2__Impl rule__PointDesc__Group__3 )
            // InternalMMDesc.g:361:2: rule__PointDesc__Group__2__Impl rule__PointDesc__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__PointDesc__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointDesc__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__2"


    // $ANTLR start "rule__PointDesc__Group__2__Impl"
    // InternalMMDesc.g:368:1: rule__PointDesc__Group__2__Impl : ( '[' ) ;
    public final void rule__PointDesc__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:372:1: ( ( '[' ) )
            // InternalMMDesc.g:373:1: ( '[' )
            {
            // InternalMMDesc.g:373:1: ( '[' )
            // InternalMMDesc.g:374:2: '['
            {
             before(grammarAccess.getPointDescAccess().getLeftSquareBracketKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getPointDescAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__2__Impl"


    // $ANTLR start "rule__PointDesc__Group__3"
    // InternalMMDesc.g:383:1: rule__PointDesc__Group__3 : rule__PointDesc__Group__3__Impl rule__PointDesc__Group__4 ;
    public final void rule__PointDesc__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:387:1: ( rule__PointDesc__Group__3__Impl rule__PointDesc__Group__4 )
            // InternalMMDesc.g:388:2: rule__PointDesc__Group__3__Impl rule__PointDesc__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__PointDesc__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointDesc__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__3"


    // $ANTLR start "rule__PointDesc__Group__3__Impl"
    // InternalMMDesc.g:395:1: rule__PointDesc__Group__3__Impl : ( ( rule__PointDesc__Alternatives_3 )? ) ;
    public final void rule__PointDesc__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:399:1: ( ( ( rule__PointDesc__Alternatives_3 )? ) )
            // InternalMMDesc.g:400:1: ( ( rule__PointDesc__Alternatives_3 )? )
            {
            // InternalMMDesc.g:400:1: ( ( rule__PointDesc__Alternatives_3 )? )
            // InternalMMDesc.g:401:2: ( rule__PointDesc__Alternatives_3 )?
            {
             before(grammarAccess.getPointDescAccess().getAlternatives_3()); 
            // InternalMMDesc.g:402:2: ( rule__PointDesc__Alternatives_3 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMMDesc.g:402:3: rule__PointDesc__Alternatives_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__PointDesc__Alternatives_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPointDescAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__3__Impl"


    // $ANTLR start "rule__PointDesc__Group__4"
    // InternalMMDesc.g:410:1: rule__PointDesc__Group__4 : rule__PointDesc__Group__4__Impl ;
    public final void rule__PointDesc__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:414:1: ( rule__PointDesc__Group__4__Impl )
            // InternalMMDesc.g:415:2: rule__PointDesc__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PointDesc__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__4"


    // $ANTLR start "rule__PointDesc__Group__4__Impl"
    // InternalMMDesc.g:421:1: rule__PointDesc__Group__4__Impl : ( ']' ) ;
    public final void rule__PointDesc__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:425:1: ( ( ']' ) )
            // InternalMMDesc.g:426:1: ( ']' )
            {
            // InternalMMDesc.g:426:1: ( ']' )
            // InternalMMDesc.g:427:2: ']'
            {
             before(grammarAccess.getPointDescAccess().getRightSquareBracketKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getPointDescAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group__4__Impl"


    // $ANTLR start "rule__PointDesc__Group_3_1__0"
    // InternalMMDesc.g:437:1: rule__PointDesc__Group_3_1__0 : rule__PointDesc__Group_3_1__0__Impl rule__PointDesc__Group_3_1__1 ;
    public final void rule__PointDesc__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:441:1: ( rule__PointDesc__Group_3_1__0__Impl rule__PointDesc__Group_3_1__1 )
            // InternalMMDesc.g:442:2: rule__PointDesc__Group_3_1__0__Impl rule__PointDesc__Group_3_1__1
            {
            pushFollow(FOLLOW_8);
            rule__PointDesc__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointDesc__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group_3_1__0"


    // $ANTLR start "rule__PointDesc__Group_3_1__0__Impl"
    // InternalMMDesc.g:449:1: rule__PointDesc__Group_3_1__0__Impl : ( ( rule__PointDesc__TypeAssignment_3_1_0 ) ) ;
    public final void rule__PointDesc__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:453:1: ( ( ( rule__PointDesc__TypeAssignment_3_1_0 ) ) )
            // InternalMMDesc.g:454:1: ( ( rule__PointDesc__TypeAssignment_3_1_0 ) )
            {
            // InternalMMDesc.g:454:1: ( ( rule__PointDesc__TypeAssignment_3_1_0 ) )
            // InternalMMDesc.g:455:2: ( rule__PointDesc__TypeAssignment_3_1_0 )
            {
             before(grammarAccess.getPointDescAccess().getTypeAssignment_3_1_0()); 
            // InternalMMDesc.g:456:2: ( rule__PointDesc__TypeAssignment_3_1_0 )
            // InternalMMDesc.g:456:3: rule__PointDesc__TypeAssignment_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PointDesc__TypeAssignment_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getPointDescAccess().getTypeAssignment_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group_3_1__0__Impl"


    // $ANTLR start "rule__PointDesc__Group_3_1__1"
    // InternalMMDesc.g:464:1: rule__PointDesc__Group_3_1__1 : rule__PointDesc__Group_3_1__1__Impl ;
    public final void rule__PointDesc__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:468:1: ( rule__PointDesc__Group_3_1__1__Impl )
            // InternalMMDesc.g:469:2: rule__PointDesc__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PointDesc__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group_3_1__1"


    // $ANTLR start "rule__PointDesc__Group_3_1__1__Impl"
    // InternalMMDesc.g:475:1: rule__PointDesc__Group_3_1__1__Impl : ( ( rule__PointDesc__Group_3_1_1__0 )* ) ;
    public final void rule__PointDesc__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:479:1: ( ( ( rule__PointDesc__Group_3_1_1__0 )* ) )
            // InternalMMDesc.g:480:1: ( ( rule__PointDesc__Group_3_1_1__0 )* )
            {
            // InternalMMDesc.g:480:1: ( ( rule__PointDesc__Group_3_1_1__0 )* )
            // InternalMMDesc.g:481:2: ( rule__PointDesc__Group_3_1_1__0 )*
            {
             before(grammarAccess.getPointDescAccess().getGroup_3_1_1()); 
            // InternalMMDesc.g:482:2: ( rule__PointDesc__Group_3_1_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMMDesc.g:482:3: rule__PointDesc__Group_3_1_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__PointDesc__Group_3_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getPointDescAccess().getGroup_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group_3_1__1__Impl"


    // $ANTLR start "rule__PointDesc__Group_3_1_1__0"
    // InternalMMDesc.g:491:1: rule__PointDesc__Group_3_1_1__0 : rule__PointDesc__Group_3_1_1__0__Impl rule__PointDesc__Group_3_1_1__1 ;
    public final void rule__PointDesc__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:495:1: ( rule__PointDesc__Group_3_1_1__0__Impl rule__PointDesc__Group_3_1_1__1 )
            // InternalMMDesc.g:496:2: rule__PointDesc__Group_3_1_1__0__Impl rule__PointDesc__Group_3_1_1__1
            {
            pushFollow(FOLLOW_10);
            rule__PointDesc__Group_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointDesc__Group_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group_3_1_1__0"


    // $ANTLR start "rule__PointDesc__Group_3_1_1__0__Impl"
    // InternalMMDesc.g:503:1: rule__PointDesc__Group_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__PointDesc__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:507:1: ( ( ',' ) )
            // InternalMMDesc.g:508:1: ( ',' )
            {
            // InternalMMDesc.g:508:1: ( ',' )
            // InternalMMDesc.g:509:2: ','
            {
             before(grammarAccess.getPointDescAccess().getCommaKeyword_3_1_1_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getPointDescAccess().getCommaKeyword_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group_3_1_1__0__Impl"


    // $ANTLR start "rule__PointDesc__Group_3_1_1__1"
    // InternalMMDesc.g:518:1: rule__PointDesc__Group_3_1_1__1 : rule__PointDesc__Group_3_1_1__1__Impl ;
    public final void rule__PointDesc__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:522:1: ( rule__PointDesc__Group_3_1_1__1__Impl )
            // InternalMMDesc.g:523:2: rule__PointDesc__Group_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PointDesc__Group_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group_3_1_1__1"


    // $ANTLR start "rule__PointDesc__Group_3_1_1__1__Impl"
    // InternalMMDesc.g:529:1: rule__PointDesc__Group_3_1_1__1__Impl : ( ( rule__PointDesc__Alternatives_3_1_1_1 ) ) ;
    public final void rule__PointDesc__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:533:1: ( ( ( rule__PointDesc__Alternatives_3_1_1_1 ) ) )
            // InternalMMDesc.g:534:1: ( ( rule__PointDesc__Alternatives_3_1_1_1 ) )
            {
            // InternalMMDesc.g:534:1: ( ( rule__PointDesc__Alternatives_3_1_1_1 ) )
            // InternalMMDesc.g:535:2: ( rule__PointDesc__Alternatives_3_1_1_1 )
            {
             before(grammarAccess.getPointDescAccess().getAlternatives_3_1_1_1()); 
            // InternalMMDesc.g:536:2: ( rule__PointDesc__Alternatives_3_1_1_1 )
            // InternalMMDesc.g:536:3: rule__PointDesc__Alternatives_3_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PointDesc__Alternatives_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPointDescAccess().getAlternatives_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__Group_3_1_1__1__Impl"


    // $ANTLR start "rule__ModelRef__Group__0"
    // InternalMMDesc.g:545:1: rule__ModelRef__Group__0 : rule__ModelRef__Group__0__Impl rule__ModelRef__Group__1 ;
    public final void rule__ModelRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:549:1: ( rule__ModelRef__Group__0__Impl rule__ModelRef__Group__1 )
            // InternalMMDesc.g:550:2: rule__ModelRef__Group__0__Impl rule__ModelRef__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__ModelRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__0"


    // $ANTLR start "rule__ModelRef__Group__0__Impl"
    // InternalMMDesc.g:557:1: rule__ModelRef__Group__0__Impl : ( 'model' ) ;
    public final void rule__ModelRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:561:1: ( ( 'model' ) )
            // InternalMMDesc.g:562:1: ( 'model' )
            {
            // InternalMMDesc.g:562:1: ( 'model' )
            // InternalMMDesc.g:563:2: 'model'
            {
             before(grammarAccess.getModelRefAccess().getModelKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getModelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__0__Impl"


    // $ANTLR start "rule__ModelRef__Group__1"
    // InternalMMDesc.g:572:1: rule__ModelRef__Group__1 : rule__ModelRef__Group__1__Impl rule__ModelRef__Group__2 ;
    public final void rule__ModelRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:576:1: ( rule__ModelRef__Group__1__Impl rule__ModelRef__Group__2 )
            // InternalMMDesc.g:577:2: rule__ModelRef__Group__1__Impl rule__ModelRef__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__ModelRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__1"


    // $ANTLR start "rule__ModelRef__Group__1__Impl"
    // InternalMMDesc.g:584:1: rule__ModelRef__Group__1__Impl : ( ( rule__ModelRef__IdAssignment_1 ) ) ;
    public final void rule__ModelRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:588:1: ( ( ( rule__ModelRef__IdAssignment_1 ) ) )
            // InternalMMDesc.g:589:1: ( ( rule__ModelRef__IdAssignment_1 ) )
            {
            // InternalMMDesc.g:589:1: ( ( rule__ModelRef__IdAssignment_1 ) )
            // InternalMMDesc.g:590:2: ( rule__ModelRef__IdAssignment_1 )
            {
             before(grammarAccess.getModelRefAccess().getIdAssignment_1()); 
            // InternalMMDesc.g:591:2: ( rule__ModelRef__IdAssignment_1 )
            // InternalMMDesc.g:591:3: rule__ModelRef__IdAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ModelRef__IdAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelRefAccess().getIdAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__1__Impl"


    // $ANTLR start "rule__ModelRef__Group__2"
    // InternalMMDesc.g:599:1: rule__ModelRef__Group__2 : rule__ModelRef__Group__2__Impl rule__ModelRef__Group__3 ;
    public final void rule__ModelRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:603:1: ( rule__ModelRef__Group__2__Impl rule__ModelRef__Group__3 )
            // InternalMMDesc.g:604:2: rule__ModelRef__Group__2__Impl rule__ModelRef__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__ModelRef__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__2"


    // $ANTLR start "rule__ModelRef__Group__2__Impl"
    // InternalMMDesc.g:611:1: rule__ModelRef__Group__2__Impl : ( ( rule__ModelRef__UriAssignment_2 ) ) ;
    public final void rule__ModelRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:615:1: ( ( ( rule__ModelRef__UriAssignment_2 ) ) )
            // InternalMMDesc.g:616:1: ( ( rule__ModelRef__UriAssignment_2 ) )
            {
            // InternalMMDesc.g:616:1: ( ( rule__ModelRef__UriAssignment_2 ) )
            // InternalMMDesc.g:617:2: ( rule__ModelRef__UriAssignment_2 )
            {
             before(grammarAccess.getModelRefAccess().getUriAssignment_2()); 
            // InternalMMDesc.g:618:2: ( rule__ModelRef__UriAssignment_2 )
            // InternalMMDesc.g:618:3: rule__ModelRef__UriAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ModelRef__UriAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelRefAccess().getUriAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__2__Impl"


    // $ANTLR start "rule__ModelRef__Group__3"
    // InternalMMDesc.g:626:1: rule__ModelRef__Group__3 : rule__ModelRef__Group__3__Impl rule__ModelRef__Group__4 ;
    public final void rule__ModelRef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:630:1: ( rule__ModelRef__Group__3__Impl rule__ModelRef__Group__4 )
            // InternalMMDesc.g:631:2: rule__ModelRef__Group__3__Impl rule__ModelRef__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__ModelRef__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__3"


    // $ANTLR start "rule__ModelRef__Group__3__Impl"
    // InternalMMDesc.g:638:1: rule__ModelRef__Group__3__Impl : ( ( rule__ModelRef__Group_3__0 )? ) ;
    public final void rule__ModelRef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:642:1: ( ( ( rule__ModelRef__Group_3__0 )? ) )
            // InternalMMDesc.g:643:1: ( ( rule__ModelRef__Group_3__0 )? )
            {
            // InternalMMDesc.g:643:1: ( ( rule__ModelRef__Group_3__0 )? )
            // InternalMMDesc.g:644:2: ( rule__ModelRef__Group_3__0 )?
            {
             before(grammarAccess.getModelRefAccess().getGroup_3()); 
            // InternalMMDesc.g:645:2: ( rule__ModelRef__Group_3__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==12) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMMDesc.g:645:3: rule__ModelRef__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ModelRef__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelRefAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__3__Impl"


    // $ANTLR start "rule__ModelRef__Group__4"
    // InternalMMDesc.g:653:1: rule__ModelRef__Group__4 : rule__ModelRef__Group__4__Impl rule__ModelRef__Group__5 ;
    public final void rule__ModelRef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:657:1: ( rule__ModelRef__Group__4__Impl rule__ModelRef__Group__5 )
            // InternalMMDesc.g:658:2: rule__ModelRef__Group__4__Impl rule__ModelRef__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__ModelRef__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__4"


    // $ANTLR start "rule__ModelRef__Group__4__Impl"
    // InternalMMDesc.g:665:1: rule__ModelRef__Group__4__Impl : ( ( rule__ModelRef__Group_4__0 )? ) ;
    public final void rule__ModelRef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:669:1: ( ( ( rule__ModelRef__Group_4__0 )? ) )
            // InternalMMDesc.g:670:1: ( ( rule__ModelRef__Group_4__0 )? )
            {
            // InternalMMDesc.g:670:1: ( ( rule__ModelRef__Group_4__0 )? )
            // InternalMMDesc.g:671:2: ( rule__ModelRef__Group_4__0 )?
            {
             before(grammarAccess.getModelRefAccess().getGroup_4()); 
            // InternalMMDesc.g:672:2: ( rule__ModelRef__Group_4__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMMDesc.g:672:3: rule__ModelRef__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ModelRef__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelRefAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__4__Impl"


    // $ANTLR start "rule__ModelRef__Group__5"
    // InternalMMDesc.g:680:1: rule__ModelRef__Group__5 : rule__ModelRef__Group__5__Impl ;
    public final void rule__ModelRef__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:684:1: ( rule__ModelRef__Group__5__Impl )
            // InternalMMDesc.g:685:2: rule__ModelRef__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelRef__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__5"


    // $ANTLR start "rule__ModelRef__Group__5__Impl"
    // InternalMMDesc.g:691:1: rule__ModelRef__Group__5__Impl : ( ( rule__ModelRef__ContinueAssignment_5 )? ) ;
    public final void rule__ModelRef__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:695:1: ( ( ( rule__ModelRef__ContinueAssignment_5 )? ) )
            // InternalMMDesc.g:696:1: ( ( rule__ModelRef__ContinueAssignment_5 )? )
            {
            // InternalMMDesc.g:696:1: ( ( rule__ModelRef__ContinueAssignment_5 )? )
            // InternalMMDesc.g:697:2: ( rule__ModelRef__ContinueAssignment_5 )?
            {
             before(grammarAccess.getModelRefAccess().getContinueAssignment_5()); 
            // InternalMMDesc.g:698:2: ( rule__ModelRef__ContinueAssignment_5 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMMDesc.g:698:3: rule__ModelRef__ContinueAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__ModelRef__ContinueAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelRefAccess().getContinueAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group__5__Impl"


    // $ANTLR start "rule__ModelRef__Group_3__0"
    // InternalMMDesc.g:707:1: rule__ModelRef__Group_3__0 : rule__ModelRef__Group_3__0__Impl rule__ModelRef__Group_3__1 ;
    public final void rule__ModelRef__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:711:1: ( rule__ModelRef__Group_3__0__Impl rule__ModelRef__Group_3__1 )
            // InternalMMDesc.g:712:2: rule__ModelRef__Group_3__0__Impl rule__ModelRef__Group_3__1
            {
            pushFollow(FOLLOW_14);
            rule__ModelRef__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_3__0"


    // $ANTLR start "rule__ModelRef__Group_3__0__Impl"
    // InternalMMDesc.g:719:1: rule__ModelRef__Group_3__0__Impl : ( '[' ) ;
    public final void rule__ModelRef__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:723:1: ( ( '[' ) )
            // InternalMMDesc.g:724:1: ( '[' )
            {
            // InternalMMDesc.g:724:1: ( '[' )
            // InternalMMDesc.g:725:2: '['
            {
             before(grammarAccess.getModelRefAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getLeftSquareBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_3__0__Impl"


    // $ANTLR start "rule__ModelRef__Group_3__1"
    // InternalMMDesc.g:734:1: rule__ModelRef__Group_3__1 : rule__ModelRef__Group_3__1__Impl rule__ModelRef__Group_3__2 ;
    public final void rule__ModelRef__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:738:1: ( rule__ModelRef__Group_3__1__Impl rule__ModelRef__Group_3__2 )
            // InternalMMDesc.g:739:2: rule__ModelRef__Group_3__1__Impl rule__ModelRef__Group_3__2
            {
            pushFollow(FOLLOW_15);
            rule__ModelRef__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_3__1"


    // $ANTLR start "rule__ModelRef__Group_3__1__Impl"
    // InternalMMDesc.g:746:1: rule__ModelRef__Group_3__1__Impl : ( ( rule__ModelRef__Alternatives_3_1 ) ) ;
    public final void rule__ModelRef__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:750:1: ( ( ( rule__ModelRef__Alternatives_3_1 ) ) )
            // InternalMMDesc.g:751:1: ( ( rule__ModelRef__Alternatives_3_1 ) )
            {
            // InternalMMDesc.g:751:1: ( ( rule__ModelRef__Alternatives_3_1 ) )
            // InternalMMDesc.g:752:2: ( rule__ModelRef__Alternatives_3_1 )
            {
             before(grammarAccess.getModelRefAccess().getAlternatives_3_1()); 
            // InternalMMDesc.g:753:2: ( rule__ModelRef__Alternatives_3_1 )
            // InternalMMDesc.g:753:3: rule__ModelRef__Alternatives_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ModelRef__Alternatives_3_1();

            state._fsp--;


            }

             after(grammarAccess.getModelRefAccess().getAlternatives_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_3__1__Impl"


    // $ANTLR start "rule__ModelRef__Group_3__2"
    // InternalMMDesc.g:761:1: rule__ModelRef__Group_3__2 : rule__ModelRef__Group_3__2__Impl ;
    public final void rule__ModelRef__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:765:1: ( rule__ModelRef__Group_3__2__Impl )
            // InternalMMDesc.g:766:2: rule__ModelRef__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelRef__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_3__2"


    // $ANTLR start "rule__ModelRef__Group_3__2__Impl"
    // InternalMMDesc.g:772:1: rule__ModelRef__Group_3__2__Impl : ( ']' ) ;
    public final void rule__ModelRef__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:776:1: ( ( ']' ) )
            // InternalMMDesc.g:777:1: ( ']' )
            {
            // InternalMMDesc.g:777:1: ( ']' )
            // InternalMMDesc.g:778:2: ']'
            {
             before(grammarAccess.getModelRefAccess().getRightSquareBracketKeyword_3_2()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getRightSquareBracketKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_3__2__Impl"


    // $ANTLR start "rule__ModelRef__Group_4__0"
    // InternalMMDesc.g:788:1: rule__ModelRef__Group_4__0 : rule__ModelRef__Group_4__0__Impl rule__ModelRef__Group_4__1 ;
    public final void rule__ModelRef__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:792:1: ( rule__ModelRef__Group_4__0__Impl rule__ModelRef__Group_4__1 )
            // InternalMMDesc.g:793:2: rule__ModelRef__Group_4__0__Impl rule__ModelRef__Group_4__1
            {
            pushFollow(FOLLOW_16);
            rule__ModelRef__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_4__0"


    // $ANTLR start "rule__ModelRef__Group_4__0__Impl"
    // InternalMMDesc.g:800:1: rule__ModelRef__Group_4__0__Impl : ( '{' ) ;
    public final void rule__ModelRef__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:804:1: ( ( '{' ) )
            // InternalMMDesc.g:805:1: ( '{' )
            {
            // InternalMMDesc.g:805:1: ( '{' )
            // InternalMMDesc.g:806:2: '{'
            {
             before(grammarAccess.getModelRefAccess().getLeftCurlyBracketKeyword_4_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getLeftCurlyBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_4__0__Impl"


    // $ANTLR start "rule__ModelRef__Group_4__1"
    // InternalMMDesc.g:815:1: rule__ModelRef__Group_4__1 : rule__ModelRef__Group_4__1__Impl rule__ModelRef__Group_4__2 ;
    public final void rule__ModelRef__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:819:1: ( rule__ModelRef__Group_4__1__Impl rule__ModelRef__Group_4__2 )
            // InternalMMDesc.g:820:2: rule__ModelRef__Group_4__1__Impl rule__ModelRef__Group_4__2
            {
            pushFollow(FOLLOW_16);
            rule__ModelRef__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelRef__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_4__1"


    // $ANTLR start "rule__ModelRef__Group_4__1__Impl"
    // InternalMMDesc.g:827:1: rule__ModelRef__Group_4__1__Impl : ( ( rule__ModelRef__NextAssignment_4_1 )* ) ;
    public final void rule__ModelRef__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:831:1: ( ( ( rule__ModelRef__NextAssignment_4_1 )* ) )
            // InternalMMDesc.g:832:1: ( ( rule__ModelRef__NextAssignment_4_1 )* )
            {
            // InternalMMDesc.g:832:1: ( ( rule__ModelRef__NextAssignment_4_1 )* )
            // InternalMMDesc.g:833:2: ( rule__ModelRef__NextAssignment_4_1 )*
            {
             before(grammarAccess.getModelRefAccess().getNextAssignment_4_1()); 
            // InternalMMDesc.g:834:2: ( rule__ModelRef__NextAssignment_4_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMMDesc.g:834:3: rule__ModelRef__NextAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__ModelRef__NextAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelRefAccess().getNextAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_4__1__Impl"


    // $ANTLR start "rule__ModelRef__Group_4__2"
    // InternalMMDesc.g:842:1: rule__ModelRef__Group_4__2 : rule__ModelRef__Group_4__2__Impl ;
    public final void rule__ModelRef__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:846:1: ( rule__ModelRef__Group_4__2__Impl )
            // InternalMMDesc.g:847:2: rule__ModelRef__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelRef__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_4__2"


    // $ANTLR start "rule__ModelRef__Group_4__2__Impl"
    // InternalMMDesc.g:853:1: rule__ModelRef__Group_4__2__Impl : ( '}' ) ;
    public final void rule__ModelRef__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:857:1: ( ( '}' ) )
            // InternalMMDesc.g:858:1: ( '}' )
            {
            // InternalMMDesc.g:858:1: ( '}' )
            // InternalMMDesc.g:859:2: '}'
            {
             before(grammarAccess.getModelRefAccess().getRightCurlyBracketKeyword_4_2()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getRightCurlyBracketKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__Group_4__2__Impl"


    // $ANTLR start "rule__ModelView__Group__0"
    // InternalMMDesc.g:869:1: rule__ModelView__Group__0 : rule__ModelView__Group__0__Impl rule__ModelView__Group__1 ;
    public final void rule__ModelView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:873:1: ( rule__ModelView__Group__0__Impl rule__ModelView__Group__1 )
            // InternalMMDesc.g:874:2: rule__ModelView__Group__0__Impl rule__ModelView__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__ModelView__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelView__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__0"


    // $ANTLR start "rule__ModelView__Group__0__Impl"
    // InternalMMDesc.g:881:1: rule__ModelView__Group__0__Impl : ( () ) ;
    public final void rule__ModelView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:885:1: ( ( () ) )
            // InternalMMDesc.g:886:1: ( () )
            {
            // InternalMMDesc.g:886:1: ( () )
            // InternalMMDesc.g:887:2: ()
            {
             before(grammarAccess.getModelViewAccess().getModelViewAction_0()); 
            // InternalMMDesc.g:888:2: ()
            // InternalMMDesc.g:888:3: 
            {
            }

             after(grammarAccess.getModelViewAccess().getModelViewAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__0__Impl"


    // $ANTLR start "rule__ModelView__Group__1"
    // InternalMMDesc.g:896:1: rule__ModelView__Group__1 : rule__ModelView__Group__1__Impl rule__ModelView__Group__2 ;
    public final void rule__ModelView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:900:1: ( rule__ModelView__Group__1__Impl rule__ModelView__Group__2 )
            // InternalMMDesc.g:901:2: rule__ModelView__Group__1__Impl rule__ModelView__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__ModelView__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelView__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__1"


    // $ANTLR start "rule__ModelView__Group__1__Impl"
    // InternalMMDesc.g:908:1: rule__ModelView__Group__1__Impl : ( 'view' ) ;
    public final void rule__ModelView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:912:1: ( ( 'view' ) )
            // InternalMMDesc.g:913:1: ( 'view' )
            {
            // InternalMMDesc.g:913:1: ( 'view' )
            // InternalMMDesc.g:914:2: 'view'
            {
             before(grammarAccess.getModelViewAccess().getViewKeyword_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getModelViewAccess().getViewKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__1__Impl"


    // $ANTLR start "rule__ModelView__Group__2"
    // InternalMMDesc.g:923:1: rule__ModelView__Group__2 : rule__ModelView__Group__2__Impl rule__ModelView__Group__3 ;
    public final void rule__ModelView__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:927:1: ( rule__ModelView__Group__2__Impl rule__ModelView__Group__3 )
            // InternalMMDesc.g:928:2: rule__ModelView__Group__2__Impl rule__ModelView__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__ModelView__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelView__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__2"


    // $ANTLR start "rule__ModelView__Group__2__Impl"
    // InternalMMDesc.g:935:1: rule__ModelView__Group__2__Impl : ( '[' ) ;
    public final void rule__ModelView__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:939:1: ( ( '[' ) )
            // InternalMMDesc.g:940:1: ( '[' )
            {
            // InternalMMDesc.g:940:1: ( '[' )
            // InternalMMDesc.g:941:2: '['
            {
             before(grammarAccess.getModelViewAccess().getLeftSquareBracketKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getModelViewAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__2__Impl"


    // $ANTLR start "rule__ModelView__Group__3"
    // InternalMMDesc.g:950:1: rule__ModelView__Group__3 : rule__ModelView__Group__3__Impl rule__ModelView__Group__4 ;
    public final void rule__ModelView__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:954:1: ( rule__ModelView__Group__3__Impl rule__ModelView__Group__4 )
            // InternalMMDesc.g:955:2: rule__ModelView__Group__3__Impl rule__ModelView__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__ModelView__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelView__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__3"


    // $ANTLR start "rule__ModelView__Group__3__Impl"
    // InternalMMDesc.g:962:1: rule__ModelView__Group__3__Impl : ( ( rule__ModelView__Group_3__0 )? ) ;
    public final void rule__ModelView__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:966:1: ( ( ( rule__ModelView__Group_3__0 )? ) )
            // InternalMMDesc.g:967:1: ( ( rule__ModelView__Group_3__0 )? )
            {
            // InternalMMDesc.g:967:1: ( ( rule__ModelView__Group_3__0 )? )
            // InternalMMDesc.g:968:2: ( rule__ModelView__Group_3__0 )?
            {
             before(grammarAccess.getModelViewAccess().getGroup_3()); 
            // InternalMMDesc.g:969:2: ( rule__ModelView__Group_3__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMMDesc.g:969:3: rule__ModelView__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ModelView__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelViewAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__3__Impl"


    // $ANTLR start "rule__ModelView__Group__4"
    // InternalMMDesc.g:977:1: rule__ModelView__Group__4 : rule__ModelView__Group__4__Impl ;
    public final void rule__ModelView__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:981:1: ( rule__ModelView__Group__4__Impl )
            // InternalMMDesc.g:982:2: rule__ModelView__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelView__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__4"


    // $ANTLR start "rule__ModelView__Group__4__Impl"
    // InternalMMDesc.g:988:1: rule__ModelView__Group__4__Impl : ( ']' ) ;
    public final void rule__ModelView__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:992:1: ( ( ']' ) )
            // InternalMMDesc.g:993:1: ( ']' )
            {
            // InternalMMDesc.g:993:1: ( ']' )
            // InternalMMDesc.g:994:2: ']'
            {
             before(grammarAccess.getModelViewAccess().getRightSquareBracketKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getModelViewAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group__4__Impl"


    // $ANTLR start "rule__ModelView__Group_3__0"
    // InternalMMDesc.g:1004:1: rule__ModelView__Group_3__0 : rule__ModelView__Group_3__0__Impl rule__ModelView__Group_3__1 ;
    public final void rule__ModelView__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1008:1: ( rule__ModelView__Group_3__0__Impl rule__ModelView__Group_3__1 )
            // InternalMMDesc.g:1009:2: rule__ModelView__Group_3__0__Impl rule__ModelView__Group_3__1
            {
            pushFollow(FOLLOW_8);
            rule__ModelView__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelView__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group_3__0"


    // $ANTLR start "rule__ModelView__Group_3__0__Impl"
    // InternalMMDesc.g:1016:1: rule__ModelView__Group_3__0__Impl : ( ( rule__ModelView__ViewedAssignment_3_0 ) ) ;
    public final void rule__ModelView__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1020:1: ( ( ( rule__ModelView__ViewedAssignment_3_0 ) ) )
            // InternalMMDesc.g:1021:1: ( ( rule__ModelView__ViewedAssignment_3_0 ) )
            {
            // InternalMMDesc.g:1021:1: ( ( rule__ModelView__ViewedAssignment_3_0 ) )
            // InternalMMDesc.g:1022:2: ( rule__ModelView__ViewedAssignment_3_0 )
            {
             before(grammarAccess.getModelViewAccess().getViewedAssignment_3_0()); 
            // InternalMMDesc.g:1023:2: ( rule__ModelView__ViewedAssignment_3_0 )
            // InternalMMDesc.g:1023:3: rule__ModelView__ViewedAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ModelView__ViewedAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getModelViewAccess().getViewedAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group_3__0__Impl"


    // $ANTLR start "rule__ModelView__Group_3__1"
    // InternalMMDesc.g:1031:1: rule__ModelView__Group_3__1 : rule__ModelView__Group_3__1__Impl ;
    public final void rule__ModelView__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1035:1: ( rule__ModelView__Group_3__1__Impl )
            // InternalMMDesc.g:1036:2: rule__ModelView__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelView__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group_3__1"


    // $ANTLR start "rule__ModelView__Group_3__1__Impl"
    // InternalMMDesc.g:1042:1: rule__ModelView__Group_3__1__Impl : ( ( rule__ModelView__Group_3_1__0 )* ) ;
    public final void rule__ModelView__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1046:1: ( ( ( rule__ModelView__Group_3_1__0 )* ) )
            // InternalMMDesc.g:1047:1: ( ( rule__ModelView__Group_3_1__0 )* )
            {
            // InternalMMDesc.g:1047:1: ( ( rule__ModelView__Group_3_1__0 )* )
            // InternalMMDesc.g:1048:2: ( rule__ModelView__Group_3_1__0 )*
            {
             before(grammarAccess.getModelViewAccess().getGroup_3_1()); 
            // InternalMMDesc.g:1049:2: ( rule__ModelView__Group_3_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==14) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMMDesc.g:1049:3: rule__ModelView__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ModelView__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getModelViewAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group_3__1__Impl"


    // $ANTLR start "rule__ModelView__Group_3_1__0"
    // InternalMMDesc.g:1058:1: rule__ModelView__Group_3_1__0 : rule__ModelView__Group_3_1__0__Impl rule__ModelView__Group_3_1__1 ;
    public final void rule__ModelView__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1062:1: ( rule__ModelView__Group_3_1__0__Impl rule__ModelView__Group_3_1__1 )
            // InternalMMDesc.g:1063:2: rule__ModelView__Group_3_1__0__Impl rule__ModelView__Group_3_1__1
            {
            pushFollow(FOLLOW_19);
            rule__ModelView__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelView__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group_3_1__0"


    // $ANTLR start "rule__ModelView__Group_3_1__0__Impl"
    // InternalMMDesc.g:1070:1: rule__ModelView__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__ModelView__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1074:1: ( ( ',' ) )
            // InternalMMDesc.g:1075:1: ( ',' )
            {
            // InternalMMDesc.g:1075:1: ( ',' )
            // InternalMMDesc.g:1076:2: ','
            {
             before(grammarAccess.getModelViewAccess().getCommaKeyword_3_1_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getModelViewAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group_3_1__0__Impl"


    // $ANTLR start "rule__ModelView__Group_3_1__1"
    // InternalMMDesc.g:1085:1: rule__ModelView__Group_3_1__1 : rule__ModelView__Group_3_1__1__Impl ;
    public final void rule__ModelView__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1089:1: ( rule__ModelView__Group_3_1__1__Impl )
            // InternalMMDesc.g:1090:2: rule__ModelView__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelView__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group_3_1__1"


    // $ANTLR start "rule__ModelView__Group_3_1__1__Impl"
    // InternalMMDesc.g:1096:1: rule__ModelView__Group_3_1__1__Impl : ( ( rule__ModelView__ViewedAssignment_3_1_1 ) ) ;
    public final void rule__ModelView__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1100:1: ( ( ( rule__ModelView__ViewedAssignment_3_1_1 ) ) )
            // InternalMMDesc.g:1101:1: ( ( rule__ModelView__ViewedAssignment_3_1_1 ) )
            {
            // InternalMMDesc.g:1101:1: ( ( rule__ModelView__ViewedAssignment_3_1_1 ) )
            // InternalMMDesc.g:1102:2: ( rule__ModelView__ViewedAssignment_3_1_1 )
            {
             before(grammarAccess.getModelViewAccess().getViewedAssignment_3_1_1()); 
            // InternalMMDesc.g:1103:2: ( rule__ModelView__ViewedAssignment_3_1_1 )
            // InternalMMDesc.g:1103:3: rule__ModelView__ViewedAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ModelView__ViewedAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModelViewAccess().getViewedAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__Group_3_1__1__Impl"


    // $ANTLR start "rule__MMDesc__PointDescAssignment_0"
    // InternalMMDesc.g:1112:1: rule__MMDesc__PointDescAssignment_0 : ( rulePointDesc ) ;
    public final void rule__MMDesc__PointDescAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1116:1: ( ( rulePointDesc ) )
            // InternalMMDesc.g:1117:2: ( rulePointDesc )
            {
            // InternalMMDesc.g:1117:2: ( rulePointDesc )
            // InternalMMDesc.g:1118:3: rulePointDesc
            {
             before(grammarAccess.getMMDescAccess().getPointDescPointDescParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePointDesc();

            state._fsp--;

             after(grammarAccess.getMMDescAccess().getPointDescPointDescParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__PointDescAssignment_0"


    // $ANTLR start "rule__MMDesc__ModelsAssignment_1"
    // InternalMMDesc.g:1127:1: rule__MMDesc__ModelsAssignment_1 : ( ruleModelRef ) ;
    public final void rule__MMDesc__ModelsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1131:1: ( ( ruleModelRef ) )
            // InternalMMDesc.g:1132:2: ( ruleModelRef )
            {
            // InternalMMDesc.g:1132:2: ( ruleModelRef )
            // InternalMMDesc.g:1133:3: ruleModelRef
            {
             before(grammarAccess.getMMDescAccess().getModelsModelRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleModelRef();

            state._fsp--;

             after(grammarAccess.getMMDescAccess().getModelsModelRefParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__ModelsAssignment_1"


    // $ANTLR start "rule__MMDesc__ViewAssignment_2"
    // InternalMMDesc.g:1142:1: rule__MMDesc__ViewAssignment_2 : ( ruleModelView ) ;
    public final void rule__MMDesc__ViewAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1146:1: ( ( ruleModelView ) )
            // InternalMMDesc.g:1147:2: ( ruleModelView )
            {
            // InternalMMDesc.g:1147:2: ( ruleModelView )
            // InternalMMDesc.g:1148:3: ruleModelView
            {
             before(grammarAccess.getMMDescAccess().getViewModelViewParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleModelView();

            state._fsp--;

             after(grammarAccess.getMMDescAccess().getViewModelViewParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MMDesc__ViewAssignment_2"


    // $ANTLR start "rule__PointDesc__TypeAssignment_3_0"
    // InternalMMDesc.g:1157:1: rule__PointDesc__TypeAssignment_3_0 : ( ( 'Integer' ) ) ;
    public final void rule__PointDesc__TypeAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1161:1: ( ( ( 'Integer' ) ) )
            // InternalMMDesc.g:1162:2: ( ( 'Integer' ) )
            {
            // InternalMMDesc.g:1162:2: ( ( 'Integer' ) )
            // InternalMMDesc.g:1163:3: ( 'Integer' )
            {
             before(grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_0_0()); 
            // InternalMMDesc.g:1164:3: ( 'Integer' )
            // InternalMMDesc.g:1165:4: 'Integer'
            {
             before(grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_0_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_0_0()); 

            }

             after(grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__TypeAssignment_3_0"


    // $ANTLR start "rule__PointDesc__TypeAssignment_3_1_0"
    // InternalMMDesc.g:1176:1: rule__PointDesc__TypeAssignment_3_1_0 : ( ( 'String' ) ) ;
    public final void rule__PointDesc__TypeAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1180:1: ( ( ( 'String' ) ) )
            // InternalMMDesc.g:1181:2: ( ( 'String' ) )
            {
            // InternalMMDesc.g:1181:2: ( ( 'String' ) )
            // InternalMMDesc.g:1182:3: ( 'String' )
            {
             before(grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_0_0()); 
            // InternalMMDesc.g:1183:3: ( 'String' )
            // InternalMMDesc.g:1184:4: 'String'
            {
             before(grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_0_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_0_0()); 

            }

             after(grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__TypeAssignment_3_1_0"


    // $ANTLR start "rule__PointDesc__TypeAssignment_3_1_1_1_0"
    // InternalMMDesc.g:1195:1: rule__PointDesc__TypeAssignment_3_1_1_1_0 : ( ( 'Integer' ) ) ;
    public final void rule__PointDesc__TypeAssignment_3_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1199:1: ( ( ( 'Integer' ) ) )
            // InternalMMDesc.g:1200:2: ( ( 'Integer' ) )
            {
            // InternalMMDesc.g:1200:2: ( ( 'Integer' ) )
            // InternalMMDesc.g:1201:3: ( 'Integer' )
            {
             before(grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_1_1_1_0_0()); 
            // InternalMMDesc.g:1202:3: ( 'Integer' )
            // InternalMMDesc.g:1203:4: 'Integer'
            {
             before(grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_1_1_1_0_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_1_1_1_0_0()); 

            }

             after(grammarAccess.getPointDescAccess().getTypeIntegerKeyword_3_1_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__TypeAssignment_3_1_1_1_0"


    // $ANTLR start "rule__PointDesc__TypeAssignment_3_1_1_1_1"
    // InternalMMDesc.g:1214:1: rule__PointDesc__TypeAssignment_3_1_1_1_1 : ( ( 'String' ) ) ;
    public final void rule__PointDesc__TypeAssignment_3_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1218:1: ( ( ( 'String' ) ) )
            // InternalMMDesc.g:1219:2: ( ( 'String' ) )
            {
            // InternalMMDesc.g:1219:2: ( ( 'String' ) )
            // InternalMMDesc.g:1220:3: ( 'String' )
            {
             before(grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_1_1_1_0()); 
            // InternalMMDesc.g:1221:3: ( 'String' )
            // InternalMMDesc.g:1222:4: 'String'
            {
             before(grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_1_1_1_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_1_1_1_0()); 

            }

             after(grammarAccess.getPointDescAccess().getTypeStringKeyword_3_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointDesc__TypeAssignment_3_1_1_1_1"


    // $ANTLR start "rule__ModelRef__IdAssignment_1"
    // InternalMMDesc.g:1233:1: rule__ModelRef__IdAssignment_1 : ( RULE_INT ) ;
    public final void rule__ModelRef__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1237:1: ( ( RULE_INT ) )
            // InternalMMDesc.g:1238:2: ( RULE_INT )
            {
            // InternalMMDesc.g:1238:2: ( RULE_INT )
            // InternalMMDesc.g:1239:3: RULE_INT
            {
             before(grammarAccess.getModelRefAccess().getIdINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getIdINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__IdAssignment_1"


    // $ANTLR start "rule__ModelRef__UriAssignment_2"
    // InternalMMDesc.g:1248:1: rule__ModelRef__UriAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ModelRef__UriAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1252:1: ( ( RULE_STRING ) )
            // InternalMMDesc.g:1253:2: ( RULE_STRING )
            {
            // InternalMMDesc.g:1253:2: ( RULE_STRING )
            // InternalMMDesc.g:1254:3: RULE_STRING
            {
             before(grammarAccess.getModelRefAccess().getUriSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getUriSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__UriAssignment_2"


    // $ANTLR start "rule__ModelRef__DataAssignment_3_1_0"
    // InternalMMDesc.g:1263:1: rule__ModelRef__DataAssignment_3_1_0 : ( RULE_STRING ) ;
    public final void rule__ModelRef__DataAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1267:1: ( ( RULE_STRING ) )
            // InternalMMDesc.g:1268:2: ( RULE_STRING )
            {
            // InternalMMDesc.g:1268:2: ( RULE_STRING )
            // InternalMMDesc.g:1269:3: RULE_STRING
            {
             before(grammarAccess.getModelRefAccess().getDataSTRINGTerminalRuleCall_3_1_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getDataSTRINGTerminalRuleCall_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__DataAssignment_3_1_0"


    // $ANTLR start "rule__ModelRef__NextAssignment_4_1"
    // InternalMMDesc.g:1278:1: rule__ModelRef__NextAssignment_4_1 : ( ruleModelRef ) ;
    public final void rule__ModelRef__NextAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1282:1: ( ( ruleModelRef ) )
            // InternalMMDesc.g:1283:2: ( ruleModelRef )
            {
            // InternalMMDesc.g:1283:2: ( ruleModelRef )
            // InternalMMDesc.g:1284:3: ruleModelRef
            {
             before(grammarAccess.getModelRefAccess().getNextModelRefParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleModelRef();

            state._fsp--;

             after(grammarAccess.getModelRefAccess().getNextModelRefParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__NextAssignment_4_1"


    // $ANTLR start "rule__ModelRef__ContinueAssignment_5"
    // InternalMMDesc.g:1293:1: rule__ModelRef__ContinueAssignment_5 : ( ( '+' ) ) ;
    public final void rule__ModelRef__ContinueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1297:1: ( ( ( '+' ) ) )
            // InternalMMDesc.g:1298:2: ( ( '+' ) )
            {
            // InternalMMDesc.g:1298:2: ( ( '+' ) )
            // InternalMMDesc.g:1299:3: ( '+' )
            {
             before(grammarAccess.getModelRefAccess().getContinuePlusSignKeyword_5_0()); 
            // InternalMMDesc.g:1300:3: ( '+' )
            // InternalMMDesc.g:1301:4: '+'
            {
             before(grammarAccess.getModelRefAccess().getContinuePlusSignKeyword_5_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getModelRefAccess().getContinuePlusSignKeyword_5_0()); 

            }

             after(grammarAccess.getModelRefAccess().getContinuePlusSignKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelRef__ContinueAssignment_5"


    // $ANTLR start "rule__ModelView__ViewedAssignment_3_0"
    // InternalMMDesc.g:1312:1: rule__ModelView__ViewedAssignment_3_0 : ( ( RULE_ID ) ) ;
    public final void rule__ModelView__ViewedAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1316:1: ( ( ( RULE_ID ) ) )
            // InternalMMDesc.g:1317:2: ( ( RULE_ID ) )
            {
            // InternalMMDesc.g:1317:2: ( ( RULE_ID ) )
            // InternalMMDesc.g:1318:3: ( RULE_ID )
            {
             before(grammarAccess.getModelViewAccess().getViewedModelRefCrossReference_3_0_0()); 
            // InternalMMDesc.g:1319:3: ( RULE_ID )
            // InternalMMDesc.g:1320:4: RULE_ID
            {
             before(grammarAccess.getModelViewAccess().getViewedModelRefIDTerminalRuleCall_3_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getModelViewAccess().getViewedModelRefIDTerminalRuleCall_3_0_0_1()); 

            }

             after(grammarAccess.getModelViewAccess().getViewedModelRefCrossReference_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__ViewedAssignment_3_0"


    // $ANTLR start "rule__ModelView__ViewedAssignment_3_1_1"
    // InternalMMDesc.g:1331:1: rule__ModelView__ViewedAssignment_3_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__ModelView__ViewedAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMMDesc.g:1335:1: ( ( ( RULE_ID ) ) )
            // InternalMMDesc.g:1336:2: ( ( RULE_ID ) )
            {
            // InternalMMDesc.g:1336:2: ( ( RULE_ID ) )
            // InternalMMDesc.g:1337:3: ( RULE_ID )
            {
             before(grammarAccess.getModelViewAccess().getViewedModelRefCrossReference_3_1_1_0()); 
            // InternalMMDesc.g:1338:3: ( RULE_ID )
            // InternalMMDesc.g:1339:4: RULE_ID
            {
             before(grammarAccess.getModelViewAccess().getViewedModelRefIDTerminalRuleCall_3_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getModelViewAccess().getViewedModelRefIDTerminalRuleCall_3_1_1_0_1()); 

            }

             after(grammarAccess.getModelViewAccess().getViewedModelRefCrossReference_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelView__ViewedAssignment_3_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000182000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000211000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000010L});

}