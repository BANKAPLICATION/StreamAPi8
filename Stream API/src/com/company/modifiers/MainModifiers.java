package com.company.modifiers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainModifiers {
    public static void main(String[] args) {
        //Stream-ы могут иметь различные модификаторы состояния, мы рассмотрим следующие : distinct, sorted, parallel, sequential
        List<String> strings = Arrays.asList("a", "b", "c", "d", "a", "b");
        //unique
        strings.stream().distinct().forEach(System.out::println);


        //Если мы хотим получить сортированный Stream, мы можем использовать метод sorted().
        //Stream имеет два метода sorted(), один без параметров (подразумевает что класс реализует Comparable) второй принимает Comparator

        List<Person> people = Arrays.asList(new Person("Jo"),
                new Person("Zai"),
                new Person("Lui"));
        people.stream().sorted(Comparator.comparing(Person::getName).reversed()).forEach(System.out::println);

        //parallel
        people.stream()
                .parallel()
                .forEach(System.out::println);
        //Sequential stream это самый обычный (последовательный) Stream, метод sequential() был введен для того, чтобы из parallel можно было обратно получить sequential Stream.

        people.parallelStream()
                .sequential()
                .forEach(System.out::println); //output Jo Zai Lui Andy


    }
}
class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' + '}';
    }
}