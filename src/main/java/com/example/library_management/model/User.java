package com.example.library_management.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;
    private String userName;

    private String password;

    private LocalDate enrollDate;


    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    @JsonManagedReference
    private Set<Basket> userBasket =new HashSet<>();


    @ManyToMany
    @JoinTable(
        name="book_history",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @JsonManagedReference
    private Set<Book> bookHistory=new HashSet<>();


    public void userAddBook(Book book){

        Basket basket=new Basket();
        basket.setBook(book);
        userBasket.add(basket);

    }

    public void userRemoveBook(Book book){

        for (Basket basket : userBasket) {
            if(basket.getBook().getId()==book.getId()){
                bookHistory.add(book);
                userBasket.remove(basket);
                basket.setBook(null);
                break;
            }
        }
    }

    public User(){
        this.enrollDate=LocalDate.now();
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public LocalDate getEnrollDate() {
        return enrollDate;
    }


    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }


    public Set<Basket> getUserBasket() {
        return userBasket;
    }


    public void setUserBasket(Set<Basket> userBasket) {
        this.userBasket = userBasket;
    }


    public Set<Book> getBookHistory() {
        return bookHistory;
    }


    public void setBookHistory(Set<Book> bookHistory) {
        this.bookHistory = bookHistory;
    }


    
    
   


    

}
