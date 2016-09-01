package com.thestartup.startuplegalconnect.fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.thestartup.startuplegalconnect.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LegalMentorFragment extends Fragment {
    CircularImageView circularImageView;

    public LegalMentorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_legal_mentor, container, false);
        circularImageView = (CircularImageView) v.findViewById(R.id.mentorImageView);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.mentorpic);
        circularImageView.setImageBitmap(largeIcon);

        return v;
    }

}
