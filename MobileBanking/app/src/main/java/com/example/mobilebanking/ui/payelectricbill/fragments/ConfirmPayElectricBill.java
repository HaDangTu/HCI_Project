package com.example.mobilebanking.ui.payelectricbill.fragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payelectricbill.adapter.ListConfirmBillRecyclerViewAdapter;
import com.example.mobilebanking.ui.payelectricbill.object.ElectricBill;
import com.example.mobilebanking.util.FormattingNumber;
import com.example.mobilebanking.util.KeyManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmPayElectricBill extends Fragment {

    private FloatingActionButton confirmFAB;
    private FloatingActionButton backFAB;

    private TextView accountIDTextView;
    private TextView accountBalTextView;
    private TextView supplierTextView;
    private TextView customerIDTextView;
    private TextView sumMoneyTextView;

    private RecyclerView confirmListBill;

    public ConfirmPayElectricBill() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_confirm_pay_electric_bill, container, false);

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
        supplierTextView = root.findViewById(R.id.supplier_text_view);
        customerIDTextView = root.findViewById(R.id.customer_id_text_view);
        sumMoneyTextView = root.findViewById(R.id.sum_money_text_view);
        confirmListBill = root.findViewById(R.id.confirm_list_bill);
        confirmListBill.setLayoutManager(new LinearLayoutManager(getContext()));

        Bundle args = getArguments();
        if (args != null){
            accountIDTextView.setText(args.getString(KeyManager.ACCOUNT_ID));
            accountBalTextView.setText(args.getString(KeyManager.ACCOUNT_BALANCE));
            supplierTextView.setText(args.getString(KeyManager.SUPPLIER));
            customerIDTextView.setText(args.getString(KeyManager.CUSTOMER_ID));
            ArrayList<Integer> checkList = args.getIntegerArrayList("CheckList");
            String[] months = getResources().getStringArray(R.array.list_month);
            String[] oldValues = getResources().getStringArray(R.array.list_old_value);
            String[] newValues = getResources().getStringArray(R.array.list_new_value);
            String[] sumMoneys = getResources().getStringArray(R.array.list_money);

            ArrayList<ElectricBill> electricBills = new ArrayList<>();
            long sum = 0;
            for (Integer pos : checkList){
                electricBills.add(new ElectricBill(months[pos],
                        oldValues[pos],
                        newValues[pos],
                        sumMoneys[pos]));
                sum = sum + convertToLong(sumMoneys[pos]);
            }

            ListConfirmBillRecyclerViewAdapter adapter = new ListConfirmBillRecyclerViewAdapter(electricBills, getContext());
            confirmListBill.setAdapter(adapter);

            String sumStr = String.valueOf(sum);
            sumStr = FormattingNumber.format(sumStr) + " VND";
            sumMoneyTextView.setText(sumStr);
        }
        return root;
    }

    private void confirmFABOnClick(){
        InputOTPPayElectricBillFragment fragment = new InputOTPPayElectricBillFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    private void backFABOnClick(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.popBackStack();
    }

    private long convertToLong(String inText){
        inText = inText.replaceAll("[.]|,|[a-zA-Z]|\\s", "");
        return Long.parseLong(inText);
    }
}
