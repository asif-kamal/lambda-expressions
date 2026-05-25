package com.asifkamal.lambdas;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.function.Consumer;

public class MiniChallenge {

    static Consumer<String> printTheParts = s ->
        Arrays.stream(s.split(" ")).forEach(System.out::println);

    public static void main(String[] args) {
        printTheParts.accept("This is a mini challenge");

    }

}
