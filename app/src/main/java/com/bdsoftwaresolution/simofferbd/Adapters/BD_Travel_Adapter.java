package com.bdsoftwaresolution.simofferbd.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bdsoftwaresolution.simofferbd.Interfaces.Each_Blog_Click;
import com.bdsoftwaresolution.simofferbd.Models.BD_travel_model;
import com.bdsoftwaresolution.simofferbd.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BD_Travel_Adapter extends RecyclerView.Adapter<BD_Travel_Adapter.BD_Travel_view_holder> {
    private Each_Blog_Click each_blog_click;
    private List<BD_travel_model> bd_travel_models;
    private Context context;

    public BD_Travel_Adapter(Each_Blog_Click each_blog_click, List<BD_travel_model> bd_travel_models, Context context) {
        this.each_blog_click = each_blog_click;
        this.bd_travel_models = bd_travel_models;
        this.context = context;
    }

    @NonNull
    @Override
    public BD_Travel_view_holder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.bd_travel_sample_layout, parent, false);
        final BD_Travel_view_holder view_holder = new BD_Travel_view_holder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                each_blog_click.OnBlogClick(parent,view_holder.getPosition());
            }
        });

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BD_Travel_view_holder holder, int position) {
        holder.title.setText(bd_travel_models.get(position).getTitle());
        holder.spot.setText(bd_travel_models.get(position).getSpot());
        Picasso.get().load(bd_travel_models.get(position).getImg()).placeholder(R.drawable.placeholder).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return bd_travel_models.size();
    }

    public class BD_Travel_view_holder extends RecyclerView.ViewHolder {

        private TextView title,spot;
        private ImageView imageView;

        public BD_Travel_view_holder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.blog_title_id);
            imageView = itemView.findViewById(R.id.blog_image_id);
            spot = itemView.findViewById(R.id.blog_spot_id);
        }
    }
}
