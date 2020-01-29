package com.bdsoftwaresolution.simofferbd.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bdsoftwaresolution.simofferbd.R;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapterExample extends
        SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;
    private int mCount;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.sample_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        switch (position) {
            case 0:
                viewHolder.textViewDescription.setText("Beautiful Sajek Valley");
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.bangladesh)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                viewHolder.textViewDescription.setText("Beautiful Cox's Bazar");
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.first_attractions)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 4:
                viewHolder.textViewDescription.setText("Beautiful Sylhet");
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.shylet_three)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            default:
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.textViewDescription.setText("Ohhhh! look at this moment!");
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.header)
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                Glide.with(viewHolder.itemView)
                        .asGif()
                        .load(R.drawable.oh_look_at_this)
                        .into(viewHolder.imageGifContainer);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mCount;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }


}

