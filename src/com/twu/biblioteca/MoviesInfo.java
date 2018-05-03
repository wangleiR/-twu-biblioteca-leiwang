package com.twu.biblioteca;

public class MoviesInfo extends BaseInfo {
    private Integer rate;

    public MoviesInfo(Integer id, String name, String author, Integer year, boolean ifCheckout, Integer rate) {
        super(id, name, author, year, ifCheckout);
        this.rate = rate;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
