package CollectionsPackage;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class LinkedHashSetDemo {

	public static void main(String[] args) {
		LinkedHashSet lhset = new LinkedHashSet();
		lhset.add("v");
		lhset.add("V");
		lhset.add("w");
		lhset.add("e");
		lhset.add("H");
		System.out.println("Heterogeneous elements allowed: "+lhset.add(1));
		System.out.println("duplicate elements allowed: "+lhset.add("v"));
		System.out.println("null insertion allowed: "+lhset.add(null));
		System.out.println("insertion order [v,V,w,e,H,1,v,null] preserved: \n"+lhset);
		Iterator itr = lhset.iterator();
		while(itr.hasNext()) {
			String element = String.valueOf(itr.next());
			System.out.print(element+" ");
		}
	}

}
