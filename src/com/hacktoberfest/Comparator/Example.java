package com.hacktoberfest.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class will show sorting with comparator
 * Created by helltux on 25.10.16.
 */
public class Example {
    public static void main(String args[]) {
        // Takes a list of Pet objects
        List<Pet> list = new ArrayList<Pet>();

        list.add(new Pet("Chomper", 3));
        list.add(new Pet("Zipper", 2));
        list.add(new Pet("Wobble", 10));
        list.add(new Pet("Pudge", 4));
        list.add(new Pet("Admiral", 6));
        list.add(new Pet("Axel", 2));
        list.add(new Pet("Bullet", 1));
        Collections.sort(list);// Sorts the array list

        for(Pet a: list) {   // printing the sorted list of names
            System.out.print(a.getName() + ", ");
        }

        // Sorts the array list using comparator
        Collections.sort(list, new Pet());

        for(Pet a: list) { // printing the sorted list of ages
            System.out.print(a.getName() + ":" + a.getAge() + ",  ");
        }
    }
}
