package com.najib.clientandroid.model;

import com.google.gson.annotations.SerializedName;

public class Pulsa {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    PulsaData mPulsa;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public PulsaData getmPulsa() {
        return mPulsa;
    }
    public void setmPulsa(PulsaData PulsaData) {
        mPulsa = PulsaData;
    }

}
