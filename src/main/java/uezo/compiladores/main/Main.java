package uezo.compiladores.main;

import uezo.compiladores.lexer.Lexer;
import uezo.compiladores.parser.Parser;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lex;

        if (args.length == 0) {
            lex = new Lexer();
        }
        else {
            String sourceCode = args[0];
            File source = new File(sourceCode);
            lex = new Lexer(source);
        }

        Parser parser = new Parser(lex);
        parser.program();
        System.out.println();
    }
}
