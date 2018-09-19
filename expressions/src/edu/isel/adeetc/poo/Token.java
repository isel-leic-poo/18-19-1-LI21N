package edu.isel.adeetc.poo;

public class Token {
    public final String token;
    public final int indexEnd;

    public Token(String token, int indexEnd) {
        this.token = token;
        this.indexEnd = indexEnd;
    }

    public Token() {
        token = "";
        indexEnd = -1;
    }

    public boolean isValid() {
        return indexEnd != -1;
    }
}
