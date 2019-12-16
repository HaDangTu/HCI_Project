package com.example.mobilebanking.ui.transferinside.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mobilebanking.ui.transferinside.fragments.TransferMorePeopleFragment;
import com.example.mobilebanking.ui.transferinside.fragments.TransferOnePersonFragment;

public class TransferInsidePagerAdapter extends FragmentStatePagerAdapter {

    private int numOfTab;
    public TransferInsidePagerAdapter(@NonNull FragmentManager fm, int behavior, int numOfTab) {
        super(fm, behavior);
        this.numOfTab = numOfTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new TransferOnePersonFragment();
            case 1:
                return new TransferMorePeopleFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.numOfTab;
    }
}
