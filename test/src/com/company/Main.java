package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Product product = new Product("asd", 12);
        product.getClass().name


        List<Product> products = new ArrayList<>();
        products.add(new Product("zxc", 1222));
        products.add(new Product("qwe", 1555));

        List<Product> products1 = products.stream()
                .filter(e -> e.getName().equals("qwe"))
                .map(e -> {
                    e.setPrice(0);
                    return e;
                })
                .collect(Collectors.toList());

        System.out.println(products1.toString());

    }
}
