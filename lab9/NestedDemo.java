package lab9;

class Outer {
    private final String outerMessage = "Data from Outer Class";

    class Inner {
        void display() {
            System.out.println("Inner class accessing: " + outerMessage);
        }
    }

    static class StaticNested {
        void display() {
            System.out.println("Static nested class instantiated independently.");
        }
    }
}

public class NestedDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.display();

        Outer.StaticNested staticNested = new Outer.StaticNested();
        staticNested.display();
    }
}
