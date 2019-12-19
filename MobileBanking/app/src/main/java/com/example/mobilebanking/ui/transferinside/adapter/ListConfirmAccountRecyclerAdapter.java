package com.example.mobilebanking.ui.transferinside.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.transferinside.object.ReceiverInfo;

import java.util.ArrayList;

public class ListConfirmAccountRecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList<ReceiverInfo> receiverInfos;
    private Context context;

    public ListConfirmAccountRecyclerAdapter(ArrayList<ReceiverInfo> receiverInfos, Context context){
        this.receiverInfos = receiverInfos;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.confirm_account_item, parent, false);

        return new ConfirmAccountItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ReceiverInfo receiverInfo = receiverInfos.get(position);
        ConfirmAccountItemViewHolder viewHolder = (ConfirmAccountItemViewHolder) holder;
        viewHolder.accountTextView.setText(receiverInfo.getAccountID());
        viewHolder.nameTextView.setText(receiverInfo.getName());
        viewHolder.moneyTextView.setText(receiverInfo.getMoney());
    }

    @Override
    public int getItemCount() {
        return receiverInfos.size();
    }

    private class ConfirmAccountItemViewHolder extends RecyclerView.ViewHolder{
        TextView accountTextView;
        TextView nameTextView;
        TextView moneyTextView;

        public ConfirmAccountItemViewHolder(@NonNull View itemView) {
            super(itemView);

            accountTextView = itemView.findViewById(R.id.account_text_view);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            moneyTextView = itemView.findViewById(R.id.money_text_view);
        }
    }
}
