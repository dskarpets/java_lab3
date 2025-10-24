package io;

import java.io.*;

public class TextAnalyzer {
    public static String findLineWithMostWords(String filePath) {
        String maxLine = "";
        int maxWords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int wordCount = line.trim().split("\\s+").length;
                if (wordCount > maxWords) {
                    maxWords = wordCount;
                    maxLine = line;
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }

        return maxLine;
    }
}

