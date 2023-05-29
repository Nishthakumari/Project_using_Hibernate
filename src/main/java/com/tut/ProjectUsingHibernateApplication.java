package com.tut;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProjectUsingHibernateApplication {

	public static void main(String[] args) {

		System.out.println("Hello world");

		Configuration cfg =new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println(factory);
		System.out.println(factory.isClosed());
	}

}
