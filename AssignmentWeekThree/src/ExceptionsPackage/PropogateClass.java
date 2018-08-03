package ExceptionsPackage;

import java.util.Scanner;

public class PropogateClass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the food to test");
		String food = scan.next();
		BadFoodException badFood = new BadFoodException();
		try {
			badFood.checkFood(food);
		} catch (BadFoodException e) {
			System.out.println("Bad Food Exception");
		}
		finally {
			System.out.println("main method finally closed");
		}
	}

	private static String propogate(String string) {
		// TODO Auto-generated method stub
		
		if(string.length()<0) {
			Exception e = new Exception("new exception thrown");
		}
		String reverseStr = "";
		for(int i=string.length()-1;i>=0;--i) {
		reverseStr += string.charAt(i);
		}
		return reverseStr;
		
	}

}
