package com.eastiger.samshap.application.di;

import com.eastiger.samshap.application.SamShapApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(SamShapApplication samShapApplication);
}
