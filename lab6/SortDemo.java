package lab6;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
    private String name;
    private double marks;

    public Student(String name, double marks) { this.name = name; this.marks = marks; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name); 
    }

    @Override
    public String toString() { return name + "(" + marks + ")"; }
}

public class SortDemo {
    public static void main(String[] args) {
        Student[] students = {
            new Student("James", 85),
            new Student("Alice", 92),
            new Student("Bob", 78)
        };

        Arrays.sort(students);
        System.out.println("Sorted by Name: " + Arrays.toString(students));

        Arrays.sort(students, Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Sorted by Marks Desc: " + Arrays.toString(students));
    }
}

