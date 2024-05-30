package com.library.repo.model.SQL;

public class BookSQL {
    public static String getBookByTitle = """
            SELECT * FROM Book
            WHERE title = :title;
            """;

    public static String getBookById = """
            SELECT * FROM Book
            WHERE bookId = :bookId;
            """;
}
