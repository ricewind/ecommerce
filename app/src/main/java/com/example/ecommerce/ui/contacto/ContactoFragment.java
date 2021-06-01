package com.example.ecommerce.ui.contacto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
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
import com.google.android.gms.common.api.Response;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ContactoFragment extends Fragment {

    private static final int RESULT_OK = 1;
    private ContactoViewModel contactoViewModel;
    private FragmentContactoBinding binding;
    private RadioButton r1, r2;
    private Button butonSiguiente;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactoViewModel = new ViewModelProvider(this).get(ContactoViewModel.class);

        binding = FragmentContactoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        this.root = root;
        this.butonSiguiente = (Button) root.findViewById(R.id.button);
        butonSiguiente.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            //On click function
            public void onClick(View v) {
                r1 = (RadioButton) root.findViewById(R.id.radioButton);
                r2 = (RadioButton) root.findViewById(R.id.radioButton2);
                if (r1.isChecked() == true) {
                    Log.d("Debugardo", "Contactar");
                    LinearLayout m_ll = root.findViewById(R.id.contactLayout);
                    m_ll.removeAllViews();

                    LinearLayout h1 = new LinearLayout(root.getContext());
                    TextView nombre = new TextView(root.getContext());
                    nombre.setText("Nombre: ");
                    h1.addView(nombre);
                    EditText nombreInput = new EditText(root.getContext());
                    nombreInput.setWidth(500);
                    h1.addView(nombreInput);
                    h1.setOrientation(LinearLayout.HORIZONTAL);
                    m_ll.addView(h1);

                    LinearLayout h2 = new LinearLayout(root.getContext());
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
                            } catch (android.content.ActivityNotFoundException ex) {
                                Log.d("Debugardo", "Error sending email...");
                            }
                        }
                    });
                    m_ll.addView(enviar);

                } else if (r2.isChecked() == true) {
                    Log.d("Debugardo", "Reclamar");
                    LinearLayout m_ll = root.findViewById(R.id.contactLayout);
                    m_ll.removeAllViews();

                    LinearLayout h1 = new LinearLayout(root.getContext());
                    TextView nombre = new TextView(root.getContext());
                    nombre.setText("Nombre: ");
                    h1.addView(nombre);
                    EditText nombreInput = new EditText(root.getContext());
                    nombreInput.setWidth(500);
                    h1.addView(nombreInput);
                    h1.setOrientation(LinearLayout.HORIZONTAL);
                    m_ll.addView(h1);

                    LinearLayout h2 = new LinearLayout(root.getContext());
                    TextView email = new TextView(root.getContext());
                    email.setText("Email: ");
                    h2.addView(email);
                    EditText emailInput = new EditText(root.getContext());
                    emailInput.setWidth(500);
                    h2.addView(emailInput);
                    h2.setOrientation(LinearLayout.HORIZONTAL);
                    m_ll.addView(h2);

                    LinearLayout h3 = new LinearLayout(root.getContext());
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


                    ImageView imagen = new ImageView(root.getContext());
                    imagen.setId(382374378);
                    imagen.setImageResource(R.drawable.ic_insert_photo_white_48dp);
                    imagen.setBackground(Drawable.createFromPath("@drawable/editbox"));
                    m_ll.addView(imagen);
                    imagen.getLayoutParams().height = 500;
                    imagen.getLayoutParams().width = 500;
                    imagen.requestLayout();
                    imagen.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            selectImage(imagen);
                        }
                    });


                    Button enviar = new Button((root.getContext()));
                    enviar.setText("Enviar");
                    enviar.setOnClickListener(new View.OnClickListener() {
                        @Override
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


                            emailIntent.putExtra(Intent.EXTRA_STREAM, selectedImage);


                            try {
                                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                                Log.d("Debugardo", "Finished sending email...");
                            } catch (android.content.ActivityNotFoundException ex) {
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

    private void selectImage(ImageView imagen) {
        final CharSequence[] options = {"Choose from Gallery", "Cancel"};
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.getContext());
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    public static final int PICK_IMAGE = 1;
    public Uri selectedImage;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE) {
            Uri selectedImage = data.getData();
            this.selectedImage = selectedImage;
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                @SuppressLint("ResourceType") ImageView imagen = (ImageView) root.findViewById(382374378);
                imagen.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}