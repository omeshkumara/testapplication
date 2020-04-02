package com.example.android.android.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, MainActivity.class));
        }

        ImageButton sendButton = (ImageButton) findViewById(R.id.send_btn);
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                sendMessage();
                //Toast.makeText(ProfileActivity.this, "sent", Toast.LENGTH_SHORT).show();
            }
        });

        //LOG OUT BUTTON
        Button log_out = (Button) findViewById(R.id.log_out_btn);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });

    }

    private void sendMessage(){

        //Getting current user
        //FirebaseUser user = firebaseAuth.getCurrentUser();
        //String u = user.toString();
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseReference = mDatabase.getReference();

        EditText messageEditTextView = (EditText) findViewById(R.id.post_content);
        UserPost userpost = new UserPost(messageEditTextView.getText().toString());
        mDatabaseReference = mDatabase.getReference().child("user");
        mDatabaseReference.setValue(userpost);
        Toast.makeText(this, "sent", Toast.LENGTH_SHORT).show();
    }

    /*public void search(View view) {
        Intent searchIntent = new Intent(Home.this, Search.class);
        startActivity(searchIntent);
    }

    public void notification(View view) {
        Intent notificationIntent = new Intent(Home.this, Notification.class);
        startActivity(notificationIntent);
    }*/
}
