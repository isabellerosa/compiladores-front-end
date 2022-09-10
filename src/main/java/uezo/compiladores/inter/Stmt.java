package uezo.compiladores.inter;

public class Stmt extends Node {
    public Stmt() {
    }

    public static Stmt Null = new Stmt();

    public void gen(int b, int a) {
    } // chamado com rótulos begin e after

    int after = 0;

    public static Stmt Enclosing = Stmt.Null; // usado para comandos break
}
