package com.eastiger.samshap.application.di;

import android.content.Context;

import com.eastiger.samshap.common.di.PerView;

import javax.inject.Singleton;

@PerView
public interface ApplicationInterface {

    Context context();
}
