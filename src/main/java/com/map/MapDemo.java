package com.map;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {
        Configuration cfg  = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        //creating question

        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("what is java?");

        //creating answer

        Answer a1 = new Answer();
        a1.setAnswerId(343);
        a1.setAnswer("Java is a programming language.");
        q1.setAnswer(a1);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        s.save(q1);
        s.save(a1);

        tx.commit();
        s.close();
        factory.close();

    }
}
