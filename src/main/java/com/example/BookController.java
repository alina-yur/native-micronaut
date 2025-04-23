package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;

@Controller("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Get(uri = "/", produces = "application/json")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

}