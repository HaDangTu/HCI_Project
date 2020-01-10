package com.example.mobilebanking.ui.paywalletelectric.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.paywalletelectric.adapter.ListWalletRecyclerAdapter;
import com.example.mobilebanking.ui.paywalletelectric.object.ReceiverInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletElectricMorePeopleFragment extends Fragment {

    private FloatingActionButton nextFAB;

    public WalletElectricMorePeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_wallet_electric_more_people, container, false);
        nextFAB = root.findViewById(R.id.next_fab);

        nextFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFABOnClick();
            }
        });

        RecyclerView listAccount = root.findViewById(R.id.list_account);
        listAccount.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] accountIds = getResources().getStringArray(R.array.id_customer);
        String[] typewallet = getResources().getStringArray(R.array.type_wallet);
        String[] money = getResources().getStringArray(R.array.transfer_amounts);

        ArrayList<ReceiverInfo> receiverInfos = new ArrayList<>();
        for (int i = 0; i < accountIds.length; i++){
            receiverInfos.add(new ReceiverInfo(accountIds[i],
                    typewallet[i],
                    money[i]));
        }
        ListWalletRecyclerAdapter adapter = new ListWalletRecyclerAdapter(receiverInfos, getContext());
        listAccount.setAdapter(adapter);
        return root;
    }

    private void nextFABOnClick(){
        ConfirmWalletElectricMorePeopleFragment fragment = new ConfirmWalletElectricMorePeopleFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void buttonImportClick(){

    }
}
