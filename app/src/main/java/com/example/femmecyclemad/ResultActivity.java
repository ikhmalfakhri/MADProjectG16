package com.example.femmecyclemad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ResultActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    TextView textView ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = findViewById(R.id.textView);
        int score = getIntent().getIntExtra("Resute",0);
        textView.setText("Your Score : " + score+"/5");

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("user");



        findViewById(R.id.btn_restart).setOnClickListener(
                restart->{
                    Intent intent = new Intent(this, HomeFragment.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
        );
    }
}