package lab2;

public class Employee {
    private String name;
    private double salary;
    private String department;
    private final int employeeId;
    private static int counter = 0;

    {
        counter++;
        employeeId = counter;
    }
    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;   
    }
    public Employee(String name, double salary) {
        this(name, salary, "General");
    }
    public Employee(String name) {
        this(name, 50000.0, "General");
    }

    public Employee(Employee other) {
        this(other.name, other.salary, other.department);
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 60000.0, "HR");
        Employee e2 = new Employee("Bob", 70000.0);
        Employee e3 = new Employee("Charlie");
        Employee e4 = new Employee(e1);

        System.out.println("Employee 1 ID: " + e1.getEmployeeId());
        System.out.println("Employee 2 ID: " + e2.getEmployeeId());
        System.out.println("Employee 3 ID: " + e3.getEmployeeId());
        System.out.println("Employee 4 ID: " + e4.getEmployeeId());

        e1.salary = 65000.0; // Modify salary of e1
        System.out.println("Employee 1 new salary: " + e1.salary);
        System.out.println("Employee 4 salary (should be unchanged): " + e4.salary);
    }

}
