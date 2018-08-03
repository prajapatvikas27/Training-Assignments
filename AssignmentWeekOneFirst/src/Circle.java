
public class Circle extends Shapes implements Operations {
	{
		
		System.out.println("Circle class called");;
	}
	private	float radius=0;
	
	public Circle(float radius) {
		this.radius = radius;
	}
	
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	
	public float getRadius() {
		return radius;
	}
	
	
	public void setSides() {
		System.out.println("\tPlease Enter the value of circle radius") ;
		radius = sideScanner.nextFloat();
	}
	
	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		float area=0;
		area = pi * radius * radius; 
		return area;
	}
	@Override
	public float getPerimeter() {
		// TODO Auto-generated method stub
		float perimeter = 0;
		perimeter = 2 * pi * radius;
		return perimeter;
	}

	

	


}
