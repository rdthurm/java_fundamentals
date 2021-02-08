package labs_examples.lambdas.labs;

import java.util.function.*;
import java.util.jar.JarOutputStream;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */

class Controller2 {
    public static void main(String[] args) {
        // 1
        BiFunction<Double, Double, Boolean> goesInto = (t, u) -> {
            if (u % t == 0) {
                return true;
            } else return false;
        };
        System.out.println(goesInto.apply(2.5, 5.0));
        // 2
        DoubleBinaryOperator doubles = (x, y) -> (x / 2) * y;
        System.out.println(doubles.applyAsDouble(9.5, 3.0));
        //3
        Consumer<String> print = (s -> System.out.println(s + " - printed with Consumer."));
        print.accept("Omnom mindless consumer");
        //4
        LongPredicate lp = (value -> {
            if (value > 2000) return true;
            else return false;
        });
        System.out.println("Long value test: " + lp.test(580));
        //5
        ToDoubleFunction<String> toDouble = (value -> {
            double i = value.length();
            return i / 2;
        });
        System.out.println(toDouble.applyAsDouble("supercalifragilisticexpialedocious!"));
        //6
        Predicate<Integer> multipleOf42 = (t -> {
            if (t % 42 == 0) return true;
            else return false;
        });
        System.out.println(multipleOf42.test(126));
        //7
        Supplier<Double> numOneToOneHundred = () -> Math.random()*100;
        System.out.println(numOneToOneHundred.get());
        //8
        Function<Integer, Integer> cube = (t) -> t * t * t;
        System.out.println(cube.apply(3));
        //9
        IntUnaryOperator alterValue = x -> ((x * 3) - 2) * 3;
        System.out.println(alterValue.applyAsInt(100));
        //10
        ToIntBiFunction<String, String> difference = (t, v) -> Math.abs(t.length() - v.length());
        System.out.println(difference.applyAsInt("Bongo", "Bingobango"));

    }
}