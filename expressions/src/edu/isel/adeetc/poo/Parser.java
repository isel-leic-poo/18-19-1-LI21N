package edu.isel.adeetc.poo;

public class Parser {

    public static Expression constant(String expression, int startIdx, TokenHolder lastToken) {
        final Token token = getNextToken(expression, startIdx);
        lastToken.token = token;

        if (!token.isValid())
            return null;

        if (token.token.charAt(0) == '0' && token.token.length() != 1)
            return null;

        return new Constant(Integer.parseInt(token.token));
    }

    public static Expression expression(String expression, int startIndex, TokenHolder lastToken) {
        Expression exp = aritExpression(expression, startIndex, lastToken);
        if (exp != null)
            return exp;

        exp = constant(expression, startIndex, lastToken);
        if (exp != null)
            return exp;

        return null;
    }

    public static Token opr(String expression, int startIndex) {
        Token opr = getNextToken(expression, startIndex);
        if (!opr.isValid())
            return opr;

        switch (opr.token) {
            case "+":case "-":case "*":case "/":
                return opr;
            default:
                return new Token();
        }
    }

    public static Expression aritExpression(String expression, int startIndex, TokenHolder lastToken) {
        Token opr = opr(expression, startIndex);
        lastToken.token = opr;
        if (!opr.isValid())
            return null;

        Expression left = expression(expression, opr.indexEnd, lastToken);
        Expression right = expression(expression, lastToken.token.indexEnd, lastToken);
        switch(opr.token.charAt(0)) {
            case '+':
                return new Addition(left, right);
            case '-':
                return new Subtraction(left, right);
            case '*':
                return new Multiplication(left, right);
            case '/':
                return new Division(left, right);
            default:
                throw new IllegalStateException();
        }
    }

    public static Token getNextToken(String expression, int startIdx) {

        while (startIdx < expression.length() && expression.charAt(startIdx) == ' ')
            startIdx += 1;

        if (startIdx == expression.length())
            return new Token();

        int endIdx = startIdx;
        while (endIdx < expression.length() && expression.charAt(endIdx) != ' ')
            endIdx += 1;

        return new Token(expression.substring(startIdx, endIdx), endIdx);
    }

    public static Expression parse(String expression) {
        return expression(expression, 0, new TokenHolder());
    }
}
