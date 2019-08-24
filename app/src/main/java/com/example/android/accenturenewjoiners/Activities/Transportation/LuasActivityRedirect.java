package com.example.android.accenturenewjoiners.Activities.Transportation;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.accenturenewjoiners.Activities.MainActivity;
import com.example.android.accenturenewjoiners.R;

public class LuasActivityRedirect extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        return rootView;
    }
}

