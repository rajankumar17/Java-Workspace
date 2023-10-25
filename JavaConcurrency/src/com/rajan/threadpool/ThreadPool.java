package com.rajan.threadpool;

import java.util.ArrayList;
import java.util.List;

import com.rajan.BlockingQueue.BlockingQueueCoreImpl;

public class ThreadPool {

	private BlockingQueueCoreImpl taskQueue = null;
	private List<PoolThread> threads = new ArrayList<PoolThread>();
	private boolean isStopped = false;

	public ThreadPool(int noOfThreads, int maxNoOfTasks) {
		taskQueue = new BlockingQueueCoreImpl(maxNoOfTasks);

		for (int i = 0; i < noOfThreads; i++) {
			threads.add(new PoolThread(taskQueue));
		}
		for (PoolThread thread : threads) {
			thread.start();
		}
	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");

		this.taskQueue.enqueue(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		for (PoolThread thread : threads) {
			thread.doStop();
		}
	}
	
	public static void main(String[] args) {
		try {
			ThreadPool threadPool=new ThreadPool(5,20);
			Thread.sleep(2000);
			MyRunnable myRunnable=new MyRunnable();
			for (int i = 0; i < 10; i++) {
				threadPool.execute(myRunnable);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
