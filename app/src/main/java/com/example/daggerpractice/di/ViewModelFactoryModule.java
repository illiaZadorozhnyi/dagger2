package com.example.daggerpractice.di;

import androidx.lifecycle.ViewModelProvider;

import com.example.daggerpractice.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

// This class will be generating dependencies for ViewModelFactory class
@Module
public abstract class ViewModelFactoryModule {

//    since ViewModule will be used in AuthActivity, we need to inject it there
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

//   ===============================
// Above @Binds does exactly same thing that below @Provides, just shorter version of it (allowed when we are not doing anything inside method's body, just the return of the object)
//    @Provides
//    static ViewModelProvider.Factory bindViewModelFactory (ViewModelProviderFactory factory) {
//        return factory;
//    }
//   ===============================

}
