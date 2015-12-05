package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import arvore.Programa;
import arvore.Tipo;

public class GerarCodigo {
	public static void gerar(String nome, Programa prog) throws FileNotFoundException {
		PrintWriter wow = new PrintWriter(nome + ".j");
		String code = prog.gerar(nome);
		wow.println(code);
		wow.close();
	}

	public static String tradutorTipos(Tipo t) {
		String retorno = "";
		switch (t) {
		case INT:
			retorno = "I";
			break;
		case BOOLEAN:
			retorno = "B";
			break;
		case CHAR:
			retorno = "C";
			break;
		case FLOAT:
			retorno = "F";
			break;
		case STRING:
			retorno = "Ljava/lang/String;";
			break;
		case VOID:
			retorno = "V";
			break;
		}

		return retorno;
	}
	
	public static String tradutorTipos(Tipo t,String op) {
		String retorno = "";
		switch (t) {
		case INT:
			retorno = "i";
			break;
		case BOOLEAN:
			retorno = "b";
			break;
		case CHAR:
			retorno = "c";
			break;
		case FLOAT:
			retorno = "f";
			break;
		
		case VOID:
			retorno = "v";
			break;
		}

		return retorno+op;
	}
}
