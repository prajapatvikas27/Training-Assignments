package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HqlUpdatePrimaryIdClient {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		String hql = "update Employee set id = '112' name = 'ramesh', email = 'ru@example.com' where id = 111";
		
		Query q = session.createQuery(hql);
		int i = q.executeUpdate();
		t.commit();
		System.out.println(i);
		
		
		session.close();
		sf.close();

	}

}
