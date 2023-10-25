package com.rajan.locks;

//Lock Core Implementation
/**
 * Notice the while(isLocked) loop, which is also called a "spin lock". Spin
 * locks and the methods wait() and notify() are covered in more detail in the
 * text Thread Signaling. While isLocked is true, the thread calling lock() is
 * parked waiting in the wait() call. In case the thread should return
 * unexpectedly from the wait() call without having received a notify() call
 * (AKA a Spurious Wakeup) the thread re-checks the isLocked condition to see if
 * it is safe to proceed or not, rather than just assume that being awakened
 * means it is safe to proceed. If isLocked is false, the thread exits the
 * while(isLocked) loop, and sets isLocked back to true, to lock the Lock
 * instance for other threads calling lock().
 * 
 * When the thread is done with the code in the critical section (the code
 * between lock() and unlock()), the thread calls unlock(). Executing unlock()
 * sets isLocked back to false, and notifies (awakens) one of the threads
 * waiting in the wait() call in the lock() method, if any.
 */


public class Lock{

	  private boolean isLocked = false;

	  public synchronized void lock()
	  throws InterruptedException{
	    while(isLocked){   //spin lock
	      wait();
	    }
	    isLocked = true;   //for spurious wake up
	  }

	  public synchronized void unlock(){
	    isLocked = false;
	    notify();
	  }
	}
