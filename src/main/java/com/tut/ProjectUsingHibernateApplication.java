package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProjectUsingHibernateApplication {

	public static void main(String[] args) {

		System.out.println("Hello world");

		Configuration cfg =new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		//creating student

		Student st =new Student();
		st.setId(102);
		st.setName("Nishtha");
		st.setCity("Lucknow");
		System.out.println(st);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(st);
		tx.commit();
		session.close();
	}

}
