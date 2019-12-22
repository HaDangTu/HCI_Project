package com.example.mobilebanking.ui.paytaxbill.fragments;


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
public class ResultPayTaxBillFragment extends Fragment {

    private FloatingActionButton backFAB;

    public ResultPayTaxBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_result_pay_tax_bill, container, false);
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
        FormPayTaxBillFragment fragment = new FormPayTaxBillFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
    }
}
