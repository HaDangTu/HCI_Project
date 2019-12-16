package com.example.mobilebanking.ui.payelectricbill.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilebanking.R;
import com.example.mobilebanking.util.InputOTPTextWatcher;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputOTPPayElectricBillFragment extends Fragment {

    private EditText inputOTP1;
    private EditText inputOTP2;
    private EditText inputOTP3;
    private EditText inputOTP4;
    private EditText inputOTP5;
    private EditText inputOTP6;

    private FloatingActionButton resetFAB;
    private FloatingActionButton confirmFAB;


    public InputOTPPayElectricBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_input_otp_pay_electric_bill, container, false);

        inputOTP1 = root.findViewById(R.id.input_otp_1);
        inputOTP2 = root.findViewById(R.id.input_otp_2);
        inputOTP3 = root.findViewById(R.id.input_otp_3);
        inputOTP4 = root.findViewById(R.id.input_otp_4);
        inputOTP5 = root.findViewById(R.id.input_otp_5);
        inputOTP6 = root.findViewById(R.id.input_otp_6);

        resetFAB = root.findViewById(R.id.reset_fab);
        confirmFAB = root.findViewById(R.id.confirm_fab);

        resetFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFABOnClick();
            }
        });

        confirmFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmFABOnClick();
            }
        });

        inputOTP1.addTextChangedListener(new InputOTPTextWatcher(inputOTP2));
        inputOTP2.addTextChangedListener(new InputOTPTextWatcher(inputOTP3));
        inputOTP3.addTextChangedListener(new InputOTPTextWatcher(inputOTP4));
        inputOTP4.addTextChangedListener(new InputOTPTextWatcher(inputOTP5));
        inputOTP5.addTextChangedListener(new InputOTPTextWatcher(inputOTP6));
        inputOTP6.addTextChangedListener(new InputOTPTextWatcher(inputOTP1));

        return root;
    }

    private void resetFABOnClick(){
        inputOTP1.setText("");
        inputOTP2.setText("");
        inputOTP3.setText("");
        inputOTP4.setText("");
        inputOTP5.setText("");
        inputOTP6.setText("");

        Toast.makeText(getContext(), "Mã OTP đã được gửi đến bạn", Toast.LENGTH_LONG).show();
    }

    private void confirmFABOnClick(){
        ResultPayElectricBillFragment fragment = new ResultPayElectricBillFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }
}
