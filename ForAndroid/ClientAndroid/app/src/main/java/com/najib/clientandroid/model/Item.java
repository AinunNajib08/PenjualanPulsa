package com.najib.clientandroid.model;

import java.io.Serializable;

/**
 * Created by Mahmudinm on 20/12/2018.
 */

public class Item implements Serializable {

    String id_transaksi, operator, status;
    int id, nominal, harga_jual, no_tujuan;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    public int getNo_tujuan() {
        return no_tujuan;
    }

    public void setNo_tujuan(int no_tujuan) {
        this.no_tujuan = no_tujuan;
    }
}
