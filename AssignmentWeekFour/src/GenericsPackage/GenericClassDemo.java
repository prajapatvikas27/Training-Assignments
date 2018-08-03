package GenericsPackage;

public class GenericClassDemo {

	public static void main(String[] args) {
		
		
		GenClass gStr = new GenClass("String");
		GenClass gInt = new GenClass(1);
		GenClass gDouble = new GenClass(3.0);
		GenClass gBool = new GenClass(true);
		GenClass gChar = new GenClass('c');
		GenClass gStu = new GenClass(new Student());
		GenClass gGenC = new GenClass(new GenClass(gStr));
		
		System.out.println("gstr : "+gStr);
		System.out.println("gstr : "+gInt);
		System.out.println("gstr : "+gDouble);
		System.out.println("gstr : "+gBool);
		System.out.println("gstr : "+gChar);
		System.out.println("gstr : "+gStu);
		System.out.println("gstr : "+gGenC);

	}

}

class GenClass<T>{
	
	T obj;
	
	GenClass(T obj){
		this.obj = obj;
	}
	
	@Override
	public String toString() {
		return obj.getClass().getName();
	}
	
}

class Student{}
