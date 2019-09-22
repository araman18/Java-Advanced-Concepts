package com.DB.threading;
public class Application {
	/*Notes
	 * One thread normally, one task -  the main thread, instructions executing sequentially or one by one. 
	 * This is called single threaded execution, now using multi threaded programs
	 * Downloading files from Internet, do calcs and load a summary file, each task can be run on their own thread at
	 * the same time
	 * Essentially multiple lines of code are being run simultaneously
	 * Complexity when threads are communicating with each other, deadlock etc
	 * 
	 * */

	public static void main(String[] args) {
		Thread t1 = new Thread(new Task("Thread-A"));
		System.out.println("Starting Thread A");//multithreaded program
		
		t1.start();//activates the thread
		//thread cant be restarted until its completed
		
		System.out.println("Starting Thread B");
		
		Thread t2 = new Thread(new Task("Thread B"));
		
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("number: " + i +  " " + Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		t2.start();
		t3.start();
	}

}

//New Thread -task driven multi threaded for a while
class Task implements Runnable{//Implements the runnable interface but cant use start now but if we use run then we dont use threading
	String name ;
	
	public Task(String name) {
		this.name = name;
	}
	public void run() {
		Thread.currentThread().setName(name);
		for(int i = 0; i < 100; i++) {
			System.out.println("number: " + i +  " " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
