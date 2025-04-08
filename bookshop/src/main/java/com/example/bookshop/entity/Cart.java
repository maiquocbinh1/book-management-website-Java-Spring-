package com.example.bookshop.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Cart")
public class Cart {

     @EmbeddedId
     private CartID cartID;

     @ManyToOne
     @MapsId("user") // lien ket voi User
     @JoinColumn(name = "UserID", nullable = false)
     private User user;

     @ManyToOne
     @MapsId("book")
     @JoinColumn(name = "BookID", nullable = false)
     private Book book;

     @Column(name = "Quantity", nullable = false)
     private Integer quantity;

     @Column(name = "AddedAt", nullable = false)
     private LocalDateTime addedAt;

     @PrePersist
     protected void onCreat() {
         this.addedAt = LocalDateTime.now();
     }

     public Cart(){
     }

    public CartID getCartID() {
        return cartID;
    }

    public void setCartID(CartID cartID) {
        this.cartID = cartID;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
