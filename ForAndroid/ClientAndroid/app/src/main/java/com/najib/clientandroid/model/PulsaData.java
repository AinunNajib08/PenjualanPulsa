package com.najib.clientandroid.model;

import com.google.gson.annotations.SerializedName;

public class PulsaData {
    @SerializedName("id_transaksi")
    private String id_transaksi;
    @SerializedName("operator")
    private String operator;
    @SerializedName("nominal")
    private String nominal;
    @SerializedName("harga_jual")
    private String harga_jual;
    @SerializedName("no_tujuan")
    private String no_tujuan;

    public PulsaData(){}

    public PulsaData(String id_transaksi, String operator, String nominal, String harga_jual, String no_tujuan) {
        this.id_transaksi = id_transaksi;
        this.nominal = nominal;
        this.operator = operator;
        this.harga_jual = harga_jual;
        this.no_tujuan = no_tujuan;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(String harga_jual) {
        this.harga_jual = harga_jual;
    }

    public String getNo_tujuan() {
        return no_tujuan;
    }

    public void setNo_tujuan(String no_tujuan) {
        this.no_tujuan = no_tujuan;
    }
}
