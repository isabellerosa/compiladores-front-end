package uezo.compiladores.main;

import uezo.compiladores.lexer.Lexer;
import uezo.compiladores.parser.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lex = new Lexer();
        Parser parser = new Parser(lex);
        parser.program();
        System.out.println();
    }
}
