package lab6;

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override public void fly() { System.out.println("Bird flaps wings to fly."); }
}

class Aeroplane implements Flyable {
    @Override public void fly() { System.out.println("Aeroplane uses engines to fly."); }
}

public class FlightDemo {
    public static void main(String[] args) {
        Flyable[] flyers = { new Bird(), new Aeroplane() };
        for (Flyable f : flyers) {
            f.fly();
        }
    }
}

