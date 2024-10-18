package com.library.service;

import com.library.config.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DailyCountReportJob {
    BookService bookService;
    ReaderService readerService;
    CsvGenerator csvGenerator;

    public DailyCountReportJob(BookService service, ReaderService readerService, CsvGenerator csvGenerator) {
        this.bookService = service;
        this.readerService = readerService;
        this.csvGenerator = csvGenerator;
    }

    @Scheduled(cron = "*/11 * * * * *")
    public void execute() {
        csvGenerator.generateCsv(readerService.getReaderCount(),
                bookService.getBooKCount(),
                LocalDate.now().toString());
        Logger.LOGGER.info("Daily report generated!");
    }
}
