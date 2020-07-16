package labs_examples.arrays.labs;

import java.util.Scanner;

/**
 * Arrays calculator
 *
 *      Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 *      calculate the sum of all of the numbers in the array as well as the average.
 *
 *      Print the results to the console.
 *
 */

public class Exercise_01 {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("enter a number: ");
            num = scanner.nextInt();
            intArray[i] = num;
        }
        int sum = 0;
        for (int i = 0; i < intArray.length; i++){
            sum += intArray[i];
        }

        int average = sum/intArray.length;
        System.out.println("Sum is " + sum + " and average is " + average);

    }
}