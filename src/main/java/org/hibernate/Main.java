package org.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.Student;
//import javax.persistence;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Configuration con=new Configuration();
        con.addAnnotatedClass(Student.class);
        con.configure("hibernate.cfg.xml");
        con.buildSessionFactory();
        SessionFactory factory= con.buildSessionFactory();
//        SessionFactory fac=new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Student.class)
//                .buildSessionFactory();
//
//        /// insert
//        Session session= factory.openSession();
//        session.beginTransaction();
//        Student s=new Student();
//        s.setName("luffy");
//        s.setAge(22);
//        s.setCity("kkdi");
//        session.persist(s);
////        session2.close();
//        session.getTransaction().commit();
//
//        session.close();
//
//
//        Session session2= factory.openSession();
//        session2.beginTransaction();
//        Student s2=new Student();
//        s2.setName("john");
//        s2.setAge(23);
//        s2.setCity("cmb");
//        session2.persist(s2);
//        session2.getTransaction().commit();
//        session2.close();
////        session.close();
//        System.out.println(" Inserted!");
////

        ///  read all
//        Session s3=factory.openSession();
//         Student readall=s3.get(Student.class,2); // it alwsy retreive the same obj type if u store or another obj it gves error
//         System.out.println(readall);
//         s3.close();



         /// update
        Session s5=factory.openSession();
        s5.beginTransaction();
        Student toupdate=s5.get(Student.class,2);
        toupdate.setAge(30);
        s5.getTransaction().commit();
        s5.close();
        System.out.println("Updated");

//        /// delete
//        Session s6=factory.openSession();
//        s6.beginTransaction();
//        Student todelete=s6.get(Student.class,1);
//        s6.delete(todelete);
//        s6.getTransaction().commit();
//        s6.close();
//        System.out.println("Deleted Sucessfully");

         ///  read all
           Session session4=factory.openSession();
         session4.beginTransaction();


         List<Student> list=session4.createQuery("From Student",Student.class).list();
         for (Student student : list) {
             System.out.println(student);
         }
         session4.getTransaction().commit();
         session4.close();
Session session=factory.openSession();
Student s9=new Student("kishor",22,"kkdi");
session.beginTransaction();
session.persist(s9);
session.getTransaction().commit();
session.close();
System.out.println("Inserted successfully");

Session sessionnew=factory.openSession();
sessionnew.beginTransaction();
       Student sex=new Student("joesph",40,"bgl");
       sessionnew.persist(sex);
       sessionnew.getTransaction().rollback();
       sessionnew.close();

factory.close();
    }
}