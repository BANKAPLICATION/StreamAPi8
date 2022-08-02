package com.company.LimitSkip;

import java.util.Arrays;
import java.util.List;

public class MainLimitSkip {
    public static void main(String[] args) {
        //Метод limit() оставляет только первые n элементов из Stream-a, где n - заданный параметр.
        // Т.е. если у нас есть Stream из 10 элементов и мы вызвали limit(5), то в Stream останутся первые 5 элементов
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().limit(5).forEach(System.out::println);


        //Если в limit() указать значение больше чем размер Stream-a,то Stream останется без изменений
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        numbers2.stream().limit(10).forEach(System.out::println);

        //Если указать отрицательное значение в limit() то мы получим IllegalArgumentException


//        numbers2.stream().limit(-1).forEach(System.out::println);


        //Stream skip
        //Метод skip() пропускает первые n элементов Stream-a, где n - заданный параметр .
        // Т.е. если у нас есть Stream из 10 элементов и мы вызвали skip(5), то в Stream останутся вторые 5 элементов

        numbers.stream().skip(5).forEach(System.out::println);


        //Если в skip() указать значение больше, чем размер Stream-a, то мы получим пустой Stream

        //Если указать отрицательное значение в skip(), то мы получим IllegalArgumentException
    }
}
