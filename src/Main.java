import controller.ShapeController;
import model.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle("Red", 4, 5),
                new Rectangle("Green", 6, 6),
                new Rectangle("Yellow", 2, 8),
                new Triangle("Purple", 4, 6),
                new Triangle("Navy", 7, 3),
                new Triangle("Cyan", 5, 5),
                new Circle("Pink", 3),
                new Circle("Beige", 5),
                new Circle("Orange", 2.5)
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
