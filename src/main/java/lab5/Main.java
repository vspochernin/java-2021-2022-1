package lab5;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------------------Задание 1---------------------------------------");
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        System.out.println(Methods.task1(list1));
        System.out.println("--------------------------------------------------------------------");

        System.out.println("--------------------Задание 2---------------------------------------");
        List<String> list2 = List.of("hello", "world", "ABC");
        list2 = Methods.task2(list2);
        System.out.println(list2);
        System.out.println("--------------------------------------------------------------------");

        System.out.println("--------------------Задание 3---------------------------------------");
        List<Integer> list3 = List.of(1, 1, 2, 3, 2, 4, 4);
        System.out.println(Methods.task3(list3));
        System.out.println("--------------------------------------------------------------------");

        System.out.println("--------------------Задание 4---------------------------------------");
        List<String> list4 = List.of("aHello", "bWorld", "abqwe", "aaqwe");
        System.out.println(Methods.task4(list4, "a"));
        System.out.println("--------------------------------------------------------------------");

        System.out.println("--------------------Задание 5---------------------------------------");
        List<Integer> list5 = List.of(32, 1, 2, 344);
        Set<String> set5 = new TreeSet<>();
        try {
            System.out.println(Methods.task5(list5));
            System.out.println(Methods.task5(set5));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------------------------------------------------------");

        System.out.println("--------------------Задание 6---------------------------------------");
        int[] a6 = {1, 2, 3, 4, 5};
        System.out.println(Methods.task6(a6));
        a6 = new int[]{1, 3, 5};
        System.out.println(Methods.task6(a6));
        System.out.println("--------------------------------------------------------------------");

        System.out.println("--------------------Задание 7---------------------------------------");
        List<String> list7 = List.of("aHello", "bWorld", "cLol", "qError");
        System.out.println(Methods.task7(list7));
        System.out.println("--------------------------------------------------------------------");
    }
}
