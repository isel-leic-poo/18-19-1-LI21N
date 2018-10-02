package edu.isel.adeetc.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTests {

    @Test
    public void sizeOnEmptyInstance_returnsZero() {
        final ArrayList sut = new ArrayList(10);
        Assertions.assertEquals(0, sut.size());
    }

    @Test
    public void capacityOnNewInstance_returnsInitialCapacity() {
        final int initialCapacity = 10;
        final ArrayList sut = new ArrayList(initialCapacity);
        Assertions.assertEquals(initialCapacity, sut.capacity());
    }

    @Test
    public void addLastOnNewInstance_addsAtFirstPosition() {
        final int initialCapacity = 10;
        final String expectedElement = "SLB";
        final ArrayList sut = new ArrayList(initialCapacity);
        sut.addLast(expectedElement);
        Assertions.assertSame(expectedElement, sut.first());
    }

    @Test
    public void addFirstOnNewInstance_addsAtLastPosition() {
        final int initialCapacity = 10;
        final String expectedElement = "SLB";
        final ArrayList sut = new ArrayList(initialCapacity);
        sut.addFirst(expectedElement);
        Assertions.assertSame(expectedElement, sut.last());
    }

    @Test
    public void addFirstOnFullInstance_addsAtFirstPosition() {
        final int initialCapacity = 10;
        final String expectedElement = "SLB";
        final ArrayList sut = new ArrayList(new String[] { "O", "MAIOR"});
        sut.addFirst(expectedElement);
        Assertions.assertSame(expectedElement, sut.first());
    }

    @Test
    public void addLastOnFullInstance_addsAtLastPosition() {
        final int initialCapacity = 10;
        final String expectedElement = "MAIOR";
        final ArrayList sut = new ArrayList(new String[] { "SLB", "O" });
        sut.addLast(expectedElement);
        Assertions.assertSame(expectedElement, sut.last());
    }
}
