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
public class TransferMorePeopleFragment extends Fragment {

    private FloatingActionButton nextFAB;

    public TransferMorePeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_transfer_more_people, container, false);
        nextFAB = root.findViewById(R.id.next_fab);

        nextFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFABOnClick();
            }
        });
        return root;
    }

    private void nextFABOnClick(){
        ConfirmTransferMorePeopleFragment fragment = new ConfirmTransferMorePeopleFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void buttonImportClick(){

    }
}
