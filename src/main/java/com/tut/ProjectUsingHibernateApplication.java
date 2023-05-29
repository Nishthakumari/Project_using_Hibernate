package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Date;

public class ProjectUsingHibernateApplication {

	public static void main(String[] args) throws IOException {

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

		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(123.123);

		//Reading image
//		FileInputStream fis = new FileInputStream("src/main/java/me.jpeg");
//		byte[] data = new byte[fis.available()];
//		fis.read(data);
//		ad.setImage(data);


		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
	}

}
