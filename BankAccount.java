import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * BankAccount Class for Bank Management System
 * Author: GitHub Copilot
 * Description: Represents a bank account with basic banking operations
 */
public class BankAccount {
    
    // Private fields to store account information
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private Date creationDate;
    private ArrayList<String> transactionHistory;
    
    // Static formatter for dates
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Constructor to create a new bank account
     * @param accountNumber The unique account number
     * @param accountHolderName The name of the account holder
     * @param initialBalance The initial balance for the account
     */
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.creationDate = new Date();
        this.transactionHistory = new ArrayList<>();
        
        // Add initial deposit to transaction history if balance > 0
        if (initialBalance > 0) {
            addTransaction("DEPOSIT", initialBalance, "Initial deposit - Account opening");
        }
    }
    
    /**
     * Gets the account number
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Gets the account holder name
     * @return The account holder name
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    /**
     * Gets the current balance
     * @return The current account balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Gets the account creation date
     * @return The date when account was created
     */
    public String getCreationDate() {
        return dateFormat.format(creationDate);
    }
    
    /**
     * Gets the transaction history
     * @return ArrayList of transaction history strings
     */
    public ArrayList<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return copy for security
    }
    
    /**
     * Gets the total number of transactions
     * @return Number of transactions performed
     */
    public int getTransactionCount() {
        return transactionHistory.size();
    }
    
    /**
     * Deposits money into the account
     * @param amount The amount to deposit
     * @return true if deposit successful, false otherwise
     */
    public boolean deposit(double amount) {
        // Validate deposit amount
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return false;
        }
        
        // Perform deposit
        balance += amount;
        addTransaction("DEPOSIT", amount, "Cash deposit");
        
        return true;
    }
    
    /**
     * Withdraws money from the account
     * @param amount The amount to withdraw
     * @return true if withdrawal successful, false otherwise
     */
    public boolean withdraw(double amount) {
        // Validate withdrawal amount
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return false;
        }
        
        // Check if sufficient funds available
        if (amount > balance) {
            System.out.println("Insufficient funds! Available balance: $" + String.format("%.2f", balance));
            return false;
        }
        
        // Perform withdrawal
        balance -= amount;
        addTransaction("WITHDRAWAL", -amount, "Cash withdrawal");
        
        return true;
    }
    
    /**
     * Adds a transaction to the history
     * @param type The type of transaction (DEPOSIT, WITHDRAWAL, TRANSFER)
     * @param amount The transaction amount (positive for credits, negative for debits)
     * @param description Description of the transaction
     */
    public void addTransaction(String type, double amount, String description) {
        Date now = new Date();
        String transaction = String.format("%s | %s | %s%.2f | %s | Balance: $%.2f", 
            dateFormat.format(now),
            type,
            amount >= 0 ? "+" : "",
            amount,
            description,
            balance);
        
        transactionHistory.add(transaction);
    }
    
    /**
     * Checks if the account has sufficient funds for a transaction
     * @param amount The amount to check
     * @return true if sufficient funds, false otherwise
     */
    public boolean hasSufficientFunds(double amount) {
        return balance >= amount && amount > 0;
    }
    
    /**
     * Gets the account status based on balance
     * @return Account status string
     */
    public String getAccountStatus() {
        if (balance >= 1000) {
            return "PREMIUM";
        } else if (balance >= 0) {
            return "ACTIVE";
        } else {
            return "OVERDRAWN";
        }
    }
    
    /**
     * Calculates interest for savings (simplified calculation)
     * @param rate Annual interest rate as percentage (e.g., 2.5 for 2.5%)
     * @return Interest amount calculated
     */
    public double calculateInterest(double rate) {
        if (balance <= 0 || rate <= 0) return 0;
        
        // Simple interest calculation (monthly)
        double monthlyRate = rate / 100 / 12;
        return balance * monthlyRate;
    }
    
    /**
     * Applies interest to the account
     * @param rate Annual interest rate as percentage
     * @return true if interest applied, false otherwise
     */
    public boolean applyInterest(double rate) {
        double interest = calculateInterest(rate);
        if (interest > 0) {
            balance += interest;
            addTransaction("INTEREST", interest, "Monthly interest credit @ " + rate + "% APR");
            return true;
        }
        return false;
    }
    
    /**
     * Returns a string representation of the account
     * @return String containing account information
     */
    @Override
    public String toString() {
        return String.format("BankAccount{accountNumber='%s', holder='%s', balance=%.2f, status='%s'}", 
                           accountNumber, accountHolderName, balance, getAccountStatus());
    }
    
    /**
     * Checks if two accounts are equal based on account number
     * @param obj The object to compare with
     * @return true if accounts have same account number, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        BankAccount account = (BankAccount) obj;
        return accountNumber.equals(account.accountNumber);
    }
}