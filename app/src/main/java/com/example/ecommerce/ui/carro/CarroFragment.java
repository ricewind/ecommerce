package com.example.ecommerce.ui.carro;

import android.graphics.Color;
import android.os.Bundle;
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
import com.example.ecommerce.databinding.FragmentCarroBinding;
import com.example.ecommerce.model.Carro;
import com.example.ecommerce.model.Game;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CarroFragment extends Fragment {

    private CarroViewModel carroViewModel;
    private FragmentCarroBinding binding;
    ArrayList<Game> lista;
    TextView totalTextView;
    Carro carro;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        carroViewModel = new ViewModelProvider(this).get(CarroViewModel.class);

        binding = FragmentCarroBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        totalTextView = binding.textCarro;

        carro = Carro.getClase();
        ArrayList<Game> carroList = carro.getLista();

        buildView(carroList, root);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void buildView(ArrayList<Game> games, View v) {
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

            if (games.get(i).SALE == 1) {
                TextView textPrice = new TextView(v.getContext());
                textPrice.setText("" + games.get(i).SALE_PRICE + "€");
                textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                m_ll.addView(textPrice);

                TextView textPriceSale = new TextView(v.getContext());
                textPriceSale.setText("" + games.get(i).SALE_PRICE + "€");
                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                textPriceSale.setTextColor(Color.RED);
                m_ll.addView(textPriceSale);
            } else {
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
        float precio = 0;
        precio = carro.getTotal();
        totalTextView.setText(Float.toString(precio));
        m_ll.addView(totalTextView);
    }
}