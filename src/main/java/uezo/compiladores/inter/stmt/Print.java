package uezo.compiladores.inter.stmt;

import uezo.compiladores.inter.Expr;
import uezo.compiladores.inter.Stmt;
import uezo.compiladores.inter.expr.Constant;
import uezo.compiladores.inter.expr.Id;
import uezo.compiladores.lexer.Num;
import uezo.compiladores.lexer.Word;

public class Print extends Stmt {
    Expr expr;
    String output;

    public Print(Expr expr) {
        this.expr = expr;

        if (expr instanceof Id id) {
            this.output = "id " + ((Word) id.op).lexeme;
        } else if (expr instanceof Constant constant) {
            this.output = "const " + ((Num) constant.op).value;
        } else {
            expr.error("expression unsupported on print statement");
        }
    }

    public void gen(int b, int a) {
        emit("print: "+ output);
    }
}
