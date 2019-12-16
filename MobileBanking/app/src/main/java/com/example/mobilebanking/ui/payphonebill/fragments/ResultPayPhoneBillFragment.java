package com.example.mobilebanking.ui.payphonebill.fragments;


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
public class ResultPayPhoneBillFragment extends Fragment {


    private FloatingActionButton backFAB;

    public ResultPayPhoneBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_result_pay_phone_bill, container, false);
        backFAB = root.findViewById(R.id.back_fab);
        backFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backFABOnClick();
            }
        });
        return root;
    }

    private void backFABOnClick(){
        PayPhoneBillMainFragment fragment = new PayPhoneBillMainFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
