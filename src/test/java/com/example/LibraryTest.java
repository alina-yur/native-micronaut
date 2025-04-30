package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

@MicronautTest
public class LibraryTest {

    @Inject
    private LibraryService libraryService;

    @Test
    void testGetAllBooks() {
        List<Book> books = libraryService.getAllBooks();
        assertNotNull(books);
        assertTrue(books.size() >= 2);

        books.forEach(book -> System.out.println(book));
    }
}