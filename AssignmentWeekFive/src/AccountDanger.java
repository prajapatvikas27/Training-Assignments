
class Account{
	int balance = 50;
	
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int amt) {
		
		
		if(getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is going "
					+ "to withdraw");
			try {
				Thread.sleep(300);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			balance = balance - amt;
			System.out.println(Thread.currentThread().getName() + " completes"
					+ "withdrawl. Account balance: " + getBalance());
		}else {
			System.out.println("Not enough ammount in the account for "
					+ Thread.currentThread().getName()+" to withdraw "
							+ getBalance());
		}
		
	}
}

class AccountHolder implements Runnable{
	
	Account account;
	
	AccountHolder(Account account){
		this.account = account;
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i < 5; i++) {
			account.withdraw(10);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
			if(account.getBalance() < 0) {
				System.out.println("Account is overdrawn");
			}
		}
		
	}

	
}

public class AccountDanger {

	public static void main(String[] args) {
		
		Account account = new Account();
		AccountHolder fred = new AccountHolder(account);
		AccountHolder lucy = new AccountHolder(account);
		Thread t1 = new Thread(fred);
		Thread t2 = new Thread(lucy);
		t1.setName("Fred");
		t2.setName("lucy");
		t1.start();
		t2.start();
	}

}
