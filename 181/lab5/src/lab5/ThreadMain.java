package lab5;

public class ThreadMain {
	public static void main(String args[]) {
		MyThread t1 = new MyThread('h');
		MyThread t2 = new MyThread('a');
		
		t1.start();
		t2.start();
	}
}

/*
 * 6. Thread 1 starts and completely executes, and then Thread 2 starts and completely executes
 * 
 * 
 * 
 */