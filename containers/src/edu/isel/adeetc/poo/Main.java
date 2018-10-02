package edu.isel.adeetc.poo;

public class Main {

    public static void main(String[] args) {

        final ArrayList list = new ArrayList(2);

        list.addLast("SLB");
        list.addLast("O");
        list.addLast("MAIOR");

        while (list.size() != 0) {
            System.out.println(list.removeFirst());
        }
    }
}
