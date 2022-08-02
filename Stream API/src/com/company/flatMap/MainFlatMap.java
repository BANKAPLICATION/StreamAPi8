package com.company.flatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainFlatMap {
    public static void main(String[] args) {


        //Получим имена питомцев всех людей
        //Before Java 8
        System.out.println("Before java 8");
        List<Human> humans = Arrays.asList(
                new Human("Sam", Arrays.asList("Buddy", "Lucy")),
                new Human("Bob", Arrays.asList("Frankie", "Rosie")),
                new Human("Marta", Arrays.asList("Simba", "Tilly")));

        List<String> petNames = new ArrayList<>();
        for (Human human : humans) {
            petNames.addAll(human.getPets());
        }
        System.out.println(petNames);
        System.out.println("After java 8");
        List<String> petNames2 = humans.stream().map(Human::getPets).flatMap(pets -> pets.stream()).collect(Collectors.toList());
        System.out.println(petNames2);


        //final version
        System.out.println("final version");
        humans.stream().flatMap(e -> e.getPets().stream()).forEach(System.out::println);

        //Stream flatMap() primitive array
        System.out.println("До Java 8\n" +
                "\n");

        int[][] arr = {{1, 2}, {3, 4}, {5, 6}}; // массив 3 на 2

        int[] newArr = new int[arr.length * arr[0].length]; // length = 6

        for (int i = 0, index = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[index++] = arr[i][j];
            }
        }
        System.out.println(Arrays.toString(newArr)); //output [1, 2, 3, 4, 5, 6]

        System.out.println("Сейчас");

        int []newarr2 = Arrays.stream(arr).flatMapToInt(i -> Arrays.stream(i)).toArray();
        System.out.println(Arrays.toString(newarr2));




    }
}
class Human {
    private final String name;
    private final List<String> pets;

    public Human(String name, List<String> pets) {
        this.name = name;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public List<String> getPets() {
        return pets;
    }


}

