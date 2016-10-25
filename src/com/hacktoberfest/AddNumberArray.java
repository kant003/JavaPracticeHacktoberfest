package com.hacktoberfest;

/**calculates the sum of an array of numbers*/
public class AddNumberArray {

	public int calcSum(int []nums){
		int cont = 0;
		for(int i=0; i<nums.length; i++){
			cont += nums[i];
		}
		return cont;
	}
	
	public AddNumberArray() {
		int []nums = {3,6,7,10,34,56};
		
		int s = calcSum(nums);
		System.out.println(s);
	}

	public static void main(String[] args) {
		new AddNumberArray();

	}

}
