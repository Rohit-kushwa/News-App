package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.Objects;

public class SearchActivity extends AppCompatActivity {

    MaterialSearchBar searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        searchBar.openSearch();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}