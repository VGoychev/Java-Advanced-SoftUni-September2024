package _04_StreamsFilesAndDirectories.exercise;

import java.io.File;

public class _08_GetFolderSize {
    public static void main(String[] args) {
        File file = new File("/Users/macbookpro/Desktop/resources1");

        long size = 0;
        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File filer : files){
                    if (!filer.isDirectory()){
                        size += file.length();
                    }
                }
            }
        }
        System.out.println("Folder size: "+ size);
    }
}
