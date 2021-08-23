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
            Employee emp = new Employee("Sergey", "qqqq", "IqqT", 1500);
            Detail detail = new Detail("qqqq", "+qqqq+7928qqq5489632", "qqqqq@mail.ru");
            emp.setEmpDetail(detail);
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
