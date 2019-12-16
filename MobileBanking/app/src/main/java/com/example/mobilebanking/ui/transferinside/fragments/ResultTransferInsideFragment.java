package com.example.mobilebanking.ui.transferinside.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultTransferInsideFragment extends Fragment {

    private FloatingActionButton backFAB;

    public ResultTransferInsideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_result_transfer_inside, container, false);
        backFAB = root.findViewById(R.id.back_to_main_fab);
        backFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backFABOnClick();
            }
        });
        return root;
    }

    private void backFABOnClick(){
        TransferInsideMainFragment fragment = new TransferInsideMainFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
