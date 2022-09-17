package uezo.compiladores.inter.expr;

import uezo.compiladores.inter.Expr;
import uezo.compiladores.lexer.Word;
import uezo.compiladores.symbol.Type;

public class Id extends Expr {
    public int offset; // endereço relativo

    public Id(Word id, Type p, int b) {
        super(id, p);
        offset = b;
    }
}
