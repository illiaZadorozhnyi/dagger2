package com.example.daggerpractice.di;

import com.example.daggerpractice.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

// MODULES are places for dependencies to live. From here we add them to components
// ONLY Activity declarations should be here

@Module
public abstract class ActivityBuilderModule {

    //    1. Letting Dagger know that AuthActivity is a potential client
    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

}
