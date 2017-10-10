package com.hacktoberfest;

import java.util.ArrayList;

public class RecorrerArrayList {

	public static void main(String[] args) {
		new RecorrerArrayList();
	}

	public RecorrerArrayList(){
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Juan");
		lista.add("Ana");
		lista.add("Jose");
		lista.add("Lucas");
		lista.add("Pedro");
		
		for(String c:lista){
			System.out.println(c);
			
		}
	}
	
}
