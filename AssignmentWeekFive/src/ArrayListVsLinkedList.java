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
	String threadName;
	
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

}

class Operation{
	
	
	ReentrantLock l = new ReentrantLock();
	
	public long traverse(List<?> list) {
		l.lock();
		System.out.println(Thread.currentThread().getName()+" got traversal lock");
		try {
			
			long startTime = System.nanoTime();
			
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
			
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			
			return totalTime;
		}
		finally {
			System.out.println(Thread.currentThread().getName()+" releases traversal lock");
			l.unlock();
		}
		
	}

	public long sort(List<String> list) {
		l.lock();
		System.out.println(Thread.currentThread().getName()+" got  sort  lock");
		try {
			long startTime = System.nanoTime();
			long endTime   = System.nanoTime();
			Collections.sort(list);
			long totalTime = endTime - startTime;
			
			return totalTime;
		}finally {
			System.out.println(Thread.currentThread().getName()+" released sort lock");
			l.unlock();
		}
	}

	public long insert(String[] collectionString, List<String> list) {
		l.lock();
		System.out.println(Thread.currentThread().getName()+" got insert lock");
		try {
			long startTime = System.nanoTime();
			for(String str : collectionString) {
				list.add(str);
			}
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			
			return totalTime;
		}
		finally {
			System.out.println(Thread.currentThread().getName()+" released insert lock");
			l.unlock();
		}
	
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
