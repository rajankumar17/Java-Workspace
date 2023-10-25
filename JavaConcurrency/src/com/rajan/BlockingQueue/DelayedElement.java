package com.rajan.BlockingQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * The value returned by the getDelay() method should be the delay remaining
	 * before this element can be released. If 0 or a negative value is
	 * returned, the delay will be considered expired, and the element released
	 * at the next take() etc. call on the DelayQueue.
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		long seconds = unit.toSeconds(5000);
		return seconds;
	}

}
