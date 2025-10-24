package controller;

import view.ShapeView;

import java.util.Arrays;
import java.util.Comparator;

import model.*;

public class ShapeController {
    private Shape[] shapes;
    private ShapeView view;

    public ShapeController(Shape[] shapes, ShapeView view) {
        this.shapes = shapes;
        this.view = view;
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }


    public void showAllShapes() {
        view.displayMessage("=== All Shapes ===");
        view.displayShapes(shapes);
    }

    public void totalArea() {
        double total = 0;
        for (Shape s : shapes) {
            total += s.calcArea();
        }
        view.displayMessage("Total area of all shapes = " + total);
    }

    public void totalAreaByType(Class<?> type) {
        double total = 0;
        for (Shape s : shapes) {
            if (type.isInstance(s)) {
                total += s.calcArea();
            }
        }
        view.displayMessage("Total area of " + type.getSimpleName() + "s = " + total);
    }

    public void sortByArea() {
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
        view.displayMessage("=== Sorted by Area ===");
        view.displayShapes(shapes);
    }

    public void sortByColor() {
        Arrays.sort(shapes, Comparator.comparing(s -> s.shapeColor));
        view.displayMessage("=== Sorted by Color ===");
        view.displayShapes(shapes);
    }
}
