package coreJava;

import java.util.*;

//The Collection API consists of several interfaces and classes that provide ready-made implementations of commonly used data structures. 
//It resides in the java.util package.

// Hierarchy
// Iterable(interface) -> Collection(interface) -> [List(interface), Queue(interface), Set(interface)]
//                     -> Set(interface)
// Map -> SortedMap(interface)

// Collection implementations
// List(interface) -> ArrayList(class), LinkedList(class), Vector(class)
// Queue(interface) -> PriorityQueue(class)
//                  -> Deque(interface) -> ArrayDeque(class, extends LinkedList, implements Queue)
// Set(interface) -> HashSet, LinkedHashSet
//                -> SortedSet(interface) -> TreeSet(class)

// Map implementations
// SortedMap(interface) -> TreeMap(class)
// Map -> HashTable(class), LinkedHashMap(class), HashMap(class)

public class Collection {
    public static void main(String[] args) {
        // List interface implementations
        List<String> l1 = new ArrayList<>();
        l1.add("Hello");
        l1.add("world");
        System.out.println(l1);
        
        List<Integer> l2 = new LinkedList<>();
        l2.add(7);
        l2.add(8);
        System.out.println(l2);

        List<Integer> l3 = new Vector<>();
        l3.add(8);
        l3.add(9);
        System.out.println(l3);

        List<String> l4 = new Stack<>();
        l4.add("world");
        l4.add("Hi");
        System.out.println(l4);

        // Set interface implementations
        Set<Integer> s1 = new HashSet<>();  // unordered
        s1.add(5);
        s1.add(6);
        s1.add(7);
        s1.add(2);
        s1.add(6);
        System.out.println(s1);

        Set<Integer> s2 = new LinkedHashSet<>();    // ordered
        s2.add(3);
        s2.add(1);
        s2.add(2);
        System.out.println(s2); // (Maintains insertion order)

        Set<String> s3 = new TreeSet<>(); // sorted implementation based on red-black tree
        s3.add("Banana");
        s3.add("Apple");
        s3.add("Cherry");
        System.out.println(s3); // Output: [Apple, Banana, Cherry] (Sorted)

        // Maps interface
        // HashMap
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("Vinay", 121);
        m1.put("Shashank", 100);
        m1.put("Vivek", 122);
        System.out.println(m1.get("Vinay"));
        System.out.println(m1);

        // LinkedHashMap, ordered version of HashMap
        Map<String, Integer> m2 = new LinkedHashMap<>();
        m2.put("Banana", 2);
        m2.put("Apple", 3);
        m2.put("Cherry", 1);
        System.out.println(m2); // Output: {Banana=2, Apple=3, Cherry=1} (Insertion order maintained)

        // TreeMap, sorted map implementation using a Red-Black tree.
        Map<String, Integer> m3 = new TreeMap<>();
        m3.put("Banana", 2);
        m3.put("Apple", 3);
        m3.put("Cherry", 1);
        System.out.println(m3); // Output: {Apple=3, Banana=2, Cherry=1} (Sorted order)

        // HashTable, legacy synchronized implementation of Map. Does NOT allow null keys or values.
        Map<Integer, String> m4 = new Hashtable<>();
        m4.put(1, "One");
        m4.put(2, "Two");
        System.out.println(m4); // Output: {1=One, 2=Two}
        
    }
}
