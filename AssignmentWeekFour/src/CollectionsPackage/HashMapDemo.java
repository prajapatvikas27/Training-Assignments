package CollectionsPackage;
import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		
		HashMap hmap = new HashMap();
		hmap.put("1", "Vikas");
		hmap.put("3", "Kl");
		hmap.put("2", "virat");
		hmap.put("5", "Msd");
		hmap.put("4", "hardik");
		System.out.println("Heterogenous key allowed: "+hmap.put("hetro", "hValue"));
		System.out.println("Heterogeneous values allowed: "+hmap.put("6", 2));
		System.out.println("Duplicate entries allowed: "+hmap.put("3", "Virat"));
		System.out.println("same key different value: "+hmap.put("2", "hitman"));
		System.out.println("null insertion allowed: "+hmap.put(null, null));
		System.out.println("insertion order {1=vikas,2=kl,3=virat"
				+ ",4=Msd,5=hardik preserved");
		System.out.println(hmap);
		
		
	}

}
