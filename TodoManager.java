import java.util.Scanner;
import java.util.ArrayList;

/**
 * To-Do List Manager for Hacktoberfest
 * Author: GitHub Copilot
 * Description: A simple task management system to organize daily tasks
 */
public class TodoManager {
    
    // List to store all tasks
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int taskIdCounter = 1;
    
    /**
     * Main method to run the to-do list manager
     */
    public static void main(String[] args) {
        System.out.println("=== Welcome to Simple To-Do List Manager ===");
        System.out.println("Stay organized and get things done! 📝");
        
        // Add some sample tasks for demonstration
        addSampleTasks();
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewAllTasks();
                    break;
                case 3:
                    markTaskComplete();
                    break;
                case 4:
                    markTaskIncomplete();
                    break;
                case 5:
                    editTask();
                    break;
                case 6:
                    deleteTask();
                    break;
                case 7:
                    viewCompletedTasks();
                    break;
                case 8:
                    viewPendingTasks();
                    break;
                case 9:
                    searchTasks();
                    break;
                case 10:
                    clearAllTasks();
                    break;
                case 11:
                    displayStatistics();
                    break;
                case 12:
                    running = false;
                    System.out.println("Thank you for using To-Do List Manager! Stay productive! 🚀");
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
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📋 TO-DO LIST MANAGER");
        System.out.println("=".repeat(50));
        System.out.println("1. ➕ Add New Task");
        System.out.println("2. 📄 View All Tasks");
        System.out.println("3. ✅ Mark Task as Complete");
        System.out.println("4. 🔄 Mark Task as Incomplete");
        System.out.println("5. ✏️  Edit Task");
        System.out.println("6. 🗑️  Delete Task");
        System.out.println("7. 🎉 View Completed Tasks");
        System.out.println("8. ⏳ View Pending Tasks");
        System.out.println("9. 🔍 Search Tasks");
        System.out.println("10. 🧹 Clear All Tasks");
        System.out.println("11. 📊 View Statistics");
        System.out.println("12. 🚪 Exit");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice (1-12): ");
    }
    
    /**
     * Gets user choice with error handling
     */
    private static int getChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
    
    /**
     * Adds sample tasks for demonstration
     */
    private static void addSampleTasks() {
        tasks.add(new Task(taskIdCounter++, "Complete Java programming assignment", "High"));
        tasks.add(new Task(taskIdCounter++, "Buy groceries", "Medium"));
        tasks.add(new Task(taskIdCounter++, "Call dentist for appointment", "Low"));
        
        // Mark one task as complete for demo
        tasks.get(0).setCompleted(true);
    }
    
