package com.example.mobilebanking.ui.payphonebill;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payphonebill.adapter.PayPhoneBillPagerAdapter;
import com.example.mobilebanking.ui.payphonebill.fragments.PayPhoneBillMainFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayPhoneBillFragment extends Fragment {

    public PayPhoneBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment]
        return inflater.inflate(R.layout.fragment_pay_phone_bill, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        PayPhoneBillMainFragment fragment = new PayPhoneBillMainFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
    }
}
