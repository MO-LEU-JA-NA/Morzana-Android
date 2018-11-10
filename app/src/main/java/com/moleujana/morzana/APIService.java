package com.moleujana.morzana;

import com.moleujana.morzana.mrzn.Login;
import com.moleujana.morzana.mrzn.Message;
import com.moleujana.morzana.mrzn.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Retrofit;
import retrofit2.http.Query;

/**
 * Created by gsy01 on 2018-11-10.
 */

public interface APIService {
    @POST("/api/auth/register")
    Call<User> register(@Body User body);
    @POST("/api/auth/login")
    Call<User> login(@Field("u_id") String id,
                      @Field("u_password") String password);
    @GET("/api/auth/idCheck")
    Call<User> idCheck(@Query("u_id") String id);
    @GET("/api/morzana/joinedUser") // array (name, phoneNum, idx)
    Call<List<User>> joinedUser();
    @POST("/api/morzana/sendMessage")
    Call<Message> sendMessage(@Body Message body);
    @GET("/api/morzana/sendMessageList") // array (contents, time)
    Call<List<Message>> sendMessageList(@Query("u_idx_caller") int idx_caller);
    @GET("/api/morzana/receiveMessageList") // array
    Call<List<Message>> receiveMessageList(@Query("u_idx_receiver") int idx_receiver);
}
