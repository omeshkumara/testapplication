package com.example.android.android.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {

    //Defining firebaseauth object
    private FirebaseAuth firebaseAuth;
    //Defining ProgressDialog object
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        /**Onclick listener for sign up*/
        Button signup_btn = (Button) findViewById(R.id.sign_up_btn);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        /**Onclick listener for switch_to_login*/
        Button switch_to_login = (Button) findViewById(R.id.switch_to_login);
        switch_to_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent_login = new Intent(Signup.this, Login.class);
                startActivity(intent_login);
            }
        });
    }

    private void registerUser(){
        //Getting user name
        EditText userEditTextView = (EditText) findViewById(R.id.user_name);
        String user_name = userEditTextView.getText().toString();

        //Getting user email
        EditText emailEditTextView = (EditText) findViewById(R.id.user_email);
        String user_email = emailEditTextView.getText().toString();

        //Getting user password
        EditText passwordEditTextView = (EditText) findViewById(R.id.user_password);
        String user_password = passwordEditTextView.getText().toString();

        /**If all the details are filled, then
         * display the progress bar*/
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //Create a new user
        firebaseAuth.createUserWithEmailAndPassword(user_email, user_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(Signup.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            //display some message here
                            Toast.makeText(Signup.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
}
