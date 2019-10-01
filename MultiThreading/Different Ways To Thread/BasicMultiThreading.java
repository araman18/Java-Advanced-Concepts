package interviewPrep;

public class BasicMultiThreading {

	public static void main(String[] args) {
		Runner r1 = new Runner();
		r1.start(); //if we call run it still runs it in the main thread not the new thread
		Runner r2 = new Runner();
		r2.start();
		
	}

}

class Runner extends Thread{
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + "Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
