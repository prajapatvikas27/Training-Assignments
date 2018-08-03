import java.lang.invoke.SwitchPoint;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Scanner;

public class AssignmentWeekTwo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("\t\t\t Welcome!");
		System.out.println("\n what problem do you want to solve:-");
		System.out.println("\t 1.Array Problems \t\t 2.String Problems");
		int choice = scan.nextInt();
		while(choice != 0) {
			switch (choice) {
			
			case 1:
				
				ArrayProblems arrayProblems = new ArrayProblems();
				System.out.println("\n Enter your problem name");
				String methodName = scan.next();
				if(ArrayProblems.isMethod(ArrayProblems.class, methodName)) {
					Method method = ArrayProblems.getMethod(ArrayProblems.class,methodName);
					Parameter[] parameters = method.getParameters();
					System.out.println("Enter the details of following parameters:-");
					for(int i=0; i<parameters.length;i++) {
						//System.out.printf("\t"+parameters[i].getName());
					//	System.out.println("Parameter type ="+ parameters[i].isNamePresent());
					System.out.printf("\t"+(i+1)+"."+ parameters[i].getName());
					}
					System.out.println();
					
					Object[] methodArgs = new Object[parameters.length];
					for(int i = 0;i<parameters.length;i++) {
						Type type = parameters[i].getType();
						String stringType = new String();
						boolean booleanType = true;
						
						if(type.toString().equals(stringType.getClass().toString())) {
							System.out.println("enter the value of"+parameters[i].getName());
							//stringArgs[i] = scan.next();
							methodArgs[i]=scan.next();
							
						}
						else if(type.toString().equals(boolean.class.toString())) {
							System.out.println("enter the value of"+parameters[i].getName());
							//booleanArgs[i] = scan.nextBoolean();
							methodArgs[i]=scan.nextBoolean();
						}	
						else if(type.toString().equals(int.class.toString())) {
							System.out.println("enter the value of "+parameters[i].getName());

							methodArgs[i]=scan.nextInt();
						}
						else if(type.toString().equals(int[].class.toString())) {
							System.out.println("enter the value of "+parameters[i].getName());
							System.out.println("eneter the length of the array you"
									+ "want to create");
							int lengthOfArray = scan.nextInt();
							int[] arrayArgs = new int[lengthOfArray]; 
							for(int j=0;j< lengthOfArray;j++) {
								System.out.println("enter "+(j+1)+" value");
								arrayArgs[j] = scan.nextInt();
							}
							methodArgs[i] = arrayArgs;
						}
						
						
						
					}
					/*System.out.println("parameters enterd are");
					for(int i = 0;i<parameters.length;i++) {
						System.out.println((i+1)+"."+stringArgs[i]);
					}*/

					try {
						method.invoke(arrayProblems, methodArgs);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					System.out.println("Enter Valid Method");
				}
				break;
				
			case 2:
				
				StringProblems stringProblems = new StringProblems();
				System.out.println("\n Enter your problem name");
				 methodName = scan.next();
				if(StringProblems.isMethod(StringProblems.class, methodName)) {
					Method method = StringProblems.getMethod(StringProblems.class,methodName);
					Parameter[] parameters = method.getParameters();
					System.out.println("Enter the details of following parameters:-");
					for(int i=0; i<parameters.length;i++) {
						//System.out.printf("\t"+parameters[i].getName());
					//	System.out.println("Parameter type ="+ parameters[i].isNamePresent());
					System.out.printf("\t"+(i+1)+"."+ parameters[i].getName());
					}
					System.out.println();
					
					Object[] methodArgs = new Object[parameters.length];
					for(int i = 0;i<parameters.length;i++) {
						Type type = parameters[i].getType();
						String stringType = new String();
						boolean booleanType = true;
						
						if(type.toString().equals(stringType.getClass().toString())) {
							System.out.println("enter the value of"+parameters[i].getName());
							//stringArgs[i] = scan.next();
							methodArgs[i]=scan.next();
							
						}
						else if(type.toString().equals(boolean.class.toString())) {
							System.out.println("enter the value of"+parameters[i].getName());
							//booleanArgs[i] = scan.nextBoolean();
							methodArgs[i]=scan.nextBoolean();
						}	
						else if(type.toString().equals(int.class.toString())) {
							System.out.println("enter the value of "+parameters[i].getName());

							methodArgs[i]=scan.nextInt();
						}
						
					}
					/*System.out.println("parameters enterd are");
					for(int i = 0;i<parameters.length;i++) {
						System.out.println((i+1)+"."+stringArgs[i]);
					}*/

					try {
						method.invoke(stringProblems, methodArgs);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					System.out.println("Enter Valid Method");
				}
							
				break;

			default:
				break;
			}
			System.out.println("\n what problem do you want to solve:-");
			System.out.println("\t 1.Array Problems \t\t 2.String Problems");
			choice = scan.nextInt();
		}
		
	}

}
