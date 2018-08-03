package CollectionsPackage;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		
		TreeSet tset = new TreeSet();
		tset.add("v");
		tset.add("V");
		tset.add("w");
		tset.add("e");
		tset.add("H");
		//System.out.println("Heterogeneous elements allowed: "+tset.add(1)); //not allowed
		System.out.println("duplicate elements allowed: "+tset.add("v"));
		//System.out.println("null insertion allowed:"+tset.add(null)); //null insertion not allowed
		System.out.println("insertion order [v,V,w,e,H,1,v,null] preserved: \n"+tset);
		Iterator itr = tset.iterator();
		while(itr.hasNext()) {
			String element = String.valueOf(itr.next());
			System.out.print(element+" ");
		}
		
		TreeSet tSetRvrs = new TreeSet(new reverseComparator());
		tSetRvrs.addAll(tset);
		System.out.println("Customized sorted set: "+tSetRvrs);

	}

}
class reverseComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		String str1 = o1.toString();
		String str2 = o2.toString();
		return str2.compareTo(str1);
		
	}
	
}
