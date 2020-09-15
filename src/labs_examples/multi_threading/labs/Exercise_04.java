package labs_examples.multi_threading.labs;


/**
 * Multithreading Exercise 4:
 *
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 */

class syncController {

    public static int x = 0;
    public static void main(String[] args) {
        //synchronized method

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                alter();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                alter();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(x);

        //--------------------------------------------------------------
        // synchronized block

        Dec dec1 = new Dec();
        BlockThread t3 = new BlockThread(dec1);
        BlockThread t4 = new BlockThread(dec1);
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(x);

    }

    public static synchronized void alter() {
        for (int i = 0; i < 10000; i++) {
            x++;
        }
    }
}

class Dec {
    public void dec() {
        for (int i = 0; i < 1000; i++) {
            syncController.x--;
        }
    }
}

class BlockThread extends Thread {
    Dec dec;
    BlockThread(Dec dec){
        this.dec = dec;
        start();
    }
    public void run() {
        synchronized (dec) {
            dec.dec();
        }
    }
}