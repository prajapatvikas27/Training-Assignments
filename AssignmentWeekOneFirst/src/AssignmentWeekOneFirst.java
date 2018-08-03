import java.util.Scanner;

public class AssignmentWeekOneFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		System.out.println("\t\t This Console Application Calculates Area and P"
				+ "erimeter of Different Shapes ");
		System.out.println("\t what do you want to do:-\t 1.Area\t 2.Perimeter\t0.Exit");
		
		int choice = scan.nextInt();
		while(choice != 0) {
		switch (choice) {
		case 1:
			System.out.println("\t Select one shape\t\n 1.Square \t2.Rectangle\t3.Circle");	
			choice = scan.nextInt();
			
			switch (choice) {
			case 1:
			
				Square square= new Square();
				square.setSides();
				System.out.println("\t Area of the Square is:  "+square.getArea());
				break;
				
			case 2:
				
				
				Rectangle rectangle = new Rectangle();
				rectangle.setSides();
				System.out.println("\t Area of the rectangle is:  "+rectangle.getArea());
				break;
				
			case 3:
				Circle circle = new Circle();
				circle.setSides();
				System.out.println("\t Area of the Circle is:  "+circle.getArea());
				break;
			default:
				System.out.println("wrong option");
				break;
			}	
			break;
			
		case 2:
	System.out.println("\t Select one shape\t\n 1.Square \t2.Rectangle\t3.Circle");	
			
			choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				
				Square square= new Square();
				square.setSides();
				System.out.println("\t Perimeter of the Square is:  "+square.getPerimeter());
				break;
				
			case 2:
				
				Rectangle rectangle = new Rectangle();
				rectangle.setSides();
				System.out.println("\t Perimeter of the rectangle is:  "+rectangle.getPerimeter());
				break;
				
			case 3:
				float radius;
				System.out.println("\tPlease Enter the value of rectangles side");
				radius = scan.nextFloat();
				Circle circle = new Circle(radius);
				System.out.println("\t Perimeter of the Circle is:  "+circle.getPerimeter());	
				break;
			default:
				System.out.println("wrong option");
				break;
			}
			

			break;
		default:
			System.out.println("wrong option");
			break;
		}
		
		
		System.out.println("\t what do you want to do:-\t 1.Area\t 2.Perimeter\t0.Exit");
		choice = scan.nextInt();
		}
		System.out.println("\t Bye! Thank You!0");

	}

}
