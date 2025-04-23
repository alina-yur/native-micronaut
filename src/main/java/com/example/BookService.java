package com.example;

import jakarta.inject.Singleton;
import java.util.Arrays;
import java.util.List;

@Singleton
public class BookService {

    private static final List<Book> BOOKS = Arrays.asList(
            new Book("TOG"),
            new Book("ACOTAR"));

    public List<Book> getAllBooks() {
        return BOOKS;
    }
}
