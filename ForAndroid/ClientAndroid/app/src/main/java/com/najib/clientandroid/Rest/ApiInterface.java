package com.najib.clientandroid.Rest;

import com.najib.clientandroid.model.GetPulsa;
import com.najib.clientandroid.model.PostPutDelPulsa;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {

    @GET("pulsa")
    Call<GetPulsa> getPulsa();

    @GET("pulsaa")
    Call<GetPulsa> getPulsaa();
    @FormUrlEncoded
    @POST("Pulsa")
    Call<PostPutDelPulsa> postPulsa(@Field("nama") String nama,
                                    @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("Pulsa")
    Call<PostPutDelPulsa> putPulsa(@Field("id") String id,
                                   @Field("nama") String nama,
                                   @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Pulsa", hasBody = true)
    Call<PostPutDelPulsa> deletePulsa(@Field("id") String id);
}
