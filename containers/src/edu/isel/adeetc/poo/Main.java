package edu.isel.adeetc.poo;

public class Main {

    private static void playWithList(List list) {
        System.out.println("--------------- List ------------------");
        list.addLast("SLB");
        list.addLast("O");
        list.addLast("MAIOR");

        while (list.size() != 0) {
            System.out.println(list.removeFirst());
        }
    }

    public static void main(String[] args) {

        playWithList(new ArrayList(5));
        playWithList(new LinkedList());
    }
}
