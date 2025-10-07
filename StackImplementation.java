/**
 * Stack Data Structure Implementation using Array
 *
 * This class implements a stack data structure with basic operations like
 * push, pop, peek, and utility methods. Stack follows LIFO (Last In, First Out) principle.
 *
 * Time Complexities:
 * - Push: O(1)
 * - Pop: O(1)
 * - Peek: O(1)
 * - Search: O(n)
 *
 * @author Hacktoberfest Contributor
 * @version 1.0
 */
public class StackImplementation {
    private int[] stackArray;
    private int top;
    private int maxSize;

    /**
     * Constructor to initialize the stack with given size
     *
     * @param size Maximum size of the stack
     */
    public StackImplementation(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    /**
     * Pushes an element onto the top of the stack
     *
     * @param value The value to be pushed
     * @return true if push is successful, false if stack is full
     */
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return false;
        }
        stackArray[++top] = value;
        System.out.println("Pushed: " + value);
        return true;
    }

    /**
     * Removes and returns the top element from the stack
     *
     * @return The popped element, or -1 if stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop from empty stack");
            return -1;
        }
        int poppedValue = stackArray[top--];
        System.out.println("Popped: " + poppedValue);
        return poppedValue;
    }

    /**
     * Returns the top element without removing it
     *
     * @return The top element, or -1 if stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No element to peek");
            return -1;
        }
        return stackArray[top];
    }

    /**
     * Checks if the stack is empty
     *
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full
     *
     * @return true if stack is full, false otherwise
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * Returns the current size of the stack
     *
     * @return Number of elements in the stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Displays all elements in the stack from top to bottom
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i]);
            if (i > 0) System.out.print(" -> ");
        }
        System.out.println();
    }

    /**
     * Searches for an element in the stack
     *
     * @param value The value to search for
     * @return The position from top (1-indexed), or -1 if not found
     */
    public int search(int value) {
        for (int i = top; i >= 0; i--) {
            if (stackArray[i] == value) {
                return top - i + 1; // Return position from top (1-indexed)
            }
        }
        return -1; // Element not found
    }

    /**
     * Main method to demonstrate stack operations
     */
    public static void main(String[] args) {
        System.out.println("=== Stack Implementation Demo ===\n");

        // Create a stack of size 5
        StackImplementation stack = new StackImplementation(5);

        // Test isEmpty on new stack
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println();

        // Push elements
        System.out.println("--- Pushing Elements ---");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Try to push when stack is full
        stack.push(60);
        System.out.println();

        // Display stack
        stack.display();
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is stack full? " + stack.isFull());
        System.out.println();

        // Peek operation
        System.out.println("--- Peek Operation ---");
        System.out.println("Top element: " + stack.peek());
        System.out.println();

        // Search operation
        System.out.println("--- Search Operation ---");
        System.out.println("Position of 30 from top: " + stack.search(30));
        System.out.println("Position of 100 from top: " + stack.search(100));
        System.out.println();

        // Pop elements
        System.out.println("--- Popping Elements ---");
        stack.pop();
        stack.pop();
        stack.display();
        System.out.println();

        // Pop remaining elements
        while (!stack.isEmpty()) {
            stack.pop();
        }

        // Try to pop from empty stack
        stack.pop();

        System.out.println("\n=== Demo Complete ===");
    }
}