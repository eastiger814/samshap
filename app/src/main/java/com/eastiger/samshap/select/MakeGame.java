package com.eastiger.samshap.select;

import com.eastiger.samshap.game.Shape;
import com.eastiger.samshap.game.ShapeGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

public class MakeGame {

    List<ShapeGame> shapeGameList;

    @Inject
    public MakeGame() {
        shapeGameList = new ArrayList<>();
    }

    public List<ShapeGame> makeGames() {
        List<ShapeGame> shapeGameList = new ArrayList<>();
        shapeGameList.addAll(makeGamesWithStatus(2, 2, 4, 8));
        shapeGameList.addAll(makeGamesWithStatus(2, 3, 9, 18));
        shapeGameList.addAll(makeGamesWithStatus(2, 4, 16, 24));
        shapeGameList.addAll(makeGamesWithStatus(2, 5, 25, 50));

        shapeGameList.addAll(makeGamesWithStatus(3, 2, 4, 8));
        shapeGameList.addAll(makeGamesWithStatus(3, 3, 9, 18));
        shapeGameList.addAll(makeGamesWithStatus(3, 4, 16, 24));
        shapeGameList.addAll(makeGamesWithStatus(3, 5, 25, 50));

        return shapeGameList;
    }

    public List<ShapeGame> makeGamesWithStatus(int orderCount, int numColumns, int shapeCount, int gameCount) {
        List<ShapeGame> shapeGameList = new ArrayList<>();
        if (gameCount > (Math.pow(orderCount, shapeCount))) {
            throw new RuntimeException("Game Count is not appropriate when make game ~!!");
        }

        Set<String> shapeListSet = new HashSet<>();
        List<Shape> orderList = makeOrder(orderCount);

        while (shapeGameList.size() < gameCount) {
            List<Shape> shapeList = makeShapeList(shapeCount, orderList);

            ShapeGame shapeGame = ShapeGame.builder()
                    .numColumns(numColumns)
                    .shapeOrderList(orderList)
                    .shapeList(shapeList)
                    .build();

            String shapeListKey = makeKey(shapeGame.getShapeList());
            if (shapeListSet.contains(shapeListKey)) {
                continue;
            }

            shapeListSet.add(shapeListKey);
            shapeGameList.add(shapeGame);
        }

        return shapeGameList;
    }

    private String makeKey(List<Shape> shapeList) {
        StringBuffer typeKey = new StringBuffer();
        for (Shape shape : shapeList) {
            typeKey.append(shape.getId());
        }
        return typeKey.toString();
    }

    private List<Shape> makeShapeList(int listCount, List<Shape> orderList) {
        int shapeCount = orderList.size();

        List<Shape> shapeList = new ArrayList<>();

        for (int i = 0; i < listCount; i++) {
            Shape shape = Shape.get(String.valueOf(((int) (Math.random() * 10) % shapeCount) + 1));
            shapeList.add(shape);
        }

        return shapeList;
    }

    //TODO : Have to remove same order with opposite order
    private List<Shape> makeOrder(int shapeCount) {
        List<Shape> orderList = new ArrayList<>();
        if (shapeCount < 2) {
            return orderList;
        }

        while (orderList.size() < shapeCount) {
            Shape shape = Shape.get(String.valueOf(((int) (Math.random() * 10) % shapeCount) + 1));
            if (!orderList.contains(shape)) {
                orderList.add(shape);
            }
        }

        return orderList;
    }
}
