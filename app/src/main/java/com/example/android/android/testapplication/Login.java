package com.example.android.android.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
