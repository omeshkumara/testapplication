package com.example.android.android.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView search= findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent searchIntent= new Intent(Home.this, Search.class);
                startActivity(searchIntent);
            }
        });

        ImageView notification= findViewById(R.id.notification);

        notification.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent notificationIntent= new Intent(Home.this, Notification.class);
                startActivity(notificationIntent);
            }
        });

    }
}
