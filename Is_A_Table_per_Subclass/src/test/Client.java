package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.AdminEmployee;
import beans.HardwareEmployee;
import beans.SoftwareEmployee;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		SoftwareEmployee softwareEmployee = new 
				SoftwareEmployee(111, "vikas", "vk@eg.com", 50000,"hibernate");
		
		HardwareEmployee hardwareEmployee = new
				HardwareEmployee(222, "Rajesh", "rj.example.com", 121221.0, 8);
		
		AdminEmployee adminEmployee = new 
				AdminEmployee(333, "Arora", "ar.example.com", 34500, "cs");
		
		session.save(softwareEmployee);
		session.save(hardwareEmployee);
		session.save(adminEmployee);
		
		transaction.commit();
		session.close();
		sf.close();
		
	}

}
