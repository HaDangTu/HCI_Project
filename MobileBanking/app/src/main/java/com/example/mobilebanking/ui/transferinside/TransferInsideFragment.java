package com.example.mobilebanking.ui.transferinside;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.transferinside.fragments.TransferInsideMainFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransferInsideFragment extends Fragment {

    public TransferInsideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transfer_inside, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        TransferInsideMainFragment fragment = new TransferInsideMainFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
    }
}
