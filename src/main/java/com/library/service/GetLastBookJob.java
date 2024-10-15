package com.library.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GetLastBookJob {
    BookService bookService;

    public GetLastBookJob(BookService service) {
        this.bookService = service;
    }

    @Scheduled(cron = "*/10 * * * * *") // Cron expression for running every minute
    public void execute() {
        System.out.println("Last book: " + bookService.getLastBook().getTitle());
    }
}
