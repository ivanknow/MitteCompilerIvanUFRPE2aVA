package syntax;

import java_cup.runtime.*;

%%

%class Lexer
%public

%cup
%line
%column

whiteSpace=([ \n\t\f\r]+)
letra=[a-zA-Z]
literalchars="\\n"|"\\t"|" "|","|"("|")"|":"
numero=[0-9]
inteiro={numero}+
real = {inteiro}\.{inteiro}
char  = {letra}|"\\n"|"\\t"|" "
comentario = "(*" [^*] ~"*)" | "(*" "*"+ ")"

%%

{whiteSpace} { 
	// Caracteres ignorados.
	// Nenhum token é retornado.
}

"==" { return new Symbol(sym.OP_IGUAL); }
"!=" { return new Symbol(sym.OP_DIFERENTE); }
">" { return new Symbol(sym.OP_MAIOR_QUE); }
"<" { return new Symbol(sym.OP_MENOR_QUE); }
">=" { return new Symbol(sym.OP_MAIOR_OU_IGUAL); }
"<=" { return new Symbol(sym.OP_MENOR_OU_IGUAL); }


"+" { return new Symbol(sym.SOMA); }
"-" { return new Symbol(sym.SUB); }
"*" { return new Symbol(sym.MULT); }
"/" { return new Symbol(sym.DIV); }
"%" { return new Symbol(sym.RESTO); }
"and" { return new Symbol(sym.AND); }
"or" { return new Symbol(sym.OR); }
"not" { return new Symbol(sym.NOT); }


"(" { return new Symbol(sym.ABRE_PAR); }
")" { return new Symbol(sym.FECHA_PAR); }
"{" { return new Symbol(sym.ABRE_CHAVE); }
"}" { return new Symbol(sym.FECHA_CHAVE); }
"," { return new Symbol(sym.VIRGULA); }
";" { return new Symbol(sym.PONTO_VIRGULA); }
":" { return new Symbol(sym.DOIS_PONTOS); }

"=" { return new Symbol(sym.ATRIBUICAO); }

"if" { return new Symbol(sym.KEY_IF); }
"else" { return new Symbol(sym.KEY_ELSE); }
"while" { return new Symbol(sym.KEY_WHILE); }
"return" { return new Symbol(sym.KEY_RETURN); }
"int" { return new Symbol(sym.KEY_INT); }
"float" { return new Symbol(sym.KEY_FLOAT); }
"char" { return new Symbol(sym.KEY_CHAR); }
"string" { return new Symbol(sym.KEY_STRING); }
"call" { return new Symbol(sym.KEY_CALL); }
"def"      { return new Symbol(sym.KEY_DEF); }
"print"      { return new Symbol(sym.KEY_PRINT); }


{inteiro}  { return new Symbol(sym.INT_LITERAL, yytext()); }
{real} { return new Symbol(sym.FLOAT_LITERAL, yytext()); }
"\'"{char}"\'" { return new Symbol(sym.CHAR_LITERAL, yytext()); }
"\""({numero}|{letra}|{literalchars})*"\""   { return new Symbol(sym.STRING_LITERAL, yytext()); }

{numero}*{letra}({numero}|{letra})*   { return new Symbol(sym.IDENTIFICADOR, yytext()); }

"##"[^\n]* {
	// Comentários de linha.
	// Não retorna token.
}

{comentario} {
	// Comentários de linha.
	// Não retorna token.
}

. { 
    // Casa com qualquer caracter que não casar com as expressoes acima.
    System.err.println("Illegal character : " + yytext());
}

<<EOF>> {
	// Casa com o fim do arquivo apenas.
	return new Symbol(sym.EOF);
}
