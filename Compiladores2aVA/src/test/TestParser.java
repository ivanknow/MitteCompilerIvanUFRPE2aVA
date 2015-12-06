package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import arvore.Programa;
import semantica.SemanticalException;
import syntax.Lexer;
import syntax.Parser;


/**
 * Exemplo de integração do analisador léxico gerado pelo JFLex 
 * com o parser gerador pelo CUP.
 * 
 * Este exemplo usa um arquivo como entrada. 
 *
 * Pablo Azevedo Sampaio
 * 14/03/2009
 */

public class TestParser {

	public static void main(String args[]) throws IOException {
		Lexer lexer;
		Parser parser;
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite o nome do arquivo: ");
        String arquivo = in.readLine();
        System.out.println();
		
		try {
			lexer = new Lexer(new FileInputStream(arquivo));
			parser = new Parser(lexer);

			Programa p = (Programa)parser.parse().value;
			//System.out.println("\nSintaxe OK!\n"+p);
			p.analyse();
			//String nomeClasse = arquivo.replace(".mitte", "");
			//GerarCodigo.gerar(nomeClasse, p);
		
		}catch (SemanticalException e) {
			System.out.println("\nErro semantico!"+e.getMessage());
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("\nErro sintático!"+e.getMessage());
			e.printStackTrace();
		}

	}

}
