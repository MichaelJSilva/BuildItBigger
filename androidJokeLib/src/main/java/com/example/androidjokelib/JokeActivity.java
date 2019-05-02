package com.example.androidjokelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public final static String JOKE_TAG = "Joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);


        TextView textview = (TextView) findViewById(R.id.joke_text);


        String JokeResult = null;
        Intent intent = getIntent();
        JokeResult = intent.getStringExtra(JOKE_TAG);

        if (JokeResult != null) {
            textview.setText(JokeResult);
        } else {
            textview.setText("The joke is on you!");
        }

    }
}
