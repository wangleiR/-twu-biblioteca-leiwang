package com.twu.biblioteca;

public class BookInfo {

    private Integer id;
    private String bookName;
    private String author;
    private Integer publishedYear;
    private boolean ifCheckout;

    public BookInfo(Integer id, String bookName, String author, Integer publishedYear, boolean ifCheckout) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publishedYear = publishedYear;
        this.ifCheckout = ifCheckout;
    }

    public boolean isIfCheckout() {
        return ifCheckout;
    }

    public void setIfCheckout(boolean ifCheckout) {
        this.ifCheckout = ifCheckout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
}
