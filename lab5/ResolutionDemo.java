package lab5;

class Parent {
    String type = "Parent Field";
    String getType() { return "Parent Method"; }
}

class Child extends Parent {
    String type = "Child Field"; 
    @Override String getType() { return "Child Method"; } 
}

public class ResolutionDemo {
    public static void main(String[] args) {
        Parent obj = new Child(); 
        
        System.out.println("Field access: " + obj.type);
        System.out.println("Method access: " + obj.getType());
    }
}