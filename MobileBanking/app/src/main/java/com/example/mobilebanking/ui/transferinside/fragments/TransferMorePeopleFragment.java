package com.example.mobilebanking.ui.transferinside.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.transferinside.adapter.ListAccountRecyclerAdapter;
import com.example.mobilebanking.ui.transferinside.object.ReceiverInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransferMorePeopleFragment extends Fragment {

    private FloatingActionButton nextFAB;

    public TransferMorePeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_transfer_more_people, container, false);
        nextFAB = root.findViewById(R.id.next_fab);

        nextFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFABOnClick();
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
        ListAccountRecyclerAdapter adapter = new ListAccountRecyclerAdapter(receiverInfos, getContext());
        listAccount.setAdapter(adapter);
        return root;
    }

    private void nextFABOnClick(){
        ConfirmTransferMorePeopleFragment fragment = new ConfirmTransferMorePeopleFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void buttonImportClick(){

    }
}
