import java.lang.reflect.Method;
import java.util.ArrayList;


public class ArrayProblems {
	
	public ArrayProblems() {
		
		System.out.println("List of Problems:-");
		showProblemList();

	}
	private void showProblemList() {
		
		ArrayList<String> problemList = getProblemList();
		for(int i=0;i<problemList.size();i++) {
			if(i%4 == 0) {
				System.out.println("");
			}
			int count = i+1;
			System.out.printf("\t"+count+"."+problemList.get(i));
		}
		
		//System.out.println("finished showProblemList");
	}

	enum ArrayProblemList {
		FIRSTLAST6{
			
			public String toString() {
				
				return "firstLast6";
			}
			
		},
		
		SAMEFIRSTLAST{
			
			public String toString() {
				return "sameFirstLast";
			}
			
		},
		
		COMMONEND{
			public String toString() {
				return "commonEnd";
			}
		},
		
		ROTATElEFT{
			@Override
			public String toString() {
				return "rotateLeft";
			}
		},
		
		
			
		
	}
	
	public ArrayList<String> getProblemList(){
		ArrayProblemList[] arrayProblemList = ArrayProblemList.values();
		ArrayList<String> problemList = new ArrayList<String>();
		for(ArrayProblemList list: arrayProblemList) {
		problemList.add(list.toString());	
		}
		return problemList;
	}
	
	public static boolean isMethod(Class<?> clazz, String methodName)
    {
       

        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method declaredMethod: declaredMethods)
        {
            if (declaredMethod.getName().equals(methodName))
            {
                return true;
            }
        }
        return false;
    }
	
	public static Method getMethod(Class<?> clazz, String methodName) {
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(Method declareMethod : declaredMethods) {
			if(declareMethod.getName().equals(methodName)) {
				return declareMethod;
			}
		}
		
		return null;
		
	}
	
	public void firstLast6(int[] nums) {
			
		  if(nums[0] == 6 || nums[nums.length-1] == 6){
		    System.out.println("6 is present at first or last position");
		  }
		  else {
			System.out.println("6 not present at first and last position");  
		  }
		 
	}
	
	
	public void sameFirstLast(int[] nums) {
		if(nums.length >= 1 && (nums[0] == nums[nums.length-1])){
		    System.out.println("first and last elements are same");
		  }
		else {
			System.out.println("first and last element not same");  
		  }
		  
	}
	
	public void commonEnd(int[] array1, int[] array2) {
		if(array1[0] == array2[0] || array1[array1.length-1] == array2[array2.length-1]){
			System.out.println("They both have common ends");
			}
		else{
			System.out.println("They both dont have same ends");	
			}
			
	}
	
	public void rotateLeft(int[] array) {
		int[] result = new int[array.length];
		System.out.println("Original array is");
		for(int i = 0;i<array.length;i++) {
			System.out.print(" "+array[i]);
		}
		if(array.length>=2) {
			
			result[array.length-1] = array[0];
			for(int i = 0; i < array.length-1 ; i++ ) {
				result[i] = array[i+1];
			}
			
			System.out.println("\n Left rotated array is");
			for(int i = 0;i<array.length;i++) {
				System.out.print(" "+result[i]);
			}
		}
		else {
			System.out.println("\n Left rotated array is");
			for(int i = 0;i<array.length;i++) {
				System.out.println(" "+array[i]);
			}
		}
		
	}
	
}
