// Main.java
// Entry point of the program demonstrating usage of the Person class.

public class Main {
    public static void main(String[] args) {
        // Create a few Person objects
        Person p1 = new Person("Alice", 22);
        Person p2 = new Person("Bob", 16);

        // Introduce the persons
        p1.introduce();
        p2.introduce();

        // Check and display if each person is an adult
        System.out.println(p1.isAdult() ? p1 + " is an adult." : p1 + " is not an adult.");
        System.out.println(p2.isAdult() ? p2 + " is an adult." : p2 + " is not an adult.");
    }
}
