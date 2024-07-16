package com.library.controller;

import com.library.repo.model.Book;
import com.library.repo.model.Borrowings;
import com.library.service.BorrowingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BorrowingsController {


    BorrowingsService service;

    public BorrowingsController(BorrowingsService service) {
        this.service = service;
    }

    @GetMapping("/borrowings/latest")
    public Book getLatestBorrowedBook(@RequestParam Long readerId){
        return service.getLatestBorrowedBook(readerId);
    }

    @GetMapping("/borrowings")
    public List<Borrowings> getAllBorrowedBook(@RequestParam Long readerId){
        return service.getAllBorrowings(readerId);
    }

    @PostMapping("/borrowings/borrow")
    public void borrow(@RequestParam Long readerId,
                       Long bookId){
        service.borrow(readerId, bookId);
    }
}