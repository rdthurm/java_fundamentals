package labs_examples.arrays.labs;

import java.util.ArrayList;

/**
 *  Traversing Arrays Backwards
 *
 *      Please create and populate an array of your choosing. Then, please demonstrate how to print out every other
 *      element in the array in reverse order.
 *
 */

public class Exercise_05 {
    public static void main(String[] args) {
        int[] numbers = new int[30];
        int x = 1;
        for (int i : numbers){
            i = x;
            x++;
        }
        for (int i = numbers.length; i > 0; i-=3){
            System.out.println(i);
        }
    }
}
