package com.adacherSoft.unsplashy.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adacherSoft.unsplashy.R;
import com.adacherSoft.unsplashy.models.Unsplash;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adacher on 11-07-17.
 */

public class UnsplashyAdapter extends RecyclerView.Adapter<UnsplashyAdapter.ViewHolder> {


    private List<Unsplash> unsplashList = new ArrayList<>();


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.splashy_list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Unsplash unsplash = unsplashList.get(position);
        ImageView photo = holder.unsplashPhoto;

        Picasso.get().load(unsplash.getUrls().getSmall()).centerCrop().fit().into(photo);
        TextView textView = holder.userTv;
        textView.setText(unsplash.getUser().getUsername());
        int color = Color.parseColor(unsplash.getColor());
        //holder.userTv.setBackgroundColor(color);
        textView.setBackgroundTintList(ColorStateList.valueOf(color));
        /*ViewCompat.setBackgroundTintList(
                textView,
                ColorStateList.valueOf(color)
        );*/

    }

    @Override
    public int getItemCount() {
        return unsplashList.size();
    }


    public void update(List<Unsplash> unsplashes) {
        unsplashList.addAll(unsplashes);
        notifyDataSetChanged();
    }

    public String getColor(int position) {
        return unsplashList.get(position).getColor();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView unsplashPhoto;
        private TextView userTv;

        public ViewHolder(View itemView) {
            super(itemView);

            unsplashPhoto = (ImageView) itemView.findViewById(R.id.splashPhotoIV);
            userTv = (TextView) itemView.findViewById(R.id.userTv);
        }
    }
}

