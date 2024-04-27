package com.hibernate.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			sf = new Configuration().configure().buildSessionFactory();
			s  = sf.openSession();
			tx = s.beginTransaction();

			
			
			// Create tables 
			Department d1 = new Department();
			d1.setName("Software");
			
			Employee e1 = new Employee("EMP001","Sreenu",23,"Nandiyal",d1);
			Employee e2 = new Employee("EMP001","Guna",24,"Trupati",d1);
			
			Set<Employee> employees = new HashSet<Employee>();
			
			employees.add(e1);
			employees.add(e2);
			
			d1.setLocation("A Block");
			d1.setEmployees(employees);
			
		/*	s.save(d1);
			
			s.save(e1);
			s.save(e2);
			
			System.out.println("Department Id : "+d1.getId()); */
			
			// display tables ;
			
			Employee pr1 = s.get(Employee.class, 1);
			Employee pr2 = s.get(Employee.class, 2);
			
			Department pr = s.get(Department.class, 1);
			
			System.out.println(pr1);
			System.out.println(pr2);
			System.out.println(pr);
			
			
			
			 
			
		}
		catch(HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			if(sf != null)
				if(tx != null)
					tx.commit();
			    sf.close();
			    
			if(s != null)
				s.close();
		}

	}

}
