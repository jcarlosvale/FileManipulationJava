package lab;

import dto.ActorLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LabService {
    public static ActorLine toActorLine(final String[] line) {
        final String name = line[3];
        final String movie = line[4];
        final int year = Integer.parseInt(line[1]);

        final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate birthDate = LocalDate.parse(line[7], df);

        final int ageMovie = Integer.parseInt(line[5]);

        final int ageNow = Period
                        .between(LocalDate.now(), birthDate)
                        .getYears();

        return new ActorLine(name, movie, year, birthDate, ageMovie, ageNow);
    }

    public static void saveToFile(List<ActorLine> actorLineList, String filename) throws IOException {
        Path pathToSave = Paths.get("src/main/resources/" + filename);
        Files.deleteIfExists(pathToSave);

        Comparator<ActorLine> comparator =
                Comparator.comparing(ActorLine::getName)
                        .thenComparingInt(ActorLine::getYear);

        var listOfActress =
                actorLineList.stream()
                .sorted(comparator)
                .map(ActorLine::toCsv)
                .collect(Collectors.toList());

        Files.write(pathToSave, listOfActress);
    }
}