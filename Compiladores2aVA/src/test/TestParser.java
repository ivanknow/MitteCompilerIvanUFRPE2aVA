package test;

import java.io.FileInputStream;
import java.io.IOException;

import arvore.Programa;
import gerador.GerarCodigo;
import semantica.SemanticalException;
import syntax.Lexer;
import syntax.Parser;
import syntax.ParserException;

/**
 * Exemplo de integração do analisador léxico gerado pelo JFLex com o parser
 * gerador pelo CUP.
 * 
 * Este exemplo usa um arquivo como entrada.
 *
 * Pablo Azevedo Sampaio 14/03/2009
 */

public class TestParser {

	public static void main(String args[]) throws IOException {
		Lexer lexer;
		Parser parser;

		try {
			String arquivo = args[0];
			lexer = new Lexer(new FileInputStream(arquivo));
			parser = new Parser(lexer);

			Programa p = (Programa) parser.parse().value;
			// System.out.println("\nSintaxe OK!\n"+p);
			p.analyse();
			String nomeClasse = arquivo.replace(".mitte", "");
			GerarCodigo.gerar(nomeClasse, p);

		} catch (SemanticalException e) {
			System.out.println("\nErro semantico!" + e.getMessage());

		} catch (ParserException e) {
			System.out.println("\nErro sintático!" + e.getMessage());

		} catch (Exception e) {
			System.out.println("\nErro inseperado!" + e.getMessage());
			e.printStackTrace();
		}

	}

}
