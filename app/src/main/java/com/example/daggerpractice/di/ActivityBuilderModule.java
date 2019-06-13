package com.example.daggerpractice.di;

import com.example.daggerpractice.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

// MODULES are places for dependencies to live. From here we add them to components

@Module
public abstract class ActivityBuilderModule {

    //    1. Letting Dagger know that auth activity is a potential client
    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

    @Provides
    static String someString() {
        return "This is a test string";
    }
}
