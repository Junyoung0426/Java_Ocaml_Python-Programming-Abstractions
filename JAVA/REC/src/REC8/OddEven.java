package REC8;

/**
 * @author ritwikbanerjee
 * @since Apr 2022
 */
public class OddEven {
    public static final int MAX = 10;
    public static final Object Lock = new Object();

    public static class EvenThread implements Runnable {
        public void run() {

            for (int i = 0; i <= MAX; i = i + 2) {

                System.out.println("Even Thread Value:" + i);
                synchronized (Lock) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }
    }

    public static class OddThread implements Runnable {
        public void run() {

            for (int i = 1; i <= MAX; i = i + 2) {

                System.out.println("Odd Thread Value:" + i);
                synchronized (Lock) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }
    }

    //    public class MultiThreading2 {
    public static void main(String[] args) {
        EvenThread et = new EvenThread();
        OddThread ot = new OddThread();
        Thread t1 = new Thread(et);
        Thread t2 = new Thread(ot);
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println("Main Thread Value:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}