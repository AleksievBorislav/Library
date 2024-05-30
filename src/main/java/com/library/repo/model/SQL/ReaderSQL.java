package com.library.repo.model.SQL;

public class ReaderSQL {

    public static String getReaderById = """
            SELECT * FROM Reader
            WHERE readerid = :readerId;
            """;
}
