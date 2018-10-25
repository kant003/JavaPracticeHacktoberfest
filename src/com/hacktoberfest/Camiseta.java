package com.hacktoberfest;

import java.util.Scanner;

public class Camiseta {

    public static void main(String[] args) {

       int a,b;

       Scanner scanner= new Scanner(System.in);

       a= scanner.nextInt();
       b=scanner.nextInt();

        System.out.println("A o B?");

       if (a=='1'){
           System.out.println("Gracias por la camiseta");
       }else if (b=='0'){
           System.out.println("Gracias por las pegatinas");
       }else{
           System.out.println("Error");
       }

    }

}
