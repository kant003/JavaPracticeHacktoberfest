import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Task Class for To-Do List Manager
 * Author: GitHub Copilot
 * Description: Represents a single task with ID, description, priority, and completion status
 */
public class Task {
    
    // Private fields to store task information
    private int id;
    private String description;
    private String priority;
    private boolean completed;
    private Date creationDate;
    private Date completionDate;
    
    // Static formatter for dates
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Constructor to create a new task
     * @param id The unique ID for the task
     * @param description The task description
     * @param priority The priority level (High, Medium, Low)
     */
    public Task(int id, String description, String priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.completed = false;
        this.creationDate = new Date();
        this.completionDate = null;
    }
    
    /**
     * Gets the task ID
     * @return The task ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Gets the task description
     * @return The task description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the task description
     * @param description The new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets the task priority
     * @return The priority level
     */
    public String getPriority() {
        return priority;
    }
    
    /**
     * Sets the task priority
     * @param priority The new priority level
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    /**
     * Checks if the task is completed
     * @return true if completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }
    
    /**
     * Sets the completion status of the task
     * @param completed The completion status
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
        if (completed) {
            this.completionDate = new Date();
        } else {
            this.completionDate = null;
        }
    }
    
    /**
     * Gets the creation date as formatted string
     * @return The creation date
     */
    public String getCreationDate() {
        return dateFormat.format(creationDate);
    }
    
    /**
     * Gets the completion date as formatted string
     * @return The completion date, or null if not completed
     */
    public String getCompletionDate() {
        if (completionDate == null) {
            return "Not completed";
        }
        return dateFormat.format(completionDate);
    }
    
    /**
     * Gets the raw creation date object
     * @return The creation Date object
     */
    public Date getCreationDateObject() {
        return new Date(creationDate.getTime()); // Return copy for security
    }
    
    /**
     * Gets the raw completion date object
     * @return The completion Date object, or null if not completed
     */
    public Date getCompletionDateObject() {
        if (completionDate == null) {
            return null;
        }
        return new Date(completionDate.getTime()); // Return copy for security
    }
    
    /**
     * Calculates how long the task has been pending (if not completed)
     * or how long it took to complete (if completed)
     * @return Duration in days
     */
    public long getDurationInDays() {
        Date endDate = completed ? completionDate : new Date();
        long diffInMillis = endDate.getTime() - creationDate.getTime();
        return diffInMillis / (1000 * 60 * 60 * 24); // Convert to days
    }
    
    /**
     * Gets the priority level as a numeric value for sorting
     * @return Priority as number (1=High, 2=Medium, 3=Low)
     */
    public int getPriorityValue() {
        switch (priority) {
            case "High": return 1;
            case "Medium": return 2;
            case "Low": return 3;
            default: return 2; // Default to medium
        }
    }
    
    /**
     * Checks if the task matches a search term
     * @param searchTerm The term to search for
     * @return true if description contains the search term
     */
    public boolean matches(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return false;
        }
        return description.toLowerCase().contains(searchTerm.toLowerCase());
    }
    
    /**
     * Gets the status icon for the task
     * @return Status icon as string
     */
    public String getStatusIcon() {
        return completed ? "✅" : "⏳";
    }
    
    /**
     * Gets the priority icon for the task
     * @return Priority icon as string
     */
    public String getPriorityIcon() {
        switch (priority) {
            case "High": return "🔴";
            case "Medium": return "🟡";
            case "Low": return "🟢";
            default: return "⚪";
        }
    }
    
    /**
     * Creates a formatted summary of the task
     * @return Formatted task summary
     */
    public String getSummary() {
        String status = completed ? "✅ Completed" : "⏳ Pending";
        String priorityIcon = getPriorityIcon();
        
        return String.format("[%d] %s %s - %s %s (Created: %s)", 
            id, status, description, priorityIcon, priority, 
            getCreationDate().substring(0, 10));
    }
    
    /**
     * Returns a string representation of the task
     * @return String containing task information
     */
    @Override
    public String toString() {
        return String.format("Task{id=%d, description='%s', priority='%s', completed=%s, created='%s'}", 
                           id, description, priority, completed, getCreationDate());
    }
    
    /**
     * Checks if two tasks are equal based on their ID
     * @param obj The object to compare with
     * @return true if tasks have the same ID, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Task task = (Task) obj;
        return id == task.id;
    }
    
    /**
     * Generates hash code based on task ID
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}