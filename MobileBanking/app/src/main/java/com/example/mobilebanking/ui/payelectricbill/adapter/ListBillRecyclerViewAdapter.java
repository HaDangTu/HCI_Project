package com.example.mobilebanking.ui.payelectricbill.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payelectricbill.object.ElectricBill;

import java.util.ArrayList;

public class ListBillRecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<ElectricBill> electricBills;
    private Context context;
    private OnBillItemClickListener listener;
    private boolean isCheckedAll;
    private ArrayList<Integer> checkList;

    public ListBillRecyclerViewAdapter(ArrayList<ElectricBill> electricBills, Context context){
        this.electricBills = electricBills;
        this.context = context;
        isCheckedAll = false;
        checkList = new ArrayList<>();
    }

    public void setIsCheckedAll(boolean isCheckedAll){
        this.isCheckedAll = isCheckedAll;
    }

    public ArrayList<Integer> getCheckList() {
        return checkList;
    }

    public interface OnBillItemClickListener{
        void onClick(CheckBox checkBox);
    }

    public void setOnBillItemClickListener(OnBillItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.bill_item, parent, false);
        return new ListBillRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ElectricBill electricBill = electricBills.get(position);
        SpannableString colorOldValueText = colorText(electricBill.getOldValue(), Color.BLUE);
        SpannableString colorNewValueText = colorText(electricBill.getNewValue(), Color.RED);
        SpannableString colorSumMoneyText = colorText(electricBill.getSumMoney(), Color.RED);

        ListBillRecyclerViewHolder listBillViewHolder = (ListBillRecyclerViewHolder) holder;
        listBillViewHolder.monthTextView.setText(context.getString(R.string.month,
                electricBill.getMonth()));

        listBillViewHolder.oldValueTextView.setText(
                TextUtils.concat(colorText(context.getString(R.string.old_value), Color.BLACK),
                       " ", colorOldValueText));

        listBillViewHolder.newValueTextView.setText(
                TextUtils.concat(colorText(context.getString(R.string.new_value), Color.BLACK)
                        , " ", colorNewValueText));

        listBillViewHolder.sumMoneyTextView.setText(
                TextUtils.concat(colorText(context.getString(R.string.sum_money), Color.BLACK),
                        " ", colorSumMoneyText));

        listBillViewHolder.payCheckBox.setChecked(isCheckedAll);
    }

    @Override
    public int getItemCount() {
        return electricBills.size();
    }


    private SpannableString colorText(String inText, int color){
        SpannableString spanString = new SpannableString(inText);
        spanString.setSpan(new ForegroundColorSpan(color), 0, inText.length(),
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }

    private class ListBillRecyclerViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{

        public TextView monthTextView;
        public TextView oldValueTextView;
        public TextView newValueTextView;
        public TextView sumMoneyTextView;
        public CheckBox payCheckBox;

        public ListBillRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            monthTextView = itemView.findViewById(R.id.month_text_view);
            oldValueTextView = itemView.findViewById(R.id.old_value_text_view);
            newValueTextView = itemView.findViewById(R.id.new_value_text_view);
            sumMoneyTextView = itemView.findViewById(R.id.sum_money_text_view);
            payCheckBox = itemView.findViewById(R.id.pay_checkbox);
            payCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        int pos = getAdapterPosition();
                        if (pos >= 0)
                            checkList.add(pos);
                    }
                    else {
                        if (checkList.size() > 0)
                            checkList.remove(Integer.valueOf(getAdapterPosition()));
                    }
                }
            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(payCheckBox);
        }
    }
}
