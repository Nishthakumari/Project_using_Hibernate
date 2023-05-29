package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

    public static void main(String[] args) {
        Configuration cfg =new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Student student = new Student();
        student.setId(14234);
        student.setName("Rimmi ");
        student.setCity("Kanpur");

        Certificate certificate = new Certificate();
        certificate.setCourse("Spring");
        certificate.setDuration( "2 months");

        student.setCerti(certificate);

        Student student1 = new Student();
        student1.setId(12223);
        student1.setName("Mugdha ");
        student1.setCity("Manpur");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Spring Boot");
        certificate1.setDuration( "1.2 months");

        student1.setCerti(certificate1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(student1);

        tx.commit();
        session.close();

        factory.close();

    }
}
