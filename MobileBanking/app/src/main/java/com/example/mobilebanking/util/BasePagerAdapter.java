package com.example.mobilebanking.util;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public abstract class BasePagerAdapter extends FragmentStatePagerAdapter {
    private int numOfTab;

    public BasePagerAdapter(@NonNull FragmentManager fm, int behavior, int numOfTab) {
        super(fm, behavior);
        this.numOfTab = numOfTab;
    }

    @Override
    public int getCount() {
        return this.numOfTab;
    }
}
