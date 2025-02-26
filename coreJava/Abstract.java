package coreJava;

//An abstract class in Java is a class that cannot be instantiated and is meant to be extended by other classes.
//It serves as a blueprint for subclasses, defining common behavior while allowing specific implementations in derived classes.

//✅ Cannot be instantiated → You cannot create an object of an abstract class.
//✅ Can have abstract methods (methods without a body) → These must be implemented by subclasses.
//✅ Can have concrete (regular) methods → These can be inherited by subclasses.
//✅ Can have constructors → Used to initialize common properties for subclasses.
//✅ Can have instance variables and static methods → Unlike interfaces, abstract classes can store state.
//✅ Supports inheritance → Other classes can extend it using extends keyword, 
// the extended class must implement all the abstract methods, else it'll also be an abstract class.

abstract class Animal {
    String name;

    // Constructor (abstract class can have a constructor)
    Animal(String name) {
        this.name = name;
        System.out.println(name + " is created");
    }

    // Abstract method (must be implemented by sub-classes)
    abstract void makeSound();

    // Concrete method (common behavior for all subclasses)
    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// subclass
class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " barks");
    }
}

// Another subclass, subclass must implement all the inherited abstract methods, 
// else declare subclass also as an abstract
class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " meows");
    }
}

public class Abstract {
    public static void main(String[] args) {
        // Animal myAnimal = new Animal("Some Animal"); ❌ Not allowed (abstract class)

        Dog myDog = new Dog("Buddy");
        myDog.makeSound(); // Output: Buddy barks
        myDog.sleep(); // Output: Buddy is sleeping

        Cat myCat = new Cat("Whiskers");
        myCat.makeSound(); // Output: Whiskers meows
        myCat.sleep(); // Output: Whiskers is sleeping

    }
}
