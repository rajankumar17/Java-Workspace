package com.rajan.semaphore;

import java.util.concurrent.Semaphore;

/**
 * a Counting semaphore with one permit is known as binary semaphore because it
 * has only two state permit available or permit unavailable. Binary semaphore
 * can be used to implement mutual exclusion or critical section where only one
 * thread is allowed to execute. Thread will wait on acquire() until Thread
 * inside critical section release permit by calling release() on semaphore
 * 
 * here is a simple example of counting semaphore in Java where we are using
 * binary semaphore to provide mutual exclusive access on critical section of
 * code in java:
 */

/**
 * 1. Semaphore class supports various overloaded version of tryAquire() method
 * which acquires permit from semaphore only if its available during time of
 * call.
 * 
 * 2. Another worth noting method from Semaphore is acquireUninterruptibly()
 * which is a blocking call and wait until a permit is available.
 */
public class CountingSemaphoreApi {

    Semaphore binary = new Semaphore(1);

    public static void main(String args[]) {
        final CountingSemaphoreApi test = new CountingSemaphoreApi();
        new Thread() {
            @Override
            public void run() {
                test.mutualExclusion();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.mutualExclusion();
            }
        }.start();
        
        new Thread() {
            @Override
            public void run() {
                test.mutualExclusion();
            }
        }.start();

    }

    private void mutualExclusion() {
        try {
            System.out.println(Thread.currentThread().getName() + " before acquire ");
            binary.acquire();
            // mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " acquired - inside mutual exclusive region");
            Thread.sleep(3000);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            binary.release(); 
            System.out.println(Thread.currentThread().getName() + " released - outside of mutual exclusive region");
        }
    }

}
