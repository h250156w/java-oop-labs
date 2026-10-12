package lab1;

public class Car {
    String brand;
    int year;
    int mileage;

    
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage);
    }

    boolean isAntique() {
        return 2026 - year > 25;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.year = 2020;
        car1.mileage = 15000;

        Car car2 = new Car();
        car2.brand = "Honda";
        car2.year = 1999;
        car2.mileage = 30000;

        Car car3 = new Car();
        car3.brand = "Ford";
        car3.year = 2021;
        car3.mileage = 10000;

        System.out.println("Car 1 Details:");
        car1.display();

        System.out.println("\nCar 2 Details:");
        car2.display();

        System.out.println("\nCar 3 Details:");
        car3.display();

        System.out.println("\nIs Car 1 an antique? " + car1.isAntique());
        System.out.println("Is Car 2 an antique? " + car2.isAntique());

    }
}


