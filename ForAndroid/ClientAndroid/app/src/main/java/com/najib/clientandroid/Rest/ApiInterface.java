package com.najib.clientandroid.Rest;

import com.najib.clientandroid.model.Pulsa;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("pendaftaran")


    @FormUrlEncoded
    @POST("pulsa")
    Call<Pulsa> postItem(@Field("id_transaksi") String id_transaksi,
                         @Field("operator") String operator,
                         @Field("nominal") String nominal,
                         @Field("harga_jual") String harga_jual,
                         @Field("no_tujuan") String no_tujuan);

}
