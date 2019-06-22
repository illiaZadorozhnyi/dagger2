package com.example.daggerpractice.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.daggerpractice.models.User;
import com.example.daggerpractice.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;

//        these below are just to verify that injection is working properly
//        =============================
        Log.d(TAG, "AuthViewModel: AuthViewModel is working...");

        if (this.authApi == null) {
            Log.d(TAG, "AuthViewModel: AuthApi is NULL");
        } else {
            Log.d(TAG, "AuthViewModel: AuthApi is PRESENT and NOT NULL");
        }
//        =============================

//        test request to check retrofit hitting api and getting User object below

        authApi.getUser(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        
                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "onNext from AuthApi: should be background thread " + Thread.currentThread().getName());
                        Log.d(TAG, "onNext from AuthApi: users email address was retrieved: " + user.getEmail());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError from AuthApi: " + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
