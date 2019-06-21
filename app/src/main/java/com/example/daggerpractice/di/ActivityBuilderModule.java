package com.example.daggerpractice.di;

import com.example.daggerpractice.di.auth.AuthViewModelsModule;
import com.example.daggerpractice.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

// MODULES are places for dependencies to live. From here we add them to components
// ONLY Activity declarations should be here

@Module
public abstract class ActivityBuilderModule {

    //    1. Letting Dagger know that AuthActivity is a potential client
    @ContributesAndroidInjector(
            modules = { AuthViewModelsModule.class,

            }
    )
    abstract AuthActivity contributeAuthActivity();

}
