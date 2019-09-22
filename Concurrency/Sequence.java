package com.DB.threading;
//to maintain numeric sequence
public class Sequence {
private int value = 0;
	
//not  thread safe wont work in multithreaded programs
	public int getNext() {
		//a new thread will not be asked to do this
		synchronized(this) {
		value = value + 1;
		return value;
		}
	}

}
