

class MyRunnable implements Runnable{

	@Override
	public void run() {
		
		for(int i = 0 ; i <= 9; i++) {
		
			System.out.println((i + 1) + ". MyRunnable is Running");
		
		}
	}
}

public class ThreadDefineInstantiateRun {

	public static void main(String[] args) {
		
		MyRunnable myRunnable = new MyRunnable();
		Thread t = new Thread(myRunnable);
		t.start();

	}

}
