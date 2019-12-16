package com.example.mobilebanking.ui.transferinside.fragments;


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
public class TransferOnePersonFragment extends Fragment{

    private FloatingActionButton nextFAB;
    private Spinner accountIDSpinner;
    private TextView accountBalanceTView;

    private AutoCompleteTextView receiverAutoText;
    private EditText receiverNameEdText;

    private EditText transferAmountEdText;
    private Spinner unitSpinner;
    private EditText transferContentEdText;

    public TransferOnePersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_transfer_one_person, container, false);
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

        receiverAutoText = root.findViewById(R.id.receiver_acc_auto_text);
        receiverNameEdText = root.findViewById(R.id.receiver_name_edit_text);
        unitSpinner = root.findViewById(R.id.unit_spinner);
        transferContentEdText = root.findViewById(R.id.transfer_content_edit_text);

        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_item,
                        getResources().getStringArray(R.array.list_receiver));

        receiverAutoText.setThreshold(1);
        receiverAutoText.setAdapter(adapter);

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

        receiverAutoText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] receiverNames = getResources().getStringArray(R.array.receiver_name);
                receiverNameEdText.setText(receiverNames[position]);
            }
        });
        return root;
    }

    public void nextFABOnClick(){
        ConfirmTransferOnePersonFragment fragment = new ConfirmTransferOnePersonFragment();
        Bundle args = new Bundle();
        args.putString(KeyManager.ACCOUNT_ID, accountIDSpinner.getSelectedItem().toString());
        args.putString(KeyManager.ACCOUNT_BALANCE, accountBalanceTView.getText().toString());
        args.putString(KeyManager.RECEIVER_ACCOUNT_ID, receiverAutoText.getText().toString());
        args.putString(KeyManager.RECEIVER_NAME, receiverNameEdText.getText().toString());
        args.putString(KeyManager.TRANSFER_AMOUNT, transferAmountEdText.getText().toString());
        args.putString(KeyManager.TRANSFER_CONTENT, transferContentEdText.getText().toString());
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
