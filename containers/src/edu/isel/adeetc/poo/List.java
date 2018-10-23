package edu.isel.adeetc.poo;

public interface List extends Iterable<String> {
    int size();

    boolean isEmpty();

    void addFirst(String elem);

    void addLast(String elem);

    String first();

    String last();

    String getAt(int index);

    String removeFirst();

    String removeLast();
}
