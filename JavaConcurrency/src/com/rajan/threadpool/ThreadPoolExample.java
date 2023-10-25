package com.rajan.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String args[]) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            service.submit(new Task(i,i*200));
        }
        service.shutdown();
    }

}

final class Task implements Runnable {
    private int taskId;
    private long seconds;

    public Task(int id,long seconds) {
        this.taskId = id;
        this.seconds = seconds;
    }
    

    @Override
    public void run() {
        try {
            Thread.sleep(seconds);
            System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
