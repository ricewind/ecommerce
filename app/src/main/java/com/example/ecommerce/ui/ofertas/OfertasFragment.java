package com.example.ecommerce.ui.ofertas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecommerce.R;
import com.example.ecommerce.databinding.FragmentOfertasBinding;
import com.example.ecommerce.model.Game;
import com.example.ecommerce.model.GamesDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OfertasFragment extends Fragment {
    static int version = 2;
    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
    private OfertasViewModel ofertasViewModel;
    private FragmentOfertasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ofertasViewModel = new ViewModelProvider(this).get(OfertasViewModel.class);

        binding = FragmentOfertasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        createGames(root);

        ofertasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void createGames(View v) {

        GamesDB admin = new GamesDB(v.getContext(), version);
        SQLiteDatabase bd = admin.getReadableDatabase();
        Cursor fila = bd.rawQuery("select *, PRICE - SALE_PRICE as diff from Game where SALE = 1 order by diff desc", null);

        if (fila.moveToFirst()) {

            List<Game> games = new ArrayList<Game>();
            do {
                try {
                    games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } while (fila.moveToNext());
            LinearLayout m_ll = v.findViewById(R.id.gamesLayout);

            for (int i = 0; i < games.size(); i++) {
                ImageView image = new ImageView(v.getContext());
                int draw = getResources().getIdentifier(games.get(i).IMAGE, "drawable", getActivity().getPackageName());
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

            }
        }
        bd.close();
    }

}