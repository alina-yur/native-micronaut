package com.example;

import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class LibraryService {

private final Library library;

	public LibraryService(Library library) {
		this.library = library;
	}

	public List<Book> getAllBooks() {
        return library.getBooks();
    }
}
