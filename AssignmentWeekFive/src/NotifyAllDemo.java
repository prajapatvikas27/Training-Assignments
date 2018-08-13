
class Reader implements Runnable{
	
	Calculator calc;
	
	Reader(Calculator calc){
		this.calc = calc;
	}
	
	@Override
	public void run() {
		
		synchronized(calc) {
			System.out.println(Thread.currentThread().getName() + 
					" starts waiting for calculator");
			try {
				calc.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + 
					" calculation : " + calc.total);
		}
		
	}
	
}

class Calculator implements Runnable{
	
	int total = 0;
	
	@Override
	public void run() {
		
		synchronized(this) {
			for(int i = 0; i<=100; i++) {
				total += i;
			}
			
			System.out.println(Thread.currentThread().getName() + 
					"finished calculation. Notifying everyOne");
			this.notifyAll();
		}
	}
	
}

public class NotifyAllDemo {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		Reader reader1 = new Reader(calculator);
		Reader reader2 = new Reader(calculator);
		Reader reader3 = new Reader(calculator);
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
