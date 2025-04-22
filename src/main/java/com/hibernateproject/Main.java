package com.hibernateproject;

import org.hibernate.cfg.Configuration;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);
        
        // comment

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Macbook");
        l3.setModel("Air");
        l3.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Navin");
        a1.setTech("Java");

        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Harsh");
        a2.setTech("Python");

        Alien a3 = new Alien();
        a3.setAid(103);
        a3.setAname("Kiran");
        a3.setTech("AI");

        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l1, l3));
        a3.setLaptops(Arrays.asList(l1));

        l1.setAlien(Arrays.asList(a1, a3));
        l2.setAlien(Arrays.asList(a1, a2));
        l3.setAlien(Arrays.asList(a2));

        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.hibernateproject.Alien.class)
                            .addAnnotatedClass(com.hibernateproject.Laptop.class)
                            .configure()
                            .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();

        Alien a4 = session.get(Alien.class, 102);
        System.out.println(a4);

        session.close();
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