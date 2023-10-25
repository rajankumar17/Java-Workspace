package com.rajan.BlockingQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

public class DelayQueueExample {

	public static void main(String[] args) {
		try {
			DelayQueue queue = new DelayQueue();

			Delayed element1 = new DelayedElement();

			queue.put(element1);
			System.out.println("element put");
			Delayed element2 = queue.take();
			System.out.println("element taken"+element2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}