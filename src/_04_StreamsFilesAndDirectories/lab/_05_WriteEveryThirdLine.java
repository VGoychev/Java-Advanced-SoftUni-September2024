package _04_StreamsFilesAndDirectories.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class _05_WriteEveryThirdLine {
    public static void main(String[] args) {
        String readPath = "/Users/macbookpro/Desktop/resources/input.txt";
        String writePath = "/Users/macbookpro/Desktop/resources/05.WriteEveryThirdLineOutput.txt";
        try(BufferedReader in = new BufferedReader(new FileReader(readPath));
        PrintWriter out = new PrintWriter(new FileWriter(writePath))){
        int counter = 1;
        String line = in.readLine();
        while (line != null){
            if (counter % 3 == 0){
                out.println(line);
            }
            counter++;
            line = in.readLine();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
