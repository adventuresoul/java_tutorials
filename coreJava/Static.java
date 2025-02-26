package Tutorials;

class Utility {
    // Static variable: shared among all instances (or without any instance)
    static int counter = 0;

    // Static block: executed once when the class is loaded
    static {
        counter = 100; // Complex initialization can be done here
        System.out.println("Static block executed: counter set to " + counter);
    }

    // Static method: can be called without an instance of Utility
    static int incrementCounter() {
        counter++; // Increments the static counter
        return counter;
    }
}

class Outer {
    // Static nested class: does not need an instance of Outer to be instantiated
    static class Nested {
        void displayMessage() {
            System.out.println("Inside static nested class of Outer");
        }
    }
}

public class Static {
    public static void main(String[] args) {
        // Accessing static variable and method from Utility class directly
        System.out.println("Initial counter: " + Utility.counter);
        System.out.println("After increment: " + Utility.incrementCounter());
        
        // Creating and using the static nested class from Outer
        Outer.Nested nested = new Outer.Nested();
        nested.displayMessage();
        
        // Demonstrating that the static variable is shared and persists
        System.out.println("Final counter value: " + Utility.counter);
    }
}
