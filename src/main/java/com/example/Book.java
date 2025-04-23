package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Book {

    private final String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
