package com.rajan.executorservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // execute
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        executorService1.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService1.shutdown();

        // submit
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future futureVar = executorService2.submit(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        // returns null if the task has finished correctly.
        try {
            System.out.println(futureVar.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // submit(Callable)
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        @SuppressWarnings("unchecked")
        Future future = executorService3.submit(new Callable() {
            public Object call() throws Exception {
                System.out.println("Asynchronous Callable");
                return "Callable Result";
            }
        });

        try {
            System.out.println("future.get() = " + future.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // invokeAny()
        ExecutorService executorService4 = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        try {
            String result = executorService4.invokeAny(callables);

            System.out.println("result = " + result);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        executorService4.shutdown();

        // invokeAll()
        ExecutorService executorService5 = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables2 = new HashSet<Callable<String>>();

        callables2.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables2.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables2.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        try {
            List<Future<String>> futures = executorService5.invokeAll(callables2);

            for (Future<String> future1 : futures) {
                System.out.println("future1.get = " + future1.get());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        executorService5.shutdown();

    }
}
