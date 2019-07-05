package com.najib.clientandroid.model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelPulsa {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pulsa mPulsa;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pulsa getmPulsa() {
        return mPulsa;
    }

    public void setmPulsa(Pulsa mPulsa) {
        this.mPulsa = mPulsa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
