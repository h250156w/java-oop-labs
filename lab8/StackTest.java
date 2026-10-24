package lab8;

import java.util.ArrayList;
import java.util.List;

class GenericStack<T> {
    private final List<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek an empty stack.");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

public class StackTest {
    public static void main(String[] args) {
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Java");
        stringStack.push("OOP");
        System.out.println("Popped string: " + stringStack.pop());

        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(100);
        intStack.push(200);
        System.out.println("Top integer: " + intStack.peek());
    }
}
