package com.example.bookshop.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoriteID implements Serializable {
    private Integer user;
    private Integer book;

    public FavoriteID(){
    }

    public FavoriteID(Integer user, Integer book) {
        this.user = user;
        this.book = book;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoriteID)) return false;
        FavoriteID other = (FavoriteID) o;
        return Objects.equals(user, other.user) && Objects.equals(book, other.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book);
    }
}
