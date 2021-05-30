package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.util.Log;

import android.content.ContentValues;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
        int version = 2;
        private String TAG = "debugardo";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
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

                boton1.setOnClickListener(new View.OnClickListener(){
                        public void onClick (View v){
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

                boton2.setOnClickListener(new View.OnClickListener(){
                        public void onClick (View v){
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
                                } else Toast.makeText(v.getContext(), "Introduzca una ID", Toast.LENGTH_SHORT).show();
                        }
                });


                boton3.setOnClickListener(new View.OnClickListener(){
                        public void onClick (View v){
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


                boton4.setOnClickListener(new View.OnClickListener(){
                        public void onClick (View v){
                                if (ID.getText().toString() != "") {
                                        GamesDB admin = new GamesDB(v.getContext(), version);
                                        SQLiteDatabase bd = admin.getWritableDatabase();
                                        int cant = bd.delete("Game", "ID="+ID.getText().toString(), null);
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
                                } else Toast.makeText(v.getContext(), "Introduzca una ID", Toast.LENGTH_SHORT).show();
                        }
                });


                boton5.setOnClickListener(new View.OnClickListener(){
                        public void onClick (View v){
                                GamesDB admin = new GamesDB(v.getContext(), version);
                                SQLiteDatabase bd = admin.getReadableDatabase();
                                Cursor fila = bd.rawQuery("select * from Game", null);
                                if (fila.moveToFirst()) {
                                        Log.d(TAG, "hola " + fila);
                                        List<Game> games = new ArrayList<Game>();
                                        do {
                                                games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), fila.getString(5), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                                        } while (fila.moveToNext());
                                        LinearLayout m_ll = findViewById(R.id.gamesLayout);
                                        m_ll.removeAllViews();
                                        for (int i = 0; i < games.size(); i++) {
                                                Log.d(TAG, "ID-> " + games.get(i).ID + ", TITLE-> " + games.get(i).TITLE + ", DESCRIPTION-> " + games.get(i).DESCRIPTION + ", PRICE-> " + games.get(i).PRICE + ", IMAGE-> " + games.get(i).IMAGE + ", DATE-> " + games.get(i).DATE + ", SALE-> " + games.get(i).SALE + ", SALE_PRICE-> " + games.get(i).SALE_PRICE + ", XBOX-> " + games.get(i).XBOX + ", PS-> " + games.get(i).PS);

                                                ImageView image = new ImageView(v.getContext());
                                                int draw = getResources().getIdentifier(games.get(i).IMAGE, "drawable", getPackageName());
                                                image.setImageResource(draw);
                                                m_ll.addView(image);
                                                image.getLayoutParams().height = 500;

                                                TextView textTitle = new TextView(v.getContext());
                                                textTitle.setText("" + games.get(i).ID + " - " + games.get(i).TITLE);
                                                m_ll.addView(textTitle);

                                                TextView textDesc = new TextView(v.getContext());
                                                textDesc.setText("" + games.get(i).DESCRIPTION);
                                                m_ll.addView(textDesc);

                                                TextView textPrice = new TextView(v.getContext());
                                                textPrice.setText("" + games.get(i).PRICE + "€");
                                                m_ll.addView(textPrice);

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
        Button boton6 = findViewById(R.id.boton6);

        boton6.setOnClickListener {
        val admin = gamesDB(this, "administracion", null, version)
        val bd = admin.writableDatabase
        val fila = bd.execSQL("DROP TABLE Game")
        bd.close()
        }
        }*/
