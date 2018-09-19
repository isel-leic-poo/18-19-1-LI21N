package edu.isel.adeetc.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTests {

    @Test
    public void testGetNextTokenNonTrimmedInput() {
        // Arrange
        String expression = "    SLB    O    MAIOR evidentemente ";
        String[] expectedTokens = { "SLB", "O", "MAIOR", "evidentemente" };

        // Act && Assert
        Token prevToken = null;
        for (int i = 0; i < expectedTokens.length; i++) {
            final int indexEnd = prevToken == null ? 0 : prevToken.indexEnd;
            // Act
            Token nextToken = Parser.getNextToken(expression, indexEnd);
            // Assert
            Assertions.assertEquals(expectedTokens[i], nextToken.token);
            prevToken = nextToken;
        }
    }

    @Test
    public void testGetNextTokenTrimmedInput() {
        // Arrange
        String expression = "SLB    O    MAIOR";
        String firstExpectedToken = "SLB";
        String secondExpectedToken = "O";
        String thirdExpectedToken = "MAIOR";

        // Act
        Token firstToken = Parser.getNextToken(expression, 0);
        Token secondToken = Parser.getNextToken(expression,
                firstToken.indexEnd);
        Token thirdToken = Parser.getNextToken(expression,
                secondToken.indexEnd);

        // Assert
        Assertions.assertEquals(firstExpectedToken, firstToken.token);
        Assertions.assertEquals(secondExpectedToken, secondToken.token);
        Assertions.assertEquals(thirdExpectedToken, thirdToken.token);
    }
}
