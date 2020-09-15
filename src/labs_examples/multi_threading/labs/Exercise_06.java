package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 6:
 *
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

class CountProgram {
    public static int count = 0;
    public static void main(String[] args) {
        Counter thread1 = new Counter("t1");
        Counter thread2 = new Counter("t2");
        Counter thread3 = new Counter("t3");
    }

    public static synchronized void inc() {
        if (count < 100) {
            count++;
            System.out.println(count);
        }
    }
}

class Counter implements Runnable {
    Thread thread;

    public Counter(String name) {
        this.thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        while (CountProgram.count < 100) {
            System.out.println("-" + this.thread.getName() + "-");
            CountProgram.inc();
        }
    }
}