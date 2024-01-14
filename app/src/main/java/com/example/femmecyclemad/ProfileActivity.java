package com.example.femmecyclemad;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    TextView profileName, profileEmail, profileGender, profilePassword;
    TextView titleName, titleUsername;
    Button editProfile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileGender = findViewById(R.id.profileGender);
        profilePassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);

        showAllUserData();


    }

    public void showAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String genderUser = intent.getStringExtra("gender");
        String passwordUser = intent.getStringExtra("password");

        titleName.setText(nameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileGender.setText(genderUser);
        profilePassword.setText(passwordUser);
    }

    public void passUserData(){
        String userEmail = profileEmail.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userEmail);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String nameFromDB = snapshot.child(userEmail).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userEmail).child("email").getValue(String.class);
                    String usernameFromDB = snapshot.child(userEmail).child("gender").getValue(String.class);
                    String passwordFromDB = snapshot.child(userEmail).child("password").getValue(String.class);

                    Intent intent = new Intent(ProfileActivity.this, EditProfile.class);

                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("gender", usernameFromDB);
                    intent.putExtra("password", passwordFromDB);

                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}