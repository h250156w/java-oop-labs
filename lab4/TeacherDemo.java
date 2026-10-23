package lab4;

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
