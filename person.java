// Person.java
// A simple class representing a person with a name and age.

public class Person {
    private String name;
    private int age;

    // Constructor to initialize name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to introduce the person
    public void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
    }

    // Method to check if the person is an adult
    public boolean isAdult() {
        return age >= 18;
    }
}
