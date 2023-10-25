package CountDownLatch_6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link java.util.concurrent.CountDownLatch} Java class to synchronize your
 * threads’ activities. <br>
 * <br>
 * Source:
 * <em>http://stackoverflow.com/questions/17827022/what-is-countdown-latch-in-java-multithreading</em>
 * <br>
 * 
 * Any thread, usually main thread of application, which calls
 * {@link java.util.concurrent.CountDownLatch#await()} will wait until count
 * reaches zero or its interrupted by another thread. All other thread are
 * required to do count down by calling
 * {@link java.util.concurrent.CountDownLatch#countDown()} once they are
 * completed or ready. <br>
 * As soon as count reaches zero, Thread awaiting starts running. One of the
 * disadvantage of {@link java.util.concurrent.CountDownLatch} is that it's not
 * reusable once the count reaches to zero you can not use
 * {@link java.util.concurrent.CountDownLatch} any more. <br>
 * <br>
 * Use {@link java.util.concurrent.CountDownLatch} when one thread, like main
 * thread, require to wait for one or more threads to complete, before it can
 * start processing. <br>
 * <br>
 * Classical example of using {@link java.util.concurrent.CountDownLatch} in
 * Java is any server side core Java application which uses services
 * architecture, where multiple services are provided by multiple threads and
 * application can not start processing until all services have started
 * successfully. <br>
 * <br>
 * Codes with minor comments are from
 * <em>http://www.caveofprogramming.com/youtube/</em><br>
 * also freely available at
 * <em>https://www.udemy.com/java-multithreading/?couponCode=FREE</em>
 * 
 * @author Z.B. Celik <celik.berkay@gmail.com>
 */

/**
 * CountDownLatch works in latch principle, main thread will wait until Gate is
 * open. One thread waits for n number of threads specified while creating
 * CountDownLatch in Java. Any thread, usually main thread of application, which
 * calls CountDownLatch.await() will wait until count reaches zero or its
 * interrupted by another Thread. All other thread are required to do count down
 * by calling CountDownLatch.countDown() once they are completed or ready to the
 * job. as soon as count reaches zero, Thread awaiting starts running. One of
 * the disadvantage of CountDownLatch is that its not reusable once count
 * reaches to zero you can not use CountDownLatch any more, but don't worry Java
 * concurrency API has another concurrent utility called CyclicBarrier for such
 * requirements.
 */

/**
 * Few points about Java CountDownLatch which is worth remembering: 
 * 1) You can
 * not reuse CountDownLatch once count is reaches to zero, this is the main
 * difference between CountDownLatch and CyclicBarrier, which is frequently
 * asked in core Java interviews and multi-threading interviews. 
 * 2) Main Thread
 * wait on Latch by calling CountDownLatch.await() method while other thread
 * calls CountDownLatch.countDown() to inform that they have completed.
 */
class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started.");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("Ended.");
        latch.countDown();
    }
}

public class App {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(new Processor(latch));
        }
        // executor.shutdown();

        try {
            // Application main thread waits, till other service threads which
            // are as an example responsible for starting framework services
            // have
            // completed started all services.
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }

}
