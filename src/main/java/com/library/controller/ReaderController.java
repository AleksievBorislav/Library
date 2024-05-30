package com.library.controller;
import com.library.repo.model.Reader;
import com.library.service.ReaderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReaderController {

    ReaderService service;
    public ReaderController(ReaderService service){
        this.service = service;
    }

    @GetMapping("/readers/{id}")
    public List<Reader> getReaderById(@PathVariable long id){
        return List.of(service.getReaderById(id));
    }
}
