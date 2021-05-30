package com.example.ecommerce.ui.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecommerce.R;
import com.example.ecommerce.databinding.FragmentLocationBinding;

public class LocationFragment extends Fragment{

    private LocationViewModel locationViewModel;
    private FragmentLocationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        locationViewModel = new ViewModelProvider(this).get(LocationViewModel.class);

        binding = FragmentLocationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLocation;
        locationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
