package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 5: Calculator
 *
 *      Take two numbers from the user, an upper and lower bound. Using a "for-loop", calculate the sum
 *      of numbers from the lower bound to the upper bound. Also, calculate the average of numbers.
 *      Print the results to the console.
 *
 *      For example, if a user enters 1 and 100, the output should be:
 *
 *      The sum is: 5050
 *      The average is: 50.5
 *
 *
 */

public class Exercise_05 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.println("Enter low bound: ");
        Scanner scanner = new Scanner(System.in);
        int low = scanner.nextInt();
        System.out.println("Enter high bound: ");
        int high = scanner.nextInt();
        for (int i = low; i <= high; i++) {
            sum += i;
        }
        System.out.println(sum);
        double amountOfNumbers = high-low+1;
        double average = sum/amountOfNumbers;
        System.out.println(average);
    }
}
