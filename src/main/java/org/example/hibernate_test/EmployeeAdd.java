package org.example.hibernate_test;

import org.example.hibernate_test.entity.Detail;
import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeAdd {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee emp = new Employee("Galina", "Petrova", "HR", 990);
            Detail detail = new Detail("Kazan", "+79886595874", "12malyshka12@gmail.com");
            emp.setEmpDetail(detail);
            detail.setEmployee(emp);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
