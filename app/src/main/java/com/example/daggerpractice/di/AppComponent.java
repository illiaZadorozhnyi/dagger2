package com.example.daggerpractice.di;

import android.app.Application;

import com.example.daggerpractice.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

// COMPONENTS == SERVICES

// at View level :
// Activities/Fragments == CLIENTS

// this is required for us to be able to return a built proper DaggerAppComponent from BaseApplication after rebuilding
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
