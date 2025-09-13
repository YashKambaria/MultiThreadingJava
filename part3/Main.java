package part3;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		BankAccount bankAccount=new BankAccount();
		
		Runnable task= new Runnable() {
			@Override
			public void run() {
				bankAccount.withdraw(50);
			}
		};
		Thread t1=new Thread(task,"Thread 1");
		Thread t2=new Thread(task,"Thread 2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		
		
	}
}
