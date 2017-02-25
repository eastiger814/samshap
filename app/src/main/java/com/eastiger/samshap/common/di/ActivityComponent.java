package com.eastiger.samshap.common.di;

import android.app.Activity;

import com.eastiger.samshap.application.SamShapApplication;

import dagger.Component;

@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(Activity activity);
}
