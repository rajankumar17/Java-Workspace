package com.rajan.locks;

public class Counter {

	private Lock lock = new Lock();
	private int count = 0;

	public int inc() {
		int newCount = 0;
		try {
			lock.lock();
			newCount = ++count;
			lock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newCount;
	}
	
	
	public static void main(String[] args) {
		Counter counter=new Counter();
		System.out.println(counter.inc());
	}
}
