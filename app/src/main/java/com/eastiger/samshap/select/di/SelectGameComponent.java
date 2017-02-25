package com.eastiger.samshap.select.di;

import com.eastiger.samshap.application.di.ApplicationComponent;
import com.eastiger.samshap.common.di.PerView;
import com.eastiger.samshap.select.SelectGameFragment;

import dagger.Component;

@PerView
@Component(dependencies = {ApplicationComponent.class}, modules = {SelectGameModule.class})
interface SelectGameComponent {

    void inject(SelectGameFragment selectGameFragment);
}
