package com.example.mobilebanking.ui.payphonebill.object;

public class PhoneInfo {
    private String phoneNumber;
    private int phoneCard;
    private int supplier;


    public PhoneInfo(String phoneNumber, int phoneCard, int supplier) {
        this.phoneNumber = phoneNumber;
        this.phoneCard = phoneCard;
        this.supplier = supplier;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPhoneCard() {
        return phoneCard;
    }

    public int getSupplier() {
        return supplier;
    }
}
