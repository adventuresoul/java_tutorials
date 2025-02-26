package Tutorials;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//An interface in Java is a blueprint of a class that contains only abstract methods (before Java 8) and default/static methods (from Java 8 onward). 
// It defines a contract that implementing classes must follow.

/*
 * Key Features of Interfaces:
✔ No Object Creation: Cannot create an instance of an interface.
✔ Method Signatures Only: Methods are public and abstract by default.
✔ No Instance Variables: Only public, static, and final (constants) fields are allowed.
✔ Multiple Inheritance: A class can implement multiple interfaces, overcoming Java's single inheritance limitation.
✔ Support for Default & Static Methods (Java 8+): Interfaces can have methods with bodies using default and static keywords.
✔ Functional Interfaces (Java 8+): Interfaces with a single abstract method can be used with lambda expressions.
✔ If implementing class doesn't implement all the methods, it'll become abstract class
 */

interface Animal {
    void makeSound();
}

// Implementing an interface
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// another Interface
interface Pet {
    void play();
}

class Cat implements Animal, Pet {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }

    @Override
    public void play() {
        System.out.println("Cat plays with ball");
    }
}

// Default & static methods in Interface
interface Vehicle {
    void start();

    // Default method
    default void honk() {
        System.out.println("Honking .... Beep Beep!");
    }

    // static method
    static void serviceInfo() {
        System.out.println("Vehicle service every 6 months");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting");
    }
}

// Marker Interface Example
interface MarkerInterface {} // No methods, just a tag
class Sample implements Serializable {  // serializable is an marker interface, no implementations

}

class Person implements MarkerInterface {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Nested Interface
class Outer {
    interface Inner {
        void display();
    }
}

class Implementation implements Outer.Inner {
    @Override
    public void display() {
        System.out.println("Nested Interface Implementation");
    }
}

// Anonymous Inner Class for Interface
interface Greeting {
    void sayHello();
}




public class Interface {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound(); // Output: Dog barks

        Cat myCat = new Cat();
        myCat.makeSound(); // Output: Cat meows
        myCat.play();      // Output: Cat plays with a ball

        Car myCar = new Car();
        myCar.start(); // Output: Car is starting...
        myCar.honk();  // Output: Honking... Beep Beep!
        Vehicle.serviceInfo(); // Output: Vehicle service every 6 months

        Person person = new Person("John Doe", 30);
        System.out.println(person); // Output: Person{name='John Doe', age=30}

        Outer.Inner nestedObj = new Implementation();
        nestedObj.display(); // Output: Nested Interface Implementation

        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Inner Class!");
            }
        };
        greeting.sayHello(); // Output: Hello from Anonymous Inner Class!
    }
}
