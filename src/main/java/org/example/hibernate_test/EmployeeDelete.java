package org.example.hibernate_test;

import org.example.hibernate_test.entity.Detail;
import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class,3);
//            session.delete(employee);
            Detail detail = session.get(Detail.class, 5);
            session.delete(detail);

//            session.createQuery("delete Employee " + "where department = 'HR'").executeUpdate();

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }


    }
}
