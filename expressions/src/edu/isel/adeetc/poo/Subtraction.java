package edu.isel.adeetc.poo;

public class Subtraction extends BinaryOperator {

    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}
