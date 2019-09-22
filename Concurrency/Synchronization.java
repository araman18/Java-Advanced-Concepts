package com.DB.threading;
//synchronize threads to share data
public class Synchronization {

	public static void main(String[] args) {
		Sequence seq = new Sequence();
		Worker worker1 = new Worker(seq);
		worker1.start();
		
		Worker worker2 = new Worker(seq);
		worker2.start();
		//can cause threads to get both values
		
		
		
		
	}

}

class Worker extends Thread{
	Sequence seq = null;
	
	public Worker(Sequence seq) {
		this.seq = seq;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " got Value " + seq.getNext());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
