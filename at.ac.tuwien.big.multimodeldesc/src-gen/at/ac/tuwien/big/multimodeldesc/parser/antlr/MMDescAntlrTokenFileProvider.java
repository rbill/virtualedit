/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.multimodeldesc.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MMDescAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("at/ac/tuwien/big/multimodeldesc/parser/antlr/internal/InternalMMDesc.tokens");
	}
}
