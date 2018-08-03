package ExceptionsPackage;

import java.util.Scanner;

class TooYoungException extends RuntimeException{
	
	public TooYoungException(String s) {
		super(s);
	}
	
}

class TooOldException extends RuntimeException{
	
	public TooOldException(String s) {
		super(s);
	}
	
}

public class CustException {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your age");
		
		int age = scan.nextInt();
		if(age > 60) {
			throw new TooYoungException("Please wait for sometime, You will get the best match");
		}
		else if(age < 18) {
			throw new TooYoungException("You have already crossed the marrige age!!!");

		}
		else {
			System.out.println("You will soon recieve your match details by e-mail...!");
		}

	}

}
