package Tutorials;

//A class declared as final cannot be subclassed.
final class Base {
    public final int age;  // cannot be changed once initialized

    // public static final int age; => constant
    // static {age = 18;}
    Base(int age) {
        this.age = age;
    }

    // A method declared as final cannot be overridden by any subclasses.
    public final void display() {
        System.out.println("Hello world!");
    }

    //When parameters are declared as final, their value cannot be modified within the method.
    public void process(final String name) {
        System.out.println("Hello" + name);
    }
}

public class Final {
    
}
