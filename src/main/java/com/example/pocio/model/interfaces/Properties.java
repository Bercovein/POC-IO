package com.example.pocio.model.interfaces;

import java.util.Arrays;

public interface Properties {

    default void gerProperties() {
        Arrays.stream(this.getClass().getDeclaredFields()).forEach(System.out::println);
    }
}
