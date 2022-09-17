package uezo.compiladores.inter.stmt;

import uezo.compiladores.inter.Expr;
import uezo.compiladores.inter.Stmt;
import uezo.compiladores.symbol.Type;

public class If extends Stmt {
    Expr expr;
    Stmt stmt;

    public If(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) expr.error("boolean required in if");
    }

    public void gen(int b, int a) {
        int label = newlabel(); // rótulo do código para stmt
        expr.jumping(0, a); // segue se for true, vai para a se for false
        emitlabel(label);
        stmt.gen(label, a);
    }
}
