package com.hacktoberfest;

/**
 * Created by helltux on 25.10.16.
 * This class will show the difference between String and StringBuilder
 */
public class StringOrStringBuilder {


    public static void main(String[] args){
        final int loops = 10;
        System.out.println("Start with String:");
        startWithStringLog(loops);
        System.out.println("Start with StringBuilder:");
        startWithStringBuilderLog(loops);
    }

    private static void startWithStringLog(final int loops) {
        String log = ""; //make a not final String
        for (int i = 0; i < loops; i++) {
            log = log + " " + i; //to add new value, add the old string before
        }
        System.out.println(log);
    }

    private static void startWithStringBuilderLog(final int loops) {
        final StringBuilder stringBuilder = new StringBuilder(); //make a final StringBuilder
        for (int i = 0; i < loops; i++){
            stringBuilder.append(" " + i); //to add new value, append to the StringBuilder
        }
        System.out.println(stringBuilder.toString()); //with .toString() get the String from StringBuilder
    }
}
