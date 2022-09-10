package uezo.compiladores.inter;

import uezo.compiladores.lexer.Word;
import uezo.compiladores.symbol.Type;

public class Temp extends Expr {
    static int count = 0;
    int number = 0;

    public Temp(Type p) {
        super(Word.temp, p);
        number = ++count;
    }

    public String toString() {
        return "t" + number;
    }
}
