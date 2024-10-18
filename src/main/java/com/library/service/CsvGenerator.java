package com.library.service;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class CsvGenerator {
    private static final String filePath = "src\\main\\resources\\reports";
    private static final String[] CSV_HEADER = {"ReaderCount", "BookCount", "Time"};

    public void generateCsv(int readerCount, int bookCount, String time) {

        File file = new File("%s/%s".formatted(filePath,time));
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            writer.writeNext(CSV_HEADER);
            writer.writeNext(new String[]{String.valueOf(readerCount), String.valueOf(bookCount), time});

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
