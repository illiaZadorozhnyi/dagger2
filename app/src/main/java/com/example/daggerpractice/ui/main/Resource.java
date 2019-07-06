package com.example.daggerpractice.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Resource<T> {

    @Nullable
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    public Resource(@NonNull Status status, @NonNull T data, @NonNull String message) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(@NonNull String msg, T data) {
        return new Resource<>(Status.ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@NonNull T data) {
        return new Resource<>(Status.LOADING, data, null);
    }

    public enum Status {ERROR, LOADING, SUCCESS}
}
