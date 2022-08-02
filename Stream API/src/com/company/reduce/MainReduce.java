package com.company.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainReduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Optional<Integer> reduce = numbers.stream().reduce((x1, x2) -> (x1 + x2));
        System.out.println(reduce);

        //А тепер посчитаем сумму начиная с 10
        Integer reduce1 = numbers.stream().reduce((10), (x1, x2) -> (x1 + x2));
        System.out.println(reduce1);

        // 1*10 + 2*10 + 3*10
        Integer sum = numbers.stream()
                        .reduce(10, (identity, val) -> identity * val, (left, right) -> (left + right));
        System.out.println(sum);

        //Search min value
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 5, 7);

        Integer min = numbers2.stream().reduce(Integer.MAX_VALUE, (v1, v2) -> v1 > v2 ? v2: v1);
        System.out.println(min);

        //Search longest string
        //Попробуем найти самую длинную строку

        List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd", "ffff");

        String maxLengthString = strings.stream().reduce("", (v1, v2) -> v1.length() > v2.length() ? v1: v2);
        System.out.println(maxLengthString);



    }
}
