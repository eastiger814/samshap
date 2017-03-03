package com.eastiger.samshap.select;

import com.eastiger.samshap.game.ShapeGame;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;

public class SelectGamePresenter {

    @Getter
    List<ShapeGame> shapeGameList;

    @Inject
    public SelectGamePresenter() {
    }

    public void makeGames() {
        shapeGameList = new MakeGame().makeGames();
    }

    public ShapeGame getShapeGame(int position) {
        return shapeGameList.get(position);
    }
}
