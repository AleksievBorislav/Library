package com.library.controller;

import com.library.repo.model.Book;
import com.library.service.BorrowingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BorrowingsController {


    BorrowingsService service;

    public BorrowingsController(BorrowingsService service) {
        this.service = service;
    }

    @GetMapping("/borrowings")
    public List<Book> getBookByTitle(@RequestParam String readerId){
        return List.of(service.getLatestBorrowedBook(readerId));
    }
}