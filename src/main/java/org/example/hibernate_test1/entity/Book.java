package org.example.hibernate_test1.entity;


import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="author")
    private String author;

    @Column(name="genre")
    private String genre;

    @Column(name="primary_cost")
    private int primaryCost;

    public Book() {
    }

    public Book(String name, String author, String genre, int primaryCost) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.primaryCost = primaryCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrimaryCost() {
        return primaryCost;
    }

    public void setPrimaryCost(int primaryCost) {
        this.primaryCost = primaryCost;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name='" + name + '\'' + ", author='" + author + '\'' + ", genre='" + genre + '\'' + ", primaryCost=" + primaryCost + '}';
    }
}
