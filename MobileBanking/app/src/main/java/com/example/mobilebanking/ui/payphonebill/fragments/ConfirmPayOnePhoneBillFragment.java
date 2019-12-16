package com.example.mobilebanking.ui.payphonebill.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payelectricbill.fragments.InputOTPPayElectricBillFragment;
import com.example.mobilebanking.ui.transferinside.fragments.TransferOnePersonFragment;
import com.example.mobilebanking.util.KeyManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmPayOnePhoneBillFragment extends Fragment {

    private FloatingActionButton confirmFAB;
    private FloatingActionButton backFAB;

    private TextView accountIDTextView;
    private TextView accountBalTextView;
    private TextView phoneNumberTextView;
    private TextView phoneCardTextView;
    private TextView supplierTextView;

    public ConfirmPayOnePhoneBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_confirm_pay_one_phone_bill, container, false);
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

        accountIDTextView = root.findViewById(R.id.payer_acc_text_view);
        accountBalTextView = root.findViewById(R.id.payer_account_bal_text_view);
        phoneNumberTextView = root.findViewById(R.id.phone_number_text_view);
        phoneCardTextView = root.findViewById(R.id.phone_card_text_view);
        supplierTextView = root.findViewById(R.id.supplier_text_view);

        Bundle args = getArguments();
        if (args != null){
            accountIDTextView.setText(args.getString(KeyManager.ACCOUNT_ID));
            accountBalTextView.setText(args.getString(KeyManager.ACCOUNT_BALANCE));
            phoneNumberTextView.setText(args.getString(KeyManager.PHONE_NUMBER));
            phoneCardTextView.setText(args.getString(KeyManager.PHONE_CARD));
            supplierTextView.setText(args.getString(KeyManager.SUPPLIER));
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
