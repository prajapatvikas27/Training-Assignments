import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class StringProblems {
	
	public StringProblems() {
		
		
		System.out.println("\t List of String Problems:-");
		showProblemList();
		//System.out.println("finished Constructor");

		
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

	enum StringProblemList {
		HELLONAME{
			
			public String toString() {
				
				return "helloName";
			}
			
		},
		
		MAKEABBA{
			
			public String toString() {
				return "makeAbba";
			}
			
		},
		
		MAKETAGS{
			public String toString() {
				return "makeTags";
			}
		},
		
		MAKEOUTWORD{
			@Override
			public String toString() {
				return "makeOutWord";
			}
		},
		
		EXTRAEND{
			@Override
			public String toString() {
				
				return "extraEnd";
			}
		},
		
		FIRSTTWO{
			@Override
			public String toString() {
				
			return "firstTwo";
			}
		},
		
		FIRSTHALF{
			@Override
			public String toString() {
				return "firstHalf";
			}
		},
		
		WITHOUTEND{
			@Override
			public String toString() {
				return "withoutEnd";
			}
		},
		
		COMBOSTRING{
			@Override
			public String toString() {
				return "comboString";
			}
		},
		
		NONSTART{
			@Override
			public String toString() {
				return "nonStart";
			}
		},
		
		LEFT2{
			@Override
			public String toString() {
				return "left2";
			}
		},
		
		RIGHT2{
			@Override
			public String toString() {
				return "right2";
			}
		},
		
		THEEND{
			@Override
			public String toString() {
				return "theEnd";
			}
		},
		
		WITHOUEND2{
			@Override
			public String toString() {
				return "withouEnd2";
			}
		},
		
		MIDDLETWO{
			@Override
			public String toString() {
				return "middleTwo";
			}
		},
		
		ENDSLY{
			@Override
			public String toString() {
				return "endsLy";
			}
		},
		
		NTWICE{
			@Override
			public String toString() {
				return "nTwice";
			}
		};
			
		
		
		
	}
	
	public ArrayList<String> getProblemList(){
		StringProblemList[] stringProblemList = StringProblemList.values();
		ArrayList<String> problemList = new ArrayList<String>();
		for(StringProblemList list: stringProblemList) {
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
	
	public void helloName(String name) {
		   System.out.println("Hello "+name);
		}
	
	public void extraEnd(String Name) {
			
		String result = Name.substring(Name.length()-2, Name.length());
		System.out.println(result+result+result);
	
	}
	
	public void makeAbba(String a, String b) {
			System.out.println(a+b+b+a);
		}
	
	public void makeTags(String tag, String word) {
			System.out.println("<"+tag+">"+word+"</"+tag+">"); 
		}
	
	public void makeOutWord(String out, String word) {
		System.out.println(out.substring(0, 2)+word+out.substring(2,4));
	}
	
	public void firstTwo(String string) {
		if(string.length()<2) {
			System.out.println(string);
		}else {
			System.out.println(string.substring(0,2));
		}
	}
	
	public void firstHalf(String string) {
		System.out.println(string.substring(0, string.length()/2));
	}
	
	public void withoutEnd(String string) {
		System.out.println(string.substring(1, string.length()-1));
	}
	
	public void comboString(String firstString, String secondString) {
		if(firstString.length()>secondString.length()) {
			System.out.println(secondString+firstString+secondString);
		}else {
			System.out.println(firstString+secondString+firstString);
		}
	}
	
	public void nonStart(String firstString, String secondString) {
		System.out.println(firstString.substring(1)+secondString.substring(1));
	}
	
	public void left2(String string) {
		System.out.println(string.substring(2)+string.substring(0, 2));
	}
	
	public void right2(String string) {
		System.out.println(string.substring(string.length()-2)+string.substring(0, string.length()-2));
	}
	
	public void theEnd(String string, boolean front) {
		if(front) {
			System.out.println(string.substring(0,1));
		}else {
			System.out.println(string.substring(string.length()-1));
		}
	}
	
	public void withouEnd2(String string) {
		if(string.length()>2) {
			System.out.println(string.substring(1, string.length()-1));
		}
		System.out.println("");
	}
	
	public void middleTwo(String string) {
		 	System.out.println(string.substring((string.length()/2)-1,string.length()/2+1));
		}
	
	public void endsLy(String string) {
			if(string.length() >= 2) {
				if(string.substring(string.length()-2).equals("ly")) {
				System.out.println("It ends in ly");
			}else {
				System.out.println("It does not end in ly");
			}
		}
	}
	
	public void nTwice(String string, int n) {
		String firstString, secondString;
		firstString = string.substring(0,n);
		secondString = string.substring(string.length()-n);
		System.out.println(firstString + secondString);
	}
}
