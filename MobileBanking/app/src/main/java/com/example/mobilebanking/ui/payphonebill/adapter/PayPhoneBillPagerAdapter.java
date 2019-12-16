package com.example.mobilebanking.ui.payphonebill.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mobilebanking.ui.payphonebill.fragments.PayMorePhoneBillFragment;
import com.example.mobilebanking.ui.payphonebill.fragments.PayOnePhoneBillFragment;
import com.example.mobilebanking.util.BasePagerAdapter;

public class PayPhoneBillPagerAdapter extends BasePagerAdapter {

    public PayPhoneBillPagerAdapter(@NonNull FragmentManager fm, int behavior, int numOfTab) {
        super(fm, behavior, numOfTab);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new PayMorePhoneBillFragment();
            default:
                return new PayOnePhoneBillFragment();
        }
    }
}
