package com.asifkamal.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("----------------");
        //lambda expression
        list.forEach(s -> System.out.println(s));
        System.out.println("---------------");

        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });

        //method reference
        System.out.println("---------------");
        list.forEach(System.out::println);

        int result = calculator((a, b) -> a + b, 5, 2);
        int result2 = calculator((a, b) -> a / b, 5, 2);

        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659}
        );

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f lng:%.3f]%n", lat, lng);
        System.out.println("------------------------");

        coords.forEach(s -> processPoint(s[0], s[1], p1));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("------------------------");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(System.out::println);


        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
    }

    public static <T> T calculator(BinaryOperator<T> function, T first, T second) {
        T result = function.apply(first, second);
        System.out.println("Result: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
}
