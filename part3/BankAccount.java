package part3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private int balance=100;
	
	private final Lock lock=new ReentrantLock();
	
	/*
	here we have used ReentrantLock because it helps us to do lock the locked thread
	so that the program does not go in the deadlock state
	for example you have 1 task which has 2 subtask so you can lock both of the
	task but note that you have to unlock it same number of time as lock
	Also for consistency  you have to unlock the lock in the same block
	 where you have acquired the lock
	 */
	
	/*
	lock.tryLock(time,timeunit) will try to wait for the given time to
	enter and acquire lock but if the time is more than that then it
	does not executes
	
	but in lock.tryLock() it will only lock if the
	lock is free otherwise it will not execute or wait
	
	and lock.lock() will wait till it does not get
	the critical area free (same as synchronized)
	
	 */
	
	
	public void withdraw(int amount){
		try {
			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				if (amount <= balance) {
					try {
						System.out.println(Thread.currentThread().getName() + " is processing payment");
						Thread.sleep(1000);
						balance -= amount;
						System.out.println(Thread.currentThread().getName() + " completed transaction current balance " + balance);
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println("Insufficient balance");
				}
			}
			else {
				System.out.println("Lock is acquired please try again later");
			}
		}
		catch (Exception e){
			//here we have used this to perform the following task -
			Thread.currentThread().interrupt();                 // |
		}                                                       // |
		/*                                                      // |
		if(Thread.currentThread().isInterrupted()){  <-------------|
			perform login or any other tasks
		}
		 */
		
	}
	
	public int getBalance() {
		return balance;
	}
}
