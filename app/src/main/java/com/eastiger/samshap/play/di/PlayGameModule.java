package com.eastiger.samshap.play.di;

import com.eastiger.samshap.common.di.PerView;
import com.eastiger.samshap.play.PlayGameView;

import dagger.Module;
import dagger.Provides;

@Module
public class PlayGameModule {
    private PlayGameView playGameView;

    public PlayGameModule(PlayGameView playGameView) {
        this.playGameView = playGameView;
    }

    @Provides
    @PerView
    public PlayGameView arrangeSameShapeView() {
        return playGameView;
    }
}
