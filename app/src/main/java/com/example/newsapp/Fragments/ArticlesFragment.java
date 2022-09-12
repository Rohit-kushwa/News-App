package com.example.newsapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newsapp.Adapters.ViewPagerAdapter;
import com.example.newsapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class ArticlesFragment extends Fragment {

    TabLayout tabLayout;
    TabItem ArticleForYou, ArticleEntertainment, ArticleHealth, ArticleScience, ArticleSports, ArticleTechnology;
    PagerAdapter pagerAdapter;
    protected ViewPager viewPager;

    String api = "1ecd993c16f44f56b07a5e8cdb2bd5fe";


    public ArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_articles, container, false);

        tabLayout = view.findViewById(R.id.ArticleTab);
        ArticleForYou = view.findViewById(R.id.ForYouTab);
        ArticleEntertainment = view.findViewById(R.id.EntertainmentTab);
        ArticleHealth = view.findViewById(R.id.HealthTab);
        ArticleScience = view.findViewById(R.id.ScienceTab);
        ArticleTechnology = view.findViewById(R.id.TechnologyTab);
        ArticleSports = view.findViewById(R.id.SportTab);
        viewPager = (ViewPager) view.findViewById(R.id.tabFragmentContainer);
        pagerAdapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager(), 6);


       viewPager.setAdapter(new ViewPagerAdapter(requireActivity().getSupportFragmentManager(), 6));

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());
               if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5){
                   pagerAdapter.notifyDataSetChanged();

               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        return view;
    }

}