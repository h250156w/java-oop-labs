package lab5;

class Employee {
    protected double baseSalary;
    public Employee(double baseSalary) { this.baseSalary = baseSalary; }
    public double calculatePay() { return baseSalary; }
}

class Manager extends Employee {
    private double bonus;
    public Manager(double baseSalary, double bonus) { super(baseSalary); this.bonus = bonus; }
    @Override public double calculatePay() { return baseSalary + bonus; }
}

class Developer extends Employee {
    private int overtimeHours;
    public Developer(double baseSalary, int overtimeHours) { super(baseSalary); this.overtimeHours = overtimeHours; }
    @Override public double calculatePay() { return baseSalary + (overtimeHours * 25.0); }
}

class Intern extends Employee {
    public Intern(double stipend) { super(stipend); }
    @Override public double calculatePay() { return baseSalary; } 
}

public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] staff = {
            new Employee(2000),
            new Manager(3500, 800),
            new Developer(3000, 10),
            new Intern(500)
        };

        double totalPayroll = 0;
        for (Employee e : staff) {
            totalPayroll += e.calculatePay(); 
        }
        System.out.printf("Total Payroll: $%.2f%n", totalPayroll);
    }
}

