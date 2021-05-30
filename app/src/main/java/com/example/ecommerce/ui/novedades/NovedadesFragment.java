package com.example.ecommerce.ui.novedades;
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

import com.example.ecommerce.R;
import com.example.ecommerce.databinding.FragmentNovedadesBinding;

public class NovedadesFragment extends Fragment{
    
    private NovedadesViewModel novedadesViewModel;
    private FragmentNovedadesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        novedadesViewModel = new ViewModelProvider(this).get(NovedadesViewModel.class);

        binding = FragmentNovedadesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNovedades;
        novedadesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
