package basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class MethodsWithNIO {

    public static void copyPathAsString(Path input, Path output) throws IOException {
        String string = Files.readString(input);
        System.out.println(string);
        Files.writeString(output, string);
    }

    public static void copyPathAsBytes(Path input, Path output) throws IOException {
        byte[] bytes = Files.readAllBytes(input);
        System.out.println(Arrays.toString(bytes) + " : " + toString(bytes));
        Files.write(output, bytes);
    }

    public static void copyPathAsLines(Path input, Path output) throws IOException {
        List<String> lines = Files.readAllLines(input);
        System.out.println(lines);
        Files.write(output, lines);
    }

    private static String toString(byte[] buffer) {
        var stringBuilder = new StringBuilder();
        for(byte b: buffer) stringBuilder.append((char) b);
        return stringBuilder.toString();
    }
}
