package com.example.daggerpractice.network.auth;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

// scope of this interface should only be within Auth module
public interface AuthApi {


//    1. Return Flawable object (Rx object)
//    2. Inside ViewModel we can convert Flowable into LiveData object
    @GET
    Flowable<ResponseBody> getResponseObject();

}
