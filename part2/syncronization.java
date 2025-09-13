package part2;

public class syncronization{
	
	
	public static void main(String[] args) throws InterruptedException {
		Counter counter=new Counter();
		MyThread thread=new MyThread(counter);
		MyThread thread2=new MyThread(counter);
		
		
		/*here the threads share the same resources counter and work parallelly
		hence we may not get the consistent result that is 1000+1000=2000
		.To achieve this we use synchronized keyword which locks that portion so that
		other thread do not execute there until the running thread is completed
		 */
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
		System.out.println(counter.get());
		
	}
}
