package com.example.mobilebanking.ui.paytaxbill;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.paytaxbill.fragments.FormPayTaxBillFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayTaxBillFragment extends Fragment {


    public PayTaxBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay_tax_bill, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        FormPayTaxBillFragment fragment = new FormPayTaxBillFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }
}
