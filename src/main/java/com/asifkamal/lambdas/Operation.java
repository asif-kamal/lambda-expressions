package com.asifkamal.lambdas;

@FunctionalInterface
public interface Operation<T> {
    T operate(T first, T second);

}
