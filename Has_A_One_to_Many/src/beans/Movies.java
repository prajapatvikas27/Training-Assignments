package beans;

public class Movies {

	private int mid;
	private String movieName;
	
	public Movies() {
		super();
	}
	
	public Movies(int mid, String moviename) {
		super();
		this.mid = mid;
		this.movieName = moviename;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	
	
}
