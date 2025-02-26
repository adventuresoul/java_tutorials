package Tutorials;

import java.util.List;

/*
 * Generics in Java allow us to create classes, interfaces, and methods with type parameters.
 * This provides type safety and code reusability while working with different data types.
 * ✅ Advantages of Generics
    Type Safety: Ensures compile-time type checking, reducing runtime errors.
    Code Reusability: We can write a single generic class/method that works with multiple data types.
    Elimination of Type Casting: No need for explicit type conversion.
    Better Performance: Reduces the overhead of typecasting and improves efficiency.
*/

//A Generic Class can work with multiple data types by using type parameters.
class Box<T> {
    private T value;

    public void setValue(T val) {   //Your class Box<T> is already generic, meaning T is defined at the class level.
        this.value = val;
    }

    public T getValue() {   //All instance methods can directly use T without needing to declare <T> again.
        return this.value;
    }

    public static <T> void printArray(T[] array) { //Since static methods do not belong to an instance, they cannot use the class's type parameter (T).
        for(T element: array) {                     //cannot access T from Box<T>
            System.out.println(element);
        }
        System.out.println();
    }
}

// Generic interfaces
interface GenereicInterfaace<T> {
    T performOperation(T a, T b);
}

class Addition implements GenereicInterfaace<Integer> {
    @Override
    public Integer performOperation(Integer a, Integer b) {
        return a + b;
    }
}

// Bounded Type parameters
// We can restrict the type parameter using extends for a superclass or interface.

class Calculator<T extends Number> {    // only works for (subclass of Number)Integer, Float, Double not Strings
    private T num1, num2;

    Calculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double sum() {
        return num1.doubleValue() + num2.doubleValue();
    }
}

//Wildcards (?) in Java Generics allow flexibility when dealing with generic types, 
//especially when you don’t know or don’t want to specify the exact type parameter.
//Types of Wildcards:
// Unbounded Wildcard (<?>) → Any type allowed.
// Upper Bounded Wildcard (<? extends T>) → Type must be subclass of T.
// Lower Bounded Wildcard (<? super T>) → Type must be superclass of T.

// Need for wildcard
class DataProcessorGeneric<T extends Number> {
    public void printNumbers(List<T> list) {
        for (T num: list) {
            System.out.println(num);
        }
    }
}
// public class Main {
//     public static void main(String[] args) {
//         DataProcessor<Integer> intProcessor = new DataProcessor<>();
//         DataProcessor<Double> doubleProcessor = new DataProcessor<>();

//         List<Integer> intList = Arrays.asList(1, 2, 3);
//         List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

//         intProcessor.printNumbers(intList); // ✅ Works
//         doubleProcessor.printNumbers(doubleList); // ✅ Works

//         // ❌ But we CAN’T pass both lists to the same method!
//     }
// }

// with wildcard
class DataProcessorWildCard {
    public void printNumbers(List<? extends Number> list) {
        for(Number num: list) {
            System.out.println(num);
        }
    }
}
// a single DataProcessorWildCard obj can process two different kinds of lists
// class Main {
//     public static void main(String[] args) {
//         List<Integer> intList = Arrays.asList(1, 2, 3);
//         List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        
//         DataProcessorWildCard obj = new DataProcessorWildCard();
//         obj.printNumbers(intList);
//         obj.printNumbers(doubleList);
//     }
// }


//Type Erasure in Generics
// Java uses Type Erasure to remove generic type information at runtime.
// This ensures backward compatibility with older Java versions.

public class GenericClasses{
    public static void main(String[] args) {
        Box<String> obj1 = new Box<String>();
        obj1.setValue("Hello");
        System.out.println(obj1.getValue());
        
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C"};

        Box.printArray(intArray); // Output: 1 2 3 4 5
        Box.printArray(strArray); // Output: A B C
    }
}
