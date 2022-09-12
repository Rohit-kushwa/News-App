package com.example.newsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Models.ArticleModelClass;
import com.example.newsapp.R;
import com.example.newsapp.webView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<ArticleModelClass> ArticleList;

    public RecyclerViewAdapter(Context context, ArrayList<ArticleModelClass> articleList) {
        this.context = context;
        ArticleList = articleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.layout_recyclerview, null, false);

       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("URL" , ArticleList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.heading.setText(ArticleList.get(position).getTitle());
        holder.description.setText(ArticleList.get(position).getDescription());
        holder.authorName.setText(new StringBuilder().append("By ").append(ArticleList.get(position).getAuthor()).toString());
        holder.publishAt.setText(new StringBuilder().append("Published At : ").append(ArticleList.get(position).getPublishedAt()).toString());

        Glide.with(context).load(ArticleList.get(position).getUrlToImage()).into(holder.image);

        Log.d("Mytag", "onBindViewHolder: " + ArticleList.get(position).getUrlToImage());


    }

    @Override
    public int getItemCount() {
        return ArticleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading, description, authorName, publishAt;
        CardView cardView;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.TopHealines);
            description = itemView.findViewById(R.id.newsDescription);
            authorName = itemView.findViewById(R.id.newsAuthorName);
            publishAt = itemView.findViewById(R.id.newsPublishAt);
            image = itemView.findViewById(R.id.newsImage);
            cardView = itemView.findViewById(R.id.CardView);

        }
    }
}
