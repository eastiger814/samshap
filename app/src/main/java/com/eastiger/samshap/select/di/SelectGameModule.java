package com.eastiger.samshap.select.di;

import com.eastiger.samshap.common.di.PerView;
import com.eastiger.samshap.select.SelectGameView;

import dagger.Module;
import dagger.Provides;

@Module
public class SelectGameModule {
    private SelectGameView selectGameView;

    public SelectGameModule(SelectGameView selectGameView) {
        this.selectGameView = selectGameView;
    }

    @Provides
    @PerView
    public SelectGameView selectGameView() {
        return selectGameView;
    }
}
