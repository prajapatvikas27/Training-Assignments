package CollectionsPackage;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	
	
	public static void main(String[] args) throws InterruptedException {
		
		WeakHashMap whmap = new WeakHashMap();
		Student fStu = new Student(1, "aditi");
		whmap.put(fStu, "passed");
		whmap.put(new Student(2,"rahul"), "Passed");
		whmap.put(new Student(5,"rupali"), "failed");
		whmap.put(new Student(7,"Sandeep"), "Passed");
		whmap.put(new Student(4,"rachel"), "Passed");
		System.out.println("duplicate entries allowed:"
				+ " "+ whmap.put(new Student(2,"rahul"), "Passed"));
		System.out.println("null insertion allowed:"
				+ " "+whmap.put(null, "null"));
		System.out.println("heterogeneous entries allowwed: "
				+ ""+whmap.put("hetro", "Passed"));
		System.out.println("Before callig garbage collector:");
		System.out.println(whmap);
		
		System.gc();
		Thread.sleep(5000);
		System.out.println("After Garbage Collection:");
		System.out.println(whmap);
	}

}
class Student implements Comparable{
	int rno;
	String name;
	
	Student(int rollno, String name){
		this.rno = rollno;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.rno+" = "+this.name;
	}
	
	@Override
	public int hashCode() {

		return this.rno;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method called");
	}

	@Override
	public int compareTo(Object arg0) {
		Student stu = (Student) arg0;
		if(this.rno < stu.rno) {
			return -1;
		}
		else if(this.rno > stu.rno) {
			return 1;
		}
		return 0;
	}
}
