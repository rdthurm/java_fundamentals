package labs_examples.generics.labs;

import java.util.ArrayList;

/**
 * Generics Exercise 2:
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList
 */

class Controller2 {
    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<Double>();
        doubles.add(4.0); doubles.add(5.5); doubles.add(6.67);
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(9); ints.add(18); ints.add(27);
        System.out.println(summer(doubles));
        System.out.println(summer(ints));

    }
    public static <T extends Number> double summer(ArrayList<T> list) {
        double x = 0.0;
        for (T t : list) {
            x += t.doubleValue();
        }
        return x;
    }
}
