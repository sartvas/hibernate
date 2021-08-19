package org.example.hibernate_test;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddSomeData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Irina", "Lavrenuk", "HR", 750);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println("Some data was added");
        }
        finally {
            factory.close();
        }


    }
}
