package view;

import basic.BasicMethods;
import basic.MethodsWithIOStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MethodsWithIOStreamView {

    public static void main(String[] args) throws IOException {

        var inputPath = "C:/temp/info.txt";
        var outputPath = "C:/temp/info-copy.txt";
        var pathFileToDelete = Paths.get(outputPath);

        System.out.println("\n**********************************");
        System.out.println("Using InputStream and OutputStream");
        System.out.println("**********************************");
        var input = new FileInputStream(inputPath);
        var output = new FileOutputStream(outputPath);
        MethodsWithIOStream.copyStream(input, output);

        input.close();
        output.close();


        Files.deleteIfExists(pathFileToDelete);

        System.out.println("\n****************************************************");
        System.out.println("Using InputStream and OutputStream With More Bytes");
        System.out.print("****************************************************\n");
        input = new FileInputStream(inputPath);
        output = new FileOutputStream(outputPath);
        MethodsWithIOStream.copyStreamIncreaseBytes(input, output);

        input.close();
        output.close();

        Files.deleteIfExists(pathFileToDelete);

        System.out.println("\n***********************");
        System.out.println("Using Reader and Writer");
        System.out.println("***********************");
        var reader = new FileReader(inputPath);
        var writer = new FileWriter(outputPath);
        MethodsWithIOStream.copyStream(reader, writer);

        reader.close();
        writer.close();

        Files.deleteIfExists(pathFileToDelete);

        System.out.println("\n*******************************");
        System.out.println("Using File to read and to write");
        System.out.println("*******************************");
        var srcFile = new File(inputPath);
        var destFile = new File(outputPath);
        MethodsWithIOStream.copyTextFile(srcFile, destFile);

        Files.deleteIfExists(pathFileToDelete);

        System.out.println("\n****************");
        System.out.println("Using PrintWriter");
        System.out.println("*****************");
        srcFile = new File(inputPath);
        destFile = new File(outputPath);
        MethodsWithIOStream.copyTextFileWithPrintln(srcFile, destFile);

        Files.deleteIfExists(pathFileToDelete);
    }
}
