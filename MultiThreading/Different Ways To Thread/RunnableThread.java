package interviewPrep;

class process implements Runnable{

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

public class RunnableThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new process());
		Thread t2 = new Thread(new process());
		t2.start();
		t1.start();
	}

}
