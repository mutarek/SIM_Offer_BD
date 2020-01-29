package com.bdsoftwaresolution.simofferbd.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotelsAdapters extends RecyclerView.Adapter<HotelsAdapters.HotelsViewHolder> {
    @NonNull
    @Override
    public HotelsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HotelsViewHolder extends RecyclerView.ViewHolder {
        private TextView name,price,address;
        private RatingBar ratingBar;
        private ImageView imageView;
        public HotelsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
