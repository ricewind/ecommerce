package com.example.ecommerce.ui.contacto;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecommerce.MainActivity;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.FragmentContactoBinding;

public class ContactoFragment extends Fragment {

    private ContactoViewModel contactoViewModel;
    private FragmentContactoBinding binding;
    private RadioButton r1,r2;
    private Button butonSiguiente;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactoViewModel = new ViewModelProvider(this).get(ContactoViewModel.class);

        binding = FragmentContactoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        this.butonSiguiente = (Button) root.findViewById(R.id.button);
        butonSiguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View v){
                r1 = (RadioButton) root.findViewById(R.id.radioButton);
                r2 = (RadioButton) root.findViewById(R.id.radioButton2);
                if (r1.isChecked() == true) {
                    Log.d("Debugardo", "Contactar");
                    LinearLayout m_ll = root.findViewById(R.id.contactLayout);
                    m_ll.removeAllViews();

                    LinearLayout h1 =  new LinearLayout(root.getContext());
                    TextView nombre = new TextView(root.getContext());
                    nombre.setText("Nombre: ");
                    h1.addView(nombre);
                    EditText nombreInput = new EditText(root.getContext());
                    nombreInput.setWidth(500);
                    h1.addView(nombreInput);
                    h1.setOrientation(LinearLayout.HORIZONTAL);
                    m_ll.addView(h1);

                    LinearLayout h2 =  new LinearLayout(root.getContext());
                    TextView email = new TextView(root.getContext());
                    email.setText("Email: ");
                    h2.addView(email);
                    EditText emailInput = new EditText(root.getContext());
                    emailInput.setWidth(500);
                    h2.addView(emailInput);
                    h2.setOrientation(LinearLayout.HORIZONTAL);
                    m_ll.addView(h2);

                    TextView consulta = new TextView(root.getContext());
                    consulta.setText("Consulta: ");
                    m_ll.addView(consulta);
                    EditText consultaInput = new EditText(root.getContext());
                    consultaInput.setWidth(500);
                    m_ll.addView(consultaInput);

                    Button enviar = new Button((root.getContext()));
                    enviar.setText("Enviar");
                    enviar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        //On click function
                        public void onClick(View v) {
                            Log.d("Salchicha", "Email contactar");
                            String[] TO = {"julio.robles@live.u-tad.com"};
                            String message;
                            message = "Nombre: " + nombreInput.getText() + "\n Email: " + emailInput.getText() + "\n Consulta:\n" + consultaInput.getText();
                            Intent emailIntent = new Intent(Intent.ACTION_SEND);

                            emailIntent.setData(Uri.parse("mailto:"));
                            emailIntent.setType("text/plain");
                            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact details");
                            emailIntent.putExtra(Intent.EXTRA_TEXT, message);

                            try {
                                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                                Log.d("Debugardo", "Finished sending email...");
                            }
                            catch (android.content.ActivityNotFoundException ex) {
                                Log.d("Debugardo", "Error sending email...");
                            }
                        }
                    });
                    m_ll.addView(enviar);

                }
                else if (r2.isChecked() == true) {
                    Log.d("Debugardo", "Reclamar");
                    LinearLayout m_ll = root.findViewById(R.id.contactLayout);
                    m_ll.removeAllViews();

                    LinearLayout h1 =  new LinearLayout(root.getContext());
                    TextView nombre = new TextView(root.getContext());
                    nombre.setText("Nombre: ");
                    h1.addView(nombre);
                    EditText nombreInput = new EditText(root.getContext());
                    nombreInput.setWidth(500);
                    h1.addView(nombreInput);
                    h1.setOrientation(LinearLayout.HORIZONTAL);
                    m_ll.addView(h1);

                    LinearLayout h2 =  new LinearLayout(root.getContext());
                    TextView email = new TextView(root.getContext());
                    email.setText("Email: ");
                    h2.addView(email);
                    EditText emailInput = new EditText(root.getContext());
                    emailInput.setWidth(500);
                    h2.addView(emailInput);
                    h2.setOrientation(LinearLayout.HORIZONTAL);
                    m_ll.addView(h2);

                    LinearLayout h3 =  new LinearLayout(root.getContext());
                    TextView idFactura = new TextView(root.getContext());
                    idFactura.setText("ID factura: ");
                    h3.addView(idFactura);
                    EditText idFacturaInput = new EditText(root.getContext());
                    idFacturaInput.setWidth(500);
                    h3.addView(idFacturaInput);
                    h3.setOrientation(LinearLayout.HORIZONTAL);
                    m_ll.addView(h3);

                    TextView motivo = new TextView(root.getContext());
                    motivo.setText("Consulta: ");
                    m_ll.addView(motivo);
                    EditText motivoInput = new EditText(root.getContext());
                    motivoInput.setWidth(500);
                    m_ll.addView(motivoInput);

                    Button enviar = new Button((root.getContext()));
                    enviar.setText("Enviar");
                    enviar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        //On click function
                        public void onClick(View v) {
                            Log.d("Salchicha", "Email contactar");
                            String[] TO = {"julio.robles@live.u-tad.com"};
                            String message;
                            message = "Nombre: " + nombreInput.getText() + "\n Email: " + emailInput.getText() + "\n ID factura: " + idFacturaInput.getText() + "\n Consulta:\n" + motivoInput.getText();
                            Intent emailIntent = new Intent(Intent.ACTION_SEND);

                            emailIntent.setData(Uri.parse("mailto:"));
                            emailIntent.setType("text/plain");
                            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact details");
                            emailIntent.putExtra(Intent.EXTRA_TEXT, message);

                            try {
                                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                                Log.d("Debugardo", "Finished sending email...");
                            }
                            catch (android.content.ActivityNotFoundException ex) {
                                Log.d("Debugardo", "Error sending email...");
                            }
                        }
                    });
                    m_ll.addView(enviar);
                }
            }
        });

        contactoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
}