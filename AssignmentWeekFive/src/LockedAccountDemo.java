import java.util.concurrent.locks.ReentrantLock;

class LockedAccount{
	int balance = 50;
	ReentrantLock lock = new ReentrantLock();
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int amount) {
		lock.lock();
		try {
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
		}finally {
			lock.unlock();
		}
	}
}

class LockedAccountHolder implements Runnable{
	
	LockedAccount lockedAccount;
	
	public LockedAccountHolder(LockedAccount lockedAccount) {
		this.lockedAccount = lockedAccount;
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i < 5; i++ ) {
				
			lockedAccount.withdraw(10);
					
			try {
					Thread.sleep(500);
				}
			catch(InterruptedException e) {
						
				}
			if(lockedAccount.getBalance() < 0) {
						System.out.println("This should never have executed");
			}
		
		}
		
	}
}
public class LockedAccountDemo {

	public static void main(String[] args) {
		
		LockedAccount lockedAccount = new LockedAccount();
		LockedAccountHolder fred = new LockedAccountHolder(lockedAccount);
		LockedAccountHolder lucy = new LockedAccountHolder(lockedAccount);
		Thread t1 = new Thread(fred);
		Thread t2 = new Thread(lucy);
		t1.setName("fred");
		t2.setName("lucy");
		t1.start();
		t2.start();
	}

}
