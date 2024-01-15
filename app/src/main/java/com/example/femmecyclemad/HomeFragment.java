package com.example.femmecyclemad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    Button button1, button2, button3, button4;
    TextView profileName;
    TextView titleName;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);

        profileName = v.findViewById(R.id.profileName);
        titleName = v.findViewById(R.id.userDisplay);
        showUser();

        button1=v.findViewById(R.id.buttonInfo1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo1();
            }
        });

        button2=v.findViewById(R.id.buttonInfo2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo5();
            }
        });

        button3=v.findViewById(R.id.buttonInfo3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo7();
            }
        });

        button4=v.findViewById(R.id.buttonInfo4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo4();
            }
        });

        return v;
    }

    private void showUser() {
        Intent intent = getActivity().getIntent();
        String nameUser = intent.getStringExtra("name");
        titleName.setText("Welcome, "+nameUser);
    }

    public void showUserQ(){
        Intent intentQ = getActivity().getIntent();
        String nameUser = intentQ.getStringExtra("name");
        titleName.setText("Welcome, "+nameUser);
    }

    public void openInfo1(){
        Intent intent = new Intent(HomeFragment.this.getActivity(), Info1.class);
        startActivity(intent);
    }

    public void openInfo7(){
        Intent intent = new Intent(HomeFragment.this.getActivity(), Info7.class);
        startActivity(intent);
    }

    public void openInfo5(){
        Intent intent = new Intent(HomeFragment.this.getActivity(), Info5.class);
        startActivity(intent);
    }

    public void openInfo4(){
        Intent intent = new Intent(HomeFragment.this.getActivity(), FeedbackActivity.class);
        startActivity(intent);
    }



}