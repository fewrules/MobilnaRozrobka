package com.example.laba11;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

public class ActivityButton extends Fragment {

    private ListenerA listener;
    private Button confirm;
    private Button display;
    private RadioGroup RadioA;

    public ActivityButton() {
    }

    public interface ListenerA{
        void onInputASent();
        void onInputBSent();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View v = inflater.inflate(R.layout.button_layout, container, false);
        confirm = v.findViewById(R.id.button2);
        display = v.findViewById(R.id.button);

        confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.onInputASent();
            }
        });

        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.onInputBSent();
            }
        });

        return v;
    }

    public static ActivityButton newInstance() {
        ActivityButton fragment = new ActivityButton();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListenerA) {
            listener = (ListenerA) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
}