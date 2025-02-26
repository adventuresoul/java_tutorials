package coreJava;

/*
Annotations are special markers or tags added to Java source code elements (classes, methods, fields, parameters, etc.). 
They do not directly affect program semantics but offer useful metadata.
 * Annotations in Java provide a way to add metadata to your source code. 
 * This metadata is not part of the program logic but can be used by the compiler, 
 * development tools, or even at runtime via reflection to guide program behavior, generate code, enforce rules, or produce documentation.
 */


//enefits of @Override:
//Ensures the method correctly overrides a superclass method.
//Helps prevent accidental method mismatches.

class Parent {
    void showMessage() {
        System.out.println("Save message parent");
    }
}

class Child extends Parent {
    @Override
    void showMessage() {
        System.out.println("Save message child");
    }
}

//Benefits of @Deprecated:
//Alerts developers that the method should not be used.
//Encourages use of newer, improved alternatives.
class Legacy {
    @Deprecated
    public void oldMethod() {
        System.out.println("This method is deprecated. Use newMethod() instead.");
    }
    void newMethod() {
        System.out.println("This is the recommended method.");
    }
}

//@FunctionalInterface Example
//The @FunctionalInterface annotation ensures an interface has exactly one abstract method.
//It helps enforce correct usage of functional interfaces in Lambda Expressions and Method References.
@FunctionalInterface
interface Calculator {
    public int calculate(int x, int y);
    // public int subtract();   only one abstract method
}

public class Annotations {
    public static void main(String[] args) {
        Legacy l1 = new Legacy();
        l1.oldMethod(); // deprecated
        l1.newMethod();
    }
}
