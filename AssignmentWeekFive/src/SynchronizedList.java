import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class NameList{
	
	private List nameList = new LinkedList<>();
	
	public synchronized void addName(String name) {
		nameList.add(name);
		System.out.println(Thread.currentThread().getName() + " added " + name);
	}
	
	public synchronized void getName() {
		if (nameList.size() > 0)
			System.out.println(Thread.currentThread().getName()
					+" removed "+((String) nameList.remove(0)));
			else {
				System.out.println(Thread.currentThread().getName()
						+" has nothing to remove ");
			}
	}
	
}

class Admin implements Runnable{
	
	NameList nameList;
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	Random rand = new Random();
	
	Admin(NameList nameList){
		this.nameList = nameList;
	}
	
	@Override
	public void run() {
		
		
		for(int i = 0; i < 99; i++) {
		
			int n = rand.nextInt(10) + 1;
			if(n % 2 == 0) {
				String name = randomIdentifier();
				nameList.addName(name);
			}
			else {
				
			nameList.getName();
				
			}
			
		}
		
	}
	
	public String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        
	    }
	    return builder.toString();
	}
	
}

public class SynchronizedList {
	
	public static void main(String[] args) {
		
		NameList nameList = new NameList();
		Admin admin1 = new Admin(nameList);
		Admin admin2 = new Admin(nameList);
		Thread t1 = new Thread(admin1);
		Thread t2 = new Thread(admin2);
		t1.setName("admin first");
		t2.setName("admin two");
		t1.start();
		t2.start();

	}

}
