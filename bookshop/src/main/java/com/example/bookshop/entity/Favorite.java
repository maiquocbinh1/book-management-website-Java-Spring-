package com.example.bookshop.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Favorites")
public class Favorite {
    @EmbeddedId
    private FavoriteID id;

    @ManyToOne
    @MapsId("user")
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("book")
    @JoinColumn(name = "BookID", nullable = false)
    private Book book;

    public Favorite() {}

    public Favorite(User user, Book book) {
        this.user = user;
        this.book = book;
        this.id = new FavoriteID(user.getUserID(), book.getBookID());
    }

    public FavoriteID getId() {
        return id;
    }

    public void setId(FavoriteID id) {
        this.id = id;
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
