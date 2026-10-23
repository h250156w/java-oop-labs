package lab4;
class Person {
    protected String name;
    protected int age;
    

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    private String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Course: " + course);
    }
}
public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student("Alice", 20, "Computer Science");
        System.out.println("--- Student ---");
        s.display();
    }
}