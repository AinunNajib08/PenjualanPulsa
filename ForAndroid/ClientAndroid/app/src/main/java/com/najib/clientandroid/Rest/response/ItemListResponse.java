package com.najib.clientandroid.Rest.response;

import com.najib.clientandroid.model.Item;

import java.util.List;

/**
 * Created by Mahmudinm on 20/12/2018.
 */

public class ItemListResponse {

    private String message;
    List<Item> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Item> getData() {
        return data;
    }

    public void setData(List<Item> data) {
        this.data = data;
    }
}
