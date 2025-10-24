package io;

import java.io.*;

public class StreamCipher {

    public static void encrypt(String inputFile, String outputFile, char key) {
        try (FileReader fr = new FileReader(inputFile);
             FileWriter fw = new FileWriter(outputFile)) {
            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c + key);
            }
        } catch (IOException e) {
            System.out.println("Помилка шифрування: " + e.getMessage());
        }
    }

    public static void decrypt(String inputFile, String outputFile, char key) {
        try (FileReader fr = new FileReader(inputFile);
             FileWriter fw = new FileWriter(outputFile)) {
            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c - key);
            }
        } catch (IOException e) {
            System.out.println("Помилка дешифрування: " + e.getMessage());
        }
    }
}
