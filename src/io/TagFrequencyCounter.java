package io;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class TagFrequencyCounter {

    public static Map<String, Integer> countTags(String urlStr) {
        Map<String, Integer> tagCount = new HashMap<>();
        try {
            URL url = new URL(urlStr);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            Pattern tagPattern = Pattern.compile("<\\s*(\\w+)");
            while ((line = in.readLine()) != null) {
                Matcher m = tagPattern.matcher(line);
                while (m.find()) {
                    String tag = m.group(1).toLowerCase();
                    tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні URL: " + e.getMessage());
        }
        return tagCount;
    }

    public static void printSorted(Map<String, Integer> map, boolean byTag) {
        map.entrySet().stream()
                .sorted(byTag ?
                        Map.Entry.comparingByKey() :
                        Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
