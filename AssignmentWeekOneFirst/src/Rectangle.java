
public class Rectangle extends Shapes implements Operations {

	{
		
		System.out.println("Rectangle class called");;
	}
	
	float[] sides =new float[2];
	public Rectangle(float side1, float side2) {
		// TODO Auto-generated constructor stub
		this.sides[0] = side1;
		this.sides[1] = side2;
	}
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	
	
	public void setSides() {
		System.out.println("\tPlease Enter the value of rectangles side");
		sides[0] = sideScanner.nextFloat();
		sides[1] = sideScanner.nextFloat();
	}
	
	public float getArea() {
		// TODO Auto-generated method stub
		float area = 0;
		area = sides[0] * sides[1];
		return area;
	}

	@Override
	public float getPerimeter() {
		// TODO Auto-generated method stub
		float perimeter = 0;
		perimeter = 2 * (sides[0] + sides[1]);
		return perimeter;
	}
	
	

}
