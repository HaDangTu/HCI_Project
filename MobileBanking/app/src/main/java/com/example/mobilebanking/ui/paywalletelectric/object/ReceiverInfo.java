package com.example.mobilebanking.ui.paywalletelectric.object;

public class ReceiverInfo {
    private String accountID;
    private String money;
    private String TypeWallet;

//    private String content;
//    private int transferFee;

    public ReceiverInfo(String accountID, String TypeWallet, String money) {
        this.accountID = accountID;
        this.TypeWallet = TypeWallet;
        this.money = money;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getTypeWallet() {
        return TypeWallet;
    }

    public String getMoney() {
        return money;
    }

//    public String getContent() {
//        return content;
//    }
//
//    public int getTransferFee() {
//        return transferFee;
//    }
}
