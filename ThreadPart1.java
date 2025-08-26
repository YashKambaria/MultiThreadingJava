public class ThreadPart1 extends Thread{
	
	
	public static void main(String[] args) throws InterruptedException {
		ThreadPart1 threadPart1=new ThreadPart1();
//		ThreadPart1 threadPart3=new ThreadPart1();
//		ThreadPart1 threadPart2=new ThreadPart1();
		threadPart1.start();
		threadPart1.join();
		System.out.println("Executed");
		
//		threadPart2.start();
//		threadPart3.start();
	}
	
	@Override
	public void run() {
//		System.out.println("Running ->"+Thread.currentThread().getName() +" priority -> "+Thread.currentThread().getPriority());
//		for (int i = 0; i <5 ; i++) {
			try {
				Thread.sleep(5000);
			}
			catch (Exception e){
				e.printStackTrace();
			}
//		}
	}
}
