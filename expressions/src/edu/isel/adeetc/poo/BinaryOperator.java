package edu.isel.adeetc.poo;

public abstract class BinaryOperator implements Expression {
    protected final Expression left, right;

    protected BinaryOperator(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
