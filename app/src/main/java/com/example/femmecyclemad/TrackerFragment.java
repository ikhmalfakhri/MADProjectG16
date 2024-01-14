package com.example.femmecyclemad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrackerFragment#} factory method to
 * create an instance of this fragment.
 *
 */
public class TrackerFragment extends Fragment {
    Button tracker;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tracker, container, false);

        tracker = v.findViewById(R.id.starttracker_button);
        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrackerFragment.this.getActivity(),TrackerActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}