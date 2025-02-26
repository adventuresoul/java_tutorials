package Tutorials;

public class WrapperClass {
    public static void main(String[] args) {
        // java is 99% oop lang, but to make even primitives to objs, we can make use of wrapper class
        // why?, objects are passed by reference, primitives by value, although there is no concept of pointers in java

        // autoboxing (primitive to wrapper)
        int num = 6;
        //Integer num1 = new Integer(num);
        Integer num1 = num;
        System.out.println(num1);

        // unboxing (wrapper class to primitive)
        //Integer obj = new Integer(7);
        Integer obj = 7;
        int num2 = obj;
        System.out.println(num2);

        //parseXxx() → Convert String to Primitive
        String str = "100";
        int num3 = Integer.parseInt(str);
        System.out.println(num3);

        // valueOf() → Convert String to Wrapper Object
        Integer obj1 = Integer.valueOf("100");
        System.out.println(obj1);

        System.out.println(Math.max(num2, num3));
    }
}
