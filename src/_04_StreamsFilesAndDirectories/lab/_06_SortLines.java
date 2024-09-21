package _04_StreamsFilesAndDirectories.lab;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _06_SortLines {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/macbookpro/Desktop/resources/input.txt");
        Path out = Paths.get("/Users/macbookpro/Desktop/resources/06.SortLinesOutput.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            lines = lines.stream().filter(l ->
                    !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(out, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
