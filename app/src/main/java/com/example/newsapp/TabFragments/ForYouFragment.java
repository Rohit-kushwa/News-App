package com.example.newsapp.TabFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.newsapp.Adapters.RecyclerViewAdapter;
import com.example.newsapp.ApiInterface;
import com.example.newsapp.Models.ArticleArrayModelClass;
import com.example.newsapp.Models.ArticleModelClass;
import com.example.newsapp.R;
import com.example.newsapp.Utilities.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForYouFragment extends Fragment {

    String api = "1ecd993c16f44f56b07a5e8cdb2bd5fe";
    ArrayList<ArticleModelClass> list;
    RecyclerView.Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewofForYOu;

    public ForYouFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_for_you, container, false);

        recyclerViewofForYOu = view.findViewById(R.id.RecyclerViewofForYou);
        list = new ArrayList<>();
        recyclerViewofForYOu.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = (RecyclerView.Adapter) new RecyclerViewAdapter(getContext(), list);
        recyclerViewofForYOu.setAdapter((RecyclerView.Adapter) adapter);

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