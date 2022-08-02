package com.company.match;

import java.util.Arrays;
import java.util.List;

public class MainMatch {
    public static void main(String[] args) {
        //Метод anyMatch() вернет true в том случае, если в Stream-e есть хоть один элемент, что удовлетворяет условию
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean match = numbers.stream().anyMatch(e -> e % 2 == 0);
        System.out.println(match); //true


        //Метод allMatch() вернет true в том случае, если в Stream-e все элементы удовлетворяют условию

        boolean matcher = numbers.stream().allMatch(e -> e % 2 == 0);
        System.out.println(matcher);//false

        // Метод noneMatch() вернет true в том случае, если в Stream-e все элементы НЕ удовлетворяют условию

        boolean matches = numbers.stream().noneMatch(e -> e < 0);
        System.out.println(matches);//true

    }
}

