package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

@MicronautTest
public class LibraryTest {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private LibraryService libraryService;

    @BeforeEach
    void setup() {
        // Clear any existing data
        bookRepository.deleteAll();

        // Add some test books
        bookRepository.save(new Book("Test Book 1", "Test Author 1"));
        bookRepository.save(new Book("Test Book 2", "Test Author 2"));
    }

    @Test
    void testGetAllBooks() {
        // When
        List<Book> books = libraryService.getAllBooks();

        // Then
        assertNotNull(books);
        assertEquals(2, books.size());
    }
}