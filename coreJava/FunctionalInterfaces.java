package coreJava;

/*
 * An interface in Java is a blueprint of a class that contains abstract methods (methods without a body) and default/static methods. 
 * Interfaces help in achieving abstraction and multiple inheritance in Java.
1. Types of Interfaces in Java
Java provides different types of interfaces based on the number of abstract methods they contain.

1.1. Normal Interface (Regular Interface)
Contains multiple abstract methods.
Can have default and static methods (since Java 8).
Must be implemented by a class using implements.

1.2. Functional Interface
Contains exactly one abstract method.
Can have default and static methods.
Used in Lambda Expressions and Functional Programming.
Annotated with @FunctionalInterface (optional but recommended).

1.3. Marker Interface
An empty interface (no methods).
Used to provide metadata to Java classes.
Example: Serializable, Cloneable, Remote (in Java API).
 */

/*
 * 2. Lambda Expressions in Java
Lambda expressions provide a clear and concise way to implement a functional interface using anonymous functions.
 */

@FunctionalInterface
interface Message {
    public void sayHello();
}

@FunctionalInterface
interface Calculator {
    public int calculate(int x, int y);
}


public class FunctionalInterfaces {
    public static void main(String[] args) {
        // using ananymous inner class
        // Message obj = new Message() {
        //     @Override
        //     public void sayHello() {
        //         System.out.println("Hello world");
        //     }
        // };
        // obj.sayHello();

        Message obj = () -> {
            System.out.println("Hello world");
        };
        obj.sayHello();

        Calculator adder = (x, y) -> {
            return x + y;
        };
        System.out.println(adder.calculate(5, 6));
    }
}

/*
 * When to Use Each?
Use Normal Interface when multiple methods need implementation.
Use Functional Interface when you need a single behavior (best for Lambdas).
Use Marker Interface when you just want to tag classes.
Use Tagging Interface when a default implementation is needed.
Use Lambda Expressions when working with Functional Interfaces for cleaner, concise code.
 */
