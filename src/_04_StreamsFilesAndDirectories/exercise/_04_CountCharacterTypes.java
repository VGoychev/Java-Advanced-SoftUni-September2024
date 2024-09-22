package _04_StreamsFilesAndDirectories.exercise;

import java.io.*;

public class _04_CountCharacterTypes {
    public static void main(String[] args) {
        String inPath = "/Users/macbookpro/Desktop/resources1/input.txt";
        String outPath = "/Users/macbookpro/Desktop/resources1/output.txt";

        try(BufferedReader in = new BufferedReader(new FileReader(inPath));
            PrintWriter out = new PrintWriter(new FileWriter(outPath))) {
            String line = in.readLine();

            int vowels = 0;
            int otherSymbols = 0;
            int punctuation = 0;

            while (line != null){
                for (char c : line.toCharArray()){
                    c = Character.toLowerCase(c);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o'){
                        vowels++;
                    } else if (c == '!' || c == ',' || c == '.' || c == '?'){
                        punctuation++;
                    } else if (c != ' '){
                        otherSymbols++;
                    }
                }

                line = in.readLine();
            }
            out.println("Vowels: " + vowels);
            out.println("Other symbols: " + otherSymbols);
            out.println("Punctuation: " + punctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