    /**
     * Adds a new task
     */
    private static void addTask() {
        System.out.println("\n➕ Add New Task");
        System.out.println("-".repeat(30));
        
        try {
            System.out.print("Enter task description: ");
            String description = scanner.nextLine().trim();
            
            if (description.isEmpty()) {
                System.out.println("❌ Task description cannot be empty!");
                return;
            }
            
            System.out.println("Select priority level:");
            System.out.println("1. High 🔴");
            System.out.println("2. Medium 🟡");
            System.out.println("3. Low 🟢");
            System.out.print("Enter priority (1-3): ");
            
            int priorityChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            String priority;
            switch (priorityChoice) {
                case 1: priority = "High"; break;
                case 2: priority = "Medium"; break;
                case 3: priority = "Low"; break;
                default: 
                    System.out.println("Invalid priority! Setting to Medium.");
                    priority = "Medium";
                    break;
            }
            
            Task newTask = new Task(taskIdCounter++, description, priority);
            tasks.add(newTask);
            
            System.out.println("✅ Task added successfully!");
            System.out.println("Task ID: " + newTask.getId());
            System.out.println("Description: " + newTask.getDescription());
            System.out.println("Priority: " + newTask.getPriority());
            
        } catch (Exception e) {
            System.out.println("❌ Error adding task! Please check your input.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Views all tasks
     */
    private static void viewAllTasks() {
        System.out.println("\n📄 All Tasks");
        System.out.println("=".repeat(80));
        
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks found! Add some tasks to get started.");
            return;
        }
        
        System.out.printf("%-5s %-8s %-10s %-40s %-15s%n", 
            "ID", "Status", "Priority", "Description", "Created");
        System.out.println("-".repeat(80));
        
        for (Task task : tasks) {
            String status = task.isCompleted() ? "✅ Done" : "⏳ Pending";
            String priorityIcon = getPriorityIcon(task.getPriority());
            
            System.out.printf("%-5d %-8s %-10s %-40s %-15s%n",
                task.getId(),
                status,
                priorityIcon + " " + task.getPriority(),
                truncateString(task.getDescription(), 38),
                task.getCreationDate().substring(0, 10)); // Show only date
        }
    }
    
    /**
     * Marks a task as complete
     */
    private static void markTaskComplete() {
        System.out.println("\n✅ Mark Task as Complete");
        System.out.println("-".repeat(30));
        
        viewPendingTasks();
        
        if (getPendingTaskCount() == 0) {
            return;
        }
        
        System.out.print("Enter task ID to mark as complete: ");
        try {
            int taskId = scanner.nextInt();
            Task task = findTaskById(taskId);
            
            if (task == null) {
                System.out.println("❌ Task with ID " + taskId + " not found!");
                return;
            }
            
            if (task.isCompleted()) {
                System.out.println("ℹ️ Task is already completed!");
                return;
            }
            
            task.setCompleted(true);
            System.out.println("🎉 Task marked as complete!");
            System.out.println("✅ " + task.getDescription());
            
        } catch (Exception e) {
            System.out.println("❌ Invalid task ID! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Marks a task as incomplete
     */
    private static void markTaskIncomplete() {
        System.out.println("\n🔄 Mark Task as Incomplete");
        System.out.println("-".repeat(30));
        
        viewCompletedTasks();
        
        if (getCompletedTaskCount() == 0) {
            return;
        }
        
        System.out.print("Enter task ID to mark as incomplete: ");
        try {
            int taskId = scanner.nextInt();
            Task task = findTaskById(taskId);
            
            if (task == null) {
                System.out.println("❌ Task with ID " + taskId + " not found!");
                return;
            }
            
            if (!task.isCompleted()) {
                System.out.println("ℹ️ Task is already incomplete!");
                return;
            }
            
            task.setCompleted(false);
            System.out.println("🔄 Task marked as incomplete!");
            System.out.println("⏳ " + task.getDescription());
            
        } catch (Exception e) {
            System.out.println("❌ Invalid task ID! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Edits an existing task
     */
    private static void editTask() {
        System.out.println("\n✏️ Edit Task");
        System.out.println("-".repeat(30));
        
        viewAllTasks();
        
        if (tasks.isEmpty()) {
            return;
        }
        
        System.out.print("Enter task ID to edit: ");
        try {
            int taskId = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            Task task = findTaskById(taskId);
            
            if (task == null) {
                System.out.println("❌ Task with ID " + taskId + " not found!");
                return;
            }
            
            System.out.println("Current task: " + task.getDescription());
            System.out.print("Enter new description (press Enter to keep current): ");
            String newDescription = scanner.nextLine().trim();
            
            if (!newDescription.isEmpty()) {
                task.setDescription(newDescription);
                System.out.println("✅ Task description updated!");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Deletes a task
     */
    private static void deleteTask() {
        System.out.println("\n🗑️ Delete Task");
        System.out.println("-".repeat(30));
        
        viewAllTasks();
        
        if (tasks.isEmpty()) {
            return;
        }
        
        System.out.print("Enter task ID to delete: ");
        try {
            int taskId = scanner.nextInt();
            Task task = findTaskById(taskId);
            
            if (task == null) {
                System.out.println("❌ Task with ID " + taskId + " not found!");
                return;
            }
            
            tasks.remove(task);
            System.out.println("🗑️ Task deleted successfully!");
            System.out.println("Deleted: " + task.getDescription());
            
        } catch (Exception e) {
            System.out.println("❌ Invalid task ID! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Views only completed tasks
     */
    private static void viewCompletedTasks() {
        System.out.println("\n🎉 Completed Tasks");
        System.out.println("=".repeat(50));
        
        int count = 0;
        for (Task task : tasks) {
            if (task.isCompleted()) {
                System.out.printf("%d. ✅ %s (Priority: %s)%n", 
                    task.getId(), task.getDescription(), task.getPriority());
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("📭 No completed tasks found!");
        } else {
            System.out.println("\nTotal completed tasks: " + count);
        }
    }
    
    /**
     * Views only pending tasks
     */
    private static void viewPendingTasks() {
        System.out.println("\n⏳ Pending Tasks");
        System.out.println("=".repeat(50));
        
        int count = 0;
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                String priorityIcon = getPriorityIcon(task.getPriority());
                System.out.printf("%d. %s %s (Priority: %s)%n", 
                    task.getId(), priorityIcon, task.getDescription(), task.getPriority());
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("🎉 No pending tasks! Great job!");
        } else {
            System.out.println("\nTotal pending tasks: " + count);
        }
    }
    
    /**
     * Searches tasks by description
     */
    private static void searchTasks() {
        System.out.println("\n🔍 Search Tasks");
        System.out.println("-".repeat(30));
        
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine().trim().toLowerCase();
        
        if (searchTerm.isEmpty()) {
            System.out.println("❌ Search term cannot be empty!");
            return;
        }
        
        System.out.println("\nSearch results for: \"" + searchTerm + "\"");
        System.out.println("-".repeat(50));
        
        int count = 0;
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(searchTerm)) {
                String status = task.isCompleted() ? "✅ Done" : "⏳ Pending";
                System.out.printf("%d. %s - %s (Priority: %s)%n", 
                    task.getId(), status, task.getDescription(), task.getPriority());
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("📭 No tasks found matching: \"" + searchTerm + "\"");
        } else {
            System.out.println("\nFound " + count + " matching task(s).");
        }
    }
    
    /**
     * Clears all tasks
     */
    private static void clearAllTasks() {
        System.out.println("\n🧹 Clear All Tasks");
        System.out.println("-".repeat(30));
        
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks to clear!");
            return;
        }
        
        System.out.print("Are you sure you want to delete ALL tasks? (y/n): ");
        char confirmation = scanner.next().toLowerCase().charAt(0);
        scanner.nextLine(); // Clear buffer
        
        if (confirmation == 'y') {
            int taskCount = tasks.size();
            tasks.clear();
            taskIdCounter = 1; // Reset counter
            System.out.println("🧹 All " + taskCount + " task(s) cleared successfully!");
        } else {
            System.out.println("❌ Operation cancelled.");
        }
    }
    
    /**
     * Displays task statistics
     */
    private static void displayStatistics() {
        System.out.println("\n📊 Task Statistics");
        System.out.println("=".repeat(40));
        
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks available for statistics!");
            return;
        }
        
        int totalTasks = tasks.size();
        int completedTasks = getCompletedTaskCount();
        int pendingTasks = getPendingTaskCount();
        
        // Priority counts
        int highPriority = 0, mediumPriority = 0, lowPriority = 0;
        for (Task task : tasks) {
            switch (task.getPriority()) {
                case "High": highPriority++; break;
                case "Medium": mediumPriority++; break;
                case "Low": lowPriority++; break;
            }
        }
        
        double completionRate = totalTasks > 0 ? (double) completedTasks / totalTasks * 100 : 0;
        
        System.out.println("📈 General Statistics:");
        System.out.println("  Total Tasks: " + totalTasks);
        System.out.println("  ✅ Completed: " + completedTasks);
        System.out.println("  ⏳ Pending: " + pendingTasks);
        System.out.printf("  📊 Completion Rate: %.1f%%\n", completionRate);
        
        System.out.println("\n🎯 Priority Distribution:");
        System.out.println("  🔴 High Priority: " + highPriority);
        System.out.println("  🟡 Medium Priority: " + mediumPriority);
        System.out.println("  🟢 Low Priority: " + lowPriority);
        
        // Performance message
        if (completionRate >= 80) {
            System.out.println("\n🎉 Excellent! You're very productive!");
        } else if (completionRate >= 60) {
            System.out.println("\n👍 Good job! Keep up the momentum!");
        } else if (completionRate >= 40) {
            System.out.println("\n💪 You're making progress! Stay focused!");
        } else {
            System.out.println("\n🚀 Let's get those tasks done! You can do it!");
        }
    }
    
    // Helper methods
    
    /**
     * Finds a task by its ID
     */
    private static Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    
    /**
     * Gets the count of completed tasks
     */
    private static int getCompletedTaskCount() {
        int count = 0;
        for (Task task : tasks) {
            if (task.isCompleted()) count++;
        }
        return count;
    }
    
    /**
     * Gets the count of pending tasks
     */
    private static int getPendingTaskCount() {
        int count = 0;
        for (Task task : tasks) {
            if (!task.isCompleted()) count++;
        }
        return count;
    }
    
    /**
     * Gets priority icon
     */
    private static String getPriorityIcon(String priority) {
        switch (priority) {
            case "High": return "🔴";
            case "Medium": return "🟡";
            case "Low": return "🟢";
            default: return "⚪";
        }
    }
    
    /**
     * Truncates a string to specified length
     */
    private static String truncateString(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }
}