package _04_StreamsFilesAndDirectories.lab;

import java.io.File;
import java.util.ArrayDeque;

public class _08_NestedFolders {
    public static void main(String[] args) {
        String path = "/Users/macbookpro/Desktop/resources/Files-and-Streams";
        File root = new File(path);

        int count = 0;
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            File file = queue.poll();
            File[] files = file.listFiles();
            System.out.printf("%s%n", file.getName());
            count++;
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                }
            }
        }
        System.out.printf("%d folders", count);
    }
}
