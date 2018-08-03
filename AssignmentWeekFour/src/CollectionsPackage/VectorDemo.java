package CollectionsPackage;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
	
		Vector vctr = new Vector();
		vctr.add("v");
		vctr.add("V");
		vctr.add("w");
		vctr.add("e");
		vctr.add("d");
		System.out.println("heterogeneous element allowed: "+vctr.add(1));
		System.out.println("null insertion allowed: "+vctr.add(null));
		System.out.println("duplicates allowed: "+vctr.add("v"));
		System.out.println("insertion order [v,V,w,e,d,1,null,v] preserved or not: \n"+vctr);
		System.out.println(vctr.set(5, "s")+" replaced");
		System.out.println(vctr.set(6, "h"));
		System.out.println("changed vector: "+vctr);
		Collections.sort(vctr);
		System.out.println("sorted vctr :"+vctr);
		ListIterator litr = vctr.listIterator();
		System.out.println("vector elements removed :");
		while(litr.hasNext()) {
			System.out.print(vctr.remove(litr.nextIndex())+" ");
		}
		System.out.println("final vctr size:"+vctr.size());
	}

}
