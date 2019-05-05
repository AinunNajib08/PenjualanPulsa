package android.com.penjualanpulsa.api;

import android.com.penjualanpulsa.model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegistrasiAPI {


    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar(@Field("nim") String nim,
                       @Field("nama") String nama,
                       @Field("jurusan") String jurusan,
                       @Field("jk") String jk
    );
    @GET("view.php")
    Call<Value> view();
}
