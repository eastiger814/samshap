package com.eastiger.samshap.game;

import com.eastiger.samshap.R;

import lombok.Getter;

public enum Shape {
    NONE("0", "none", 0),
    CIRCLE("1", "circle", R.drawable.shape_circle),
    TRIANGLE("2", "triangle", R.drawable.shape_triangle),
    RECTANGLE("3", "rectangle", R.drawable.shape_rectangle),
    PENTAGON("4", "pentagon", R.drawable.shape_pentagon);

    @Getter
    String id;

    @Getter
    String description;

    @Getter
    int rscId;

    Shape(String id, String description, int rscId) {
        this.id = id;
        this.description = description;
        this.rscId = rscId;
    }

    public static Shape get(String id) {
        for (Shape shape : Shape.values()) {
            if (shape.getId().equals(id)) {
                return shape;
            }
        }
        return NONE;
    }
}
