package com.hacktoberfest;

/**
 * The class prints out a set of fibonacci numbers.
 */

import java.util.ArrayList;

public class FibonacciSequence {

	public static void main(String[] args) {
		System.out.println(fibonacciSeq(20)); //prints out first 20
	}

	public static ArrayList<Integer> fibonacciSeq(int amount) {
		ArrayList<Integer> seq = new ArrayList<Integer>();

		if (amount < 1)
			return seq;
		else if (amount < 2)
			seq.add(0); // first fibonacci number
		else {
			seq.add(0); // first fibonacci number
			seq.add(1); // second fibonacci number
		}

		// loop for fibonacci sequence
		for (int i = 2; i < amount; i++) {
			seq.add(seq.get(i - 1) + seq.get(i - 2));
		}
		return seq;
	}

}
