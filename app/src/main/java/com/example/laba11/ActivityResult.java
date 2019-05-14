package com.example.laba11;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActivityResult extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View y = inflater.inflate(R.layout.result_layout, container, false);
        return y;
    }

    public static ActivityResult newInstance() {
        ActivityResult fragment = new ActivityResult();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
}
