package part3;

public class BankAccount {
	private int balance=100;
	
	public synchronized void withdraw(int amount){
		
		if(amount<=balance){
			System.out.println(Thread.currentThread().getName()+" is processing payment");
			try {
				Thread.sleep(1000);
			}
			catch (Exception e){
			
			}
			balance-=amount;
			System.out.println(Thread.currentThread().getName()+" completed transaction current balance "+ balance);
			
		}
		else{
			System.out.println("Insufficient balance");
		}
	}
	
	public int getBalance() {
		return balance;
	}
}
