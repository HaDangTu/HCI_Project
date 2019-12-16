package com.example.mobilebanking.ui.transferinside.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.transferinside.adapter.TransferInsidePagerAdapter;
import com.example.mobilebanking.util.KeyManager;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Field;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransferInsideMainFragment extends Fragment {

    public TransferInsideMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_transfer_inside_main, container, false);
        TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        final ViewPager viewPager = root.findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_person));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_more_people));

        TransferInsidePagerAdapter adapter = new TransferInsidePagerAdapter(
                getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


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
