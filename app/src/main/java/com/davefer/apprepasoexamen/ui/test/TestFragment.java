package com.davefer.apprepasoexamen.ui.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.davefer.apprepasoexamen.R;
import com.davefer.apprepasoexamen.ui.notifications.NotificationsViewModel;


public class TestFragment extends Fragment {

    private TestViewModel testViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //testViewModel = new ViewModelProvider(this).get(TestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_test, container, false);
         //final TextView textView = root.findViewById(R.id.text_notifications);
    /*
        testViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });

        */
        return root;



    }

}