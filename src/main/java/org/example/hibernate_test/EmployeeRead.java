package org.example.hibernate_test;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeRead {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class,3);
//            List <Employee> allEmployees = session.createQuery("from Employee").getResultList();
            List <Employee> allEmployees = session.createQuery("from Employee " + "where name = 'Irina' AND salary>800").getResultList();
            for(Employee e: allEmployees){
                System.out.println(e);
            }

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }


    }
}
