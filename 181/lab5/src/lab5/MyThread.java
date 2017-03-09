package lab5;

public class MyThread extends Thread {

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
    public void start() {
    	for (int i = 0; i < 1000; i++) {
			System.out.print(this.c);
			Thread.yield();
		}
    }
    
}