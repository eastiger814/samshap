package com.eastiger.samshap.application;

import android.app.Application;

import com.eastiger.samshap.application.di.ApplicationComponent;
import com.eastiger.samshap.application.di.ApplicationModule;
import com.eastiger.samshap.application.di.DaggerApplicationComponent;

public class SamShapApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

}
