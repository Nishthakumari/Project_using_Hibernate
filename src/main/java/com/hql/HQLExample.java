package com.hql;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
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


        System.out.println("_______________________________________________________________________");

        Transaction tx = s.beginTransaction();
//        Query q2 = s.createQuery("delete from Student s where s.city=:c");
//        q2.setParameter("c", "ABC");

        //delete query
//        int r =q2.executeUpdate();
//        System.out.println("Deleted");
//        System.out.println(r);
//        tx.commit();

        //update query

        Query q2 = s.createQuery("update Student set city=:c where name=:n");
        q2.setParameter("c", "Delhi");
        q2.setParameter("n", "Peter");
        int r = q2.executeUpdate();
        System.out.println(r + "  Object updated");
        tx.commit();

        Query q3 = s.createQuery("select q.question, q.questionId, a.answer from Question " +
                "as q INNER JOIN q.answers as a ");


         List<Object[]> list3 = q3.getResultList();

        for(Object[] arr: list3)
        {

            System.out.println(Arrays.toString(arr));
        }
        s.close();
        factory.close();
    }
}
