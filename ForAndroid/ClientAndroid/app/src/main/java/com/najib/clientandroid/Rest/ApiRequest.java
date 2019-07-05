package com.najib.clientandroid.Rest;

import com.najib.clientandroid.Rest.response.ItemListResponse;
import com.najib.clientandroid.Rest.response.StatusResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by Mahmudinm on 20/12/2018.
 */

public interface ApiRequest {

    @GET("pulsa")
    Call<ItemListResponse> getPulsa();

    @FormUrlEncoded
    @POST("pulsa")
    Call<StatusResponse> postItem(@Field("id_transaksi") String id_transaksi,
                                  @Field("operator") String operator,
                                  @Field("nominal") String nominal,
                                  @Field("harga_jual") String harga_jual,
                                  @Field("no_tujuan") String no_tujuan);

    @FormUrlEncoded
    @PUT("item")
    Call<StatusResponse> putItem(@Field("id") String id,
                                 @Field("nama") String nama,
                                 @Field("harga") String harga);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "item", hasBody = true)
    Call<StatusResponse> deleteItem(@Field("id") String id);

}
