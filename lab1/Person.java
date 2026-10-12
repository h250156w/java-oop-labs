package lab1;

public class Person {
    String name;
    int age;
    Address address;

public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Alice";
        person1.age = 30;
        Address address1 = new Address();
        address1.city = "Harare";
        person1.address = address1;

        System.out.println("Person 1 Details:");
        System.out.println("Name: " + person1.name);
        System.out.println("Age: " + person1.age);
        System.out.println("City: " + person1.address.city);

        person1.address = null;
        System.out.println("Address object: " + person1.address);

        System.out.println("City: " + person1.address.city);
    }

}
