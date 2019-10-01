import java.util.ArrayList;
import java.util.Random;


public class Locks {
	
	private static Random r = new Random();
	
	private static ArrayList<Integer> list1 = new ArrayList<Integer>();
	private static ArrayList<Integer> list2 = new ArrayList<Integer>();
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();


	public static void main(String[] args) {
		System.out.println("Starting ");
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken " + (end - start));
		System.out.println("1 " + list1.size() + " 2: " + list2.size());
	}
	
	public static void stage1() {
		
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(r.nextInt());	
		}
		
	}
	
	public static void stage2() {
		
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(r.nextInt());
		}
		
	}
	
	public static void process() {
		for(int i = 0; i < 1000; i++) {
			stage1();
			stage2();
		}
	}

}
