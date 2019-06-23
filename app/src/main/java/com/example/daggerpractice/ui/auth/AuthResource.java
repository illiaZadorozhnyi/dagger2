package com.example.daggerpractice.ui.auth;

import androidx.annotation.Nullable;

public class AuthResource<T> {

    @Nullable
    public final AuthStatus status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    public AuthResource(AuthStatus status, T data, String message) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public static <T> AuthResource<T> authenticated (T data) {
        return new AuthResource<>(AuthStatus.AUTHENTICATED, data, null);
    }

    public static <T> AuthResource<T> error (String msg,T data) {
        return new AuthResource<>(AuthStatus.ERROR, data, msg);
    }

    public static <T> AuthResource<T> loading (T data) {
        return new AuthResource<>(AuthStatus.LOADING, data, null);
    }

    public static <T> AuthResource<T> logout () {
        return new AuthResource<>(AuthStatus.NOT_AUTHENTICATED, null, null);
    }

    public enum AuthStatus {
        ERROR, LOADING, AUTHENTICATED, NOT_AUTHENTICATED
    }
}
