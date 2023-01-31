package com.example.hw_2_3_month;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    EditText editTextTime;
    Button button_one;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inisView();
        startClick();
    }

    private void inisView() {
        editTextTime = requireActivity().findViewById(R.id.editTextTime);
        button_one = requireActivity().findViewById(R.id.button_one);
    }

    private void startClick() {
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if (editTextTime.getText().toString().isEmpty()) {
                } else {
                    bundle.putString("key", editTextTime.getText().toString());
                    SecondFragment fragment = new SecondFragment();
                    fragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("").commit();
                }
            }
        });
    }
}