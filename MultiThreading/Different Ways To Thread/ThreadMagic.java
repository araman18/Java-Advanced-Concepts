package interviewPrep;

public class ThreadMagic {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

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
			
		});
	}

}
