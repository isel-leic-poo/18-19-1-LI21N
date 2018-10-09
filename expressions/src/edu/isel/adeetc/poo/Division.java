package edu.isel.adeetc.poo;

public class Division extends BinaryOperator {
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}
