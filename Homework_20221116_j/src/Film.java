import java.util.Collections;
import java.util.Scanner;

public class Film implements Comparable<Film>{
    private String title;
    private String genre;
    private double rating;
    private int releaseYear;

    public Film(String title, String genre, double rating, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return title + ", genre: " + genre + ", rating: " + rating + ", releaseYear: " + releaseYear + System.lineSeparator();
    }


    @Override
    public int compareTo(Film o) {
        return this.releaseYear - o.releaseYear;
    }
}