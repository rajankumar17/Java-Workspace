package com.rajan.semaphore;

public class SendingThread extends Thread{
	Semaphore semaphore = null;

	public SendingThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			while (true) {
				// do something, then signal
				Thread.sleep(2000);
				System.out.println("In sending thread");
				this.semaphore.take();

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
