package org.example.hibernate_test;

import org.example.hibernate_test.entity.Detail;
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
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 5);
//            detail.getEmployee().setEmpDetail(null);
//            Employee employee = session.get(Employee.class,1);
//            System.out.println(employee+" "+employee.getEmpDetail());
//            List <Employee> allEmployees = session.createQuery("from Employee").getResultList();
//            List <Employee> allEmployees = session.createQuery("from Employee " + "where name = 'Artom'").getResultList();
//            for(Employee e: allEmployees){
//                System.out.println(e);
//            }


            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }


    }
}
