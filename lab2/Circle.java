package lab2;


public class Circle {
    private static int counter = 0;
    double radius;

    {
        counter++;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
        this(1.0);   
    }
    public static int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle();
        System.out.println("Circle 1 radius: " + c1.radius);
        System.out.println("Circle 2 radius: " + c2.radius);
        System.out.println("Number of circles created: " + Circle.getCounter());

    }
    


}
