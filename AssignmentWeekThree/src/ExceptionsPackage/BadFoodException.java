package ExceptionsPackage;

public class BadFoodException extends Exception{

	public void checkFood(String food) throws BadFoodException{
		
		switch(food){
			
			case "Grapes":
			case "Mango":
			case "Rasberry":
				System.out.println("love the food");
				break;
			default:
			throw new BadFoodException();
				
			
		}
	}
	
	
}
