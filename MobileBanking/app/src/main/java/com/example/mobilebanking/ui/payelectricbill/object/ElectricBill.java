package com.example.mobilebanking.ui.payelectricbill.object;

public class ElectricBill {
    private String month;
    private String oldValue;
    private String newValue;
    private String sumMoney;


    public ElectricBill(String month, String oldValue, String newValue, String sumMoney ){
        this.month = month;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.sumMoney = sumMoney;
    }


    public String getMonth() {
        return month;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getSumMoney() {
        return sumMoney;
    }
}
