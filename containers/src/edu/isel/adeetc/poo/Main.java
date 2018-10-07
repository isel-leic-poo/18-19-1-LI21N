package edu.isel.adeetc.poo;

public class Main {

    public static void main(String[] args) {

        System.out.println("--------------- ArrayList ------------------");
        final ArrayList alist = new ArrayList(2);

        alist.addLast("SLB");
        alist.addLast("O");
        alist.addLast("MAIOR");

        while (alist.size() != 0) {
            System.out.println(alist.removeFirst());
        }

        System.out.println("\n--------------- LinkedList ------------------");
        final LinkedList llist = new LinkedList();
        llist.addFirst("SLB");
        llist.addFirst("GLORIOSO");
        llist.addFirst("SLB");
        llist.addFirst("SLB");

        while (llist.size() != 0) {
            System.out.println(llist.removeFirst());
        }
    }
}
