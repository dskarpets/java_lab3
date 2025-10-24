package model;

import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable {
    public String shapeColor;
    private static final long serialVersionUID = 1L;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "Shape (color=" + shapeColor + ")";
    }
}
