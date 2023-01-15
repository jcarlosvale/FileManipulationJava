package view;

import basic.BasicMethods;

import java.io.IOException;

public class FileView {

    public static void main(String[] args) throws IOException {
        System.out.println("**********************");
        System.out.println("Directory");
        System.out.print("**********************");
        BasicMethods.fileAndDirectoryInfo("C:/temp");

        System.out.println("\n**********************");
        System.out.println("File");
        System.out.print("**********************");
        BasicMethods.fileAndDirectoryInfo("C:/temp/info.txt");

        System.out.println("\n**********************");
        System.out.println("Directory - Relative Path");
        System.out.print("**********************");
        BasicMethods.fileAndDirectoryInfo("/temp");

        System.out.println("\n**********************");
        System.out.println("Relative Path");
        System.out.print("**********************");
        BasicMethods.fileAndDirectoryInfo(".");

        System.out.println("\n**********************");
        System.out.println("Relative Path 2");
        System.out.print("**********************");
        BasicMethods.fileAndDirectoryInfo("..\\");

        System.out.println("\n**********************");
        System.out.println("Directory not exists");
        System.out.print("**********************");
        BasicMethods.fileAndDirectoryInfo("C:/some-directory");

        System.out.println("\n**********************");
        System.out.println("File not exists");
        System.out.print("**********************");
        BasicMethods.fileAndDirectoryInfo("C:/temp/some-file.txt");
    }


}
