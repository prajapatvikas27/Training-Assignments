package CollectionsPackage;
import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		TreeMap tmap = new TreeMap();
		tmap.put(new Student(10,"shamsher"), "passed");
		tmap.put(new Student(8,"shalini"), "passed");
		tmap.put(new Student(5,"ritesh"), "failed");
		//tmap.put(null, null);
		tmap.put(new Student(7,"ritvik"), "Passed");
		//tmap.put(5, 6);
		System.out.println(tmap);
		
		TreeMap nmTmap = new TreeMap(new rvrsNameComprator());
		nmTmap.putAll(tmap);
		System.out.println(nmTmap);
	}

}

class rvrsNameComprator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		String o1name = s1.name;
		String o2name = s2.name;
		return o2name.compareTo(o1name);
	}
	
}