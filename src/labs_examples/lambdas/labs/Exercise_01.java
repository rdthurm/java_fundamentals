package labs_examples.lambdas.labs;

import java.io.SequenceInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.*;

/**
 * Lambdas Exercise 1:
 *
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 *          value of the same type as the parameter
 *      4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 *          value
 *      6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 *
 *
 *
 *
 */

@FunctionalInterface
interface InterfaceOne {
    public void method();
}

@FunctionalInterface
interface InterfaceTwo {
    public int method(int x);
}

@FunctionalInterface
interface InterfaceThree {
    public int method(String x, String y);
}

class Controller {
    public static void main(String[] args) {
        InterfaceOne oneLambda = () -> System.out.println("InterfaceOne Lambda.");
        InterfaceOne oneAIC = new InterfaceOne() {
            @Override
            public void method() {
                System.out.println("InterfaceOne AIC.");
            }
        };

        InterfaceTwo twoLambda = (x) -> x * x;
        InterfaceTwo twoAIC = new InterfaceTwo() {
            @Override
            public int method(int x) {
                return (x/2) + 7;
            }
        };

        InterfaceThree threeLambda = (x, y) -> x.length() + y.length();
        InterfaceThree threeAIC = new InterfaceThree() {
            @Override
            public int method(String x, String y) {
                return x.length() - y.length();
            }
        };

        DoubleFunction<Double> radius = (circumference -> circumference/Math.PI);
        System.out.println(radius.apply(1000));
        IntToDoubleFunction heightInchesToFeet = (height -> (double) height/12);
        System.out.println(heightInchesToFeet.applyAsDouble(68));
    }
}