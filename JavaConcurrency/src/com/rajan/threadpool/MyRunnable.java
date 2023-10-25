package com.rajan.threadpool;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println("My runnable");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
