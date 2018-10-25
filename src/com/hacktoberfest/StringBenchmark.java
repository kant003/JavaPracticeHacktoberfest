package com.hacktoberfest;

import java.util.Scanner;

/**
 * This is interactive class
 *  which show some performance advantages
 *  of StringBuilder compared to String
 *
 * #TODO
 * add some java-doc commentary
 * for the following benchmarks methods
 */
public class StringBenchmark {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("input some number");

        long input = scanner.nextLong();

        long defaultTimeCost = testDefaultString(input);
        long BuilderTimeCost = testStringBuilder(input);

        long difference = defaultTimeCost - BuilderTimeCost;

        System.out.println(String.format("StringBuilder faster then Default String for %s mills", difference));

    }

    private static long testDefaultString(long input) {

        long start = System.currentTimeMillis();

        String ourString = "Hello World!";

        for (long i = 0; i < input; i++) {
            ourString += "\nHello World!";
        }

        long finish = System.currentTimeMillis();

        long result = finish - start;

        return result;

    }

    private static long testStringBuilder(long input) {

        long start = System.currentTimeMillis();

        StringBuilder ourString = new StringBuilder("Hello World!");

        for (long i = 0; i < input; i++) {
            ourString.append("\nHello World!");
        }

        long finish = System.currentTimeMillis();

        long result = finish - start;

        return result;

    }

}
