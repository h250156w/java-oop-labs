package lab1;

public class Rectangle {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    double perimeter() {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle(5.0, 3.0);
        rectangles[1] = new Rectangle(7.5, 4.5);
        rectangles[2] = new Rectangle(10.0, 6.0);
        rectangles[3] = new Rectangle(12.5, 8.5);
        rectangles[4] = new Rectangle(15.0, 10.0);

        int maxAreaIndex = 0;
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i].area() > rectangles[maxAreaIndex].area()) {
                maxAreaIndex = i;
            }
        }
        System.out.println("Rectangle with the largest area: " + (maxAreaIndex + 1) + " (Area: " + rectangles[maxAreaIndex].area() + ")");

        Rectangle r1 = new Rectangle(10, 20 );
        Rectangle r2 = r1;
        r2.width = 40;
        System.out.println(r1.width);



    }
}
