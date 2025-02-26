package Tutorials;


public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        System.out.println(numbers[0]); // accessing elt

        // normal for loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // enhanced for loop
        for (int num : numbers) {
            System.out.println(num);
        }
        
        // multidimensional arrays
        int[][] matrix1 = new int[3][3];
        System.out.println(matrix1);

        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(matrix2);

        // jagged arrays
        int[][] matrix3 = new int[3][];
        int[] row1 = new int[2];
        int[] row2 = new int[4];
        int[] row3 = new int[3];

        matrix3[0] = row1;
        matrix3[1] = row2;
        matrix3[2] = row3;

        // Assigning values
        matrix3[0][0] = 1;
        matrix3[0][1] = 2;

        matrix3[1][0] = 3;
        matrix3[1][1] = 4;
        matrix3[1][2] = 5;
        matrix3[1][3] = 6;

        matrix3[2][0] = 7;
        matrix3[2][1] = 8;
        matrix3[2][2] = 9;

        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
