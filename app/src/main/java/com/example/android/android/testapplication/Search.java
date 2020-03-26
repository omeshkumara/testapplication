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

        ImageView home= findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent homeIntent= new Intent(Search.this, Home.class);
                startActivity(homeIntent);
            }
        });

        ImageView search= findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent searchIntent= new Intent(Search.this, Search.class);
                startActivity(searchIntent);
            }
        });

        ImageView notification= findViewById(R.id.notification);

        notification.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent notificationIntent= new Intent(Search.this, Notification.class);
                startActivity(notificationIntent);
            }
        });
    }
}
