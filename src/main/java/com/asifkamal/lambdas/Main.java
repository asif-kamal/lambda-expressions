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
        //method reference
        System.out.println("---------------");
        list.forEach(System.out::println);
    }
}
