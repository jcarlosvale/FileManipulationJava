package view;

import basic.MethodsWithIOStream;
import basic.MethodsWithNIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MethodsWithNIOView {

    public static void main(String[] args) throws IOException {

        var inputPath = Paths.get("C:/temp/info.txt");
        var outputPath = Paths.get("C:/temp/info-copy.txt");

        System.out.println("\n**************");
        System.out.println("Copy As String");
        System.out.println("**************");

        MethodsWithNIO.copyPathAsString(inputPath, outputPath);

        Files.deleteIfExists(outputPath);

        System.out.println("\n**************");
        System.out.println("Copy As Bytes");
        System.out.println("**************");

        MethodsWithNIO.copyPathAsBytes(inputPath, outputPath);

        Files.deleteIfExists(outputPath);

        System.out.println("\n**************");
        System.out.println("Copy As Lines");
        System.out.println("**************");

        MethodsWithNIO.copyPathAsLines(inputPath, outputPath);

        Files.deleteIfExists(outputPath);
    }
}
