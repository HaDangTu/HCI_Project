package com.example.mobilebanking.ui.transferinside.object;

public class ReceiverInfo {
    private String accountID;
    private String name;
    private String money;
//    private String content;
//    private int transferFee;

    public ReceiverInfo(String accountID, String name, String money) {
        this.accountID = accountID;
        this.name = name;
        this.money = money;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getName() {
        return name;
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
