package com.asifkamal.lambdas;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MiniChallenge {

    static Consumer<String> printTheParts = s ->
        Arrays.stream(s.split(" ")).forEach(System.out::println);

    static UnaryOperator<String> everySecondChar = source -> {
        StringBuilder sb = new StringBuilder();
        for  (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                sb.append(source.charAt(i));
            }
        }
        return sb.toString();

    };

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);

    }

    static Supplier<String> iLoveJava = () -> "I love Java";

    public static void main(String[] args) {
        printTheParts.accept("This is a mini challenge");

        System.out.println(everySecondChar.apply("1234567890"));

        System.out.println(everySecondCharacter(everySecondChar, "1234567890"));

        System.out.println(iLoveJava.get());

    }

}
