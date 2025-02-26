package coreJava;

// Polymorphism is one of the fundamental concepts of Object-Oriented Programming (OOP) that allows objects of different classes to be treated as objects of a common superclass.
// In Java, polymorphism is mainly of two types:
// Compile-time Polymorphism (Static Polymorphism)
// Runtime Polymorphism (Dynamic Polymorphism)

// compile time polymorphism
// Static polymorphism is achieved using method overloading. 
// The method that gets called is resolved at compile time.

class MathOperations {
    // Method with two parameters
    int add(int a, int b) {
        return a + b;
    }

    // Method with three parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method with different data type
    double add(double a, double b) {
        return a + b;
    }
}


// Run-time polymorphism, dynamic 
// Runtime polymorphism is achieved using method overriding, where a subclass provides a specific implementation of a method that is already defined in its parent class.
// The method that gets executed is determined at runtime.
class Animal {
    void sound() {
        System.out.println("Animals make sounds");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}



public class Polymorphism {
    public static void main(String[] args) {
        MathOperations obj = new MathOperations();
        System.out.println(obj.add(5, 10));
        System.out.println(obj.add(5, 10, 15)); 

        Animal myAnimal = new Dog();
        myAnimal.sound();

        Animal myAnimal2 = new Cat();
        myAnimal2.sound();

        // Dog myDog = new Animal();
        // 1.Concept of "Is-A" Relationship
        // The subclass (Dog) extends the superclass (Animal), meaning Dog is an Animal (i.e., every Dog is an Animal).
        // However, not every Animal is necessarily a Dog. Other animals, such as Cats or Birds, also exist.
        // If Java allowed Dog myDog = new Animal();, then myDog might not have access to methods defined in Dog, like bark().
        // 2.Object Properties Problem
        // The Dog class might have additional attributes or methods that Animal does not.
        // Assigning an Animal object to a Dog reference could lead to situations where myDog calls a method that doesn’t exist in Animal.
    }
}
