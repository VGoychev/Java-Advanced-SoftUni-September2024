package _04_StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class _06_WordCount {
    public static void main(String[] args) throws IOException{
        Map<String, Integer> words = new HashMap<>();
        String firstPath = "/Users/macbookpro/Desktop/resources1/text.txt";
        String secondPath = "/Users/macbookpro/Desktop/resources1/words.txt";
        String out = "/Users/macbookpro/Desktop/resources1/output.txt";

        BufferedReader first = Files.newBufferedReader(Path.of(firstPath));
        BufferedReader second = Files.newBufferedReader(Path.of(secondPath));
        BufferedWriter writer = Files.newBufferedWriter(Path.of(out));

        String line = first.readLine();
        while (line != null) {
            String[] lineArray = line.split("\\s+");
            for (int i = 0; i < lineArray.length; i++) {
                words.put(lineArray[i], 0);
            }
            line = first.readLine();
        }
        line = second.readLine();
        while (line != null) {
            String[] lineArray = line.split("\\s+");
            for (int i = 0; i < lineArray.length; i++) {
                if (words.containsKey(lineArray[i])) {
                    words.put(lineArray[i], words.get(lineArray[i]) + 1);
                }
            }
            line = second.readLine();
        }
        words.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> {
                    try {
                        writer.write(String.format("%s - %d%n", entry.getKey(), entry.getValue()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        first.close();
        second.close();
        writer.close();
    }
}
