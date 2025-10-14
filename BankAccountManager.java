import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Bank Account Management System for Hacktoberfest
 * Author: GitHub Copilot
 * Description: A simple banking system to manage account operations
 */
public class BankAccountManager {
    
    // Static variables for the banking system
    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");
    private static int accountCounter = 1000; // Starting account number
    
    /**
     * Main method to run the bank account management system
     */
    public static void main(String[] args) {
        System.out.println("=== Welcome to Simple Bank Management System ===");
        
        // Create a sample account for demonstration
        BankAccount account = null;
        boolean running = true;
        
        while (running) {
            if (account == null) {
                displayWelcomeMenu();
                int choice = getChoice();
                
                switch (choice) {
                    case 1:
                        account = createAccount();
                        break;
                    case 2:
                        account = loadDemoAccount();
                        break;
                    case 3:
                        running = false;
                        System.out.println("Thank you for using Simple Bank! Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } else {
                displayMainMenu(account);
                int choice = getChoice();
                
                switch (choice) {
                    case 1:
                        checkBalance(account);
                        break;
                    case 2:
                        depositMoney(account);
                        break;
                    case 3:
                        withdrawMoney(account);
                        break;
                    case 4:
                        transferMoney(account);
                        break;
                    case 5:
                        viewTransactionHistory(account);
                        break;
                    case 6:
                        displayAccountInfo(account);
                        break;
                    case 7:
                        account = null; // Logout
                        System.out.println("Logged out successfully!");
                        break;
                    case 8:
                        running = false;
                        System.out.println("Thank you for using Simple Bank! Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
        
        scanner.close();
    }
    
    /**
     * Displays the welcome menu for new users
     */
    private static void displayWelcomeMenu() {
        System.out.println("\n=== Welcome Menu ===");
        System.out.println("1. Create New Account");
        System.out.println("2. Use Demo Account");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
    }
    
    /**
     * Displays the main menu for logged-in users
     */
    private static void displayMainMenu(BankAccount account) {
        System.out.println("\n=== Main Menu ===");
        System.out.println("Welcome, " + account.getAccountHolderName() + "!");
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Current Balance: " + currencyFormat.format(account.getBalance()));
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money (Simulation)");
        System.out.println("5. View Transaction History");
        System.out.println("6. Account Information");
        System.out.println("7. Logout");
        System.out.println("8. Exit");
        System.out.print("Enter your choice (1-8): ");
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
     * Creates a new bank account
     */
    private static BankAccount createAccount() {
        System.out.println("\n=== Create New Account ===");
        
        try {
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine().trim();
            
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty!");
                return null;
            }
            
            System.out.print("Enter initial deposit amount: $");
            double initialDeposit = scanner.nextDouble();
            
            if (initialDeposit < 0) {
                System.out.println("Initial deposit cannot be negative!");
                return null;
            }
            
            // Generate account number
            String accountNumber = "ACC" + String.format("%06d", accountCounter++);
            
            BankAccount account = new BankAccount(accountNumber, name, initialDeposit);
            
            System.out.println("\n🎉 Account created successfully!");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + name);
            System.out.println("Initial Balance: " + currencyFormat.format(initialDeposit));
            
            return account;
            
        } catch (Exception e) {
            System.out.println("Error creating account! Please check your input.");
            scanner.nextLine(); // Clear invalid input
            return null;
        }
    }
    
    /**
     * Loads a demonstration account with sample data
     */
    private static BankAccount loadDemoAccount() {
        BankAccount demoAccount = new BankAccount("DEMO001", "Demo User", 1500.00);
        
        // Add some sample transactions
        demoAccount.deposit(200.00);
        demoAccount.withdraw(50.00);
        demoAccount.deposit(300.00);
        
        System.out.println("\n✅ Demo account loaded successfully!");
        System.out.println("Account Number: DEMO001");
        System.out.println("Account Holder: Demo User");
        System.out.println("Balance: " + currencyFormat.format(demoAccount.getBalance()));
        
        return demoAccount;
    }
    
    /**
     * Displays current account balance
     */
    private static void checkBalance(BankAccount account) {
        System.out.println("\n=== Balance Inquiry ===");
        System.out.println("Current Balance: " + currencyFormat.format(account.getBalance()));
        System.out.println("Account Status: " + 
            (account.getBalance() >= 0 ? "✅ Active" : "⚠️ Overdrawn"));
    }
    
    /**
     * Handles money deposit
     */
    private static void depositMoney(BankAccount account) {
        System.out.println("\n=== Deposit Money ===");
        System.out.print("Enter deposit amount: $");
        
        try {
            double amount = scanner.nextDouble();
            
            if (account.deposit(amount)) {
                System.out.println("✅ Deposit successful!");
                System.out.println("Amount Deposited: " + currencyFormat.format(amount));
                System.out.println("New Balance: " + currencyFormat.format(account.getBalance()));
            } else {
                System.out.println("❌ Deposit failed! Please check the amount.");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Invalid amount! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Handles money withdrawal
     */
    private static void withdrawMoney(BankAccount account) {
        System.out.println("\n=== Withdraw Money ===");
        System.out.println("Current Balance: " + currencyFormat.format(account.getBalance()));
        System.out.print("Enter withdrawal amount: $");
        
        try {
            double amount = scanner.nextDouble();
            
            if (account.withdraw(amount)) {
                System.out.println("✅ Withdrawal successful!");
                System.out.println("Amount Withdrawn: " + currencyFormat.format(amount));
                System.out.println("New Balance: " + currencyFormat.format(account.getBalance()));
            } else {
                System.out.println("❌ Withdrawal failed! Insufficient funds or invalid amount.");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Invalid amount! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Simulates money transfer (for demonstration)
     */
    private static void transferMoney(BankAccount account) {
        System.out.println("\n=== Transfer Money (Simulation) ===");
        System.out.println("Current Balance: " + currencyFormat.format(account.getBalance()));
        
        try {
            System.out.print("Enter recipient account number: ");
            String recipientAccount = scanner.nextLine();
            
            System.out.print("Enter transfer amount: $");
            double amount = scanner.nextDouble();
            
            if (account.withdraw(amount)) {
                System.out.println("✅ Transfer successful!");
                System.out.println("Amount Transferred: " + currencyFormat.format(amount));
                System.out.println("To Account: " + recipientAccount);
                System.out.println("New Balance: " + currencyFormat.format(account.getBalance()));
                
                // Add transfer to transaction history
                account.addTransaction("TRANSFER", -amount, "Transfer to " + recipientAccount);
            } else {
                System.out.println("❌ Transfer failed! Insufficient funds or invalid amount.");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please check your entries.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Displays transaction history
     */
    private static void viewTransactionHistory(BankAccount account) {
        System.out.println("\n=== Transaction History ===");
        ArrayList<String> history = account.getTransactionHistory();
        
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        
        System.out.println("Recent Transactions:");
        System.out.println("─".repeat(60));
        
        // Show last 10 transactions
        int startIndex = Math.max(0, history.size() - 10);
        for (int i = startIndex; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
        
        if (history.size() > 10) {
            System.out.println("\n(Showing last 10 transactions)");
        }
    }
    
    /**
     * Displays detailed account information
     */
    private static void displayAccountInfo(BankAccount account) {
        System.out.println("\n=== Account Information ===");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Current Balance: " + currencyFormat.format(account.getBalance()));
        System.out.println("Account Created: " + account.getCreationDate());
        System.out.println("Total Transactions: " + account.getTransactionCount());
        System.out.println("Account Status: " + 
            (account.getBalance() >= 0 ? "✅ Active" : "⚠️ Overdrawn"));
    }
}