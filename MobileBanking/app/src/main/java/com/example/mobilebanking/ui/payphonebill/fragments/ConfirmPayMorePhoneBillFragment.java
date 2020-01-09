package com.example.mobilebanking.ui.payphonebill.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payphonebill.adapter.ListConfirmPhoneRecyclerViewAdapter;
import com.example.mobilebanking.ui.payphonebill.object.PhoneInfo;
import com.example.mobilebanking.util.KeyManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmPayMorePhoneBillFragment extends Fragment {

    private FloatingActionButton confirmFAB;
    private FloatingActionButton backFAB;

    private TextView accountIdTView;
    private TextView accountBalTView;
    public ConfirmPayMorePhoneBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_confirm_pay_more_phone_bill, container, false);
        RecyclerView listPhone = root.findViewById(R.id.list_phone);
        listPhone.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] phones = getResources().getStringArray(R.array.phone_numbers);
        String[] cards = getResources().getStringArray(R.array.list_phone_card);
        String[] suppliers = getResources().getStringArray(R.array.list_supplier_phone);
        int[] selCards = getResources().getIntArray(R.array.selected_card);
        int[] selSuppliers = getResources().getIntArray(R.array.selected_supplier);

        ArrayList<PhoneInfo> phoneInfos = new ArrayList<>();
        for (int i = 0; i < phones.length; i++){
            phoneInfos.add(new PhoneInfo(phones[i], selCards[i], selSuppliers[i]));
        }

        ListConfirmPhoneRecyclerViewAdapter adapter = new ListConfirmPhoneRecyclerViewAdapter(
                phoneInfos, getContext(), cards, suppliers);

        listPhone.setAdapter(adapter);

        confirmFAB = root.findViewById(R.id.confirm_fab);
        confirmFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmFABOnClick();
            }
        });
        backFAB = root.findViewById(R.id.back_fab);
        backFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backFABOnClick();
            }
        });

        accountIdTView = root.findViewById(R.id.account_id);
        accountBalTView = root.findViewById(R.id.account_bal_more_text_view);

        Bundle args = getArguments();
        if (args != null){
            accountIdTView.setText(args.getString(KeyManager.ACCOUNT_ID));
            accountBalTView.setText(args.getString(KeyManager.ACCOUNT_BALANCE));
        }
        return root;
    }

    private void confirmFABOnClick(){
        InputOTPPayPhoneBillFragment fragment = new InputOTPPayPhoneBillFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void backFABOnClick(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.popBackStack();
    }

}
