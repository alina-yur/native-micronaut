package com.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;


@Serdeable
@MappedEntity
public record Book(
        @Id @GeneratedValue Long id,

        @NotBlank String name,

        @NotBlank String author) {

    public Book(String name, String author) {
        this(null, name, author);
    }
}