package com.example.android.android.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

    }
    public void home(View view) {
        Intent homeIntent = new Intent(Notification.this, Home.class);
        startActivity(homeIntent);
    }

    public void search(View view) {
        Intent searchIntent = new Intent(Notification.this, Search.class);
        startActivity(searchIntent);
    }
}
