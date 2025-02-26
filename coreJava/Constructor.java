package coreJava;

// import java.lang.Math;

class Car {
    String brand;
    int speed;

    // Default constructor: Uses constructor chaining to call the parameterized constructor
    Car() {
        this("Unknown", 0);
        System.out.println("Default constructor called.");
    }

    // Parameterized constructor: Initializes brand and speed
    Car(String brand) {
        this(brand, 0);
        System.out.println("Parameterized constructor (brand only) called.");
    }

    // Parameterized constructor: Initializes brand and speed
    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
        System.out.println("Parameterized constructor (brand and speed) called.");
    }

    // copy constructor
    Car(Car other) {
        this.brand = other.brand;
        this.speed = other.speed;
        System.out.println("Copy constructor called.");
    }

    // Method to display the details of the car
    void display() {
        System.out.println("Brand: " + brand + ", Speed: " + speed + " km/h");
    }
}

// private constructors
// Purpose of the Private Constructor
// *Control Instantiation:
// The private constructor prevents external classes from creating new instances of the class using the new keyword.

// *Singleton Pattern:
// It is primarily used in the Singleton design pattern, where only one instance of a class should exist. 
// The instance is created once (lazily, as shown) and then reused.

// *Utility Classes:
// It is also used in classes that only contain static methods and fields (such as java.lang.Math).
// By making the constructor private, you prevent the accidental creation of instances.

class Singleton {
    // static variable that holds one instance of the class
    private static Singleton instance;

    // Private constructor prevents instantiation from outside
    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    public static Singleton createInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from the Singleton!");
    }
}

public class Constructor {
    public static void main(String[] args) {
        //A constructor in Java is a special method used to initialize objects. 
        // It is called when an instance of a class is created

        // some important points
        // Has the same name as the class.
        // Does not have a return type (not even void).
        // Is automatically invoked when an object is created.
        // Can be overloaded.
        // If no constructor is explicitly defined, Java provides a default constructor.

        System.out.println("Creating car1 using default constructor:");
        Car car1 = new Car();       // Default constructor is called

        System.out.println("\nCreating car2 using parameterized constructor (brand only):");
        Car car2 = new Car("Honda"); // Calls the parameterized constructor with one argument

        System.out.println("\nCreating car3 using parameterized constructor (brand and speed):");
        Car car3 = new Car("BMW", 200); // Calls the parameterized constructor with two arguments

        System.out.println("\nCreating car4 using copy constructor from car3:");
        Car car4 = new Car(car3);   // Copy constructor is called

        System.out.println("\nDisplaying details of all cars:");
        car1.display();
        car2.display();
        car3.display();
        car4.display();

        // System.out.println(Math.max(5, 6));
        // Attempt to create multiple references to the Singleton instance
        Singleton obj1 = Singleton.createInstance();
        Singleton obj2 = Singleton.createInstance();

        // Both obj1 and obj2 refer to the same instance
        obj1.showMessage();
        obj2.showMessage();
    }
}
