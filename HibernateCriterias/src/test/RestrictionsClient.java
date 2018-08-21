package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class RestrictionsClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Criteria c = s.createCriteria(Employee.class);
		Criterion cr = Restrictions.eq("id", 111);
		/*		c.add(cr);
		Employee employee = (Employee) c.uniqueResult();
		System.out.println("Single Object through Restriction..............");
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSalary());
		System.out.println("------------------------------");
		*/
		cr = Restrictions.gt("salary", 10.0);
		c.add(cr);
		System.out.println("Multiple Object through Restriction..............");
		List<Employee> list = c.list();
		
		for(Employee employee1 : list) {
			
			System.out.println(employee1.getId());
			System.out.println(employee1.getName());
			System.out.println(employee1.getEmail());
			System.out.println(employee1.getSalary());
			System.out.println("------------------------------");
		}
		
		
		s.close();
		sf.close();
	}

}
