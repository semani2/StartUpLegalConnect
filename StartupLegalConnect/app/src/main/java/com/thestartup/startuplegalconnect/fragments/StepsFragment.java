package com.thestartup.startuplegalconnect.fragments;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.adapters.CyberLawStepsAdapter;
import com.thestartup.startuplegalconnect.viewmodels.StepsViewModel;
import com.thestartup.startuplegalconnect.viewmodels.IStepsViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepsFragment extends Fragment {
    VideoView videoView;
    TextView textView;
    MediaController mediaController;

    public StepsFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steps, container, false);

        videoView = (VideoView) view.findViewById(R.id.videoView);
        textView = (TextView) view.findViewById(R.id.launchStepCheck);

        String uriPath = "android.resource://com.thestartup.startuplegalconnect/raw/startup_legal_connect";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        mediaController = new MyMediaController(getContext());
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(new StepsCheckFragment(), "StepsCheck")
                        .commit();
            }
        });

        return view;
    }

    public class MyMediaController extends MediaController {
        public MyMediaController(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyMediaController(Context context, boolean useFastForward) {
            super(context, useFastForward);
        }

        public MyMediaController(Context context) {
            super(context);
        }
    }
}
