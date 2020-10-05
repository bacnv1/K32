package com.hanabi.thithu.api;

import com.hanabi.thithu.models.Message;
import com.hanabi.thithu.models.User;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("login.php")
    Call<User> login(
            @Field("username") String userName,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> register(
            @Field("username") String userName,
            @Field("password") String password,
            @Field("name") String name);

    @FormUrlEncoded
    @POST("chat.php")
    Call<ResponseBody> chat(
            @Field("username") String userName,
            @Field("message") String message);

    @GET("list-chat.php")
    Call<List<Message>> getChat();
}
