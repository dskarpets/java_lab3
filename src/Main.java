import controller.ShapeController;
import io.*;
import model.*;
import view.ShapeView;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] shapes = {
                new Rectangle("Red", 4, 5),
                new Rectangle("Green", 6, 6),
                new Triangle("Purple", 4, 6),
                new Circle("Pink", 3),
                new Triangle("Cyan", 8, 6),
                new Circle("Ginger", 5)
        };
        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);

        while (true) {
            System.out.println("""
                    1. Робота з фігурами
                    2. Знайти рядок з найбільшою кількістю слів у файлі
                    3. Шифрування/дешифрування тексту
                    4. Підрахунок частоти тегів на сторінці
                    5. Вийти
                    Введіть номер завдання:
                    """);

            String input = sc.nextLine();
            switch (input) {
                case "1" -> shapesMenu(controller, view, sc);
                case "2" -> analyzeText(sc);
                case "3" -> cipher(sc);
                case "4" -> countTags(sc);
                case "5" -> {
                    return;
                }
                default -> System.out.println("Невірний вибір! Спробуйте ще раз.");
            }
        }
    }

    private static void shapesMenu(ShapeController controller, ShapeView view, Scanner sc) {
        Shape[] shapes = controller.getShapes();
        while (true) {
            System.out.println("""
                    Дії з фігурами
                    1. Показати всі фігури
                    2. Порахувати сумарну площу
                    3. Відсортувати за площею
                    4. Відсортувати за кольором
                    5. Зберегти фігури у файл
                    6. Завантажити фігури з файлу
                    7. Повернутися в головне меню
                    Виберіть дію:
                    """);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> controller.showAllShapes();
                case "2" -> controller.totalArea();
                case "3" -> controller.sortByArea();
                case "4" -> controller.sortByColor();
                case "5" -> {
                    System.out.print("Введіть ім'я файлу для збереження: ");
                    String file = sc.nextLine();
                    ShapeFileManager.saveShapes(file, controller.getShapes());
                }
                case "6" -> {
                    System.out.print("Введіть ім'я файлу для зчитування: ");
                    String file = sc.nextLine();
                    Shape[] loaded = ShapeFileManager.loadShapes(file);
                    controller.setShapes(loaded);
                    System.out.println("Дані успішно завантажено!");
                }
                case "7" -> {
                    return;
                }
                default -> System.out.println("Невірний вибір!");
            }
        }
    }

    private static void analyzeText(Scanner sc) {
        System.out.print("Введіть шлях до файлу: ");
        String file = sc.nextLine();
        String line = TextAnalyzer.findLineWithMostWords(file);
        System.out.println("\nРядок з найбільшою кількістю слів:\n" + line + "\n");
    }

    private static void cipher(Scanner sc) {
        System.out.print("Введіть шлях до вхідного файлу: ");
        String input = sc.nextLine();
        System.out.print("Введіть шлях до вихідного файлу: ");
        String output = sc.nextLine();
        System.out.print("Введіть ключовий символ: ");
        char key = sc.nextLine().charAt(0);

        System.out.println("""
                Виберіть дію:
                1. Шифрувати
                2. Дешифрувати
                """);
        String action = sc.nextLine();
        if (action.equals("1")) {
            StreamCipher.encrypt(input, output, key);
            System.out.println("Файл зашифровано!");
        } else if (action.equals("2")) {
            StreamCipher.decrypt(input, output, key);
            System.out.println("Файл дешифровано!");
        } else {
            System.out.println("Невірний вибір!");
        }
    }

    private static void countTags(Scanner sc) {
        System.out.print("Введіть URL: ");
        String url = sc.nextLine();
        Map<String, Integer> tags = TagFrequencyCounter.countTags(url);
        if (tags.isEmpty()) {
            System.out.println("Не вдалося отримати дані з URL.");
            return;
        }

        System.out.println("\nСортування тегів за назвою:");
        TagFrequencyCounter.printSorted(tags, true);

        System.out.println("\nСортування тегів за частотою:");
        TagFrequencyCounter.printSorted(tags, false);
    }
}
