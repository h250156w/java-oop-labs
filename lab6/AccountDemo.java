package lab6;

abstract class Account {
    protected double balance;
    
    public Account(double balance) { this.balance = balance; }
    
    public void deposit(double amount) { 
        balance += amount; 
        System.out.println("Deposited " + amount + ". Balance: " + balance);
    }
    
    abstract void applyMonthlyFee();
}

class SavingsAccount extends Account {
    public SavingsAccount(double balance) { super(balance); }
    @Override void applyMonthlyFee() {
        balance -= 5.0; 
        System.out.println("Savings fee applied. Balance: " + balance);
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(double balance) { super(balance); }
    @Override void applyMonthlyFee() {
        balance -= (balance * 0.01); 
        System.out.println("Current fee applied. Balance: " + balance);
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = { new SavingsAccount(1000), new CurrentAccount(2000) };
        for (Account acc : accounts) {
            acc.deposit(100);
            acc.applyMonthlyFee();
        }
    }
}

