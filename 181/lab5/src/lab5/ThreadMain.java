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
 * 	  so there are 1000 h's and 1000 a's
 * 8. The two threads seem to execute at 'random' times, this is because the yield function 
 *    tells the scheduler that the calling thread is willing to yield or give up use. resutling 
 *    in a seeming random flow of execution 
 * 10. The output is close to ha * 1000 but there are some conjoined h's and a's. 
 *     This is because the thread sleeping for one millisecond gives the other thread
 * 	   enough time to execute before it continues its execution. But the loop can fire off more than once 
 * 	   within that period 
 * 11. With the semaphore, the two threads will wait for access to the thread before executing, meaning it 
 *     print out a ha * 1000 pattern.
 */