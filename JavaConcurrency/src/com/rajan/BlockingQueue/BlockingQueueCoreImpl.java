package com.rajan.BlockingQueue;

import java.util.LinkedList;
import java.util.List;


//Same as bounded semaphore
public class BlockingQueueCoreImpl {

	private List queue = new LinkedList();
	private int limit = 10;

	public BlockingQueueCoreImpl(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		System.out.println("Enqueued");
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		Thread.sleep(2000);
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		System.out.println("Dequeued");
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}
		Thread.sleep(1000);
		return this.queue.remove(0);
	}

}
