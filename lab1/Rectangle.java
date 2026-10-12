package lab1;

public class Rectangle {
    double length;
    double width;



    double area() {
        return length * width;
    }

    double perimeter() {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle();
        rectangles[0].length = 5.0;
        rectangles[0].width = 3.0;
        rectangles[1] = new Rectangle();
        rectangles[1].length = 7.5;
        rectangles[1].width = 4.5;
        rectangles[2] = new Rectangle();
        rectangles[2].length = 10.0;
        rectangles[2].width = 6.0;
        rectangles[3] = new Rectangle();
        rectangles[3].length = 12.5;
        rectangles[3].width = 8.5;
        rectangles[4] = new Rectangle();
        rectangles[4].length = 15.0;
        rectangles[4].width = 10.0;

        int maxAreaIndex = 0;
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i].area() > rectangles[maxAreaIndex].area()) {
                maxAreaIndex = i;
            }
        }
        System.out.println("Rectangle with the largest area: " + (maxAreaIndex + 1) + " (Area: " + rectangles[maxAreaIndex].area() + ")");

        Rectangle r1 = new Rectangle();
        r1.length = 5.0;
        r1.width = 3.0;
        Rectangle r2 = r1;
        r2.width = 10.0;
        System.out.println("Width of r1: " + r1.width); 
    }
}
