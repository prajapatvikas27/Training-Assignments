import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class MyarrayList implements Runnable{

	ArrayList<String> al = new ArrayList<>();
	String[] collectionString;
	Operation op;
	
	public MyarrayList(Operation op, String[] collectionString) {
		this.collectionString = collectionString;
		this.op = op;
	}



	@Override
	public void run() {
		System.out.println("Time to insert elements in ArrayList:" + op.insert(collectionString,al));
		System.out.println("Time to sort elements in ArrayList:" + op.sort(al) );
		System.out.println("Time to traverse elements in ArrayList:" + op.traverse(al));
	}

	

/*	private void traverse(ArrayList<String> al) {
		long startTime = System.nanoTime();
		Iterator<String> itr = al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time taken to traverse ArrayList:" + totalTime);
	}



	private void sort(ArrayList<String> al2) {

		long startTime = System.nanoTime();
		Collections.sort(al2);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time required by ArrayList for natural sorting:" + totalTime);
	}



	public void insert(String[] collectionString) {
		long startTime = System.nanoTime();
		for(String str : collectionString) {
			al.add(str);
		}
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Arraylist required time to insert :" + totalTime);
	}
	
	*/
}

class MyLinkedList implements Runnable{
	LinkedList<String> ll = new LinkedList<>();
	String[] collectionString;
	Operation op;
	public MyLinkedList(Operation op, String[] collectionString) {
		this.collectionString = collectionString;
		this.op = op;
	}
	
	@Override
	public void run() {
		System.out.println("Time to insert elements in LinkedList:" + op.insert(collectionString,ll));
		System.out.println("Time to sort elements in LinkedList:" + op.sort(ll) );
		System.out.println("Time to traverse elements in LinkedList:" + op.traverse(ll));
	}

/*	private void traverese(LinkedList<String> ll) {

		long startTime = System.nanoTime();
		
		Iterator itr = ll.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time taken to traverse linked list:" + totalTime);
	}
*/
	/*private void sort(LinkedList<String> ll) {
		long startTime = System.nanoTime();
		Collections.sort(ll);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time taken to sort LinkedLsit:" + totalTime);
	}
*/
/*	private void insert(String[] collectionString) {
		
		long startTime = System.nanoTime();
		
		for(String str : collectionString) {
			ll.add(str);
		}
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time taken to insert elements in Linked list:" + totalTime);
	}
	
	*/
}

class Operation{
	
	
	ReentrantLock l = new ReentrantLock();
	
	public long traverse(List<?> list) {
		l.lock();	
		long startTime = System.nanoTime();
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		l.unlock();
		return totalTime;
	}

	public long sort(List<String> list) {
		l.lock();
		long startTime = System.nanoTime();
		long endTime   = System.nanoTime();
		Collections.sort(list);
		long totalTime = endTime - startTime;
		l.unlock();
		return totalTime;
	}

	public long insert(String[] collectionString, List<String> list) {
		l.lock();
		long startTime = System.nanoTime();
		for(String str : collectionString) {
			list.add(str);
		}
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		l.unlock();
		return totalTime;
	}
	
}


public class ArrayListVsLinkedList {

	public static void main(String[] args) {
		String[] collectionString = {"fifth","fourth","seventh","rubbish","kailash"};
		Operation op = new Operation();
		MyarrayList al = new MyarrayList(op,collectionString);
		MyLinkedList ll = new MyLinkedList(op,collectionString);
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(al);
		service.submit(ll);
		service.shutdown();
	}

}
