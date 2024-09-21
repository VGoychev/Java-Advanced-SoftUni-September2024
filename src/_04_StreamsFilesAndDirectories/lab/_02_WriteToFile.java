package _04_StreamsFilesAndDirectories.lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02_WriteToFile {
    public static void main(String[] args) {
        String readPath = "/Users/macbookpro/Desktop/resources/input.txt";
        String writePath = "/Users/macbookpro/Desktop/resources/output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',' , '!' , '?');
        try (InputStream in = new FileInputStream(readPath);
             OutputStream out = new FileOutputStream(writePath)){
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0){
                if (!symbols.contains((char)oneByte)){
                    out.write(oneByte);
                }
            }
        }
        catch (IOException e ){
            e.printStackTrace();
        }
    }
}
