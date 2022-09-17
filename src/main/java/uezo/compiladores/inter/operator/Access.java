package uezo.compiladores.inter.operator;

import uezo.compiladores.inter.Expr;
import uezo.compiladores.inter.expr.Id;
import uezo.compiladores.inter.expr.Op;
import uezo.compiladores.lexer.Tag;
import uezo.compiladores.lexer.Word;
import uezo.compiladores.symbol.Type;

public class Access extends Op {
    public Id array;
    public Expr index;

    public Access(Id a, Expr i, Type p) { // p é o tipo de elemento após
        super(new Word("[]", Tag.INDEX), p); // achatar o arranjo
        array = a;
        index = i;
    }

    public Expr gen() {
        return new Access(array, index.reduce(), type);
    }

    public void jumping(int t, int f) {
        emitjumps(reduce().toString(), t, f);
    }

    public String toString() {
        return array.toString() + " [ " + index.toString() + " ]";
    }
}
