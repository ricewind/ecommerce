package com.example.ecommerce.ui.ofertas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.GameDetail;
import com.example.ecommerce.MyRecyclerViewAdapter;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.FragmentOfertasBinding;
import com.example.ecommerce.model.Game;
import com.example.ecommerce.model.GamesDB;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OfertasFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener{
    static int version = 2;
    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
    private OfertasViewModel OfertasViewModel;
    private FragmentOfertasBinding binding;
    MyRecyclerViewAdapter adapter;
    List <Game> games;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        OfertasViewModel = new ViewModelProvider(this).get(OfertasViewModel.class);

        binding = FragmentOfertasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        games = createGames(root);
        OfertasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.dataOfertas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext());

        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(root.getContext(), games);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        return root;
    }


    @Override
    public void onItemClick(View view, int position) {
        System.out.println(position);

        Game selectedGame = null;
        for (Game a : games) {
            if (a.ID == adapter.getItem(position).ID) {
                selectedGame = a;
            }
        }

        Gson gson = new Gson();
        String gameDataParced = gson.toJson(selectedGame);
        Bundle bundle = new Bundle();
        bundle.putString("game", gameDataParced);

        Fragment newFragment = new GameDetail();
        newFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_content_main, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }      //ddd

    public List<Game> createGames(View v) {
        GamesDB admin = new GamesDB(v.getContext(), version);
        SQLiteDatabase bd = admin.getReadableDatabase();
        Cursor fila = bd.rawQuery("select *, PRICE - SALE_PRICE as diff from Game where SALE = 1 order by diff desc", null);
        List<Game> games = new ArrayList<Game>();
        if (fila.moveToFirst()) {
            do {
                try {
                    games.add(new Game(fila.getInt(0), fila.getString(1), fila.getString(2), fila.getFloat(3), fila.getString(4), formatter1.parse(fila.getString(5)), fila.getInt(6), fila.getFloat(7), fila.getInt(8), fila.getInt(9)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } while (fila.moveToNext());
        }
        bd.close();
        return games;
    }
}