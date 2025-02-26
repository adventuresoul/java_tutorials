package Tutorials;

// Key Rules for Method Overriding
// Same Method Signature → The method in the child class must have the same name and parameter list.
// Inheritance Required → The method must be inherited from a parent class.
// Cannot Override Static Methods → Static methods belong to the class, not an instance.
// Cannot Override Final Methods → A method declared with final in the parent class cannot be overridden.
// Access Modifier Rules:
// A subclass cannot reduce the visibility of an overridden method (e.g., public in the superclass cannot be overridden with private in the subclass).
// It can increase visibility (e.g., protected in the superclass can be overridden with public in the subclass).
// Checked Exceptions → The overriding method cannot throw a broader exception than the superclass method.


// In Java, non-static and non-final methods are indeed "virtual" by default. 
// This means that method calls are dynamically dispatched at runtime based on the actual object type, allowing for method overriding to work as expected.

class Animal {
    public void sound() {
        System.out.println("Animals make sounds");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.sound();  // Expected output: "Dog barks"
    }    
}

