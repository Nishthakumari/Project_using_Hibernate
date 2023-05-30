package com.states;

import com.tut.Certificate;
import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StateDemo {
    public static void main(String[] args) {
        //practical of Object Hibernate State
        //Transient
        //Persistent
        //Detached
        //Removed

        System.out.println("Example  : ");

        SessionFactory f = new Configuration().configure().buildSessionFactory();

        //creating student object
        Student student = new Student();
        student.setId(1414);
        student.setName("Peter");
        student.setCity("ABC");
        student.setCerti(new Certificate("Java  Hibernate Course","2 months"));
        //student: Transient state

        Session s = f.openSession();
        Transaction tx = s.beginTransaction();
        s.save(student);
        //student - Persistent - session, database

        student.setName("John");

        tx.commit();
        s.close();

        student.setName("Sachin");
        System.out.println(student.getName());
        f.close();

    }
}
