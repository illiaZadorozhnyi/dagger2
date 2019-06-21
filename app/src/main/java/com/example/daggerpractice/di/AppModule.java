package com.example.daggerpractice.di;

// This module is going to be used inside AppComponent

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    //    All APPLICATION LEVEL dependencies for the project are going to reside in here
    //    like retrofit, glide etc (what needs to exist for the entire lifetime of the application)
    //    Dependencies that do not go into Activities will reside here

    //    @Provides used to declare a dependency, it should be static according to documentation
    @Provides
    static String someString() {
        return "This is a test string";
    }
}


// HOW to reference other dependencies within same module ? ? ?
