package coreJava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
;

/*
The forEach method in Java is a default method in Iterable and Stream that iterates over elements.
It accepts a Consumer<T> functional interface, which defines an operation that takes an argument but returns no result.
 */

/*
Java Streams API (introduced in Java 8) provides a powerful way to process collections of data using a functional-style approach.
Streams allow filtering, mapping, reducing, sorting, and other operations without modifying the original data.
✅ Key Features:
    Declarative (Functional) Programming: Avoids explicit loops.
    Lazy Evaluation: Intermediate operations are executed only when a terminal operation is invoked.
    Parallel Execution: Supports parallelism for better performance.
    No Data Storage: Streams do not modify the original collection; they work on a pipeline.
*/


public class StreamTutorial {
    public static void main(String[] args) {
        // forEach
        List<String> names = new ArrayList<>();
        names.add("Vinay");
        names.add("Vivek");
        names.add("Vighnesh");

        // Consumer<String> s = new Consumer<String>() {
        //     @Override
        //     public void accept(String name) {
        //         System.out.println(name);
        //     }
        // };

        // // forEach method accepts Consumer<> obj
        // names.forEach(s);
        //

        // using lambda exp
        names.forEach((String name) -> {
            System.out.println(name);
        });


        // Streams 
        List<Integer> l1 = new ArrayList<>();
        l1.add(7);
        l1.add(8);
        l1.add(13);
        l1.add(5);
        l1.add(62);
        l1.add(79);
        l1.add(14);
        l1.add(36);
        l1.add(64);
        // streams can be consumed only once, build stream on top of an sequenced collection etc 
        Stream<Integer> s1 = l1.stream();
        
        // operations -> map, filter, reduce, sorted

        // filter method (ex: filter out all even numbers)
        // Predicate<Integer> p = new Predicate<Integer>() {
        //     @Override
        //     public boolean test(Integer n) {
        //         return n%2==0;
        //     }
        // };
        // Stream<Integer> s2 = s1.filter(p);
        // s2.forEach((n) -> System.out.println(n));
        //Stream<Integer> s2 = s1.filter((n) -> n%2==0);
        //s2.forEach((n) -> System.out.println(n));

        // map method
        // Function<Integer, Integer> f1 = new Function<Integer,Integer>() {
        //     @Override
        //     public Integer apply(Integer n) {
        //         return n * 2;
        //     }
        // };
        // Stream<Integer> s3 = s2.map(f1);
        //Stream<Integer> s3 = s2.map(n -> n * 2);
        //s3.forEach((n) -> System.out.println(n));

        // sorted method
        //Stream<Integer> s4 = s3.sorted();   // there is a method overloading for custom comparator
        //s4.forEach(n -> System.out.println(n));


        // reduce
        //int sum = s4.reduce(0, (c, e) -> c+e);
        //System.out.println(sum);

        // Alternatively
        int sum = s1.filter(n -> n%2==0)
                .map(n -> n*2)
                .reduce(0, (c, e) -> c+e);
        System.out.println(sum);
        
    }
    
}
