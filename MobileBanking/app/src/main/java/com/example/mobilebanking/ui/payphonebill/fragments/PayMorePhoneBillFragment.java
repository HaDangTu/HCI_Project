package com.example.mobilebanking.ui.payphonebill.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payphonebill.adapter.ListPhoneRecyclerViewAdapter;
import com.example.mobilebanking.ui.payphonebill.object.PhoneInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayMorePhoneBillFragment extends Fragment {

    private FloatingActionButton nextFAB;

    public PayMorePhoneBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pay_more_phone_bill, container, false);
        RecyclerView listPhone = root.findViewById(R.id.list_phone);
        listPhone.setLayoutManager(new LinearLayoutManager(getContext()));

        String[] phones = getResources().getStringArray(R.array.phone_numbers);
        int[] cards = getResources().getIntArray(R.array.selected_card);
        int[] suppliers = getResources().getIntArray(R.array.selected_supplier);

        ArrayList<PhoneInfo> phoneInfos = new ArrayList<>();
        for (int i = 0; i < phones.length; i++){
            phoneInfos.add(new PhoneInfo(phones[i], cards[i], suppliers[i]));
        }

        ListPhoneRecyclerViewAdapter adapter = new ListPhoneRecyclerViewAdapter(phoneInfos, getContext());
        listPhone.setAdapter(adapter);

        nextFAB = root.findViewById(R.id.next_fab);
        nextFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFABOnClick();
            }
        });
        return root;
    }

    private void nextFABOnClick(){
        ConfirmPayMorePhoneBillFragment fragment = new ConfirmPayMorePhoneBillFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }
}
