package com.example.android.android.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.log_in_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent= new Intent(Login.this, Home.class);
                startActivity(numbersIntent);
                Toast.makeText(Login.this, "logged in", Toast.LENGTH_SHORT).show();
            }
        });

        Button switch_to_signup = (Button) findViewById(R.id.create_acc);
        switch_to_signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent_signup = new Intent(Login.this, Signup.class);
                startActivity(intent_signup);
            }
        });
    }
}
