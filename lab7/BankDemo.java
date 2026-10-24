package lab7;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Cannot withdraw $" + amount + ". Current balance: $" + balance);
        }
        balance -= amount;
        System.out.println("Withdrew $" + amount + ". Remaining balance: $" + balance);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100.00);

        try {
            acc.withdraw(40.00);
            acc.withdraw(80.00); // Throws InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction Error: " + e.getMessage());
        }
    }
}
