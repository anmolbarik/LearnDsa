package com.anmolbarik;


public class Main {
    public static void main(String[] args) {
        int x = 5;
        // Normal condition
        if (x == 5) {
            System.out.println("Normal condition matched");
        }
        // Yoda condition
        if (5 == x) {
            System.out.println("Yoda condition matched");
        }
        /*
         * Why some developers prefer:
         * if (5 == x)
         *
         * Imagine you accidentally write:
         *
         * if (x = 5)   // Mistake!
         *
         * In languages like C/C++, this becomes assignment instead of comparison.
         * But:
         *
         * if (5 = x)   // Compiler Error immediately
         *
         * So placing constants first can prevent accidental assignment bugs.
         */
        // Example mistake
        // Uncomment below line to see compiler error in Java
        // if (5 = x) {
        //     System.out.println("This will never compile");
        // }
        }
}