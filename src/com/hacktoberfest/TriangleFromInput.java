package com.example.springAngularBlog;

import java.util.Scanner;

public class TriangleFromInput {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input number: ");
        int num = input.nextInt();
        input.close();

        for (int i = 0; i < num; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
