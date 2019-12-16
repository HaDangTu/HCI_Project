package com.example.mobilebanking.ui.payphonebill.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payphonebill.adapter.PayPhoneBillPagerAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayPhoneBillMainFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public PayPhoneBillMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pay_phone_bill_main, container, false);
        tabLayout = root.findViewById(R.id.tab_layout);
        viewPager = root.findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_sim));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_dual_sim));

        PayPhoneBillPagerAdapter adapter = new PayPhoneBillPagerAdapter(getChildFragmentManager(),
                PayPhoneBillPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return root;
    }

}
