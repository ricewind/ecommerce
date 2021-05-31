package com.example.ecommerce;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ecommerce.model.Game;
import com.example.ecommerce.model.GamesDB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.text.ParseException;

public class Utilities {

    static Context context;
    static int version = 2;
    static SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");


    public Utilities (Context context){
        this.context = context;
    }

    public static ArrayList<ListObject> populateFirstList() {
        ArrayList<ListObject> mFirstList = new ArrayList<>();

        List<Game> novedades = getNovedades();


        for (int i = 0; i < 3; i++) {
            ListObject mListObject;

            if(i < novedades.size()){
                if(novedades.get(i).SALE_PRICE != 0)
                    mListObject = new ListObject(novedades.get(i).SALE_PRICE + "€", novedades.get(i).TITLE);
                else
                    mListObject = new ListObject(novedades.get(i).PRICE + "€", novedades.get(i).TITLE);

                mFirstList.add(mListObject);
            }
        }

        return mFirstList;
    }

    public static ArrayList<ListObject> populateSecondList() {
        ArrayList<ListObject> mSecondList = new ArrayList<>();

        List<Game> ofertas = getOfertas();

        for (int i = 0; i < 3; i++) {
            ListObject mListObject;
            if(i < ofertas.size()) {
                mListObject = new ListObject(ofertas.get(i).SALE_PRICE + "€", ofertas.get(i).TITLE);
                mSecondList.add(mListObject);
            }
        }


        return mSecondList;
    }


    public static List<Game> getNovedades() {
        GamesDB admin = new GamesDB(context, version);
        SQLiteDatabase bd = admin.getReadableDatabase();
        Cursor fila = bd.rawQuery("select * from Game", null);
        List<Game> games = new ArrayList<Game>();

        if (fila.moveToFirst()) {
            do {
                try {
                    games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } while (fila.moveToNext());


            Collections.sort(games);
            Collections.reverse(games);
        }
        bd.close();
        return games;
    }

    public static List<Game> getOfertas() {
        GamesDB admin = new GamesDB(context, version);
        SQLiteDatabase bd = admin.getReadableDatabase();
        Cursor fila = bd.rawQuery("select *, PRICE - SALE_PRICE as diff from Game where SALE = 1 order by diff desc", null);
        List<Game> games = new ArrayList<Game>();

        if (fila.moveToFirst()) {
            do {
                try {
                    games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } while (fila.moveToNext());
        }
        bd.close();
        return games;
    }




}
