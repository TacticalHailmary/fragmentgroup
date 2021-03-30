package com.example.fragmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        SharedPreferences preferences = getSharedPreferences("location", Context.MODE_PRIVATE);
        TextView txtResults = findViewById(R.id.txtResults);
        int score = preferences.getInt("score", 0);
        if (score != 1) {
            txtResults.setText(String.format("You saw Carmen Sandiego %s times", score));
        } else {
            txtResults.setText(String.format("You saw Carmen Sandiego %s time", score));
        }
    }
}