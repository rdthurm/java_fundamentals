package labs_examples.arrays.labs;

import java.util.ArrayList;

/**
 *  Irregular Arrays
 *
 *      Create and populate a 2 dimensional irregular array of size and contents of your choosing. Using a nested
 *      "for-each" loop, iterate and print out each element of the array.
 *
 */

public class Exercise_04 {
    public static void main(String[] args) {
        int[][] wonka = new int[3][5];
        int x = wonka.length;
        for (int i = 0; i < wonka.length; i++){
            for (int j = 0; j < wonka[i].length; j++){
                wonka[i][j] = x;
                x *= wonka.length;
            }
        }
        for (int[] row : wonka) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
