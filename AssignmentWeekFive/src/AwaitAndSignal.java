import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Signaler implements Runnable{
	ReentrantLock lock = new ReentrantLock();
	Condition calculationDone = lock.newCondition();
	int total = 0;
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		lock.lock();
		try {
			
			for(int i = 0 ; i<=100; i++) {
				total += i;
			}
		
			System.out.println("Calculations done. Signalling");
			calculationDone.signal();
		}
		finally {
			lock.unlock();
		}
	}
}

public class AwaitAndSignal {

	static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		
		Signaler signaler = new Signaler();
		Thread t1 = new Thread(signaler);
		t1.setName("Signaler");
		t1.start();
		
		loop1:
		while(true)	{
		boolean gotLock = signaler.lock.tryLock();
		
			if(gotLock) {
			
				System.out.println("Waiting for Signaler to signal");
				
				try {
					signaler.calculationDone.await();
					System.out.println("total : " + signaler.total);
					break loop1;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		
		}
		
	
	}

}
