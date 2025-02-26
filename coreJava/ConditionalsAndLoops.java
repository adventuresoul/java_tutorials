package coreJava;

public class ConditionalsAndLoops {
    // never use switch in production code
    public static void main(String[] args) {
        int a = 3;
        if (a < 0) {

        }
        else if (a == 0) {

        }
        else {

        }

        int i = 0;
        while (i != 100) {
            i += 1;
        }

        for (int j = 0; j < args.length; j++) {
            System.out.println(i);
        }

        do {  
            System.out.println(i);  
            i++;
        } while (i < 10);

        // enhanced for used with array(iterables)

        // ternary
        int num = 17;
        boolean res = num >> 1 == 1 ? true: false;
        System.out.println(res);
    }
}
