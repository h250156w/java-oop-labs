package lab6;

interface InterfaceA {
    default void hello() { System.out.println("Hello from A"); }
}

interface InterfaceB {
    default void hello() { System.out.println("Hello from B"); }
}

class ConflictResolver implements InterfaceA, InterfaceB {
    @Override
    public void hello() {
        InterfaceA.super.hello(); 
    }
}

public class ConflictDemo {
    public static void main(String[] args) {
        new ConflictResolver().hello();
    }
}

