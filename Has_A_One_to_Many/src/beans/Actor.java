package beans;

import java.util.Set;

public class Actor {
	
	private int aid;
	private String actorName;
	private Set<Movies> movies;
	public Actor() {
		super();
		
	}
	public Actor(int aid, String actorName, Set<Movies> movies) {
		super();
		this.aid = aid;
		this.actorName = actorName;
		this.movies = movies;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public Set<Movies> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	
	

}
