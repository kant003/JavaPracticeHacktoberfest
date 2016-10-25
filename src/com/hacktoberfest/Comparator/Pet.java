package com.hacktoberfest.Comparator;

import java.util.Comparator;

/**
 * this class is only a object with comparator to show how you can sort with comparator
 * Created by helltux on 25.10.16.
 */
public class Pet implements Comparator<Pet>, Comparable<Pet>{
    //Object variabel
    private String name;
    private Integer age;

    //Constructors
    public Pet(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Pet pet) {
        return (this.name).compareTo(pet.name);
    }

    @Override
    public int compare(Pet pet, Pet t1) {
        return pet.age - t1.age;
    }
}
