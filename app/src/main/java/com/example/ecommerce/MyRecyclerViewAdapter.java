package com.example.ecommerce;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.model.Game;

import java.util.Date;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Game> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, List<Game> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = mData.get(position).TITLE;
        holder.myTextTitle.setText(title);

        String description = mData.get(position).DESCRIPTION;
        holder.myTextDescription.setText(description);

        float price = mData.get(position).PRICE;
        holder.myTextPrice.setText("" + price);
        if (mData.get(position).SALE == 1){
            float salePrice = mData.get(position).SALE_PRICE;
            holder.myTextSalePrice.setText("" + salePrice);
            holder.myTextSalePrice.setTextColor(Color.RED);
        }

        Date date = mData.get(position).DATE;
        holder.myTextDate.setText("" + date);

        String image = mData.get(position).IMAGE;
        int draw = holder.itemView.getResources().getIdentifier(image, "drawable",holder.itemView.getContext().getPackageName());
        holder.myImage.setImageResource(draw);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myImage;
        TextView myTextTitle;
        TextView myTextDescription;
        TextView myTextPrice;
        TextView myTextSalePrice;
        TextView myTextDate;


        ViewHolder(View itemView) {
            super(itemView);
            myTextTitle = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(this);

            myImage = itemView.findViewById(R.id.image);
            myTextDescription = itemView.findViewById(R.id.description);
            myTextPrice = itemView.findViewById(R.id.price);
            myTextSalePrice = itemView.findViewById(R.id.salePrice);
            myTextDate = itemView.findViewById(R.id.date);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Game getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
