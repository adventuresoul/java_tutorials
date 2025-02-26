package coreJava;
/*
 Exception Handling in Java
Exception handling is a powerful mechanism that handles runtime errors, 
allowing a program to continue its execution rather than crashing abruptly. 
In Java, exceptions are objects that describe an error condition that has occurred during program execution.
 */

/*
Types of Exceptions
a) Checked Exceptions (Compile-time)
    Exceptions that the compiler forces you to handle.
    Must be caught using try-catch or declared using throws.
    Examples:
        IOException
        SQLException
        InterruptedException
b) Unchecked Exceptions (Runtime)
    Exceptions that occur during runtime.
    The compiler does not force handling, but it's recommended.
    Examples:
        NullPointerException
        ArithmeticException
        ArrayIndexOutOfBoundsException
        IllegalArgumentException
c) Errors
    Serious problems usually caused by system failures.
    Cannot be handled by the application.
    Examples:
        OutOfMemoryError
        StackOverflowError


                Throwable
                 /      \
          Exception      Error
         /        \
Checked      RuntimeException
Exceptions     (Unchecked)
 */

/*
Keywords in Exception Handling
a) try
    Contains the code that might throw an exception.
b) catch
    Used to handle exceptions thrown in the try block.
    A single try block can have multiple catch blocks.
c) finally
    Always executes whether an exception is thrown or not.
    Used for cleanup operations (closing resources like files, DB connections).
d) throw
    Used to explicitly throw an exception.
e) throws
    Used in method signatures to indicate that a method may throw an exception.
 */

 // examples
class ExceptionExample {
    public void compute() {
        try {
            int result = 10 / 0; // Throws ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("This will always execute.");
        }
    }
}

// rethrowing an execption
class RethrowExample {
    static void process() throws ArithmeticException {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Handling exception in process(), rethrowing...");
            throw e; // Rethrowing exception
        }
    }

    public void mainProcess() {
        try {
            process();
        } catch (ArithmeticException e) {
            System.out.println("Caught in main: " + e);
        }
    }
}

// custom exception
class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

class CustomCheckedException {
    public static void checkAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("Age must be 18 or older.");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (AgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

/*
Parent-Child Relationship in Exception Handling
    Order of Exception Handling
    A child class exception must be caught before its parent exception.
    If the parent is caught first, then the child exception will never be reached, causing a compilation error.
 
    try {
        int a = 10 / 0;
    } catch (Exception e) { // Parent Exception
        System.out.println("General Exception caught.");
    } catch (ArithmeticException e) { // Child Exception
        System.out.println("Arithmetic Exception caught."); // Unreachable code error
    }

    correctd code:
    try {
        int a = 10 / 0;
    } catch (ArithmeticException e) { // Child Exception
        System.out.println("Arithmetic Exception caught.");
    } catch (Exception e) { // Parent Exception
        System.out.println("General Exception caught.");
    }
*/

/*
Multiple Catch Blocks
    You can have multiple catch blocks for handling different exceptions.
        try {
            int[] arr = new int[5];
            arr[10] = 50; // This will cause ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught.");
        } catch (Exception e) {
            System.out.println("General Exception caught.");
        }
*/

/*
Try-With-Resources (Java 7+)
    Java introduced try-with-resources to automatically close resources that implement the AutoCloseable interface.
    public class TryWithResourcesExample {
        public static void main(String[] args) {
            try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
                System.out.println(br.readLine());
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
    
    or 
    public class TryWithResourcesExample {
        public static void main(String[] args) {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"))
            try {
                System.out.println(br.readLine());
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
            finally {
                br.close();
            }
        }
    }

 */
public class Exceptions {
    
}
