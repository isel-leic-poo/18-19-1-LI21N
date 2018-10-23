package edu.isel.adeetc.poo;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements List {

    private static class Node {
        Node next;
        final String data;

        Node(String elem, Node next) {
            this.next = next;
            this.data = elem;
        }

        public Node(String elem) {
            this(elem, null);
        }

        public Node() {
            this(null, null);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {

            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                String elem = current.data;
                current = current.next;
                return elem;
            }
        };
    }


    private int size = 0;
    private Node head = null;

    public LinkedList() { }

    public LinkedList(String[] elems) {
        for (int idx = elems.length - 1; idx >= 0; idx--) {
            addFirst(elems[idx]);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void addFirst(String elem) {
        if (elem == null)
            throw new IllegalArgumentException();

        head = new Node(elem, head);
        size += 1;
    }

    @Override
    public String removeFirst() {
        if (isEmpty())
            throw new IllegalStateException();

        final Node formerFirst = head;
        head = head.next;
        size -= 1;
        return formerFirst.data;
    }

    @Override
    public String first() {
        if (isEmpty())
            throw new IllegalStateException();

        return head.data;
    }

    @Override
    public String last() {
        if (isEmpty())
            throw new IllegalStateException();

        Node current = head;
        while (current.next != null)
            current = current.next;

        return current.data;
    }

    @Override
    public String getAt(int index) {
        if (index >= size)
            throw new IllegalArgumentException();

        Node current = head;
        while (index-- != 0)
            current = current.next;

        return current.data;
    }

    @Override
    public void addLast(String elem) {
        if (elem == null)
            throw new IllegalArgumentException();

        if (isEmpty()) {
            addFirst(elem);
            return;
        }

        Node current = head;
        while (current.next != null)
            current = current.next;

        current.next = new Node(elem, null);
        size += 1;
    }

    @Override
    public String removeLast() {
        if (size == 0)
            throw new IllegalStateException();

        if (size == 1)
            return removeFirst();

        Node current = head;
        while (current.next.next != null)
            current = current.next;

        final String last = current.next.data;
        current.next = null;
        size -= 1;
        return last;
    }
}
