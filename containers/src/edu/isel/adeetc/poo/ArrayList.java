package edu.isel.adeetc.poo;

public class ArrayList implements List {
    private String[] content;
    private int size;

    private void checkGrowth() {
        if(size() == capacity()) {
            String[] newArray = new String[content.length*2];
            System.arraycopy(content, 0, newArray, 0, content.length);
            content = newArray;
        }
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity <= 0)
            throw new IllegalArgumentException();
        content = new String[initialCapacity];
        size = 0;
    }

    public ArrayList(String[] elements) {
        if (elements == null)
            throw new IllegalArgumentException();
        content = new String[elements.length];
        System.arraycopy(elements, 0, content, 0, elements.length);
        size = elements.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int capacity() {
        return content.length;
    }

    @Override
    public void addFirst(String elem) {
        if (elem == null)
            throw new IllegalArgumentException();
        checkGrowth();
        System.arraycopy(content, 0, content, 1, size++);
        content[0] = elem;
    }

    @Override
    public void addLast(String elem) {
        if (elem == null)
            throw new IllegalArgumentException();
        checkGrowth();
        content[size++] = elem;
    }

    @Override
    public String first() {
        if (size == 0)
            throw new IllegalStateException();
        return content[0];
    }

    @Override
    public String last() {
        if (size == 0)
            throw new IllegalStateException();
        return content[size-1];
    }

    @Override
    public String getAt(int index) {
        if (index >= size)
            throw new IllegalArgumentException();

        return content[index];
    }

    @Override
    public String removeFirst() {
        if (size == 0)
            throw new IllegalStateException();
        final String first = first();
        System.arraycopy(content, 1, content, 0, --size);
        content[size] = null;
        return first;
    }

    @Override
    public String removeLast() {
        if (size == 0)
            throw new IllegalStateException();
        final String last = last();
        content[--size] = null;
        return last;
    }
}
