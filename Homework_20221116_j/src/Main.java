import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Создать класс Film и полями: название, жанр, рейтинг, год;
        Создать список фильмов. Программа должна спрашивать, какая
        сортировка нужна пользователю (по названию, по рейтингу, по
        жанру или году) и выводить отсортированный список на экран.
         */

        List<Film> films = new ArrayList<>();
        films.add(new Film("Django freeman", "thriller      ", 8.5, 2011));
        films.add(new Film("Begining      ", "action        ", 9.0, 2018));
        films.add(new Film("Avatar        ", "fantasy       ", 9.5, 2005));
        films.add(new Film("Catwomen      ", "action,fantasy", 6.5, 2007));
//        Collections.sort(films);
//        System.out.println(films);

        System.out.println("How to sort the list of movies: by title, by rating, by genre, by year?");

        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();
        switch (result) {
            case "title":
                Collections.sort(films, new CompareFilmByTitle());
                System.out.println(films);
                break;
            case "rating":
                Collections.sort(films, new CompareFilmByRating());
                System.out.println(films);
                break;
            case "genre":
                Collections.sort(films, new CompareFilmByGenre());
                System.out.println(films);
                break;
            case "year":
                Collections.sort(films, new CompereFilmByYearsOfRelease());
                System.out.println(films);
                break;
        }
        scanner.close();
    }
}