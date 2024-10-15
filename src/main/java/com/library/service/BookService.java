package com.library.service;

import com.library.repo.model.Book;
import com.library.repo.model.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepo repo;
    public BookService(BookRepo repo){
        this.repo = repo;
    }

    public Book getBookByTitle(String title){
        return repo.getBookByTitle(title);
    }

    public Book getBookById(long id) {
        return  repo.getBookById(id);
    }

    public Book getLastBook() { return repo.getLastBook(); }
}
