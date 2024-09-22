package _04_StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class _03_AllCapitals {
    public static void main(String[] args) {
        String inPath = "/Users/macbookpro/Desktop/resources1/input.txt";
        String outPath = "/Users/macbookpro/Desktop/resources1/output.txt";

        try(BufferedReader in = new BufferedReader(new FileReader(inPath));
            PrintWriter out = new PrintWriter(new FileWriter(outPath))) {
            String line = in.readLine();
            while (line != null){
                String newLine = "";
                for (char c : line.toCharArray()){
                    char upperCase = Character.toUpperCase(c);
                    newLine += upperCase;
                }
                out.println(newLine);

                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
