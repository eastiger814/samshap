package com.eastiger.samshap.play.di;

import com.eastiger.samshap.application.di.ApplicationComponent;
import com.eastiger.samshap.common.di.PerView;
import com.eastiger.samshap.play.PlayGameFragment;

import dagger.Component;

@PerView
@Component(dependencies = {ApplicationComponent.class}, modules = {PlayGameModule.class})
interface PlayGameComponent {

    void inject(PlayGameFragment playGameFragment);
}
