package com.example.newsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Models.ArticleModelClass;
import com.example.newsapp.R;
import com.example.newsapp.webView;

import java.util.ArrayList;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>{

    Context context;
    ArrayList<ArticleModelClass> HomeArticleList;

    public HomeRecyclerViewAdapter(Context context, ArrayList<ArticleModelClass> homeArticleList) {
        this.context = context;
        HomeArticleList = homeArticleList;
    }

    @NonNull
    @Override
    public HomeRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_home_recyclerview, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewAdapter.ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("URL" , HomeArticleList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(context, holder.menu);
                popupMenu.inflate(R.menu.news_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.notInterested:
                                Toast.makeText(context, "Not Interested", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.Report:
                                Toast.makeText(context, "Report", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = HomeArticleList.get(position).getUrl();

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Click Here : " + url);
                context.startActivity(intent);
            }
        });

        holder.bookmark.setOnClickListener(new View.OnClickListener() {

            boolean isChanged = false;
            @Override
            public void onClick(View view) {

                if (isChanged){
                    holder.bookmark.setImageResource(R.drawable.ic_bookmark);
                    isChanged = false;
                }
                else {
                    holder.bookmark.setImageResource(R.drawable.ic_bookmarkk);
                    isChanged = true;
                }

            }
        });

        holder.heading.setText(HomeArticleList.get(position).getTitle());
        holder.description.setText(HomeArticleList.get(position).getDescription());
        Glide.with(context).load(HomeArticleList.get(position).getUrlToImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return HomeArticleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading, description;
        CardView cardView;
        ImageView image;
        ImageView share, bookmark, menu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.HomeNewsHeading);
            description = itemView.findViewById(R.id.HomeNewsDescription);
            image = itemView.findViewById(R.id.HomeNewsImage);
            cardView = itemView.findViewById(R.id.CardViewHomeRecyclerview);
            share = itemView.findViewById(R.id.HomeShareBtn);
            bookmark = itemView.findViewById(R.id.HomeBookmarkBtn);
            menu = itemView.findViewById(R.id.HomeMenuBtn);


        }
    }
}
