package com.example.daggerpractice;

import com.example.daggerpractice.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    // BaseApplication class is a client and AppComponent is a SERVICE. It a client <-> service iteration

    // COMPONENTS == SERVICES
    // Activities/Fragments == CLIENTS

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
