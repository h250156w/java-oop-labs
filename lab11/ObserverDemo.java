package lab11;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class MemberObserver implements Observer {
    private final String name;

    public MemberObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}

class ItemSubject {
    private final List<Observer> observers = new ArrayList<>();
    private final String itemTitle;

    public ItemSubject(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String status) {
        for (Observer obs : observers) {
            obs.update("The item '" + itemTitle + "' is now " + status + ".");
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        ItemSubject bookSubject = new ItemSubject("Clean Code");

        MemberObserver m1 = new MemberObserver("James");
        MemberObserver m2 = new MemberObserver("Tariro");

        bookSubject.addObserver(m1);
        bookSubject.addObserver(m2);

        bookSubject.notifyObservers("AVAILABLE");
    }
}
