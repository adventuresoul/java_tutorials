package coreJava;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
    
    void fetch() {
        System.out.println("Dog fetches the ball");
    }
}


public class UpcastingDowncasting {
    public static void main(String[] args) {
        // Upcasting: Dog object is referenced by Animal type
        Animal animalRef = new Dog();
        
        // Dynamic method dispatch: Calls Dog's overridden sound() method
        animalRef.sound();  // Output: Dog barks

        //Downcasting is when a superclass reference is cast back to a subclass reference.
        //It is an explicit conversion because it can potentially lead to a runtime error if the object is not actually an instance of that subclass.

        Animal animalRef1 = new Dog();

        if (animalRef1 instanceof Dog) {
            Dog dogRef = (Dog) animalRef1;
            dogRef.fetch();
        }

        // Unsafe Downcasting Example:
        Animal anotherAnimal = new Animal();  // Pure Animal object
        // Dog wrongDog = (Dog) anotherAnimal; // ❌ Causes ClassCastException at runtime
    }
    
}
