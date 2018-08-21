package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class Client {

	public static void main(String[] args) {


		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		
		
		Criteria c = s.createCriteria(Employee.class);
		
		List<Employee> list = c.list();
		
		for(Employee employee : list) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getEmail());
			System.out.println(employee.getSalary());
			System.out.println("------------------------------");
		}
		
		s.close();
		sf.close();

	}

}
