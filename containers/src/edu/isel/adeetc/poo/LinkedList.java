package edu.isel.adeetc.poo;


public class LinkedList {

    private static class Node {
        public Node next;
        public final String data;

        public Node(String elem, Node next) {
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

    private int size = 0;
    private Node head = null;

    public LinkedList() { }

    public LinkedList(String[] elems) {
        for (int idx = elems.length - 1; idx >= 0; idx--) {
            addFirst(elems[idx]);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void addFirst(String elem) {
        if (elem == null)
            throw new IllegalArgumentException();

        head = new Node(elem, head);
        size += 1;
    }

    public String removeFirst() {
        if (isEmpty())
            throw new IllegalStateException();

        final Node formerFirst = head;
        head = head.next;
        size -= 1;
        return formerFirst.data;
    }

    public String first() {
        if (isEmpty())
            throw new IllegalStateException();

        return head.data;
    }

    public String last() {
        if (isEmpty())
            throw new IllegalStateException();

        Node current = head;
        while (current.next != null)
            current = current.next;

        return current.data;
    }

    public String getAt(int index) {
        if (index >= size)
            throw new IllegalArgumentException();

        Node current = head;
        while (index-- != 0)
            current = current.next;

        return current.data;
    }

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
        return last;
    }
}
