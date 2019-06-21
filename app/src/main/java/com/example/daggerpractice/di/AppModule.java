package com.example.daggerpractice.di;

// This module is going to be used inside AppComponent

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.daggerpractice.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    //    All APPLICATION LEVEL dependencies for the project are going to reside in here
    //    like retrofit, glide etc (what needs to exist for the entire lifetime of the application)
    //    Dependencies that do not go into Activities will reside here

    //    @Provides used to declare a dependency, it should be static according to documentation
    @Singleton
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }

    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static Drawable provideAppDrawable(Application application) {
        return ContextCompat.getDrawable(application, R.drawable.dagger_logo);
    }

}


// HOW to reference other dependencies within same module ? ? ?
