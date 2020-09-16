package labs_examples.generics.labs;


/**
 * Generics Exercise 1:
 *
 *      1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2.) Create a few objects of your generic class with different data types to demonstrate it's
 *          dynamic usage.
 */

class Controller {
    public static void main(String[] args) {
        Generics<Double, Integer> gen = new Generics(3.0, 5, "generic 1");
        Generics<Short, String> gen2 = new Generics(45, "this is my data", "generic 2");
        Generics<Integer, Integer> gen3 = new Generics<>(12, 24, "generic 3");

        System.out.println(gen.getData());
        gen.setData(15);
        System.out.println(gen.getData());
    }
}

class Generics<T extends Number, V> {
    private T amount;
    private V data;
    private String name;

    public Generics(T amount, V data, String name){
        this.amount = amount;
        this.data = data;
        this.name = name;
    }

    public T getAmount() {
        return amount;
    }

    public void setAmount(T amount) {
        this.amount = amount;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}