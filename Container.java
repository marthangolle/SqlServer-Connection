package com.example.sqlverbindung.model;

import androidx.annotation.NonNull;

public class Container {

    private int BID;
    private int RFID;
    private String HID;

    // Getters and Setters
    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public int getRFID() {
        return RFID;
    }

    public void setRFID(int RFID) {
        this.RFID = RFID;
    }

    public String getHID() {
        return HID;
    }

    public void setHID(String HID) {
        this.HID = HID;
    }

    // Corrected toString() method
    @NonNull
    @Override
    public String toString() {
        return "Container {" +
                "BID=" + BID +
                ", RFID=" + RFID +
                ", HID='" + HID + '\'' +
                '}';
    }
}






