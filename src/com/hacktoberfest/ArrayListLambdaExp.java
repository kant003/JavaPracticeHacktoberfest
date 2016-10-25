package com.hacktoberfest;

import java.util.ArrayList;

/**Use Java's lambda expressions to print an array list*/
public class ArrayListLambdaExp {

	public void showArrayList(ArrayList<String> arr){
		arr.forEach(e -> System.out.println(e));
	}
	
	public ArrayListLambdaExp() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("One");
		arr.add("Two");
		arr.add("Three");
		
		showArrayList(arr);
	}

	public static void main(String[] args) {
		new ArrayListLambdaExp();

	}

}
