package com.mistake.page;

/**
 * 电影
 *
 * @author leoliu
 */
public class Movie {
    public static final int CHILDREN = 2;

    public static final int REGULAR = 0;

    public static final int NEW_RELEASE = 1;
    /**
     * 标题
     */
    private String title;

    /**
     * 商品code
     */
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
