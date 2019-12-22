package com.example.mobilebanking.ui.paytaxbill.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.paytaxbill.adapter.ListTaxBillRecyclerViewAdapter;
import com.example.mobilebanking.ui.paytaxbill.object.TaxBill;
import com.example.mobilebanking.ui.payphonebill.fragments.PayOnePhoneBillFragment;
import com.example.mobilebanking.ui.transferinside.fragments.TransferOnePersonFragment;
import com.example.mobilebanking.util.KeyManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormPayTaxBillFragment extends Fragment {

    private FloatingActionButton nextFAB;

    private Spinner accountIDSpinner;
    private TextView accountBalTextView;
    private Spinner idTaxSpinner;
    private EditText customerIDEdText;

    private RecyclerView listBill;
    private ListTaxBillRecyclerViewAdapter adapter;
    private Button getBillButton;

    private CheckBox payAllCheckBox;

    public FormPayTaxBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_form_pay_tax_bill, container, false);
        nextFAB = root.findViewById(R.id.next_fab);
        nextFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFABOnClick();
            }
        });
        accountIDSpinner = root.findViewById(R.id.payer_acc_spinner);
        accountBalTextView = root.findViewById(R.id.payer_account_bal_text_view);
        idTaxSpinner = root.findViewById(R.id.id_tax_spinner);
        customerIDEdText = root.findViewById(R.id.customer_id_edit_text);

        accountIDSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] accountBalances = getResources().getStringArray(R.array.account_balances);
                accountBalTextView.setText(accountBalances[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listBill = root.findViewById(R.id.list_tax_bill);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listBill.setLayoutManager(layoutManager);

        getBillButton = root.findViewById(R.id.get_tax_bill_button);
        getBillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTaxBillButtonOnClick();
            }
        });

        payAllCheckBox = root.findViewById(R.id.pay_all_checkbox);
        payAllCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setIsCheckedAll(payAllCheckBox.isChecked());
                adapter.notifyDataSetChanged();
            }
        });
        return root;
    }

    private void nextFABOnClick(){
        ConfirmPayTaxBill fragment = new ConfirmPayTaxBill();

        Bundle args = new Bundle();
        args.putString(KeyManager.ACCOUNT_ID, accountIDSpinner.getSelectedItem().toString());
        args.putString(KeyManager.ACCOUNT_BALANCE, accountBalTextView.getText().toString());
        args.putString(KeyManager.IDTAX, idTaxSpinner.getSelectedItem().toString());
        args.putString(KeyManager.CUSTOMER_ID, customerIDEdText.getText().toString());
        args.putIntegerArrayList("CheckList", adapter.getCheckList());
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    private void getTaxBillButtonOnClick(){
        String[] months = getResources().getStringArray(R.array.list_month);
        String[] sumMoneys = getResources().getStringArray(R.array.list_money);

        ArrayList<TaxBill> taxbill = new ArrayList<>();
        for (int i = 0; i < months.length; i++){
            taxbill.add(new TaxBill(months[i],
                    sumMoneys[i]));
        }
        adapter = new ListTaxBillRecyclerViewAdapter(taxbill, getContext());

        listBill.setAdapter(adapter);
    }
}
