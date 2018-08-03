package GenericsPackage;

import java.util.ArrayList;

/* This program demonstrates the behavior of generic object in generic and no-generic area. */


public class GenericsBehaviour {

	static void test(ArrayList al) {
		// Generic object behaving non-generic in non-generic area
		
		//any type of abject can be added here to ArrayList
		//thus ArrayList here displays non-generic behavior
		
		al.add(10);
		al.add(12.4);
		al.add(false);
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<>();
		al.add("vikas");
		al.add("camilla");
		al.add("enrique");
		System.out.println("before sending al to non-generic area: "+al);
	/*	
	  	Generic object behaving like generic object in generic area
	 
	  	al.add(10);
		al.add(12.5);
		al.add(true);
		
		All these statements results in compile time error stating CE: The method add(String)
		in the type ArrayList<String> is not applicable for the arguments (type)
		*/
		test(al);
		System.out.println("after sending al to non-generic area"+al);
		
		/*	al.add(10);
		al.add(12.5);
		al.add(true);
		
		All these statements will still result in compile time error stating
		CE: The method add(String)in the type ArrayList<String> is not applicable 
		for the arguments (type)
		because the list is back in generic area
		*/
		
	}

}
