package com.rajan.semaphore;

public class TestSemaphore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore();

		SendingThread sender = new SendingThread(semaphore);

		ReceivingThread receiver = new ReceivingThread(semaphore);

		receiver.start();
		sender.start();

	}

}
