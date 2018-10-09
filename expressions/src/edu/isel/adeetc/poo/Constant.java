package edu.isel.adeetc.poo;

public class Constant implements Expression {
    private final int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
