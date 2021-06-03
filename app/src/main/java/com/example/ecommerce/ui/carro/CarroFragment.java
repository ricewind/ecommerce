package com.example.ecommerce.ui.carro;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
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

        totalTextView = root.findViewById(R.id.text_carro);

        carro = Carro.getClase();
        ArrayList<Game> carroList = carro.getLista();
        lista = carroList;
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
        View temp = v;
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

            TextView textPrice = new TextView(v.getContext());
            textPrice.setText("" + games.get(i).PRICE + "€");
            textPrice.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            m_ll.addView(textPrice);

            if (games.get(i).SALE == 1) {
                TextView textPriceSale = new TextView(v.getContext());
                textPriceSale.setText("" + games.get(i).SALE_PRICE + "€");
                textPriceSale.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                textPriceSale.setTextColor(Color.RED);
                m_ll.addView(textPriceSale);
            }

            TextView textDate = new TextView(v.getContext());
            textDate.setText("" + games.get(i).DATE);
            textDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            m_ll.addView(textDate);
        }
        float precio = 0;
        precio = carro.getTotal();
        System.out.println(precio);
        totalTextView.setText("Total a pagar: " + precio +"€");

        Button pagar = (Button) v.findViewById(R.id.pagar);
        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            //On click function
            public void onClick(View v) {
                m_ll.removeAllViews();

                LinearLayout h1 = new LinearLayout(v.getContext());
                TextView nombre = new TextView(v.getContext());
                nombre.setText("Nombre: ");
                h1.addView(nombre);
                EditText nombreInput = new EditText(v.getContext());
                nombreInput.setWidth(500);
                h1.addView(nombreInput);
                h1.setOrientation(LinearLayout.HORIZONTAL);
                m_ll.addView(h1);

                LinearLayout h2 = new LinearLayout(v.getContext());
                TextView dir = new TextView(v.getContext());
                dir.setText("Dir: ");
                h2.addView(dir);
                EditText dirInput = new EditText(v.getContext());
                dirInput.setWidth(500);
                h2.addView(dirInput);
                h2.setOrientation(LinearLayout.HORIZONTAL);
                m_ll.addView(h2);

                LinearLayout h3 = new LinearLayout(v.getContext());
                TextView tel = new TextView(v.getContext());
                tel.setText("Teléfono: ");
                h3.addView(tel);
                EditText telInput = new EditText(v.getContext());
                telInput.setWidth(500);
                h3.addView(telInput);
                h3.setOrientation(LinearLayout.HORIZONTAL);
                m_ll.addView(h3);

                LinearLayout h4 = new LinearLayout(v.getContext());
                TextView email = new TextView(v.getContext());
                email.setText("Email: ");
                h4.addView(email);
                EditText emailInput = new EditText(v.getContext());
                emailInput.setWidth(500);
                h4.addView(emailInput);
                h4.setOrientation(LinearLayout.HORIZONTAL);
                m_ll.addView(h4);

                TextView metodo = new TextView(v.getContext());
                metodo.setText("Método de pago: ");
                m_ll.addView(metodo);

                RadioGroup metodoPago = new RadioGroup(v.getContext());
                RadioButton Tarjeta = new RadioButton(v.getContext());
                Tarjeta.setText("Tarjeta");
                metodoPago.addView(Tarjeta);
                RadioButton PayPal = new RadioButton(v.getContext());
                PayPal.setText("PayPal");
                metodoPago.addView(PayPal);
                m_ll.addView(metodoPago);

                Button comprar = new Button((v.getContext()));
                comprar.setText("Comprar");
                comprar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    //On click function
                    public void onClick(View v) {
                        Log.d("Salchicha", "Email contactar");
                        String[] TO = {""+emailInput.getText()};
                        String message;
                        message = "Nombre: " + nombreInput.getText() + "\n Dirección: " + dirInput.getText() + "\n Teléfono: " + telInput.getText() + "\n Email: " + emailInput.getText();

                        for (int i = 0; i < lista.size(); i++) message += "\n\n Game "+ i + "\nTitle: " + lista.get(i).TITLE + "\n Price: " + lista.get(i).PRICE;

                        message += "\n\n Total: " + carro.getTotal();

                        Intent emailIntent = new Intent(Intent.ACTION_SEND);

                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.setType("text/plain");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact details");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

                        try {
                            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                            Log.d("Debugardo", "Finished sending email...");
                        } catch (ActivityNotFoundException ex) {
                            Log.d("Debugardo", "Error sending email...");
                        }
                    }
                });
                m_ll.addView(comprar);
            }
        });
    }
}