package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		//SessionFactory sfFactory =
		cfg.buildSessionFactory();
		//Session session = sfFactory.openSession()
		

	}

}
