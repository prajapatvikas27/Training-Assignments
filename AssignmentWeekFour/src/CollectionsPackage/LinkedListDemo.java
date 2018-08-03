package CollectionsPackage;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList llist = new LinkedList();
		llist.add("L");
		llist.add("b");
		System.out.println("heterogeneous elements allowed: "+llist.add(1));
		System.out.println("null insertion allowed: "+llist.add(null));
		llist.add("a");
		System.out.println("duplicates allowed: "+llist.add("b"));
		System.out.println(llist);
		System.out.println("First element in list: "+llist.getFirst());
		System.out.println("last elemrnt in list: "+llist.getLast());
		System.out.println("replaced element: "+llist.set(3, "z"));
		
		Iterator itr = llist.iterator();
		while (itr.hasNext()) {
			String object = itr.next().toString();
			itr.remove();
			System.out.print(object+" removed ");
		}
		System.out.println("final list:"+llist);
	}

}
