package com.rajan.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to demonstrate how to use CyclicBarrier in Java. CyclicBarrier
 * is a new Concurrency Utility added in Java 5 Concurrent package.
 * 
 * @author Javin Paul
 */

/**
 * 1. CyclicBarrier can perform a completion task once all thread reaches to the
 * barrier, This can be provided while creating CyclicBarrier.
 * 
 * 2. If CyclicBarrier is initialized with 3 parties means 3 thread needs to
 * call await method to break the barrier. 
 * 3. The thread will block on await()
 * until all parties reach to the barrier, another thread interrupt or await
 * timed out. 
 * 4. If another thread interrupts the thread which is waiting on
 * barrier it will throw BrokernBarrierException as shown below:
 * 
 * java.util.concurrent.BrokenBarrierException at
 * java.util.concurrent.CyclicBarrier.dowait(CyclicBarrier.java:172) at
 * java.util.concurrent.CyclicBarrier.await(CyclicBarrier.java:327)
 * 
 * 5.CyclicBarrier.reset() put Barrier on its initial state, other thread which
 * is waiting or not yet reached barrier will terminate with
 * java.util.concurrent.BrokenBarrierException.
 */

/**
 * The waiting threads waits at the CyclicBarrier until either:
 * 
 * The last thread arrives (calls await() ) The thread is interrupted by another
 * thread (another thread calls its interrupt() method) Another waiting thread
 * is interrupted Another waiting thread times out while waiting at the
 * CyclicBarrier The CyclicBarrier.reset() method is called by some external
 * thread.
 */
public class CyclicBarrierExample {

    // Runnable task for each thread
    private static class Task implements Runnable {

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException ex) {
                Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {

        // creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call
        // await()
        //The CyclicBarrier supports a barrier action, which is a Runnable that 
        //is executed once the last thread arrives. You pass the Runnable barrier 
        //action to the CyclicBarrier in its constructor
        final CyclicBarrier cb = new CyclicBarrier(30, new Runnable() {
            @Override
            public void run() {
                // This task will be executed once all thread reaches barrier
                System.out.println("All parties are arrived at barrier, lets play");
            }
        });

        // starting each of thread
        
        Thread t1 = new Thread(new Task(cb), "Thread 1");
        Thread t2 = new Thread(new Task(cb), "Thread 2");
        Thread t3 = new Thread(new Task(cb), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
       /* //For BarrierException
        for(int i=1;i<100;i++){
            new Thread(new Task(cb), "Thread 1").start();
            }
        cb.reset() ;*/
    }
}