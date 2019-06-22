package com.example.daggerpractice.network.auth;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

// scope of this interface should only be within Auth module
public interface AuthApi {

    @GET
    Call<ResponseBody> getResponseObject();

}
