package com.example.daggerpractice.network.auth;

import com.example.daggerpractice.models.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

// scope of this interface should only be within Auth module
public interface AuthApi {


//    1. Return Flawable object (Rx object)
//    2. Inside ViewModel we can convert Flowable into LiveData object
    @GET("users/{id}") // <-- this tells us which call will result getting one User object from the endpoint, ex. users/4
    Flowable<User> getUser(@Path("id") int id); // <-- this needs to match @GET above
}

