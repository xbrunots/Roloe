package com.devbruno.superfit.presentation.drawer.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.devbruno.superfit.R;
import com.devbruno.superfit.infraestruture.Constants;
import com.devbruno.superfit.model.DrawerItens;
import com.devbruno.superfit.presentation.drawer.DrawerActivity;
import com.devbruno.superfit.presentation.home.HomeActivity;

import java.util.List;

/**
 * Created by bsilvabr on 12/02/2018.
 */

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.GenreAdapterViewHolder> {

    private final DrawerActivity mActivity;
    public List<DrawerItens> genres;
    private int rowLayout;
    private Context context;

    public class GenreAdapterViewHolder extends RecyclerView.ViewHolder {
        LinearLayout genreLayout;
        Button textView;


        public GenreAdapterViewHolder(View v) {
            super(v);
            genreLayout = (LinearLayout) v.findViewById(R.id.layoutItem);
            textView = (Button) v.findViewById(R.id.txtValue);
        }
    }

    public DrawerAdapter(List<DrawerItens> genres, int rowLayout, Context context) {
        this.genres = genres;
        this.rowLayout = rowLayout;
        this.context = context;
        this.mActivity = (DrawerActivity) context;
    }

    @Override
    public DrawerAdapter.GenreAdapterViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DrawerAdapter.GenreAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DrawerAdapter.GenreAdapterViewHolder holder, final int position) {

        holder.textView.setText(String.valueOf(genres.get(position).getName()));

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, HomeActivity.class);
                intent.putExtra(Constants.ARGUMENT_GENRES, genres.get(position));
                mActivity.startActivity(intent);
            }
        };
        holder.genreLayout.setOnClickListener(onClickListener);
        holder.textView.setOnClickListener(onClickListener);
    }


    @Override
    public int getItemCount() {
        return genres.size();
    }

}