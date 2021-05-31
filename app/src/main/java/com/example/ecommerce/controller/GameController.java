package com.example.ecommerce.controller;

import android.content.ContentValues;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.example.ecommerce.R;
import com.example.ecommerce.model.Game;
import com.example.ecommerce.model.GamesDB;


public class GameController extends AppCompatActivity{

        int version = 2;
        private String TAG = "debugardo";
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.games_controller);

            EditText ID = findViewById(R.id.ID);
            EditText title = findViewById(R.id.title);
            EditText description = findViewById(R.id.description);
            EditText price = findViewById(R.id.price);
            EditText image = findViewById(R.id.image);
            EditText date = findViewById(R.id.date);
            EditText sale = findViewById(R.id.sale);
            EditText sale_price = findViewById(R.id.sale_price);
            EditText xbox = findViewById(R.id.XBOX);
            EditText ps = findViewById(R.id.PS);

            Button boton1 = findViewById(R.id.boton1);
            Button boton2 = findViewById(R.id.boton2);
            Button boton3 = findViewById(R.id.boton3);
            Button boton4 = findViewById(R.id.boton4);
            Button boton5 = findViewById(R.id.boton5);
            Button boton6 = findViewById(R.id.boton6);
            Button boton7 = findViewById(R.id.boton7);
            Button boton8 = findViewById(R.id.boton8);
            Button boton9 = findViewById(R.id.boton9);


            boton1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (ID.getText().toString() != "" && title.getText().toString() != "" && description.getText().toString() != "" && price.getText().toString() != "" && image.getText().toString() != "" && date.getText().toString() != "" && sale.getText().toString() != "" && sale_price.getText().toString() != "" && xbox.getText().toString() != "" && ps.getText().toString() != "") {
                        GamesDB admin = new GamesDB(v.getContext(), version);
                        SQLiteDatabase bd = admin.getWritableDatabase();
                        ContentValues registro = new ContentValues();
                        registro.put("ID", ID.getText().toString());
                        registro.put("TITLE", title.getText().toString());
                        registro.put("DESCRIPTION", description.getText().toString());
                        registro.put("PRICE", price.getText().toString());
                        registro.put("IMAGE", image.getText().toString());
                        registro.put("DATE", date.getText().toString());
                        registro.put("SALE", sale.getText().toString());
                        registro.put("SALE_PRICE", sale_price.getText().toString());
                        registro.put("XBOX ", xbox.getText().toString());
                        registro.put("PS", ps.getText().toString());
                        bd.insert("Game", null, registro);
                        bd.close();
                        ID.setText("");
                        title.setText("");
                        description.setText("");
                        price.setText("");
                        image.setText("");
                        date.setText("");
                        sale.setText("");
                        sale_price.setText("");
                        xbox.setText("");
                        ps.setText("");
                        Toast.makeText(v.getContext(), "Se cargaron los datos del juego", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(v.getContext(), "Introduzca todos los valores pedidos", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            boton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (ID.getText().toString() != "") {
                        GamesDB admin = new GamesDB(v.getContext(), version);
                        SQLiteDatabase bd = admin.getReadableDatabase();
                        Cursor fila = bd.rawQuery("select * from Game where ID=" + ID.getText().toString(), null);
                        if (fila.moveToFirst()) {
                            ID.setText(fila.getString(0));
                            title.setText(fila.getString(1));
                            description.setText(fila.getString(2));
                            price.setText(fila.getString(3));
                            image.setText(fila.getString(4));
                            date.setText(fila.getString(5));
                            sale.setText(fila.getString(6));
                            sale_price.setText(fila.getString(7));
                            xbox.setText(fila.getString(8));
                            ps.setText(fila.getString(9));
                        } else
                            Toast.makeText(v.getContext(), "No existe un juego con dicha ID", Toast.LENGTH_SHORT).show();
                        bd.close();
                    } else
                        Toast.makeText(v.getContext(), "Introduzca una ID", Toast.LENGTH_SHORT).show();
                }
            });


            boton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (ID.getText().toString() != "") {
                        GamesDB admin = new GamesDB(v.getContext(), version);
                        SQLiteDatabase bd = admin.getReadableDatabase();
                        Cursor fila = bd.rawQuery("select * from Game where TITLE='${title.text.toString()}'", null);
                        if (fila.moveToFirst()) {
                            ID.setText(fila.getString(0));
                            title.setText(fila.getString(1));
                            description.setText(fila.getString(2));
                            price.setText(fila.getString(3));
                            image.setText(fila.getString(4));
                            date.setText(fila.getString(5));
                            sale.setText(fila.getString(6));
                            sale_price.setText(fila.getString(7));
                            xbox.setText(fila.getString(8));
                            ps.setText(fila.getString(9));
                        } else
                            Toast.makeText(v.getContext(), "No existe un juego con dicho título", Toast.LENGTH_SHORT).show();
                        bd.close();
                    } else
                        Toast.makeText(v.getContext(), "Introduzca un título", Toast.LENGTH_SHORT).show();
                }
            });


            boton4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (ID.getText().toString() != "") {
                        GamesDB admin = new GamesDB(v.getContext(), version);
                        SQLiteDatabase bd = admin.getWritableDatabase();
                        int cant = bd.delete("Game", "ID=" + ID.getText().toString(), null);
                        bd.close();
                        ID.setText("");
                        title.setText("");
                        description.setText("");
                        price.setText("");
                        image.setText("");
                        date.setText("");
                        sale.setText("");
                        sale_price.setText("");
                        xbox.setText("");
                        ps.setText("");
                        if (cant == 1)
                            Toast.makeText(v.getContext(), "Se borró el juego con dicha ID", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(v.getContext(), "No existe un juego con dicha ID", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(v.getContext(), "Introduzca una ID", Toast.LENGTH_SHORT).show();
                }
            });


            boton5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GamesDB admin = new GamesDB(v.getContext(), version);
                    SQLiteDatabase bd = admin.getReadableDatabase();
                    Cursor fila = bd.rawQuery("select * from Game", null);
                    if (fila.moveToFirst()) {
                        List<Game> games = new ArrayList<Game>();
                        do {
                            try {
                                games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } while (fila.moveToNext());
                        LinearLayout m_ll = findViewById(R.id.gamesLayout);
                        m_ll.removeAllViews();
                        for (int i = 0; i < games.size(); i++) {
                            ImageView image = new ImageView(v.getContext());
                            int draw = getResources().getIdentifier(games.get(i).IMAGE, "drawable", getPackageName());
                            image.setImageResource(draw);
                            m_ll.addView(image);
                            image.getLayoutParams().height = 500;

                            TextView textTitle = new TextView(v.getContext());
                            textTitle.setText("" + games.get(i).ID + " - " + games.get(i).TITLE);
                            textTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textTitle);

                            TextView textDesc = new TextView(v.getContext());
                            textDesc.setText("" + games.get(i).DESCRIPTION);
                            textDesc.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDesc);

                            if (games.get(i).SALE == 1){
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);

                                TextView textPriceSale = new TextView(v.getContext());
                                textPriceSale.setText("" + games.get(i).SALE_PRICE + "€");
                                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                textPriceSale.setTextColor(Color.RED);
                                m_ll.addView(textPriceSale);
                            }
                            else{
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);
                                Log.d(TAG, "" + games.get(i).SALE + " " + games.get(i).SALE_PRICE);
                            }

                            TextView textDate = new TextView(v.getContext());
                            textDate.setText("" + games.get(i).DATE);
                            textDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDate);

                                                /*
                                                TextView text = new TextView(v.getContext());
                                                text.setText("");
                                                m_ll.addView(text);
                                                //games.get(i).IMAGE + ", DATE-> " + games.get(i).DATE + ", SALE-> " + games.get(i).SALE + ", SALE_PRICE-> " + games.get(i).SALE_PRICE + ", XBOX-> " + games.get(i).XBOX + ", PS-> " + games.get(i).PS
                                                */
                        }
                    }
                    bd.close();
                }
            });
            boton6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GamesDB admin = new GamesDB(v.getContext(), version);
                    SQLiteDatabase bd = admin.getReadableDatabase();
                    Cursor fila = bd.rawQuery("select * from Game where XBOX = 1", null);
                    if (fila.moveToFirst()) {
                        List<Game> games = new ArrayList<Game>();
                        do {
                            try {
                                games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } while (fila.moveToNext());
                        LinearLayout m_ll = findViewById(R.id.gamesLayout);
                        m_ll.removeAllViews();
                        for (int i = 0; i < games.size(); i++) {
                            ImageView image = new ImageView(v.getContext());
                            int draw = getResources().getIdentifier(games.get(i).IMAGE, "drawable", getPackageName());
                            image.setImageResource(draw);
                            m_ll.addView(image);
                            image.getLayoutParams().height = 500;

                            TextView textTitle = new TextView(v.getContext());
                            textTitle.setText("" + games.get(i).ID + " - " + games.get(i).TITLE);
                            textTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textTitle);

                            TextView textDesc = new TextView(v.getContext());
                            textDesc.setText("" + games.get(i).DESCRIPTION);
                            textDesc.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDesc);

                            if (games.get(i).SALE == 1){
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).SALE_PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);

                                TextView textPriceSale = new TextView(v.getContext());
                                textPriceSale.setText("" + games.get(i).SALE_PRICE + "€");
                                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                textPriceSale.setTextColor(Color.RED);
                                m_ll.addView(textPriceSale);
                            }
                            else{
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);
                            }

                            TextView textDate = new TextView(v.getContext());
                            textDate.setText("" + games.get(i).DATE);
                            textDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDate);

                                                /*
                                                TextView text = new TextView(v.getContext());
                                                text.setText("");
                                                m_ll.addView(text);
                                                //games.get(i).IMAGE + ", DATE-> " + games.get(i).DATE + ", SALE-> " + games.get(i).SALE + ", SALE_PRICE-> " + games.get(i).SALE_PRICE + ", XBOX-> " + games.get(i).XBOX + ", PS-> " + games.get(i).PS
                                                */
                        }
                    }
                    bd.close();
                }
            });
            boton7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GamesDB admin = new GamesDB(v.getContext(), version);
                    SQLiteDatabase bd = admin.getReadableDatabase();
                    Cursor fila = bd.rawQuery("select * from Game where PS = 1", null);
                    if (fila.moveToFirst()) {
                        List<Game> games = new ArrayList<Game>();
                        do {
                            try {
                                games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } while (fila.moveToNext());
                        LinearLayout m_ll = findViewById(R.id.gamesLayout);
                        m_ll.removeAllViews();
                        for (int i = 0; i < games.size(); i++) {
                            ImageView image = new ImageView(v.getContext());
                            int draw = getResources().getIdentifier(games.get(i).IMAGE, "drawable", getPackageName());
                            image.setImageResource(draw);
                            m_ll.addView(image);
                            image.getLayoutParams().height = 500;

                            TextView textTitle = new TextView(v.getContext());
                            textTitle.setText("" + games.get(i).ID + " - " + games.get(i).TITLE);
                            textTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textTitle);

                            TextView textDesc = new TextView(v.getContext());
                            textDesc.setText("" + games.get(i).DESCRIPTION);
                            textDesc.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDesc);

                            if (games.get(i).SALE == 1){
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).SALE_PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);

                                TextView textPriceSale = new TextView(v.getContext());
                                textPriceSale.setText("" + games.get(i).SALE_PRICE + "€");
                                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                textPriceSale.setTextColor(Color.RED);
                                m_ll.addView(textPriceSale);
                            }
                            else{
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);
                            }

                            TextView textDate = new TextView(v.getContext());
                            textDate.setText("" + games.get(i).DATE);
                            textDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDate);

                                                /*
                                                TextView text = new TextView(v.getContext());
                                                text.setText("");
                                                m_ll.addView(text);
                                                //games.get(i).IMAGE + ", DATE-> " + games.get(i).DATE + ", SALE-> " + games.get(i).SALE + ", SALE_PRICE-> " + games.get(i).SALE_PRICE + ", XBOX-> " + games.get(i).XBOX + ", PS-> " + games.get(i).PS
                                                */
                        }
                    }
                    bd.close();
                }
            });
            boton8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GamesDB admin = new GamesDB(v.getContext(), version);
                    SQLiteDatabase bd = admin.getReadableDatabase();
                    Cursor fila = bd.rawQuery("select *, PRICE - SALE_PRICE as diff from Game where SALE = 1 order by diff desc", null);

                    if (fila.moveToFirst()) {
                        Log.d(TAG, "assaas");

                        List<Game> games = new ArrayList<Game>();
                        do {
                            try {
                                games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } while (fila.moveToNext());
                        LinearLayout m_ll = findViewById(R.id.gamesLayout);
                        m_ll.removeAllViews();
                        for (int i = 0; i < games.size(); i++) {
                            ImageView image = new ImageView(v.getContext());
                            int draw = getResources().getIdentifier(games.get(i).IMAGE, "drawable", getPackageName());
                            image.setImageResource(draw);
                            m_ll.addView(image);
                            image.getLayoutParams().height = 500;

                            TextView textTitle = new TextView(v.getContext());
                            textTitle.setText("" + games.get(i).ID + " - " + games.get(i).TITLE);
                            textTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textTitle);

                            TextView textDesc = new TextView(v.getContext());
                            textDesc.setText("" + games.get(i).DESCRIPTION);
                            textDesc.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDesc);

                            if (games.get(i).SALE == 1){
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);

                                TextView textPriceSale = new TextView(v.getContext());
                                textPriceSale.setText("" + games.get(i).SALE_PRICE + "€");
                                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                textPriceSale.setTextColor(Color.RED);
                                m_ll.addView(textPriceSale);
                            }
                            else{
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);
                            }

                            TextView textDate = new TextView(v.getContext());
                            textDate.setText("" + games.get(i).DATE);
                            textDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDate);

                                                /*
                                                TextView text = new TextView(v.getContext());
                                                text.setText("");
                                                m_ll.addView(text);
                                                //games.get(i).IMAGE + ", DATE-> " + games.get(i).DATE + ", SALE-> " + games.get(i).SALE + ", SALE_PRICE-> " + games.get(i).SALE_PRICE + ", XBOX-> " + games.get(i).XBOX + ", PS-> " + games.get(i).PS
                                                */
                        }
                    }
                    bd.close();
                }
            });

            boton9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GamesDB admin = new GamesDB(v.getContext(), version);
                    SQLiteDatabase bd = admin.getReadableDatabase();
                    Cursor fila = bd.rawQuery("select * from Game", null);

                    if (fila.moveToFirst()) {
                        List<Game> games = new ArrayList<Game>();
                        do {
                            try {
                                games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } while (fila.moveToNext());


                        Collections.sort(games);
                        Collections.reverse(games);


                        LinearLayout m_ll = findViewById(R.id.gamesLayout);
                        m_ll.removeAllViews();
                        for (int i = 0; i < games.size(); i++) {
                            ImageView image = new ImageView(v.getContext());
                            int draw = getResources().getIdentifier(games.get(i).IMAGE, "drawable", getPackageName());
                            image.setImageResource(draw);
                            m_ll.addView(image);
                            image.getLayoutParams().height = 500;

                            TextView textTitle = new TextView(v.getContext());
                            textTitle.setText("" + games.get(i).ID + " - " + games.get(i).TITLE);
                            textTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textTitle);

                            TextView textDesc = new TextView(v.getContext());
                            textDesc.setText("" + games.get(i).DESCRIPTION);
                            textDesc.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDesc);

                            if (games.get(i).SALE == 1){
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);

                                TextView textPriceSale = new TextView(v.getContext());
                                textPriceSale.setText("" + games.get(i).SALE_PRICE + "€");
                                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                textPriceSale.setTextColor(Color.RED);
                                m_ll.addView(textPriceSale);
                            }
                            else{
                                TextView textPrice = new TextView(v.getContext());
                                textPrice.setText("" + games.get(i).PRICE + "€");
                                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                m_ll.addView(textPrice);
                            }

                            TextView textDate = new TextView(v.getContext());
                            textDate.setText("" + games.get(i).DATE);
                            textDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                            m_ll.addView(textDate);

                                                /*
                                                TextView text = new TextView(v.getContext());
                                                text.setText("");
                                                m_ll.addView(text);
                                                //games.get(i).IMAGE + ", DATE-> " + games.get(i).DATE + ", SALE-> " + games.get(i).SALE + ", SALE_PRICE-> " + games.get(i).SALE_PRICE + ", XBOX-> " + games.get(i).XBOX + ", PS-> " + games.get(i).PS
                                                */
                        }
                    }
                    bd.close();
                }
            });
        }

    }
        /*
        Button botonDelete = findViewById(R.id.boton6);

        botonDelete.setOnClickListener {
        val admin = gamesDB(this, "administracion", null, version)
        val bd = admin.writableDatabase
        val fila = bd.execSQL("DROP TABLE Game")
        bd.close()
        }
        }*/

