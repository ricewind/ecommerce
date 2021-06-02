package com.example.ecommerce.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.DynamicListAdapter;
import com.example.ecommerce.ListObject;
import com.example.ecommerce.Utilities;
import com.example.ecommerce.databinding.FragmentHomeBinding;
import com.example.ecommerce.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private ArrayList<ListObject> firstList = new ArrayList<>();
    private ArrayList<ListObject> secondList = new ArrayList<>();


    private RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManager;

    private DynamicListAdapter mDynamicListAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mRecyclerView = root.findViewById(R.id.my_list);

        Utilities u = new Utilities(getContext());
        firstList = u.populateFirstList();
        secondList = u.populateSecondList();


        // Initialize the list
        mDynamicListAdapter = new DynamicListAdapter(false);
        mDynamicListAdapter.setFirstList(firstList);
        mDynamicListAdapter.setSecondList(secondList);


        mLayoutManager = new LinearLayoutManager(root.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mDynamicListAdapter);






        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        homeViewModel.setImage(homeViewModel.getImage());
        binding = null;
    }
}