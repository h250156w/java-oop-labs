package lab4;

class Vehicle {
    public Vehicle() { System.out.println("Vehicle Constructor"); }
}

class Car extends Vehicle {
    public Car() { System.out.println("Car Constructor"); }
}

class ElectricCar extends Car {
    public ElectricCar() { System.out.println("ElectricCar Constructor"); }

    public static void main(String[] args) {
        new ElectricCar();
    }
}
