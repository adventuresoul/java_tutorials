package Tutorials;

public class TypeConversions {
    public static void main(String[] args) {
        // implicit type conversions -> widening(smaller data types to larger data types)
        // Byte → Short → Int → Long → Float → Double
        int num = 100;
        double num1 = num;
        System.out.println(num1);

        // explicit type casting -> narrowing(larger data types to smaller data types)
        // Double → Float → Long → Int → Short → Byte
        float num2 = 5.6f;
        int num3 = (int)num2;
        System.out.println(num3);

        // string to other types
        String num4 = new String("1");
        Integer num5 = Integer.parseInt(num4);
        System.out.println(num5);
    }
}
