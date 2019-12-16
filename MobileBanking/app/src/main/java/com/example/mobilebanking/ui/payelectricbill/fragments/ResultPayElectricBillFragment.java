package com.example.mobilebanking.ui.payelectricbill.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.transferinside.fragments.TransferInsideMainFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultPayElectricBillFragment extends Fragment {

    private FloatingActionButton backFAB;

    public ResultPayElectricBillFragment() {
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
        FormPayElectricBillFragment fragment = new FormPayElectricBillFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
    }
}
