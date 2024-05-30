package com.library.service;

import com.library.repo.model.Book;
import com.library.repo.model.BookRepo;
import com.library.repo.model.BorrowingsRepo;
import org.springframework.stereotype.Service;

@Service
public class BorrowingsService {

    BorrowingsRepo repo;
    BookService bookService;
    ReaderService readerService;

    public BorrowingsService(BorrowingsRepo repo,
                             BookService bookService,
                             ReaderService readerService) {
        this.repo = repo;
        this.bookService = bookService;
        this.readerService = readerService;
    }

    public Book getLatestBorrowedBook(String readerId) {
        return repo.getLastBorrowedBokkByReaderId(readerId);
    }
}
