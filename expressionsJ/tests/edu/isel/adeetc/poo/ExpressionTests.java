package edu.isel.adeetc.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionTests {

    @Test
    public void testConstant() {

        // Arrange
        final int expectedValue = 5;
        Expression sut = new Expression(expectedValue);

        // Act
        final int result = sut.evaluate();

        // Assert
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void testSum() {

        // Arrange
        final int expectedValue = 10;
        Expression sut = new Expression('+', new Expression(4), new Expression(6));

        // Act
        final int result = sut.evaluate();

        // Assert
        Assertions.assertEquals(expectedValue, result);
    }
}
