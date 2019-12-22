package com.example.mobilebanking.ui.paytaxbill.object;

public class TaxBill {
    private String month;
    private String sumMoney;


    public TaxBill(String month, String sumMoney ){
        this.month = month;
        this.sumMoney = sumMoney;
    }


    public String getMonth() {
        return month;
    }

    public String getSumMoney() {
        return sumMoney;
    }
}
