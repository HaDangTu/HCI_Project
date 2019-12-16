package com.example.mobilebanking.ui.payphonebill.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payphonebill.PayPhoneBillFragment;
import com.example.mobilebanking.ui.transferinside.fragments.TransferOnePersonFragment;
import com.example.mobilebanking.util.KeyManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayOnePhoneBillFragment extends Fragment {

    private FloatingActionButton nextFAB;

    private Spinner payerAccID;
    private TextView payerAccountBalTextView;
    private AutoCompleteTextView phoneNumberAutoText;
    private Spinner phoneCardSpinner;
    private Spinner supplierSpinner;


    public PayOnePhoneBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pay_one_phone_bill, container, false);
        nextFAB = root.findViewById(R.id.next_fab);
        nextFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFABOnClick();
            }
        });

        payerAccID = root.findViewById(R.id.payer_acc_spinner);
        payerAccountBalTextView = root.findViewById(R.id.payer_account_bal_text_view);
        phoneCardSpinner = root.findViewById(R.id.phone_card_spinner);
        phoneNumberAutoText = root.findViewById(R.id.phone_number_auto_text);
        supplierSpinner = root.findViewById(R.id.supplier_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.select_dialog_item, getResources().getStringArray(R.array.list_phone_number));

        phoneNumberAutoText.setThreshold(1);
        phoneNumberAutoText.setAdapter(adapter);

        payerAccID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] accountBalances = getResources().getStringArray(R.array.account_balances);
                payerAccountBalTextView.setText(accountBalances[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return root;
    }

    private void nextFABOnClick(){
        ConfirmPayOnePhoneBillFragment fragment = new ConfirmPayOnePhoneBillFragment();
        Bundle args = new Bundle();
        args.putString(KeyManager.ACCOUNT_ID, payerAccID.getSelectedItem().toString());
        args.putString(KeyManager.ACCOUNT_BALANCE, payerAccountBalTextView.getText().toString());
        args.putString(KeyManager.PHONE_NUMBER, phoneNumberAutoText.getText().toString());
        args.putString(KeyManager.PHONE_CARD, phoneCardSpinner.getSelectedItem().toString());
        args.putString(KeyManager.SUPPLIER, supplierSpinner.getSelectedItem().toString());
        fragment.setArguments(args);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .remove(new PayPhoneBillMainFragment())
                .addToBackStack(null)
                .commit();
    }
}
