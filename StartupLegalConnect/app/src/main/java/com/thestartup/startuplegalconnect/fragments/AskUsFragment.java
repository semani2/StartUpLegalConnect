package com.thestartup.startuplegalconnect.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.thestartup.startuplegalconnect.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AskUsFragment extends Fragment {
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText queryEditText;
    Button sendButton;

    public AskUsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ask_us, container, false);
        nameEditText = (EditText) view.findViewById(R.id.userName);
        emailEditText = (EditText) view.findViewById(R.id.userEmail);
        queryEditText = (EditText) view.findViewById(R.id.userQuery);
        sendButton = (Button) view.findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAndSend();
            }
        });
        return view;
    }

    private void validateAndSend() {
        boolean isValidated = true;
        if(nameEditText.getText().toString().trim().isEmpty()) {
            nameEditText.setError("Please enter your name");
            isValidated = false;
        }

        if(emailEditText.getText().toString().trim().isEmpty() || !isValidEmail(emailEditText.getText().toString())) {
            emailEditText.setError("Please enter a valid email");
            isValidated = false;
        }

        if(queryEditText.getText().toString().trim().isEmpty()) {
            queryEditText.setError("Please enter your question/comments");
            isValidated = false;
        }

        if(isValidated) {
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"cyberlawsknowledgecentre@gmail.com"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Query from "+nameEditText.getText().toString());
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "You have a query from the legal connect android app :\n"
                    +queryEditText.getText().toString());

            getActivity().startActivity(Intent.createChooser(emailIntent, "Send us your query..."));
        }
    }

    public boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
