package com.example.android.android.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }

    public void home(View view) {
        Intent homeIntent = new Intent(Search.this, Home.class);
        startActivity(homeIntent);
    }

    public void notification(View view) {
        Intent notificationIntent = new Intent(Search.this, Notification.class);
        startActivity(notificationIntent);
    }
}
