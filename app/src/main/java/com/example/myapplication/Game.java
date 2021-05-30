package com.example.myapplication;

public class Game {
    int ID;
    String TITLE;
    String DESCRIPTION;
    float PRICE;
    String IMAGE;
    String DATE;
    int SALE;
    float SALE_PRICE;
    int XBOX;
    int PS;
    public Game(int ID, String TITLE, String DESCRIPTION, float PRICE, String IMAGE, String DATE, int SALE, float SALE_PRICE, int XBOX, int PS){
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
}
