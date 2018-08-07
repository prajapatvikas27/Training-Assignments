
class A{
	public synchronized void d1(B b) {
		System.out.println(" A d1() method starts execution");
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			System.out.println("A d1() got interrupted");
		}
		b.last();
	}
	
	public synchronized void last() {
		System.out.println("Inside A's last() method");
	}
}

class B{
	public synchronized void d1(A a) {
		System.out.println(" B d1() method starts execution");
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println(" B d2() got interrupted");
		}
		a.last();
	}
	
	public synchronized void last() {
		System.out.println("Inside B's last() method");
	}
	
}

class MyThread extends Thread{
	A a =new A();
	B b = new B();
	public void m1() {
		this.start();
		a.d1(b);
	}
	
	public void run() {
		b.d1(a);
	}
	
}

public class DeadLock {

	public static void main(String[] args) {
		
		MyThread mt = new MyThread();
		mt.m1();
		
	}

}
