
class Letter implements Runnable{
	
	StringBuffer str;
	
	Letter(StringBuffer str){
		this.str = str;
	}
	
	@Override
	public void run() {
		synchronized(this.str) {
			for(int i = 0; i<99 ; i++) {
				System.out.println(Thread.currentThread().getName() + 
					i +" :" +	str.toString());
			}
			str.replace(0,str.length(), "b");
		}
	}
	
}

public class SynchronizedBlock {

	public static void main(String[] args) {
		
		String string = "a";
		StringBuffer str = new StringBuffer();
		str.append(string);
		Letter first = new Letter(str);
		Letter second = new Letter(str);
		Letter third = new Letter(str);
		Thread t1 = new Thread(first);
		Thread t2 = new Thread(second);
		Thread t3 = new Thread(third);
		t1.setName("first");
		t2.setName("second");
		t3.setName("third");
		t1.start();
		t2.start();
		t3.start();
	}

}
