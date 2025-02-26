package Tutorials;

class Person {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}

public class getterSetter {
    public static void main(String[] args) {
        // Getters and setters are methods used to access and modify private fields of a
        // class. They provide encapsulation,
        // allowing controlled access to data while keeping it hidden from direct
        // modification.

    }
}
