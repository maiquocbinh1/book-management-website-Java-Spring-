package com.example.bookshop.entity;

import java.io.Serializable;
import java.util.Objects;

public class CartID implements Serializable {
    private Integer user;
    private Integer book;

    public CartID() {
    }

    public CartID(Integer userID, Integer bookID) {
        this.user = user;
        this.book = book;
    }

    public Integer getUserID() {
        return user;
    }

    public void setUserID(Integer userID) {
        this.user = user;
    }

    public Integer getBookID() {
        return book;
    }

    public void setBookID(Integer bookID) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartID)) return false;
        CartID other = (CartID) o;
        return Objects.equals(user, other.user) && Objects.equals(book, other.book);
    }


}
