package com.example;

import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class LibraryService {

	private final BookRepository bookRepository;

	public LibraryService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}
