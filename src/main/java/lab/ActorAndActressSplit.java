package lab;

import basic.Util;
import dto.ActorLine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ActorAndActressSplit {

    private static final String FILENAME = "oscars_actors.csv";
    private static final String FILENAME_ACTOR = "atores.csv";
    private static final String FILENAME_ACTRESS = "atrizes.csv";

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path filePath = Util.getPathFromResourcesFolder(FILENAME);

        try (var fileStream = Files.lines(filePath)) {
            var actress =
                    fileStream
                            .skip(1)
                            .peek(System.out::println)
                            .map(s -> s.split(","))
                            .filter(elements -> elements[2].contains("actress"))
                            .map(LabService::toActorLine)
                            .collect(Collectors.toList());

            LabService.saveToFile(actress, FILENAME_ACTRESS);
        }

        try (var fileStream = Files.lines(filePath)) {
            var actors =
                    fileStream
                            .skip(1)
                            .peek(System.out::println)
                            .map(s -> s.split(","))
                            .filter(elements -> elements[2].contains("actor"))
                            .map(LabService::toActorLine)
                            .collect(Collectors.toList());

            LabService.saveToFile(actors, FILENAME_ACTOR);
        }
    }
}
