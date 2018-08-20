package beans;

public class Student {

	private int sid;
	private String sname;
	private String semail;
	private int smarks;
	
	public Student() {
		
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public int getSmarks() {
		return smarks;
	}

	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}
	
	
	
}
