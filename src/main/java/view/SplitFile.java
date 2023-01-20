package view;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class SplitFile {


    public static void main(String[] args) throws IOException {
        String filename = "C:/temp/oscars_actors.csv";
        Path path = Paths.get(filename);
        Path pathSaida = Paths.get("C:/temp/atrizes.txt");


        var lista =
                Files.lines(path)
                .skip(1)
                .peek(s -> System.out.println(s))
                .filter(linha -> linha.contains("Best actress"))
                .collect(Collectors.toList());

        //lista
        var novaLista = Files.readAllLines(path);

        for (String linha : novaLista) {
            if (linha.contains("Best actress")) {
                //salvar numa novalista
            }
        }

        Files.write(pathSaida, lista);



    }

}
