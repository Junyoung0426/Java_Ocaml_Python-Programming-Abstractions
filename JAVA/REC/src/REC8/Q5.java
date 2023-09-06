package REC8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q5 {
    public static Set<String> getwords(String path) {
        Stream<String> lines;
        try {
            lines = Files.lines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return lines.flatMap(line -> Stream.of(line.split(" ")))
                .collect(Collectors.toSet());
    }
        public static void main(String[] args) {
        String Path = "Q5.1.txt";
        Set<String> words = getwords(Path);
            System.out.println(words);

    }
}
