import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student Management System for Hacktoberfest
 * Author: GitHub Copilot
 * Description: A simple system to manage student records
 */
public class StudentManager {
    
    // List to store all students
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Main method to run the student management system
     */
    public static void main(String[] args) {
        System.out.println("=== Student Management System ===");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    calculateAverageGrade();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using Student Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Displays the main menu
     */
    private static void displayMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Remove Student");
        System.out.println("5. Calculate Average Grade");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }
    
    /**
     * Gets user choice with error handling
     */
    private static int getChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
    
    /**
     * Adds a new student to the system
     */
    private static void addStudent() {
        try {
            scanner.nextLine(); // Clear buffer
            
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Enter student grade (0-100): ");
            double grade = scanner.nextDouble();
            
            // Validate grade range
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade! Grade must be between 0 and 100.");
                return;
            }
            
            // Check if student ID already exists
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    System.out.println("Student with ID " + id + " already exists!");
                    return;
                }
            }
            
            // Create and add new student
            Student student = new Student(name, id, grade);
            students.add(student);
            System.out.println("Student added successfully!");
            
        } catch (Exception e) {
            System.out.println("Error adding student! Please check your input.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Displays all students in the system
     */
    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }
        
        System.out.println("\n=== ALL STUDENTS ===");
        System.out.printf("%-15s %-10s %-8s %-10s%n", "Name", "ID", "Grade", "Letter Grade");
        System.out.println("------------------------------------------------");
        
        for (Student student : students) {
            System.out.printf("%-15s %-10s %-8.2f %-10s%n", 
                student.getName(), 
                student.getId(), 
                student.getGrade(),
                student.getLetterGrade());
        }
    }
    
    /**
     * Searches for a student by ID
     */
    private static void searchStudent() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter student ID to search: ");
        String searchId = scanner.nextLine();
        
        for (Student student : students) {
            if (student.getId().equals(searchId)) {
                System.out.println("\nStudent found:");
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("Grade: " + student.getGrade());
                System.out.println("Letter Grade: " + student.getLetterGrade());
                return;
            }
        }
        
        System.out.println("Student with ID " + searchId + " not found.");
    }
    
    /**
     * Removes a student from the system
     */
    private static void removeStudent() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter student ID to remove: ");
        String removeId = scanner.nextLine();
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(removeId)) {
                students.remove(i);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        
        System.out.println("Student with ID " + removeId + " not found.");
    }
    
    /**
     * Calculates and displays the average grade of all students
     */
    private static void calculateAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }
        
        double totalGrade = 0;
        for (Student student : students) {
            totalGrade += student.getGrade();
        }
        
        double average = totalGrade / students.size();
        System.out.printf("Average grade of %d students: %.2f%n", students.size(), average);
    }
}