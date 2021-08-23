package org.example.hibernate_test1;

import org.hibernate.Session;
import org.example.hibernate_test1.entity.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LibraryAddBook {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Book book = new Book("Siberia", "Tolstoy L.N.", "Stories", 1750);
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            System.out.println("The book name " + "'" + book.getName() + "'" +" was added in the library!");

        } finally {
            factory.close();
        }

    }
}
