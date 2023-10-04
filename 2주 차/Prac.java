package org.example;

public class Prac {
    public static void main(String[] args) {
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= 9; j++) {
                for(int k = 2+(i*4); k <= 5+(i*4); k++) {
                    System.out.print(k + " x " + j + " = " + String.format("%2d", k*j) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
