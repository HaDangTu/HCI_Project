package com.example.mobilebanking.ui.paytaxbill.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.paytaxbill.object.TaxBill;

import java.util.ArrayList;

public class ListConfirmTaxBillRecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<TaxBill> electricBills;
    private Context context;

    public ListConfirmTaxBillRecyclerViewAdapter(ArrayList<TaxBill> electricBills, Context context){
        this.electricBills = electricBills;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.confirm_tax_item, parent, false);
        return new ListConfirmTaxBillViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TaxBill electricBill = electricBills.get(position);
        SpannableString colorSumMoneyText = colorText(electricBill.getSumMoney(), Color.RED);

        ListConfirmTaxBillViewHolder listBillViewHolder =
                (ListConfirmTaxBillViewHolder) holder;
        listBillViewHolder.monthTextView.setText(context.getString(R.string.month,
                electricBill.getMonth()));

        listBillViewHolder.sumMoneyTextView.setText(
                TextUtils.concat(colorText(context.getString(R.string.sum_money), Color.BLACK),
                        " ", colorSumMoneyText));
    }

    private SpannableString colorText(String inText, int color){
        SpannableString spanString = new SpannableString(inText);
        spanString.setSpan(new ForegroundColorSpan(color), 0, inText.length(),
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }

    @Override
    public int getItemCount() {
        return electricBills.size();
    }
    
    private class ListConfirmTaxBillViewHolder extends RecyclerView.ViewHolder {

        public TextView monthTextView;
        public TextView sumMoneyTextView;
        
        public ListConfirmTaxBillViewHolder(@NonNull View itemView) {
            super(itemView);

            monthTextView = itemView.findViewById(R.id.month_text_view);
            sumMoneyTextView = itemView.findViewById(R.id.sum_money_text_view);
        }
    }
}
