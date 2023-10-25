package com.rajan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeData {


	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		
		Transaction tran=session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setName(297);
		session.persist(emp);
		tran.commit();
		session.close();
	}

}
