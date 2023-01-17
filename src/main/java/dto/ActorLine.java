package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class ActorLine {
    private String name;
    private String movie;
    private int year;
    private LocalDate birthDate;
    private int ageMovie;
    private int ageNow;

    public ActorLine() {

    }

    public ActorLine(String name, String movie, int year, LocalDate birthDate, int ageMovie, int ageNow) {
        this.name = name;
        this.movie = movie;
        this.year = year;
        this.birthDate = birthDate;
        this.ageMovie = ageMovie;
        this.ageNow = ageNow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAgeMovie() {
        return ageMovie;
    }

    public void setAgeMovie(int ageMovie) {
        this.ageMovie = ageMovie;
    }

    public int getAgeNow() {
        return ageNow;
    }

    public void setAgeNow(int ageNow) {
        this.ageNow = ageNow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorLine actorLine = (ActorLine) o;
        return year == actorLine.year && ageMovie == actorLine.ageMovie && ageNow == actorLine.ageNow && Objects.equals(name, actorLine.name) && Objects.equals(movie, actorLine.movie) && Objects.equals(birthDate, actorLine.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movie, year, birthDate, ageMovie, ageNow);
    }

    @Override
    public String toString() {
        return "ActorLine{" +
                "name='" + name + '\'' +
                ", movie='" + movie + '\'' +
                ", year=" + year +
                ", birthDate=" + birthDate +
                ", ageMovie=" + ageMovie +
                ", ageNow=" + ageNow +
                '}';
    }

    public String toCsv() {
        return name + ',' + movie + ',' + year + ',' + birthDate + ',' + ageMovie + ',' + ageNow;
    }
}
