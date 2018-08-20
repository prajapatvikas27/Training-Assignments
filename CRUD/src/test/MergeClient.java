package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class MergeClient {

	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.get(Student.class, 111);
		
		Student st = new Student();
		
		st.setSid(111);
		st.setName("Vikas");
		st.setEmail("vkU@example.com");
		
		session.merge(st);
		transaction.commit();
		session.close();
		sf.close();
		


	}

}
