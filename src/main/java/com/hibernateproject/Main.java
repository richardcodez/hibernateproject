package com.hibernateproject;

import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.hibernateproject.Laptop.class)
                            .configure()
                            .buildSessionFactory();

        Session session = sf.openSession();

        Laptop l1 = session.get(Laptop.class, 2);
        System.out.println(l1);
        

        session.close();

        Session s1 = sf.openSession();
        Laptop l2 = s1.get(Laptop.class, 2);
        System.out.println(l2);

        s1.close();
        sf.close();

    }
}



// public class Main {
//     public static void main(String[] args) {
        
//         Student s1 = new Student();
//         // s1.setsName("Anvit");
//         // s1.setsAge(29);
//         // s1.setRollno(109);

//         Student s2 = null;

//         // Configuration cfg = new Configuration();
//         // cfg.addAnnotatedClass(com.hibernateproject.Student.class);
//         // cfg.configure();

//         SessionFactory sf = new Configuration()
//                             .addAnnotatedClass(com.hibernateproject.Student.class)
//                             .configure()
//                             .buildSessionFactory();

//         Session session = sf.openSession();

//         Transaction transaction = session.beginTransaction();

//         // Transaction transaction = session.beginTransaction();    // for saving or updating database
//         // session.persist(s1);         // for saving data
//         // transaction.commit();

//         // s2 = session.get(Student.class, 102);        // fetching data
//         // session.merge(s1)        // updating or inserting if object does not exist
//         s1 = session.get(Student.class, 109);
//         session.remove(s1);
//         transaction.commit();

//         session.close();
//         sf.close();

//         System.out.println(s1);
//     }
// }