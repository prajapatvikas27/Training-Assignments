
class Notifier implements Runnable{
	
	int total = 0;
	
	@Override
	public void run() {
		synchronized(this) {
			
			for(int i=0 ; i<=100; i++) {
				total += i;
			}
			System.out.println(Thread.currentThread().getName()+
					" notifies");
			notify();
		}
	}
	
}

public class WaitAndNotify {

	public static void main(String[] args) {
		
		Notifier notifier = new Notifier();
		Thread t1 = new Thread(notifier);
		t1.setName("notifier");
		t1.start();
		synchronized(notifier) {
			System.out.println("Waiting for notifier to notify");
			
			try {
				notifier.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("total : " + notifier.total);
		}

	}

}
