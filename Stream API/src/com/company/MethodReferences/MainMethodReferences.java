package com.company.MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MainMethodReferences {
    public static void main(String[] args) {

        //before
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(number -> System.out.println(number));
        //after
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        numbers2.forEach(System.out::println);


        System.out.println("Before");
        Function<String, Integer> toInteger = string -> parse(string);
        Integer integer = toInteger.apply("5");
        System.out.println("After");
        Function<String, Integer> toInteger2 = MainMethodReferences::parse;
        Integer integer2 = toInteger.apply("2");
        System.out.println(integer2);


        UserFactory userFactory = User::new;
        User user = userFactory.create("Syrym", "Khakimzhan");

        List<User> users = new ArrayList<>();

        users.add(new User("Nick", "Boll"));
        users.add(new User("Jan", "Nicky"));
        users.add(new User("Bot", "Smart"));
        System.out.println("Before");
        users.forEach(System.out::println);
        users.sort(Comparator.comparing(User::getName));
        System.out.println("After");
        users.forEach(System.out::println);

    }
    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
interface UserFactory {
    User create(String name, String surname);
}
class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
