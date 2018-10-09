package edu.isel.adeetc.poo;

public class Multiplication extends BinaryOperator {
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
