package com.example.smartclock.ui.bedtime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.smartclock.R;

public class BedtimeFragment extends Fragment {

    private BedtimeViewModel bedtimeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bedtimeViewModel =
                ViewModelProviders.of(this).get(BedtimeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bed, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        bedtimeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}