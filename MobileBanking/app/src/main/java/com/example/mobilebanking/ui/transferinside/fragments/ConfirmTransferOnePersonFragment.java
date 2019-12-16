package com.example.mobilebanking.ui.transferinside.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilebanking.R;
import com.example.mobilebanking.util.KeyManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmTransferOnePersonFragment extends Fragment {

    private FloatingActionButton confirmFAB;
    private FloatingActionButton backFAB;

    private TextView transferAccTextView;
    private TextView accountBalTextView;
    private TextView receiverAccTextView;
    private TextView receiverNameTextView;
    private TextView transferAmountTextView;
    private TextView transferContentTextView;

    public ConfirmTransferOnePersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_confirm_transfer_one_person, container, false);
        confirmFAB = root.findViewById(R.id.confirm_to_input_otp_fab);
        backFAB = root.findViewById(R.id.back_to_prev_fab);

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

        transferAccTextView = root.findViewById(R.id.confirm_transfer_acc_text_view);
        accountBalTextView = root.findViewById(R.id.confirm_account_bal_text_view);
        receiverAccTextView = root.findViewById(R.id.confirm_receiver_acc_text_view);
        receiverNameTextView = root.findViewById(R.id.confirm_receiver_name_text_view);
        transferAmountTextView = root.findViewById(R.id.confirm_transfer_amount_text_view);
        transferContentTextView = root.findViewById(R.id.confirm_transfer_content_text_view);
        Bundle args = getArguments();
        if (args != null){
            transferAccTextView.setText(args.getString(KeyManager.ACCOUNT_ID));
            accountBalTextView.setText(args.getString(KeyManager.ACCOUNT_BALANCE));
            receiverAccTextView.setText(args.getString(KeyManager.RECEIVER_ACCOUNT_ID));
            receiverNameTextView.setText(args.getString(KeyManager.RECEIVER_NAME));
            String transferAmountStr = String.format("%s %s", args.getString(KeyManager.TRANSFER_AMOUNT),
                    args.getString(KeyManager.UNIT));
            transferAmountTextView.setText(transferAmountStr);
            transferContentTextView.setText(args.getString(KeyManager.TRANSFER_CONTENT));
        }

        return root;
    }

    private void confirmFABOnClick(){
        InputOTPTransferInsideFragment fragment = new InputOTPTransferInsideFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void backFABOnClick(){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
    }
}
