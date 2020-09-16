package labs_examples.generics.labs;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers.txt were passed in regardless of their type.
 *
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes

 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */

class Controller3 {
    public static void main(String[] args) {
        System.out.println(methodOne(5, 7.8));

        ArrayList<String> palindromes = new ArrayList<>();
        palindromes.add("okay"); palindromes.add("hannah"); palindromes.add("asdfdsa"); palindromes.add("siris");
        System.out.println(palindromes(palindromes) + " palindromes.");

        Character[] chars = {'a', 'b', 'c', 'd'};
        exchange(chars, 0, chars.length-1);
        for (Character c : chars){
            System.out.println(c.toString());
        }

        Double[] doubles = {4.2, 5.7, 8.9, 20.1, 9.8, 100.0};
        System.out.println(largestElement(doubles, 0, 4));
    }

    public static <T extends Number, V extends Number> double methodOne(T t, V v) {
        return t.doubleValue() + v.doubleValue();
    }

    public static int palindromes(ArrayList<String> list) {
        int counter = 0;
        boolean isPalindrome;
        for (String s : list) {
            isPalindrome = true;
            for (int i = 0; i < s.length(); i++) {
                if (! (s.charAt(i) == s.charAt(s.length()-(i+1)))) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) counter++;
        }
        return counter;
    }

    public static <E> void exchange(E[] array, int index1, int index2) {
        E placeholder = array[index1];
        array[index1] = array[index2];
        array[index2] = placeholder;
    }

    public static <E extends Comparable> E largestElement(E[] array, int start, int end) {
        E max = array[start];
        for (int i = (start + 1); i <= end; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}