package lab3;

public class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        setName(name);
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 75) return "A";
        if (marks >= 65) return "B";
        if (marks >= 50) return "C";
        return "F";
    }

    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 82.5);
        System.out.printf("Student: %s | Marks: %.1f | Grade: %s%n", s1.getName(), s1.getMarks(), s1.getGrade());

        try {
            s1.setMarks(105); 
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
    }
}
