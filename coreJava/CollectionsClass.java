package coreJava;

import java.util.*;


class Employee1 implements Comparable<Employee1> {
    String name;
    int salary;
    public Employee1(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    
    @Override
    public int compareTo(Employee1 that) {
        if(this.salary > that.salary) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Employee{Name=" + name + ", salary='" + salary + "'}";
    }
}

class Employee2 {
    String name;
    int salary;
    public Employee2(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    

    @Override
    public String toString() {
        return "Employee{Name=" + name + ", salary='" + salary + "'}";
    }
}




public class CollectionsClass {
    public static void main(String[] args) {
        // with compareTo method implemented
        List<Employee1> employees = new ArrayList<>();
        employees.add(new Employee1("vinay", 1000));
        employees.add(new Employee1("vivek", 1200));
        employees.add(new Employee1("vighnesh", 1300));
        Collections.sort(employees); // Uses compareTo() method
        System.out.println(employees);

        // using custom comparator
        List<Employee2> employees1 = new ArrayList<>();
        employees1.add(new Employee2("Vinay", 1000));
        employees1.add(new Employee2("vivek", 1200));
        employees1.add(new Employee2("vighnesh", 1300));

        // Comparator<Employee2> com = new Comparator<Employee2>() {
        //     @Override
        //     public int compare(Employee2 obj1, Employee2 obj2) {
        //         return obj1.salary > obj2.salary ? -1: 1;
        //     }
        // };
        // using lambda exp
        Comparator<Employee2> com = (Employee2 obj1, Employee2 obj2) -> {
            return obj1.salary > obj2.salary ? -1: 1;
        };

        Collections.sort(employees1, com);
        System.out.println(employees1);
    }
}
