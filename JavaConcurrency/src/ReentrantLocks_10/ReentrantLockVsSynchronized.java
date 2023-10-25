package ReentrantLocks_10;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to show, how to use ReentrantLock in Java.
 * Reentrant lock is an alternative way of locking
 * apart from implicit locking provided by synchronized keyword in Java.
 *
 * @author  Javin Paul
 */
public class ReentrantLockVsSynchronized {

    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;
    private int count2 = 0;

     //Locking using Lock and ReentrantLock
     public int getCount() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
            return count++;
        } finally {
            lock.unlock();
        }
     }

     //Implicit locking using synchronized keyword
     public synchronized int getCountTwo() {
         System.out.println(Thread.currentThread().getName() + " gets Count: " + count2);
            return count2++;
     }

    

    public static void main(String args[]) {
        final ReentrantLockVsSynchronized counter = new ReentrantLockVsSynchronized();
        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (counter.getCount() <6) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();                    }
                }
            }
        };
      
        Thread t2 = new Thread() {

            @Override
            public void run() {
                while (counter.getCount() < 6) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
      
        
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-------------Lock Executed above---------------");
        System.out.println("-------------Synchronized block executing below---------------");
        Thread t3 = new Thread() {

            @Override
            public void run() {
                while (counter.getCountTwo() <6) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();                    }
                }
            }
        };
      
        Thread t4 = new Thread() {

            @Override
            public void run() {
                while (counter.getCountTwo() < 6) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        t3.start();
        t4.start();
        
    }
}
