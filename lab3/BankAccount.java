package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double initialDeposit) {
        if (initialDeposit < 0) throw new IllegalArgumentException("Deposit cannot be negative");
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialDeposit;
        history.add("Account opened with $" + initialDeposit);
    }

    public double getBalance() { return balance; }

    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        history.add("Deposited $" + amount);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "James", 500);
        acc.deposit(200);
        System.out.println("Balance: $" + acc.getBalance());
        System.out.println("History: " + acc.getHistory());
        
        try {
            acc.getHistory().clear(); 
        } catch (UnsupportedOperationException e) {
            System.out.println("Encapsulation protected the history list.");
        }
    }
}