package com.example.ecommerce.ui.ofertas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecommerce.databinding.FragmentOfertasBinding;

public class OfertasFragment extends Fragment {

    private OfertasViewModel ofertasViewModel;
    private FragmentOfertasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ofertasViewModel = new ViewModelProvider(this).get(OfertasViewModel.class);

        binding = FragmentOfertasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textOfertas;
        ofertasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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
