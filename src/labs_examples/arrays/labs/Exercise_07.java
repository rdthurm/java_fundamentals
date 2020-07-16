package labs_examples.arrays.labs;

import java.util.ArrayList;

/**
 *  ArrayLists
 *
 *      Please demonstrate how to create an ArrayList, populate an array list, access elements within an ArrayList.
 *      Also take a moment to explore the many methods that are available to you when you use an ArrayList. By simply
 *      typing the dot operator (".") after the ArrayList object that you create. You should see a menu pop up that
 *      shows a list of methods.
 *
 */
public class Exercise_07 {
    public static void main(String[] args) {
        ArrayList<String> spheres = new ArrayList<>();
        spheres.add("basketball");
        spheres.add("globe");
        spheres.add("bubble");

        if (spheres.size() < 4){
            spheres.add("bb gun bullet");
            System.out.println(spheres.get(spheres.size() - 1));
        }
        String x = spheres.get(0);
        System.out.println(x);

        if (!spheres.isEmpty() && spheres.contains("globe")) {
            System.out.println("The earth is round.");
        }
    }

}
