package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 5:
 *
 *      Demonstrate the use of a wait() and notify()
 */

class WaitNotify {
    public static void main(String[] args) {
        KarateKid kk = new KarateKid();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    kk.waxOn();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    kk.waxOff();
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class KarateKid {
    public synchronized void waxOn() {
        System.out.println("Wax on");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.getLocalizedMessage();
        }
    }

    public synchronized void waxOff() {
        System.out.println("Wax off");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.getLocalizedMessage();
        }
    }
}