/**
 * Student Class for Student Management System
 * Author: GitHub Copilot  
 * Description: Represents a student with name, ID, and grade information
 */
public class Student {
    
    // Private fields to store student information
    private String name;
    private String id;
    private double grade;
    
    /**
     * Constructor to create a new Student object
     * @param name The student's name
     * @param id The student's ID
     * @param grade The student's grade (0-100)
     */
    public Student(String name, String id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    
    /**
     * Gets the student's name
     * @return The student's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the student's name
     * @param name The new name for the student
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the student's ID
     * @return The student's ID
     */
    public String getId() {
        return id;
    }
    
    /**
     * Sets the student's ID
     * @param id The new ID for the student
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Gets the student's grade
     * @return The student's grade
     */
    public double getGrade() {
        return grade;
    }
    
    /**
     * Sets the student's grade
     * @param grade The new grade for the student (0-100)
     */
    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade! Grade must be between 0 and 100.");
        }
    }
    
    /**
     * Calculates and returns the letter grade based on numerical grade
     * @return The letter grade (A, B, C, D, or F)
     */
    public String getLetterGrade() {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    /**
     * Checks if the student is passing (grade >= 60)
     * @return true if the student is passing, false otherwise
     */
    public boolean isPassing() {
        return grade >= 60;
    }
    
    /**
     * Returns a string representation of the student
     * @return String containing student information
     */
    @Override
    public String toString() {
        return String.format("Student{name='%s', id='%s', grade=%.2f, letterGrade='%s'}", 
                           name, id, grade, getLetterGrade());
    }
    
    /**
     * Checks if two students are equal based on their ID
     * @param obj The object to compare with
     * @return true if the students have the same ID, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return id.equals(student.id);
    }
}