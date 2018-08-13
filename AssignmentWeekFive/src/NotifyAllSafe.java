
class SafeReader implements Runnable{
	
	SafeCalculator calculator = new SafeCalculator();
	
	SafeReader(SafeCalculator safeCalculator){
		this.calculator = safeCalculator;
	}
	
	@Override
	public void run() {
		
		synchronized(calculator) {
			System.out.println(Thread.currentThread().getName() + 
					" is starting to wait");
			while(calculator.calculationNotDone()) {
				try {
					calculator.wait();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + 
					" calculation : " + calculator.total);
		}
		
	}
	
}

class SafeCalculator implements Runnable{
	int total = 0;
	boolean calNotDone = true;
	@Override
	public void run() {
	
		synchronized(this) {
			
			for(int i = 0;i <= 100; i++) {
				total += i;
			}
			
			calNotDone = false;
			System.out.println("EveryOne Notified");
			notifyAll();
		}
		
	}
	
	public boolean calculationNotDone() {
		return calNotDone;
	}
	
}

public class NotifyAllSafe {

	public static void main(String[] args) {
		
		SafeCalculator calculator = new SafeCalculator();
		SafeReader reader1 = new SafeReader(calculator);
		SafeReader reader2 = new SafeReader(calculator);
		SafeReader reader3 = new SafeReader(calculator);
		Thread t1 = new Thread(reader1);
		Thread t2 = new Thread(reader2);
		Thread t3 = new Thread(reader3);
		Thread t4 = new Thread(calculator);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
