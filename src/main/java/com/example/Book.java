package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Book (String name, String author) {

}