
public final class ImmutableClass {

	
	    final String name;
	    final int regNo;
	 
	    public ImmutableClass(String name, int regNo)
	    {
	        this.name = name;
	        this.regNo = regNo;
	    }
	    public String getName()
	    {
	        return name;
	    }
	    public int getRegNo()
	    {
	        return regNo;
	    }
	
	public static void main(String[] args) {
		
			ImmutableClass s = new ImmutableClass("vikas", 2);
	        System.out.println(s.name);
	        System.out.println(s.regNo);
		
		
	}

}
