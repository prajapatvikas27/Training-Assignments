import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NameRunnable implements Runnable{
	
	@Override
	public void run() {
		
		
		System.out.println("Name Runnable run by : " 
				+ Thread.currentThread().getName());
	}
	
}

class SecondRunnable implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Second Runnable run by : " 
				+ Thread.currentThread().getName());
	}
	
}

public class NameThread {
	
	public static void main(String[] args) {
		
		NameRunnable nameRunnable = new NameRunnable();
		Thread t1 = new Thread(nameRunnable);
		Thread t2 = new Thread(nameRunnable);
		t1.setName("Vikas");
		t2.setName("Ramesh");
		t1.start();
		t2.start();
		NameRunnable nameRunnable2 = new NameRunnable();
		t1 = new Thread(nameRunnable2);
		t1.setName("Third");
		t1.start();
		SecondRunnable secondRunnable = new SecondRunnable();
		t1 = new Thread(secondRunnable);
		t1.setName("second Runnable");
		t1.start();
		/* This part of the code won't work because the job's have already started
		  
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(t1);
		service.submit(t2);
		service.shutdown();
	*/
	}

}
