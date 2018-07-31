package sp;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SecondPartTasks {

    private SecondPartTasks() {}

    // Найти строки из переданных файлов, в которых встречается указанная подстрока.
    public static List<String> findQuotes(List<String> paths, CharSequence sequence)  {

        return paths.stream().flatMap(x -> {
            try {
                return Files.lines(Paths.get(x)).filter(y -> y.toLowerCase().contains(sequence.toString().toLowerCase()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } ).collect(Collectors.toList());


    }

    // Дано отображение из имени автора в список с содержанием его произведений.
    // Надо вычислить, чья общая длина произведений наибольшая.
    public static String findPrinter(Map<String, List<String>> compositions) {
        return compositions.entrySet().stream().max(Comparator.comparingInt(x -> x.getValue().stream().reduce((o1, o2) ->  o1 + o2).get().length())).get().getKey();
    }
}