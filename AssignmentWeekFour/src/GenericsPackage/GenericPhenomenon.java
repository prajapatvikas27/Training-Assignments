package GenericsPackage;

import java.util.ArrayList;

/* This program demonstrates that generics is a compile time phenomenon and not
   run time phenomenon
 */

public class GenericPhenomenon {

	public static void show(ArrayList<String> al) {
		
		System.out.println(al);
		
	}
	
	/*
	public static void show(ArrayList<Integer> al) {
	}
	
	Declaration of above method produces compile time error stating:
	Erasure of method show(ArrayList<Integer>) is the same as another method
	in type GenericPhenomenon
	
	This happens because of three steps during compile time process:
	1.Compile with generics signature
	2.Remove generic signature
	3.Recompile without generic signature
	
	Thus both show will have same erasure after recompilations and thus proving
	generics is compile time phenomenon.
	*/
	
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList<String>();
		al.add("vikas");
		al.add("havana");
	/*1.*/	al.add(10);
	/*2.*/	al.add(12.5);
	/*3.*/	al.add(true);
		
	/* The statements marked 1,2 and 3 won't produce any errors neither at
	   compile time nor at run time even though we are adding different 
	   type of object than what we mentioned at generic signature because 
	   at compile time compiler checks errors based on references where we
	   have declared a non-generic ArrayList and after compilation removes
	   generic signature thus making it non-generic at even run time, thus
	   resulting in no errors.
	   
	   The above conclusion proves that generics is compile time phrnomenon
	   and not run-time phenomenon*/
	
		show(al);

	}

}
