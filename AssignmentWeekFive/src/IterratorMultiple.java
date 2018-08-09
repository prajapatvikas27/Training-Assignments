import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterratorMultiple {

	public static void main(String[] args) {
		HashMap hashmap = new HashMap();
		hashmap.put(3, "vk");
		hashmap.put(1, "vikas");
		hashmap.put(2, "kl");
		hashmap.put(5, "msd");
		hashmap.put(4, "hardik");
		Iterator itr = hashmap.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();
			System.out.println(pair.getKey()+ " = " + pair.getValue());
		}
		while(itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();
			System.out.println(pair.getKey()+ " = " + pair.getValue());
		}
		while(itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();
			System.out.println(pair.getKey()+ " = " + pair.getValue());
		}
	}

}
