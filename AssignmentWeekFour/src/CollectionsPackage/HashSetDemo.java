package CollectionsPackage;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		
		HashSet hset = new HashSet();
		hset.add("v");
		hset.add("V");
		hset.add("w");
		hset.add("e");
		hset.add("H");
		System.out.println("Heterogeneous elements allowed: "+hset.add(1));
		System.out.println("duplicate elements allowed: "+hset.add("v"));
		System.out.println("null insertion allowed: "+hset.add(null));
		System.out.println("insertion order [v,V,w,e,H,1,v,null] preserved: \n"+hset);
		Iterator itr = hset.iterator();
		while(itr.hasNext()) {
			String element = String.valueOf(itr.next());
			System.out.print(element+" ");
		}
		

	}

}
