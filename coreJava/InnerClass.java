package coreJava;

//Inner Classes:
// Member inner classes are defined at the class level and have full access to the outer class.
// Local inner classes are defined within a block and have limited scope.
// Static nested classes are similar to top-level classes but grouped inside another class.

// Anonymous Inner Classes:
// Provide a quick, one-off implementation without naming the class.
// Commonly used for event handling and simple interface or abstract class implementations.

// Abstract and Anonymous Inner Classes:
// Allow you to create an instance of an abstract class by providing method implementations inline.
// Useful for short-term implementations where defining a separate subclass is unnecessary.
//--------------------------------------------------------------------------------------------------

/*
 * Types of Inner Classes
    Non-static (Member) Inner Class:
    Declared at the member level of the outer class (not inside a method).
    Has access to all members of the outer class.
    Local Inner Class:
    Defined within a block, such as a method, constructor, or even an initializer.
    Scope is limited to the block where it is defined.
    Anonymous Inner Class:
    A special kind of local inner class without a name.
    Created and instantiated in a single expression.
    Static Nested Class:
    Although nested within an outer class, it is declared static.
    It behaves like a top-level class but is grouped logically with the outer class.
    Note: It is not considered an “inner class” in the strict sense because it cannot access non-static members of the outer class directly.
 */
class Outer {
    private String name;
    Outer(String name) {
        this.name = name;
    }

    class Inner {
        void display() {
            System.out.println("In inner class");
        }
    }

    void createInner() {
        Inner inner = new Inner();
        inner.display();
    }
}


/*
Ananymous inner class
 * Characteristics
    No Name: Defined without a class name.
    Single Use: Generally used for short-term tasks such as event handling or callbacks.
    Can Extend a Class or Implement an Interface:
    You create an anonymous subclass of an existing class or an anonymous implementation of an interface.
    Access to Final/Effectively Final Variables:
    Anonymous classes can access local variables of the enclosing method if they are final or effectively final.
 */

 abstract class Outer1{
    abstract void show();
 }


 /*
  * Combining abstract classes with anonymous inner classes is common when you need a one-off implementation of an abstract class without creating a separate named subclass.

    When to Use:
    When you want to quickly provide an implementation for an abstract class.
    When the implementation is only needed in a local context (such as within a method).
  */
abstract class Calculator {
    abstract int calculate(int x, int y);
}



public class InnerClass {
    public static void main(String[] args) {
        Outer obj1 = new Outer("Hello");
        
        Outer.Inner obj2 = obj1.new Inner();
        obj2.display();

        // why create subclass just for implementing show() of abstract class Outer1
        // instead create anaymous inner class
        // also not stores the class after compiling, thereby saving memory
        Outer1 obj3 = new Outer1() {
            @Override
            void show() {
                System.out.println("In show implementation of Abstract class Outer1");
            }
        };
        obj3.show();

        Calculator addition = new Calculator() {
            @Override
            int calculate(int x, int y) {
                return x + y;
            }
        };

        Calculator multiplication = new Calculator() {
            @Override
            int calculate(int x, int y) {
                return x * y;
            }
        };

        System.out.println(addition.calculate(5, 6));
        System.out.println(multiplication.calculate(4, 5));
    }
    
}
