package edu.isel.adeetc.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTests {
    @Test
    public void sizeOnEmptyInstance_returnsZero() {
        final LinkedList sut = new LinkedList();
        Assertions.assertEquals(0, sut.size());
    }

    @Test
    public void addLastOnNewInstance_addsAtFirstPosition() {
        final String expectedElement = "SLB";
        final LinkedList sut = new LinkedList();
        sut.addLast(expectedElement);
        Assertions.assertSame(expectedElement, sut.first());
    }

    @Test
    public void addFirstOnNewInstance_addsAtLastPosition() {
        final String expectedElement = "SLB";
        final LinkedList sut = new LinkedList();
        sut.addFirst(expectedElement);
        Assertions.assertSame(expectedElement, sut.last());
    }

    @Test
    public void addFirstOnNonEmptyInstance_addsAtFirstPosition() {
        final String expectedElement = "SLB";
        final LinkedList sut = new LinkedList(new String[] { "O", "MAIOR"});
        sut.addFirst(expectedElement);
        Assertions.assertSame(expectedElement, sut.first());
    }

    @Test
    public void addLastOnNonEmptyInstance_addsAtLastPosition() {
        final String expectedElement = "MAIOR";
        final LinkedList sut = new LinkedList(new String[] { "SLB", "O" });
        sut.addLast(expectedElement);
        Assertions.assertSame(expectedElement, sut.last());
    }

    @Test
    public void removeLastOnNonEmptyInstance_removesAtLastPosition() {
        final String expectedElement = "MAIOR";
        final LinkedList sut = new LinkedList(new String[] { "SLB", "O", expectedElement });
        Assertions.assertSame(expectedElement, sut.removeLast());
    }

    @Test
    public void removeLastOnOneElementInstance_leavesListEmpty() {
        final String expectedElement = "SLB";
        final LinkedList sut = new LinkedList(new String[] { expectedElement });
        Assertions.assertSame(expectedElement, sut.removeLast());
        Assertions.assertTrue(sut.isEmpty());
    }

    @Test
    public void removeFirstOnOneElementInstance_leavesListEmpty() {
        final String expectedElement = "SLB";
        final LinkedList sut = new LinkedList(new String[] { expectedElement });
        Assertions.assertSame(expectedElement, sut.removeFirst());
        Assertions.assertTrue(sut.isEmpty());
    }

    @Test
    public void removeFirstOnNonEmptyInstance_removesAtFirstPosition() {
        final String expectedElement = "MAIOR";
        final LinkedList sut = new LinkedList(new String[] { expectedElement, "O", "MAIOR" });
        Assertions.assertSame(expectedElement, sut.removeFirst());
    }
}
