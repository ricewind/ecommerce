package com.example.ecommerce.model;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class GamesDB extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "GamesOnlineShop.db";

    public GamesDB(Context context, int version) {
        super(context, DATABASE_NAME, null, version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Game(ID int primary key, TITLE text, DESCRIPTION text, PRICE float, IMAGE text, DATE text, SALE int, SALE_PRICE float, XBOX int, PS int)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion>oldVersion){
            db.execSQL("create table Game(ID int primary key, TITLE text, DESCRIPTION text, PRICE float, IMAGE text, DATE text, SALE int, SALE_PRICE float, XBOX int, PS int)");
        }
    }
}

