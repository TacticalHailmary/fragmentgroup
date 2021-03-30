package com.example.fragmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Area3 extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Random random;
    ImageView hiding;
    ImageView carmen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Disable Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area3);

        //Putting together the preferences
        preferences = getSharedPreferences("location", Context.MODE_PRIVATE);
        editor = preferences.edit();

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        carmen = findViewById(R.id.carmen);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Area3.this, Area1.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Area3.this,Area2.class));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Area3.this,Area3.class));
            }
        });

        /* Leaves */
        ImageView leaf1 = findViewById(R.id.imageView);
        ImageView leaf2 = findViewById(R.id.imageView2);
        ImageView leaf3 = findViewById(R.id.imageView3);
        ImageView leaf4 = findViewById(R.id.imageView4);

        ImageView[] images = new ImageView[]{leaf1, leaf2, leaf3, leaf4};
        for(int i = 0; i < 4; i++){
            random = new Random();
            images[i].setTranslationX(random.nextInt(900));
            random = new Random();
            images[i].setTranslationY(random.nextInt(1500));
        }

        if(preferences.getInt("area", 4) == 0){
            carmen.setVisibility(View.VISIBLE);
            random = new Random();
            hiding = images[random.nextInt(4)];
            carmen.setTranslationX(hiding.getTranslationX());
            carmen.setTranslationY(hiding.getTranslationY());
            hiding.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int score = preferences.getInt("score", 0) + 1;
                    editor.remove("score").commit();
                    editor.putInt("score", score).commit();
                    hiding.setVisibility(View.GONE);
                    Toast.makeText(Area3.this, String.valueOf(score), Toast.LENGTH_SHORT).show();

                    editor.remove("area").commit();
                    random = new Random();
                    editor.putInt("area", random.nextInt(3)).commit();

                    carmen.setVisibility(View.INVISIBLE);
                }
            });
        }
        else{
            carmen.setVisibility(View.GONE);
        }
        /* Leaves */
    }
}