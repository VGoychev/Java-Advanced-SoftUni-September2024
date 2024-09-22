package _04_StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _01_SumLines {
    public static void main(String[] args) {
        String path = "/Users/macbookpro/Desktop/resources1/input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line = reader.readLine();

            while (line != null){
                long sum = 0;
                for (char c : line.toCharArray()){
                    sum += c;
                }

                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
