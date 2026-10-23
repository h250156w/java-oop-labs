package lab4;

class Animal {
    private String name;
    
    public Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        // Must explicitly call the parent constructor that matches, 
        // otherwise Java tries to call a default super() which doesn't exist here.
        super(name); 
    }

    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        System.out.println("Dog created successfully.");
    }
}
