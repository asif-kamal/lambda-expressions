package com.asifkamal.lambdas;

import java.util.ArrayList;
import java.util.List;

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
    }

    public static <T> T calculator(Operation<T> function, T first, T second) {
        T result = function.operate(first, second);
        System.out.println("Result: " + result);
        return result;
    }
}
