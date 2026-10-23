package lab4;

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Subject: " + subject);
    }
}

public class TeacherDemo {
    public static void main(String[] args) {
        Student s = new Student("Alice", 20, "Computer Science");
        Teacher t = new Teacher("Mr. Smith", 45, "Mathematics");
        
        System.out.println("--- Student ---");
        s.display();
        System.out.println("--- Teacher ---");
        t.display();
    }
}
