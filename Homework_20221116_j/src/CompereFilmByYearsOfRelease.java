import java.util.Comparator;

public class CompereFilmByYearsOfRelease implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        return o1.getReleaseYear() - o2.getReleaseYear();
    }
}
