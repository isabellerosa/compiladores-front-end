package uezo.compiladores.inter.stmt;

import uezo.compiladores.inter.Expr;
import uezo.compiladores.inter.Stmt;
import uezo.compiladores.symbol.Type;

public class While extends Stmt {
    Expr expr;
    Stmt stmt;

    public While() {
        expr = null;
        stmt = null;
    }

    public void init(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) expr.error("boolean required in while");
    }

    public void gen(int b, int a) {
        after = a; // guarda rótulo a
        expr.jumping(0, a);
        int label = newlabel(); // rótulo para comando
        emitlabel(label);
        stmt.gen(label, b);
        emit("goto L" + b);
    }
}
