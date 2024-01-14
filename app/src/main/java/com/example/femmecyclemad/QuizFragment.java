package com.example.femmecyclemad;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

    Button btnQuiz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quiz, container, false);

        btnQuiz = v.findViewById(R.id.startquiz_button);
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizFragment.this.getActivity(),QuizActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }


}