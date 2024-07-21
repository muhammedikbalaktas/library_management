package com.example.library_management.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private LocalDate takenDate;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;

    public Basket(){
        this.takenDate=LocalDate.now();
        this.dueDate=takenDate.plusWeeks(2);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(LocalDate takenDate) {
        this.takenDate = takenDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    


    
}