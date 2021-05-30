package com.example.myapplication;

import java.util.Date;

public class Game implements Comparable<Game> {
    int ID;
    String TITLE;
    String DESCRIPTION;
    float PRICE;
    String IMAGE;
    Date DATE;
    int SALE;
    float SALE_PRICE;
    int XBOX;
    int PS;
    public Game(int ID, String TITLE, String DESCRIPTION, float PRICE, String IMAGE, Date DATE, int SALE, float SALE_PRICE, int XBOX, int PS){
        this.ID = ID;
        this.TITLE = TITLE;
        this.DESCRIPTION = DESCRIPTION;
        this.PRICE = PRICE;
        this.IMAGE = IMAGE;
        this.DATE = DATE;
        this.SALE = SALE;
        this.SALE_PRICE = SALE_PRICE;
        this.XBOX = XBOX;
        this.PS = PS;
    }
    @Override
    public int compareTo(Game o) {
        if (getDateTime() == null || o.getDateTime() == null) return 0;
        return getDateTime().compareTo(o.getDateTime());
    }

    private Date getDateTime() {
        return this.DATE;
    }
}
