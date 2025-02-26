package coreJava;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

// Serialization (Saving Objects to a File)
// Serialization is the process of converting an object into a byte stream to save it to a file.

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


public class ObjectSerialization {
    public static void main(String[] args) {
        // writing serialized obj into file
        // FileOutputStream fos = null;
        // ObjectOutputStream oos = null;

        // try {
        //     fos = new FileOutputStream("Student.ser"); // Designed for writing binary data (raw bytes) to a file. low level
        //     oos = new ObjectOutputStream(fos);  // uses underlying fos, it acts as a higher-level stream that knows how to serialize objects.

        //     Student s = new Student("Vinay", 21);
        //     oos.writeObject(s);
        //     System.out.println("Object Serialized Successfully.");
        // } catch (IOException  e) {
        //     e.printStackTrace();
        // } finally {
        //     try {
        //         if (oos != null) oos.close(); // Step 12: Closing ObjectOutputStream
        //         if (fos != null) fos.close(); // Step 13: Closing FileOutputStream
        //     } catch (IOException e) {
        //         System.out.println("Error closing streams: " + e.getMessage());
        //     }
        // }

        // retrieving written serialized obj
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("Student.ser");
            ois = new ObjectInputStream(fis);
            Student s = (Student) ois.readObject();
            System.out.println("Deserialized Student: " + s.name + ", Age: " + s.age);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ois != null) ois.close(); // Step 12: Closing ObjectOutputStream
                if (fis != null) fis.close(); // Step 13: Closing FileOutputStream
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
        
    }
}

/*
 * What’s Happening Here?
Creating a FileOutputStream:
    FileOutputStream fos = new FileOutputStream("student.ser");
    Purpose:
        This line creates a FileOutputStream object that is linked to the file named student.ser.
        FileOutputStream is used to write raw bytes to a file.
    What It Does:
        It either creates a new file named student.ser or opens the existing file (overwriting it by default).
Creating an ObjectOutputStream:
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    Purpose:
        The ObjectOutputStream is created by wrapping the FileOutputStream (fos).
        Its job is to convert (serialize) Java objects into a stream of bytes.
    What It Does:
        It uses the underlying FileOutputStream to write the serialized data into the file.
        In other words, it acts as a higher-level stream that knows how to serialize objects.
 */