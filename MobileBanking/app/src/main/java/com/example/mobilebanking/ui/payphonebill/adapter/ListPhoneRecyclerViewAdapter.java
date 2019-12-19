package com.example.mobilebanking.ui.payphonebill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payphonebill.object.PhoneInfo;

import java.util.ArrayList;

public class ListPhoneRecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<PhoneInfo> phoneInfos;
    private Context context;

    public ListPhoneRecyclerViewAdapter(ArrayList<PhoneInfo> phoneInfos, Context context){
        this.phoneInfos = phoneInfos;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.phone_item, parent, false);
        return new PhoneRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PhoneInfo phoneInfo = phoneInfos.get(position);
        PhoneRecyclerViewHolder viewHolder = (PhoneRecyclerViewHolder) holder;
        viewHolder.phoneNumEdText.setText(phoneInfo.getPhoneNumber());
        viewHolder.phoneCardSpinner.setSelection(phoneInfo.getPhoneCard());
        viewHolder.supplierSpinner.setSelection(phoneInfo.getSupplier());
    }

    @Override
    public int getItemCount() {
        return phoneInfos.size();
    }

    private class PhoneRecyclerViewHolder extends RecyclerView.ViewHolder{
        EditText phoneNumEdText;
        Spinner phoneCardSpinner;
        Spinner supplierSpinner;

        public PhoneRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneNumEdText = itemView.findViewById(R.id.phone_edit_text);
            phoneCardSpinner = itemView.findViewById(R.id.phone_card_spinner);
            supplierSpinner = itemView.findViewById(R.id.supplier_spinner);

        }
    }
}
