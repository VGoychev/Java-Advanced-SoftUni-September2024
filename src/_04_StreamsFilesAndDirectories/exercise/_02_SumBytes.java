package _04_StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _02_SumBytes {
    public static void main(String[] args) {
        String path = "/Users/macbookpro/Desktop/resources1/input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line = reader.readLine();
            long sum = 0;
            while (line != null){
                for (char c : line.toCharArray()){
                    sum += c;
                }

                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
