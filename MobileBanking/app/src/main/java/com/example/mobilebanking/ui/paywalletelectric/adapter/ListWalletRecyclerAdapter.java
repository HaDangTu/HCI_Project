package com.example.mobilebanking.ui.paywalletelectric.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilebanking.R;
import com.example.mobilebanking.ui.paywalletelectric.object.ReceiverInfo;

import java.util.ArrayList;

public class ListWalletRecyclerAdapter extends RecyclerView.Adapter {

    private ArrayList<ReceiverInfo> receiverInfos;
    private Context context;

    public ListWalletRecyclerAdapter(ArrayList<ReceiverInfo> receiverInfos, Context context){
        this.receiverInfos = receiverInfos;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.account_item, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ReceiverInfo receiverInfo = receiverInfos.get(position);
        ListViewHolder viewHolder = (ListViewHolder) holder;
        viewHolder.accountIDEdText.setText(receiverInfo.getAccountID());
        viewHolder.nameEdText.setText(receiverInfo.getTypeWallet());
        viewHolder.moneyEdText.setText(receiverInfo.getMoney());
    }

    @Override
    public int getItemCount() {
        return receiverInfos.size();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder{

        EditText accountIDEdText;
        EditText nameEdText;
        EditText moneyEdText;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            accountIDEdText = itemView.findViewById(R.id.account_id_edit_text);
            nameEdText = itemView.findViewById(R.id.name_edit_text);
            moneyEdText = itemView.findViewById(R.id.money_edit_text);
        }
    }
}
