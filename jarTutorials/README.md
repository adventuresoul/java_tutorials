# JAR Tutorials

This is a simple Java project demonstrating how to compile Java files, create a JAR file, and run it.

## What is a JAR File?
A JAR (Java Archive) file is a package format used to bundle multiple Java class files and their associated resources (such as images and configuration files) into a single compressed file. It helps in distributing Java applications more efficiently and can be executed directly if it contains a `Main-Class` entry in the manifest file.

## Project Structure
```
jarTutorials/
│── src/
│   ├── com/
│   │   ├── example/
│   │   │   ├── Main.java
│── manifest.txt
│── out/ (Generated after compilation)
│── myproject.jar (Generated JAR file)
```

## Getting Started

### 1. Compile the Java Files
Run the following command to compile the Java files:
```sh
javac -d out src/com/example/Main.java
```
This creates a `Main.class` file inside the `out/com/example/` directory.

### 2. Create a Manifest File
Ensure the `manifest.txt` file contains:
```
Main-Class: com.example.Main
```
*(Make sure there is an empty newline at the end of the file.)*

### 3. Create the JAR File
Run:
```sh
jar cfm myproject.jar manifest.txt -C out .
```
This packages all compiled files into `myproject.jar`.

### 4. Run the JAR File
Execute:
```sh
java -jar myproject.jar
```
Expected output:
```
Hello, JAR!
```

## Checking JAR Contents
To verify what’s inside the JAR:
```sh
jar tf myproject.jar
```
