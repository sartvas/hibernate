package org.example.hibernate_test;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeUpdate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 2); - for 1 row
//            employee.setSalary(400);

            session.createQuery("update Employee set salary=1000 "+ "where name='Irina'").executeUpdate();

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }


    }
}
