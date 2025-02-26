package coreJava;

import java.util.Scanner; 

public class Strings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Strings(String class) are immutable in java
        // to make it mutable and memory efficient by not creating new obj everytime for modifying,
        // we can make use of StringBuffer and StringBuilder
        String s = "Hello";
        s = s + " World"; // Creates a new object instead of modifying the existing one
        System.out.println(s);

        // StringBuffer
        // ✅ Mutable (modifiable without creating new objects)
        // ✅ Thread-safe (synchronized methods)
        // ✅ Slower than StringBuilder due to synchronization overhead
        String str = scan.next();
        System.out.println(str);

        StringBuffer str1 = new StringBuffer(str);
        str1.append(" World!");
        str1.insert(12, " Java");
        str1.delete(12, 17);
        str1.reverse();
        System.out.println(str1);
        
        // StringBuilder
        // Key Features:
        // ✅ Mutable (modifications do not create new objects)
        // ✅ Not thread-safe (no synchronization)
        // ✅ Faster than StringBuffer due to lack of synchronization
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" World"); // Append operation
        System.out.println(sb); // Output: Hello World

        sb.insert(5, " Java"); // Insert operation
        System.out.println(sb); // Output: Hello Java World

        sb.replace(6, 10, "C++"); // Replace operation
        System.out.println(sb); // Output: Hello C++ World

        sb.delete(6, 10); // Delete operation
        System.out.println(sb); // Output: Hello  World

        sb.reverse(); // Reverse operation
        System.out.println(sb); // Output: dlroW  olleH
        

        scan.close();
    }
}
