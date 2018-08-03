
public class Square extends Shapes implements Operations {
	{
		
			
			System.out.println("Square class called");;
	
	}
	private float side;
	
	public Square(float side) {
	// TODO Auto-generated constructor stub
	this.side = side;
	}

	public Square() {
		// TODO Auto-generated constructor stub
	}

	
	
	public void setSides() {
		
				System.out.println("\tPlease Enter the value of squares side");
				side = sideScanner.nextFloat();
	}

	public float getArea() {
		// TODO Auto-generated method stub
		float area = 0;
	    area = side * side;
		return area;
	}

	
	public float getPerimeter() {
		// TODO Auto-generated method stub
		float perimeter = 0;
		perimeter = 4 * side;
		return perimeter;
	}


	}
