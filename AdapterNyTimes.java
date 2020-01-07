package com.example.altkamulassesignment;


import android.content.Context;

import android.content.res.Resources;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.util.Base64;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.altkamulassesignment.model.Media;


import java.util.List;



public class AdapterNyTimes extends RecyclerView.Adapter<AdapterNyTimes.ViewHolder> {


    Context mContext;

    List<Media> media;

    public AdapterNyTimes(Context context,List<Media> media) {
        mContext = context;
        this.media = media;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView picture;

        //*** code changed ***
        //public TextView txt_item_list_product_name;
        public TextView Title;

        //*** code added ***
        public TextView Abstract;

        public TextView date;


        public ViewHolder(@NonNull View v) {
            super(v);
            picture = v.findViewById(R.id.image);
            Abstract = v.findViewById(R.id.tvAbs);
            Title = v.findViewById(R.id.tvArticalBy);
            date = v.findViewById(R.id.date);


        }
    }



    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public AdapterNyTimes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_all_products, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        try {
            Glide.with(mContext).load(media.get(position).getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.picture);
            holder.date.setText(media.get(position).getPublished_date());
            holder.Abstract.setText(media.get(position).getAbstract());
            holder.Title.setText(media.get(position).getTitle());


        } catch (Exception e) {

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return media.size();
    }




    public static boolean isNetworkAvalible(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}

