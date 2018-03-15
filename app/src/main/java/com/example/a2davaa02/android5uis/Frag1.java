package com.example.a2davaa02.android5uis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2davaa02.android5uis.R;

/**
 * Created by whitelegg_n on 10/11/2017.
 */

public class Frag1 extends android.app.Fragment {
    public Frag1() {

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, group, false);
    }
}
