package com.library.controller;

import com.library.repo.model.Book;
import com.library.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {


    BookService service;

    public BookController(BookService service) {
        this.service = service;
    }


    @GetMapping("/books")
    public List<Book> getBookByTitle(@RequestParam String title) {
        return List.of(service.getBookByTitle(title));
    }

    @GetMapping("/books/{id}")
    public List<Book> getBookById(@PathVariable long id) {
        return List.of(service.getBookById(id));
    }

    @GetMapping("/books/last")
    public Book getBookById() {
        return service.getLastBook();
    }

    ;
}
