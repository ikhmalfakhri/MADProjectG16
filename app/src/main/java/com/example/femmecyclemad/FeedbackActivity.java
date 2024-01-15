package com.example.femmecyclemad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;

    TextView subject, message;
    private Button button,button1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        button = findViewById(R.id.feedbackSubmit);
        button1 = findViewById(R.id.buttonMenu);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("feedback");

                subject = findViewById(R.id.feedbackSubject);
                message = findViewById(R.id.feedbackMsg);

                String subj = subject.getText().toString();
                String msg = message.getText().toString();

                HelperClass2 helperClass2 = new HelperClass2(subj,msg);
                reference.child(subj).setValue(helperClass2);

                Toast.makeText(FeedbackActivity.this, "Feedback sent!", Toast.LENGTH_SHORT).show();

                onBackPressed();
            }
        });
    }
}