package lab5;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

	static Semaphore s = new Semaphore(1,true); 

	private char c; 
    /**
     * Default Constructor 
     */
    public MyThread(char c) {
    	this.c = c; 
    }

    /**
     * Run override  
     */
    public void run() {


    	try {
			for (int i = 0; i < 1000; i++) {
				s.acquire();
				System.out.print(this.c);
				Thread.yield();
				Thread.sleep(1);
				s.release();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
