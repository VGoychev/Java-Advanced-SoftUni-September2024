package _04_StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String readPath = "/Users/macbookpro/Desktop/resources/input.txt";
        String writePath = "/Users/macbookpro/Desktop/resources/04.ExtractIntegersOutput.txt";
            Scanner scanner = new Scanner(new FileInputStream(readPath));
            PrintWriter out = new PrintWriter(new FileOutputStream(writePath));

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }
                scanner.next();
            }
            out.close();
        }
}
