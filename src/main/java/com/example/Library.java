package com.example;

import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.List;

@Singleton
public class Library {

	private static final List<Book> BOOKS = Arrays.asList(
			new Book("TOG", "Sarah J Mass"),
			new Book("ACOTAR", "Sarah J Mass"));

	public List<Book> getBooks() {

		return BOOKS;
	}
}
