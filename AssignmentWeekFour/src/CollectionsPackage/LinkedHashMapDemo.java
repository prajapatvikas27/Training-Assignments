package CollectionsPackage;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

	public static void main(String[] args) throws InterruptedException {
		
		LinkedHashMap lhmap = new LinkedHashMap();
		lhmap.put("1", "Vikas");
		lhmap.put("3", "Kl");
		lhmap.put("2", "virat");
		lhmap.put("5", "Msd");
		lhmap.put("4", "hardik");
		lhmap.put(new Student(3, "Vikas"), "passed");
		
		System.out.println("Heterogenous key allowed: "+lhmap.put("hetro", "hValue"));
		System.out.println("Heterogeneous values allowed: "+lhmap.put("6", 2));
		System.out.println("Duplicate entries allowed: "+lhmap.put("3", "Virat"));
		System.out.println("same key different value: "+lhmap.put("2", "hitman"));
		System.out.println("null insertion allowed: "+lhmap.put(null, null));
		System.out.println("insertion order {1=vikas,2=kl,3=virat"
				+ ",4=Msd,5=hardik preserved: ");
		System.out.println("Before gc: "+lhmap);
		System.gc();
		Thread.sleep(5000);
		System.out.println("After gc: "+lhmap);
		System.out.println("contains key vikas: "+lhmap.containsKey("vikas"));
		System.out.println("contains value Vikas: "+lhmap.containsValue("Vikas"));
		

	}

}

