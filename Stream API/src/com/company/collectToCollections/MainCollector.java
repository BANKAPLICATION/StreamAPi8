package com.company.collectToCollections;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainCollector {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jaime", "Daenerys", "", "Tyrion", "");

        Queue<String> s = names.stream().filter(e -> !e.isEmpty()).collect(Collectors.toCollection(() -> new LinkedList<>()));

        System.out.println(s);


        List<Human> humans = Arrays.asList(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3));

        Map<String, List<Human>> map = humans.stream().collect(Collectors.groupingBy(Human::getSurname));
        map.forEach((k, v) -> System.out.println(k +  "  " + v));



        //Grouping objects by property + count
        Map<String, Long> map2 = humans.stream().collect(Collectors.groupingBy(Human::getSurname, Collectors.counting()));
        map2.forEach((k, v) -> System.out.println(k + " " + v));

        //Grouping objects by property + sum
        Map<String, Integer> map3 = humans.stream().collect(Collectors.groupingBy(Human::getSurname, Collectors.summingInt(Human::getFriendsAmount)));
        map3.forEach((k, v) -> System.out.println(k + " " + v));


        //Grouping + mapping
        Map<String, Set<String>> map4 = humans.stream().collect(Collectors.groupingBy(Human::getSurname, Collectors.mapping(Human::getName, Collectors.toSet())));
        map4.forEach((k, v) -> System.out.println(k + " " + v));

    }
}
class Human {
    private String name;
    private String surname;
    private Integer friendsAmount;

    public Human(String name, String surname, Integer friendsAmount) {
        this.name = name;
        this.surname = surname;
        this.friendsAmount = friendsAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getFriendsAmount() {
        return friendsAmount;
    }

    public void setFriendsAmount(Integer friendsAmount) {
        this.friendsAmount = friendsAmount;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", friendsAmount=" + friendsAmount +
                '}';
    }
}
