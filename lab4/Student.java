package lab4;

public class Student extends Person {
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