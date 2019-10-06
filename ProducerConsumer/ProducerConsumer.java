package interviewPrep;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	 final static CPU c = new CPU();
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					c.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}

/*Taken val = 58Queue size is 10
Taken val = 79Queue size is 9
Taken val = 34Queue size is 9
Taken val = 41Queue size is 9
Taken val = 90Queue size is 10
Taken val = 6Queue size is 9
Taken val = 85Queue size is 9
Taken val = 38Queue size is 9
Taken val = 19Queue size is 10
Taken val = 28Queue size is 9
Taken val = 4Queue size is 9
Taken val = 4Queue size is 9
Taken val = 2Queue size is 9
*/


