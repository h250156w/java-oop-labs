package lab5;

interface Payment { void process(); }

class CardPayment implements Payment {
    @Override public void process() { System.out.println("Polymorphic: Card swiped"); }
}

class MobilePayment implements Payment {
    @Override public void process() { System.out.println("Polymorphic: Mobile scanned"); }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment[] payments = { new CardPayment(), new MobilePayment() };
        for (Payment p : payments) {
            p.process();
        }
    }
}