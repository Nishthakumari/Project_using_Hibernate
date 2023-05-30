package com.hql;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLExample {

    public static void main(String[] args) {
        Configuration cfg  = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Session s = factory.openSession();
        //HQL
        //Syntax:

        String query = "from Student where city=:x ";
        Query q = s.createQuery(query);
        q.setParameter("x", "Manpur");

        //single - unique
        //multiple - list

        List<Student> list = q.list();

        for(Student student: list)
        {
            System.out.println(student.getName());
        }


        s.close();
        factory.close();
    }
}
