package Tutorials;

import java.util.Scanner; 

public class InputExample { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x;
        x = input.nextInt();
        System.out.println(x);
        input.close();
    }
}