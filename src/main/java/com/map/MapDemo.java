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

//
//
//        Question q1 = new Question();
//        q1.setQuestionId(1212);
//        q1.setQuestion("what is java?");
//
//        //creating answer
//
//        Answer a1 = new Answer();
//        a1.setAnswerId(343);
//        a1.setAnswer("Java is a programming language.");
//        a1.setQuestion(q1);
//
//        Answer a2 = new Answer();
//        a2.setAnswerId(363);
//        a2.setAnswer("With the help of java, we can create softwares.");
//        a2.setQuestion(q1);
//
//        Answer a3 = new Answer();
//        a3.setAnswerId(373);
//        a3.setAnswer("Java has different type of frameworks.");
//        a3.setQuestion(q1);
//
//        List<Answer> list = new ArrayList<Answer>();
//        list.add(a1);
//        list.add(a2);
//        list.add(a3);
//
//
//        q1.setAnswers(list);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

//        s.save(q1);
//        s.save(a1);
//        s.save(a2);
//        s.save(a3);

        Question q = s.get(Question.class, 1212);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());

        System.out.println(q.getAnswers().size());


        tx.commit();
        s.close();
        factory.close();

    }
}
