package com.twu.biblioteca;

public class BaseInfo {

    private Integer id;
    private String name;
    private String author;
    private Integer year;
    private boolean ifCheckout;


    public BaseInfo(Integer id, String name, String author, Integer year, boolean ifCheckout) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.ifCheckout = ifCheckout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isIfCheckout() {
        return ifCheckout;
    }

    public void setIfCheckout(boolean ifCheckout) {
        this.ifCheckout = ifCheckout;
    }
}
