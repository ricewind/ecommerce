package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ecommerce.controller.GameController;
import com.example.ecommerce.databinding.ActivityMainBinding;
import com.example.ecommerce.databinding.FragmentContactoBinding;
import com.example.ecommerce.model.Game;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

public class GameDetail extends Fragment {
    Game game;
    private FragmentContactoBinding binding;
    View rootView;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String strtext = getArguments().getString("game");

        rootView =  inflater.inflate(R.layout.activity_game_detail, container, false);
        Gson gson = new Gson();
        String gameDataParced = strtext;
        this.game = gson.fromJson(gameDataParced,Game.class);
        createView();
        return rootView;
    }

    public void createView(){
        LinearLayout m_ll = rootView.findViewById(R.id.gamesLayout);
        ImageView image = new ImageView(rootView.getContext());
        int draw = getResources().getIdentifier(game.IMAGE, "drawable", rootView.getContext().getPackageName());
        image.setImageResource(draw);
        m_ll.addView(image);
        image.getLayoutParams().height = 500;

        TextView textTitle = new TextView(rootView.getContext());
        textTitle.setText("" + game.ID + " - " + game.TITLE);
        textTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        m_ll.addView(textTitle);

        TextView textDesc = new TextView(rootView.getContext());
        textDesc.setText("" + game.DESCRIPTION);
        textDesc.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        m_ll.addView(textDesc);

            if (game.SALE == 1){
                TextView textPrice = new TextView(rootView.getContext());
                textPrice.setText("" + game.PRICE + "€");
                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                m_ll.addView(textPrice);

                TextView textPriceSale = new TextView(rootView.getContext());
                textPriceSale.setText("" + game.SALE_PRICE + "€");
                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                textPriceSale.setTextColor(Color.RED);
                m_ll.addView(textPriceSale);
            }
            else{
                TextView textPrice = new TextView(rootView.getContext());
                textPrice.setText("" + game.PRICE + "€");
                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                m_ll.addView(textPrice);
            }

            TextView textDate = new TextView(rootView.getContext());
            textDate.setText("" + game.DATE);
            textDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            m_ll.addView(textDate);
        }
}