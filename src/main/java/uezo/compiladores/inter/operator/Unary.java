package uezo.compiladores.inter.operator;

import uezo.compiladores.inter.Expr;
import uezo.compiladores.inter.expr.Op;
import uezo.compiladores.lexer.Token;
import uezo.compiladores.symbol.Type;

public class Unary extends Op {
    public Expr expr;

    public Unary(Token tok, Expr x) { // trata operador menos, para !, ver Not
        super(tok, null);
        expr = x;
        type = Type.max(Type.Int, expr.type);

        if (type == null) error("type error");
    }

    public Expr gen() {
        return new Unary(op, expr.reduce());
    }

    public String toString() {
        return op.toString() + " " + expr.toString();
    }
}
