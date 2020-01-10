package com.example.mobilebanking.ui.paywalletelectric.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mobilebanking.ui.paywalletelectric.fragments.WalletElectricMorePeopleFragment;
import com.example.mobilebanking.ui.paywalletelectric.fragments.WalletElectricOnePersonFragment;

public class WalletElectricPagerAdapter extends FragmentStatePagerAdapter {

    private int numOfTab;
    public WalletElectricPagerAdapter(@NonNull FragmentManager fm, int behavior, int numOfTab) {
        super(fm, behavior);
        this.numOfTab = numOfTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new WalletElectricOnePersonFragment();
            case 1:
                return new WalletElectricMorePeopleFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.numOfTab;
    }
}
