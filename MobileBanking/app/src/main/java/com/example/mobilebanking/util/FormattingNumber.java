package com.example.mobilebanking.util;

import java.text.NumberFormat;

public class FormattingNumber {
    public static String format(String number){
        number = number.replaceAll("[.]|,", "");
        return NumberFormat.getInstance()
                .format(Long.parseLong(number));
    }
}
