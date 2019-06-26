package com.example.daggerpractice.di;

import android.app.Application;

import com.example.daggerpractice.BaseApplication;
import com.example.daggerpractice.SessionManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

// COMPONENTS == SERVICES

// at View level :
// Activities/Fragments == CLIENTS

// this is required for us to be able to return a built proper DaggerAppComponent from BaseApplication after rebuilding

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        AppModule.class,
        ViewModelFactoryModule.class,

})

public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessionManager();

    @Component.Builder
    interface Builder {

//        This binding means that every time when AppComponent is created, it is going to have
//        Application bind to it and available
//        This makes it available in all the modules of AppComponent !!!
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
