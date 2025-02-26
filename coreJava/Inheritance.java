package coreJava;

// multiple inheritance is not possible in java
// all methods are virtual by default

// Inheritance is an Object-Oriented Programming (OOP) mechanism where one class (called a subclass or child class) inherits fields and methods from another class (called a superclass or parent class).
//  This promotes code reuse and establishes a relationship between classes.

// superclass
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called for " + name);
    }

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// subclass - single inheritance
class Dog extends Animal {
    Dog(String name) {
        super(name);
        System.out.println("Dog constructor called for " + name);
    }

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
    
    void display() {
        super.sound();
        this.sound();
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("=== Creating Animal Object ===");
        Animal animal = new Animal("Generic Animal");
        animal.sound();

        System.out.println("\n=== Creating Dog Object ===");
        Dog dog = new Dog("Buddy");
        dog.display();
    }
}
