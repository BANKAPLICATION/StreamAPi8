package com.company.LambdaComparatorExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainLambda {

    public static void main(String[] args) {
        // write your code here

        // Сортировка с использованием лямбд
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21));

        System.out.println("Before sort:");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("After sort:");
        Collections.sort(users, (u1, u2) -> (u1.getName().compareTo(u2.getName())));
        users.forEach(System.out::println);

        // Сортировка в обратном направлении

        List<User> users2 = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21));

        System.out.println("Before sort: reverse ");
        for (User user : users2) {
            System.out.println(user);
        }
        Comparator<User> comparator = (u1, u2) -> (u1.getName().compareTo(u2.getName()));
        users2.sort(comparator.reversed());
        System.out.println("After sort: reverse");
        users2.forEach(System.out::println);


        //Sorting with age

        Comparator<User> comparator1 = (u1, u2) -> (u1.getAge() - u2.getAge());
        users2.sort(comparator.reversed());


        // 5.3 Сортировка с несколькими условиями // sorting with some conditions
        List<User> users3 = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Alex", 21));

        System.out.println("Sorting with some conditions before: " + users3);

        users3.sort((u1, u2) -> {
            if(u1.getAge() == u2.getAge()) {
                return u1.getName().compareTo(u2.getName());
            }
            else return u1.getAge() - u2.getAge();
        });

        System.out.println("Sorting with some conditions after: " + users3);



    }
}
class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
