package android.tvz.hr.happyenvelope.retrofit.services;

import android.tvz.hr.happyenvelope.retrofit.models.AccessToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Auth {
    @FormUrlEncoded
    @POST("/Token")
    Call<AccessToken> getAccessToken(
            @Field("username") String username,
            @Field("password") String password,
            @Field("grant_type") String grantType);
}
