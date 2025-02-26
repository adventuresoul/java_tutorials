package Tutorials;

// The Object class is the root class of all classes in Java. 
//It provides several fundamental methods that every Java object inherits, including

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    // Overriding equals() for logical equality based on name and age
    @Override
    public boolean equals(Object obj) {
        if (this ==  obj) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        
        //Person p = new Object();  // ❌ Not allowed, Object is not necessarily a Person
        // we have already checked that obj is indeed a person
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    // Overriding hashCode() when equals() is overridden (see below)
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age);   
    }

    // overriding toString method, which basically a representation
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    } 
}


public class ObjectClass {
    public static void main(String[] args) {
        Person p1 = new Person("vinay", 21);
        Person p2 = new Person("vinay", 21);
        System.out.println(p1.equals(p2));
        System.out.println(p1);
    }
}
