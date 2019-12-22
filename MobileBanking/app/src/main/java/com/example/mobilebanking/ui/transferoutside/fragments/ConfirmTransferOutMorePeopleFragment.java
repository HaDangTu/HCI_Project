package com.example.mobilebanking.ui.transferoutside.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.transferinside.adapter.ListConfirmAccountRecyclerAdapter;
import com.example.mobilebanking.ui.transferinside.object.ReceiverInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmTransferOutMorePeopleFragment extends Fragment {

    private FloatingActionButton confirmFAB;
    private FloatingActionButton backFAB;


    public ConfirmTransferOutMorePeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_confirm_transfer_outside_more_people, container, false);
        confirmFAB = root.findViewById(R.id.confirm_fab);
        backFAB = root.findViewById(R.id.back_fab);

        confirmFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmFABOnClick();
            }
        });

        backFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backFABOnClick();
            }
        });

        RecyclerView listAccount = root.findViewById(R.id.list_account);
        listAccount.setLayoutManager(new LinearLayoutManager(getContext()));

        String[] accountIds = getResources().getStringArray(R.array.more_receiver);
        String[] receiversName = getResources().getStringArray(R.array.name_receivers);
        String[] money = getResources().getStringArray(R.array.transfer_amounts);

        ArrayList<ReceiverInfo> receiverInfos = new ArrayList<>();
        for (int i = 0; i < accountIds.length; i++){
            receiverInfos.add(new ReceiverInfo(accountIds[i],
                    receiversName[i],
                    money[i]));
        }
        ListConfirmAccountRecyclerAdapter adapter = new ListConfirmAccountRecyclerAdapter(receiverInfos, getContext());
        listAccount.setAdapter(adapter);
        return root;
    }

    private void confirmFABOnClick(){
        InputOTPTransferOutsideFragment fragment = new InputOTPTransferOutsideFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void backFABOnClick(){
        TransferOutsideMainFragment fragment = new TransferOutsideMainFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}
