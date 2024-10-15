package com.library.service;

import com.library.repo.model.Book;
import com.library.repo.model.Borrowings;
import com.library.repo.model.BorrowingsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Book getLatestBorrowedBook(Long readerId) {
        return repo.getLastBorrowedBookByReaderId(readerId);
    }

    public void borrow(Long readerId, Long bookId) {
        repo.borrow(readerId, bookId);
    }

    public List<Borrowings> getAllBorrowings(Long readerId) {
        return repo.getAllBorrowings(readerId);
    }
}
