package interviewPrep;

import java.util.LinkedList;

public class CPU {
	
	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException{
		int value = 0;
		while(true) {
			synchronized(lock) {
				while(list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
			
		}
		
	}
	
	public void consumer() throws InterruptedException {
		while(true) {
			synchronized(lock) {
				while(list.size() == 0) {
					lock.wait();
				}
				System.out.println("List size " + list.size());
				int value = list.removeFirst();
				System.out.println("Values is " + value);
				lock.notify();
				//wakes up the other lock
			}
			Thread.sleep(500);
		}
		
		
	}

}
