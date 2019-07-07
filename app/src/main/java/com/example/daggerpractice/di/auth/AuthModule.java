package com.example.daggerpractice.di.auth;

import com.example.daggerpractice.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

//    we can access this inside AuthActivity subcomponent built by ContributesAndroidInjector module section
//    and our retrofit instance is inside parent AppComponent
    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

}
