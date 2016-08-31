package com.thestartup.startuplegalconnect.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.thestartup.startuplegalconnect.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartupStepsFragment extends Fragment {
    String[] stepsForStartups = {
            "Can you protect your idea?",
            "Ideas as such cannot be protected, but execution of idea can be protected. Business plan can be protected as per law",
            "Protecting logo as per law.",
            "Founders agreement - protecting the interests of founders and company.",
            "Outsourcing agreement (with developers) - website, mobile app, software",
            "Website, Mobile app, Software, Product based - legal documentation like policies, terms of use etc.",
            "Cyber law compliance for start-ups.",
            "Legal agreements & contracts with clients and users.",
            "Digital agreement & social media marketing agreements",
            "Employee agreements",
            "Adviser/Consultant agreement",
            "Non-disclosure agreement",
            "Protecting website/mobile app content, data, database, software, source code as per law.",
            "IP related agreements - IP protection, IP transfer, IP assignment agreements",
            "Term sheets",
            "Investor agreement, Share Holders agreement"
    };
    public ArrayAdapter<String> listAdapter;
    public StartupStepsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_startup_steps, container, false);
        ListView lv = (ListView) view.findViewById(R.id.steps_listView);
        List<String> steps = new ArrayList<>(Arrays.asList(stepsForStartups));
        listAdapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.steps_item_layout,
                R.id.steps_item_textView,
                steps);
        lv.setAdapter(listAdapter);
        return view;
    }

}
