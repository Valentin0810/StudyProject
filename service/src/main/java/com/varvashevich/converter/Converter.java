package com.varvashevich.converter;

@FunctionalInterface
public interface Converter<T, R> {

    R convert(T object);
}