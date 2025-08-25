public class main extends Thread{
	
	public static void main(String[] args) throws InterruptedException {
		/*  method 1
		World world=new World();
		world.start();
		while(true) {
			System.out.println("Hello");
		}
		 */
		
		/* method 2
		
		
		World world=new World();
		Thread thread=new Thread(world);
		thread.start();
		while(true){
			System.out.println("Hello");
		}
		 */
		 main myThread=new main();
		System.out.println(myThread.getState());
		 myThread.start();
		System.out.println(myThread.getState());
		System.out.println(Thread.currentThread().getState());
		Thread.sleep(100);
		System.out.println(myThread.getState());
		myThread.join();
		System.out.println(myThread.getState());
		
		
	}
	
	@Override
	public void run() {
		System.out.println("Running");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
