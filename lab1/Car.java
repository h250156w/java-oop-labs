package lab1;

public class Car {
    String brand;
    int year;
    int mileage;

    public Car(String brand, int year, int mileage) {
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage);
    }

    boolean isAntique() {
        return 2026 - year > 25;
    }
    

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 2020, 15000);
        Car car2 = new Car("Honda", 2018, 30000);
        Car car3 = new Car("Ford", 2021, 10000);

        System.out.println("Car 1 Details:");
        car1.display();

        System.out.println("\nCar 2 Details:");
        car2.display();

        System.out.println("\nCar 3 Details:");
        car3.display();
    }
}


