package com.example.mobilebanking.ui.payphonebill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.payphonebill.object.PhoneInfo;

import java.util.ArrayList;

public class ListConfirmPhoneRecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<PhoneInfo> phoneInfos;
    private Context context;
    private String[] cards;
    private String[] suppliers;


    public ListConfirmPhoneRecyclerViewAdapter(ArrayList<PhoneInfo> phoneInfos, Context context,
                                               String[] cards, String[] suppliers){
        this.phoneInfos = phoneInfos;
        this.context = context;
        this.cards = cards;
        this.suppliers = suppliers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.confirm_phone_item, parent, false);
        return new ConfirmPhoneViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PhoneInfo phoneInfo = phoneInfos.get(position);
        ConfirmPhoneViewHolder viewHolder = (ConfirmPhoneViewHolder) holder;
        viewHolder.phoneTextView.setText(phoneInfo.getPhoneNumber());
        viewHolder.cardTextView.setText(cards[phoneInfo.getPhoneCard()]);
        viewHolder.supplierTextView.setText(suppliers[phoneInfo.getSupplier()]);
    }

    @Override
    public int getItemCount() {
        return phoneInfos.size();
    }

    private class ConfirmPhoneViewHolder extends RecyclerView.ViewHolder{
        TextView phoneTextView;
        TextView cardTextView;
        TextView supplierTextView;

        public ConfirmPhoneViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneTextView = itemView.findViewById(R.id.phone_text_view);
            cardTextView = itemView.findViewById(R.id.phone_card_text_view);
            supplierTextView = itemView.findViewById(R.id.supplier_text_view);
        }
    }
}
