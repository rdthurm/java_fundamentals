package labs_examples.multi_threading.labs;

import java.util.concurrent.TimeUnit;

/**
 * Multithreading Exercise 1:
 *
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 */

class Controller{
    public static void main(String[] args) {
        // Exercise 1
        Thread1 thrdA = new Thread1();
        thrdA.run();
        Thread1 thrdB = new Thread1("thrdB");

    }
}

class Thread1 implements Runnable {
    Thread thread;

    public Thread1(){
    }

    public Thread1(String name){
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run(){
        System.out.println("----/\\----");
        System.out.println("---/--\\---");
        System.out.println("--/----\\--");
        System.out.println("-/------\\-");
        System.out.println("/--------\\");
    }
}