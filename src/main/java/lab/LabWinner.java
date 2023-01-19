package lab;

import basic.Util;
import dto.Actor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LabWinner {

    private static final String FILENAME_ACTOR = "oscar_age_male.csv";
    private static final String FILENAME_ACTRESS = "oscar_age_female.csv";

    public static void main(String[] args) throws IOException, URISyntaxException {

        List<Actor> actressList = LabService.readFile(Util.getPathFromResourcesFolder(FILENAME_ACTRESS));

        List<Actor> actorsList = LabService.readFile(Util.getPathFromResourcesFolder(FILENAME_ACTOR));

        System.out.println("Ator mais jovem: " + youngestActor(actorsList));

        System.out.println("Atriz mais jovem: " + youngestActor(actressList));

        System.out.println("Atriz mais premiada: " + mostAwardedActor(actressList));

        System.out.println("Atriz entre 20 e 30 anos que mais vezes foi vencedora: " + mostAwardedBetweenAges(actressList, 20, 30));

        System.out.println("Atores e atrizes que receberam mais de um Oscar: " + actorsWithMoreThanOneOscar(actressList, actorsList));

        System.out.println("Resumo de Katharine Hepburn: ");

        printSummary("Katharine Hepburn", actressList, actorsList);

    }

    private static void printSummary(String name, List<Actor> listaAtrizes, List<Actor> listaAtores) {
        List<Actor> actors = joinLists(listaAtrizes, listaAtores);

        List<Actor> filteredLines =
                actors.stream()
                        .filter(actor -> actor.getName().equals(name))
                        .collect(Collectors.toList());

        System.out.println("Ator/atriz: " + name);

        filteredLines
                .forEach(actor -> System.out.println("\t\t" + actor.getYear() + " - " + actor.getAge() + " anos em " + actor.getMovie()));

        System.out.println("Total premios: " + filteredLines.size());
    }

    private static List<String> actorsWithMoreThanOneOscar(List<Actor> actressList, List<Actor> actorList) {
        List<Actor> actors = joinLists(actressList, actorList);
        return
                actors.stream()
                        .collect(groupingBy(Actor::getName, counting()))
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
    }

    private static List<Actor> joinLists(List<Actor> actressList, List<Actor> actorList) {
        return Stream
                .concat(actressList.stream(), actorList.stream())
                .collect(Collectors.toList());
    }

    private static String mostAwardedBetweenAges(List<Actor> actorList, int minAge, int maxAge) {
        List<Actor> filtered =
                actorList.stream()
                        .filter(actor -> actor.getAge() >= minAge && actor.getAge() <= maxAge)
                        .collect(Collectors.toList());
        return mostAwardedActor(filtered);
    }

    private static String mostAwardedActor(List<Actor> actorList) {
        var actorsGroupedByAwards =
                actorList.stream()
                        .collect(groupingBy(Actor::getName, counting()))
                        .entrySet();

        var actor =
                actorsGroupedByAwards
                        .stream()
                        .max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                        .orElseThrow(() -> new RuntimeException("Actor not found"));

        return actor.getKey();
    }

    private static Actor youngestActor(List<Actor> actorsList) {
        return actorsList
                .stream()
                .min(Comparator.comparingInt(Actor::getAge))
                .orElse(null);
    }
}