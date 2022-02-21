package lab5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Methods {

    public static double task1(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    public static List<String> task2(List<String> list) {
        return list.stream()
                .map(str -> str = str.toUpperCase())
                .map(str -> str = "_new_" + str)
                .toList();
    }

    public static List<Integer> task3(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(n -> n * n)
                .toList();
    }

    public static List<String> task4(Collection<String> list, String startLetter) {
        return list.stream()
                .filter(n -> n.startsWith(startLetter))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
    }

    public static <T> T task5(Collection<T> collection) {
        return collection.stream()
                .reduce((a, b) -> b)
                .orElseThrow(() -> new NoSuchElementException("В коллекции нет элементов"));
    }

    public static int task6(int[] a) {
        return Arrays.stream(a)
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Map<Character, String> task7(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1)));
    }
}
