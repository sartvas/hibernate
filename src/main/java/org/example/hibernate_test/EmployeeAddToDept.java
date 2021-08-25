package org.example.hibernate_test;

import org.example.hibernate_test.entity.Department;
import org.example.hibernate_test.entity.Detail;
import org.example.hibernate_test.entity.Employee2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EmployeeAddToDept {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee2.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

            Department department = new Department("IT", 300, 4500);

            Employee2 employee = new Employee2("Artem", "Savinykh", 3000);
            Employee2 employee2 = new Employee2("Sergey", "Vovkin", 1500);

            department.addEmployeestoDepartmen(employee);
            department.addEmployeestoDepartmen(employee2);
            session.beginTransaction();
            session.save(department);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
