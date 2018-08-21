package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Actor;
import beans.Movies;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		Movies m1 = new Movies();
		m1.setMid(3);
		m1.setMovieName("chak de india");
		

		Movies m2 = new Movies();
		m2.setMid(4);
		m2.setMovieName("kal ho na ho");
		

		Set<Movies> movieSet = new HashSet<>();
		movieSet.add(m1);
		movieSet.add(m2);
		
		Actor actor = new Actor();
		actor.setAid(2);
		actor.setActorName("shah rukh khan");
		actor.setMovies(movieSet);
		
		session.save(actor);
		transaction.commit();
		session.close();
		sf.close();
	}

}
