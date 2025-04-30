package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;

@Controller("/books")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Get
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

}