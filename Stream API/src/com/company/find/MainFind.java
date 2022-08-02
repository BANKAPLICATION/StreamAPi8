package com.company.find;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainFind {
    public static void main(String[] args) {
        //        Stream findAny
        //        Метод findAny() возвращает первый попавшийся элемент из Stream-a, в виде обертки Optional.

        List<String> strings = Arrays.asList("BLOB", "Java is the best", "Java 8", "Java 9", "Jacoco");
        Optional<String> java = strings.stream().findAny();
        System.out.println(java.get());//BLOB

        //  Теперь найдем любую строку, в которой есть слово "Java"
        Optional<String> javaa = strings.stream().filter(e -> e.contains("Java")).findAny();
        System.out.println(javaa);

        List<Integer> numbers = Arrays.asList(1, 5, 8, 10, 12, 15);

        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println(first);//output Optional[1]

        //Теперь найдем первое число, больше 10
        Optional<Integer> firstMoreThan10 = numbers.stream().filter(e -> e > 10).findFirst();
        System.out.println(firstMoreThan10);

    }
}
