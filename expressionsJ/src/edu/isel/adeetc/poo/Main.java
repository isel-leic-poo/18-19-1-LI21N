package edu.isel.adeetc.poo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        int result = Parser.parse(expression).evaluate();
        System.out.println(result);
    }
}
