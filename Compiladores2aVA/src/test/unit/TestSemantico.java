package test.unit;

import java.io.ByteArrayInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import arvore.Programa;
import semantica.SemanticalException;
import syntax.Lexer;
import syntax.Parser;

public class TestSemantico {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test (expected = SemanticalException.class)
	public void testOpAritmeticaComString() throws Exception {// REGAR 1
		StringBuilder sb = new StringBuilder();
		/*
		 * def main() 
			{ 
			   x, y : string; 
			   m :int; 
			   x = "oi";  
			
			print (x+m);
			}
		 * */
		sb.append("def main()" );
		sb.append("{ ");
		sb.append(" x, y : string; ");
		sb.append(" m :int; ");
		sb.append(" x = \"oi\";"); 
		sb.append(" print(x+m);");
		sb.append("} ");
		String programa = sb.toString();
		System.out.println(programa);
		Lexer lexer = new Lexer(new ByteArrayInputStream(programa.getBytes()));
		Parser parser = new Parser(lexer);
		
			Programa p = (Programa) parser.parse().value;
			p.analyse();
			

	}

}
