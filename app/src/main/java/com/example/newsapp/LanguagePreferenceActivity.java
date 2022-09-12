package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LanguagePreferenceActivity extends AppCompatActivity {

    ListView languageListView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_preference);

        toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        final String[] list = {"English", "Hindi"};
        languageListView = findViewById(R.id.language_listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(LanguagePreferenceActivity.this, android.R.layout.select_dialog_singlechoice, list);
        languageListView.setAdapter(adapter);

        languageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(LanguagePreferenceActivity.this, "Selected " + list[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}