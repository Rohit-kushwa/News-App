package com.example.newsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.Adapters.HomeRecyclerViewAdapter;
import com.example.newsapp.Adapters.RecyclerViewAdapter;
import com.example.newsapp.Models.ArticleArrayModelClass;
import com.example.newsapp.Models.ArticleModelClass;
import com.example.newsapp.R;
import com.example.newsapp.Utilities.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api = "1ecd993c16f44f56b07a5e8cdb2bd5fe";
    ArrayList<ArticleModelClass> list;
    RecyclerView.Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewofHome;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewofHome = view.findViewById(R.id.RecyclerViewofHome);
        list = new ArrayList<>();
        recyclerViewofHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = (RecyclerView.Adapter) new HomeRecyclerViewAdapter(getContext(), list);
        recyclerViewofHome.setAdapter((RecyclerView.Adapter) adapter);

        findNews();

        return view;
    }

    private void findNews(){
        ApiUtilities.getApiInterface().getNews(country, 100, api).enqueue(new Callback<ArticleArrayModelClass>() {
            @Override
            public void onResponse(Call<ArticleArrayModelClass> call, Response<ArticleArrayModelClass> response) {
                list.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArticleArrayModelClass> call, Throwable t) {

            }
        });
    }
}