package com.najib.data.Model;

import com.google.gson.annotations.SerializedName;

public class Pulsa {
    @SerializedName("id")
    private String id;
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

    public String getNo_tujuan() {
        return no_tujuan;
    }

    public void setNo_tujuan(String no_tujuan) {
        this.no_tujuan = no_tujuan;
    }

    @SerializedName("status")
    private String status;


    public Pulsa(){

    }

    public Pulsa(String no_tujuan) {
        this.no_tujuan = no_tujuan;
    }

    public Pulsa(String id, String id_transaksi, String operator, String nominal, String harga_jual, String status) {
        this.id = id;
        this.id_transaksi = id_transaksi;
        this.operator = operator;
        this.nominal = nominal;
        this.harga_jual = harga_jual;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
