package io;

import model.Shape;
import java.io.*;

public class ShapeFileManager {
    public static void saveShapes(String filePath, Shape[] shapes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(shapes);
            System.out.println("Об'єкти збережено у файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні: " + e.getMessage());
        }
    }

    public static Shape[] loadShapes(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Shape[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при зчитуванні: " + e.getMessage());
            return new Shape[0];
        }
    }
}
