package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        Configuration cfg =new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Student student = session.load(Student.class, 102);
        System.out.println(student);

        Address ad = session.get(Address.class, 1);
        System.out.println(ad);
    }


}
