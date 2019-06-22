package com.example.daggerpractice.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.daggerpractice.network.auth.AuthApi;

import javax.inject.Inject;

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
    }

}
