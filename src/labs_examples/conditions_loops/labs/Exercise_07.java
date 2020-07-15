package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 7: First vowel
 *
 *      Take in a word from the user and using a "while" loop, find the first vowel in the word.
 *      Once you find the vowel, print out the word and the first vowel.
 *
 *      Hints:
 *          - there are a few helpful methods in the String class called length(), charAt() and indexOf()
 *          - you'll likely want to use a String that contains all the vowels:
 *              - ie: String vowels = "aeiou";
 *
 */

public class Exercise_07 {
    public static void main(String[] args) {
        String vowels = "aeiou";
        System.out.println("enter a word: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int counter = 0;
        String firstVowel = "";
        while (counter < word.length()){
            if (vowels.contains(Character.toString(word.charAt(counter)))) {
                firstVowel = Character.toString(word.charAt(counter));
                break;
            }
            counter++;
        }

        System.out.println(word + " " + firstVowel);
    }
}
