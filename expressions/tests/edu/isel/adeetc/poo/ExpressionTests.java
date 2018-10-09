package edu.isel.adeetc.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionTests {

    @Test
    public void testConstant() {

        // Arrange
        final int expectedValue = 5;
        Expression sut = new Constant(expectedValue);

        // Act
        final int result = sut.evaluate();

        // Assert
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void testSum() {

        // Arrange
        final int expectedValue = 10;
        Expression sut = new Addition(new Constant(4), new Constant(6));

        // Act
        final int result = sut.evaluate();

        // Assert
        Assertions.assertEquals(expectedValue, result);
    }
}
