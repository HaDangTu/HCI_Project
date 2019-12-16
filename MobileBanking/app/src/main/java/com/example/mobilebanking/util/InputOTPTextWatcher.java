package com.example.mobilebanking.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class InputOTPTextWatcher implements TextWatcher {
    private EditText nextEditText;

    public InputOTPTextWatcher(EditText nextEditText){
        this.nextEditText = nextEditText;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        nextEditText.requestFocus();
    }
}
