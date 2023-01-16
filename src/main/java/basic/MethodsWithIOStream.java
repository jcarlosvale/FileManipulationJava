package basic;

import java.io.*;
import java.util.Arrays;

public class MethodsWithIOStream {

    public static void copyStream(InputStream in, OutputStream out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            System.out.println(b + " : " + (char)b);
            out.write(b);
        }
    }

    public static void copyStreamIncreaseBytes(InputStream in, OutputStream out) throws IOException {
        int batchSize = 1024;
        var buffer = new byte[batchSize];
        int lengthRead;
        while ((lengthRead = in.read(buffer, 0, batchSize)) > 0) {
            System.out.println(Arrays.toString(buffer) + " : " + toString(buffer));
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
    }

    public static void copyStream(Reader in, Writer out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            System.out.println(b + ":" + (char) b);
            out.write(b);
        }
    }

    public static void copyTextFile(File src, File dest) throws IOException {
        try (var reader = new BufferedReader(new FileReader(src));
             var writer = new BufferedWriter(new FileWriter(dest))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static void copyTextFileWithPrintln(File src, File dest) throws IOException {
        try (var reader = new BufferedReader(new FileReader(src));
             var writer = new PrintWriter(new FileWriter(dest))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.println(line);

            }
        }
    }

    private static String toString(byte[] buffer) {
        var stringBuilder = new StringBuilder();
        for(byte b: buffer) stringBuilder.append((char) b);
        return stringBuilder.toString();
    }
}
