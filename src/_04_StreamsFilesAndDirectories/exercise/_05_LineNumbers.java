package _04_StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class _05_LineNumbers {
    public static void main(String[] args) {

        String inPath = "/Users/macbookpro/Desktop/resources1/inputLineNumbers.txt";
        String outPath = "/Users/macbookpro/Desktop/resources1/output.txt";

        try(BufferedReader in = new BufferedReader(new FileReader(inPath));
            PrintWriter out = new PrintWriter(new FileWriter(outPath))) {
            int number = 1;
            String line = in.readLine();
            while (line != null){
                out.println(number +". " + line);
                number++;
                line = in.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
