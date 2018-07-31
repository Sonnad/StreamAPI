package sp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class FirstPartTasks {


    private FirstPartTasks() {}

    // Список названий альбомов
    public static List<String> allNames(Stream<Album> albums) {

        return albums.map(Album::getName).collect(Collectors.toList());
    }

    // Список названий альбомов, отсортированный лексикографически по названию
    public static List<String> allNamesSorted(Stream<Album> albums) {

        return albums.map(Album::getName).sorted().collect(Collectors.toList());
    }

    // Список треков, отсортированный лексикографически по названию, включающий все треки альбомов из 'albums'
    public static List<String> allTracksSorted(Stream<Album> albums) {

        return albums.flatMap(x -> x.getTracks().stream()).map(Track::getName).sorted().collect(Collectors.toList());

    }

    // Список альбомов, в которых есть хотя бы один трек с рейтингом более 95, отсортированный по названию
    public static List<Album> sortedFavorites(Stream<Album> s) {
        return s.filter(x -> x.getTracks().stream().anyMatch(y -> y.getRating() > 95)).sorted(Comparator.comparing(Album::getName)).collect(Collectors.toList());
    }

    // Сгруппировать альбомы по артистам
    public static Map<Artist, List<Album>> groupByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getArtist));
    }

    // Число повторяющихся альбомов в потоке
    public static long countAlbumDuplicates(Stream<Album> albums) {
        List<Album> albumList = albums.collect(Collectors.toList());
        return albumList.stream().filter(x -> Collections.frequency(albumList.stream().map(Album::getName).collect(Collectors.toList()), x.getName()) > 1).distinct().count();
    }

    // Альбом, в котором максимум рейтинга минимален
    // (если в альбоме нет ни одного трека, считать, что максимум рейтинга в нем --- 0)
    public static Optional<Album> minMaxRating(Stream<Album> albums) {
        return albums.min(Comparator.comparingInt(x -> x.getTracks().stream().max(Comparator.comparing(Track::getRating)).get().getRating()));
    }
    // Список альбомов, отсортированный по убыванию среднего рейтинга его треков (0, если треков нет)
    public static List<Album> sortByAverageRating(Stream<Album> albums) {
        return albums.sorted(Comparator.comparingDouble(x -> ((Album)x).getTracks().stream().mapToInt(Track::getRating).average().getAsDouble()).reversed()).collect(Collectors.toList());

    }

    // Произведение всех чисел потока по модулю 'modulo'
    // (все числа от 0 до 10000)
    public static int moduloProduction(IntStream stream, int modulo) {
        return stream.reduce((x, y) -> (x*y) % modulo).getAsInt();
    }

    // Вернуть строку, состояющую из конкатенаций переданного массива, и окруженную строками "<", ">"
    // см. тесты
    public static String joinTo(String... strings) {

        return  "<" + Arrays.stream(strings).collect(Collectors.joining(", ")) + ">";

    }

    // Вернуть поток из объектов класса 'clazz'
    public static <R> Stream<R> filterIsInstance(Stream<?> s, Class<R> clazz) {
        return s.filter(x -> clazz.isAssignableFrom(x.getClass())).map(clazz::cast);
    }
}