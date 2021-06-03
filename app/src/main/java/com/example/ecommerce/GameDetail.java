package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ecommerce.model.Game;
import com.google.gson.Gson;

public class GameDetail extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        Gson gson = new Gson();
        Intent i = getIntent();
        String gameDataParced = i.getStringExtra("game");
        this.game = gson.fromJson(gameDataParced,Game.class);

        createView();


    }

    public void createView(){
        LinearLayout m_ll = findViewById(R.id.gamesLayout);
        ImageView image = new ImageView(this);
        int draw = getResources().getIdentifier(game.IMAGE, "drawable", getPackageName());
        image.setImageResource(draw);
        m_ll.addView(image);
        image.getLayoutParams().height = 500;

        TextView textTitle = new TextView(this);
        textTitle.setText("" + game.ID + " - " + game.TITLE);
        textTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        m_ll.addView(textTitle);

        TextView textDesc = new TextView(this);
        textDesc.setText("" + game.DESCRIPTION);
        textDesc.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        m_ll.addView(textDesc);

            if (game.SALE == 1){
                TextView textPrice = new TextView(this);
                textPrice.setText("" + game.PRICE + "€");
                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                m_ll.addView(textPrice);

                TextView textPriceSale = new TextView(this);
                textPriceSale.setText("" + game.SALE_PRICE + "€");
                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                textPriceSale.setTextColor(Color.RED);
                m_ll.addView(textPriceSale);
            }
            else{
                TextView textPrice = new TextView(this);
                textPrice.setText("" + game.PRICE + "€");
                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                m_ll.addView(textPrice);
            }

            TextView textDate = new TextView(this);
            textDate.setText("" + game.DATE);
            textDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            m_ll.addView(textDate);
        }

}