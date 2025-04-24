package com.example;

import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.List;

@Singleton
public class Library {
	private final BookRepository bookRepository;

	public Library(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}
}