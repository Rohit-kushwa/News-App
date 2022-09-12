package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.newsapp.Fragments.ArticlesFragment;
import com.example.newsapp.Fragments.HomeFragment;
import com.example.newsapp.Fragments.LiveFragment;
import com.example.newsapp.Fragments.MycityFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    Toolbar toolbar;
    ImageView HamburgerMenuBtn, notificationBtn, searchBtn, menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HamburgerMenuBtn = findViewById(R.id.toolbarHamburgerMenu);
        notificationBtn = findViewById(R.id.toolbarNotification);
        searchBtn = findViewById(R.id.toolbarSearch);
        menuBtn = findViewById(R.id.toolbarMenu);
        toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        bottomNav = findViewById(R.id.bottomNav);




        HamburgerMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HamburgerMenu Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "notificationBtn Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, menuBtn);
                popupMenu.inflate(R.menu.toolbar_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.showBookmarks:
                                Toast.makeText(MainActivity.this, "Show Bookmarks", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.LanguagePreferences:
                                startActivity(new Intent(MainActivity.this, LanguagePreferenceActivity.class));
                                break;
                            case R.id.TextSize:
                                Toast.makeText(MainActivity.this, "Change Language", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.Settings:
                                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });


        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.navHome:
                        transaction.replace(R.id.fragmentContainerView, new HomeFragment());
                        break;
                    case R.id.navArticles:
                        transaction.replace(R.id.fragmentContainerView, new ArticlesFragment());
                        break;
                    case R.id.navMycity:
                        transaction.replace(R.id.fragmentContainerView, new MycityFragment());
                        break;
                    case R.id.navLive:
                        transaction.replace(R.id.fragmentContainerView, new LiveFragment());

                    default: break;
                }
                transaction.commit();
                return true;
            }
        });

    }


    @Override
    public void onBackPressed() {
        if (bottomNav.getSelectedItemId() == R.id.navHome){
            super.onBackPressed();
            finish();
        }
        else{
            bottomNav.setSelectedItemId(R.id.navHome);
        }
    }
}