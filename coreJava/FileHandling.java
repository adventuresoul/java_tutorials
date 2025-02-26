package Tutorials;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/*
File handling in Java is used to read, write, update, and delete files from the file system. 
Java provides several classes and methods for file operations in the java.io, java.nio, and java.nio.file packages.
 */

public class FileHandling {
    public static void main(String[] args) {
        // creating new file
        File file = new File("sample.txt");

        try {
            if(file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            }
            else{
                System.out.println("File already exists.");
            }  
        } catch (IOException e) {
            e.printStackTrace();
        } 

        // writing to a file
        
        try(FileWriter writer = new FileWriter("sample.txt");) {
            writer.write("Hello world");
            System.out.println("Data written to file");
        } catch (IOException e) {
            e.printStackTrace();
        } 

        // reading from file
        try(BufferedReader bf = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
