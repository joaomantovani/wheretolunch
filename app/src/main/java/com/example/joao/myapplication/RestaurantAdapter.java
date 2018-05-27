package com.example.joao.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private List<Restaurant> restaurantList;

    public RestaurantAdapter(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    // you provide access to all the views for a data item in a view holder
    // Complex data items may need more than one view per item, and
    // Provide a reference to the views for each data item
    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView restaurantName;
        TextView restaurantDescription;
        ImageView restaurantPhoto;

        RestaurantViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            restaurantName = (TextView)itemView.findViewById(R.id.restaurant_name);
            restaurantDescription = (TextView)itemView.findViewById(R.id.restaurant_description);
            restaurantPhoto = (ImageView)itemView.findViewById(R.id.restaurant_photo);
        }

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }


    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);

        return new RestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int i) {
        holder.restaurantName.setText(restaurantList.get(i).getName());
        holder.restaurantDescription.setText(restaurantList.get(i).getDescription());
        holder.restaurantPhoto.setImageResource(restaurantList.get(i).getPhotoId());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
