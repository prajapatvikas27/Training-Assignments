package CollectionsPackage;
import java.awt.List;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.sound.midi.Soundbank;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList alist = new ArrayList();
		System.out.println(alist.isEmpty());
		for(int i = 0; i <= 10;i++) {
			if (i%2 == 0) {
				alist.add(i-1);
			}else {
				alist.add(i+1);
			}
		}
		alist.add(null);
		alist.add("a");
		System.out.println(alist.isEmpty());
		System.out.println(alist);
		System.out.println(alist.size());
		alist.get(0);
		System.out.println(alist.set(11, 33)+" replaced");
		System.out.println(alist.set(12, 400)+" replaced");
		System.out.println("duplicate entry:"+alist.add(33));
		System.out.println(alist);
		ArrayList evenList = new ArrayList();
		ArrayList oddList = new ArrayList();
		ListIterator litr = alist.listIterator();
		
		while(litr.hasNext()) {
			int i = (int) litr.next();
			if(i % 2 == 0) {
				evenList.add(i);
			}else {
				oddList.add(i);
			}
			
		}
		System.out.println("original List:"+alist);
		System.out.println("even List:"+evenList);
		System.out.println("oddList:"+oddList);
		System.out.println("In reverse order");
		while (litr.hasPrevious()) {
			int i = (int) litr.previous();
			System.out.print(" "+i);
			
		}
		System.out.println("\narray list contains 33:"+alist.contains(33));
		System.out.println("removed from list:"+alist.remove(3));
		System.out.println("array list contains 33:"+alist.contains(33));
		alist.clear();
		System.out.println("After clear alist:"+alist);
	}

}
