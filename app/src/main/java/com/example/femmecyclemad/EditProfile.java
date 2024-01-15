package com.example.femmecyclemad;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity {

    EditText editGender, editEmail, editUsername, editPassword;
    Button saveButton;
    String genderUser, emailUser, usernameUser, passwordUser;
    DatabaseReference reference;
    Spinner spinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        reference = FirebaseDatabase.getInstance().getReference("users");

        editGender= findViewById(R.id.editGender);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editName);
        editPassword = findViewById(R.id.editPassword);
        saveButton = findViewById(R.id.saveButton);


        showData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGenderChanged() || isPasswordChanged() || isEmailChanged()){
                    Toast.makeText(EditProfile.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditProfile.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isGenderChanged() {
        if (!genderUser.equals(editGender.getText().toString())){
            reference.child(usernameUser).child("name").setValue(editGender.getText().toString());
            genderUser = editGender.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!emailUser.equals(editEmail.getText().toString())){
            reference.child(usernameUser).child("email").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
            return true;
        } else {
            return false;
        }
    }


    private boolean isPasswordChanged() {
        if (!passwordUser.equals(editPassword.getText().toString())){
            reference.child(usernameUser).child("password").setValue(editPassword.getText().toString());
            passwordUser = editPassword.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public void showData(){

        Intent intent = getIntent();

        genderUser = intent.getStringExtra("gender");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("name");
        passwordUser = intent.getStringExtra("password");

        editGender.setText(genderUser);
        editEmail.setText(emailUser);
        editUsername.setText(usernameUser);
        editPassword.setText(passwordUser);
    }
}