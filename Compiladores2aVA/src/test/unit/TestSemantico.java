package test.unit;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import arvore.Programa;
import semantica.SemanticalException;
import syntax.Lexer;
import syntax.Parser;

public class TestSemantico {
@Test
	public void testOpAritmeticaComString() {// REGAR 1
		StringBuilder sb = new StringBuilder();

		sb.append("def main()");
		sb.append("{ ");
		sb.append(" x, y : string; ");
		sb.append(" m :int; ");
		sb.append(" x = \"oi\";");
		sb.append(" print(x+m);");
		sb.append(" print(m+m);");
		sb.append(" print(m+x);");
		sb.append("} ");

		try {
			Programa p = loadProgram(sb);
			p.analyse();
			fail("Nao detectou erro");
		} catch (SemanticalException e) {

			System.out.println(e.getMessage());
		} catch (Exception e) {
			fail("Excecao inesperada");
			e.printStackTrace();
		}

	}

@Test
public void testOpAritmeticaDivMultComCHAR() {// REGAR 1
	StringBuilder sb = new StringBuilder();

	sb.append("def main()");
	sb.append("{ ");
	sb.append(" x: char; ");
	sb.append(" m :int; ");
	sb.append(" x='A';");
	sb.append(" m=23; ");
	sb.append(" print(x*m);");
	sb.append("} ");

	try {
		Programa p = loadProgram(sb);
		p.analyse();
		fail("");
	} catch (SemanticalException e) {

		System.out.println(e.getMessage());
	} catch (Exception e) {
		fail("Excecao inesperada");
		e.printStackTrace();
	}

}

@Test
public void testSomaString() {// REGAR 1
	StringBuilder sb = new StringBuilder();

	sb.append("def main()");
	sb.append("{ ");
	sb.append(" x, y : string; ");
	sb.append(" m :int; ");
	sb.append("x = \"oi\";");
	sb.append(" print(x+m); ");
	sb.append("} ");

	try {
		Programa p = loadProgram(sb);
		p.analyse();
		fail("");
	} catch (SemanticalException e) {

		System.out.println(e.getMessage());
	} catch (Exception e) {
		fail("Excecao inesperada");
		e.printStackTrace();
	}

}

	public Programa loadProgram(StringBuilder sb) throws Exception {
		String programa = sb.toString();
		System.out.println(programa);
		Lexer lexer = new Lexer(new ByteArrayInputStream(programa.getBytes()));
		Parser parser = new Parser(lexer);
		return (Programa) parser.parse().value;
	}

}
