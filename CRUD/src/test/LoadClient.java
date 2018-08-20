package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class LoadClient {

	public static void main(String[] args) {
		
		
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Object o = session.load(Student.class, 111);
		
		Student st = (Student) o ;
		System.out.println(st.getSid());
		System.out.println(st.getSid() + " " + st.getName() + " " + st.getEmail());
		
		session.update(st);
		transaction.commit();
		session.close();
		sf.close();
		

	}

}
