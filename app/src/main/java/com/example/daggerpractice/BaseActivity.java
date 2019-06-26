package com.example.daggerpractice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.example.daggerpractice.models.User;
import com.example.daggerpractice.ui.auth.AuthActivity;
import com.example.daggerpractice.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    private void subscribeObservers() {
//        This allows us to have other activities extend BaseActivity and we don't have to manage Authentication state of the user anywhere else
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING: {
                            break;
                        }

                        case AUTHENTICATED: {
                            Log.d(TAG, "onChanged: LOGIN SUCCESS " + userAuthResource.data.getEmail());
                            break;
                        }

                        case ERROR: {
                            break;
                        }

                        case NOT_AUTHENTICATED: {
                            navigateToLoginPage();
                            break;
                        }
                    }
                }
            }
        });
    }

    private void navigateToLoginPage() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
