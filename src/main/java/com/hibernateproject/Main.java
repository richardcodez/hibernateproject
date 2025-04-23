package com.hibernateproject;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // Laptop l1 = new Laptop();
        // l1.setLid(4);
        // l1.setBrand("Asus");
        // l1.setModel("Strix");
        // l1.setRam(32);

        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.hibernateproject.Alien.class)
                            .addAnnotatedClass(com.hibernateproject.Laptop.class)
                            .configure()
                            .buildSessionFactory();

        Session session = sf.openSession();

        // select * from laptop where ram=32
        // HQL
        // from Laptop where ram=32

        String brand = "Asus";
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Object[]> laptops = query.getResultList();

        // Laptop l1 = session.get(Laptop.class, 3);
        for(Object[] laptop : laptops) {
            System.out.println((String)laptop[0] + ", " + laptop[1]);
        }
        // System.out.println(laptops);

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