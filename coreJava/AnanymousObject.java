package Tutorials;

// ✅ Saves memory by not storing unnecessary references
// ✅ Useful for one-time use objects
// ✅ Reduces code length and improves readability
// ✅ Commonly used in method arguments

class Example {
    void show() {
        System.out.println("Anonymous Object Called");
    }

    // Method that returns an anonymous object
    static Example getObject() {
        return new Example();
    }
}

public class AnanymousObject {
    //An anonymous object in Java is an object that is instantiated but does not have a reference variable.
    // Instead of storing the object in a variable, it is used immediately and then discarded.
    public static void main(String[] args) {
        new Example().show();
    }
}
