package com.library.service;

import com.library.repo.model.Reader;
import com.library.repo.model.ReaderRepo;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    ReaderRepo repo;

    public ReaderService(ReaderRepo repo) {
        this.repo = repo;
    }

    public Reader getReaderById(long id) {
        return repo.getReaderById(id);
    }

    public Integer getReaderCount() {
        return repo.getReaderCount();
    }
}
