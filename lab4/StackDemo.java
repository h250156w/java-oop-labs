package lab4;

import java.util.ArrayList;

class GoodStack<T> {
    // HAS-A relationship (Composition) rather than IS-A (Inheritance)
    private final ArrayList<T> list = new ArrayList<>(); 

    public void push(T item) { list.add(item); }
    
    public T pop() { 
        if (list.isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.remove(list.size() - 1); 
    }
    
    public int size() { return list.size(); }
}

public class StackDemo {
    public static void main(String[] args) {
        GoodStack<String> stack = new GoodStack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Popped: " + stack.pop());
        // stack.clear(); // This would be a compile error, which is exactly what we want!
    }
}