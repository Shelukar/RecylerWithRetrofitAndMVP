package com.example.onevoice.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by onevoice on 28/2/18.
 */

public class adapter extends RecyclerView.Adapter<adapter.AdapterHolder> {


    private List<Datum> movies;
    private int rowLayout;
    private Context context;


    public static class AdapterHolder extends RecyclerView.ViewHolder {

        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public AdapterHolder(View v) {
            super(v);

            movieTitle = (TextView) v.findViewById(R.id.first_name);
            data = (TextView) v.findViewById(R.id.last_name);
            movieDescription = (TextView) v.findViewById(R.id.avtar);

        }
    }

    public adapter(List<Datum> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public com.example.onevoice.myapplication.adapter.AdapterHolder onCreateViewHolder(ViewGroup parent,
                                                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new AdapterHolder(view);
    }


    @Override
    public void onBindViewHolder(AdapterHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getFirstName());
        holder.data.setText(movies.get(position).getLastName());
        holder.movieDescription.setText(movies.get(position).getAvatar());
        //holder.rating.setText(movies.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
