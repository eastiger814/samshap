package com.eastiger.samshap.play;

import com.eastiger.samshap.common.ObjectUtils;
import com.eastiger.samshap.game.Shape;
import com.eastiger.samshap.game.ShapeGame;

import java.util.List;

import javax.inject.Inject;

public class PlayGamePresenter {
    private ShapeGame shapeGame;
    private PlayGameView playGameView;

    @Inject
    public PlayGamePresenter(PlayGameView playGameView) {
        this.playGameView = playGameView;
    }

    public void setShapeGame(ShapeGame shapeGame) {
        this.shapeGame = shapeGame;
    }

    public int getNumColumns() {
        if (ObjectUtils.isEmpty(shapeGame)) {
            return 0;
        }

        return shapeGame.getNumColumns();
    }

    public List<Shape> getShapeOrderList() {
        return shapeGame.getShapeOrderList();
    }

    public List<Shape> getShapeList() {
        return shapeGame.getShapeList();
    }

    public void clickShape(int position) {
        Shape nextShape = getNextShape(position);
        shapeGame.getShapeList().set(position, nextShape);

        checkSameShape();
        playGameView.updateDataList();
    }

    private void checkSameShape() {
        Shape firstShape = null;
        for (Shape shape : getShapeList()) {
            if (ObjectUtils.isEmpty(firstShape)) {
                firstShape = shape;
                continue;
            }

            if (firstShape.getId() != shape.getId()) {
                return;
            }
        }

        playGameView.showCompleteGame();
    }

    private Shape getNextShape(int position) {
        Shape currentShape = shapeGame.getShapeList().get(position);
        int currentPositionInOrderList = shapeGame.getShapeOrderList().indexOf(currentShape);
        int orderSize = shapeGame.getShapeOrderList().size();
        return shapeGame.getShapeOrderList().get((currentPositionInOrderList == orderSize - 1) ? 0 : currentPositionInOrderList + 1);
    }
}
