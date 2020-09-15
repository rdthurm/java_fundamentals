package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 2:
 *
 *      Create an application that creates a Thread using the Thread class
 */

class Controller2 {
    public static void main(String[] args) {

        exThread ex0 = new exThread("ex0");
        exThread ex1 = new exThread("ex1");
        ex1.setPriority(10);
        exThread ex2 = new exThread("ex2");
    }
}

class exThread extends Thread {
    exThread(String name){
        super(name);
        start();
    }

    @Override
    public void run(){
        try {
            System.out.println(getName() + "\\--------/");
            Thread.sleep(500);
            System.out.println(getName() + "-\\------/-");
            Thread.sleep(500);
            System.out.println(getName() + "--\\----/--");
            Thread.sleep(500);
            System.out.println(getName() + "---\\--/---");
            Thread.sleep(500);
            System.out.println(getName() + "----\\/----");
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.getLocalizedMessage();
        }
    }

}