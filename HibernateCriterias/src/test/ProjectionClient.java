package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import beans.Employee;

public class ProjectionClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Criteria c = s.createCriteria(Employee.class);
		/*
		Projection p = Projections.property("name");
		c.setProjection(p);
		List<String> names = c.list();
		
		for(String name : names) {
			System.out.println(name);
		}
		*/
		
		Projection p1 = Projections.property("name");
		Projection p2 = Projections.property("salary");
		ProjectionList plist = Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
		c.setProjection(plist);
		
		List<Object[]> list = c.list();
		
		for(Object[] o :list) {
			
			System.out.println(o[0] + " " + o[1]);
			
		}
		
		Projection pavg = Projections.avg("salary");
		c.setProjection(pavg);
		double avg =(double) c.uniqueResult();
		System.out.println("Average salary: " + avg);
		
		Projection pmax = Projections.max("salary");
		c.setProjection(pmax);
		double max = (double) c.uniqueResult();
		System.out.println("Maximum salary: " + max);

		s.close();
		sf.close();

	}

}
