package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import beans.Employee;

public class HqlTable_Table {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
	/*	Employee emp1 = new Employee(111,"vikas", "vikas@example.com", 1000000000000.0);
		Employee emp2 = new Employee(222,"ramesh", "ra@example.com", 1000000000.0);		
		Employee emp3 = new Employee(333,"suresh", "su@example.com", 200000000.0);
		Employee emp4 = new Employee(444,"jeet", "jee@example.com", 30000000000.0);

		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		
		t.commit();
		*/
		String hql = "insert into NewEmployee(id,name,email,salary) select e.id,e.name,e.email,e.salary from Employee e";
		
		Query q = session.createQuery(hql);
		int i = q.executeUpdate();
		System.out.println(i);
		
		
		session.close();
		sf.close();
		
	}

}
