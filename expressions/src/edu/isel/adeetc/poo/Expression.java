package edu.isel.adeetc.poo;

/**
 * Class whose instances represent arithmetic expressions.
 */
public class Expression {

    private final int value;
    private final char opr;
    private final Expression left, right;

    public Expression(int value) {
        this.value = value;
        this.opr = 0;
        this.left = this.right = null;
    }

    public Expression(char opr, Expression left, Expression right) {
        this.opr = opr;
        this.value = 0;
        this.left = left;
        this.right = right;
    }

    public int evaluate() {
        switch (opr) {
            case '+':
                return left.evaluate() + right.evaluate();
            case '-':
                return left.evaluate() - right.evaluate();
            case '*':
                return left.evaluate() * right.evaluate();
            case '/':
                return left.evaluate() / right.evaluate();
            default:
                return value;
        }
    }
}
