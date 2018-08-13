

class Counter implements Runnable{
	
	@Override
	public void run() {
		for(int i = 0 ; i<=99 ; i++ ) {
			if((i % 10) == 0) {
				System.out.println(i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}

public class SleepCounter {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		Thread t = new Thread(counter);
		t.start();
		
	}

}
