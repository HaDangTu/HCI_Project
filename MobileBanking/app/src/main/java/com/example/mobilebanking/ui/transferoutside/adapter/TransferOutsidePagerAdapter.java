package com.example.mobilebanking.ui.transferoutside.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mobilebanking.ui.transferoutside.fragments.TransferOutMorePeopleFragment;
import com.example.mobilebanking.ui.transferoutside.fragments.TransferOutOnePersonFragment;

public class TransferOutsidePagerAdapter extends FragmentStatePagerAdapter {

    private int numOfTab;
    public TransferOutsidePagerAdapter(@NonNull FragmentManager fm, int behavior, int numOfTab) {
        super(fm, behavior);
        this.numOfTab = numOfTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new TransferOutOnePersonFragment();
            case 1:
                return new TransferOutMorePeopleFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.numOfTab;
    }
}
