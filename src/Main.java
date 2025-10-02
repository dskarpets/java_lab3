import controller.ShapeController;
import model.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle("Red", 4, 5),
                new Circle("Blue", 3),
                new Triangle("Green", 4, 6),
                new Rectangle("Yellow", 2, 8),
                new Circle("Red", 5),
                new Triangle("Blue", 7, 3),
                new Rectangle("Green", 6, 6),
                new Circle("Yellow", 2.5),
                new Triangle("Red", 5, 5),
                new Rectangle("Blue", 3, 9)
        };

        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);

        controller.showAllShapes();
        controller.totalArea();
        controller.totalAreaByType(Rectangle.class);
        controller.totalAreaByType(Circle.class);
        controller.totalAreaByType(Triangle.class);
        System.out.println(" ");
        controller.sortByArea();
        controller.sortByColor();
    }
}
