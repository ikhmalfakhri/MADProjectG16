package com.example.femmecyclemad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    TextView profileName, profileEmail, profileGender, profilePassword;
    TextView titleName, titleUsername;
    Button btnLogout;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile, container, false);

        profileName = v.findViewById(R.id.profileName);
        profileEmail = v.findViewById(R.id.profileEmail);
        profileGender = v.findViewById(R.id.profileGender);
        profilePassword = v.findViewById(R.id.profilePassword);
        titleName = v.findViewById(R.id.titleName);

        btnLogout = v.findViewById(R.id.logout_button);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileFragment.this.getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        showAllUserData();

        // Inflate the layout for this fragment
        return v;
    }

    public void showAllUserData(){
        Intent intent = getActivity().getIntent();
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
}