package com.rajan.semaphore;

public class ReceivingThread extends Thread{
	Semaphore semaphore = null;

	public ReceivingThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			while (true) {
				this.semaphore.release();
				// receive signal, then do something...
				System.out.println("In Receiving Thread ");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
