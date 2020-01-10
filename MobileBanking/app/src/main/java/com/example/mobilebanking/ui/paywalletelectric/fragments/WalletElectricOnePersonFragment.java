package com.example.mobilebanking.ui.paywalletelectric.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilebanking.R;
import com.example.mobilebanking.util.FormattingNumber;
import com.example.mobilebanking.util.KeyManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Field;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletElectricOnePersonFragment extends Fragment{

    private FloatingActionButton nextFAB;
    private Spinner accountIDSpinner;
    private TextView accountBalanceTView;
    private EditText customerIDEDText;
    private Spinner TypeWalletSpinner;
    private EditText transferAmountEdText;
    private Spinner unitSpinner;

    public WalletElectricOnePersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_wallet_electric_one_person, container, false);
        nextFAB = root.findViewById(R.id.next_fab);
        nextFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFABOnClick();
            }
        });

        transferAmountEdText = root.findViewById(R.id.transfer_amount_edit_text);
        transferAmountEdText.setOnKeyListener(new EditTextKeyListener());

        accountIDSpinner = root.findViewById(R.id.transfer_acc_spinner);
        accountBalanceTView = root.findViewById(R.id.account_bal_text_view);

        unitSpinner = root.findViewById(R.id.unit_spinner);
        customerIDEDText = root.findViewById(R.id.customer_id_auto_text);
        TypeWalletSpinner = root.findViewById(R.id.type_wallet_spinner);


        accountIDSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] accountBalances = getResources().getStringArray(R.array.account_balances);
                accountBalanceTView.setText(accountBalances[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return root;
    }

    public void nextFABOnClick(){
        ConfirmWalletElectricOnePersonFragment fragment = new ConfirmWalletElectricOnePersonFragment();
        Bundle args = new Bundle();
        args.putString(KeyManager.ACCOUNT_ID, accountIDSpinner.getSelectedItem().toString());
        args.putString(KeyManager.ACCOUNT_BALANCE, accountBalanceTView.getText().toString());
        args.putString(KeyManager.CUSTOMER_ID, customerIDEDText.getText().toString());
        args.putString(KeyManager.TRANSFER_AMOUNT, transferAmountEdText.getText().toString());
        args.putString(KeyManager.TYPE_WALLET, TypeWalletSpinner.getSelectedItem().toString());
        args.putString(KeyManager.UNIT, unitSpinner.getSelectedItem().toString());
        fragment.setArguments(args);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private class EditTextKeyListener implements View.OnKeyListener {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getAction() == KeyEvent.ACTION_UP){
                String number = transferAmountEdText.getText().toString();
                number = FormattingNumber.format(number);
                transferAmountEdText.setText(number);
                transferAmountEdText.setSelection(number.length());
                return true;
            }
            return false;
        }
    }
}
