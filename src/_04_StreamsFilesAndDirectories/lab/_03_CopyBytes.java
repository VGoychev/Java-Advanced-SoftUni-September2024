package _04_StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class _03_CopyBytes {
    public static void main(String[] args) {
        String readPath = "/Users/macbookpro/Desktop/resources/input.txt";
        String writePath = "/Users/macbookpro/Desktop/resources/03.CopyBytesOutput.txt";

        try (InputStream in = new FileInputStream(readPath);
             OutputStream out = new FileOutputStream(writePath)){
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0){
                if (oneByte == 10 || oneByte == 32){
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
