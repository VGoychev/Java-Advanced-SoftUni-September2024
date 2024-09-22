package _04_StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _07_MergeTwoFiles {
    public static void main(String[] args) {

        String firstPath = "/Users/macbookpro/Desktop/resources1/inputOne.txt";
        String secondPath = "/Users/macbookpro/Desktop/resources1/inputTwo.txt";
        String out = "/Users/macbookpro/Desktop/resources1/output.txt";

        try(BufferedReader first = Files.newBufferedReader(Path.of(firstPath));
        BufferedReader second = Files.newBufferedReader(Path.of(secondPath));
        PrintWriter writer = new PrintWriter(out)) {

            String line = first.readLine();
            while (line != null) {
                writer.println(line);
                line = first.readLine();
            }
            line = second.readLine();
            while (line != null) {
                writer.println(line);
                line = second.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
