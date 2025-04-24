package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
@Introspected
@MappedEntity
public record Book(
		@Id
		@GeneratedValue
		@TypeDef(type = DataType.LONG)
		Long id,

		@NotBlank
		@TypeDef(type = DataType.STRING)
		String name,

		@NotBlank
		@TypeDef(type = DataType.STRING)
		String author
) {
	// Add a constructor without id for creating new books
	public Book(String name, String author) {
		this(null, name, author);
	}
}