package com.company.map;

import java.util.Arrays;
import java.util.List;

public class MainMap {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3 , 5, 7);
        numbers.stream().map(i -> i * 2).forEach(System.out::println);
        List<String> names = Arrays.asList("john", "arya", "sansa");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        //Assume that, We need to print the number of cars
        //Before Java 8

        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AM1111BE", 2009),
                new Car("AK5555IT", 2010),
                new Car("AI5601CC", 2015),
                new Car("AI3838PP", 2017));

        System.out.println("Before Java 8");
        for (Car car : cars) {
            System.out.println(car.getNumber());
        }
        //After java 8
        System.out.println("After java 8");
        cars.stream().map(Car::getNumber).forEach(System.out::println);

    }
}
class Car {
    private String number;
    private Integer age;

    public Car(String number, Integer age) {
        this.number = number;
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", age=" + age +
                '}';
    }
}
