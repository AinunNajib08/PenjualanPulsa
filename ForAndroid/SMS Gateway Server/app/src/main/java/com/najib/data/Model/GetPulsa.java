package com.najib.data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPulsa {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Pulsa> listDataKontak;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Pulsa> getListDataKontak() {
        return listDataKontak;
    }

    public void setListDataKontak(List<Pulsa> listDataKontak) {
        this.listDataKontak = listDataKontak;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
