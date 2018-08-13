
class SynchedAccount{
	private int balance = 50;
	
	public  int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int amount) {
		
		if(getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + " is trying"
					+ " to withdraw money. Account balance: " + getBalance());
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			balance = balance - amount;
			System.out.println(Thread.currentThread().getName() + "withdrew money."
					+ " Account balance left :" + getBalance());
		}
		else {
			System.out.println(Thread.currentThread().getName() + "can't make"
					+ "withdrawl. Account balance : " + getBalance());
		}
	
		
	}
}

class SynchronizedAccountHolder implements Runnable{
	
	private SynchedAccount synchedaccount;
	
	public SynchronizedAccountHolder(SynchedAccount account) {
		this.synchedaccount = account;
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i < 5; i++) {
			
			synchedaccount.withdraw(10);
			
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
			if(synchedaccount.getBalance() < 0) {
				System.out.println("This should never have executed");
			}
		}
		
	}

}

public class SynchronizedAccount {

	public static void main(String[] args) {
		SynchedAccount account = new SynchedAccount();
		SynchronizedAccountHolder fred = new SynchronizedAccountHolder(account);
		SynchronizedAccountHolder lucy = new SynchronizedAccountHolder(account);
		Thread t1 = new Thread(fred);
		Thread t2 = new Thread(lucy);
		t1.setName("Fred");
		t2.setName("Lucy");
		t1.start();
		t2.start();
	}

}
